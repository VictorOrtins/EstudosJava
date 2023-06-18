import java.util.ArrayList;
import java.util.List;

public class Consumer{
    public static void main(String[] args){
        List<Product> list = new ArrayList<Product>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        list.forEach( (product) -> product.setPrice(product.getPrice() * 1.1) );

        list.forEach(System.out::println);
    }
}