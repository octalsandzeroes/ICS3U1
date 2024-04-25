import java.util.*;

/*
Limit
By Andrew Martinus
Last modified on April 1, 2024
This program takes an input N and prints the sum of the reciprocals of all integers up to N
*/

public class Limit {
    public static void main(String[] args) {
        // declares input and initializes the sum and creates the scanner
        double input, sum = 0;
        Scanner sc = new Scanner(System.in);

        // asks the user for N value to calculate to
        System.out.println("sum = 1.0/1 + 1.0/2 + 1.0/3 + 1.0/4 + 1.0/5 + .... + 1.0/N");
        System.out.println("\nEnter N");
        input = Double.parseDouble(sc.nextLine());

        System.out.print("sum = ");
        // calculates the value for the sum using a for loop to increment the denominator up to N
        for (int i = 1; i <= (int) input; i++){
            System.out.printf("1.0/%d", i);
            if (i != (int) input) System.out.print(" + ");
            sum += 1.0/i;
        }
        // prints the result
        System.out.println("\n\nSum is:  " + sum);
    }
}