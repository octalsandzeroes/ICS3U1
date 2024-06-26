import java.util.*;
import java.io.*;

public class BattleshipRunner{
    public static void main(String[] args) {
        // static variables for the grid size and number of ships
        final int GRID_SIZE = 10;
        final int NUM_SHIPS = 5;
        // static array variables for the lengths and characters associated with each ship
        // array format = [Destroyer, Cruiser, Submarine, Battleship, Carrier]
        final int[] SHIP_SIZE_ARRAY = {2, 3, 3, 4, 5};
        final char[] SHIP_CHAR_ARRAY = {'D', 'C', 'S', 'B', 'A'};
        final String[] SHIP_NAME_ARRAY = {"Destroyer", "Cruiser", "Submarine", "Battleship", "Aircraft Carrier"};

        char[][] PlayerShipsGrid;
        char[][] CPUShipsGrid;
        String inputCoord;
        String shipStartCoord;
        String shipEndCoord;
        boolean validCoord = false;
        boolean validPlace = false;

        Scanner sc = new Scanner(System.in);

        // creates the grid objects for the player and CPU
        Grids Player = new Grids(GRID_SIZE);
        Grids CPU = new Grids(GRID_SIZE);

        // prints the empty grid to start the game
        Player.printGrid();

        // creates the player ship objects
        for (int i = 0; i < NUM_SHIPS; i++){
            do {
                // prompts for a starting coordinate and checks if it is valid
                System.out.printf("Enter the start coordinate of your %s in \"[Column],[Row]\": ", SHIP_NAME_ARRAY[i]);
                do {
                    inputCoord = getString(sc);
                    validCoord = Grids.coordCheck(inputCoord, GRID_SIZE);
                    if (validCoord == false) System.out.print("Invalid coordinate, please retry: ");
                } while (validCoord == false);
                shipStartCoord = Grids.convertCoord(inputCoord);
                validCoord = false;
                // prompts for a ending coordinate and checks if it is valid
                System.out.printf("Enter the end coordinate of your %s in \"[Column],[Row]\": ", SHIP_NAME_ARRAY[i]);
                do {
                    inputCoord = getString(sc);
                    validCoord = Grids.coordCheck(inputCoord, GRID_SIZE);
                    if (validCoord == false) System.out.print("Invalid coordinate, please retry: ");
                } while (validCoord == false);
                shipEndCoord = Grids.convertCoord(inputCoord);
                validCoord = false;
                // checks if the placement of the ship is valid
                validPlace = Player.placeCheck(shipStartCoord, shipEndCoord, SHIP_SIZE_ARRAY[i]);
                if (validPlace == false) System.out.println("Invalid ship placement, please retry.");
            } while (validPlace == false);
            validPlace = false;
            // creates a new ship object depending on the current ship (janky but no other viable option)
            switch (i){
                case 0:
                    Ships PDestroyer = new Ships(SHIP_NAME_ARRAY[i], SHIP_CHAR_ARRAY[i], SHIP_SIZE_ARRAY[i], shipStartCoord, shipEndCoord);
                    Player.updateShip(PDestroyer);
                    break;
                case 1:
                    Ships PCruiser = new Ships(SHIP_NAME_ARRAY[i], SHIP_CHAR_ARRAY[i], SHIP_SIZE_ARRAY[i], shipStartCoord, shipEndCoord);
                    Player.updateShip(PCruiser);
                    break;
                case 2:
                    Ships PSubmarine = new Ships(SHIP_NAME_ARRAY[i], SHIP_CHAR_ARRAY[i], SHIP_SIZE_ARRAY[i], shipStartCoord, shipEndCoord);
                    Player.updateShip(PSubmarine);
                    break;
                case 3:
                    Ships PBattleship = new Ships(SHIP_NAME_ARRAY[i], SHIP_CHAR_ARRAY[i], SHIP_SIZE_ARRAY[i], shipStartCoord, shipEndCoord);
                    Player.updateShip(PBattleship);
                    break;
                case 4:
                    Ships PAircraftCarrier = new Ships(SHIP_NAME_ARRAY[i], SHIP_CHAR_ARRAY[i], SHIP_SIZE_ARRAY[i], shipStartCoord, shipEndCoord);
                    Player.updateShip(PAircraftCarrier);
                    break;
                default:
                    break;
            }

            Player.printGrid();
        }

        // creates the CPU ship objects
        for (int i = 0; i < NUM_SHIPS; i++){
            do {
                // prompts for a starting coordinate and checks if it is valid
                shipStartCoord = (Math.random()*10) + "," + (Math.random()*10);
                // prompts for a ending coordinate and checks if it is valid
                shipEndCoord = (Math.random()*10) + "," + (Math.random()*10);
                // checks if the placement of the ship is valid
                validPlace = CPU.placeCheck(shipStartCoord, shipEndCoord, SHIP_SIZE_ARRAY[i]);
            } while (validPlace == false);
            validPlace = false;
            // creates a new ship object depending on the current ship (janky but no other viable option)
            switch (i){
                case 0:
                    Ships CDestroyer = new Ships(SHIP_NAME_ARRAY[i], SHIP_CHAR_ARRAY[i], SHIP_SIZE_ARRAY[i], shipStartCoord, shipEndCoord);
                    CPU.updateShip(CDestroyer);
                    break;
                case 1:
                    Ships CCruiser = new Ships(SHIP_NAME_ARRAY[i], SHIP_CHAR_ARRAY[i], SHIP_SIZE_ARRAY[i], shipStartCoord, shipEndCoord);
                    CPU.updateShip(CCruiser);
                    break;
                case 2:
                    Ships CSubmarine = new Ships(SHIP_NAME_ARRAY[i], SHIP_CHAR_ARRAY[i], SHIP_SIZE_ARRAY[i], shipStartCoord, shipEndCoord);
                    CPU.updateShip(CSubmarine);
                    break;
                case 3:
                    Ships CBattleship = new Ships(SHIP_NAME_ARRAY[i], SHIP_CHAR_ARRAY[i], SHIP_SIZE_ARRAY[i], shipStartCoord, shipEndCoord);
                    CPU.updateShip(CBattleship);
                    break;
                case 4:
                    Ships CAircraftCarrier = new Ships(SHIP_NAME_ARRAY[i], SHIP_CHAR_ARRAY[i], SHIP_SIZE_ARRAY[i], shipStartCoord, shipEndCoord);
                    CPU.updateShip(CAircraftCarrier);
                    break;
                default:
                    break;
            }

            CPU.printGrid();
        }
    }

    // automatic method to get a string
    public static String getString(Scanner sc){
        String userInput = sc.nextLine();
        return userInput;
    }

    // automatic method to get a char
    public static char getChar(Scanner sc){
        String userInput;
        char charInput = (char) -1;
        boolean validChar = false;

        do {
            try{
                userInput = sc.nextLine();
                if (userInput.length() == 1){
                    charInput = userInput.charAt(0);
                    validChar = true;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.print("Invalid input, please retry: ");
            }
        } while (validChar == false);

        return charInput;
    }

    // automatic method to get an integer
    public static int getInt(Scanner sc){
        int intInput = -1;
        boolean validInt = false;

        do {
            try{
                intInput = Integer.parseInt(sc.nextLine());
                validInt = true;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input, please retry: ");
            }
        } while (validInt == false);

        return intInput;
    }
}