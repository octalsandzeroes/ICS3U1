import java.util.*;

/*
Exponent
By Andrew Martinus
Last modified on April 19, 2024
This program prompts the user for a base and an exponent and prints out the result
*/

public class Exponent{
    // main method
    public static void main(String[] args){
        // creates the scanner object
        Scanner sc = new Scanner(System.in);
        double base, exponent, power;

        // recieves the variables
        System.out.print("Enter a base: ");
        base = Double.parseDouble(sc.nextLine());
        System.out.print("Enter an exponent: ");
        exponent = Double.parseDouble(sc.nextLine());

        // prints the resultant power
        power = Math.pow(base, exponent);
        System.out.printf("%f^%f = %f", base, exponent, power);
        sc.close();
    }
}