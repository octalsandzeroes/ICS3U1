import java.util.*;

/*
PythagoreanTriples
By Andrew Martinus
Last modified on April 1, 2024
This program receives a positive integer and finds all pythagorean triples where it is the greatest number
*/

public class PythagoreanTriples {
    public static void main(String[] args) {
        // declares the input variable, the triples and creates the scanner
        int c, b, a;
        double input;
        Scanner sc = new Scanner(System.in);

        // recieves a valid user input for c
        do {
            System.out.print("Enter a positive integer: ");
            input = Double.parseDouble(sc.nextLine());
            if ((input <= 0 || input%(int)input != 0)){
                System.out.println("That is not a valid input.");
            }
        } while (input <= 0 || input%(int)input != 0);
        c = (int) input;

        System.out.println("\nThe pythagorean triples are:");
        // discovers and prints the triples
        for (int i = c; i > 0; i--){
            for (int j = i; j > 0; j--){
                a = j;
                b = i;
                if (Math.pow(c,2) == Math.pow(b,2) + Math.pow(a,2)){
                    System.out.printf("%d^2 + %d^2 = %d^2%n", a, b, c);
                }
            }
        }
    }
}