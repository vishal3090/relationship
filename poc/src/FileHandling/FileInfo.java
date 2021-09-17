package FileHandling;

import java.io.File;

public class FileInfo {
    public static void main(String[] args){
        File file = new File("FileHandlingExample.txt");
        boolean value = file.exists();
        if(value){
            System.out.println("The name of the file is: "+file.getName());
            System.out.println("The absolute path of the file is: "+file.getAbsolutePath());
            System.out.println("Is file writable: "+file.canWrite());
            System.out.println("Is file readable: "+file.canRead());
            System.out.println("The size of the file in Bytes is: "+file.length());
        }
        else {
            System.out.println("The file does not exist");
        }
    }
}
