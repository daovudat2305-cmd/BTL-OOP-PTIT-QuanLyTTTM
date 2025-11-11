
package Model;

import java.sql.*;
import java.util.*;
import util.DBConnection;

public class ProductDAO {
     public List<Product> getProductsByShopId(int shopId){
          List<Product> products = new ArrayList<>();
          try(Connection conn = DBConnection.getConnection()) {
               String sql = "SELECT * FROM product WHERE shop_id=?";
               PreparedStatement stmt = conn.prepareStatement(sql);
               stmt.setInt(1, shopId);
               ResultSet rs = stmt.executeQuery();
               while(rs.next()){
                    products.add(new Product(
                         rs.getString("name"),
                         rs.getDouble("price"),
                         rs.getString("image_path"),
                         rs.getInt("shop_id"),
                         rs.getString("description")
                    ));
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
          return products;
     }
     
     //lọc sản phẩm theo giá
     public List<Product> getProductsByPrice(int shopId, double minPrice, double maxPrice){
          List<Product> products = new ArrayList<>();
          try(Connection conn = DBConnection.getConnection()) {
               String sql = "SELECT * FROM product WHERE shop_id=? AND price>=? AND price<=?";
               PreparedStatement stmt = conn.prepareStatement(sql);
               stmt.setInt(1, shopId);
               stmt.setDouble(2, minPrice);
               stmt.setDouble(3, maxPrice);
               ResultSet rs = stmt.executeQuery();
               while(rs.next()){
                    products.add(new Product(
                         rs.getString("name"),
                         rs.getDouble("price"),
                         rs.getString("image_path"),
                         rs.getInt("shop_id"),
                         rs.getString("description")
                    ));
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
          return products;
     }
     
     public boolean addProduct(Product product){
          try(Connection conn = DBConnection.getConnection()) {
               String sql = "INSERT INTO product(name, price, image_path, shop_id, description) VALUES(?,?,?,?,?)";
               PreparedStatement stmt = conn.prepareStatement(sql);
               stmt.setString(1, product.getName());
               stmt.setDouble(2, product.getPrice());
               stmt.setString(3, product.getImagePath());
               stmt.setInt(4, product.getShopId());
               stmt.setString(5, product.getDescription());
               return stmt.executeUpdate() > 0;
          } catch (Exception e) {
               e.printStackTrace();
          }
          return false;
     }
     
     public boolean deleteProduct(int shopId, String name){
          try (Connection conn = DBConnection.getConnection()){
               String sql = "DELETE FROM product WHERE shop_id=? AND name=?";
               PreparedStatement stmt = conn.prepareStatement(sql);
               stmt.setInt(1, shopId);
               stmt.setString(2, name);
               return stmt.executeUpdate() > 0;
          } catch (Exception e) {
               e.printStackTrace();
          }
          return false;
     }
     
     public String getDescriptionByNameID(int shopId, String name){
          try (Connection conn = DBConnection.getConnection()){
               String sql = "SELECT description FROM product WHERE shop_id=? AND name=?";
               PreparedStatement stmt = conn.prepareStatement(sql);
               stmt.setInt(1, shopId);
               stmt.setString(2, name);
               ResultSet rs = stmt.executeQuery();
               if(rs.next()){
                    return rs.getString("description");
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
          return null;
     }
     
     public boolean updateProductByNameID(int shopId, String name, double price, String imagePath, String description){
          try (Connection conn = DBConnection.getConnection()){
               String sql = "UPDATE product SET price=?, image_path=?, description=? WHERE shop_id=? AND name=?";
               PreparedStatement stmt = conn.prepareStatement(sql);
               stmt.setDouble(1, price);
               stmt.setString(2, imagePath);
               stmt.setString(3, description);
               stmt.setInt(4, shopId);
               stmt.setString(5, name);
               return stmt.executeUpdate() > 0;
          } catch (Exception e) {
               e.printStackTrace();
          }
          return false;
     }
     
     public boolean deleteAllProductById(int shopId){
          String sql = "DELETE FROM product WHERE shop_id=?";
          try (Connection conn = DBConnection.getConnection()){
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setInt(1, shopId);
               return ps.executeUpdate() > 0;
          } catch (Exception e) {
               e.printStackTrace();
          }
          return false;
     }
}
