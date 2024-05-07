import java.io.*;
import java.util.*;

/*
WriteChars
By Andrew Martinus
Last modified on May 5, 2024
This program asks for user input until "stop" is entered, then writes each character entered to a file on seperate files
*/

public class WriteChars{
    // main method
    public static void main(String[] args){
        // static variable for the file in focus
        final String FILE_NAME = "writeChars.txt";

        // creates the scanner and initializes the variable to store each line of user input
        Scanner sc = new Scanner(System.in);
        String input, output = "";

        // reads and prints each line of
        System.out.println("Enter as many inputs as you like, enter stop to finish inputting.");
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(FILE_NAME, true));
            // recieves  user inputs
            do{
                input = sc.nextLine();
                if (input.compareToIgnoreCase("stop") != 0){
                    output += input;
                }
            } while (input.compareToIgnoreCase("stop") != 0);

            // writes out each character to the file in focus
            for (int i = 0; i < output.length(); i++){
                out.write(output.charAt(i));
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Problem writing " + e.getMessage());
        }

        sc.close();
    }
}