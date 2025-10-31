package Controller;

import Model.Revenue;
import Model.RevenueDAO;
import java.util.List;
import javax.swing.JTable;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.*;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

public class RevenueController {
    
     private RevenueDAO revenueDAO;
     
     public RevenueController(){
          revenueDAO = new RevenueDAO();
     }
     
     public double getMonthlyRevenue(int month, int year){
          return revenueDAO.getMonthlyRevenue(month, year);
     }
     
     public List<Object[]> getShopRevenueList(int month, int year){
          return revenueDAO.getShopRevenueList(month, year);
     }
     
     //xuất doanh thu ra file excel
     public void exportToExcel(JTable table, int month, int year, double totalRevenue){
          try (Workbook workbook = new XSSFWorkbook()){
               Sheet sheet = workbook.createSheet("Doanh thu " + month + "-" + year);
               // --- Tiêu đề ---
            Row titleRow = sheet.createRow(0);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellValue("BÁO CÁO DOANH THU THÁNG " + month + "/" + year);
            sheet.addMergedRegion(new org.apache.poi.ss.util.CellRangeAddress(0, 0, 0, 2));

            // --- Header ---
            Row headerRow = sheet.createRow(2);
            for (int i = 0; i < table.getColumnCount(); i++) {
                headerRow.createCell(i).setCellValue(table.getColumnName(i));
            }

            // --- Dữ liệu từ JTable ---
            for (int i = 0; i < table.getRowCount(); i++) {
                Row row = sheet.createRow(i + 3);
                for (int j = 0; j < table.getColumnCount(); j++) {
                    Object value = table.getValueAt(i, j);
                    row.createCell(j).setCellValue(value != null ? value.toString() : "");
                }
            }

            // --- Tổng doanh thu ---
            Row totalRow = sheet.createRow(table.getRowCount() + 4);
            totalRow.createCell(0).setCellValue("TỔNG DOANH THU:");
            DecimalFormat df = new DecimalFormat("#,### VNĐ");
            totalRow.createCell(2).setCellValue(df.format(totalRevenue));

            // --- Tự giãn cột ---
            for (int i = 0; i < table.getColumnCount(); i++) {
                sheet.autoSizeColumn(i);
            }

            // --- Chọn nơi lưu file ---
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn nơi lưu file Excel");
            fileChooser.setSelectedFile(new java.io.File("DoanhThu_" + month + "_" + year + ".xlsx"));

            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try (FileOutputStream fos = new FileOutputStream(fileChooser.getSelectedFile())) {
                    workbook.write(fos);
                    JOptionPane.showMessageDialog(null, "Đã xuất file Excel thành công!");
                }
            }

          } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "Lỗi khi xuất Excel: " + e.getMessage());
               e.printStackTrace();
          }
     }
}
