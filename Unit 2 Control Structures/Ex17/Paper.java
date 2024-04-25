import java.util.*;

/*
Paper
By Andrew Martinus
Last modified on April 4, 2024
This program prints the area and thickness of a repeatedly cut and stacked piece of paper
*/

public class Paper {
    public static void main(String[] args) {
        // creates a constant integer to store the upper bounds of the print out
        final double INITIAL_THICKNESS = 0.090;
        final double INITIAL_AREA = 1.0;
        final int NUM_LOOPS = 40;

        // sets up modifiable variables
        double thickness = INITIAL_THICKNESS;
        double area = INITIAL_AREA;

        // halves the area and doubles the thickness each loop
        for (int i = 1; i <= NUM_LOOPS; i++){
            area /= 2;
            thickness *= 2;
        }

        /* Technically if you think about it, dividing 1 by 2 forty times is just (1/2)^40
        area = Math.pow(0.5, 40);
        Technically if you also think about it, multiplying the thickness by 2 for forty times is just 0.090*(2)^40
        thickness = 0.090*Math.pow(2, 40);
        */

        // prints the final area and thickness
        System.out.println("Final area: " + area + "m^2");
        System.out.println("Final thickness: " + thickness + "mm");
    }
}