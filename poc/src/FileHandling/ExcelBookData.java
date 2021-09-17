package FileHandling;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class ExcelBookData {
    public static void main(String[] args){
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet spreadSheet = workBook.createSheet("Books");
        Object[][] bookData = {
                {"Head First Java", "Kathy Serria", 79 },
                {"Effective Java", "Joshua Bloch", 36},
                {"Clean Code", "Robert martin", 42},
                {"Thinking in Java", "Bruce Eckel", 35},
        };
        int rowCount = 0;
        for (Object[] aBook: bookData){
            Row row = spreadSheet.createRow(rowCount++);
            int columnCount = 0;
            for (Object field: aBook){
                Cell cell = row.createCell(columnCount++);
                if(field instanceof String) {
                    cell.setCellValue((String) field);
                }
                else if (field instanceof Integer){
                    cell.setCellValue((Integer)field);
                }
            }
        }
        try {
            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\DC\\Desktop\\java\\FileHandling\\Books.xlsx");
            workBook.write(outputStream);
        }
        catch (Exception e){
            System.out.println("Error "+e);
        }
    }
}
