import java.util.*;

/*
TableOfNumbers
By Andrew Martinus
Last modified on April 1, 2024
This program takes an input of the x and y and makes a prints an incrementing set for numbers based on that
*/

public class TableOfNumbers {
    public static void main(String[] args) {
        // declares the y and x variables and creates the scanner
        int x, y;
        Scanner sc = new Scanner(System.in);

        // gets an input of x and y
        System.out.print("Enter x:  ");
        x = (int) Math.round(Double.parseDouble(sc.nextLine()));
        System.out.print("Enter y:  ");
        y = (int) Math.round(Double.parseDouble(sc.nextLine()));
        // prints the numbers based on the input
        for (int i = 1; i <= x; i++){
            for (int j = 1; j <= y; j++){
                System.out.print(j);
                if (j != y){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}