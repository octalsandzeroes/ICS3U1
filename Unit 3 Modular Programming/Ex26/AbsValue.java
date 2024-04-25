import java.util.*;

/*
AbsValue
By Andrew Martinus
Last modified on April 19, 2024
This program prompts the user for a number and prints out the absolute value of it
*/

public class AbsValue{
    // main method
    public static void main(String[] args){
        // creates the scanner object
        Scanner sc = new Scanner(System.in);
        double value, absValue;

        // recieves the value
        System.out.print("Enter a number: ");
        value = Double.parseDouble(sc.nextLine());
        
        // prints the resultant abs value
        absValue = Math.abs(value);
        System.out.printf("|%f| = %f", value, absValue);
    }
}