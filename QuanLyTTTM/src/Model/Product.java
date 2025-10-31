
package Model;


public class Product {
     private String name;
     private double price;
     private String imagePath;
     private int shopId;
     private String description;
     
     public Product(){
          
     }
     
     public Product(String name, double price, String imagePath, int shopId, String description){
          this.name = name;
          this.price = price;
          this.imagePath = imagePath;
          this.shopId = shopId;
          this.description = description;
     }
     
     // Getters & Setters
     public String getName() { return name; }
     public void setName(String name) { this.name = name; }

     public double getPrice() { return price; }
     public void setPrice(double price) { this.price = price; }

     public String getImagePath() { return imagePath; }
     public void setImagePath(String imagePath) { this.imagePath = imagePath; }

     public int getShopId() { return shopId; }
     public void setShopId(int shopId) { this.shopId = shopId; }
     
     public String getDescription() { return description; }
     public void setDescription(String description) { this.description = description; }
}
