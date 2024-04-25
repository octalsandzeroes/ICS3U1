package Ex07;

import java.util.*;

/*
Spending
By Andrew Martinus
Last modified on Feb 22, 2024
This program prompts the user for a the amount they spent on various catergories and shows it in percentages
*/

public class Spending {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalSpent = 0;
        String[] categoryNames = new String[] {"Food", "Clothing", "Entertainment", "Rent"};
        double[] categoryExpenses = new double[4];

        System.out.println("Enter the amount spent last month on the following item:\n");
        for (int i = 0; i < 4; i++){
            System.out.printf("%s: $", categoryNames[i]);
            categoryExpenses[i] = sc.nextDouble();
            totalSpent += categoryExpenses[i];
        }
        System.out.printf("%-18s%s%n", "Category", "Budget");
        for (int i = 0; i < 4; i++){
            System.out.printf("%-18s%.2f%c%n", categoryNames[i], (categoryExpenses[i]/totalSpent)*100, '%');
        }
    }
}
