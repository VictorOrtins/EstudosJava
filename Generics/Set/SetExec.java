import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExec{
    public static void main(String[] args) {
        Set<String> hash = new HashSet<String>(); //Mais eficiente, porém não mantém nenhuma ordem
        Set<String> linked = new LinkedHashSet<String>(); //Intermediário, mantém a ordem de "entrada"
        Set<String> tree = new TreeSet<String>(); //Menos eficiente, mas mantém a ordem do compareTo do objeto em que
        //o set foi parametrizado

        hash.add("TV");
        hash.add("Journal");
        hash.add("Notebook");

        linked.add("TV");
        linked.add("Journal");
        linked.add("Notebook");

        tree.add("TV");
        tree.add("TElevision");
        tree.add("Journal");
        tree.add("AAAA");
        tree.add("Notebook");

        tree.removeIf(x -> x.charAt(0) == 'T'); //Uso de predicados para remover elementos do Set

        System.out.println("----- HASH -----");
        for(String string : hash){
            System.out.println(string);
        }

        System.out.println("----- LINKED -----");
        for(String string : linked){
            System.out.println(string);
        }

        System.out.println("----- TREE -----");
        for(String string : tree){
            System.out.println(string);
        }

        Set<Integer> a = new TreeSet<Integer>(Arrays.asList(0,2,4,6,8,10));
        Set<Integer> b = new TreeSet<Integer>(Arrays.asList(5,6,7,8,9,10));

        //O conjunto C é formado da união do conjunto A com o conjunto B
        Set<Integer> c = new TreeSet<Integer>(a);
        c.addAll(b);
        System.out.println("----- CONJUNTO C -----");
        System.out.println(c);

        //O conjunto D é formado da intersecção do conjunto A com B
        Set<Integer> d = new TreeSet<Integer>(a);
        d.retainAll(b);
        System.out.println("----- CONJUNTO D -----");
        System.out.println(d);

        //O conjunto E é formado da diferença entre os conjuntos A e B
        //Diferença é quase que o contrário da intersecção. O set final tem que ter os elementos que estão
        //em A e que, ao mesmo tempo, não estão em B















        
        Set<Integer> e = new TreeSet<Integer>(a);
        e.removeAll(b);
        System.out.println("----- CONJUNTO D -----");
        System.out.println(e);


    }
}