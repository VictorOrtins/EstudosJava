package Bonus;

import java.util.Scanner;

public class Bitwise{
    public static void main(String[] args) {

        int mask = 0b10000; //Criando uma máscara para a verificação do quinto bit. É estratégio usar números binários
        //de base 2

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        if((num & mask) == 0){ //Se o operador & de num e mask der 0, quer dizer que o quinto bit dos 2 números são diferentes, logo o quinto bit do número digitado é 0
            System.out.println("The 5th bit is 0");
        }
        else{ //Se der 1, quer dizer que o quinto bit dos 2 são iguais, logo ele é 1
            System.out.println("The 5th bit is 1"); 
        }

        scan.close();
    }
}