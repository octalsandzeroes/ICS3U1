import java.util.*;

/*
Height
By Andrew Martinus
Last modified on April 5, 2024
This program recieves twenty inputs of height and prints all that have a greater than average height
*/

public class Height {
    public static void main(String[] args) {
        // initializes the static variable that sets the amount of inputs
        final int NUM_INPUTS = 20;

        // declares the input variable, average variable, the array variable, and creates the scanner
        double input, average = 0, heightArray[] = new double[NUM_INPUTS];
        Scanner sc = new Scanner(System.in);

        // gathers the inputs and finds the average of the inputs
        for (int i = 0; i < NUM_INPUTS; i++){
            System.out.printf("Enter the height of person %d in centimeters: ", i+1);
            input = Double.parseDouble(sc.nextLine());
            input = (double) Math.round(input * 100) /100;
            heightArray[i] = input;
            average += heightArray[i];
        }
        average /= NUM_INPUTS;
        average = (double) Math.round(average*100)/100;
        System.out.printf("%nThe average height is %.2fcm.%n%n", average);

        // prints those taller than the average height
        for (int i = 0; i < NUM_INPUTS; i++){
            if (heightArray[i] > average){
                System.out.printf("Person %d is above average height at %.2fcm.%n", i+1, heightArray[i]);
            }
        }
    }
}