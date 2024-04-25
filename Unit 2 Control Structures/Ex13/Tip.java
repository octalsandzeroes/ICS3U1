import java.util.*;

/*
Tip
By Andrew Martinus
Last modified on Mar 18, 2024
This program asks the user for a letter grade and prints a comment in return
*/

public class Tip {
    public static void main(String[] args) {
        // creates the scanner and declares the input variable
        Scanner sc = new Scanner(System.in);
        char character;

        System.out.print("\nYour letter grade: ");
        // gets the input and checks validity
        do{
            character = sc.nextLine().charAt(0);
            System.out.println(character);
            if (character != 'A' && character != 'B' && character != 'C' && character != 'D' && character != 'F'){
                System.out.print("That is not a valid input, please re-enter your grade: ");
            }
        } while (character != 'A' && character != 'B' && character != 'C' && character != 'D' && character != 'F');

        // prints the sentence depending on the grade
        switch (character){
            case 'A':
                System.out.printf("Why not S+? Study harder.");
                break;
            case 'B':
                System.out.printf("Decent. Keep it up.");
                break;
            case 'C':
                System.out.printf("I mean, it's okay I guess... Practice more.");
                break;
            case 'D':
                System.out.printf("Sheesh. You should probably actually study.");
                break;
            default:
                System.out.printf("You have cancer. Retake the course.");
                break;
        }
    }
}