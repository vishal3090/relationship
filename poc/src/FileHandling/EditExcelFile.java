package FileHandling;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EditExcelFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInput= new FileInputStream(new File("C:\\Users\\DC\\Desktop\\java\\FileHandling\\CarData.xlsx"));

        XSSFWorkbook wb = new XSSFWorkbook(fileInput);

        XSSFSheet worksheet = wb.getSheetAt(0);

        Cell cell = null;

        cell = worksheet.getRow(4).getCell(1);

        cell.setCellValue("Laura");

        System.out.println("Successfully Done");

        fileInput.close();

        FileOutputStream output_file =new FileOutputStream(new File("C:\\Users\\DC\\Desktop\\java\\FileHandling\\CarData.xlsx"));

        wb.write(output_file);

        output_file.close();
    }
}
