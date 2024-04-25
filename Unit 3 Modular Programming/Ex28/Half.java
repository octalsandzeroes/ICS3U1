import java.util.*;

/*
Half
By Andrew Martinus
Last modified on April 19, 2024
This program prints out the length of a string the user enters
*/

public class Half{
    // main method
    public static void main(String[] args){
        // creates the scanner
        Scanner sc = new Scanner(System.in);
        String input;
        int strLength;

        // recieves a user string input and uses the substring method to split the string in half
        System.out.print("Enter a string: ");
        input = sc.nextLine();
        strLength = input.length();
        System.out.println(input.substring(0, strLength/2));
        System.out.println(input.substring(strLength/2, strLength));
    }
}