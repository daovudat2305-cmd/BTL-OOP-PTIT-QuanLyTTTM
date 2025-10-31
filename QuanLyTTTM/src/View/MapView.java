               
package View;

import Model.Session;
import Model.Shop;
import Model.ShopDAO;
import Model.Contract;
import Model.ContractDAO;
import Controller.ContractController;
import Controller.ShopController;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class MapView extends javax.swing.JFrame {

     private ShopController shopController;
     
     public MapView() {
          initComponents();
          
          backgroundPanel1.setBackgroundImage("src/View/resources/map.png");
          
          shopController = new ShopController();
          updateShopColors();
          setLocationRelativeTo(null);
     }

     //màu nút thể hiện trạng thái shop
     private void updateShopColors() {
          
          String status1 = shopController.getStatusByArea("Khu X");
          setButtonColor(btnKhuX, status1, shopController.findShopIdByArea("Khu X"));

          String status2 = shopController.getStatusByArea("Khu A1");
          setButtonColor(btnKhuA1, status2, shopController.findShopIdByArea("Khu A1"));
          
          String status3 = shopController.getStatusByArea("Khu A2");
          setButtonColor(btnKhuA2, status3, shopController.findShopIdByArea("Khu A2"));
          
          String status4 = shopController.getStatusByArea("Khu B1");
          setButtonColor(btnKhuB1, status4, shopController.findShopIdByArea("Khu B1"));
          
          String status5 = shopController.getStatusByArea("Khu B2");
          setButtonColor(btnKhuB2, status5, shopController.findShopIdByArea("Khu B2"));
          
          String status6 = shopController.getStatusByArea("Khu C1");
          setButtonColor(btnKhuC1, status6, shopController.findShopIdByArea("Khu C1"));
          
          String status7 = shopController.getStatusByArea("Khu C2");
          setButtonColor(btnKhuC2, status7, shopController.findShopIdByArea("Khu C2"));
      }
     
     private void setButtonColor(custom.Button btn, String status, int shopId) {
          switch (status) {
               case "Trống":
                    btn.setBackground(new Color(255,182,193));//đỏ nhạt
                    break;
               case "Đang thuê":
                    Shop s = shopController.getShopById(shopId);
                    Contract c = ContractDAO.findById(s.getContractId());
                    if(c.getStatus().equals("active")){
                         btn.setBackground(new Color(204,255,204));//xanh nhạt
                         break;
                    }
                    else if(c.getStatus().equals("terminated")){
                         btn.setBackground(new Color(255,255,153));//vàng nhạt
                         break;
                    }
                    else{
                         btn.setBackground(new Color(255,182,193));//đỏ nhạt
                         break;
                    }
                    
               default:
                    btn.setBackground(Color.white);
          }
      }
     
     
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          backgroundPanel1 = new custom.BackgroundPanel();
          btnExit = new custom.Button();
          btnKhuA1 = new custom.Button();
          btnKhuA2 = new custom.Button();
          btnKhuB1 = new custom.Button();
          btnKhuB2 = new custom.Button();
          btnKhuC2 = new custom.Button();
          btnKhuX = new custom.Button();
          btnKhuC1 = new custom.Button();
          jLabel1 = new javax.swing.JLabel();
          jLabel2 = new javax.swing.JLabel();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

          backgroundPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          btnExit.setBackground(new java.awt.Color(0, 255, 255));
          btnExit.setForeground(new java.awt.Color(102, 102, 102));
          btnExit.setText("Thoát");
          btnExit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
          btnExit.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnExitActionPerformed(evt);
               }
          });
          backgroundPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 72, -1));

          btnKhuA1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.lightGray, java.awt.Color.lightGray));
          btnKhuA1.setText("Khu A1");
          btnKhuA1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
          btnKhuA1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnKhuA1ActionPerformed(evt);
               }
          });
          backgroundPanel1.add(btnKhuA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 84, 72, 120));

          btnKhuA2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.lightGray, java.awt.Color.lightGray));
          btnKhuA2.setText("Khu A2");
          btnKhuA2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
          btnKhuA2.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnKhuA2ActionPerformed(evt);
               }
          });
          backgroundPanel1.add(btnKhuA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 74, 96, 84));

          btnKhuB1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.lightGray, java.awt.Color.lightGray));
          btnKhuB1.setText("Khu B1");
          btnKhuB1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
          btnKhuB1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnKhuB1ActionPerformed(evt);
               }
          });
          backgroundPanel1.add(btnKhuB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 384, 96, 168));

          btnKhuB2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.lightGray, java.awt.Color.lightGray));
          btnKhuB2.setText("Khu B2");
          btnKhuB2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
          btnKhuB2.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnKhuB2ActionPerformed(evt);
               }
          });
          backgroundPanel1.add(btnKhuB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 516, 144, 84));

          btnKhuC2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.lightGray, java.awt.Color.lightGray));
          btnKhuC2.setText("Khu C2");
          btnKhuC2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
          btnKhuC2.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnKhuC2ActionPerformed(evt);
               }
          });
          backgroundPanel1.add(btnKhuC2, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 516, 144, 84));

          btnKhuX.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.lightGray, java.awt.Color.lightGray));
          btnKhuX.setText("Khu X");
          btnKhuX.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
          btnKhuX.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnKhuXActionPerformed(evt);
               }
          });
          backgroundPanel1.add(btnKhuX, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 48, 192, 72));

          btnKhuC1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.lightGray, java.awt.Color.lightGray));
          btnKhuC1.setText("Khu C1");
          btnKhuC1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
          btnKhuC1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnKhuC1ActionPerformed(evt);
               }
          });
          backgroundPanel1.add(btnKhuC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(864, 228, 84, 180));

          jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
          jLabel1.setText("CỔNG VÀO");
          backgroundPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 12, 108, 24));

          jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/resources/logomini.png"))); // NOI18N
          backgroundPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(924, 0, 108, 96));

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(backgroundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addComponent(backgroundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
          if(Session.isAdmin()){
               new MainView_Admin().setVisible(true);
               dispose();
          }
          else{
               new MainView_Tenant().setVisible(true);
               dispose();
          }
     }//GEN-LAST:event_btnExitActionPerformed

     private void btnKhuXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuXActionPerformed
          int shopId = shopController.findShopIdByArea("Khu X");
          if(shopId!=0){
               String status = shopController.getStatusByArea("Khu X");
               if(status.equals("Trống")){
                    JOptionPane.showMessageDialog(this, "Chưa có gian hàng được thuê ở đây!");
               }
               else{
                    new ProductViewMap(shopId).setVisible(true);
                    dispose();
               }
          }
          else{
               JOptionPane.showMessageDialog(this, "Không tìm thấy shop!");
          }
     }//GEN-LAST:event_btnKhuXActionPerformed

     private void btnKhuA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuA1ActionPerformed
          int shopId = shopController.findShopIdByArea("Khu A1");
          if(shopId!=0){
               String status = shopController.getStatusByArea("Khu A1");
               if(status.equals("Trống")){
                    JOptionPane.showMessageDialog(this, "Chưa có gian hàng được thuê ở đây!");
               }
               else{
                    new ProductViewMap(shopId).setVisible(true);
                    dispose();
               }
          }
          else{
               JOptionPane.showMessageDialog(this, "Không tìm thấy shop!");
          }
     }//GEN-LAST:event_btnKhuA1ActionPerformed

     private void btnKhuA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuA2ActionPerformed
          int shopId = shopController.findShopIdByArea("Khu A2");
          if(shopId!=0){
               String status = shopController.getStatusByArea("Khu A2");
               if(status.equals("Trống")){
                    JOptionPane.showMessageDialog(this, "Chưa có gian hàng được thuê ở đây!");
               }
               else{
                    new ProductViewMap(shopId).setVisible(true);
                    dispose();
               }
          }
          else{
               JOptionPane.showMessageDialog(this, "Không tìm thấy shop!");
          }
     }//GEN-LAST:event_btnKhuA2ActionPerformed

     private void btnKhuB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuB1ActionPerformed
          int shopId = shopController.findShopIdByArea("Khu B1");
          if(shopId!=0){
               String status = shopController.getStatusByArea("Khu B1");
               if(status.equals("Trống")){
                    JOptionPane.showMessageDialog(this, "Chưa có gian hàng được thuê ở đây!");
               }
               else{
                    new ProductViewMap(shopId).setVisible(true);
                    dispose();
               }
          }
          else{
               JOptionPane.showMessageDialog(this, "Không tìm thấy shop!");
          }
     }//GEN-LAST:event_btnKhuB1ActionPerformed

     private void btnKhuB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuB2ActionPerformed
          int shopId = shopController.findShopIdByArea("Khu B2");
          if(shopId!=0){
               String status = shopController.getStatusByArea("Khu b2");
               if(status.equals("Trống")){
                    JOptionPane.showMessageDialog(this, "Chưa có gian hàng được thuê ở đây!");
               }
               else{
                    new ProductViewMap(shopId).setVisible(true);
                    dispose();
               }
          }
          else{
               JOptionPane.showMessageDialog(this, "Không tìm thấy shop!");
          }
     }//GEN-LAST:event_btnKhuB2ActionPerformed

     private void btnKhuC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuC1ActionPerformed
          int shopId = shopController.findShopIdByArea("Khu C1");
          if(shopId!=0){
               String status = shopController.getStatusByArea("Khu C1");
               if(status.equals("Trống")){
                    JOptionPane.showMessageDialog(this, "Chưa có gian hàng được thuê ở đây!");
               }
               else{
                    new ProductViewMap(shopId).setVisible(true);
                    dispose();
               }
          }
          else{
               JOptionPane.showMessageDialog(this, "Không tìm thấy shop!");
          }
     }//GEN-LAST:event_btnKhuC1ActionPerformed

     private void btnKhuC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuC2ActionPerformed
          int shopId = shopController.findShopIdByArea("Khu C2");
          if(shopId!=0){
               String status = shopController.getStatusByArea("Khu C2");
               if(status.equals("Trống")){
                    JOptionPane.showMessageDialog(this, "Chưa có gian hàng được thuê ở đây!");
               }
               else{
                    new ProductViewMap(shopId).setVisible(true);
                    dispose();
               }
          }
          else{
               JOptionPane.showMessageDialog(this, "Không tìm thấy shop!");
          }
     }//GEN-LAST:event_btnKhuC2ActionPerformed

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
               java.util.logging.Logger.getLogger(MapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(MapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(MapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(MapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          /* Create and display the form */
          java.awt.EventQueue.invokeLater(() -> new MapView().setVisible(true));
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private custom.BackgroundPanel backgroundPanel1;
     private custom.Button btnExit;
     private custom.Button btnKhuA1;
     private custom.Button btnKhuA2;
     private custom.Button btnKhuB1;
     private custom.Button btnKhuB2;
     private custom.Button btnKhuC1;
     private custom.Button btnKhuC2;
     private custom.Button btnKhuX;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     // End of variables declaration//GEN-END:variables
}
