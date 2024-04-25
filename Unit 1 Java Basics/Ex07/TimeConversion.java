package Ex07;

import java.util.*;

/*
TimeConversion
By Andrew Martinus
Last modified on Feb 22, 2024
This program prompts the user for a time in minutes and displays in hours and minutes
*/

public class TimeConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minutes;
        int hours;

        System.out.print("Enter a time in minutes: ");
        minutes = sc.nextInt();
        hours = minutes/60;
        minutes %= 60;
        System.out.printf("That is equal to %d:%02d", hours, minutes);
    }
}
