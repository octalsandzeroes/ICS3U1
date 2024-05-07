import java.io.*;
import java.util.*;

/*
WriteLines
By Andrew Martinus
Last modified on May 5, 2024
This program asks the user to input 10 strings and then writes them on seperate lines to a file
*/

public class WriteLines{
    // main method
    public static void main(String[] args){
        // static variable for the file in focus
        final String FILE_NAME = "writeLines.txt";

        // creates the scanner and initializes the variable to store each line of user input
        Scanner sc = new Scanner(System.in);
        String lineOut;

        // recieves user input and writes them out to the file
        System.out.println("Enter 10 strings:");
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(FILE_NAME, true));
            for (int i = 1; i <= 10; i++){
                lineOut = sc.nextLine();
                out.write(lineOut + "\n");
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Problem writing " + e.getMessage());
        }

        sc.close();
    }
}