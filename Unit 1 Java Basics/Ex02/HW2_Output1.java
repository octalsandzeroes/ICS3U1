package Ex02;

public class HW2_Output1 {
    public static void main(String[] args)
    {
        System.out.println("Num   Square\n***   ******");
        for (int i = 1; i <= 5; i++){ // prints the numbers 1-4 and their square
            System.out.println(i + "     " + Math.round(Math.pow(i, 2)));
        }
        System.out.println("");
        for (int i = 1; i <= 4; i++){ // shows the work for the above up to 4
            System.out.println(i + "*" + i + " = " + Math.round(Math.pow(i, 2)));
        }
    }
}
