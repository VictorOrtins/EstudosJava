package services;

import entities.CarRental;

public interface TaxService {
    public abstract double tax(CarRental carRental);
}
