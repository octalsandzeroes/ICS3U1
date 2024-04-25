import java.util.*;

/*
StringLen
By Andrew Martinus
Last modified on April 19, 2024
This program prints out the length of a string the user enters
*/

public class StringLen{
    // main method
    public static void main(String[] args){
        // creates the scanner
        Scanner sc = new Scanner(System.in);
        String input;
        int strLength;

        // recieves a user string input 
        System.out.print("Enter a string: ");
        input = sc.nextLine();
        strLength = input.length();
        System.out.printf("Your string is %d characters long.%n", strLength);
    }
}