package com.exelBatch.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exelBatch.model.data_exel;
import com.exelBatch.reppo.dataExelReppo;


@Service
public class dataExelService{

  @Autowired
  private dataExelReppo dR;
  public String publishAPI(String filePath){
    
    List<data_exel> reportDataList = dR.findAll();

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Report");

            // Header Row
            Row headerRow = sheet.createRow(0);
            String[] columns = {"Periode", "Tanggal Generate", "Barang Masuk", "Barang Keluar", "Pendapatan"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // Data Rows
            int rowNum = 1;
            for (data_exel data : reportDataList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(data.getPeriode());
                row.createCell(1).setCellValue(data.getTgl_generate());
                row.createCell(2).setCellValue(data.getBarang_masuk());
                row.createCell(3).setCellValue(data.getBarang_keluar());
                row.createCell(4).setCellValue(data.getPendapatan());
            }

            // Write the file to the specified path
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

            return "File generated successfully at " + filePath;

        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to generate file: " + e.getMessage();
        }
    
  }
  
}
