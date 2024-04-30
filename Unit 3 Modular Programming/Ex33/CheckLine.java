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
        String length = "", slope = "";
        boolean validInput = false;

        // recieves a user input for a the first coordinate 
        do{
            try {
                System.out.print("Enter an integer x coordinate for the first point: ");
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
                System.out.print("Enter an integer y coordinate for the first point: ");
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
                    System.out.print("Enter an integer x coordinate for the second point: ");
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
                System.out.print("Enter an integer y coordinate for the second point: ");
                y2 = sc.nextInt();
                sc.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid input, please retry.");
                sc.nextLine();
            }
        } while (!validInput);

        // calls the Line class' length and slope methods and prints the result
        length += Line.length(x1, y1, x2, y2);
        slope += Line.slope(x1, y1, x2, y2);
        System.out.printf("The length of the line is %s units.%n", length);
        System.out.printf("The slope of the line is %s.%n", slope);
        sc.close();
    }
}