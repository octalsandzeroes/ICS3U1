import java.io.*;

/*
AddNumbers
By Andrew Martinus
Last modified on May 5, 2024
This program reads and sums up the numbers from each line from a file
*/

public class AddNumbers{
    // main method
    public static void main(String[] args){
        // static variable for the file in focus
        final String FILE_NAME = "numbers.txt";
        
        // declares and initializes the read string and the sum integer variables
        String lineIn;
        int sum = 0;

        // sums up the integers from each line of the file
        try {
            BufferedReader in = new BufferedReader(new FileReader(FILE_NAME));
            lineIn = in.readLine();
            while (lineIn != null) {
                // catches any format exceptions and resets the lineIn variable if it detects one
                try {
                    sum += Integer.parseInt(lineIn);
                    lineIn = in.readLine();
                } catch (NumberFormatException f) {
                    lineIn = in.readLine();
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Problem reading " + e.getMessage());
        }
        
        // prints the final sum
        System.out.println("The sum is: " + sum);
    }
}