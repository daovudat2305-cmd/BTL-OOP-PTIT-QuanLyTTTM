package Controller;

import Model.Shop;
import Model.ShopDAO;

import java.util.List;

public class ShopController {
    private ShopDAO shopDAO;

    public ShopController() {
        this.shopDAO = new ShopDAO();
    }

    public List<Shop> getAllShops(){
         return shopDAO.getAllShops();
    }

    public void updateShopById(int id, String name, String type, int tenantId, int contractId){
         shopDAO.updateShopById(id, name, type, tenantId, contractId);
    }
    
    public void updateShopAfterCancel(int shopId){
         shopDAO.updateShopAfterCancel(shopId);
    }
    
    public Shop getShopById(int id){
         return shopDAO.getShopById(id);
    }
    
    public boolean isShopOwnedByTenant(int shopId, int tenantId){
         return shopDAO.isShopOwnedByTenant(shopId, tenantId);
    }
    
    public int findShopIdByArea(String area){
         return shopDAO.findShopIdByArea(area);
    }
    
    public String getStatusByArea(String area){
         return shopDAO.getStatusByArea(area);
    }
}
