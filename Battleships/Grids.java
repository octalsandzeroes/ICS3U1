import java.util.*;
import java.io.*;

public class Grids {
    private char[][] shipsGrid;
    private char[][] shotsGrid;
    private int gridSize;

    public Grids(int gridSize){
        // initializes the ships and shots grids
        this.shipsGrid = new char[gridSize][gridSize];
        this.shotsGrid = new char[gridSize][gridSize];
        this.gridSize = gridSize;
        // fills the ships and shots grids with '-' initially
        for (int i = 0; i < gridSize; i++){
            for (int j = 0; j < gridSize; j++){
                this.shipsGrid[i][j] = '-';
                this.shotsGrid[i][j] = '-';
            }
        }
    }

    // checks and converts the inputted coordinates into their index numerical form (STATIC)
    public static String coordcheck(String charInputCoords, int gridSize){
        // if for example the user enters "A,10", that is "0,9", where it is the first column and tenth row in the 2D array (y,x) or (j,i)
        String row = charInputCoords.split(",", 2)[1];
        String column = charInputCoords.split(",", 2)[0];
        String intInputCoords = "";

        try{
            // checks if the inputted coordinates are within bounds
            if (Integer.parseInt(row) >= 1 && Integer.parseInt(row) <= gridSize){ // the row section of the inputted coordinates will be numerical
                if (column.length() == 1 && (int) column.charAt(0) >= 'A' && (int) column.charAt(0) < ('A' + gridSize)){ // makes sure the column section of the inputted coordinates are within bounds
                    intInputCoords = (Integer.parseInt(row) - 1) + "," + ((int) column.charAt(0) - 'A'); // arrays start at 0, ex: char J = 75, minus char A = 65, thats index 9
                    System.out.println(intInputCoords);
                }
            }
        } catch (NumberFormatException e){
            // skips everything in the if block
        }
        
        return intInputCoords;
    }

    // checks to see if the chosen start and end coordinates are valid (NOT STATIC)
    public boolean placecheck(String shipStartCoords, String shipEndCoords, int shipLength){
        // sets the y and x coordinates from the example form of "0,9", where it is the first column and tenth row in the 2D array (y,x) or (j,i)
        int startRow = Integer.parseInt(shipStartCoords.split(",", 2)[1]);
        int startColumn = Integer.parseInt(shipStartCoords.split(",", 2)[0]);
        int endRow = Integer.parseInt(shipEndCoords.split(",", 2)[1]);
        int endColumn = Integer.parseInt(shipEndCoords.split(",", 2)[0]);
        boolean validPlace = true;

        // checks if the coordinates form a ship of proper length by xoring the length in the row or column sides
        if ((Math.abs(endRow-startRow) == shipLength && Math.abs(endColumn-startColumn) == 0) ^ (Math.abs(endRow-startRow) == 0 && Math.abs(endColumn-startColumn) == shipLength)){
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
    public void updateship(String shipStartCoords, String shipEndCoords, char[] shipArray){
        // sets the y and x coordinates from the example form of "0,9", where it is the first column and tenth row in the 2D array (y,x) or (j,i)
        int startRow = Integer.parseInt(shipStartCoords.split(",", 2)[1]);
        int startColumn = Integer.parseInt(shipStartCoords.split(",", 2)[0]);
        int endRow = Integer.parseInt(shipEndCoords.split(",", 2)[1]);
        int endColumn = Integer.parseInt(shipEndCoords.split(",", 2)[0]);
        int l = 0; // counter for the array storing individual ships

        for (int j = startRow; j <= endRow; j++) { // check this first for array index out of bounds exceptions, (start end index hunch)
            for (int i = startColumn; i <= endColumn; i++) {
                this.shipsGrid[j][i] = shipArray[l];
                l++;
            }
        }
    }  
}
