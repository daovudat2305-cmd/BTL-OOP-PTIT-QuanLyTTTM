
package View;

import Model.Product;
import Model.Session;
import Controller.ShopController;
import Controller.ProductController;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;



public class ProductViewMap extends javax.swing.JFrame {

     private ProductController productController;
     private ShopController shopController;
     public static int shopId;
     
     
     DefaultTableModel model;
     
     public ProductViewMap(){
          
     }

     public ProductViewMap(int shopId){
          initComponents();
     
          // Renderer cho cột ảnh
          tableProduct.getColumnModel().getColumn(2).setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {
              JLabel label = new JLabel();
              label.setHorizontalAlignment(JLabel.CENTER);

              if (value instanceof ImageIcon) {
                  ImageIcon icon = (ImageIcon) value;
                  // resize ảnh nhỏ lại để hiển thị trong cell
                  Image scaled = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                  label.setIcon(new ImageIcon(scaled));
              }

              if (isSelected) {
                  label.setOpaque(true);
                  label.setBackground(table.getSelectionBackground());
              }

              return label;
          });
          
          //khởi tạo kích chuột
          tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
               @Override
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                   tableProductMouseClicked(evt);
               }
           });
          
          // thay đổi selection
          tableProduct.getSelectionModel().addListSelectionListener(e -> {
              if (!e.getValueIsAdjusting()) {
                  int row = tableProduct.getSelectedRow();
                  if (row >= 0) {
                      // Có hàng được chọn
                      Object nameObj = tableProduct.getValueAt(row, 0);
                      Object priceObj = tableProduct.getValueAt(row, 1);
                      Object iconObj = tableProduct.getValueAt(row, 2);

                      lblNameDetail.setText(nameObj != null ? nameObj.toString() : "(trống)");
                      lblPriceDetail.setText(priceObj != null ? priceObj.toString() : "(trống)");

                      if (iconObj instanceof ImageIcon) {
                          ImageIcon icon = (ImageIcon) iconObj;
                          Image scaled = icon.getImage().getScaledInstance(
                                  lblImageDetail.getWidth(),
                                  lblImageDetail.getHeight(),
                                  Image.SCALE_SMOOTH
                          );
                          lblImageDetail.setIcon(new ImageIcon(scaled));
                      } else {
                          lblImageDetail.setIcon(null);
                      }
                  } else {
                      // Không có hàng nào được chọn
                      clearDetail();
                  }
              }
          });

          
          setLocationRelativeTo(null);
          
          
          model = (DefaultTableModel) tableProduct.getModel();
          
          this.shopId = shopId;
          productController = new ProductController();
          shopController = new ShopController();
          loadProducts();
     }
     
     private void loadProducts() {
          model.setRowCount(0);
          List<Product> list = productController.getProductsByShopId(shopId);
          for (Product p : list) {
               ImageIcon icon = null;
               if (p.getImagePath() != null) {
                   ImageIcon rawIcon = new ImageIcon(p.getImagePath());
                   Image scaled = rawIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); // thumbnail
                   icon = new ImageIcon(scaled);
               }
               model.addRow(new Object[]{
                   p.getName(),
                   p.getPrice(),
                   icon
               });
         }
          if (model.getRowCount() == 0) {
               clearDetail(); // bảng rỗng thì xóa chi tiết
           }
          
         // quan trọng: để JTable render ImageIcon
     }
     
     private void clearDetail() {
          lblNameDetail.setText("");
          lblPriceDetail.setText("");
          lblImageDetail.setIcon(null);
          txtDescription.setText("");
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
          jLabel1 = new javax.swing.JLabel();
          jScrollPane1 = new javax.swing.JScrollPane();
          tableProduct = new javax.swing.JTable();
          btnExit = new custom.Button();
          btnDelete = new custom.Button();
          btnAdd = new custom.Button();
          jPanel2 = new javax.swing.JPanel();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          lblImageDetail = new javax.swing.JLabel();
          lblNameDetail = new javax.swing.JLabel();
          lblPriceDetail = new javax.swing.JLabel();
          jLabel5 = new javax.swing.JLabel();
          jScrollPane2 = new javax.swing.JScrollPane();
          txtDescription = new javax.swing.JTextArea();
          jLabel2 = new javax.swing.JLabel();
          btnExitToMenu = new custom.Button();
          btnUpdate = new custom.Button();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setSize(new java.awt.Dimension(1050, 650));

          background1.setLayout(new java.awt.CardLayout());

          jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          jLabel1.setText("Danh sách sản phẩm trong Shop");

          jScrollPane1.setBorder(null);

          tableProduct.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
               },
               new String [] {
                    "Tên sản phẩm", "Giá", "Hình minh họa"
               }
          ) {
               boolean[] canEdit = new boolean [] {
                    false, false, false
               };

               public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
               }
          });
          tableProduct.setRowHeight(50);
          tableProduct.getTableHeader().setFont(new java.awt.Font("Time New Roman", java.awt.Font.BOLD, 14));
          jScrollPane1.setViewportView(tableProduct);

          btnExit.setBackground(new java.awt.Color(0, 153, 255));
          btnExit.setForeground(new java.awt.Color(255, 255, 255));
          btnExit.setText("Quay lại");
          btnExit.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
          btnExit.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnExitActionPerformed(evt);
               }
          });

          btnDelete.setBackground(new java.awt.Color(0, 153, 255));
          btnDelete.setForeground(new java.awt.Color(255, 255, 255));
          btnDelete.setText("Xóa Sản Phẩm");
          btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
          btnDelete.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnDeleteActionPerformed(evt);
               }
          });

          btnAdd.setBackground(new java.awt.Color(0, 153, 255));
          btnAdd.setForeground(new java.awt.Color(255, 255, 255));
          btnAdd.setText("Thêm Sản Phẩm");
          btnAdd.setFocusable(false);
          btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
          btnAdd.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnAddActionPerformed(evt);
               }
          });

          jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
          jLabel3.setText("Tên");

          jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
          jLabel4.setText("Giá");

          lblImageDetail.setBackground(new java.awt.Color(255, 255, 255));
          lblImageDetail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
          lblImageDetail.setForeground(new java.awt.Color(51, 51, 51));
          lblImageDetail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

          lblNameDetail.setBackground(new java.awt.Color(255, 255, 255));
          lblNameDetail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
          lblNameDetail.setForeground(new java.awt.Color(51, 51, 51));
          lblNameDetail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

          lblPriceDetail.setBackground(new java.awt.Color(255, 255, 255));
          lblPriceDetail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
          lblPriceDetail.setForeground(new java.awt.Color(51, 51, 51));
          lblPriceDetail.setToolTipText("");
          lblPriceDetail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

          jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
          jLabel5.setText("Mô tả sản phẩm");

          txtDescription.setEditable(false);
          txtDescription.setColumns(20);
          txtDescription.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
          txtDescription.setLineWrap(true);
          txtDescription.setRows(5);
          txtDescription.setWrapStyleWord(true);
          jScrollPane2.setViewportView(txtDescription);

          javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
          jPanel2.setLayout(jPanel2Layout);
          jPanel2Layout.setHorizontalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(lblImageDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(lblNameDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(lblPriceDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel2Layout.createSequentialGroup()
                              .addGap(90, 90, 90)
                              .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(jPanel2Layout.createSequentialGroup()
                              .addGap(159, 159, 159)
                              .addComponent(jLabel5)))
                    .addContainerGap(242, Short.MAX_VALUE))
          );
          jPanel2Layout.setVerticalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel2Layout.createSequentialGroup()
                              .addComponent(lblImageDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(lblNameDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                   .addComponent(jLabel4)
                                   .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblPriceDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                        .addGap(1, 8, Short.MAX_VALUE)))
                              .addGap(0, 24, Short.MAX_VALUE))
                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                              .addGap(0, 0, Short.MAX_VALUE)
                              .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(31, 31, 31))))
          );

          jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/resources/logomini.png"))); // NOI18N

          btnExitToMenu.setBackground(new java.awt.Color(0, 153, 255));
          btnExitToMenu.setForeground(new java.awt.Color(255, 255, 255));
          btnExitToMenu.setText("Quay lại Menu");
          btnExitToMenu.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
          btnExitToMenu.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnExitToMenuActionPerformed(evt);
               }
          });

          btnUpdate.setBackground(new java.awt.Color(0, 153, 255));
          btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
          btnUpdate.setText("Cập nhật Sản Phẩm");
          btnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
          btnUpdate.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnUpdateActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addGap(345, 345, 345)
                              .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                              .addContainerGap(59, Short.MAX_VALUE)
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnExitToMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(293, 293, 293)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                              .addGap(21, 21, 21)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                         .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(btnExitToMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(111, 111, 111))
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
               .addComponent(background1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
          closeWithEffect(this, () -> new MapView().setVisible(true));
     }//GEN-LAST:event_btnExitActionPerformed

     private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
          if(Session.isTenant()){
               int tenantId = Session.getCurrentTenantId();
               if(!shopController.isShopOwnedByTenant(shopId, tenantId)){
                    JOptionPane.showMessageDialog(this, "Bạn không phải chủ của gian hàng này!");
               }
               else{
                    int row = tableProduct.getSelectedRow();
                    if(row >= 0){
                        Object name = tableProduct.getValueAt(row, 0);

                        if(name == null){
                              JOptionPane.showMessageDialog(this, 
                                   "Dòng này chưa có dữ liệu sản phẩm, không thể xóa!");
                              return;
                        }

                        int confirm = JOptionPane.showConfirmDialog(this,
                                "Xóa sản phẩm " + name + "?",
                                "Xác nhận", JOptionPane.YES_NO_OPTION);
                        if(confirm == JOptionPane.YES_OPTION){
                            productController.deleteProduct(shopId, name.toString());
                            loadProducts();
                        }
                        else{
                             JOptionPane.showMessageDialog(this, "Xóa thất bại!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Hãy chọn sản phẩm để xóa!");
                    }
               }
          }
          else{
               JOptionPane.showMessageDialog(this, "Chỉ chủ thuê gian hàng mới được xóa sản phẩm!");
          }
     }//GEN-LAST:event_btnDeleteActionPerformed

     private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
          if(Session.isTenant()){
               int tenantId = Session.getCurrentTenantId();
               if(!shopController.isShopOwnedByTenant(shopId, tenantId)){
                    JOptionPane.showMessageDialog(this, "Bạn không phải chủ của gian hàng này!");
               }
               else{
                    AddProductDialog dialog = new AddProductDialog(this, true, shopId);
                    dialog.setVisible(true);
                    loadProducts();
               }
          }
          else{
               JOptionPane.showMessageDialog(this, "Chỉ chủ thuê gian hàng mới được thêm sản phẩm!");
          }
     }//GEN-LAST:event_btnAddActionPerformed

     private void btnExitToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitToMenuActionPerformed
          if(Session.isAdmin()){
               closeWithEffect(this, () -> new MainView_Admin().setVisible(true));
          }
          else{
               closeWithEffect(this, () -> new MainView_Tenant().setVisible(true));
          }
     }//GEN-LAST:event_btnExitToMenuActionPerformed

     private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
          if(Session.isTenant()){
               int tenantId = Session.getCurrentTenantId();
               if(!shopController.isShopOwnedByTenant(shopId, tenantId)){
                    JOptionPane.showMessageDialog(this, "Bạn không phải chủ của gian hàng này!");
               }
               else{
                    int row = tableProduct.getSelectedRow();
                    if(row >= 0){
                        Object name = tableProduct.getValueAt(row, 0);

                        if(name == null){
                              JOptionPane.showMessageDialog(this, 
                                   "Dòng này chưa có dữ liệu sản phẩm, không thể cập nhật!");
                              return;
                        }

                        int confirm = JOptionPane.showConfirmDialog(this,
                                "Cập nhật sản phẩm " + name + "?",
                                "Xác nhận", JOptionPane.YES_NO_OPTION);
                        if(confirm == JOptionPane.YES_OPTION){
                              UpdateProductDialog dialog = new UpdateProductDialog(this, true, shopId,name.toString());
                              dialog.setVisible(true);
                              loadProducts();
                        }
                        else{
                             JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Hãy chọn sản phẩm để cập nhật!");
                    }
               }
          }
          else{
               JOptionPane.showMessageDialog(this, "Chỉ chủ thuê gian hàng mới được cập nhật sản phẩm!");
          }
     }//GEN-LAST:event_btnUpdateActionPerformed

     private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {                                        
          int row = tableProduct.getSelectedRow();
          if (row >= 0) {
              Object nameObj = tableProduct.getValueAt(row, 0);
              Object priceObj = tableProduct.getValueAt(row, 1);
              Object iconObj = tableProduct.getValueAt(row, 2);

              if (nameObj == null || priceObj == null) {
                  lblNameDetail.setText("(Trống)");
                  lblPriceDetail.setText("(Trống)");
                  lblImageDetail.setIcon(null);
                  txtDescription.setText("(Trống)");
                  return;
              }

              lblNameDetail.setText(nameObj.toString());
              lblPriceDetail.setText(priceObj.toString());

              if (iconObj instanceof ImageIcon) {
                  ImageIcon icon = (ImageIcon) iconObj;
                  Image scaled = icon.getImage().getScaledInstance(
                          lblImageDetail.getWidth(),
                          lblImageDetail.getHeight(),
                          Image.SCALE_SMOOTH);
                  lblImageDetail.setIcon(new ImageIcon(scaled));
              } else {
                  lblImageDetail.setIcon(null);
              }
              
              txtDescription.setText(productController.getDescriptionByNameID(shopId,nameObj.toString()));
          }
      }

     
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
               java.util.logging.Logger.getLogger(ProductViewMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(ProductViewMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(ProductViewMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(ProductViewMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>
          //</editor-fold>

          /* Create and display the form */
          SwingUtilities.invokeLater(() -> {
               new ProductViewMap().setVisible(true);
           });
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private custom.Background background1;
     private custom.Button btnAdd;
     private custom.Button btnDelete;
     private custom.Button btnExit;
     private custom.Button btnExitToMenu;
     private custom.Button btnUpdate;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JScrollPane jScrollPane2;
     private javax.swing.JLabel lblImageDetail;
     private javax.swing.JLabel lblNameDetail;
     private javax.swing.JLabel lblPriceDetail;
     private javax.swing.JTable tableProduct;
     private javax.swing.JTextArea txtDescription;
     // End of variables declaration//GEN-END:variables
}
