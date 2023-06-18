import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Readers {
    public static void main(String[] args) {
        String lines[] = new String[] {"Good Morning", "Good Afternoon", "Good Night"};

        String path = "teste2.txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){ //Se o segundo argumento for true, ele vai adicionar as coisas ao arquivo. Se não, o arquivo será recriado.
            for(String line : lines){
                bw.write(line);
                bw.newLine(); //Write não dá newline
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
