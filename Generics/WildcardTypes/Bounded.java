import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bounded{
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4);
        List<Double> doubleList = Arrays.asList(3.14, 6.28);
        List<Object> objList = new ArrayList<Object>();

        copy(intList, objList);
        printObjectList(objList);
        copy(doubleList, objList);
        printObjectList(objList);
        
    }

    public static void copy(List<? extends Number> source, List<? super Number> destination){
        for(Number number : source){
            destination.add(number); //Pode ser adicionado algum super de Number na lista de destino, porém,
            //pela incerteza dos tipos armazenados na lista, o get dela não pode ser armazenado numa variável
            //do tipo number

            //O contrário ocorre para a lista de source
        }
    }

    public static void printObjectList(List<Object> list){
        System.out.print("[ ");
        for(Object object : list){
            System.out.print(object + " ");
        }
        System.out.println("]");
    }
}