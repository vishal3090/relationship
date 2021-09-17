package FileHandling;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        //Using Scanner
        try {

            File file = new File("FileHandlingExample.txt");
            Scanner dataReader = new Scanner(file);
            while (dataReader.hasNextLine()){
                String fileData = dataReader.nextLine();
                System.out.println(fileData);
                }
            dataReader.close();
        }
        catch (Exception e){
            System.out.println("Unexpected error occurred");
            e.printStackTrace();
        }
        //USing reader
        /*try {
            Reader reader = new FileReader("FileHandlingExample.txt");
            int data = reader.read();
            while (data!=-1){
                System.out.println((char) data);
                data = reader.read();
            }
            reader.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }*/

    }
}
