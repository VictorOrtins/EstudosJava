package services;

import java.time.Duration;

import entities.CarRental;
import entities.Invoice;

public class RentalService implements TaxService{

    private Double pricePerHour;
    private Double pricePerDay;

    public RentalService(){

    }


    public RentalService(Double pricePerHour, Double pricePerDay) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
    }

    public void applyInvoice(CarRental carRental){
        double durationMinutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double price;
        
        if(Math.ceil(durationMinutes / 60.0) < 12){
            price = this.pricePerHour;
        }
        else{
            price = this.pricePerDay;
        }

    }

    @Override
    public double tax(CarRental carRental) {
        if(carRental.getInvoice().getBasicPayment() < 100){
            return 0.20;
        }
        else{
            return 0.15;
        }
    }


    public Double getPricePerHour() {
        return this.pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    
}
