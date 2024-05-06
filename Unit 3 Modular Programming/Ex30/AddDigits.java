import java.util.*;

/*
AddDigits
By Andrew Martinus
Last modified on April 19, 2024
This program prompts the user for an integer value and prints the sum of each digit in the number
*/

public class AddDigits{
    // main method
    public static void main(String[] args){
        // creates the scanner
        Scanner sc = new Scanner(System.in);
        String strInput, sumStr = "";
        int intLength, sum = 0;

        // recieves a user string input
        System.out.printf("%-13s","Input:");
        strInput = sc.nextLine();
        intLength = strInput.length();
        for (int i = 0; i < intLength; i++){
            sum += Integer.parseInt(strInput.substring(i, i+1));
        }
        // prints the output sum
        System.out.printf("%-13s%d%n","Output:", sum);
        // prints the mathematical expression
        sumStr += "(";
        for (int i = 0; i < intLength; i++){
            sumStr += strInput.charAt(i);
            if (i != intLength-1){
                sumStr += "+";
            }
        }
        sumStr += ")";
        System.out.printf("%13s%s%n", "", sumStr);
        sc.close();
    }
}