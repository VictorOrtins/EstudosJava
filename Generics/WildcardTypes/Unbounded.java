import java.util.Arrays;
import java.util.List;

public class Unbounded {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("Maria", "João");
        List<Character> charList = Arrays.asList('a','b','c');
        List<Product> prodList = Arrays.asList(new Product("Book", 1000), new Product("Mouse", 2102), new Product("Joystick", 954));

        printList(strList);
        printList(prodList);
        printList(charList);
    }

    public static void printList(List<?> list){
        System.out.print("[ ");
        for(Object obj : list){
            System.out.print(obj + " ");            
        }
        System.out.println("]");
    }
}
