package Ex07;

import java.util.*;

/*
Energy
By Andrew Martinus
Last modified on Feb 21, 2024
This program prompts the user for a mass in kilograms and prints how much energy it is equivalent to
*/

public class Energy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double energy;
        double mass;
        double c = 300000000d;

        System.out.print("E=mc^2 Calculator\n\nEnter a mass in kilograms: ");
        mass = sc.nextDouble();
        energy = mass * Math.pow(c, 2);
        System.out.printf("Following the equation, your %.2fkg mass is equivalent to %,.2fJ of energy.%nThat's enough to power about %,d 100W lightbulbs for 1 hour.%n", mass, energy, Math.round(energy/360000));
    }
}
