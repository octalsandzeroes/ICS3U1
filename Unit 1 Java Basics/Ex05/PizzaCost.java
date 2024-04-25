import java.util.*;

/*
PizzaCost
By Andrew Martinus
Last modified on Feb 15, 2024
This program asks the user for a pizza size and displays the cost to create it
*/

public class PizzaCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numPizzas;
        double diameter;
        double cost = 0;
        double totalCost;

        System.out.println("    Pizza Cost Calculator    ");
        System.out.println("-----------------------------");
        System.out.println("           Pricing           \n");
        System.out.printf("Labour%23s%n", "$0.75/Pizza");
        System.out.printf("Rent%25s%n", "$1 flat");
        System.out.printf("Materials%20s%n%n", "$0.05/Inch");

        System.out.print("Enter the number of pizzas: ");
        numPizzas = sc.nextInt();
        if (numPizzas == 1) {
            System.out.printf("Enter a pizza size in inches: ");
            diameter = sc.nextDouble();
            totalCost = 1d + (0.75d*numPizzas) + 0.05*Math.pow(diameter,2);
            System.out.printf("%nThe total cost for your pizza is $%.2f%n", totalCost);
        } else if (numPizzas > 1){
            for (int i = 1; i <= numPizzas; i++){
                System.out.printf("Enter a pizza size in inches for pizza number %d: ", i);
                diameter = sc.nextDouble();
                cost = cost + 0.05*Math.pow(diameter,2);
            }
            totalCost = 1d + (0.75d*numPizzas) + cost;
            System.out.printf("%nThe total cost for your %d pizzas is $%.2f%n", numPizzas, totalCost);
        }else {
            totalCost = 0;
            System.out.println("\nThe cost for 0 pizzas is... $0.");
        }

    }
}