package FileHandling;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class ExcelCar {
    public static void main(String[] args){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet excelSheet = workbook.createSheet("Car Data");
        Object[][] carData = {
                {"No", "Model", "Company", "Price"},
                {"1", "Creta", "Hyundai", "12 Lakh"},
                {"2", "I20", "Maruti Suzuki", "8 Lakh"},
                {"3", "Civik", "Honda", "18 Lakh"},
                {"4", "Octavia", "Skoda", "22 Lakh"},
                {"5", "Harirer", "Tata", "16 Lakh"}
        };
        int rowCount = 0;
        for(Object[] aCar: carData){
            Row row = excelSheet.createRow(rowCount++);
            int cellCOunt = 0;
            for (Object column: aCar){
                Cell cell = row.createCell(cellCOunt++);
                if (column instanceof String){
                    cell.setCellValue((String)column);
                }
                else if (column instanceof Integer){
                    cell.setCellValue((Integer)column);
                }
            }
        }
        try {
            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\DC\\Desktop\\java\\FileHandling\\CarData.xlsx");
            workbook.write(outputStream);
            System.out.println("Successfully created");
        }
        catch (Exception e){
            System.out.println("Error: "+e);
        }
    }
}
