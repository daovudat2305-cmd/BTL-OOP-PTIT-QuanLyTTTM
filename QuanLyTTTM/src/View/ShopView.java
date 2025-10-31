
package View;

import Controller.LoginController;
import Controller.ShopController;
import Model.Session;
import Model.Shop;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class ShopView extends javax.swing.JFrame {

     private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ShopView.class.getName());
     
     
     private ShopController shopController;
     
     public ShopView(){
          initComponents();
          
          shopController = new ShopController();
          
          setLocationRelativeTo(null);
     }
     
     public void closeWithEffect(JFrame currentFrame, Runnable afterCloseAction) {
          Animator animator = new Animator(1500, new TimingTargetAdapter() {
              @Override
              public void timingEvent(float fraction){
                  background1.setAnimate(fraction);
              }

              @Override
              public void end() {
                  currentFrame.dispose();
                  if (afterCloseAction != null) {
                      afterCloseAction.run();
                  }
              }
          });
          animator.start();
      }

     
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          background1 = new custom.Background();
          jPanel1 = new javax.swing.JPanel();
          jLabel3 = new javax.swing.JLabel();
          jLabel1 = new javax.swing.JLabel();
          txtSearchId = new javax.swing.JTextField();
          btnSearch = new custom.Button();
          jScrollPane1 = new javax.swing.JScrollPane();
          tableShop = new javax.swing.JTable();
          btnViewProduct = new custom.Button();
          btnExit = new custom.Button();
          btnAll = new custom.Button();
          jLabel2 = new javax.swing.JLabel();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setTitle("Shop");
          setResizable(false);
          setSize(new java.awt.Dimension(1050, 650));

          background1.setLayout(new java.awt.CardLayout());

          jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
          jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          jLabel3.setText("QUẢN LÝ SHOP");
          jLabel3.setToolTipText("");
          jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

          jLabel1.setBackground(new java.awt.Color(255, 255, 255));
          jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
          jLabel1.setForeground(new java.awt.Color(51, 51, 51));
          jLabel1.setText("Nhập Shop ID");

          txtSearchId.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

          btnSearch.setBackground(new java.awt.Color(0, 153, 255));
          btnSearch.setForeground(new java.awt.Color(255, 255, 255));
          btnSearch.setText("Tìm Kiếm");
          btnSearch.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
          btnSearch.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnSearchActionPerformed(evt);
               }
          });

          jScrollPane1.setBorder(null);

          tableShop.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
          tableShop.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null}
               },
               new String [] {
                    "Shop ID", "Tên Shop", "Loại Hình", "Khu Vực", "Trạng Thái", "Tenant ID", "Contract ID"
               }
          ) {
               boolean[] canEdit = new boolean [] {
                    false, false, false, false, true, false, false
               };

               public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
               }
          });
          tableShop.setGridColor(new java.awt.Color(153, 153, 153));
          tableShop.setName("tableShop"); // NOI18N
          tableShop.setRowHeight(40);
          tableShop.setShowGrid(true);
          tableShop.getTableHeader().setFont(new java.awt.Font("Time New Roman", java.awt.Font.BOLD, 12));
          jScrollPane1.setViewportView(tableShop);

          btnViewProduct.setBackground(new java.awt.Color(0, 153, 255));
          btnViewProduct.setForeground(new java.awt.Color(255, 255, 255));
          btnViewProduct.setText("Xem Sản Phẩm");
          btnViewProduct.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
          btnViewProduct.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnViewProductActionPerformed(evt);
               }
          });

          btnExit.setBackground(new java.awt.Color(0, 153, 255));
          btnExit.setForeground(new java.awt.Color(255, 255, 255));
          btnExit.setText("Thoát");
          btnExit.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
          btnExit.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnExitActionPerformed(evt);
               }
          });

          btnAll.setBackground(new java.awt.Color(0, 153, 255));
          btnAll.setForeground(new java.awt.Color(255, 255, 255));
          btnAll.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
          btnAll.setLabel("Tất Cả");
          btnAll.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnAllActionPerformed(evt);
               }
          });

          jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/resources/logomini.png"))); // NOI18N

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnViewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(98, 98, 98))
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                         .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                              .addGap(69, 69, 69)
                              .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(18, 18, 18)
                              .addComponent(txtSearchId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(18, 18, 18)
                              .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(18, 18, 18)
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(btnAll, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addGap(44, 44, 44)
                              .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(21, Short.MAX_VALUE))
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addContainerGap()
                              .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(35, 35, 35)
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(btnAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(txtSearchId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addGap(9, 9, 9)
                              .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(48, 48, 48)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(14, 14, 14)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(btnViewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(134, Short.MAX_VALUE))
          );

          background1.add(jPanel1, "card2");

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void btnViewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewProductActionPerformed
          int row = tableShop.getSelectedRow(); // lấy dòng được chọn
          if (row >= 0) {
              Object value = tableShop.getValueAt(row, 0);
               if (value == null) {
                   JOptionPane.showMessageDialog(this, "Hàng này không có dữ liệu!");
                   return;
               }
              int shopId = (int) tableShop.getValueAt(row, 0); // cột 0 = ID
              String status = tableShop.getValueAt(row, 4).toString();
              if(status.equals("Trống")){
                   JOptionPane.showMessageDialog(this, "Shop hiện đang trống!");
              }
              else{
                    closeWithEffect(this, () -> new ProductView(shopId).setVisible(true));
              }
          } else {
              JOptionPane.showMessageDialog(this, "Vui lòng chọn một shop trước khi xem sản phẩm!");
          }
     }//GEN-LAST:event_btnViewProductActionPerformed

     private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
          try {
               int id = Integer.parseInt(txtSearchId.getText());
               Shop s = shopController.getShopById(id);
               DefaultTableModel model = (DefaultTableModel) tableShop.getModel();
               model.setRowCount(0);
               if (s != null) {
                   model.addRow(new Object[]{
                       s.getShopId(), s.getName(), s.getType(), s.getArea(),
                       s.getRentalStatus(), s.getTenantId(), s.getContractId()
                   });
               } else {
                   JOptionPane.showMessageDialog(this, "Không tìm thấy shop!");
               }
           } catch (NumberFormatException ex) {
               JOptionPane.showMessageDialog(this, "Vui lòng nhập ID hợp lệ!");
           }
     }//GEN-LAST:event_btnSearchActionPerformed

     private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
          if(Session.isAdmin()){
               closeWithEffect(this, () -> new MainView_Admin().setVisible(true));
          }
          else{
               closeWithEffect(this, () -> new MainView_Tenant().setVisible(true));
          }
     }//GEN-LAST:event_btnExitActionPerformed

     private void btnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllActionPerformed
          DefaultTableModel model = (DefaultTableModel) tableShop.getModel();
          model.setRowCount(0);
          List<Shop> shops = shopController.getAllShops();
          for(Shop s : shops){
               model.addRow(new Object[]{
                    s.getShopId(), s.getName(), s.getType(), s.getArea(),
                    s.getRentalStatus(), s.getTenantId(), s.getContractId()
               });
          }
     }//GEN-LAST:event_btnAllActionPerformed

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
               java.util.logging.Logger.getLogger(ShopView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(ShopView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(ShopView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(ShopView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          /* Create and display the form */
          SwingUtilities.invokeLater(() -> {
               new ShopView().setVisible(true);
           });
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private custom.Background background1;
     private custom.Button btnAll;
     private custom.Button btnExit;
     private custom.Button btnSearch;
     private custom.Button btnViewProduct;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JTable tableShop;
     private javax.swing.JTextField txtSearchId;
     // End of variables declaration//GEN-END:variables
}
