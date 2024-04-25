import java.util.*;

/*
Rectangle
By Andrew Martinus
Last modified on April 1, 2024
This program takes an input of the number of rows and columns and makes a rectangle out of stars with the given size
*/

public class Rectangle {
    public static void main(String[] args) {
        // declares the row and column variables and creates the scanner
        int rows, columns;
        Scanner sc = new Scanner(System.in);

        // gets an input of rows and columns
        System.out.print("Enter # of rows:  ");
        rows = (int) Math.round(Double.parseDouble(sc.nextLine()));
        System.out.print("Enter # of columns:  ");
        columns = (int) Math.round(Double.parseDouble(sc.nextLine()));
        // prints the rectangle based on the inputted dimensions
        for (int i = 1; i <= rows; i++){
            for (int j = 1; j <= columns; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}