import java.util.*;

/*
Numbers
By Andrew Martinus
Last modified on April 5, 2024
This program reads six doubles, prints them in reverse order, adds 10% to each and prints all over 50
*/

public class Numbers {
    public static void main(String[] args) {
        // initializes the static variable that sets the amount of inputs
        final int NUM_INPUTS = 6;

        // declares the array variable and creates the scanner
        double doubleArray[] = new double[NUM_INPUTS];
        Scanner sc = new Scanner(System.in);

        // gathers the inputs
        for (int i = 0; i < NUM_INPUTS; i++){
            System.out.printf("Enter a double: ");
            doubleArray[i] = Double.parseDouble(sc.nextLine());
        }

        // prints the inputs in reverse order
        System.out.print("Your inputs in reverse order is: ");
        for (int i = NUM_INPUTS-1; i >= 0; i--){
            System.out.print(doubleArray[i]);
            if (i > 0){
                System.out.print(" ");
            }
        }

        // adds 10% to each input
        for (int i = 0; i < NUM_INPUTS; i++){
            doubleArray[i] *= 1.10;
        }

        // prints the values greater than 50
        System.out.print("\nThe inputs over 50 are: ");
        for (int i = 0; i < NUM_INPUTS; i++){
            if (doubleArray[i] > 50){
                System.out.print(doubleArray[i]);
                if (i != NUM_INPUTS-1){
                    System.out.print(" ");
                }
            }
        }
    }
}