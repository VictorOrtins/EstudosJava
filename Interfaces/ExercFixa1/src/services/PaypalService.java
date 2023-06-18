package services;

public class PaypalService implements OnlinePaymentService{

    private final Double simpleInterest = 0.01; //percentage
    private final Double fee = 0.02; //percentage


    public PaypalService(){
        
    }

    @Override
    public double paymentFee(double amount) {
        return amount * fee;
    }

    @Override
    public double interest(double amount, int month) {
        return amount * simpleInterest * month;
    }

    public double getSimpleInterest() {
        return this.simpleInterest;
    }

    public double getFee() {
        return this.fee;
    }
}
