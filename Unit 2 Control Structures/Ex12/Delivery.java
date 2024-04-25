import java.util.*;

/*
Delivery
By Andrew Martinus
Last modified on Mar 18, 2024
This program asks the user to enter a weight and size for their package
*/

public class Delivery {
    public static void main(String[] args) {
        // creates constant integers to store size intervals, limits, and cost
        final int WEIGHT_LIMIT = 27;
        final int MAX_VOLUME = 100000;
        final int SMALL = 5;
        final int MEDIUM = 12;
        final int LARGE = 20;
        final double SMALLEST_PRICE = 3.00;
        final double SMALL_PRICE = 3.50;
        final double MEDIUM_PRICE = 4.00;
        final double LARGE_PRICE = 4.50;

        // creates the scanner and declares the input variable
        Scanner sc = new Scanner(System.in);
        double weight;
        double length;
        double width;
        double height;

        // asks the user for the weight, then checks if it is allowed, and if not asks for it again
        System.out.println("Enter the weight of the item in kilograms.");
        do {
            weight = Double.parseDouble(sc.nextLine());
            if (weight > WEIGHT_LIMIT){
                System.err.println("Item is too heavy, please re-enter the weight.");
            }
        } while (weight > WEIGHT_LIMIT);

        // asks the user for the length, width, and height, then checks if the volume is allowed, and if not asks for it again
        System.out.println("Enter the dimensions of the package in centimeters.");
        do {
            System.out.print("Length: ");
            length = Double.parseDouble(sc.nextLine());
            System.out.print("Width: ");
            width = Double.parseDouble(sc.nextLine());
            System.out.print("Height: ");
            height = Double.parseDouble(sc.nextLine());
            if (length*width*height > MAX_VOLUME){
                System.err.println("Package is too large, please re-enter dimensions.");
            }
        } while (length*width*height > MAX_VOLUME);

        // if block to check the age and categorize the package size and cost
        if (weight > LARGE && weight <= WEIGHT_LIMIT){
            System.out.println("The package will cost $" + (LARGE_PRICE*weight) + " to send.");
        } else if (weight > MEDIUM && weight <= LARGE){
            System.out.println("The package will cost $" + (MEDIUM_PRICE*weight) + " to send.");
        } else if (weight > SMALL && weight <= MEDIUM){
            System.out.println("The package will cost $" + (SMALL_PRICE*weight) + " to send.");
        } else {
            System.out.println("The package will cost $" + (SMALLEST_PRICE*weight) + " to send.");
        }
    }
}