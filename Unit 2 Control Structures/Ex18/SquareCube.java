import java.util.*;

/*
SquareCube
By Andrew Martinus
Last modified on April 1, 2024
This program takes an input N and prints the sum of the squares and cubes of 1 through N
*/

public class SquareCube {
    public static void main(String[] args) {
        // declares input and initializes the sum and creates the scanner
        double input;
        int sum = 0;
        Scanner sc = new Scanner(System.in);

        // asks the user for N value to calculate to
        System.out.println("\nUpper Limit:");
        input = Double.parseDouble(sc.nextLine());

        // calculates the value for the square sum using a for loop to increment the denominator up to N
        // if the user enters a double it forces it into an int
        for (int i = 1; i <= (int) input; i++){
            sum += (int) Math.pow(i, 2);
        }
        // prints the result for the squares
        System.out.printf("%nThe sum of Squares is %d", sum);

        sum = 0;

        // calculates the value for the cube sum using a for loop to increment the denominator up to N
        for (int i = 1; i <= (int) input; i++){
            sum += (int) Math.pow(i, 3);
        }
        // prints the result for the cubes
        System.out.printf("%nThe sum of Cubes is %d%n", sum);
    }
}