import java.util.*;

/*
Chart
By Andrew Martinus
Last modified on Mar 28, 2024
This program prints a chart of a numbers square and then cube
*/

public class Chart {
    public static void main(String[] args) {
        final int starting = 5;
        final int stopping = 40;

        // prints the heading
        System.out.println("Number    Square    Cube");
        // prints the countdown
        for (int i = starting; i <= stopping; i++){
            System.out.printf("%-10d%-10d%d%n", i, (int) Math.pow(i, 2), (int) Math.pow(i, 3));
        }
    }
}
