
package Model;

public class Session {
     private static Account currentUser;
     
     public static void setCurrentUser(Account a){
          currentUser = a;
     }
     
     public static Account getCurrentUser(){
          return currentUser;
     }
     
     public static int getCurrentTenantId(){
          return TenantDAO.findTenantIdByUsername(currentUser.getUsername());
     }
     
     public static boolean isAdmin(){
          return currentUser!=null && currentUser.isAdmin();
     }
     
     public static boolean isTenant(){
          return currentUser!=null && currentUser.isTenant();
     }
}
