import java.util.Scanner;

/*
Test
By Andrew Martinus
Last modified on Mar 6, 2024
This program asks the teacher for a mark and prints if it is within range, passing, or failing.
*/

public class Test {
    public static void main(String[] args)
    {
        // sets the passing mark and range
        final int PASSING_MARK = 50;
        final int MAX_RANGE = 100;
        final int MIN_RANGE = 0;

        // creates the scanner and declares the mark variable
        double mark;
        Scanner sc = new Scanner(System.in);

        // gets a teacher input for the grade
        System.out.print("Enter a mark, teacher: ");
        mark = sc.nextDouble();
        // checks to see if it is within range or passing
        if (mark < MIN_RANGE){
            System.out.println("Mark below range.");
        } else if (mark > MAX_RANGE){
            System.out.println("Mark above range.");
        } else {
            if (mark < PASSING_MARK){
                System.out.println("FAIL");
            } else {
                System.out.println("PASS");
            }
        }
    }
}
