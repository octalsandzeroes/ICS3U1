package Ex07;

import java.util.*;

/*
SimpleInterestPrincipal
By Andrew Martinus
Last modified on Feb 23, 2024
This program prompts for a final amount, time, and interest rate to calculate the required principal amount
*/

public class SimpleInterestPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double years; // Realistically you can have a non integer number of time
        double interest;
        double amount;
        double principal;
        
        System.out.print("Enter the final amount in dollars: $");
        amount = sc.nextDouble();
        System.out.print("Enter the interest rate in percent: ");
        interest = sc.nextDouble();
        System.out.print("Enter the amount of time in years: ");
        years = sc.nextDouble();
        // Since we are assuming an annual interest rate, it floors the year since you realistically cannot round up to get interest early 
        principal = (amount)/(1 + Math.floor(years) * (interest/100));
        System.out.printf("%nTo get $%,.2f after %.2f years, you would need to deposit an initial amount of $%,.2f.%n", amount, amount, principal);
    }
}
