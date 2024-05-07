import java.io.*;
import java.util.*;

/*
TimeTable
By Andrew Martinus
Last modified on May 5, 2024
This program creates a 2D 12x12 grid times table and writes it to a file
*/

public class StudentMarks {
    public static void main(String[] args) {
        // static variable for the file in focus and the times table upper bound
        final String FILE_NAME = "marks.txt";

        // declares the the array and size variables and creates the scanner objects
        Scanner sc = new Scanner(System.in);
        String[][] scores;
        String score = "";
        int students, tests, charIn;
        double average = 0;

        try {
            BufferedReader in = new BufferedReader(new FileReader(FILE_NAME));
            students = Integer.parseInt(in.readLine());
            tests = Integer.parseInt(in.readLine());

            scores = new String[students][tests];


            for (int i = 0; i < students; i++){
                for (int j = 0; j < tests; j++){
                    charIn = in.read(); // starts/clears the read queue
                    // saves the character if its not a new line, return, space
                    while ((char) charIn != ' ' && (char) charIn != '\n' && (char) charIn != '\r'){
                        score += (char) charIn;
                        scores[i][j] = score; // saves/overrides the characters seperated by the illegals to the array
                        charIn = in.read();
                    }
                    // resets the score summation string
                    score = "";
                }
            }

            for (int i = 0; i < students; i++){
                for (int j = 0; j < tests; j++){
                    System.out.println(scores[i][j]);
                }
            }

            for (int i = 0; i < students; i++){
                for (int j = 0; j < tests; j++){
                    average += Double.parseDouble(scores[i][j]);
                }
                average /= tests;
                System.out.printf("The average of student %d is %.2f%n", i+1, average);
                average = 0;
            }

        } catch (IOException e){
            System.out.println("Problem reading " + e.getMessage());
        } catch (NumberFormatException f) {
            System.out.println("Invalid parameter detected, please review input file.");
        } catch (ArrayIndexOutOfBoundsException g){
            System.out.println("There is not enough elements in your database!");
        }

        sc.close();
    }
}