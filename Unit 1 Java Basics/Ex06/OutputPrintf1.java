package Ex06;

/*
OutputPrintf1
By Andrew Martinus
Last modified on Feb 20, 2024
This program prints the names of two people and lists their balances
*/

public class OutputPrintf1 {
    public static void main(String[] args) {
        double juanitasBalance = 2345678.99;
        double juansBalance = 15455.26;
        
        // prints a string with field width of 35, the balance with a fw of 12, 2 decimal places, and commas
        System.out.printf("%35s%,12.2f.%n", "Juanita's bank account balance is $", juanitasBalance);
        System.out.printf("%35s%,12.2f.%n", "Juan's bank account balance is $", juansBalance);
    }
}
