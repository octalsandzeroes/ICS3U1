package Ex07;

import java.util.*;

/*
SimpleInterestAmount
By Andrew Martinus
Last modified on Feb 23, 2024
This program prompts for a principal amount, time, and interest rate to calculate the final amount
*/

public class SimpleInterestAmount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double years; // Realistically you can have a non integer number of time
        double interest;
        double amount;
        double principal;
        
        System.out.print("Enter the principal amount in dollars: $");
        principal = sc.nextDouble();
        System.out.print("Enter the interest rate in percent: ");
        interest = sc.nextDouble();
        System.out.print("Enter the amount of time in years: ");
        years = sc.nextDouble();
        // Since we are assuming an annual interest rate, it floors the year since you realistically cannot round up to get interest early 
        amount = principal * (1 + Math.floor(years) * (interest/100));
        System.out.printf("%nAfter %.2f years, you would have a total of $%,.2f from a principal amount of $%,.2f.%n", years, amount, principal);
    }
}
