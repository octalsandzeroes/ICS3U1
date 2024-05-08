import java.io.*;
import java.util.*;

/*
StudentMarks
By Andrew Martinus
Last modified on May 5, 2024
This program reads student data on tests from a file and writes onto another file various averages and rankings
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
        int students = 0, tests = 0, charIn, counter = 0, bestStudent = -1;
        double highest = 0, average = 0;


        // initializes and assigns values to the test score array and writes to a second file the averages of the tests for each student
        try {
            BufferedReader in1 = new BufferedReader(new FileReader(FILE_NAME1));
            BufferedWriter out1 = new BufferedWriter(new FileWriter(FILE_NAME2, true));
            // initializes the 2D array with integer values from the file
            students = Integer.parseInt(in1.readLine());
            tests = Integer.parseInt(in1.readLine());
            scores = new String[students][tests];
            
            // reads each character from the file in focus and appends characters not seperated by '\n' or ' ' to each index in the array
            for (int i = 0; i < students; i++){
                for (int j = 0; j < tests; j++){
                    scores[i][j] = "";
                    do{
                        charIn = in1.read();
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
                out1.write(String.format("%.2f", average) + "\n");
                average = 0;
            }
            
            // closes the reader and saves the material in the datastream to the output file
            in1.close();
            out1.close();

            BufferedReader in2 = new BufferedReader(new FileReader(FILE_NAME2));
            BufferedWriter out2 = new BufferedWriter(new FileWriter(FILE_NAME2, true));
            // writes the student number of the student with the highest average
            lineIn = in2.readLine();
            System.out.println(lineIn);
            while (counter < students){
                // System.out.println("lineIn: " + Double.parseDouble(lineIn) + " highest:" + highest);
                counter++;
                if (Double.parseDouble(lineIn) > highest){
                    highest = Double.parseDouble(lineIn);
                    bestStudent = counter;
                }
                lineIn = in2.readLine();
                System.out.println(counter);
            }
            out2.write(bestStudent + "\n");
            
            // writes the class average for each test
            for (int i = 0; i < tests; i++){
                for (int j = 0; j < students; j++){
                    average += Double.parseDouble(scores[j][i]);
                }
                average /= students;
                out2.write(String.format("%.2f", average) + "\n");
            }

            // closes the reader and saves the material in the datastream to the output file
            in2.close();
            out2.close();

        } catch (IOException e){
            System.out.println("Problem interacting with file:" + e.getMessage());
        } catch (NumberFormatException f) {
            System.out.println("Invalid input detected, please check input file " + f.getMessage());
        } catch (Exception g){
            System.out.println("An error occured!: " + g);
            g.printStackTrace();
        }

        System.out.println(tests);

        sc.close();
    }
}