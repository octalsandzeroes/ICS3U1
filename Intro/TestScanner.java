import java.util.Scanner;

public class TestScanner 
{
    public static void main(String[] args)
    {
        try (Scanner scnObj = new Scanner(System.in)) {
            System.out.println("Enter username");

            String test = scnObj.nextLine();
            System.out.println("Username is: ");
            System.out.println(test);

            // scanner leaving a new line char in input buffer
            // https://www.freecodecamp.org/news/java-scanner-nextline-call-gets-skipped-solved/
            // tldr if you have nextInt then nextLine, add an extra nextLine before the actual nextLine
            // or take everything as strings and parse
        }
    }
}
