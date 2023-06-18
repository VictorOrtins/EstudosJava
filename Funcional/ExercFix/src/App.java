import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        List<Employee> employeesList = new ArrayList<Employee>();

        System.out.print("Enter full file path: ");
        String path = scan.nextLine();

        System.out.print("Enter salary: ");
        double salary = scan.nextDouble();
        System.out.format("Email of people whose salary is more than %.2f:\n", salary);

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            String str_array[];

            while(line != null){
                str_array = line.split(",");
                employeesList.add(new Employee(str_array[0], str_array[1], Double.parseDouble(str_array[2])));
                line = br.readLine();
            }

            List<Employee> employeesListSalaryHigherThanCriteria = employeesList.stream()
                                                                   .filter( (employee) -> employee.getSalary() > salary)
                                                                   .sorted( (x, y) -> x.getName().toUpperCase().compareTo(y.getName().toUpperCase()))
                                                                   .collect(Collectors.toList());

            employeesListSalaryHigherThanCriteria.stream().forEach(App::printEmail);

            System.out.format("Sum of people whose name starts with 'M': %.2f", EmployeeService.filteredSum(employeesList, (employee) -> employee.getName().toUpperCase().charAt(0) == 'M'));

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

        scan.close();
    }

    public static void printEmail(Employee employee){
        System.out.println(employee.getEmail());
    }
}
