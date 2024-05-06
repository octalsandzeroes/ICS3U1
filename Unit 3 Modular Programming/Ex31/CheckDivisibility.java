import java.util.*;

/*
CheckDivisibility
By Andrew Martinus
Last modified on April 25, 2024
This program prompts the user for two values and prints out if the first is evenly divisible by the second
*/

public class CheckDivisibility{
    // main method
    public static void main(String[] args){
        // creates the scanner
        Scanner sc = new Scanner(System.in);
        int num, den;

        // recieves a user input for the dividend an divisor
        System.out.print("Enter the numerator: ");
        num = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the denominator: ");
        den = Integer.parseInt(sc.nextLine());
        if (evenlyDivisible(num, den)){
            System.out.printf("%d is perfectly divisible by %d", num, den);
        } else {
            System.out.printf("%d is not perfectly divisible by %d", num, den);
        }
        sc.close();
    }

    /*====================================================================
    |  boolean evenlyDivisible(int from, int to)                         |
    |--------------------------------------------------------------------|
    |  returns boolean - The boolean for whether it is evenly divisible  |
    |--------------------------------------------------------------------|
    |  int num - This parameter is the dividend                          |
    |--------------------------------------------------------------------|
    |  int den - This parameter is the divisor                           |
    |--------------------------------------------------------------------|
    |  This method checks whether a number is evenly divisible and then  |
    |  returns true or false                                             |
    ====================================================================*/
    public static boolean evenlyDivisible(int num, int den){
        boolean check = false;
        // runs a for loop to sum up the values
        if (num % den == 0){
            check = true;
        }
        return check;
    }
}