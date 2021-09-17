package FileHandling;

import java.io.File;

public class DeleteFile {
    public static void main(String[] args){
        File file = new File("FileHandlingExample.docs");
        if(file.delete()){
            System.out.println(file.getName()+" file is deleted successfully");
        }
        else {
            System.out.println("Error found in deletion");
        }

    }
}
