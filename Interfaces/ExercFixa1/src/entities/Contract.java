package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    private int number;
    private LocalDate date;
    private double value;
    private List<Installment> installments = new ArrayList<Installment>();

    public Contract() {
    }

    public Contract(int number, LocalDate date, double value) {
        this.number = number;
        this.date = date;
        this.value = value;
    }

    public void addInstallment(Installment installment){
        this.installments.add(installment);
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public List<Installment> getInstallments() {
        return this.installments;
    }

    public void setInstallments(List<Installment> installments) {
        this.installments = installments;
    }

    public String printInstallments(){        
        StringBuilder ret = new StringBuilder("Installments: \n");

        for(Installment installment : installments){
            ret.append(installment.toString());
        }
        
        return ret.toString();
    }

}
