import java.util.*;

/*
NumberSum
By Andrew Martinus
Last modified on April 1, 2024
This program takes multiple integer inputs and prints the sum of them
*/

public class NumberSum {
    public static void main(String[] args) {
        // declares input and initializes the evenNumber counter and creates the scanner
        int sum = 0, numInputs;
        double input;
        Scanner sc = new Scanner(System.in);

        // asks the user for the amount of integers they will enter
        System.out.println("How many integers will be added?");
        numInputs = Integer.parseInt(sc.nextLine());

        // a loop that runs for the previously set amount that sums up inputs
        for (int i = 1; i <= numInputs; i++){
            do {
                System.out.println("Enter an integer: ");
                input = Double.parseDouble(sc.nextLine());
                if (input%(int)input != 0 && (int)input != 0) {
                    System.out.println("That is not an integer, please retry.");
                }
            } while (input%(int)input != 0 && (int)input != 0);
            sum += input;
        }
        // prints the result
        System.out.printf("The sum is %d%n", sum);
    }
}