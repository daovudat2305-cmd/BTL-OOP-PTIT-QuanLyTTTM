import util.DBConnection;
import java.sql.Connection;

import View.LoginView;
import Controller.LoginController;
import Controller.ContractController;

public class App {
    public static void main(String[] args) {
         //Cập nhật trạng thái hợp đồng và hủy hợp đồng đã hết hạn
         ContractController contractController = new ContractController();
         contractController.cancelExpiredContracts();
         contractController.updateContractStatuses();
         
        // Khởi tạo View
        LoginView loginView = new LoginView();

        // Khởi tạo Controller và gắn View + DAO
        LoginController loginController = new LoginController();

        // Hiển thị giao diện Login
        loginView.setVisible(true);
    }
}
