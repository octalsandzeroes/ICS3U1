import java.util.*;

/*
SelfReverse
By Andrew Martinus
Last modified on April 9, 2024
This program creates an array of length 10 with user inputs and reverses it
*/

public class TwoLargest {
    public static void main(String[] args) {
        // initializes the static variable that sets the number of elements
        final int ARRAY_LENGTH = 10;

        // declares the the array and address variables and creates the scanner
        int[] randomArray = new int[ARRAY_LENGTH];
        int address;
        Scanner sc = new Scanner(System.in);

        // assigns a user input to each index in the array
        for (int i = 0; i < ARRAY_LENGTH; i++){
            System.out.print("Enter a numerical value: ");
            randomArray[i] = (int) Math.round(Double.parseDouble(sc.nextLine()));
        }

        // prints out the array as is
        System.out.println("\nNormal:");
        for (int i : randomArray){
            System.out.print(i + " ");
        }

        // rearranges the array
        for (int j = ARRAY_LENGTH-1; j >= ARRAY_LENGTH/2; j--){
            address = randomArray[j];
            randomArray[j] = randomArray[(ARRAY_LENGTH-1)-j];
            randomArray[(ARRAY_LENGTH-1)-j] = address;
        }

        // prints out the array after the reversal
        System.out.println("\nReversed:");
        for (int i = 0; i < ARRAY_LENGTH; i++){
            System.out.print(randomArray[i] + " ");
        }
    }
}