import java.util.Collections;
import java.util.List;

public class CalculationService{

    public static <T extends Comparable<? super T>> T max(List<T> list){
        return Collections.max(list);
    }
}
