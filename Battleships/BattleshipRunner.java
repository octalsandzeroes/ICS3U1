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
        final char[] SHIP_CHAR_ARRAY = {'D', 'C', 'S', 'B', 'C'};

        String inputCoords;

        // creates the grid objects for the player and CPU
        Grids PlayerShips = new Grids(GRID_SIZE);
        Grids CPUShips = new Grids(GRID_SIZE);
        Grids PlayerShots = new Grids(GRID_SIZE);
        Grids CPUShots = new Grids(GRID_SIZE);

        for (int i = 0; i < NUM_SHIPS; i++){
            
        }
    } 
}