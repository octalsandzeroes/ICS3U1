import java.util.*;

/*
Height
By Andrew Martinus
Last modified on Feb 27, 2024
This program asks the user their height in inches and outputs it in centimeters
*/

public class Height {
    public static void main(String[] args) {
        final double inchInCM = 2.54;

        Scanner sc = new Scanner(System.in);
        double heightInches;

        System.out.print("Enter your height in inches: ");
        heightInches = sc.nextDouble();

        System.out.printf("Your height in centimeters is %.2f", (inchInCM*heightInches));
    }
}