import java.util.ArrayList;
import java.util.List;

public class Predicate{
    public static void main(String[] args) {
        List<Product> list = new ArrayList<Product>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        list.removeIf( (product) -> product.getPrice() >= 100);

        for(Product product : list){
            System.out.println(product);
        }

    }   
}   