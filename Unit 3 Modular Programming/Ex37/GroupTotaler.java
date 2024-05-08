import java.io.*;
import java.text.NumberFormat;
import java.util.*;

import javax.imageio.IIOException;

/*
GroupTotaler
By Andrew Martinus
Last modified on May 6, 2024
This program reads from a file and prints sum of values within groups
*/

public class GroupTotaler {
    public static void main(String[] args) {
        // the static variable for the input file's name
        final String FILE_NAME = "input.txt";

        // 
        String lineIn = "";
        double sum = 0;
        
        try{
            BufferedReader in = new BufferedReader(new FileReader(FILE_NAME));

            // prints the first group name
            lineIn = in.readLine();
            System.out.println(lineIn);
            while (lineIn != null){
                try {
                    lineIn = in.readLine();
                    if (lineIn != null){
                        sum += Double.parseDouble(lineIn);
                    }
                } catch (NumberFormatException f){
                    if (sum == (int) sum){
                        System.out.printf("Sum = %d%n%n", (int) sum);
                    } else {
                        System.out.printf("Sum = %f%n%n", sum);
                    }
                    sum = 0;
                    System.out.println(lineIn);
                }
            }
            // prints the last group values
            if (sum == (int) sum){
                System.out.printf("Sum = %d%n%n", (int) sum);
            } else {
                System.out.printf("Sum = %f%n%n", sum);
            }

            in.close();
        } catch (IOException e){
            System.out.println("Error reading file " + e.getMessage());
        }
    }
}