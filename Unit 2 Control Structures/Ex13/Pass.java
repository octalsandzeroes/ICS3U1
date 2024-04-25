import java.util.Scanner;

/*
Pass
By Andrew Martinus
Last modified on Mar 18, 2024
This program asks the user to solve a math problem with random values and operations (integer operations)
*/

public class Pass {
    public static void main(String[] args) {
        // initializes the random values, declares the input variable, and creates the scanner
        int num1 = (int) Math.round(Math.random()*3+1);
        int num2 = (int) Math.round(Math.random()*3+1);
        int operator = (int) Math.round(Math.random()*3+1);
        Scanner sc = new Scanner(System.in);
        int input;

        // prints the question and asks for an input until correct
        switch (operator){
            case 1:
                System.out.printf("What is int(" + num1 + " + " + num2 + ")?: ");
                do {
                    input = Integer.parseInt(sc.nextLine());
                    if (input != (num1 + num2)) {
                        System.out.print("Sorry, that is not correct, please try again: ");
                    }
                }while(input != (num1 + num2));
                break;
            case 2:
                System.out.printf("What is int(" + num1 + " - " + num2 + ")?: ");
                do {
                    input = Integer.parseInt(sc.nextLine());
                    if (input != (num1 - num2)) {
                        System.out.print("Sorry, that is not correct, please try again: ");
                    }
                }while(input != (num1 - num2));
                break;
            case 3:
                System.out.printf("What is int(" + num1 + " * " + num2 + ")?: ");
                do {
                    input = Integer.parseInt(sc.nextLine());
                    if (input != (num1 * num2)) {
                        System.out.print("Sorry, that is not correct, please try again: ");
                    }
                }while(input != (num1 * num2));
                break;
            default:
                System.out.printf("What is int(" + num1 + " / " + num2 + ")?: ");
                do {
                    input = Integer.parseInt(sc.nextLine());
                    if (input != (num1 / num2)) {
                        System.out.print("Sorry, that is not correct, please try again: ");
                    }
                }while(input != (num1 / num2));
                break;
        }
        System.out.println("\nThat's correct!");
    }
}