import java.util.*;

/*
Alphabets
By Andrew Martinus
Last modified on April 1, 2024
This program takes multiple alphabet letter inputs and lists the amount of various letter types entered
*/

public class Alphabets {
    public static void main(String[] args) {
        // declares the input and initializes the counter variables for different letter types as well as and creates the scanner
        int uppercase = 0, lowercase = 0, vowels = 0;
        char input;
        Scanner sc = new Scanner(System.in);

        // runs a loop to read a char input and classify it
        do{
            System.out.print("Enter a letter: ");
            input = sc.nextLine().charAt(0);

            // checks for uppercase and then checks vowels
            if (input >= 65 && input <= 90){
                uppercase++;
                switch (input) {
                    case 'A':
                        vowels++;
                        break;
                    case 'E':
                        vowels++;
                        break;
                    case 'I':
                        vowels++;
                        break;
                    case 'O':
                        vowels++;
                        break;
                    case 'U':
                        vowels++;
                        break;
                    default:
                        break;
                }
            // checks for lowercase and then checks vowels
            } else if (input >= 97 && input <= 122) {
                lowercase++;
                switch (input) {
                    case 'a':
                        vowels++;
                        break;
                    case 'e':
                        vowels++;
                        break;
                    case 'i':
                        vowels++;
                        break;
                    case 'o':
                        vowels++;
                        break;
                    case 'u':
                        vowels++;
                        break;
                    default:
                        break;
                }
            }

        } while (input >= 65 && input <= 90 || input >= 97 && input <= 122);
        // prints the result
        System.out.printf("%nYou have entered %d upper case letters.", uppercase);
        System.out.printf("%nYou have entered %d lower case letters.", lowercase);
        System.out.printf("%nYou have entered %d vowels.%n", vowels);
    }
}