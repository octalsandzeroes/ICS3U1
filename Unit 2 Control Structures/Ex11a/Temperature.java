import java.util.Scanner;

/*
Temperature
By Andrew Martinus
Last modified on Mar 6, 2024
This program asks the user for a temperature and checks what range it is in
*/

public class Temperature {
    public static void main(String[] args)
    {
        // creates arrays for the temperature rangers
        final String[] TEMP_RANGE = {"very cold", "cold", "very cool", "moderate", "warm", "hot", "extremely hot"};
        final int[] TEMP_ARRAY = {-2147483647,-18,0,10,20,30,40,100,2147483647};

        // creates the scanner and declares the input temp var
        int temp;
        Scanner sc = new Scanner(System.in);

        // asks for a temp
        System.out.print("Enter a temperature: ");
        temp = sc.nextInt();
        // checks for all the in between ranges of temperatures excluding 100 and 0 exactly
        for (int i = 0; i <= 8; i++){
            if (temp > TEMP_ARRAY[i] && temp <= TEMP_ARRAY[i+1] && temp != 100 && temp != 0){
                System.out.println(TEMP_RANGE[i]);
            }
        }
        // prints the message for 100 or 0
        if (temp == 0) {
            System.out.println("freezing point of water");
        } else if (temp >= 100) {
            System.out.println("boiling point of water");
        }
    }
}
