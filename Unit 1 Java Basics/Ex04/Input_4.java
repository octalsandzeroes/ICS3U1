import java.util.Scanner;

/*
Input_4
By Andrew M.
Last Modified on Feb 13, 2024
This program asks the user for two different words and then prints them back seperately and then together
*/

public class Input_4 {
    public static void main(String[] args) {
        String inputWord1;
        String inputWord2;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please enter word #1: ");
        inputWord1 = sc.nextLine();
        System.out.print("Please enter word #2: ");
        inputWord2 = sc.nextLine();
        System.out.println(inputWord1 + "\n" + inputWord2 + "\n" + inputWord1 + " " + inputWord2);
    }
}
