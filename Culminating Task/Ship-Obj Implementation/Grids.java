import java.util.*;
import java.io.*;

public class Grids {
    private char[][] shipsGrid;
    private char[][] shotsGrid;
    private int gridSize;

    public Grids(int gridSize){
        // initializes the ships and shots grids
        this.gridSize = gridSize;
        this.shipsGrid = new char[gridSize][gridSize];
        this.shotsGrid = new char[gridSize][gridSize];
        // fills the ships and shots grids with '-' initially
        for (int i = 0; i < gridSize; i++){
            for (int j = 0; j < gridSize; j++){
                this.shipsGrid[i][j] = '-';
                this.shotsGrid[i][j] = '-';
            }
        }
    }

    public char[][] accessShipsGrid(){
        return this.shipsGrid;
    }

    public char[][] accessShotsGrid(){
        return this.shotsGrid;
    }

    public void printGrid(){
        char[][] gridArray = this.accessShipsGrid();
        String headerString;

        // prints the board during and just after updates
        // prints the header
        System.out.print("   ");
        for (int i = 0; i < this.gridSize; i++){
            System.out.printf(" %c ", (char) (i+'A'));
        }
        System.out.println();
        // prints the body
        for (int i = 0; i < this.gridSize; i++){
            // prints the body header
            headerString = "" + (i+1);
            if (headerString.length() == 1){
                System.out.printf(" %s ", headerString);
            } else if (headerString.length() == 2){
                System.out.printf(" %s", headerString);
            }
            // prints the grid
            for (int j = 0; j < this.gridSize; j++){
                System.out.print(" " + gridArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    // checks the inputted coordinate to see if it is a valid choice
    public static boolean coordCheck(String charInputCoord, int gridSize){
        // if for example the user enters "A,10", that is "0,9", where it is the first column and tenth row in the 2D array (y,x) or (j,i)
        String[] splitCharInputCoord = charInputCoord.split(",", 0);
        String row;
        String column;
        boolean validCoord = false;

        if (splitCharInputCoord.length == 2){
            row = splitCharInputCoord[1];
            column = splitCharInputCoord[0];

            try{
                // checks if the inputted coordinate are within bounds
                if (Integer.parseInt(row) >= 1 && Integer.parseInt(row) <= gridSize){ // the row section of the inputted coordinates will be numerical
                    if (column.length() == 1 && (int) column.charAt(0) >= 'A' && (int) column.charAt(0) < ('A' + gridSize)){ // makes sure the column section of the inputted coordinates are within bounds
                        validCoord = true;
                    }
                }
            } catch (NumberFormatException e){
                // skips everything in the if block
            }
        }
        
        return validCoord;
    }

    // checks and converts the inputted coordinates into their index numerical form (STATIC)
    public static String convertCoord(String charInputCoord){
        // if for example the user enters "A,10", that is "0,9", where it is the first column and tenth row in the 2D array (y,x) or (j,i)
        String row = charInputCoord.split(",", 2)[1];
        String column = charInputCoord.split(",", 2)[0];
        String intInputCoord = (Integer.parseInt(row) - 1) + "," + ((int) column.charAt(0) - 'A'); // arrays start at 0, ex: char J = 75, minus char A = 65, thats index 9
        return intInputCoord;
    }

    // checks to see if the chosen start and end coordinates are valid (NOT STATIC)
    public boolean placeCheck(String shipStartCoord, String shipEndCoord, int shipLength){
        // sets the y and x coordinates from the example form of "0,9", where it is the first column and tenth row in the 2D array (y,x) or (j,i)
        int startColumn = Integer.parseInt(shipStartCoord.split(",", 2)[1]);
        int startRow = Integer.parseInt(shipStartCoord.split(",", 2)[0]);
        int endColumn = Integer.parseInt(shipEndCoord.split(",", 2)[1]);
        int endRow = Integer.parseInt(shipEndCoord.split(",", 2)[0]);
        boolean validPlace = true;

        // checks if the coordinate form a ship of proper length by xoring the length in the row or column sides
        if ((Math.abs(endRow-startRow)+1 == shipLength && Math.abs(endColumn-startColumn) == 0) ^ (Math.abs(endRow-startRow) == 0 && Math.abs(endColumn-startColumn)+1 == shipLength)){ // offset of 1 only for the row/column it actually is in
            // checks if there is any blockages in between
            for (int j = startRow; j <= endRow; j++) { // check this first for array index out of bounds exceptions, (start end index hunch)
                for (int i = startColumn; i <= endColumn; i++) {
                    // if there is a blockage, it is not a valid place
                    if (this.shipsGrid[j][i] != '-'){
                        validPlace = false;
                    }
                }
            }
        } else {
            validPlace = false;
        }
        
        return validPlace;
    }

    // updates (or places) ships of known valid details
    public void updateShip(Ships ship){
        // gets the ship array for a specific ship to act on
        char[] shipArray = ship.accessShipArray();
        String shipStartCoord = ship.accessShipStartCoord();
        String shipEndCoord = ship.accessShipEndCoord();

        // sets the y and x coordinates from the example form of "0,9", where it is the first column and tenth row in the 2D array (y,x) or (j,i)
        int startColumn = Integer.parseInt(shipStartCoord.split(",", 2)[1]);
        int startRow = Integer.parseInt(shipStartCoord.split(",", 2)[0]);
        int endColumn = Integer.parseInt(shipEndCoord.split(",", 2)[1]);
        int endRow = Integer.parseInt(shipEndCoord.split(",", 2)[0]);
        int l = 0; // counter for the array storing individual ships

        /*
        System.out.println(shipStartCoord);
        System.out.println(shipEndCoord);
        System.out.println(startRow + "," + startColumn);
        System.out.println(endRow + "," + endColumn);
        */

        for (int j = startRow; j <= endRow; j++) { // check this first for array index out of bounds exceptions, (start end index hunch)
            for (int i = startColumn; i <= endColumn; i++) {
                this.shipsGrid[j][i] = shipArray[l];
                l++;
            }
        }
    }
}
