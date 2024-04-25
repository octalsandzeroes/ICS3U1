import java.util.*;

/*
Unicode
By Andrew Martinus
Last modified on Mar 21, 2024
This program prints unicode characters
*/

public class Unicode {
    public static void main(String[] args) {
        // creates a constant integer to store the upper bounds of the print out
        final int unicodeTo = 212;

        // creates the scanner and declares the counter variable
        Scanner sc = new Scanner(System.in);
        int i = 1;
        char unicode;

        // a do while loop to increment the counter and print the characters
        System.out.printf("%s%5s%-7s%n", "Char", "", "Unicode");
        do {
            unicode = (char) i;
            System.out.printf("%-9d%-7c%n", i, unicode);
            i++;
        } while (i <= unicodeTo);
    }
}