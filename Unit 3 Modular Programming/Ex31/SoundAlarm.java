import java.util.*;

/*
SoundAlarm
By Andrew Martinus
Last modified on April 24, 2024
This program prompts the user for the number of alarms and then prints them
*/

public class SoundAlarm{
    // main method
    public static void main(String[] args){
        // creates the scanner
        Scanner sc = new Scanner(System.in);
        int numAlarms;

        // recieves a user input for the number of "ALARM!"s they want
        System.out.print("Enter the number of alarms: ");
        numAlarms = Integer.parseInt(sc.nextLine());
        SoundAlarm.alarm(numAlarms);
    }

    /*====================================================================
    |  void alarm(int numAlarms)                                         |
    |--------------------------------------------------------------------|
    |  int numAlarms - This parameter is the number of alarm lines       |
    |--------------------------------------------------------------------|
    |  This method takes the number of alarm lines the user requested    |
    |  and then prints them.                                             |
    ====================================================================*/
    public static void alarm(int numAlarms){
        for (int i = 1; i <= numAlarms; i++){
            System.out.println("ALARM!");
        }
    }
}