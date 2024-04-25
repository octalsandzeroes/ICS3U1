import java.util.*;

/*
Alive
By Andrew Martinus
Last modified on Feb 15, 2024
This program asks the user for their birthday and then calculates the time they have been alive for
*/

public class Alive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int birthDay;
        int birthMonth;
        int birthYear;
        int curDay;
        int curMonth;
        int curYear;
        int totalDays;
        int hoursSlept;

        System.out.println("Enter your birthdate: ");
        System.out.println("Year: ");
        birthYear = sc.nextInt();
        System.out.println("Month: ");
        birthMonth = sc.nextInt();
        System.out.println("Day: ");
        birthDay = sc.nextInt();
        System.out.println("Enter today’s date: ");
        System.out.println("Year: ");
        curYear = sc.nextInt();
        System.out.println("Month: ");
        curMonth = sc.nextInt();
        System.out.println("Day: ");
        curDay = sc.nextInt();

        totalDays = (curYear-birthYear)*365 + (curMonth-birthMonth)*30 + (curDay-birthDay);
        hoursSlept = totalDays*8;
        System.out.printf("You have been alive for %d days.%n", totalDays);
        System.out.printf("You have slept %d hours.", hoursSlept);

    }
}

/*
Enter your birthdate:
Year:  1990
Month:  9
Day:  8
Enter today’s date:
Year:  2006
Month:  2
Day:  12
You have been alive for 5634 days.
You have slept 45072 hours.
 */
