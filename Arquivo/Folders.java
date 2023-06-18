import java.io.File;
import java.util.Scanner;

public class Folders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a folder path:");
        String strPath = scan.nextLine();

        File path = new File(strPath);

        printFolders(path);

        File files[] = path.listFiles(File::isFile);
        System.out.println("FILES:");
        for(File file: files){
            System.out.println(file);
        }

        boolean sucess = new File(strPath + "\\subdir").mkdir();
        System.out.println(sucess);

        printFolders(path);



        scan.close();
    }

    public static void printFolders(File path){
        File folders[] = path.listFiles(File::isDirectory);
        System.out.println("FOLDERS:");
        for(File folder: folders){
            System.out.println(folder);
        }
    }
}
