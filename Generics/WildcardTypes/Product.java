public class Product {
    private String name;
    private int id;

    public Product() {
    }

    public Product(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product name(String name) {
        setName(name);
        return this;
    }

    public Product id(int id) {
        setId(id);
        return this;
    }

    @Override
    public String toString() {
        return "{Name: " + this.getName() + " Id: " + this.getId() + "}";
    }


}
