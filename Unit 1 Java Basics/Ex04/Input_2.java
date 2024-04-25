import java.util.Scanner;

/*
Input_2
By Andrew M.
Last Modified on Feb 13, 2024
This program asks the user for their name and then outputs it back to them
*/

public class Input_2 {
    public static void main(String[] args) {
        String userName;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("What's your name? ");
        userName = sc.nextLine();
        System.out.println("Hello " + userName);
    }
}
