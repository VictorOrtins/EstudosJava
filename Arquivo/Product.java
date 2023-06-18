public class Product {
    private String name;
    private Double pricePerProduct;
    private Integer amount;
    
    public Product() {
        this.name = null;
        this.amount = null;
        this.pricePerProduct = null;
    }

    public Product(String name, double pricePerProduct, Integer amount) {
        this.name = name;
        this.amount = amount;
        this.pricePerProduct = pricePerProduct;
    }

    public double totalValue(){
        return amount * pricePerProduct;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public double getPricePerProduct() {
        return this.pricePerProduct;
    }

    public void setPricePerProduct(double pricePerProduct) {
        this.pricePerProduct = pricePerProduct;
    }

}
