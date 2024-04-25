import java.util.*;

/*
StarTable
By Andrew Martinus
Last modified on April 15, 2024
This program creates a 2D array of stars with user specified rows and columns
*/

public class StarTable {
    public static void main(String[] args) {
        // declares the the array and size variables and creates the scanner
        String[][] starArray;
        int rows, columns;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        rows = (int) Math.round(Double.parseDouble(sc.nextLine()));
        System.out.print("Enter the number of columns: ");
        columns = (int) Math.round(Double.parseDouble(sc.nextLine()));

        starArray = new String[rows][columns];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                starArray[i][j] = "*";
                System.out.print(starArray[i][j]);
            }
            System.out.println();
        }
    }
}