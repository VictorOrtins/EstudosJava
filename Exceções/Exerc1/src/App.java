import java.time.LocalDate;
import java.util.Scanner;

import entities.Reservation;
import exceptions.ReservationException;

public class App {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        Reservation reservation;
        String checkIn_str, checkOut_str;
        int roomNumber;

        try{
            System.out.print("Enter Room Number: ");
            roomNumber = scan.nextInt();
            reservation = new Reservation(roomNumber);
    
            System.out.print("Check-In date (dd/MM/yyyy): ");
            checkIn_str = scan.next();
            System.out.print("Check-Out date (dd/MM/yyyy): ");
            checkOut_str = scan.next();
    
            LocalDate checkIn = LocalDate.parse(checkIn_str, Reservation.format);
            LocalDate checkOut = LocalDate.parse(checkOut_str, Reservation.format);
            
            updateDates(reservation, checkIn, checkOut);
    
            System.out.println("Enter Data to Update Reservation: ");
    
            System.out.print("Check-In date (dd/MM/yyyy): ");
            checkIn_str = scan.next();
            System.out.print("Check-Out date (dd/MM/yyyy): ");
            checkOut_str = scan.next();
    
            checkIn = LocalDate.parse(checkIn_str, Reservation.format);
            checkOut = LocalDate.parse(checkOut_str, Reservation.format);
    
            updateDates(reservation, checkIn, checkOut);
        }
        catch(RuntimeException e){
            System.out.println("Unexpected Error");
        }

        scan.close();
    }

    public static void updateDates(Reservation reservation, LocalDate checkIn, LocalDate checkOut){
        try{
            reservation.updateDates(checkIn, checkOut);
        }
        catch(ReservationException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        
        System.out.println(reservation.toString());
    }
}
