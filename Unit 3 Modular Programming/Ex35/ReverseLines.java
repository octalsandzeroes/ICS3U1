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

        // initializes the lineIn array with the first line of the file and stores each line from the file and prints them in reverse
        try {
            Scanner sc = new Scanner(inputFile);
            lineIn = new String[Integer.parseInt(sc.nextLine())];
            for (int i = lineIn.length-1; i >= 0; i--){
                lineIn[i] = sc.nextLine();
            }
            for (int i = 0; i < lineIn.length; i++){
                System.out.println(lineIn[i]);
            }
        } catch (InputMismatchException e){
            System.out.println("\nNon-integer data detected. File read terminated!");
        } catch (IOException e) {
            System.out.println("Problem reading " + e.getMessage());
        }
    }
}