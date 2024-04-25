import java.util.*;

/*
DigitSum
By Andrew Martinus
Last modified on Feb 15, 2024
This program asks the user for a three-digit number and prints the sum of its digits
*/

public class DigitSum {
    public static void main(String[] args) {
        String num;
        int numDigits;
        char pointer;
        int sum = 0;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        num = sc.nextLine();

        // for the length of the inputted number (string), get each character
        for (int i = 0; i < num.length(); i++) {
            pointer = num.charAt(i);
            if (pointer != '.'){
                sum = sum + (pointer-48); // since a char is in ASCII, apply an offset to it to get it in decimal number form
            }
        }

        System.out.printf("%nThe sum of the digits in %s is %d%n", num, sum);
    }
}