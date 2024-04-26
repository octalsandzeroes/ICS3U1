public class PrintfLesson {
    public static void main (String[] args){
        // run program
        System.out.println("flags width precision conversion/format character\n");

        System.out.printf("Printing with printf allows you to insert values into strings%n");
        System.out.printf("Use a percent sign and a character to insert things like such: %s%n", "Test");
        System.out.printf("Aside from the last character, other format specifiers like flags, width and precision exist%n%n");
        // https://www.cs.colostate.edu/~cs160/.Summer16/resources/Java_printf_method_quick_reference.pdf

        System.out.printf("Format characters include d (ints), f (decimals), c and s (and C and S for force caps), and n for new line %n%n");
        
        System.out.printf("A dot and a number rounds to a certain decimal: %.2f%n%n", 0.6666d);
        
        System.out.printf("The field width pads values: %5s%n", "Pad");
        System.out.printf("The field width pads values: %5s%n%n", "The field width only specifies the minimum amount");

        System.out.printf("Flags dictate formatting:%n - pads to the right of a value%n + adds a sign to pos/neg values%n , adds a comma for very large numbers every 3 digits%n \" \" a space adds a space for pos numbers but leaves neg ones unchanged (for formatting)%n");
    }
}
