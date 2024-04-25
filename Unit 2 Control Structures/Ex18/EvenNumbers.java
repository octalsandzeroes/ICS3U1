import java.util.*;

/*
Alphabets
By Andrew Martinus
Last modified on April 1, 2024
This program takes multiple integer inputs and lists the amount of even numbers entered
*/

public class EvenNumbers {
    public static void main(String[] args) {
        // declares input and initializes the evenNumber counter and creates the scanner
        int evenNumbers = 0;
        double input;
        Scanner sc = new Scanner(System.in);

        // runs a loop to read an integer and increase the counter if it is even
        do{
            System.out.print("Enter an integer: ");
            input = Double.parseDouble(sc.nextLine());

            if (input%(int)input == 0 && (int)input%2 == 0){
                evenNumbers++;
            }

        } while (input > 0 && input%(int)input == 0);
        // prints the result
        System.out.printf("You have entered %d even numbers.%n", evenNumbers);
    }
}