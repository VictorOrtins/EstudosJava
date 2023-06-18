import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Function {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<Product>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        //O método stream() transforma a lista numa stream. Pra retornar essa stream para uma lista,
        //é preciso chamar o método collect() e passando como argumento Collectors. a conversão para o tipo desejado
        List<String> names = list.stream().map( (product) -> product.getName().toUpperCase()).collect(Collectors.toList());

        names.forEach(System.out::println);
    }
}
