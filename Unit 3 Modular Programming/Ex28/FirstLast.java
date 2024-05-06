import java.util.*;

/*
FirstLast
By Andrew Martinus
Last modified on April 19, 2024
This program recieves a string from the user and outputs the first and last characters in the string
*/

public class FirstLast{
    // main method
    public static void main(String[] args){
        // creates the scanner
        Scanner sc = new Scanner(System.in);
        String input;
        int strLength;

        // recieves a user string input and prints the first and last characters
        System.out.print("Enter a string: ");
        input = sc.nextLine();
        strLength = input.length();
        System.out.printf("First character: %c%nLast character: %c%n", input.charAt(0), input.charAt(strLength-1));
        sc.close();
    }
}