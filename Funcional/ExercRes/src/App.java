import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        List<Product> list = new ArrayList<Product>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            String str_array[];

            while(line != null){
                str_array = line.split(",");
                list.add(new Product(str_array[0], Double.parseDouble(str_array[1])));
                line = br.readLine();
            }
            
            // List<Double> priceList = new ArrayList<Double>();
            // //Ver como fazer isso com stream em programação funcional
            // for(Product product : list){
            //     priceList.add(product.getPrice());
            // }
            //É só fazer o map, ele retorna um stream novo dado a função que foi colocada

            double averagePrice = list.stream().map( (product) -> product.getPrice()).reduce(0.0, (x, y) -> x + y) / list.size(); 
            System.out.format("Average Price: %f\n", averagePrice);

            list = list.stream().filter( (product) -> product.getPrice() < averagePrice).sorted( (p1, p2) -> -p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase())).collect(Collectors.toList());

            for(Product product : list){
                System.out.println(product.getName());
            }
        }
        catch(IOException e){

        }

        scan.close();
    }
}
