import java.util.Scanner;

/*
Input_3
By Andrew M.
Last Modified on Feb 13, 2024
This program asks the user for their name and age and then outputs it back to them
*/

public class Input_3 {
    public static void main(String[] args) {
        String userName;
        int userAge;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("What's your name? ");
        userName = sc.nextLine();
        System.out.print("How old are you? ");
        userAge = sc.nextInt();
        System.out.println("So you are " + userName + " and you are " + userAge);
    }
}
