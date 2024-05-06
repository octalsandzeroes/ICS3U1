import java.io.*;

/*
PrintLines
By Andrew Martinus
Last modified on May 5, 2024
This program reads and prints out each line from a file
*/

public class PrintLines{
    // main method
    public static void main(String[] args){
        // static variable for the file in focus
        final String FILE_NAME = "line.txt";

        // declares the string variable to store each read line
        String lineIn;

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