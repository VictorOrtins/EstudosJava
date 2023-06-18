package Bonus;

public class FuncoesString {
    public static void main(String[] args) {
        String original = "abcde FGHIJ ABC abc DEFG";

        String s1 = original.toLowerCase();
        String s2 = original.toUpperCase();
        String s3 = original.trim();
        String s4 = original.substring(2);
        String s5 = original.substring(2, 9);
        String s6 = original.replace('a', 'x');
        String s7 = original.replace("abc", "xyz");

        int i = original.indexOf("bc");
        int j = original.lastIndexOf("bc");

        System.out.println("original = " + original);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3 + "-");
        System.out.println("s4 = " + s4);
        System.out.println("s5 = " + s5);
        System.out.println("s6 = " + s6);
        System.out.println("s7 = " + s7);
        System.err.println("i = " + i);
        System.out.println("j = " + j);

        String s = "potato apple lemon";

        String[] vect = s.split(" ");

        for (String c : vect){
            System.out.println(c);
        }
    }
}
