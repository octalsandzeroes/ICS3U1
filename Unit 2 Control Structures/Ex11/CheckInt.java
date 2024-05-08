import java.util.Scanner;

/*
CheckInt
By Andrew Martinus
Last modified on Mar 6, 2024
This program asks the user to enter an integer and checks its properties
*/

public class CheckInt {
    public static void main(String[] args) {
        // creates the scanner and declares the user input variable
        Scanner sc = new Scanner(System.in);
        int inputValue;

        // asks the user for an integer value
        System.out.print("Enter an integer: ");
        inputValue = sc.nextInt();
        System.out.println("\nYour integer is " + inputValue);
        // checks the range of the value and outputs the result
        if (inputValue<0){
            System.out.println("Your integer is negative!");
        } else if (inputValue>0) {
            System.out.println("Your integer is positive!");
        } else {
            System.out.println("Your input value is neither positive or negative!");
        }
        // checks to see if the number is off or even
        if (inputValue%2==0) {
            System.out.println("Your integer is an even number!");
        } else {
            System.out.println("Your integer is an odd number!");
        }
        // checks to see if the number is divisible by 7
        if (inputValue%7==0){
            System.out.println("Your number is a multiple of 7!");
        }
        sc.close();
    }
}