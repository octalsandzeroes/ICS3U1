import java.io.*;
import java.util.*;

/*
TimeTable
By Andrew Martinus
Last modified on May 5, 2024
This program creates a 2D 12x12 grid times table and writes it to a file
*/

public class TimeTable {
    public static void main(String[] args) {
        // static variable for the file in focus and the times table upper bound
        final String FILE_NAME = "timetable.txt";
        final int TIMES_TO = 12;


        // declares the the array and size variables and creates the scanner
        Scanner sc = new Scanner(System.in);
        String[][] timeTable = new String[TIMES_TO+1][TIMES_TO+1];

        for (int i = 0; i <= TIMES_TO; i++){    
            if (i == 0){
                timeTable[i][0] = "";
                for (int j = 1; j <= TIMES_TO; j++){
                    timeTable[i][j] = "" + (1*j);
                }
            } else {
                timeTable[i][0] = "" + i;
                for (int k = 1; k <= TIMES_TO; k++){
                    timeTable[i][k] = "" + (i*k);
                }
            }
        }

        for (int i = 0; i <= TIMES_TO; i++){
            for (int j = 0; j <= TIMES_TO; j++){
                autoBufferedWrite(String.format("%-5s", timeTable[i][j]), FILE_NAME, true);
            }
            autoBufferedWrite("\n", FILE_NAME, true);
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

    /*===============================================================================
    |  void autoBufferedWrite(String output, String FILE_NAME, boolean appendState) |
    |-------------------------------------------------------------------------------|
    |  String output - The data the user wishes to write to a file                  |
    |-------------------------------------------------------------------------------|
    |  String FILE_NAME - The file the user wishes to write to                      |
    |-------------------------------------------------------------------------------|
    |  boolean appendState - The boolean to enable or disable appending             |
    |-------------------------------------------------------------------------------|
    |  This method writes to a file in focus a user input                           |
    ===============================================================================*/
    public static void autoBufferedWrite(String output, String FILE_NAME, boolean appendState){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(FILE_NAME, appendState));
            out.write(output);
            out.close();
        } catch (IOException e) {
            System.out.println("Problem writing " + e.getMessage());
        }
    }
}