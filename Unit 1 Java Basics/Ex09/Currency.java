import java.util.*;

/*
Currency
By Andrew Martinus
Last modified on Feb 27, 2024
This program asks the user for a value in USD and outputs it in CAD
*/

public class Currency {
    public static void main(String[] args) {
        final double cadToUSD = 1.35;

        Scanner sc = new Scanner(System.in);
        double usDollar;

        System.out.print("Enter a value in USD: $");
        usDollar = sc.nextDouble();

        System.out.printf("In Canadian dollars, that is $%.2f", (usDollar*cadToUSD));
    }
}