package cmd;

import java.io.File;

public class MyDisks {
    private static File[] files;
    public static File[] getFiles(){
        return files;
    }
    public static void setFiles(File file){
        files = file.listFiles();
    }
}
