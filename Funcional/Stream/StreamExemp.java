import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamExemp{
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,4,5,10,7);

        Stream<Integer> stream = list.stream().map(x -> x * 10);

        System.out.println(Arrays.toString(stream.toArray()));

        Stream<String> stream2 = Stream.of("Maria", "Alex", "Bob");
        System.out.println(Arrays.toString(stream2.toArray()));

        Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2);
        System.out.println(Arrays.toString(stream3.limit(10).toArray()));

        Stream<Long> fibonacci = Stream.iterate(new Long[] {0L, 1L} , tupla -> new Long[] {tupla[1], tupla[0] + tupla[1]}).map(tupla -> tupla[0]);
        System.out.println(Arrays.toString(fibonacci.limit(10).toArray()));

    }
}