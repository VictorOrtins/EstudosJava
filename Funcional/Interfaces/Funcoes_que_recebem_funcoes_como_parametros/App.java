import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<Product>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        double sum = new ProductService().filteredSum(list, (product) -> product.getName().toUpperCase().charAt(0) == 'T');

        System.out.format("Sum: %.2f\n", sum);

        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book("Treasure", 900.00));
        bookList.add(new Book("Teste", 350.50));

        double bookSum = new ProductService().filteredSum(list, (book) -> book.getName().toUpperCase().charAt(0) == 'T');
        System.out.format("Sum: %.2f\n", bookSum);
    }
}
