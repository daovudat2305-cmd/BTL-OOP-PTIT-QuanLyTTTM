
package Controller;

import Model.Contract;
import Model.ContractDAO;
import java.math.BigDecimal;
import java.util.List;

public class ContractController {
     private ContractDAO contractDAO;
     
     public ContractController(){
          contractDAO = new ContractDAO();
     }
     
     public void cancelExpiredContracts(){
          contractDAO.cancelExpiredContracts();
     }
     
     public List<Contract> getAllContracts(){
          return contractDAO.getAllContracts();
     }
     
     public boolean updateIncomeById(int contractId, BigDecimal income){
          return contractDAO.updateIncomeById(contractId, income);
     }
     
     public void updateContractStatuses(){
          contractDAO.updateContractStatuses();
     }
     
     //Gia hạn hợp đồng
     public boolean extendContract(int contractId, java.sql.Date newEndDate) {
          return contractDAO.extendContract(contractId, newEndDate);
      }

}
