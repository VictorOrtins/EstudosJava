package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
    public static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate dueDate;
    private double amount;


    public Installment() {
    }

    public Installment(LocalDate dueDate, double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();

        ret.append(this.getDueDate().format(format));
        ret.append(" - ");
        ret.append(this.getAmount() + "\n");

        return ret.toString();
    }


}
