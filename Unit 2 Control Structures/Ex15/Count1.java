import java.util.*;

/*
Count1
By Andrew Martinus
Last modified on Mar 21, 2024
This program count down from 100 to 1 by 2s
*/

public class Count1 {
    public static void main(String[] args) {
        // creates the starting, stopping and the stepping variables
        final int starting = 100;
        final int stopping = 1;
        final int stepping = 2;

        // creates the scanner and declares the input variable
        Scanner sc = new Scanner(System.in);
        int counter = starting;

        // prints the countdown
        System.out.println(starting);
        do{
            counter -= stepping;
            System.out.println(counter);
        }while (counter > stopping);
    }
}