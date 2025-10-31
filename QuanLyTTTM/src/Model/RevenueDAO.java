package Model;

//Tính toán doanh thu

import util.DBConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RevenueDAO {

     public double getMonthlyRevenue() {
        double total = 0;

        String sql = "SELECT SUM(income) AS total " +
                     "FROM contract " +
                     "WHERE status = 'active' OR status='terminated' " +
                     "AND start_date <= CURDATE() " +
                     "AND end_date >= CURDATE()";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                total = rs.getDouble("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }
     
     //Tính doanh thu 1 tháng trong năm
     public double getMonthlyRevenue(int month, int year){
          double total = 0;

          // Ngày đầu & cuối tháng
          LocalDate startOfMonth = LocalDate.of(year, month, 1);
          LocalDate endOfMonth = startOfMonth.withDayOfMonth(startOfMonth.lengthOfMonth());

          String sql = """
              SELECT SUM(income) AS total
              FROM contract
              WHERE start_date <= ? 
                AND end_date >= ?
                AND (status = 'active' OR status = 'terminated')
              """;

          try (Connection conn = DBConnection.getConnection();
               PreparedStatement ps = conn.prepareStatement(sql)) {

              ps.setDate(1, java.sql.Date.valueOf(endOfMonth));
              ps.setDate(2, java.sql.Date.valueOf(startOfMonth));

              ResultSet rs = ps.executeQuery();
              if (rs.next()) total = rs.getDouble("total");

          } catch (SQLException e) {
              e.printStackTrace();
          }

          return total;
     }
     
     //Lấy danh sách thu tiền thuê từ từng shop
     public List<Object[]> getShopRevenueList(int month, int year){
          List<Object[]> list = new ArrayList<>();

          LocalDate startOfMonth = LocalDate.of(year, month, 1);
          LocalDate endOfMonth = startOfMonth.withDayOfMonth(startOfMonth.lengthOfMonth());

          String sql = """
              SELECT s.name, s.area, c.income
              FROM contract c
              JOIN shop s ON c.shop_id = s.shop_id
              WHERE c.start_date <= ? 
                AND c.end_date >= ?
              """;
          
          try (Connection conn = DBConnection.getConnection()){
               PreparedStatement ps = conn.prepareStatement(sql);
               
               ps.setDate(1, java.sql.Date.valueOf(endOfMonth));
               ps.setDate(2, java.sql.Date.valueOf(startOfMonth));
               
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
                    String shopName = rs.getString("name");
                    String area = rs.getString("area");
                    double income = rs.getDouble("income");
                    list.add(new Object[]{shopName, area, income});
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
          return list;
     }
     
     public Revenue getCurrentRevenue() {
        double revenue = getMonthlyRevenue();
        return new Revenue(revenue);
    }
}
