import java.util.Scanner;

/*
Pass
By Andrew Martinus
Last modified on Mar 18, 2024
This program asks the user to solve a math problem with random values
*/

public class Pass {
    public static void main(String[] args) {
        // initializes the random values, declares the input variable, and creates the scanner
        int num1 = (int) Math.round(Math.random()*10);
        int num2 = (int) Math.round(Math.random()*10);
        double input;
        Scanner sc = new Scanner(System.in);

        // gets the choice of question
        System.out.println("What is " + num1 + " + " + num2 + "?");
        // checks the answer to the question and asks the user for another input if wrong
        do{
            input = sc.nextInt();
            if (input != (num1 + num2)){
                System.out.print("Sorry, that is not correct, please try again.");
            }
        } while(input != (num1 + num2));
        // prints if correct
        System.out.println("\nThat's correct!");
    }
}