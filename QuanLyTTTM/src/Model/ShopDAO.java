package Model;

import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopDAO {

    

    // Lấy tất cả shop
    public List<Shop> getAllShops(){
        List<Shop> list = new ArrayList<>();
        String sql = "SELECT * FROM Shop";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Shop shop = new Shop(
                    rs.getInt("shop_id"),
                    rs.getObject("name") != null ? rs.getString("name") : null,
                    rs.getObject("type") != null ? rs.getString("type") : null,
                    rs.getString("area"),
                    rs.getString("rental_status"),
                    rs.getObject("tenant_id") != null ? rs.getInt("tenant_id") : null,
                    rs.getObject("contract_id") != null ? rs.getInt("contract_id") : null
                );
                list.add(shop);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

     //kiểm tra shop có thuộc quyền sở hữu của tenantid không
     public boolean isShopOwnedByTenant(int shopId, int tenantId) {
          String sql = "SELECT COUNT(*) FROM shop WHERE shop_id=? AND tenant_id=?";
          try (Connection conn = DBConnection.getConnection();
               PreparedStatement ps = conn.prepareStatement(sql)) {
              ps.setInt(1, shopId);
              ps.setInt(2, tenantId);
              ResultSet rs = ps.executeQuery();
              if (rs.next()) {
                  return rs.getInt(1) > 0;
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return false;
      }

    //Tìm shopId theo khu vực
     public int findShopIdByArea(String area){
          String sql = "SELECT shop_id FROM shop WHERE area=?";
          try (Connection conn = DBConnection.getConnection()){
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, area);
               ResultSet rs = ps.executeQuery();
               if(rs.next()){
                    return rs.getInt("shop_id");
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
          return 0;
     }
     
     //Lấy trạng thái shop theo khu vực
     public String getStatusByArea(String area){
          String sql = "SELECT rental_status FROM shop WHERE area=?";
          try (Connection conn = DBConnection.getConnection()){
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, area);
               ResultSet rs = ps.executeQuery();
               if(rs.next()){
                    return rs.getString("rental_status");
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
          return null;
     }
    
    //Cập nhật shop khi kí hợp đồng(cập nhật theo id)
    public void updateShopById(int shopId, String name, String type, int tenantId, int contractId){
         String sql = "UPDATE shop SET name=?, type=?, rental_status='Đang thuê', tenant_id=?, contract_id=? WHERE shop_id=?";
         try (Connection conn = DBConnection.getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql)){
              stmt.setString(1,name);
              stmt.setString(2,type);
              stmt.setInt(3, tenantId);
              stmt.setInt(4, contractId);
              stmt.setInt(5, shopId);
              stmt.executeUpdate();
         } catch (Exception e) {
              e.printStackTrace();
         }
    }
    
    public void updateShopAfterCancel(int shopId){
         String sql = "UPDATE shop SET name=null, type=null, rental_status='Trống', tenant_id=null, contract_id=null WHERE shop_id=?";
         try (Connection conn = DBConnection.getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql)){
              stmt.setInt(1, shopId);
              stmt.executeUpdate();
         } catch (Exception e) {
              e.printStackTrace();
         }
    }
   
    //Lấy Shop theo id
    public Shop getShopById(int id){
         String sql = "SELECT * FROM Shop WHERE shop_id=?";
         try (Connection conn = DBConnection.getConnection();
              PreparedStatement ps = conn.prepareStatement(sql)){
              
              ps.setInt(1, id);
              ResultSet rs = ps.executeQuery();
              if(rs.next()){
                   return new Shop(
                        rs.getInt("shop_id"),
                        rs.getObject("name") != null ? rs.getString("name") : null,
                        rs.getObject("type") != null ? rs.getString("type") : null,
                        rs.getString("area"),
                        rs.getString("rental_status"),
                        rs.getObject("tenant_id") != null ? rs.getInt("tenant_id") : null,
                        rs.getObject("contract_id") != null ? rs.getInt("contract_id") : null
                   );
              }
              
         } catch (Exception e) {
              e.printStackTrace();
         }
         return null;
    }
    

}
