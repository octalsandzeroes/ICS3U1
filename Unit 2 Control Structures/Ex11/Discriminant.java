import java.util.Scanner;

/*
Discriminant
By Andrew Martinus
Last modified on Mar 6, 2024
This program asks the user to enter the values for a, b, c and checks for real roots
*/

public class Discriminant {
    public static void main(String[] args) {
        // creates the scanner and declares the user input variable
        Scanner sc = new Scanner(System.in);
        double discriminant;
        double a;
        double b;
        double c;

        // asks the user for the values of a, b, c
        System.out.println("Enter the values for a, b, and c.");
        System.out.print("a: ");
        a = sc.nextDouble();
        System.out.print("b: ");
        b = sc.nextDouble();
        System.out.print("c: ");
        c = sc.nextDouble();
        // finds the discriminant with the given values
        discriminant = Math.pow(b,2)-(4*a*c);
        // outputs the amount of roots based on the discriminant
        if (discriminant<0){
            System.out.println("No roots");
        } else if (discriminant>0) {
            System.out.println("Two roots");
        } else {
            System.out.println("One root");
        }
    }
}