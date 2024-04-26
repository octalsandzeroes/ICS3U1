//Feb 5, 2024

public class PrintTest // Main class, your "programs", file name must be the same as class name
{
    public static void main(String[] args) //entry point for java program, there the JVM starts 
    { // put code here, this is the main method
        System.out.println("First");
        System.out.println("Second");
        //the ln means it creates a new line, or linebreak after the output
        System.out.print("First");
        System.out.print("Second");
        System.out.println("Done?");
        System.out.println("Yes");
        //"\n" is a special character, meaning it does something instead of getting printed "a line break"
        //"\b" is backspace and "\t" is a tab
        System.out.println("Before\nAfter");
        //trying to print out certain things needs escape characters, the "\"
        System.out.println("(\"_\")"); // in this case it thought that the first " was ending the string
        // thus the backslash either can do a special job (\n) or get rid of a job (\")
        System.out.println("\\n/");

        System.err.println("1 + 2 + 3 + 4 + 5"); //prints as str
        System.err.println(1 + 2 + 3 + 4 + 5); //sums as ints
        System.err.println(1 + 2 + 3 + " 4 + 5"); //sums 1,2,3 and then prints " 4 + 5" 
        System.err.println("1 + 2 + 3" + 4 + 5); //if quotation marks come first, it treats the rest as strs
        // essentially its like the order of operations when it comes to "+":
        // int + int = int
        // int + str = int + str
        // str + int = str + str = str
        // so str + int + int = str + str + int = str + int = str + str = str
        System.err.println("1 + 2 + 3" + (4 + 5)); // so use brackets since it does the int + int first
    }
}
