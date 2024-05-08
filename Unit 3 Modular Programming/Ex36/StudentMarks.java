import java.io.*;
import java.util.*;

/*
StudentMarks
By Andrew Martinus
Last modified on May 5, 2024
This program 
*/

public class StudentMarks {
    public static void main(String[] args) {
        // static variable for the file in focus and the times table upper bound
        final String FILE_NAME1 = "marks.txt";
        final String FILE_NAME2 = "result.txt";

        // declares the the array and size variables and creates the scanner objects
        Scanner sc = new Scanner(System.in);
        String[][] scores;
        String lineIn;
        int students, tests, charIn, counter = 0, bestStudent = -1;
        double highest = 0, average = 0;


        // initializes and assigns values to the test score array and writes to a second file the averages of the tests for each student
        try {
            BufferedReader sourceIn = new BufferedReader(new FileReader(FILE_NAME1));

            BufferedReader resultIn = new BufferedReader(new FileReader(FILE_NAME2));
            BufferedWriter resultOut = new BufferedWriter(new FileWriter(FILE_NAME2, true));

            // initializes the 2D array with integer values from the file
            students = Integer.parseInt(sourceIn.readLine());
            tests = Integer.parseInt(sourceIn.readLine());
            scores = new String[students][tests];
            
            // reads each character from the file in focus and appends characters not seperated by '\n' or ' ' to each index in the array
            for (int i = 0; i < students; i++){
                for (int j = 0; j < tests; j++){
                    scores[i][j] = "";
                    do{
                        charIn = sourceIn.read();
                        if ((char) charIn != ' ' && (char) charIn != '\n' && charIn != -1){
                            scores[i][j] += (char) charIn;
                        }
                    } while ((char) charIn != ' ' && (char) charIn != '\n' && charIn != -1);
                }
            }

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
                resultOut.write(String.format("%.2f", average) + "\n");
                average = 0;
            }
            
            // writes the student number of the student with the highest average
            lineIn = resultIn.readLine();
            while (counter <= students){
                // System.out.println("lineIn: " + Double.parseDouble(lineIn) + " highest:" + highest);
                counter++;
                if (Double.parseDouble(lineIn) > highest){
                    highest = Double.parseDouble(lineIn);
                    bestStudent = counter;
                }
                lineIn = resultIn.readLine();
                System.out.println(counter);
            }
            resultOut.write(bestStudent + "\n");

            for (int i = 0; i < tests; i++){
                for (int j = 0; j < students; j++){
                    average += Double.parseDouble(scores[j][i]);
                }
                average /= students;
                resultOut.write(String.format("%.2f", average) + "\n");
            }

            resultIn.close();
            resultOut.close();
            sourceIn.close();
        } catch (IOException e){
            System.out.println("Problem interacting with " + e.getMessage());
        } catch (NumberFormatException f) {
            System.out.println("Invalid input detected, please check input file " + FILE_NAME1);
        } catch (Exception g){
            System.out.println("An error occured!: " + g);
            g.printStackTrace();
        }

        sc.close();
    }
}