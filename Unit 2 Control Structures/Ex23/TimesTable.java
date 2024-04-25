import java.util.*;

import javax.sound.midi.Soundbank;

/*
TimesTable
By Andrew Martinus
Last modified on April 15, 2024
This program prints a multiplication table up to twelve times twelve
*/

public class TimesTable {
    public static void main(String[] args) {
        // creates static variables for the row and column length
        final int ROWS = 12;
        final int COLUMNS = 12;
        
        // declares the the array and creates the scanner
        int[][] timesTable = new int[ROWS][COLUMNS];
        Scanner sc = new Scanner(System.in);

        // creates the array and fills it with the values of the times table
        for (int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLUMNS; j++){
                timesTable[i][j] = (i+1)*(j+1);
            }
        }
        
        // prints the header
        System.out.printf("%-4s", "");
        for (int i = 0; i < ROWS; i++){
            System.out.printf("%-4d", i+1);
        }
        System.out.println();

        // prints the multiplication table
        for (int i = 0; i < ROWS; i++){
            System.out.printf("%-4d", i+1);
            for (int j = 0; j < ROWS; j++){
                System.out.printf("%-4d", timesTable[i][j]);
            }
            System.out.println();
        }
    }
}