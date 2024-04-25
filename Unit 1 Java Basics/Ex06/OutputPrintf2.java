package Ex06;

/*
OutputPrintf2
By Andrew Martinus
Last modified on Feb 20, 2024
This program lists several base 10 decimal numbers and their squares neatly
*/

public class OutputPrintf2 {
    public static void main(String[] args) {
        // prints the header for the table, (the Number and Square)
        System.out.printf("%s%14s%n", "Number", "Square");
        // for loop that increments in 0.01 steps, and prints 1.10+increment and its square and the fieldwidth with appropriate precision
        for (double i = 0.00d; i <= 0.05d; i += 0.01d){
            System.out.printf("%.2f%16.5f%n", (1.10+i), Math.pow((1.10+i), 2));
        }
    }
}
