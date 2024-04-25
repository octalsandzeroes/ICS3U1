import java.util.Scanner;

/*
AgeCheck
By Andrew Martinus
Last modified on Mar 3, 2024
This program asks the user for their age and checks if they can vote or not
*/

public class AgeCheck {
    public static void main(String[] args) {
        // sets the legal voting age as a constant
        final int LEGAL_VOTING_AGE = 18;
        
        // creates the scanner and declares the age variable
        Scanner sc = new Scanner(System.in);
        int age;

        // asks the user for their age
        System.out.print("Enter your age: ");
        age = sc.nextInt();
        if (age < LEGAL_VOTING_AGE){ // checks the age and if not old enough, it says so and the amount of years to wait
            System.out.printf("Sorry, you are not old enough to vote, please wait for %d year(s) when you will be 18.%n", (LEGAL_VOTING_AGE-age));
        } else { // if old enough it prints that the user is old enough to vote
            System.out.println("OLD ENOUGH TO VOTE.");
        }
        
    }
}