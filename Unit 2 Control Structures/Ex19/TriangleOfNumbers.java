import java.util.*;

/*
TriangleOfNumbers
By Andrew Martinus
Last modified on April 1, 2024
This program prints ever incrementing lines of numbers to form a triangle
*/

public class TriangleOfNumbers {
    public static void main(String[] args) {
        // creates a static variable for the number the triangle will increment to
        final int x = 5;

        /* the following code is for if the triangle is user dependant
        // declares the input variables and creates the scanner
        int x;
        Scanner sc = new Scanner(System.in);

        // gets an input for the number to increment to
        System.out.print("Enter the number to increment to:  ");
        x = (int) Math.round(Double.parseDouble(sc.nextLine()));
        */

        // prints the numbers
        for (int i = 1; i <= x; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}