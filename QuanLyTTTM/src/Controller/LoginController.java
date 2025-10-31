package Controller;

import Model.Account;
import Model.AccountDAO;

public class LoginController {
    private AccountDAO accountDAO;

    public LoginController() {
        accountDAO = new AccountDAO();
    }

    // Xử lý đăng nhập: trả về true/false
    public boolean login(String username, String password) {
        return accountDAO.checkLogin(username, password);
    }

    // Lấy tên đầy đủ của người dùng (sau khi đăng nhập thành công)
    public String getFullName(String username) {
        return accountDAO.getFullName(username);
    }
    
    public Account getCurrentAccount(String username){
         return accountDAO.findByUserName(username);
    }
}
