package Ex07;

import java.util.*;

/*
Energy
By Andrew Martinus
Last modified on Feb 21, 2024
This program prompts the user for a value in cents and prints the minimum about of coins needed to match it
*/

public class Change {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int centsValue;
        int centsRemainder;
        int toonies = 0;
        int loonies = 0;
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int cents = 0;

        System.out.print("Enter the amount (in cents): ");
        centsValue = sc.nextInt();
        
        toonies = centsValue/200;
        centsValue %= 200;
        loonies = centsValue/100;
        centsValue %= 100;
        quarters = centsValue/25;
        centsValue %= 25;
        dimes = centsValue/10;
        centsValue %= 10;
        nickels = centsValue/5;
        centsValue %= 5;
        cents = centsValue;

        System.out.printf("The minimum number of coins is: %d%n", (toonies+loonies+quarters+dimes+nickels+cents));
        System.out.printf("     Toonies: %d%n", toonies);
        System.out.printf("     Loonies: %d%n", loonies);
        System.out.printf("     Quarters: %d%n", quarters);
        System.out.printf("     Dimes: %d%n", dimes);
        System.out.printf("     Nickels: %d%n", nickels);
        System.out.printf("     Leftover cents: %d%n", cents);
    }
}
