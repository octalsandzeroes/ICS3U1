import java.util.*;

/*
Average
By Andrew Martinus
Last modified on Feb 15, 2024
This program asks the user for three double values and prints the average
*/

public class Average {
    public static void main(String[] args) {
        double num1;
        double num2;
        double num3;
        Scanner sc = new Scanner(System.in);

        System.out.println("This program finds the average of three numbers.\n");
        System.out.print("Enter the first number: ");
        num1 = sc.nextDouble();
        System.out.print("Enter the second number: ");
        num2 = sc.nextDouble();
        System.out.print("Enter the third number: ");
        num3 = sc.nextDouble();
        System.out.printf("%nThe average is %f", (num1 + num2 + num3)/3d);
    }
}
