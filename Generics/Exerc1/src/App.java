import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Product> list = new ArrayList<Product>();
        String path = "C:\\temp\\generics.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            String array[];
            Product temp_product;

            while(line != null){
                array = line.split(",");

                temp_product = new Product(array[0], Double.parseDouble(array[1]));
                list.add(temp_product);

                line = br.readLine();
            }

            System.out.println("Most Expensive: ");
            System.out.println(CalculationService.max(list));
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
