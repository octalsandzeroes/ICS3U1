import java.io.*;

/*
PrintAllChar
By Andrew Martinus
Last modified on May 5, 2024
This program reads and prints out each character from a file
*/

public class PrintAllChar{
    // main method
    public static void main(String[] args){
        // static variable for the file in focus
        final String FILE_NAME = "allChar.txt";

        // declares the variable to store the read character's integer values
        int charIn;

        // reads and prints the the characters on new lines if they are valid characters
        try {
            BufferedReader in = new BufferedReader(new FileReader(FILE_NAME));
            charIn = in.read();
            while (charIn != -1) {
                if ((char) charIn != ' ' && (char) charIn != '\n' && (char) charIn != '\r'){
                    System.out.println((char) charIn);
                }
                charIn = in.read();
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Problem reading " + e.getMessage());
        }

    }
}