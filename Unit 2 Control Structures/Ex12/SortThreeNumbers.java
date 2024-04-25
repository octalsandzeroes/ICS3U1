import java.util.*;

/*
SortThreeNumbers
By Andrew Martinus
Last modified on Mar 18, 2024
This program asks the user to enter three positive whole numbers and then sorts them in ascending order
*/

public class SortThreeNumbers {
    public static void main(String[] args) {
        // creates a constant integer to store the amount of elements in the input array
        final int ARRAY_LENGTH = 3;

        // creates the scanner and declares the input and array variables
        Scanner sc = new Scanner(System.in);
        double input;
        int[] numArray = new int[ARRAY_LENGTH];

        // asks the user for three positive integer values and will do so repeatedly if a wrong input is entered
        System.out.println("Enter three postive integer values.");
        for (int i = 0; i < numArray.length; i++){
            do {
                input = Double.parseDouble(sc.nextLine());
                if ((input % (int) Math.round(input)) != 0 || input <= 0){
                    System.err.println("That is not a positive integer, please re-enter your number.");
                }
            } while ((input % (int) Math.round(input)) != 0 || input <= 0);
            numArray[i] = (int) input;
        }

        // prints out the array in an unsorted manner as according to the way they were inputted
        System.out.print("\nYour unsorted numbers are: " + Arrays.toString(numArray)); // could also have used a for loop and printed each element individually

        // sorts the array in ascending order and prints them again
        Arrays.sort(numArray); // could also have used a loop to sort through and compare the values manually to be ordered
        System.out.print("\nYour numbers sorted in ascending order are: " + Arrays.toString(numArray));
    }
}