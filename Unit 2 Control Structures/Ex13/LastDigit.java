import java.util.*;

/*
LastDigit
By Andrew Martinus
Last modified on Mar 18, 2024
This program asks the user for an integer and prints the last letter in words
*/

public class LastDigit {
    public static void main(String[] args) {
        // initializes constant integers to store the word version of numbers
        final String[] numToWords = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        // creates the scanner and declares the input variable
        Scanner sc = new Scanner(System.in);
        double input;
        int digit;

        System.out.print("\nEnter an integer value: ");
        // gets the input and checks validity
        do{
            input = Double.parseDouble(sc.nextLine());
            if (input%(int)input!=0){
                System.out.print("That is not a valid input, please re-enter your value: ");
            }
        } while (input%(int)input!=0);
        // gets the last digit
        digit = (int) input % 10;

        // prints the sentence depending on the last digit
        switch ((int) digit){
            case 1:
                System.out.printf("The last digit of %d is %s.", (int) input, numToWords[1]);
                break;
            case 2:
                System.out.printf("The last digit of %d is %s.", (int) input, numToWords[2]);
                break;
            case 3:
                System.out.printf("The last digit of %d is %s.", (int) input, numToWords[3]);
                break;
            case 4:
                System.out.printf("The last digit of %d is %s.", (int) input, numToWords[4]);
                break;
            case 5:
                System.out.printf("The last digit of %d is %s.", (int) input, numToWords[5]);
                break;
            case 6:
                System.out.printf("The last digit of %d is %s.", (int) input, numToWords[6]);
                break;
            case 7:
                System.out.printf("The last digit of %d is %s.", (int) input, numToWords[7]);
                break;
            case 8:
                System.out.printf("The last digit of %d is %s.", input, numToWords[8]);
                break;
            case 9:
                System.out.printf("The last digit of %d is %s.", input, numToWords[9]);
                break;
            default:
                System.out.printf("The last digit of %d is %s.", input, numToWords[0]);
                break;
        }
    }
}