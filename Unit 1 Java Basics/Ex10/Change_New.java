import java.util.Scanner;

/*
Change_New
By Andrew Martinus
Last modified on Feb 29, 2024
This program asks the user for a dollar amount and finds the minimum amount of coins needed to sum it up
*/

public class Change_New {
    public static void main(String[] args) {
        // declaring and initializing the constant values for the cents value of various denominations
        final int dollar = 100;
        final int toonie = 200;
        final int quarter = 25;
        final int dime = 10;
        final int nickel = 5;

        // creates the scanner and variables to store the number of coins of each denomination
        Scanner sc = new Scanner(System.in);
        double dollarInput;
        int centsValue;
        int numToonies = 0;
        int numLoonies = 0;
        int numQuarters = 0;
        int numDimes = 0;
        int numNickels = 0;
        
        // gets a dollar double amount of money as input
        System.out.print("Enter the amount in dollars: ");
        dollarInput = sc.nextDouble();
        // converts the double dollar value into an integer rounded cents value
        centsValue = (int) Math.round(dollarInput*dollar);
        
        // uses integer division to find the number of coins of each denomination and then modulos the cents value repeatedly to continue the process
        numToonies = centsValue/toonie;
        centsValue %= toonie;
        numLoonies = centsValue/dollar;
        centsValue %= dollar;
        numQuarters = centsValue/quarter;
        centsValue %= quarter;
        numDimes = centsValue/dime;
        centsValue %= dime;
        numNickels = centsValue/nickel;
        centsValue %= nickel;

        // outputs a recap of the calculations
        System.out.printf("The minimum number of coins is: %d%n", (numToonies+numLoonies+numQuarters+numDimes+numNickels+centsValue));
        System.out.printf("     Toonies: %d%n", numToonies);
        System.out.printf("     Loonies: %d%n", numLoonies);
        System.out.printf("     Quarters: %d%n", numQuarters);
        System.out.printf("     Dimes: %d%n", numDimes);
        System.out.printf("     Nickels: %d%n", numNickels);
        System.out.printf("     Leftover cents: %d%n", centsValue);
    }
}
