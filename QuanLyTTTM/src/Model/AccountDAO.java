
package Model;

import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {
    
    public boolean checkLogin(String username, String password){
        String sql = "SELECT * FROM account WHERE username=? AND password=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //Lấy full_name
    public String getFullName(String username) {
        String sql = "SELECT full_name FROM account WHERE username=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getString("full_name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //tim account theo username
    public Account findByUserName(String username){
         String sql = "SELECT * FROM account WHERE username=?";
         try (Connection conn = DBConnection.getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql)){
              
              stmt.setString(1, username);
              
              ResultSet rs = stmt.executeQuery();
              if(rs.next()){
                    Account user = new Account(
                         rs.getInt("id"),
                         rs.getString("username"),
                         rs.getString("password"),
                         rs.getString("full_name"),
                         rs.getString("role")
                    );
                    return user;
              }
         } catch (Exception e) {
              e.printStackTrace();
         }
         return null;
    }
    
    
    
    // Thêm tài khoản mới cho khách hàng vừa kí hợp đồng
    public boolean registerTenant(String username, String password, String full_name) {
        String sql = "INSERT INTO account (username, password, full_name, role) VALUES (?, ?, ?, 'TENANT')";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, full_name);

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean changePassWord(String username, String newPassWord){
         String sql = "UPDATE account SET password=? WHERE username=?";
         try (Connection conn = DBConnection.getConnection()){
              PreparedStatement ps = conn.prepareStatement(sql);
              ps.setString(1, newPassWord);
              ps.setString(2, username);
              return ps.executeUpdate() > 0;
         } catch (Exception e) {
              e.printStackTrace();
         }
         return false;
    }
    
    //Xóa tài khoản theo username
    public boolean deleteAccountByUsername(String username){
         String sql = "DELETE FROM account WHERE username=?";
         try (Connection conn = DBConnection.getConnection()){
              PreparedStatement ps = conn.prepareStatement(sql);
              ps.setString(1, username);
              return ps.executeUpdate() > 0;
         } catch (Exception e) {
              e.printStackTrace();
         }
         return false;
    }
}
