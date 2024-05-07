import java.util.*;

/* 
 Class Header Block
 Program Name:
 Name:
 Date created/Last modified on:
 Summary of program: 
*/

// curly brackets should like up vertically or should start with the opening line
public class CodingStyle { // Classes start with capitals, variables dont
    public static void main(String[] args) {
        // always declare variables at the start of the main class
        double example1;
        double example2;
        String stest;
        int ntest;
        double dtest;

        // creates a scanner object
        Scanner scannerObject = new Scanner(System.in);

        // seperate code into 'paragraphs' using line breaks - demonstrates how variables are assigned values
        example1 = 2;
        example2 = example1*2;
        System.out.println("Assign it once: " + example2);
        example1 = 3;
        System.out.println("Assign a new value to a used variable: " + example2);
        example2 = example1*2;
        System.out.println("Reassign example2: " + example2 + "\n");

        // this demonstrates the use of scanner
        System.out.print("Enter username: ");
        stest = scannerObject.nextLine(); // this uses the scanner var to read and store a string value

        System.out.print("Enter user age: ");
        ntest = scannerObject.nextInt(); // this uses the scanner var to read and store one int value
        
        System.out.println("\nUsername is: " + stest);
        System.out.println("User age is: " + ntest);

        dtest = scannerObject.nextDouble(); // scanner has more than just nextLine and nextInt
        System.out.println(dtest);

        scannerObject.close();
    }
}
