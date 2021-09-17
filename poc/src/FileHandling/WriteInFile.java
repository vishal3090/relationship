package FileHandling;

import java.io.FileWriter;

public class WriteInFile {
    public static void main(String[] args){
        try {
            FileWriter fileWrite = new FileWriter("C:\\Users\\DC\\Desktop\\java\\FileHandling\\Example.xlsx");

            //fileWrite.write("This is a file created using Java");
            fileWrite.close();
            System.out.println("Content is successfully wrote to the file");
        }
        catch (Exception e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
