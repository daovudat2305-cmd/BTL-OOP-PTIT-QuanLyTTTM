
package Controller;

import Model.Product;
import Model.ProductDAO;
import java.util.List;

public class ProductController {
     private ProductDAO productDAO = new ProductDAO();
     
     public List<Product> getProductsByShopId(int shopId){
          return productDAO.getProductsByShopId(shopId);
     }
     
     public List<Product> getProductsByPrice(int shopId, double minPrice, double maxPrice){
          return productDAO.getProductsByPrice(shopId, minPrice, maxPrice);
     }
     
     public boolean addProduct(Product product){
          return productDAO.addProduct(product);
     }
     
     public boolean deleteProduct(int shopId, String name){
          return productDAO.deleteProduct(shopId,name);
     }
     
     public String getDescriptionByNameID(int shopId, String name){
          return productDAO.getDescriptionByNameID(shopId,name);
     }
     
     public boolean updateProductByNameID(int shopId, String name, double price, String imagePath, String description){
          return productDAO.updateProductByNameID(shopId, name, price, imagePath, description);
     }
     
     public boolean deleteAllProductById(int shopId){
          return productDAO.deleteAllProductById(shopId);
     }
     
     public boolean existedProduct(String name, int shopId){
          return productDAO.existedProduct(name, shopId);
     }
}
