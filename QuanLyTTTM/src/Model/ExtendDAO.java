
package Model;

import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class ExtendDAO {
     
     //lấy trạng thái theo id
     public Extend getById(int contractId){
          String sql = "SELECT * FROM extend WHERE contract_id=?";
          try (Connection conn = DBConnection.getConnection()){
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setInt(1, contractId);
               ResultSet rs = ps.executeQuery();
               if(rs.next()){
                    return new Extend(rs.getInt("contract_id"), rs.getString("status"));
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
          return null;
     }
     
     //set trạng thái theo id
     public boolean setStatusById(int contractId, String status){
          String sql = "UPDATE extend SET status=? WHERE contract_id=?";
          try (Connection conn = DBConnection.getConnection()){
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString(1, status);
               ps.setInt(2, contractId);
               
               return ps.executeUpdate() > 0;
          } catch (Exception e) {
               e.printStackTrace();
          }
          return false;
     }
     
     //lấy danh sách yêu cầu
     public List<Extend> getListRequirements(){
          List<Extend> lst = new ArrayList<>();
          String sql = "SELECT * FROM extend WHERE status='yes' ";
          try (Connection conn = DBConnection.getConnection()){
               PreparedStatement ps = conn.prepareStatement(sql);
               
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
                    lst.add(new Extend(rs.getInt("contract_id"), rs.getString("status")));
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
          return lst;
     }
}
