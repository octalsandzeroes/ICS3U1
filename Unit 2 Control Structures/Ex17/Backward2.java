import java.util.*;

/*
Backward2
By Andrew Martinus
Last modified on Mar 28, 2024
This program count down from 100 to an input by 5s
*/

public class Backward2 {
    public static void main(String[] args) {
        // creates the starting, stopping and the stepping variables
        final int starting = 100;
        final int stepping = -5;

        // creates the scanner and declares the input variable
        Scanner sc = new Scanner(System.in);
        int stopping;

        System.out.print("Enter a numben integer to run until: ");
        stopping = sc.nextInt();

        // prints the countdown
        for (int i = starting; i >= stopping; i += stepping){
            System.out.println(i);
        }
    }
}
