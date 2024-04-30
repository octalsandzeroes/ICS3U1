import java.util.*;

/*
CheckLine
By Andrew Martinus
Last modified on April 24, 2024
This program uses the Line class methods to obtain the length and slope of a line
*/

public class CheckLine{
    // main method
    public static void main(String[] args){
        // creates the scanner
        Scanner sc = new Scanner(System.in);
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        double length1, slope1, length2, slope2;
        boolean validInput = false;

        // for the first line
        // recieves a user input for a the first coordinate 
        System.out.println("Please enter the two coordinates of line 1:");
        do{
            try {
                System.out.print("Vertex 1 x-value: ");
                x1 = sc.nextInt();
                sc.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid input, please retry.");
                sc.nextLine();
            }
        } while (!validInput);
        validInput = false;
        do{
            try {
                System.out.print("Vertex 1 y-value:: ");
                y1 = sc.nextInt();
                sc.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid input, please retry.");
                sc.nextLine();
            }
        } while (!validInput);
        validInput = false;
        // recieves a user input for a the second coordinate 
        do{
            try {
                do{
                    System.out.print("Vertex 2 x-value: ");
                    x2 = sc.nextInt();
                    sc.nextLine();
                    if (x1 == x2){
                        System.out.println("That is not a valid input, you cannot have the same x coordinate, please retry.");
                    }
                } while (x1 == x2);
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid input, please retry.");
                sc.nextLine();
            }
        } while (!validInput);
        validInput = false;
        do{
            try {
                System.out.print("Vertex 2 y-value:: ");
                y2 = sc.nextInt();
                sc.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid input, please retry.");
                sc.nextLine();
            }
        } while (!validInput);

        // calls the Line class' length and slope methods and prints the result
        length1 = Line.length(x1, y1, x2, y2);
        slope1 = Line.slope(x1, y1, x2, y2);
        System.out.printf("The length of the first line is %s units.%n", length1);
        System.out.printf("The slope of the first line is %s.%n", slope1);

        // for the second line
        // recieves a user input for a the first coordinate 
        System.out.println("\nPlease enter the two coordinates of line 2:");
        do{
            try {
                System.out.print("Vertex 1 x-value: ");
                x1 = sc.nextInt();
                sc.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid input, please retry.");
                sc.nextLine();
            }
        } while (!validInput);
        validInput = false;
        do{
            try {
                System.out.print("Vertex 1 y-value:: ");
                y1 = sc.nextInt();
                sc.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid input, please retry.");
                sc.nextLine();
            }
        } while (!validInput);
        validInput = false;
        // recieves a user input for a the second coordinate 
        do{
            try {
                do{
                    System.out.print("Vertex 2 x-value: ");
                    x2 = sc.nextInt();
                    sc.nextLine();
                    if (x1 == x2){
                        System.out.println("That is not a valid input, you cannot have the same x coordinate, please retry.");
                    }
                } while (x1 == x2);
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid input, please retry.");
                sc.nextLine();
            }
        } while (!validInput);
        validInput = false;
        do{
            try {
                System.out.print("Vertex 2 y-value:: ");
                y2 = sc.nextInt();
                sc.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid input, please retry.");
                sc.nextLine();
            }
        } while (!validInput);

        // calls the Line class' length and slope methods and prints the result
        length2 = Line.length(x1, y1, x2, y2);
        slope2 = Line.slope(x1, y1, x2, y2);
        System.out.printf("The length of the first line is %s units.%n", length2);
        System.out.printf("The slope of the first line is %s.%n", slope2);

        System.out.println("\nResults:");
        if (length1 == length2){
            System.out.println("The two lines have the same length");
        } else {
            System.out.println("The two lines do not have the same length");
        }

        if (slope1 == slope2) {
            System.out.println("The two lines are parallel.");
        } else if (slope1 == -1/slope2 || slope2 == -1/slope1) {
            System.out.println("The two lines are perpendicular.");
        } else {
            System.out.println("The two lines are neither parallel nor perpendicular");
        }
        sc.close();
    }
}