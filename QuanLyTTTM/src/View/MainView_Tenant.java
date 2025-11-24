
package View;

import Controller.ExtendController;
import Controller.TenantController;
import Controller.AccountController;
import Model.Session;
import Model.Contract;
import Model.ContractDAO;
import Model.Tenant;
import javax.swing.*;
import java.awt.*;

public class MainView_Tenant extends javax.swing.JFrame {

     private JPanel contentPanel;
     private JLabel logoLabel;
     
     private TenantController tenantController = new TenantController();
     private ExtendController extendController = new ExtendController();
     
     public MainView_Tenant() {
          initComponents();
          setTitle("Shopping Mall Management System");
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setSize(1050, 650);
          setLocationRelativeTo(null);
          setLayout(new BorderLayout());

          JMenuBar menuBar = new JMenuBar();

          // Main Menu
          JMenu menu = new JMenu("Menu");
          menu.setFont(new Font("Segoe UI", Font.BOLD, 15));   // chỉnh font to hơn
          menu.setPreferredSize(new Dimension(100, 40));       // chỉnh kích thước
          JMenuItem homeItem = new JMenuItem("Trang chủ");
          JMenuItem shopItem = new JMenuItem("Các cửa hàng");
          JMenuItem infoItem = new JMenuItem("Thông tin");
          JMenuItem mapItem = new JMenuItem("Sơ đồ trung tâm");

          homeItem.setFont(new Font("Segoe UI", Font.BOLD, 15));
          shopItem.setFont(new Font("Segoe UI", Font.BOLD, 15));
          infoItem.setFont(new Font("Segoe UI", Font.BOLD, 15)); 
          mapItem.setFont(new Font("Segoe UI", Font.BOLD, 15)); 
          
          menu.add(homeItem);
          menu.add(shopItem);
          menu.add(infoItem);
          menu.add(mapItem);

          
          menuBar.add(menu);

          // ====== Logout Button next to Menu ======
          JButton logoutButton = new JButton("Đăng xuất");
          logoutButton.setFont(new Font("Segoe UI", Font.BOLD, 15)); 
          logoutButton.setPreferredSize(new Dimension(100, 40));
          logoutButton.addActionListener(e -> {
              int confirm = JOptionPane.showConfirmDialog(
                      this,
                      "Bạn có chắc muốn đăng xuất?",
                      "Đăng xuất",
                      JOptionPane.YES_NO_OPTION
              );
              if (confirm == JOptionPane.YES_OPTION) {
                  dispose();
                  JOptionPane.showMessageDialog(null, "Bạn đã đăng xuất!");
                  
                  // Mở lại LoginView
                    SwingUtilities.invokeLater(() -> {
                        new View.LoginView().setVisible(true);
                    });
              }
              
          });
          
          //Nút đổi mật khẩu
          JButton changePassWordButton = new JButton("Đổi mật khẩu");
          changePassWordButton.setFont(new Font("Segoe UI", Font.BOLD, 15)); 
          changePassWordButton.setPreferredSize(new Dimension(100, 40));
          changePassWordButton.addActionListener(e -> {
              new ChangePassWordDialog(this,true).setVisible(true);
          });
          
          
          //Thông báo
          JLabel lblAlert = new JLabel("              Hợp đồng của bạn sắp hết hạn!!!   ");
          lblAlert.setFont(new Font("Segoe UI", Font.BOLD, 15)); 
          lblAlert.setForeground(new Color(244, 67, 54));
          lblAlert.setPreferredSize(new Dimension(100, 40));
          
          //yêu cầu gia hạn hợp đồng
          JButton extendContractButton = new JButton("Yêu cầu gia hạn");
          extendContractButton.setFont(new Font("Segoe UI", Font.BOLD, 15)); 
          extendContractButton.setPreferredSize(new Dimension(100, 40));
          extendContractButton.addActionListener(e -> {
              int confirm = JOptionPane.showConfirmDialog(
                      this,
                      "Bạn có chắc muốn yêu cầu gia hạn hợp đồng?",
                      "Thông báo",
                      JOptionPane.YES_NO_OPTION
              );
              if (confirm == JOptionPane.YES_OPTION) {
                    int tenantId = Session.getCurrentTenantId();
                    Tenant curTenant = tenantController.getTenant(tenantId);
                    
                    if(extendController.setStatusById(curTenant.getContractId(), "yes")){
                         JOptionPane.showMessageDialog(null, "Bạn đã yêu cầu gia hạn!");
                    }
                    else{
                         JOptionPane.showMessageDialog(null, "Yêu cầu thất bại!");
                    }                   
                  
              }
              
          });
          
          menuBar.add(changePassWordButton);
          menuBar.add(logoutButton);
          menuBar.add(lblAlert);
          menuBar.add(extendContractButton);
          

          //hiện thị thông báo nếu sắp hết hạn
          int tenantId = Session.getCurrentTenantId();
          
          Contract contract = ContractDAO.findByTenantId(tenantId);
          if(contract.getStatus().equals("active")){
               lblAlert.setVisible(false);
               extendContractButton.setVisible(false);
          }
          
          setJMenuBar(menuBar);

          // ====== Main Panel ======
          contentPanel = new JPanel(new BorderLayout());
          add(contentPanel, BorderLayout.CENTER);

          // ====== Logo (Home screen) ======
          ImageIcon icon = new ImageIcon(getClass().getResource("/View/resources/home.png"));
          Image img = icon.getImage().getScaledInstance(1050, 650, Image.SCALE_SMOOTH);
          logoLabel = new JLabel(new ImageIcon(img), SwingConstants.CENTER);
          contentPanel.add(logoLabel, BorderLayout.CENTER);

          // ====== Menu Events ======
          homeItem.addActionListener(e -> showHome());
          shopItem.addActionListener(e -> showShop());
          infoItem.addActionListener(e -> showInfo());
          mapItem.addActionListener(e -> showMap());

          setVisible(true);
     }

     
     private void showHome() {
          contentPanel.removeAll();
          contentPanel.add(logoLabel, BorderLayout.CENTER);
          contentPanel.revalidate();
          contentPanel.repaint();
      }

      private void showShop() {
          new ShopView().setVisible(true);
          dispose();
      }


      private void showInfo() {
          new InfoTenantDialog(this,true).setVisible(true);
      }

      private void showMap() {
          new MapView().setVisible(true);
          dispose();
      }
      
     
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jLabel1 = new javax.swing.JLabel();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setIconImages(null);

          jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/resources/logomini.png"))); // NOI18N

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(623, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(325, 325, 325))
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addGap(78, 78, 78)
                    .addComponent(jLabel1)
                    .addContainerGap(457, Short.MAX_VALUE))
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     /**
      * @param args the command line arguments
      */
     public static void main(String args[]) {
          /* Set the Nimbus look and feel */
          //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
          /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
           */
          try {
               for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                         javax.swing.UIManager.setLookAndFeel(info.getClassName());
                         break;
                    }
               }
          } catch (ClassNotFoundException ex) {
               java.util.logging.Logger.getLogger(MainView_Tenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(MainView_Tenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(MainView_Tenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(MainView_Tenant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>
          //</editor-fold>

          /* Create and display the form */
          SwingUtilities.invokeLater(() -> new MainView_Tenant());
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JLabel jLabel1;
     // End of variables declaration//GEN-END:variables
}
