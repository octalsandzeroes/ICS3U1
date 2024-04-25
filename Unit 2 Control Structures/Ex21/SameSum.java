import java.util.*;

/*
SameSum
By Andrew Martinus
Last modified on April 9, 2024
This program creates an array of length 10 of user inputs and creates another array with corresponding values that cause the sum of the elements in corresponding indexes to be 25
*/

public class SameSum {
    public static void main(String[] args) {
        // initializes the static variable that sets the number of elements and variable to sum to
        final int ARRAY_LENGTH = 10;
        final int SUM_TO = 25;

        // declares the the array variables
        int[] list1 = new int[ARRAY_LENGTH];
        int[] list2 = new int[ARRAY_LENGTH];
        Scanner sc = new Scanner(System.in);

        // assigns a user input to each index in list 1 and calculates the corresponding value in list 2
        for (int i = 0; i < ARRAY_LENGTH; i++){
            System.out.print("Enter an integer: ");
            list1[i] = (int) Math.round(Double.parseDouble(sc.nextLine()));
            list2[i] = SUM_TO - list1[i];
        }

        // prints out the arrays
        System.out.println("\nList 1:");
        for (int i : list1){
            System.out.print(i + " ");
        }
        System.out.println("\nList 2:");
        for (int i : list2){
            System.out.print(i + " ");
        }
    }
}