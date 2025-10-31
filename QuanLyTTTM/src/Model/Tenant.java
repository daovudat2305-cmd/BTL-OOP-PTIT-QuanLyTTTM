package Model;


public class Tenant {
    private int tenantId;
    private String tenantName;
    private String phone;
    private String email;
    private int shopId;
    private int contractId;
    private String username;
    private String password;

    public Tenant() {}

    public Tenant(int tenantId, String tenantName, String phone, String email) {
        this.tenantId = tenantId;
        this.tenantName = tenantName;
        this.phone = phone;
        this.email = email;
        this.shopId = 0;
        this.contractId = 0;
        this.username = null;
        this.password = null;
    }

    public int getTenantId() { return tenantId; }
    public void setTenantId(int tenantId) { this.tenantId = tenantId; }

    public String getTenantName() { return tenantName; }
    public void setTenantName(String tenantName) { this.tenantName = tenantName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

     public int getShopId() { return shopId; }

     public void setShopId(int shopId) { this.shopId = shopId; }

     public int getContractId() { return contractId; }

     public void setContractId(int contractId) { this.contractId = contractId; }

     public String getUsername() { return username; }

     public void setUsername(String username) { this.username = username; }

     public String getPassword() { return password; }

     public void setPassword(String password) { this.password = password; }

     
     
    @Override public String toString() {
        return "[" + tenantId + "] " + tenantName + " | " +
               (phone == null ? "" : phone) + " | " +
               (email == null ? "" : email);
    }
}
