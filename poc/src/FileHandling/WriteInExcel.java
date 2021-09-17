package FileHandling;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class WriteInExcel {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Student Data");
        XSSFRow row;
        Map<String, Object[]> studentData = new TreeMap<>();
        studentData.put("1", new Object[]{"Roll No", "Name", "Year"});
        studentData.put("2", new Object[]{"1", "Nayan", "1st year"});
        studentData.put("3", new Object[]{"2", "Mayank", "1st year"});
        studentData.put("4", new Object[]{"3", "Hardik", "1st year"});
        studentData.put("5", new Object[]{"4", "Karan", "1st year"});
        studentData.put("6", new Object[]{"5", "Hiren", "1st year"});

        Set<String> keyId = studentData.keySet();
        int rowCount = 0;

        //Writing the data into the sheets

        for (String key : keyId){
            row = sheet.createRow(rowCount++);
            Object[] objectArr = studentData.get(key);
            int cellCount = 0;
            for (Object obj : objectArr){
                Cell cell = row.createCell(cellCount++);
                cell.setCellValue((String)obj);
            }
        }
        FileOutputStream out = new FileOutputStream("C:\\Users\\DC\\Desktop\\java" +
                "\\FileHandling\\StudentData.xlsx");
        workbook.write(out);
        out.close();
        System.out.println("Successfully created file");
    }
}
