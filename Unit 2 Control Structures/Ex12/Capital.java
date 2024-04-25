import java.util.*;

/*
Capital
By Andrew Martinus
Last modified on Mar 18, 2024
This program asks the user to enter the capital of Canada
*/

public class Capital {
    public static void main(String[] args) {
        // creates constant string
        final String CAPITAL = "Ottawa";

        // creates the scanner and declares input variable
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.print("Enter the capital of Canada: ");
        do {
            input = sc.nextLine();

            /*
            string are arrays, and how they work is that the array variable itself stores the location in memory of the addresses containing the array/strings value
            thus doing string1 = string2 sets string1 to store the address location string2 is also storing
            but doing string1 = "value equal to string 1" creates a new array stored at a different memory location
            so, in order to compare strings use [string1name].equals([string2name]) or equalsIgnoreCase()
            */
            if (!input.equalsIgnoreCase(CAPITAL)){
                System.out.print("That is not correct, please retry:");
            }
        } while (!input.equalsIgnoreCase(CAPITAL));
        System.out.println("That's correct!");
    }
}