import java.util.*;

/*
CountInt1
By Andrew Martinus
Last modified on Mar 21, 2024
This program asks the user for integer values and prints the number of numbers entered if once the end input is entered
*/

public class CountInt1 {
    public static void main(String[] args) {
        // creates the final int for the exit code
        final int exit = -1;

        // creates the scanner and declares the input variable
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int input;

        System.out.println("Enter as many integers as you like, enter a \"-1\" to print the number of numbers entered: ");
        // gets an integer input and increases a counter while the input is not -1
        do{
            input = Integer.parseInt(sc.nextLine());
            if (input != exit){
                count++;
            }
        } while (input != exit);
        // prints the number of numbers
        System.out.println("You inputed " + count + " numbers.");
    }
}