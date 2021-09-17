package FileHandling;

import java.io.*;

public class EditFile {
    static void editFile(String filePath, String oldString, String newString){
        File fileToBeEdit = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(fileToBeEdit));

            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();
            while (line!=null){
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
            //Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceAll(oldString, newString);

            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeEdit);
            writer.write(newContent);
        }
        catch (Exception e){
            System.out.println("Error: "+e);
        }
        finally {
            try {
                //Closing the resources
                reader.close();
                writer.close();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        editFile("Rename.txt","78","87");
        System.out.println("Done");
    }
}
