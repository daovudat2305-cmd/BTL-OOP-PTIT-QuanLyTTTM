
package View;

import Model.Product;
import Controller.ProductController;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class UpdateProductDialog extends javax.swing.JDialog {

     private int shopId;
     private String name;
     
     public UpdateProductDialog(Frame parent, boolean modal) {
          super(parent, modal);
          initComponents();
     }

     public UpdateProductDialog(Frame parent, boolean modal, int shopId, String name) {
        super(parent, modal);
        this.shopId = shopId;
        this.name = name;
        
        initComponents();
        setLocationRelativeTo(parent);
        
    }
     
     
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jLabel1 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          txtPrice = new javax.swing.JTextField();
          txtImage = new javax.swing.JTextField();
          btnChooseImage = new custom.Button();
          lblPreview = new javax.swing.JLabel();
          btnSave = new custom.Button();
          btnCancel = new custom.Button();
          jLabel5 = new javax.swing.JLabel();
          txtDescription = new javax.swing.JTextField();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

          jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
          jLabel1.setText("Thông tin cập nhật");

          jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
          jLabel3.setText("Giá");

          jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
          jLabel4.setText("Ảnh");

          btnChooseImage.setBackground(new java.awt.Color(0, 153, 255));
          btnChooseImage.setForeground(new java.awt.Color(255, 255, 255));
          btnChooseImage.setText("Thêm ảnh");
          btnChooseImage.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
          btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnChooseImageActionPerformed(evt);
               }
          });

          btnSave.setBackground(new java.awt.Color(0, 153, 255));
          btnSave.setForeground(new java.awt.Color(255, 255, 255));
          btnSave.setText("Cập nhật");
          btnSave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
          btnSave.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnSaveActionPerformed(evt);
               }
          });

          btnCancel.setBackground(new java.awt.Color(0, 153, 255));
          btnCancel.setForeground(new java.awt.Color(255, 255, 255));
          btnCancel.setText("Hủy");
          btnCancel.setFocusable(false);
          btnCancel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
          btnCancel.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnCancelActionPerformed(evt);
               }
          });

          jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
          jLabel5.setText("Mô tả");

          txtDescription.setText("Mô tả sản phẩm");

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(55, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                         .addGroup(layout.createSequentialGroup()
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                   .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGap(35, 35, 35)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                  .addComponent(txtPrice)
                                                  .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                             .addComponent(lblPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)
                                        .addComponent(btnChooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                         .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(36, 36, 36))
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(44, 44, 44)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                         .addGroup(layout.createSequentialGroup()
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                   .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                         .addComponent(btnChooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(lblPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                         .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(22, 22, 22))
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImageActionPerformed
          JFileChooser fileChooser = new JFileChooser();
          fileChooser.setDialogTitle("Chọn ảnh sản phẩm");

          // Chỉ cho chọn file ảnh
          fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
              "Hình ảnh", "jpg", "jpeg", "png", "gif"
          ));

          int result = fileChooser.showOpenDialog(this);
          if (result == JFileChooser.APPROVE_OPTION) {
              String filePath = fileChooser.getSelectedFile().getAbsolutePath();
              txtImage.setText(filePath); // gán đường dẫn vào ô nhập
              
              // Hiển thị ảnh thu nhỏ
               ImageIcon icon = new ImageIcon(filePath);
               Image img = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
               lblPreview.setIcon(new ImageIcon(img));
          }
     }//GEN-LAST:event_btnChooseImageActionPerformed

     private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
          try {
            
            if (txtPrice.getText().trim().isEmpty()) {
               JOptionPane.showMessageDialog(this, "Vui lòng nhập giá sản phẩm!");
               return;
            }
            
            try {
               double value = Double.parseDouble(txtPrice.getText().trim());
           } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(this, "Giá sản phẩm không hợp lệ!");
               return;
           }
            
            double price = Double.parseDouble(txtPrice.getText().trim());
            String imagePath = txtImage.getText().trim();
            String description = txtDescription.getText().trim();

            
            ProductController controller = new ProductController();
            controller.updateProductByNameID(shopId, name, price, imagePath, description);

            JOptionPane.showMessageDialog(this, "Đã cập nhật sản phẩm!");

            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi nhập liệu!");
        }
     }//GEN-LAST:event_btnSaveActionPerformed

     private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
          dispose();
     }//GEN-LAST:event_btnCancelActionPerformed

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
               java.util.logging.Logger.getLogger(UpdateProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(UpdateProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(UpdateProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(UpdateProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>
          //</editor-fold>

          /* Create and display the dialog */
          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    UpdateProductDialog dialog = new UpdateProductDialog(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                         @Override
                         public void windowClosing(java.awt.event.WindowEvent e) {
                              System.exit(0);
                         }
                    });
                    dialog.setVisible(true);
               }
          });
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private custom.Button btnCancel;
     private custom.Button btnChooseImage;
     private custom.Button btnSave;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JLabel lblPreview;
     private javax.swing.JTextField txtDescription;
     private javax.swing.JTextField txtImage;
     private javax.swing.JTextField txtPrice;
     // End of variables declaration//GEN-END:variables
}
