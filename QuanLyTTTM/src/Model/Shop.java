package Model;

public class Shop {
    private int shopId;
    private String name;
    private String type;
    private String area;
    private String rentalStatus;   // "Đang thuê" hoặc "Trống"
    private Integer tenantId;      // có thể null
    private Integer contractId;    // có thể null

    // Constructor
    public Shop() {}

    public Shop(int shopId, String name, String type, String area,
                String rentalStatus, Integer tenantId, Integer contractId) {
        this.shopId = shopId;
        this.name = name;
        this.type = type;
        this.area = area;
        this.rentalStatus = rentalStatus;
        this.tenantId = tenantId;
        this.contractId = contractId;
    }

    // Getters và Setters
    public int getShopId() { return shopId; }
    public void setShopId(int shopId) { this.shopId = shopId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getRentalStatus() { return rentalStatus; }
    public void setRentalStatus(String rentalStatus) { this.rentalStatus = rentalStatus; }

    public Integer getTenantId() { return tenantId; }
    public void setTenantId(Integer tenantId) { this.tenantId = tenantId; }

    public Integer getContractId() { return contractId; }
    public void setContractId(Integer contractId) { this.contractId = contractId; }
}
