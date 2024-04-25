import java.util.*;

/*
Power
By Andrew Martinus
Last modified on April 1, 2024
This program takes an input N and X and outputs the result of X^N
*/

public class Power {
    public static void main(String[] args) {
        // declares input and initializes the sum and creates the scanner
        double base, exponent, power = 1;
        Scanner sc = new Scanner(System.in);

        // asks the user for N value to calculate to
        System.out.println("Enter X:");
        base = Double.parseDouble(sc.nextLine());
        do {
            System.out.println("Enter N:");
            exponent = Double.parseDouble(sc.nextLine());
            if (exponent%(int)exponent!=0 && exponent <= 0){
                System.out.println("N must be a positive integer.");
            }
        } while (exponent%(int)exponent!=0 && exponent <= 0);
        // calculates the value of the power
        for (int i = 1; i <= (int)exponent; i++){
            power *= base;
        }
        // you can also just have done Math.pow(base, exponent);
        // prints out the resulting power
        System.out.printf("%n%f raised to the power %d is:  %f", base, (int)exponent, power);
    }
}