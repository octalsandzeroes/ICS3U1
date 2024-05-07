import java.util.*; // use the import command to import non og java instruction sets
// this star means go to java.util and load EVERYTHING in it
// if you need to be really memory efficient, do .scanner

public class InputAndVariables {
    public static void main(String[] args) {
        // we need to save values to variables
        // variables only update when you tell them to
        double example1 = 2;
        double example2 = example1*2;
        System.out.println("Assign it once: " + example2);
        example1 = 3;
        System.out.println("Assign a new value to a used variable: " + example2);
        example2 = example1*2;
        System.out.println("Reassign example2: " + example2 + "\n");

        // Reading keyboard inputs are not in the original Java instruction set
        // thus we need to use the Scanner class that someone has made
        Scanner scannerObject = new Scanner(System.in);
        // here we make a new variable of the Scanner type called scannerObject that gets info from System.in
        // (which is the keyboard)
        // basically gets everything the user typed until enter is pressed
        
        System.out.print("Enter username: ");
        String stest = scannerObject.nextLine(); // this uses the scanner var to read and store a string value
        
        System.out.print("Enter user age: ");
        int ntest = scannerObject.nextInt(); // this uses the scanner var to read and store one int value
        
        System.out.println("\nUsername is: " + stest);
        System.out.println("User age is: " + ntest);

        double dtest = scannerObject.nextDouble(); // scanner has more than just nextLine and nextInt
        System.out.println(dtest);

        scannerObject.close();
    }
}
