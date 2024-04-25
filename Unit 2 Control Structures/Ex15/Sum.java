import java.util.*;

/*
Sum
By Andrew Martinus
Last modified on Mar 21, 2024
This program asks the user for integer values and prints the sum if a negative number is printed
*/

public class Sum {
    public static void main(String[] args) {
        // creates the scanner and declares the input variable
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int input;

        System.out.println("Enter as many integers as you like, enter a negative value to print the sum: ");
        // gets the input and sums it up
        do{
            input = Integer.parseInt(sc.nextLine());
            if (input > 0){
                sum += input;
            }
        } while (input >= 0);

        System.out.println("The sum of your inputs is: " + sum);
    }
}