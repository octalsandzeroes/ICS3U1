import java.util.*;

/*
RandomNum
By Andrew Martinus
Last modified on April 19, 2024
This program prints out a random number between 0 and 100
*/

public class RandomNum{
    // main method
    public static void main(String[] args){
        // static maximum value to multiply with the random int between 0 and 1
        final int NUM_TO = 100;

        // prints out a random integer between 0 and 100
        System.out.println((int) (Math.random()*NUM_TO));
    }
}