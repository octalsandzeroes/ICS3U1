import java.util.*;

public class ConstantsCasting {
    public static void main(String[] args) {
        // use final and capitalize to make a const variable
        // use constants rather that raw values since thats bad style >:(
        final String NIG = "Nigeria";
        final String GER = "Germany";
        System.out.println(NIG + " vs " + GER);

        int i = 1;
        char c = '1';
        String s = "1";
        
        // casting
        c = (char)(i+'0');
        s = i + "";
        i = c - '0';
        s = c + "";
        i = Integer.parseInt(s);
        c = s.charAt(0);

        float test = 5.0f/9.0f;
        test = (float) (5.0/9.0);
        System.out.println(test);

        double d1 = 3.5 / 2.6; // ok
        System.out.println ("d = " + d1); // prints d = 

        d1 = (int) 3.5 / 2.6;
        System.out.println ("d = " + d1);

        d1 = (int) (3.5) / 2.6;
        System.out.println ("d = " + d1);

        d1 = (int) (3.5 / 2.6);
        System.out.println ("d = " + d1);

        //d1 = int 3.5 / 2.6;   // error because...

        d1 = 3.5 / (int) 2.6; // ok, but assigns d1 3.5 divided by the int 2
        System.out.println ("d = " + d1);

        d1 = (float) (int) (3.5 / 2.6);
        System.out.println ("d = " + d1);

        float pay = 42234.45f; //ok
        long bigValue = 45243224L; //ok
        double amount = 345.45d; //ok
        System.out.printf("Pay: %f, bigValue: %d, amount: %f", pay, bigValue, amount);
    }
}
