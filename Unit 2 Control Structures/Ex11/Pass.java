import java.util.Scanner;

/*
Pass
By Andrew Martinus
Last modified on Mar 3, 2024
This program asks the user to select a math problem and answer it, displaying if they got it right or not
*/

public class Pass {
    public static void main(String[] args) {
        // creates predetermined arrays of questions and another with the respective answers
        final String[] QUESTIONS = new String[] {"1 + 1 = ","324 * 9123 = ","20 * 20 - 16 = ","5 * 4 * 3 * 2 * 1 = ","25 - 55 + (85 + 65) = "};
        final String[] ANSWERS = new String[] {"2","2955852","384","120","120"};
        
        // declares the question choice and input variables and creates the scanner
        int choice;
        double input;
        Scanner sc = new Scanner(System.in);

        // gets the choice of question
        System.out.println("Choose a question to solve: [1] [2] [3] [4] [5]");
        choice = sc.nextInt();
        // checks the answer to the question and asks the user for another input if wrong
        do{
            System.out.print("\n" + QUESTIONS[choice-1]);
            input = sc.nextDouble();
            if (input != (Double.parseDouble(ANSWERS[choice-1]))){
                System.out.print("Sorry, that is not correct, please try again.");
            }
        } while(input != (Double.parseDouble(ANSWERS[choice-1])));
        // prints if correct
        System.out.println("\nThat's correct!");
        sc.close();
    }
}