import java.io.*;
import java.util.*;

/*
StarTable
By Andrew Martinus
Last modified on May 5, 2024
This program creates a 2D array of stars with user specified rows and columns and then writes it to a file
*/

public class StarTable {
    public static void main(String[] args) {
        // static variable for the file in focus
        final String FILE_NAME = "timetable.txt";

        // declares the the array and size variables and creates the scanner
        Scanner sc = new Scanner(System.in);
        String[][] starArray;
        int rows, columns;

        // gets the dimensions of the 2D array
        System.out.print("Enter a row size: ");
        rows = getIntInput(sc);
        System.out.print("Enter a column size: ");
        columns = getIntInput(sc);
        
        starArray = new String[rows][columns];

        // fills the array
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                starArray[i][j] = "*";
            }
        }

        // prints the array
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                autoBufferedWrite(starArray[i][j], FILE_NAME);
            }
            autoBufferedWrite("\n", FILE_NAME);
        }

        sc.close();
    }

    /*====================================================================
    |  int getIntInput(Scanner sc)                                       |
    |--------------------------------------------------------------------|
    |  Scanner sc - The System.in scanner object                         |
    |--------------------------------------------------------------------|
    |  returns int - The valid integer input                             |
    |--------------------------------------------------------------------|
    |  This method ensures the user enters a valid integer input         |
    ====================================================================*/
    public static int getIntInput(Scanner sc){
        int input = 0;
        boolean pass = false;
        
        do{
            try {
                input = sc.nextInt();
                sc.nextLine();
                pass = true;
            } catch (InputMismatchException e) {
                System.out.print("Error, that is not a valid input. Please retry: ");
                sc.nextLine();
            }
        } while (pass == false);

        return input;
    }

    /*====================================================================
    |  void autoBufferedWrite(String output, String FILE_NAME)           |
    |--------------------------------------------------------------------|
    |  String output - The data the user wishes to write to a file       |
    |--------------------------------------------------------------------|
    |  String FILE_NAME - The file the user wishes to write to           |
    |--------------------------------------------------------------------|
    |  This method writes to a file in focus a user input                |
    ====================================================================*/
    public static void autoBufferedWrite(String output, String FILE_NAME){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(FILE_NAME));
            out.write(output);
            out.close();
        } catch (IOException e) {
            System.out.println("Problem writing " + e.getMessage());
        }
    }
}