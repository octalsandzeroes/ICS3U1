import java.io.*;
import java.util.*;

/*
ReverseLines
By Andrew Martinus
Last modified on May 5, 2024
This program reads and prints out the lines in a file in reverse order
*/

public class ReverseLines{
    // main method
    public static void main(String[] args){
        // creates a file and scanner objects
        File inputFile = new File("reverse.txt");

        // declares the string array variable to store each read line
        String[] lineIn;

        // 
        try {
            Scanner sc = new Scanner(inputFile);
            lineIn = in.readLine();
            while (lineIn != null){
                System.out.println(lineIn);
                lineIn = in.readLine();
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Problem reading " + e.getMessage());
        }
        
        // reads and prints each line of
        try {

            BufferedReader in = new BufferedReader(new FileReader(FILE_NAME));
            lineIn = in.readLine();
            while (lineIn != null){
                System.out.println(lineIn);
                lineIn = in.readLine();
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Problem reading " + e.getMessage());
        }

    }
}