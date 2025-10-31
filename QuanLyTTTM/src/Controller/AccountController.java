package Controller;

import Model.AccountDAO;

public class AccountController {
    private AccountDAO accountDAO;

    public AccountController() {
        accountDAO = new AccountDAO();
    }

    public boolean login(String username, String password) {
        return accountDAO.checkLogin(username, password);
    }

    public String getFullName(String username) {
        return accountDAO.getFullName(username);
    }
    
    public boolean changePassWord(String username, String newPassWord){
         return accountDAO.changePassWord(username, newPassWord);
    }
    
    public boolean registerTenant(String username, String password, String full_name){
         return accountDAO.registerTenant(username, password, full_name);
    }
    
    public boolean deleteAccountByUsername(String username){
         return accountDAO.deleteAccountByUsername(username);
    }
}
