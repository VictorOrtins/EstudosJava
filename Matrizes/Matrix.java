package Matrizes;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        int rows, columns;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of rows desired: ");
        rows = scan.nextInt();
        System.out.print("Type the number of columns that you want: ");
        columns = scan.nextInt();

        Integer matrix[][] = new Integer[rows][columns];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                //System.out.println("Enter the integer at position " + i + "," + j + ": ");
                matrix[i][j] = scan.nextInt();
            }
        }

        int num;
        System.out.println("Tell me the number you want to search: ");
        num = scan.nextInt();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(matrix[i][j] == num){
                    System.out.println("Position " + i + "," + j);
                    if(j - 1 >= 0){
                        System.out.println("Left: " + matrix[i][j - 1]);
                    }

                    if(j + 1 < columns){
                        System.out.println("Right: " + matrix[i][j + 1]);
                    }

                    if(i - 1 >= 0){
                        System.out.println("Up: " + matrix[i - 1][j]);
                    }

                    if(i + 1 < rows){
                        System.out.println("Down: " + matrix[i + 1][j]);
                    }

                }
            }
        }

        scan.close();
    }
}
