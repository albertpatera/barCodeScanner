package com.example.scankitdemo.core;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class writeXls {
    public void main(String[] args) {

        File file = new File("C:\\temp\\data.xlsx");

        List<ItemEntity> recordsToWrite = List.of(
               // new ItemEntity("Charles", "Babej", "60", null),
                //new ItemEntity("John", "Doe", "70", null),
                //new ItemEntity("Loreum", "Ipsum", "80", null)
        );

        try {
            this.appendRows(recordsToWrite, file);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, Object[]> prepareData(int rowNum,
                                                      List<ItemEntity> recordsToWrite) {
        Map<Integer, Object[]> data = new HashMap<>();
        for (ItemEntity entity : recordsToWrite) {
            rowNum++;
            data.put(rowNum, new Object[]{rowNum, entity.getFirstName(),
                    entity.getLastName()});
        }
        return data;
    }

    public  void appendRows(List<ItemEntity> recordsToWrite, File file)
            throws IOException, InvalidFormatException {


        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getLastRowNum() + 1;
        /*String[] headers = new String[] { "Header1", "Header2", "Header3" };

        //Workbook workbook = new HSSFWorkbook();
       // Sheet sheet = workbook.createSheet("EDR Raw Data");
        Row r = sheet.createRow(2);
        r.createCell(0).setCellValue(headers[0]);
        r.createCell(1).setCellValue(headers[1]);
        r.createCell(2).setCellValue(headers[2]);
        for (int rn=0; rn<headers.length; rn++) {
            r.createCell(0).setCellValue(headers[0]);
            r.createCell(1).setCellValue(headers[1]);
            r.createCell(2).setCellValue(headers[2]);
        }*/

        Map<Integer, Object[]> data = prepareData(rowNum, recordsToWrite);

        Set<Integer> keySet = data.keySet();
        for (Integer key : keySet) {
            Row row = sheet.createRow(rowNum++);
            Object[] objArr = data.get(key);
            int cellNum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellNum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}