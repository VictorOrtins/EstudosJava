import java.util.Objects;

public class Product implements Comparable<Product>{
    private String name;
    private Double price;

    public Product() {
        this.name = null;
        this.price = null;
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "{" +
            " name = '" + getName() + "'" +
            ", price = '" + getPrice() + "'" +
            "}";
    }

    @Override
    public int compareTo(Product o) {
        return this.getName().toUpperCase().compareTo(o.getName().toUpperCase());
    }

}
