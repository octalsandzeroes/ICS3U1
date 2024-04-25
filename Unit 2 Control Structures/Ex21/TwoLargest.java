import java.util.*;

/*
TwoLargest
By Andrew Martinus
Last modified on April 5, 2024
This program creates an array of length 10 with random integers and prints out the two largest
*/

public class TwoLargest {
    public static void main(String[] args) {
        // initializes the static variable that sets the number of elements
        final int ARRAY_LENGTH = 10;

        // declares the the array variable and the variables to store the greatest values
        int[] randomArray = new int[ARRAY_LENGTH];
        int greatestValue1 = 0, greatestValue2 = 0;

        // assigns a random value to each index in the array
        for (int i = 0; i < ARRAY_LENGTH; i++){
            randomArray[i] = (int) (Math.random()*100);
            // checks if the value is greater than the second greatest value
            if (randomArray[i] > greatestValue2){
                // checks if the value is then greater than the greatest value
                if (randomArray[i] > greatestValue1){
                    greatestValue1 = randomArray[i];
                } else {
                    greatestValue2 = randomArray[i];
                }
            }
            System.out.println(randomArray[i]);
        }

        System.out.printf("The greatest value is: %d%nThe second greatest value is: %d%n", greatestValue1, greatestValue2);
    }
}