import java.util.*;

/*
Average
By Andrew Martinus
Last modified on Feb 29, 2024
This program asks the user for 5 grades and then displays their average
*/

public class Average {
    public static void main(String[] args) {
        final int numSubjects = 5;

        Scanner sc = new Scanner(System.in);
        String[] subjects = new String[numSubjects];
        int[] grades = new int[numSubjects];
        double average = 0;

        System.out.println("-----------------Grades-----------------\n"); // creates the header
        for (int i = 0; i <= numSubjects-1; i++){ // for loop to get user inputs for the subject and grades
            System.out.printf("Enter subject #%d: ", (i+1));
            subjects[i] = sc.nextLine(); // gets a string for the name of the subject
            System.out.print("Enter your grade for subject #" + (i+1) + ": ");
            grades[i] = (int) Math.round(Double.parseDouble(sc.nextLine())); // gets a string which is parsed for a double and rounded
        }
        System.out.println("\n----------------------------------------"); // line break
        for (int i = 0; i <= numSubjects-1; i++){ // for loop to reprint out the subjects and their respective grades
            System.out.printf("%-20S%20S%n", subjects[i], (grades[i] + "%"));
            average += grades[i]; // begins the sumation of grades to allow for average to be calculated later
        }
        System.out.println("\n----------------------------------------"); // line break
        System.out.printf("Your average is: %23S", (Math.round(average/numSubjects) + "%")); // prints a padded average statement
    }
}