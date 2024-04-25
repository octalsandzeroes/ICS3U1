import java.util.*;

/*
Array2DOddEven
By Andrew Martinus
Last modified on April 17, 2024
This program recieves odd and even integers in a 2D array and declares a row has numbers that are all either odd or even
*/

public class Array2DOddEven {
    public static void main(String[] args) {
        // creates static variables for the row and column length
        final int ROWS = 3;
        final int COLUMNS = 3;

        // declares the the array and counter and creates the scanner
        int[][] intArray = new int[ROWS][COLUMNS];
        int[] counterArray = new int[ROWS];
        Scanner sc = new Scanner(System.in);

        // recieves integer inputs and checks the oddness and evenness of them
        for (int i = 0; i < ROWS; i++){
            counterArray[i] = 0;
            for (int j = 0; j < COLUMNS; j++){
                System.out.printf("Enter an integer for row %d, column %d: ", i, j);
                intArray[i][j] = Integer.parseInt(sc.nextLine());
                if (intArray[i][j] % 2 == 0){
                    counterArray[i]++;
                }
            }
        }

        // prints the result of the odd and even check
        for (int i = 0; i < ROWS; i++){
            switch (counterArray[i]){
                case 0:
                    System.out.printf("All inputs were odd for row %d.%n", i);
                    break;
                case COLUMNS:
                    System.out.printf("All inputs were even for row %d.%n", i);
                    break;
                default:
                    System.out.printf("Not all were either odd or even for row %d.%n", i);
                    break;
            }
        }
    }
}