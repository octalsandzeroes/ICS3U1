import java.util.Scanner;

/*
Salary
By Andrew Martinus
Last modified on Mar 3, 2024
This program asks the user for the amount of sales they closed and then calculates their monthly bonus
*/

public class Salary {
    public static void main(String[] args) {
        // initializes in constants the known quota bonus percent and default salary
        final double BONUS_PERCENT = 0.01;
        final int QUOTA = 10;
        final int DEFAULT_SALARY = 1000;
        
        // creates the scanner and decleared the variable to store the amount of sales closed
        Scanner sc = new Scanner(System.in);
        int salesClosed;

        // asks the user for the amount of sales closed
        System.out.print("The amount of sales closed: ");
        salesClosed = sc.nextInt();
        // prints the salary depending on the quota
        if (salesClosed > QUOTA){
            System.out.printf("Your salary for this month is $%.2f.", DEFAULT_SALARY*(1+(salesClosed*BONUS_PERCENT)));
        } else {
            System.out.printf("Your salary for this month is $%.2f.", (double) DEFAULT_SALARY);
        }
        
    }
}