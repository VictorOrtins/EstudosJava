import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exerc1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Type the .csv path you want me to analyze");
        String strPath = scan.nextLine();
        File file = new File(strPath);

        List<Product> products = new ArrayList<Product>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String temp_str = new String();
            String line[];
            Product temp_product;

            
            while(true){
                temp_str = br.readLine();

                if(temp_str == null){
                    break;
                }

                line = temp_str.split(",");
                // for(String line: line){
                //     line.trim();
                // }
                temp_product = new Product(line[0], Double.parseDouble(line[1]), Integer.parseInt(line[2]));
                products.add(temp_product);
            }
            strPath = file.getParent() + "\\out";

            System.out.println("strPath: " + strPath);
            boolean success = new File(strPath).mkdir();

            if(!success){
                System.out.println("Something went wrong!");
                System.exit(0);
            }

            strPath += "\\sumary.csv";
            System.out.println("strPath: " + strPath);
            BufferedWriter bw = new BufferedWriter(new FileWriter(strPath));

            for(Product product : products){
                bw.write(product.getName() + "," + product.totalValue());
                bw.newLine();
            }

            bw.close();
        }
        catch(IOException e){
            System.out.println("Unexpected error");
        }

        scan.close();
    }
}
