import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        List<Employee> list = new ArrayList<Employee>();

        System.out.print("Enter the file path: ");
        String path = scan.next();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String employeeCSV = br.readLine();
            while(employeeCSV != null){
                String array[] = employeeCSV.split(",");

                list.add(new Employee(array[0], Double.parseDouble(array[1])));
                
                employeeCSV = br.readLine();
            }

            Collections.sort(list);

            for(Employee s : list){
                System.out.println(s);
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        scan.close();
    }
}
