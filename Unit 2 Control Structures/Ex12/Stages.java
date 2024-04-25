import java.util.*;

/*
Stages
By Andrew Martinus
Last modified on Mar 18, 2024
This program asks the user to their age and catogorizes their place in human development
*/

public class Stages {
    public static void main(String[] args) {
        // creates constant integers to store the age brackets
        final int ADULT_AGE = 18;
        final int TEEN_AGE = 12;
        final int PRETEEN_AGE = 10;
        final int CHILD = 5;

        // creates the scanner and declares the input variable
        Scanner sc = new Scanner(System.in);
        double input;

        // asks the user for three positive integer values and will do so repeatedly if a wrong input is entered
        System.out.println("Enter your age in years.");
        do {
            input = Double.parseDouble(sc.nextLine());
            if (input < 0){
                System.err.println("That is not a positive value, please re-enter your age.");
            }
        } while (input < 0);
        
        // if block to check the age and categorize the human
        if (input > ADULT_AGE){
            System.out.println("adult");
        } else if (input > TEEN_AGE && input <= ADULT_AGE){
            System.out.println("teen");
        } else if (input > PRETEEN_AGE && input <= TEEN_AGE){
            System.out.println("preteen");
        } else if (input > CHILD && input <= PRETEEN_AGE){
            System.out.println("child");
        } else {
            System.out.println("toddler");
        }
    }
}