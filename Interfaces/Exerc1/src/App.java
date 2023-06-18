import java.time.LocalDateTime;
import java.util.Scanner;

import entities.CarRental;
import entities.Invoice;
import entities.Vehicle;
import services.RentalService;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        String carModel, retirada, retorno;

        System.out.println("Enter the rental data:");
        CarRental carRental = new CarRental();

        System.out.print("Car Model: ");
        carModel = scan.nextLine();

        carRental.setVehicle(new Vehicle());
        carRental.getVehicle().setModel(carModel);

        System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
        retirada = scan.nextLine();
        carRental.setStart(LocalDateTime.parse(retirada, CarRental.format));

        System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
        retorno = scan.nextLine();
        carRental.setFinish(LocalDateTime.parse(retorno, CarRental.format));

        double pricePerHour, pricePerDay;
        System.out.print("Type the price per hour: ");
        pricePerHour = scan.nextDouble();

        System.out.print("Type the price per day: ");
        pricePerDay = scan.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay);

        rentalService.

        // carRental.setInvoice(new Invoice());

        System.out.println(carRental.getInvoice().toString());


        scan.close();
    }
}
