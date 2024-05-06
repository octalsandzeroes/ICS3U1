import java.util.*;

/*
Divide17
By Andrew Martinus
Last modified on April 19, 2024
This program prompts the user for two values, divides it by 17 and prints the result
*/

public class Divide17{
    // main method
    public static void main(String[] args){
        // initializes the static divisor
        final int DIVISOR = 17;

        // creates the scanner
        Scanner sc = new Scanner(System.in);
        String sumStr = "";
        double sumNum, result;
        

        // recieves a user string input
        System.out.print("Enter number one: ");
        sumStr += sc.nextLine();
        System.out.print("Enter number two: ");
        sumStr += sc.nextLine();
        sumNum = Double.parseDouble(sumStr);
        result = sumNum/DIVISOR;
        System.out.printf("%s / %d = %.2f", sumStr, DIVISOR, result);
        sc.close();
    }
}