package Model;

import java.math.BigDecimal;
import java.sql.Date;

public class Contract {
     public Integer contractId;    // null khi insert
     public long tenantId;
     public int shopId;
     public String shopName;
     public String name, phone, email, type, status;
     public Date startDate, endDate;
     public BigDecimal income;

     //Getter & Setter
     public Integer getContractId() {return contractId;}

     public void setContractId(Integer contractId) {this.contractId = contractId;}

     public long getTenantId() {return tenantId;}

     public void setTenantId(long tenantId) {this.tenantId = tenantId;}

     public int getShopId() {return shopId;}

     public void setShopId(int shopId) {this.shopId = shopId;}

     public String getName() {return name;}

     public void setName(String name) {this.name = name;}

     public String getPhone() {return phone;}

     public void setPhone(String phone) {this.phone = phone;}

     public String getEmail() {return email;}

     public void setEmail(String email) {this.email = email;}

     public String getType() {return type;}

     public void setType(String type) {this.type = type;}

     public String getStatus() {return status;}

     public void setStatus(String status) {this.status = status;}

     public Date getStartDate() {return startDate;}

     public void setStartDate(Date startDate) {this.startDate = startDate;}

     public Date getEndDate() {return endDate;}

     public void setEndDate(Date endDate) {this.endDate = endDate;}

     public BigDecimal getIncome() {return income;}

     public void setIncome(BigDecimal income) {this.income = income;}

     public String getShopName() {return shopName;}

     public void setShopName(String shopName) {this.shopName = shopName;}
    
}
