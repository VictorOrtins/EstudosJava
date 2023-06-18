package entities;

public class Invoice {
    private Double basicPayment;
    private Double tax;
    private Double totalPayment;

    public Invoice(){
        this.basicPayment = null;
        this.tax = null;
        this.totalPayment = null;
    }

    public Invoice(Double basicPayment, Double tax, Double totalPayment) {
        this.basicPayment = basicPayment;
        this.tax = tax;
        this.totalPayment = totalPayment;
    }

    public Double getBasicPayment() {
        return this.basicPayment;
    }

    public Double getTax() {
        return this.tax;
    }

    public Double getTotalPayment() {
        return this.totalPayment;
    }

    public void setBasicPayment(Double basicPayment) {
        this.basicPayment = basicPayment;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();

        ret.append("Invoice: \n");
        ret.append("Basic Payment: " + this.basicPayment);
        ret.append("\nTax: " + this.tax);
        ret.append("\nTotal Payment: " + this.totalPayment);

        return ret.toString();
    }
}
