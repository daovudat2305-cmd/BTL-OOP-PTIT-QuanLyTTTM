
package Controller;

import Model.ExtendDAO;
import Model.Extend;
import java.util.*;


public class ExtendController {
     private ExtendDAO extendDAO;
     
     public ExtendController(){
          extendDAO = new ExtendDAO();
     }
     
     public Extend getById(int contractId){
          return extendDAO.getById(contractId);
     }
     
     public boolean setStatusById(int contractId, String status){
          return extendDAO.setStatusById(contractId, status);
     }
     
     public List<Extend> getListRequirements(){
          return extendDAO.getListRequirements();
     }
}
