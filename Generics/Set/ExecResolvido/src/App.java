import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Set<UserLog> set = new HashSet<UserLog>();
        String path = "C:\\temp\\in.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String file_str = br.readLine();
            String line[];
            UserLog log;

            while(file_str != null){
                line = file_str.split(" ");

                log = new UserLog(line[0], Instant.parse(line[1]));
                set.add(log);

                file_str = br.readLine();
            }

            System.out.println("Total users: " + set.size());
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
