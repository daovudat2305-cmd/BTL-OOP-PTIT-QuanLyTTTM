package Model;


import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TenantDAO {

    private Tenant mapRow(ResultSet rs) throws SQLException {
        return new Tenant(
                rs.getInt("tenant_id"),
                rs.getString("tenant_name"),
                rs.getString("phone"),
                rs.getString("email")
        );
    }

    // === Query ===
    public List<Tenant> findAll(){
        String sql = "SELECT * FROM tenant ORDER BY tenant_id";
        List<Tenant> list = new ArrayList<>();
         try (Connection conn = DBConnection.getConnection()){
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            while (rs.next()){
                 list.add(mapRow(rs));
            }
            return list;
         } catch (Exception e) {
              e.printStackTrace();
         }
        return null;
    }

    public Tenant findById(int id){
        String sql = "SELECT * FROM tenant WHERE tenant_id=?";
         try (Connection conn = DBConnection.getConnection()){
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setLong(1, id);
               
              ResultSet rs = ps.executeQuery();
              if(rs.next()){
                   Tenant t =  new Tenant(
                        rs.getInt("tenant_id"),
                        rs.getObject("tenant_name") != null ? rs.getString("tenant_name") : null,
                        rs.getObject("phone") != null ? rs.getString("phone") : null,
                        rs.getObject("email") != null ? rs.getString("email") : null
                   );
                   if(rs.getObject("contract_id")!=null){
                        t.setContractId(rs.getInt("contract_id"));
                   }
                   if(rs.getObject("shop_id")!=null){
                        t.setShopId(rs.getInt("shop_id"));
                   }
                   if(rs.getObject("username")!=null){
                        t.setUsername(rs.getString("username"));
                   }
                   if(rs.getObject("password")!=null){
                        t.setPassword(rs.getString("password"));
                   }
                   return t;
              }
              return null;
         } catch (Exception e) {
              e.printStackTrace();
         }
         return null;
    }

    public boolean existsById(int id){
        String sql = "SELECT 1 FROM tenant WHERE tenant_id=? LIMIT 1";
         try (Connection conn = DBConnection.getConnection()){
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
         } catch (Exception e) {
              e.printStackTrace();
         }
         return false;
    }

    public List<Tenant> search(String keyword){
        String sql = """
            SELECT * FROM tenant
            WHERE tenant_id=? OR tenant_name LIKE ? OR email LIKE ? OR phone LIKE ? OR username LIKE ?
            ORDER BY tenant_id
        """;
        List<Tenant> list = new ArrayList<>();
         try (Connection conn = DBConnection.getConnection()){
               PreparedStatement ps = conn.prepareStatement(sql);
               String k = keyword;
               int id = 0;
               try {
                   id = Integer.parseInt(k);
              } catch (Exception e) {
              }
               ps.setInt(1, id);
               ps.setString(2, k);
               ps.setString(3, k);
               ps.setString(4, k);
               ps.setString(5, k);
               ResultSet rs = ps.executeQuery();
               while (rs.next()){
                    list.add(mapRow(rs));
               }
               return list;
         } catch (Exception e) {
              e.printStackTrace();
         }
         return null;
    }
    public int insert(Tenant t){
        if (t.getTenantId() != 0) {
            String sql = "INSERT INTO tenant(tenant_id, tenant_name, phone, email, contract_id, shop_id, username, password) VALUES (?,?,?,?,?,?,?,?)";
             try (Connection conn = DBConnection.getConnection()){
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setLong(1, t.getTenantId());
                    ps.setString(2, t.getTenantName());
                    ps.setString(3, t.getPhone());
                    ps.setString(4, t.getEmail());
                    ps.setInt(5, t.getContractId());
                    ps.setInt(6, t.getShopId());
                    ps.setString(7, t.getUsername());
                    ps.setString(8, t.getPassword());
                    ps.executeUpdate();
                    return t.getTenantId();
             } catch (Exception e) {
                  e.printStackTrace();
             }
             return 0;
        }

        String sql = "INSERT INTO tenant(tenant_name, phone, email, contract_id, shop_id, username, password) VALUES (?,?,?,?,?,?,?)";
         try (Connection conn = DBConnection.getConnection()){
               PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               ps.setString(1, t.getTenantName());
               ps.setString(2, t.getPhone());
               ps.setString(3, t.getEmail());
               ps.setInt(4, t.getContractId());
               ps.setInt(5, t.getShopId());
               ps.setString(6, t.getUsername());
               ps.setString(7, t.getPassword());
               ps.executeUpdate();
               ResultSet rs = ps.getGeneratedKeys();
               return rs.next() ? rs.getInt(1) : null;
         } catch (Exception e) {
              e.printStackTrace();
         }
         return 0;
    }


    public boolean updatePhoneById(int tenantId, String phone){
        String sql = "UPDATE tenant SET phone=? WHERE tenant_id=?";
         try (Connection conn = DBConnection.getConnection()){
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, phone);
               ps.setInt(2, tenantId);
            return ps.executeUpdate() > 0;
         } catch (Exception e) {
              e.printStackTrace();
         }
         return false;
    }
    
    public boolean updateEmailById(int tenantId, String email){
        String sql = "UPDATE tenant SET email=? WHERE tenant_id=?";
         try (Connection conn = DBConnection.getConnection()){
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, email);
               ps.setInt(2, tenantId);
            return ps.executeUpdate() > 0;
         } catch (Exception e) {
              e.printStackTrace();
         }
         return false;
    }
    
    public boolean deleteById(int tenantId){
        String sql = "DELETE FROM tenant WHERE tenant_id=?";
         try (Connection conn = DBConnection.getConnection()){
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setLong(1, tenantId);
               return ps.executeUpdate() > 0;
         } catch (Exception e) {
              e.printStackTrace();
         }
         return false;
    }

    public boolean existsByPhone(String phone){
        String sql = "SELECT 1 FROM tenant WHERE phone = ? LIMIT 1";
         try (Connection conn = DBConnection.getConnection()){
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, phone);
               ResultSet rs = ps.executeQuery();
               return rs.next();
         } catch (Exception e) {
              e.printStackTrace();
         }
         return false;
    }

    public boolean existsByEmail(String email){
        String sql = "SELECT 1 FROM tenant WHERE email = ? LIMIT 1";
         try (Connection conn = DBConnection.getConnection()){
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, email);
               ResultSet rs = ps.executeQuery();
               return rs.next();
         } catch (Exception e) {
              e.printStackTrace();
         }
         return false;
    }
    
    public boolean existsByPassword(String password){
        String sql = "SELECT 1 FROM tenant WHERE password = ? LIMIT 1";
         try (Connection conn = DBConnection.getConnection()){
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, password);
               ResultSet rs = ps.executeQuery();
               return rs.next();
         } catch (Exception e) {
              e.printStackTrace();
         }
         return false;
    }

    
    public static int findTenantIdByUsername(String username){
         String sql = "SELECT tenant_id FROM tenant WHERE username=?";
         try (Connection conn = DBConnection.getConnection()){
              PreparedStatement ps = conn.prepareStatement(sql);
              ps.setString(1, username);
              ResultSet rs = ps.executeQuery();
              if(rs.next()){
                   return rs.getInt("tenant_id");
              }
         } catch (Exception e) {
              e.printStackTrace();
         }
         return 0;
    }
    
    List<Tenant> searchByPhone(String phone) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
