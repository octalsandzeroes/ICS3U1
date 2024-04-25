package Ex05;

import java.util.*;

/*
Drop
By Andrew Martinus
Last modified on Feb 15, 2024
This program asks the user for a time and calculates the height above 
ground of an object falling from a height of 100 meters at that time
*/

public class Drop {
    public static void main(String[] args) {
        double dispEqn;
        double timeInSec;
        Scanner sc = new Scanner(System.in);

        System.out.println("This program finds the height of an object falling from 100 meters at a given time in seconds\n");
        System.out.print("Enter a time in seconds: ");
        timeInSec = sc.nextDouble();
        dispEqn = 100f - 4.9*Math.pow(timeInSec, 2);
        System.out.printf("%nThe object is %.4fm above the ground", dispEqn);
    }
}
