import java.io.*;
import java.util.*;

/*
StudentMarksExperiments
By Andrew Martinus
Last modified on May 5, 2024
This program aims to tinker with using BufferedReader and BufferedWriter in methods
*/


public class StudentMarksExperiments {
    public static void main(String[] args) {
        // static variable for the file in focus and the times table upper bound
        final String SOURCE_FILE = "marks.txt";
        final String OUTPUT_FILE = "result.txt";

        // declares the the array and size variables and creates the scanner objects
        Scanner sc = new Scanner(System.in);
        String[][] scores;
        String lineIn;
        int students = 0, tests = 0, charIn, counter = 0, bestStudent = -1;
        double highest = 0, average = 0;

        try {
            BufferedReader sourceIn = new BufferedReader(new FileReader(SOURCE_FILE));
            BufferedReader outputIn = new BufferedReader(new FileReader(OUTPUT_FILE));
        } catch (IOException e) {
            System.out.println("Error accessing file " + e.getMessage());
        }

        // initializes and assigns values to the test score array and writes to a second file the averages of the tests for each student   
        // initializes the 2D array with integer values from the file
//        students = Integer.parseInt(autobufferedread(sourceIn, true));
//        tests = Integer.parseInt(autobufferedread(sourceIn, true));
        System.out.println("Students: " + students + " Tests: " + tests);
        scores = new String[students][tests];
        
        // reads each character from the file in focus and appends characters not seperated by '\n' or ' ' to each index in the array
//        for (int i = 0; i < students; i++){
//            for (int j = 0; j < tests; j++){
//                scores[i][j] = "";
//
//                do{
//                    charIn = Integer.parseInt(autobufferedread(sourceIn, false));
//                    if ((char) charIn != ' ' && (char) charIn != '\n' && charIn != -1){
//                        scores[i][j] += (char) charIn;
//                    }
//                } while ((char) charIn != ' ' && (char) charIn != '\n' && charIn != -1);
//            }
//        }

        /* prints the 2D array
        System.out.println();
        for (int i = 0; i < students; i++){
            for (int j = 0; j < tests; j++){
                if (j == tests-1){
                    System.out.println(scores[i][j]);    
                } else {
                    System.out.print(scores[i][j] + " ");
                }
            }
        }
        */


        // calculates the averages for each student and writes them to a seperate file
        for (int i = 0; i < students; i++){
            for (int j = 0; j < tests; j++){
                average += Double.parseDouble(scores[i][j]);
            }
            average /= tests;
            // System.out.printf("The average of student %d is %.2f%n", i+1, average);
            autobufferedwrite(String.format("%.2f", average) + "\n", OUTPUT_FILE, true);
            average = 0;
        }


        // writes the student number of the student with the highest average
//        lineIn = autobufferedread(outputIn, true);
        System.out.println(lineIn);
        while (counter < students){
            // System.out.println("lineIn: " + Double.parseDouble(lineIn) + " highest:" + highest);
            counter++;
            if (Double.parseDouble(lineIn) > highest){
                highest = Double.parseDouble(lineIn);
                bestStudent = counter;
            }
//            lineIn = autobufferedread(outputIn, true);
            System.out.println(counter);
        }
        autobufferedwrite(bestStudent + "\n", OUTPUT_FILE, true);
        
        
        // prints the class averages for each test
        for (int i = 0; i < tests; i++){
            for (int j = 0; j < students; j++){
                average += Double.parseDouble(scores[j][i]);
            }
            average /= students;
            autobufferedwrite(String.format("%.2f", average) + "\n", OUTPUT_FILE, true);
        }



        sc.close();
    }

    /*===============================================================================
    |  void autobufferedwrite(String output, String FILE_NAME, boolean appendState) |
    |-------------------------------------------------------------------------------|
    |  String output - The data the user wishes to write to a file                  |
    |-------------------------------------------------------------------------------|
    |  String FILE_NAME - The file the user wishes to write to                      |
    |-------------------------------------------------------------------------------|
    |  boolean appendState - The boolean to enable or disable appending             |
    |-------------------------------------------------------------------------------|
    |  This method writes to a file in focus a user input                           |
    ===============================================================================*/
    public static void autobufferedwrite(String output, String FILE_NAME, boolean appendState){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(FILE_NAME, appendState));
            out.write(output);
            out.close();
        } catch (IOException e) {
            System.out.println("Problem writing " + e.getMessage());
        } catch (Exception f){
            System.out.println("An error occured!: " + f);
            f.printStackTrace();
        }
    }

    /*===============================================================================
    |  String autobufferedread(String FILE_NAME, boolean readLine)                  |
    |-------------------------------------------------------------------------------|
    |  Returns String - Returns read data                                           |
    |-------------------------------------------------------------------------------|
    |  BufferedReader in - The BufferedReader object to be used                     |
    |-------------------------------------------------------------------------------|
    |  boolean readLine - The boolean defining the read type to be executed         |
    |-------------------------------------------------------------------------------|
    |  This method reads from a file in focus                                       |
    ===============================================================================*/
    public static String autobufferedread(BufferedReader in, boolean readLine){
        String readData = null;

        try {
            if (readLine == false){
                readData = Character.toString((char) in.read());
            } else {
                readData = in.readLine();
            }
        } catch (IOException e) {
            System.out.println("Problem reading " + e.getMessage());
        } catch (Exception f){
            System.out.println("An error occured!: " + f);
            f.printStackTrace();
        }

        return readData;
    }
}