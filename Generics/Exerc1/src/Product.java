public class Product implements Comparable<Product>{
    private String name;
    private Double value;

    public Product() {
        this.name = null;
        this.value = null;
    }

    public Product(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return this.getName() + " - " + this.getValue();
    }

    @Override
    public int compareTo(Product other) {
        return this.value.compareTo(other.getValue());
    }
}
