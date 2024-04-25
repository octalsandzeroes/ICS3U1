import java.util.*;

/*
Cost
By Andrew Martinus
Last modified on Feb 27, 2024
*/

public class Cost {
    public static void main(String[] args) {
        final double bagCost = 0.05;
        final double taxRate = 0.13;

        Scanner sc = new Scanner(System.in);
        double cost = 0;
        int numItems;
        int numBags;

        System.out.print("Enter the number of items you have: ");
        numItems = sc.nextInt();

        for (int i = 1; i <= numItems; i++){
            System.out.printf("Enter the cost for item %d: $", i);
            cost += sc.nextDouble();
        }

        System.out.print("Enter the number of plastic bags you need: ");
        numBags = sc.nextInt();

        System.out.printf("%nThe total cost of your %d item(s) is $%.2f%n", numItems, (cost + numBags*bagCost)*(1+taxRate));
    }
}