
package Model;


public class Extend {
     private Integer contractId;
     private String status;
     
     public Extend(){
          
     }
     
     public Extend(Integer contractId, String status){
          this.contractId = contractId;
          this.status = status;
     }

     public Integer getContractId() {
          return contractId;
     }

     public void setContractId(Integer contractId) {
          this.contractId = contractId;
     }

     public String getStatus() {
          return status;
     }

     public void setStatus(String status) {
          this.status = status;
     }
}
