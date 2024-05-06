import java.util.*;

/*
Alphabetical
By Andrew Martinus
Last modified on April 19, 2024
This program prompts the user for two string inputs and compares them alphabetically
*/

public class Alphabetical{
    // main method
    public static void main(String[] args){
        // creates the scanner
        Scanner sc = new Scanner(System.in);
        String str1, str2;
        int compareStr;

        // recieves user string inputs and compares the inputs alphabetically 
        System.out.print("Enter a string: ");
        str1 = sc.nextLine();
        System.out.print("Enter another string: ");
        str2 = sc.nextLine();
        compareStr = str1.compareTo(str2);
        if (compareStr < 0){
            System.out.printf("\"%s\"a is alphabetically first compared to \"%s\"%n", str1, str2);    
        } else if (compareStr > 0){
            System.out.printf("\"%s\" is alphabetically last compared to \"%s\"%n", str1, str2);    
        } else {
            System.out.printf("\"%s\" is alphabetically equal to \"%s\"%n", str1, str2);    
        }
        sc.close();
    }
}