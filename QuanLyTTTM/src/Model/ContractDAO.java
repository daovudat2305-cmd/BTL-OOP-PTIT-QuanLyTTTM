package Model;

import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Controller.AccountController;
import Controller.ProductController;
import Controller.ShopController;
import Controller.TenantController;
import java.math.BigDecimal;

public class ContractDAO {

    // Lấy danh sách Shop ID trống trong phạm vi 1..7
    // (ẩn mọi shop_id đã xuất hiện trong bảng contract)
    public static List<Integer> listFreeShopIds() throws SQLException {
        String sql = """
            SELECT n AS shop_id FROM (
              SELECT 1 n UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL
              SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7
            ) t
            WHERE n NOT IN (SELECT shop_id FROM contract)
            ORDER BY n
        """;
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            List<Integer> list = new ArrayList<>();
            while (rs.next()) list.add(rs.getInt(1));
            return list;
        }
    }

    // Thêm hợp đồng và trả về contract_id sinh ra
    public static int insertReturningId(Contract x) throws SQLException {
        String sql = "INSERT INTO contract(" +
                "tenant_id, shop_id, name, phone, email, shop_name, type, start_date, end_date, income, status" +
                ") VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setLong(1, x.tenantId);
            ps.setInt(2, x.shopId);
            ps.setString(3, x.name);
            ps.setString(4, x.phone);
            ps.setString(5, x.email);
            ps.setString(6, x.shopName);
            ps.setString(7, x.type);
            ps.setDate(8, x.startDate);
            ps.setDate(9, x.endDate);
            ps.setBigDecimal(10, x.income);
            ps.setString(11, x.status);

            if (ps.executeUpdate() != 1) {
                throw new SQLException("Insert failed");
            }
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
            throw new SQLException("No generated key");
        }
    }
    
    // Tải lại 1 hợp đồng theo id (để hiển thị nếu cần)
    public static Contract findById(int id){
        String sql = "SELECT * FROM contract WHERE contract_id=?";
         try (Connection conn = DBConnection.getConnection()){
              PreparedStatement ps = conn.prepareStatement(sql);
              ps.setInt(1, id);
              ResultSet rs = ps.executeQuery();
                if (!rs.next()) return null;
                Contract x = new Contract();
                x.contractId = rs.getInt("contract_id");
                x.tenantId = rs.getLong("tenant_id");
                x.shopId = rs.getInt("shop_id");
                x.name = rs.getString("name");
                x.phone = rs.getString("phone");
                x.email = rs.getString("email");
                x.shopName = rs.getString("shop_name");
                x.type = rs.getString("type");
                x.startDate = rs.getDate("start_date");
                x.endDate = rs.getDate("end_date");
                x.income = rs.getBigDecimal("income");
                x.status = rs.getString("status");
                return x;
         } catch (Exception e) {
              e.printStackTrace();
         }
         return null;
    }
    
    //tìm theo mã khách
    public static Contract findByTenantId(int tenantId){
        String sql = "SELECT * FROM contract WHERE tenant_id=?";
         try (Connection conn = DBConnection.getConnection()){
              PreparedStatement ps = conn.prepareStatement(sql);
              ps.setInt(1, tenantId);
              ResultSet rs = ps.executeQuery();
                if (!rs.next()) return null;
                Contract x = new Contract();
                x.contractId = rs.getInt("contract_id");
                x.tenantId = rs.getLong("tenant_id");
                x.shopId = rs.getInt("shop_id");
                x.name = rs.getString("name");
                x.phone = rs.getString("phone");
                x.email = rs.getString("email");
                x.shopName = rs.getString("shop_name");
                x.type = rs.getString("type");
                x.startDate = rs.getDate("start_date");
                x.endDate = rs.getDate("end_date");
                x.income = rs.getBigDecimal("income");
                x.status = rs.getString("status");
                return x;
         } catch (Exception e) {
              e.printStackTrace();
         }
         return null;
    }
    
    //Hủy hợp đồng
    public static boolean deleteContractById(int contractId){
         String sql = "DELETE FROM contract WHERE contract_id=?";
         try (Connection conn = DBConnection.getConnection()){
              PreparedStatement ps = conn.prepareStatement(sql);
              ps.setInt(1, contractId);
              return ps.executeUpdate() > 0;
         } catch (Exception e) {
              e.printStackTrace();
         }
         return false;
    }
    
    //tự hủy khi đến ngày hết hạn
    public void cancelExpiredContracts(){
         TenantController tenantController = new TenantController();
         ShopController shopController = new ShopController();
         AccountController accountController = new AccountController();
         ProductController productController = new ProductController();
         
          String sql = """
              SELECT contract_id
              FROM contract 
              WHERE end_date < CURDATE() AND status != 'expired'
          """;
          try (Connection conn = DBConnection.getConnection()){
               PreparedStatement ps = conn.prepareStatement(sql);
               ResultSet rs = ps.executeQuery(sql);

               while (rs.next()) {
                   int contractId = rs.getInt("contract_id");
                   Contract c = findById(contractId);
                   
                   int tenantId = (int)c.getTenantId();
                    Tenant t = tenantController.getTenant(tenantId);
                    int shopId = c.getShopId();
                    String username = t.getUsername().trim();

                    //Xóa tenant
                    tenantController.deleteTenant(tenantId);

                    //cập nhật lại shop
                    shopController.updateShopAfterCancel(shopId);

                    //xóa sản phẩm trong shop bị hủy
                    productController.deleteAllProductById(shopId);

                    //xóa account
                    accountController.deleteAccountByUsername(username);

                    //xóa hợp đồng
                    deleteContractById(contractId);
               }
         } catch (Exception e) {
              e.printStackTrace();
         }
      }

    
    //liệt kê danh sách hợp đồng
    public List<Contract> getAllContracts(){
        List<Contract> list = new ArrayList<>();
        String sql = "SELECT * FROM contract";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Contract contract = new Contract();
                contract.setContractId(rs.getInt("contract_id"));
                contract.setTenantId((int)rs.getInt("tenant_id"));
                contract.setShopId(rs.getInt("shop_id"));
                contract.setName(rs.getString("name"));
                contract.setShopName(rs.getString("shop_name"));
                contract.setIncome(rs.getBigDecimal("income"));
                contract.setStatus(rs.getString("status"));
                list.add(contract);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    //cập nhật hợp đồng (tiền thuê)
    public boolean updateIncomeById(int contractId , BigDecimal income){
         String sql = "UPDATE contract SET income=? WHERE contract_id=?";
         try (Connection conn = DBConnection.getConnection()){
              PreparedStatement ps = conn.prepareStatement(sql);
              ps.setBigDecimal(1, income);
              ps.setInt(2, contractId);
              return ps.executeUpdate() > 0;
         } catch (Exception e) {
              e.printStackTrace();
         }
         return false;
    }
    
    //cập nhật trạng thái của hợp đồng (còn hạn, sắp hết hạn)
    public void updateContractStatuses() {
          try (Connection conn = DBConnection.getConnection()){
               // 1. Cập nhật hợp đồng sắp hết hạn (≤ 30 ngày)
               String sql1 = """
                   UPDATE contract
                   SET status = 'terminated'
                   WHERE DATEDIFF(end_date, CURDATE()) BETWEEN 0 AND 30
               """;
               PreparedStatement ps1 = conn.prepareStatement(sql1);
               ps1.executeUpdate();

               // 3. Cập nhật hợp đồng còn hạn (> 30 ngày)
               String sql2 = """
                   UPDATE contract
                   SET status = 'active'
                   WHERE DATEDIFF(end_date, CURDATE()) > 30
                   AND status != 'active'
               """;
               PreparedStatement ps2 = conn.prepareStatement(sql2);
               ps2.executeUpdate();
         } catch (Exception e) {
              e.printStackTrace();
         }

    }

    //gia hạn hợp đồng
    public boolean extendContract(int contractId, java.sql.Date newEndDate){
          try (Connection conn = DBConnection.getConnection()){

               // Gia hạn hợp đồng
               PreparedStatement psUpdate = conn.prepareStatement("""
                   UPDATE contract
                   SET end_date = ?, status = 'active'
                   WHERE contract_id = ?
               """);
               psUpdate.setDate(1, newEndDate);
               psUpdate.setInt(2, contractId);

               int rows = psUpdate.executeUpdate();
               conn.close();
               return rows > 0;
         } catch (Exception e) {
              e.printStackTrace();
         }
          return false;
      }

}
