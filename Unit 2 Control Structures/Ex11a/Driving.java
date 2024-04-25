import java.util.Scanner;

/*
Driving
By Andrew Martinus
Last modified on Mar 6, 2024
This program asks the user for their age and checks if they are able to drive or not
*/

public class Driving {
    public static void main(String[] args)
    {
        // sets the minimum and maximum ages
        final int MAX_AGE = 75;
        final int MIN_AGE = 18;

        // creates the scanner and declares the age variable
        double age;
        Scanner sc = new Scanner(System.in);

        // gets a user input for age
        System.out.print("Enter your age: ");
        age = sc.nextDouble();
        // checks to see if it is within range or passing
        if (age < MIN_AGE){
            System.out.println("Too young to drive.");
        } else if (age > MAX_AGE){
            System.out.println("Sorry you are over the legal age limit for driving.");
        } else {
            System.out.println("Age: " + age + "\nAge OK. Have you got a driver's licence?");
        }
    }
}
