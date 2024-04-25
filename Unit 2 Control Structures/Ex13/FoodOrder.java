import java.util.*;

/*
FoodOrder
By Andrew Martinus
Last modified on Mar 18, 2024
This program asks the user for a date in separated format and reprints it in standard form
*/

public class FoodOrder {
    public static void main(String[] args) {
        // initializes constant integers to store the option costs
        final double option1Cost = 2.50;
        final double option2Cost = 2.50;
        final double option3Cost = 3.00;
        final double option4Cost = 3.50;
        final double option5Cost = 5.00;
        final String menu = "1) juice, muffin & coffee\n2) cereal, toast & milk\n3) egg, toast & coffee\n4) banana, granola & milk\n5) grapefruit, bacon, eggs & coffee";
        
        // creates the scanner and declares the input variable
        Scanner sc = new Scanner(System.in);
        double input;
        // prints the menu
        System.out.println(menu);
        System.out.print("\nEnter your selection: ");
        // gets the input and checks validity
        do{
            input = Double.parseDouble(sc.nextLine());
            if (input > 5 || input < 1 || input%(int)input!=0){
                System.out.print("That is not a valid input, please re-enter your selection: ");
            }
        } while (input > 5 || input < 1 || input%(int)input!=0);
        // prints the price depending on the selection
        switch ((int) input){
            case 1:
                System.out.println("It will cost $" + option1Cost);
                break;
            case 2:
                System.out.println("It will cost $" + option2Cost);
                break;
            case 3:
                System.out.println("It will cost $" + option3Cost);
                break;
            case 4:
                System.out.println("It will cost $" + option4Cost);
                break;
            default:
                System.out.println("It will cost $" + option5Cost);
                break;
        }
    }
}