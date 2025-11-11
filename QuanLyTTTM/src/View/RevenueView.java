
package View;

import Controller.RevenueController;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class RevenueView extends javax.swing.JFrame {

     private RevenueController revenueController = new RevenueController();
     
     public RevenueView() {
         initComponents();
         
         initComboBoxes();
         
          setLocationRelativeTo(null);
     }

     // Khởi tạo dữ liệu cho combobox tháng, năm
     private void initComboBoxes() {
         // Tháng
         for (int i = 1; i <= 12; i++) {
             cboMonth.addItem(String.valueOf(i));
         }

         // Năm
         int currentYear = LocalDate.now().getYear();
         for (int y = currentYear - 5; y <= currentYear + 10; y++) {
             cboYear.addItem(String.valueOf(y));
         }

         cboMonth.setSelectedItem(String.valueOf(LocalDate.now().getMonthValue()));
         cboYear.setSelectedItem(String.valueOf(currentYear));
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
          jLabel2 = new javax.swing.JLabel();
          jScrollPane1 = new javax.swing.JScrollPane();
          table = new javax.swing.JTable();
          table.getTableHeader().setFont(new java.awt.Font("Time New Roman", java.awt.Font.BOLD, 14));
          btnExport = new custom.Button();
          btnExit = new custom.Button();
          jLabel5 = new javax.swing.JLabel();
          cboMonth = new javax.swing.JComboBox<>();
          cboYear = new javax.swing.JComboBox<>();
          btnView = new custom.Button();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          jLabel1 = new javax.swing.JLabel();
          lblTotal = new javax.swing.JLabel();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

          jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/resources/logomini2.png"))); // NOI18N

          table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
          table.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
               },
               new String [] {
                    "Shop", "Khu vực", "Tiền thuê thu được"
               }
          ) {
               boolean[] canEdit = new boolean [] {
                    false, false, false
               };

               public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
               }
          });
          table.setRowHeight(40);
          jScrollPane1.setViewportView(table);

          btnExport.setBackground(new java.awt.Color(0, 153, 255));
          btnExport.setForeground(new java.awt.Color(255, 255, 255));
          btnExport.setText("Xuất file");
          btnExport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
          btnExport.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnExportActionPerformed(evt);
               }
          });

          btnExit.setBackground(new java.awt.Color(0, 153, 255));
          btnExit.setForeground(new java.awt.Color(255, 255, 255));
          btnExit.setText("Thoát");
          btnExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
          btnExit.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnExitActionPerformed(evt);
               }
          });

          jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
          jLabel5.setText("Tổng doanh thu");

          cboMonth.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

          cboYear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

          btnView.setBackground(new java.awt.Color(0, 153, 255));
          btnView.setForeground(new java.awt.Color(255, 255, 255));
          btnView.setText("Xem");
          btnView.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
          btnView.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnViewActionPerformed(evt);
               }
          });

          jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
          jLabel3.setText("Tháng");

          jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
          jLabel4.setText("Năm");

          jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
          jLabel1.setText("Doanh Thu Trung Tâm");

          lblTotal.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
          lblTotal.setForeground(new java.awt.Color(0, 204, 102));

          javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
          background1.setLayout(background1Layout);
          background1Layout.setHorizontalGroup(
               background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(312, 312, 312))
               .addGroup(background1Layout.createSequentialGroup()
                    .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(background1Layout.createSequentialGroup()
                              .addComponent(jLabel2)
                              .addGap(325, 325, 325)
                              .addComponent(jLabel1))
                         .addGroup(background1Layout.createSequentialGroup()
                              .addGap(252, 252, 252)
                              .addComponent(jLabel3)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addComponent(cboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(37, 37, 37)
                              .addComponent(jLabel4)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addComponent(cboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(31, 31, 31)
                              .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(background1Layout.createSequentialGroup()
                              .addGap(161, 161, 161)
                              .addComponent(jLabel5)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(background1Layout.createSequentialGroup()
                              .addGap(205, 205, 205)
                              .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(239, Short.MAX_VALUE))
          );
          background1Layout.setVerticalGroup(
               background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(background1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(35, 35, 35)
                    .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel3)
                         .addComponent(jLabel4)
                         .addComponent(cboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(cboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                         .addComponent(jLabel5)
                         .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                    .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(127, 127, 127))
               .addGroup(background1Layout.createSequentialGroup()
                    .addComponent(jLabel2)
                    .addGap(0, 0, Short.MAX_VALUE))
          );

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(background1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
          closeWithEffect(this, () -> new MainView_Admin().setVisible(true));
     }//GEN-LAST:event_btnExitActionPerformed

     private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
          try {
            int month = Integer.parseInt((String) cboMonth.getSelectedItem());
            int year = Integer.parseInt((String) cboYear.getSelectedItem());

            double total = revenueController.getMonthlyRevenue(month, year);
            lblTotal.setText(String.format("%,.0f VNĐ", total));

            List<Object[]> data = revenueController.getShopRevenueList(month, year);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for (Object[] row : data) {
                model.addRow(new Object[]{
                    row[0],
                    row[1],
                    String.format("%,.0f VNĐ", (double) row[2])
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu: " + e.getMessage());
        }
     }//GEN-LAST:event_btnViewActionPerformed

     private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
          int month = Integer.parseInt((String) cboMonth.getSelectedItem());
          int year = Integer.parseInt((String) cboYear.getSelectedItem());

          // Giả sử lblTotalRevenue hiển thị như “4,423,000 VNĐ”
          String totalStr = lblTotal.getText().replaceAll("[^0-9]", "");
          double total = totalStr.isEmpty() ? 0 : Double.parseDouble(totalStr);

          revenueController.exportToExcel(table, month, year, total);
     }//GEN-LAST:event_btnExportActionPerformed

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
               java.util.logging.Logger.getLogger(RevenueView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(RevenueView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(RevenueView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(RevenueView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>
          //</editor-fold>

          /* Create and display the form */
          java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                    new RevenueView().setVisible(true);
               }
          });
     }

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private custom.Background background1;
     private custom.Button btnExit;
     private custom.Button btnExport;
     private custom.Button btnView;
     private javax.swing.JComboBox<String> cboMonth;
     private javax.swing.JComboBox<String> cboYear;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JLabel lblTotal;
     private javax.swing.JTable table;
     // End of variables declaration//GEN-END:variables
}
