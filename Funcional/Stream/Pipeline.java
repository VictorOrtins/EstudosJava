import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;

public class Pipeline {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,4,5,10,7, 9);

        Stream<Integer> stream = list.stream().map(x -> x * 10);
    
        System.out.println(Arrays.toString(stream.limit(10).toArray()));
    
        int sum = list.stream().reduce(0, (x , y) -> x + y);   
        System.out.println(sum);

        List<Integer> newList = list.stream().filter(x -> x % 3 == 0).map(x -> x * 10).toList();
        System.out.println(Arrays.toString(newList.toArray()));
    }
}
