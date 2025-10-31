
package util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



//Dùng cho MySql workbench
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/malldb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";      
    private static final String PASSWORD = "admin"; 

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Test nhanh
    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("Kết nối MySQL thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
