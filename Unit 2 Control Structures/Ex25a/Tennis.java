import java.util.*;

import javax.sound.midi.Soundbank;

/*
Tennis
By Andrew Martinus
Last modified on April 17, 2024
This program creates a tennis score card
*/

public class Tennis {
    public static void main(String[] args) {
        // creates static variables for the array row and column length
        final int NUM_PLAYERS = 2;
        final int NUM_SETS = 5;
        final int WIN_CONDITION = 3;
        final int SET_CONDITION = 6;
        final int PLAYER1 = 0;
        final int PLAYER2 = 1;

        // declares the the array and counter and creates the scanner
        int[][] setArray = new int[NUM_PLAYERS][NUM_SETS];
        int p1Counter = 0, p2Counter = 0;
        double input;
        Scanner sc = new Scanner(System.in);

        // recieves integer inputs for the score of each player
        for (int i = 0; i < NUM_SETS; i++){
            for (int j = 0; j < NUM_PLAYERS; j++){
                System.out.printf("Enter a the score for player %d, set %d: ", j+1, i+1);
                // loops while you enter a 6-6 score and if you input an decimal or out of bounds score and while no one has won
                do{
                    input = Double.parseDouble(sc.nextLine());
                    if (input == SET_CONDITION){
                        if (j == PLAYER1){
                            p1Counter++;
                        } else if (j == PLAYER2) {
                            p2Counter++;
                        }
                    }
                    // prints the error messages
                    if ((input%(int)input != 0 && input != 0) || input < 0 || input > SET_CONDITION){
                        System.out.println("That is not a valid input, please enter an integer score between 0 and 6.");
                    } 
                    if (input == SET_CONDITION && setArray[PLAYER1][i] == SET_CONDITION && j > 0){
                        System.out.println("That is not a valid set result, please enter a valid score.");
                    }
                } while (((input%(int)input != 0 && input != 0) || input < 0 || input > SET_CONDITION)
                        && (input == 6 && setArray[PLAYER1][i] == SET_CONDITION && j == PLAYER2));
                setArray[j][i] = (int) input;
            }
        }

        // prints the header of the set array
        System.out.printf("%-4s", "Set:");
        for (int i = 1; i <= NUM_SETS; i++){
            System.out.printf("%-4d", i);
        }
        System.out.println();

        // prints the set array
        for (int i = 0; i < NUM_PLAYERS; i++){
            System.out.printf("%-4s", "P" + (i+1));
            for (int j = 0; j < NUM_SETS; j++){
                System.out.printf("%-4d", setArray[i][j]);
            }
            System.out.println();
        }

        // discovers and prints who won each set
        System.out.println();
        for (int i = 0; i < NUM_PLAYERS; i++){
            for (int j = 0; j < NUM_SETS; j++){
                if (setArray[i][j] == SET_CONDITION){
                    System.out.printf("Player %d won set %d.%n", i+1, j+1);
                }
            }
        }

        // prints the overall winner
        System.out.println();
        if (p1Counter == WIN_CONDITION){
            System.out.printf("Player 1 won with %d sets.%n", p1Counter);
            System.out.printf("Player 2 lost with %d sets.%n", p2Counter);
        } else if (p2Counter == WIN_CONDITION){
            System.out.printf("Player 2 won with %d sets.%n", p2Counter);
            System.out.printf("Player 1 lost with %d sets.%n", p1Counter);
        }
    }
}