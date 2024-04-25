import java.util.*;

/*
Factors
By Andrew Martinus
Last modified on April 1, 2024
This program takes an input and finds all of its factors
*/

public class Factors {
    public static void main(String[] args) {
        // declares input and initializes the sum and creates the scanner
        double input;
        Scanner sc = new Scanner(System.in);

        // asks the user for a number to factor
        do {
            System.out.println("Enter the number you want to factor:");
            input = Double.parseDouble(sc.nextLine());
            if (input%(int)input!=0 && input <= 0){
                System.out.println("The input must be a positive integer!");
            }
        } while (input%(int)input!=0 && input <= 0);
        // creates the loop that cycles and prints out the factors
        System.out.printf("%nThe factors of %d are:%n", (int)input);
        for (int i = 1; i <= (int)input; i++){
            if (input % i == 0){
                System.out.println(i);
            }
        }
    }
}