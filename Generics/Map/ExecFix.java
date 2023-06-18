import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ExecFix{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter full file path: ");

        Map<String, Integer> poll = new LinkedHashMap<String, Integer>();

        String path = scan.nextLine();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            String lineArray[];
            Integer currentValue;
            while(line != null){
                lineArray = line.split(",");
                currentValue = poll.get(lineArray[0]);

                if(currentValue == null){
                    currentValue = 0;
                }

                poll.put(lineArray[0], currentValue + Integer.parseInt(lineArray[1]));
                line = br.readLine();
            }

            for(String key : poll.keySet()){
                System.out.println(key + ": " + poll.get(key));
            }
        }   
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        scan.close();
    }
}