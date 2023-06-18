import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Set<Student> studentsSet = new HashSet<Student>();
        
        char charArray[] = {'A','B','C'};

        int studentsPerCourse = 0;

        for(int i = 0; i < charArray.length; i++){
            System.out.print("How many students for course " + charArray[i] + "? ");
            studentsPerCourse = scan.nextInt();
            for(int j = 0; j < studentsPerCourse; j++){
                studentsSet.add(new Student(scan.nextInt()));
            }
        }

        System.out.println("Total Students: " + studentsSet.size());

        scan.close();


    }
}
