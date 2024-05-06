import java.util.*;

/*
Welcome
By Andrew Martinus
Last modified on April 24, 2024
This program uses a method to print out a welcome method for a user
*/

public class Welcome{
    // main method
    public static void main(String[] args){
        // creates the scanner
        Scanner sc = new Scanner(System.in);
        String name;
        int visitorNum;

        // recieves a user input for their name and which visitor they are
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("Enter your visitor number: ");
        visitorNum = Integer.parseInt(sc.nextLine());
        System.out.println(Welcome.welcomeMessage(name, visitorNum));
        sc.close();
    }

    /*====================================================================
    |  String welcomeMessage(String name, int visitorNum)                |
    |--------------------------------------------------------------------|
    |  returns String - The welcome message for the specific user        |
    |--------------------------------------------------------------------|
    |  String name - This parameter is a string for the user's name      |
    |--------------------------------------------------------------------|
    |  int visitorNum - This parameter is the visitor number of the user |
    |--------------------------------------------------------------------|
    |  This method takes the name and visitor number of the user and     |
    |  prints a welcome message                                          |
    ====================================================================*/
    public static String welcomeMessage(String name, int visitorNum){
        String output = "Welcome " + name + "! You are visitor number " + visitorNum + ".";
        return output;
    }
}