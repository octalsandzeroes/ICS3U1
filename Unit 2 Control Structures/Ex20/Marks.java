import java.util.*;

/*
Marks
By Andrew Martinus
Last modified on April 5, 2024
This program receives an input for a mark and matches it to a person
*/

public class Marks {
    public static void main(String[] args) {
        // initializes the static variable that sets the length of the array
        final int NUM_INPUTS = 4;

        // declares the input, and array variables, initializes the boolean check, and creates the scanner
        String nameArray[] = {"Benjamin", "Fred", "Bob", "El"};
        int input, markArray[] = new int[NUM_INPUTS];
        boolean markFound = false;
        Scanner sc = new Scanner(System.in);

        // assigns a mark to each person
        for (int i = 0; i < NUM_INPUTS; i++){
            markArray[i] = (int) Math.round(Math.random()*100);
            //System.out.println(markArray[i]);
        }

        // receives a user input for the mark and prints if there is a person that matches that mark
        do{
            System.out.print("Enter a mark: ");
            input = (int) Double.parseDouble(sc.nextLine());
            for (int j = 0; j < NUM_INPUTS; j++){
                if (markArray[j] == input){
                    markFound = true;
                    System.out.printf("%s has the mark %d%%", nameArray[j], markArray[j]);
                }
            }
            if (!markFound){
                System.out.println("Nobody has that mark.");
            }
        } while (!markFound);
    }
}