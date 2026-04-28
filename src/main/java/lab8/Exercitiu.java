package lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

public class Exercitiu {

    public static void main(String[] args) throws Exception {
        readAndDisplay();
        copyWithAverage();
        copyWithFormula();
    }

    static void readAndDisplay() throws Exception {
        Workbook wb = new XSSFWorkbook(new FileInputStream("laborator8_input.xlsx"));
        for (Row row : wb.getSheetAt(0)) {
            for (Cell cell : row) {
                if (cell.getCellType() == CellType.NUMERIC)
                    System.out.print(cell.getNumericCellValue() + ", ");
                else
                    System.out.print(cell.getStringCellValue() + ", ");
            }
            System.out.println();
        }
        wb.close();
    }

    static void copyWithAverage() throws Exception {
        Workbook input = new XSSFWorkbook(new FileInputStream("laborator8_input.xlsx"));
        Workbook output = new XSSFWorkbook();
        Sheet outSheet = output.createSheet();
        
        int r = 0;
        for (Row row : input.getSheetAt(0)) {
            Row out = outSheet.createRow(r++);
            double sum = 0;
            int cnt = 0;
            
            for (int i = 0; i < row.getLastCellNum(); i++) {
                Cell c = row.getCell(i);
                if (c != null) {
                    if (c.getCellType() == CellType.NUMERIC) {
                        out.createCell(i).setCellValue(c.getNumericCellValue());
                        if (i >= row.getLastCellNum() - 3) { sum += c.getNumericCellValue(); cnt++; }
                    } else out.createCell(i).setCellValue(c.getStringCellValue());
                }
            }
            out.createCell(row.getLastCellNum()).setCellValue(cnt > 0 ? sum / cnt : 0);
        }
        output.write(new FileOutputStream("laborator8_output2.xlsx"));
        output.close();
        input.close();
    }

    static void copyWithFormula() throws Exception {
        Workbook input = new XSSFWorkbook(new FileInputStream("laborator8_input.xlsx"));
        Workbook output = new XSSFWorkbook();
        Sheet outSheet = output.createSheet();
        
        int r = 0;
        for (Row row : input.getSheetAt(0)) {
            Row out = outSheet.createRow(r);
            int n = row.getLastCellNum();
            
            for (int i = 0; i < n; i++) {
                Cell c = row.getCell(i);
                if (c != null) {
                    if (c.getCellType() == CellType.NUMERIC) 
                        out.createCell(i).setCellValue(c.getNumericCellValue());
                    else out.createCell(i).setCellValue(c.getStringCellValue());
                }
            }
            
            String a = colName(n - 3), b = colName(n - 1);
            out.createCell(n).setCellFormula("AVERAGE(" + a + (r + 1) + ":" + b + (r + 1) + ")");
            r++;
        }
        output.write(new FileOutputStream("laborator8_output3.xlsx"));
        output.close();
        input.close();
    }

    static String colName(int i) {
        String s = ""; i++;
        while (i > 0) { i--; s = (char)('A' + i % 26) + s; i /= 26; }
        return s;
    }
}
