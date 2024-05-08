import java.io.*;
import java.util.*;

/*
DivideLoop
By Andrew Martinus
Last modified on May 6, 2024
This program repeatedly asks for a numerator and a denominator repeatedly to evaluate a fraction until an exit code is typed
*/

public class DivideLoop {
    public static void main(String[] args) {
        // declares boolean program quit variable, numerator, denominator, and creates the scanner
        Scanner sc = new Scanner(System.in);
        String num, den;
        boolean quit = false;

            do{
                System.out.print("Enter the numerator: ");
                num = sc.nextLine();
                // if block to immediately quit if a q type character is detected as the first character
                if ((Character.toString(num.charAt(0)).compareToIgnoreCase("q") == 0)){
                    quit = true;
                } else {
                    try{
                        // if block to keep formatting of double/int input for the numerator
                        if (Double.parseDouble(num) == (int) Double.parseDouble(num)){
                            num = Integer.toString((int) Double.parseDouble(num));
                        } else {
                            num = Double.toString(Double.parseDouble(num));
                        }
                        
                        // if block to repeat the checks and formatting for the denominator
                        System.out.print("Enter the denominator: ");
                        den = sc.nextLine();
                        // if statement to keep formatting of double/int input
                        if (Double.parseDouble(den) == (int) Double.parseDouble(den)){
                            den = Integer.toString((int) Double.parseDouble(den));
                        } else {
                            den = Double.toString(Double.parseDouble(den));
                        }                            
                        
                        // prints the resultant string
                        System.out.printf("%s / %s is %f%n%n", num, den, Double.parseDouble(num)/Double.parseDouble(den));

                    } catch (NumberFormatException e){
                        System.out.println("You entered bad data.\nPlease try again.\n");
                    }
                }
            } while (quit == false);

        sc.close();
    }
}