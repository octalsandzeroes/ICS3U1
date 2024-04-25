import java.util.*;

/*
TimeTable
By Andrew Martinus
Last modified on April 4, 2024
This program prints a chart of natural numbers, their square, and their cubes
*/

public class TimeTable {
    public static void main(String[] args) {
        // creates the scanner and the input variable
        Scanner sc = new Scanner(System.in);
        int input;

        // gets the nxn times table
        System.out.print("Enter a value to print a times table up to: ");
        input = sc.nextInt();

        System.out.printf("%n1 x %d through %d x %d timestable:%n", input, input, input);
        // prints the table
        for (int i = 1; i <= input; i++){
            System.out.printf("%d x %d = %d%n", i, input, i*input);
        }
    }
}