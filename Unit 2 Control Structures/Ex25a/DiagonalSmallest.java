import java.util.*;

/*
DiagonalSmallest
By Andrew Martinus
Last modified on April 17, 2024
This program recieves integers in a 2D array prints out the integer
*/

public class DiagonalSmallest {
    public static void main(String[] args) {
        // declares the the array and rows and column size, smallest value, and creates the scanner
        int intArray[][], smallestArray[];
        int rowsAndColumns, smallestValue;
        Scanner sc = new Scanner(System.in);

        // initializes the array
        System.out.print("Enter the size of the square array: ");
        rowsAndColumns = (int) Math.round(Double.parseDouble(sc.nextLine()));
        intArray = new int[rowsAndColumns][rowsAndColumns];
        smallestArray = new int[rowsAndColumns];
        System.out.println();
         
        // recieves integer inputs and checks the oddness and evenness of them
        for (int i = 0; i < rowsAndColumns; i++){
            for (int j = 0; j < rowsAndColumns; j++){
                System.out.printf("Enter an integer for row %d, column %d: ", i+1, j+1);
                intArray[i][j] = Integer.parseInt(sc.nextLine());
            }
        }

        // prints out the array
        System.out.println("\nYour array is:");
        for (int i = 0; i < rowsAndColumns; i++){
            for (int j = 0; j < rowsAndColumns; j++){
                System.out.print(intArray[i][j] + " ");
            }
            System.out.println();
        }

        // makes an array for the smallest value for each diagonal in each row
        for (int i = 0; i < rowsAndColumns; i++){
            smallestArray[i] = Math.min(intArray[i][i], intArray[i][rowsAndColumns-i-1]);
        }
        // finds the smallest values out of the array of smallest values
        smallestValue = smallestArray[0];
        for (int i = 1; i < rowsAndColumns; i++){
            smallestValue = Math.min(smallestArray[i], smallestValue);
        }
        System.out.println("\nThe smallest value in the diagonals is: " + smallestValue);
        
    }
}