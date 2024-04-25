import java.util.*;

/*
Array1DOddEven
By Andrew Martinus
Last modified on April 17, 2024
This program recieves odd and even integers in a 1D array and declares if all are either odd or even
*/

public class Array1DOddEven {
    public static void main(String[] args) {
        // creates static variables for array length
        final int NUM_INTS = 10;
        
        // declares the the array and counter and creates the scanner
        int[] intArray = new int[NUM_INTS];
        int counter = 0;
        Scanner sc = new Scanner(System.in);

        // recieves integer inputs and checks the oddness and evenness of them
        for (int i = 0; i < NUM_INTS; i++){
            System.out.print("Enter an integer: ");
            intArray[i] = Integer.parseInt(sc.nextLine());
            if (intArray[i] % 2 == 0){
                counter++;
            }
        }

        // prints the result of the odd and even check
        switch (counter){
            case 0:
                System.out.println("All inputs were odd numbers.");
                break;
            case NUM_INTS:
                System.out.println("All inputs were even numbers.");
                break;
            default:
                break;
        }
    }
}