import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        Worker worker = new Worker();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        String temp_str;

        System.out.print("Enter Department's name: ");
        temp_str = scan.nextLine();
        worker.setDepartment(new Department(temp_str));

        System.out.print("Enter Worker's data:\nName: ");
        temp_str = scan.nextLine();
        worker.setName(temp_str);

        System.out.print("Level: ");
        temp_str = scan.nextLine();
        worker.setWorkerLevel(WorkerLevel.valueOf(temp_str));
        
        double temp_double;
        System.out.print("Base Salary: ");
        temp_double = scan.nextDouble();

        worker.setBaseSalary(temp_double);

        int temp_int;

        int contracts;
        System.out.print("How many contracts to this worker? ");
        contracts = scan.nextInt();

        HourContract temp_hour_contract;
        for(int i = 1; i <= contracts; i++){
            temp_hour_contract = new HourContract();

            System.out.print("Enter contract #" + i + " data:\nDate (DD/MM/YYYY): ");
            // scan.next();
            temp_str = scan.next();
            temp_hour_contract.setDate(LocalDate.parse(temp_str, formatter));

            System.out.print("Value per hour: ");
            temp_double = scan.nextDouble();
            temp_hour_contract.setValuePerHour(temp_double);

            System.out.print("Duration (hours): ");
            temp_int = scan.nextInt();
            temp_hour_contract.setHours(temp_int);
            
            worker.addContract(temp_hour_contract);
        }

        System.out.print("Enter Month and Year to calculate income (MM/YYYY): ");
        temp_str = scan.next();

        String str_array[] = temp_str.split("/");
        int array[] = new int[str_array.length];

        for(int i = 0; i < array.length; i++){
            array[i] = Integer.parseInt(str_array[i]);
        }

        System.out.println("Name: " + worker.getName() + "\nDepartment: " + worker.getDepartment().getName() + "\nIncome for " + temp_str + ": " + worker.income(array[1], array[0]));

        scan.close();
    }
}
