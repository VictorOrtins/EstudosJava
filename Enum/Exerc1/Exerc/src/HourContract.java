import java.time.LocalDate;

public class HourContract {
    private LocalDate date;
    private double valuePerHour;
    private Integer hours;


    public HourContract() {
        this.date = null;
        this.valuePerHour = 0;
        this.hours = 0;
    }

    public HourContract(LocalDate date, double valuePerHour, Integer hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public double totalValue(){
        return this.valuePerHour * hours;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getValuePerHour() {
        return this.valuePerHour;
    }

    public void setValuePerHour(double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public int getHours() {
        return this.hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }




}
