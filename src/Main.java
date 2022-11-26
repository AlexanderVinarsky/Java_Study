import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        ArrayList<File> fileList = new ArrayList<File>();
        searchFiles(new File("C:\\Users\\vinar\\"), fileList);
        for (File file: fileList){
            System.out.println(file.getAbsolutePath());
        }
    }
    private static void searchFiles (File rootFile, ArrayList<File> fileList) {
        if (rootFile.isDirectory()) {
            System.out.println("searching at: " + rootFile.getPath());
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        searchFiles(file, fileList);
                    }
                    else {
                        if (file.getName().endsWith(".jpg")){
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }
}