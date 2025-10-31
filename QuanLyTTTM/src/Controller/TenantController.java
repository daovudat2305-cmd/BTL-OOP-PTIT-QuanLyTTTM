package Controller;

import Model.Tenant;
import Model.TenantDAO;
import java.util.List;
import java.util.regex.Pattern;

public class TenantController {
    private TenantDAO tenantDAO;

    public TenantController() {
        tenantDAO = new TenantDAO();
    }

    public List<Tenant> getAllTenants() {
        return tenantDAO.findAll();
    }
    
    public boolean deleteTenant(int tenantId) { return tenantDAO.deleteById(tenantId); }

    public Tenant getTenant(int id) { 
         try {
              return tenantDAO.findById(id);
         } catch (Exception e) {
              e.printStackTrace();
         }
         return null;
    }

    public List<Tenant> searchTenant(String keyword) throws Exception { return tenantDAO.search(keyword); }
    
    private void validate(Tenant t) {
        if (t.getTenantName() == null || t.getTenantName().isBlank())
            throw new IllegalArgumentException("Tên tenant không được để trống");

        if (t.getEmail() == null || t.getEmail().isBlank())
            throw new IllegalArgumentException("Email không được để trống");

        String regex = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$";
        if (!Pattern.matches(regex, t.getEmail()))
            throw new IllegalArgumentException("Email không hợp lệ");
    }
    
    public boolean existsById(int id) throws Exception { return tenantDAO.existsById(id); }

    public int createTenant(Tenant t) throws Exception {
        validate(t);

        // chống trùng username (nếu có nhập)
        if (t.getUsername() != null && !t.getUsername().isBlank()) {
            List<Tenant> exists = tenantDAO.search(t.getUsername());
            for (Tenant e : exists) {
                if (e.getUsername() != null &&
                    e.getUsername().equalsIgnoreCase(t.getUsername()))
                    throw new IllegalArgumentException("Username đã tồn tại");
            }
        }
         if (t.getPhone() != null && tenantDAO.existsByPhone(t.getPhone())) {
        throw new IllegalArgumentException("Số điện thoại đã tồn tại");
        }

        // nếu người dùng tự nhập ID → kiểm tra chưa tồn tại
        if (t.getTenantId() != 0 && tenantDAO.existsById(t.getTenantId()))
            throw new IllegalArgumentException("tenant_id đã tồn tại");

        return tenantDAO.insert(t);
    }
    
    
    public boolean updatePhoneById(int tenantId, String phone){
         return tenantDAO.updatePhoneById(tenantId, phone);
    }
    
    public boolean updateEmailById(int tenantId, String email){
         return tenantDAO.updateEmailById(tenantId, email);
    }
    
}
