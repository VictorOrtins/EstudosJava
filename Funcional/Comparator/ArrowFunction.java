import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrowFunction{
    public static void main(String[] args) {
        List<Product> list = new ArrayList<Product>();

        list.add(new Product("Notebook", 900.00));
        list.add(new Product("TV", 1200.00));
        list.add(new Product("Baby Doll", 400.00));

        //Isso aqui usa o compareTo da interface Comparable que fica dentro da classe
        //Não é o ideal porque, pra mudar a regra de sort, eu preciso ir na classe e alterá-la.

        Collections.sort(list);

        //Usar o Comparator já é um avanço, mas ter que criar uma classe só pra implementar um compare de uma clase
        //específica, o Product, volta pro mesmo problema de ter que ir numa classe para alterar as regras de negócio

        list.sort(new MyComparator());

        //Usar uma classe anônima tira todos os problemas acima, porém isso aqui ainda é bem mt verboso

        list.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
            }
        });

        //Uso de arrow functions deixa menos verboso
        //Note que não é preciso declarar a classe de p1 e p2, o compilador já infere as respectivas classes
        //por causa do tipo da lista

        list.sort( (Product p1, Product p2) -> {
            return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        });

        list.sort( (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

        for(Product p : list){
            System.out.println(p);
        }
    }
}