import java.util.Scanner;

/*
PizzaCost
By Andrew Martinus
Last modified on Feb 15, 2024
This program asks the user for a pizza size and displays the cost to create it
*/

public class Fastfood {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numBurgers;
        int numFries;
        int numSodas;
        double amountTendered = 0;
        double totalCost;


        System.out.println("    Burger King Simulator    ");
        System.out.println("-----------------------------");
        System.out.println("           Pricing           \n");
        System.out.printf("Burger%23s%n", "$1.69");
        System.out.printf("Fries%24s%n", "$1.09");
        System.out.printf("Soda%25s%n%n", "$0.99");

        System.out.print("Enter the number of burgers: ");
        numBurgers = sc.nextInt();
        System.out.print("Enter the number of fries: ");
        numFries = sc.nextInt();
        System.out.print("Enter the number of sodas: ");
        numSodas = sc.nextInt();
        totalCost = 1.69*numBurgers + 1.09*numFries + 0.999*numSodas;
        System.out.printf("%nYour order of %d burgers, %d fries, and %d sodas will cost $%.2f%n%n", numBurgers, numFries, numSodas, totalCost);
        System.out.print("Enter the amount you wish to pay with: ");
        amountTendered = sc.nextDouble();
        do {
            if (amountTendered < totalCost) {
                System.out.print("That amount is not enough, please enter a valid amount: ");
                amountTendered = sc.nextDouble();
            }
        } while (amountTendered < totalCost);
        System.out.printf("%nYour change is $%.2f%n%n", (amountTendered - totalCost));
    }
}