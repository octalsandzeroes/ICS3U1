import java.util.*;

/*
CalculateSum
By Andrew Martinus
Last modified on April 25, 2024
This program prompts the user for a range of values and prints the sum of integers within the range
*/

public class CalculateSum{
    // main method
    public static void main(String[] args){
        // creates the scanner
        Scanner sc = new Scanner(System.in);
        int from, to;

        // recieves a user input for the bounds
        System.out.print("Enter the left side bound: ");
        from = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the right side bound: ");
        to = Integer.parseInt(sc.nextLine());
        System.out.printf("The sum of the integers between %d to %d is %d", from, to, sumRange(from, to));
        sc.close();
    }

    /*====================================================================
    |  int sumRange(int from, int to)                                    |
    |--------------------------------------------------------------------|
    |  returns int - The sum of the integers in the range (inclusive)    |
    |--------------------------------------------------------------------|
    |  int from - This parameter is the left side integer bound          |
    |--------------------------------------------------------------------|
    |  int to - This parameter is the right side integer bound           |
    |--------------------------------------------------------------------|
    |  This method takes a left side and right side bound of integers    |
    |  and then prints the sum of the integers between them (inclusive). |
    ====================================================================*/
    public static int sumRange(int from, int to){
        int sum = 0;
        // runs a for loop to sum up the values
        if (to > from){
            for (int i = from; i <= to; i++){
                sum += i;
            }
        }
        return sum;
    }
}