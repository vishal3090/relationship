package FileHandling;

import java.io.File;

public class RenameFile {
    public static void main(String[] args){
        File file = new File("newFile.txt");
        File dest = new File("Rename.txt");
        if(file.renameTo(dest)){
            System.out.println("File is successfully rename");
        }
        else
        {
            System.out.println("File cannot be removed");
        }
    }
}
