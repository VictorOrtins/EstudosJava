import java.time.LocalDate;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the contract data:");

        System.out.print("Number: ");
        int number = scan.nextInt();

        System.out.print("Date: ");
        LocalDate date = LocalDate.parse(scan.next(), Installment.format);

        System.out.print("Contract Value: ");
        double contractValue = scan.nextDouble();

        Contract contract = new Contract(number, date, contractValue);

        System.out.print("Number of installments: ");
        int numberOfInstallments = scan.nextInt();

        ContractService service = new ContractService(new PaypalService());

        service.proccesContract(contract, numberOfInstallments);

        System.out.println(contract.printInstallments());

        scan.close();
    }
}
