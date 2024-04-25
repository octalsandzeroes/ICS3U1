import java.util.*;

/*
ConvertDate
By Andrew Martinus
Last modified on Mar 18, 2024
This program asks the user for a date in seperated format and reprints it in standard form
*/

public class ConvertDate {
    public static void main(String[] args) {
        // creates constant integers to store the month
        final String month1 = "January";
        final String month2 = "February";
        final String month3 = "March";
        final String month4 = "April";
        final String month5 = "May";
        final String month6 = "June";
        final String month7 = "July";
        final String month8 = "August";
        final String month9 = "September";
        final String month10 = "October";
        final String month11 = "November";
        final String month12 = "December";

        // creates the scanner and declares the input and selection variables
        Scanner sc = new Scanner(System.in);
        int input;
        int year;
        String month = "";
        int day;

        // to enter the date in seperated format
        System.out.print("Enter the year: ");
        input = sc.nextInt();
        year = input;

        System.out.print("Enter the month: ");
        input = sc.nextInt();
        
        switch (input){
            case 1:
                month = month1;
                break;
            case 2:
                month = month2;
                break;
            case 3:
                month = month3;
                break;
            case 4:
                month = month4;
                break;
            case 5:
                month = month5;
                break;
            case 6:
                month = month6;
                break;
            case 7:
                month = month7;
                break;
            case 8:
                month = month8;
                break;
            case 9:
                month = month9;
                break;
            case 10:
                month = month10;
                break;
            case 11:
                month = month11;
                break;
            case 12:
                month = month12;
                break;
        }

        System.out.print("Enter the day: ");
        input = sc.nextInt();
        day = input;

        System.out.printf("\n%s %d, %d", month, day, year);
    }
}