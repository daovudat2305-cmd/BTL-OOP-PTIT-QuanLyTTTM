package Model;

public class Account {
    private int id;
    private String username;
    private String password;
    private String fullName;
    private String role; //ADMIN hoặc TENANT;

    public Account() {}

    public Account(int id, String username, String password, String fullName, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }

    
    //kiểm tra vai trò
    public boolean isAdmin(){
         return "ADMIN".equalsIgnoreCase(role);
    }
    
    public boolean isTenant(){
         return "TENANT".equalsIgnoreCase(role);
    }
    
    //getter và setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
}
