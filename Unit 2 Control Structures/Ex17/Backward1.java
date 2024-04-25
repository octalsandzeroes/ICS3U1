import java.util.*;

/*
Backward1
By Andrew Martinus
Last modified on Mar 28, 2024
This program count down from 100 to 5 by 5s
*/

public class Backward1 {
    public static void main(String[] args) {
        // creates the starting, stopping and the stepping variables
        final int starting = 100;
        final int stopping = 5;
        final int stepping = -5;

        // creates the scanner and declares the input variable
        Scanner sc = new Scanner(System.in);

        // prints the countdown
        for (int i = starting; i >= stopping; i += stepping){
            System.out.println(i);
        }
    }
}