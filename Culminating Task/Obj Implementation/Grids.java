import java.io.*;

/*
 * Grids
 *
 * By Andrew Martinus
 *
 * Last modified on June 17, 2024
 *
 * This program is the Grids class of a text-based implementation of the classic Battleship game featuring
 * a manual setup and saving/loading game functionality, rulebook, and an AI opponent.
 * The purpose of this class is to manage the logistics of the grids in play during the game, 
 * as well and the saving and loading to and from files.
 */

public class Grids {
    private char[][] shipsGrid;
    private char[][] shotsGrid;
    private int gridSize;

    /*====================================================================
    |  Constructor method                                                |
    ====================================================================*/
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

    /*========================================================================
    |  String accessShipsGrid()                                              |
    |------------------------------------------------------------------------|
    |  returns char[][] - A 2D ships grid array                              |
    |------------------------------------------------------------------------|
    |  This accessor method returns the ships grid array for a grids object  |
    ========================================================================*/
    public char[][] accessShipsGrid(){
        return this.shipsGrid;
    }

    /*========================================================================
    |  String accessShotsGrid()                                              |
    |------------------------------------------------------------------------|
    |  returns char[][] - A 2D shots grid array                              |
    |------------------------------------------------------------------------|
    |  This accessor method returns the shots grid array for a grids object  |
    ========================================================================*/
    public char[][] accessShotsGrid(){
        return this.shotsGrid;
    }

    /*========================================================================
    |  void printPlaceGrid()                                                |
    |------------------------------------------------------------------------|
    |  returns void                                                          |
    |------------------------------------------------------------------------|
    |  This method prints the player ships grid during ship placement        |
    ========================================================================*/
    public void printPlaceGrid(){
        String headerString;

        // prints the board during and just after updates
        // prints the ships grid header
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
                System.out.print(" " + this.shipsGrid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    /*========================================================================
    |  void printGrids()                                                     |
    |------------------------------------------------------------------------|
    |  returns void                                                          |
    |------------------------------------------------------------------------|
    |  This method prints the ships and shots grids                          |
    ========================================================================*/
    public void printGrids(){
        String headerString;

        // prints the board during and just after updates
        System.out.printf("%-36s%-33s%n", "Ships:", "Shots:");
        // prints the ships grid header
        System.out.print("   ");
        for (int i = 0; i < this.gridSize; i++){
            System.out.printf(" %c ", (char) (i+'A'));
        }
        // prints the shots grid header
        System.out.print("      ");
        for (int i = 0; i < this.gridSize; i++){
            System.out.printf(" %c ", (char) (i+'A'));
        }

        System.out.println();
        // prints the body
        for (int i = 0; i < this.gridSize; i++){
            // prints the ship body header
            headerString = "" + (i+1);
            if (headerString.length() == 1){
                System.out.printf(" %s ", headerString);
            } else if (headerString.length() == 2){
                System.out.printf(" %s", headerString);
            }
            // prints the ships grid
            for (int j = 0; j < this.gridSize; j++){
                System.out.print(" " + this.shipsGrid[i][j] + " ");
            }

            // prints the shots body header
            headerString = "   " + (i+1);
            if (headerString.length() == 4){
                System.out.printf(" %s ", headerString);
            } else if (headerString.length() == 5){
                System.out.printf(" %s", headerString);
            }
            // prints the shots grid
            for (int j = 0; j < this.gridSize; j++){
                System.out.print(" " + this.shotsGrid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    /*=================================================================================================
    |  boolean coordCheck(String charInputCoord, int gridSize)                                        |
    |-------------------------------------------------------------------------------------------------|
    |  String charInputCoord - The inputted character coordinates                                     |
    |-------------------------------------------------------------------------------------------------|
    |  int gridSize - The size of the grid                                                            |
    |-------------------------------------------------------------------------------------------------|
    |  returns boolean - The coordinate check result                                                  |
    |-------------------------------------------------------------------------------------------------|
    |  This method checks to see if an inputted coordinate is a valid one and returns the result      |
    =================================================================================================*/
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

    /*=================================================================================================
    |  String convertCoord(String charInputCoord)                                                     |
    |-------------------------------------------------------------------------------------------------|
    |  String charInputCoord - An string coordinate                                                   |
    |-------------------------------------------------------------------------------------------------|
    |  returns String - The converted coordinates                                                     |
    |-------------------------------------------------------------------------------------------------|
    |  This method converts the inputted coordinates into their array index numerical form            |
    =================================================================================================*/
    // checks and converts the inputted coordinates into their index numerical form (STATIC)
    public static String convertCoord(String charInputCoord){
        // if for example the user enters "A,10", that is "0,9", where it is the first column and tenth row in the 2D array (y,x) or (j,i)
        String row = charInputCoord.split(",", 2)[1];
        String column = charInputCoord.split(",", 2)[0];
        String intInputCoord = (Integer.parseInt(row) - 1) + "," + ((int) column.charAt(0) - 'A'); // arrays start at 0, ex: char J = 75, minus char A = 65, thats index 9
        return intInputCoord;
    }

    /*=================================================================================================
    |  boolean placeCheck(String shipStartCoord, String shipEndCoord, int shipLength)                 |
    |-------------------------------------------------------------------------------------------------|
    |  String shipStartCoord - An individually valid start coordinate                                 |
    |-------------------------------------------------------------------------------------------------|
    |  String shipEndCoord - An individually valid end coordinate                                     |
    |-------------------------------------------------------------------------------------------------|
    |  int shipLength - The size of the ship being placed                                             |
    |-------------------------------------------------------------------------------------------------|
    |  returns boolean - The placement check result                                                   |
    |-------------------------------------------------------------------------------------------------|
    |  This method checks to see if an placement is a valid one and returns the result                |
    =================================================================================================*/
    public boolean placeCheck(String shipStartCoord, String shipEndCoord, int shipLength){
        // sets the y and x coordinates from the example form of "0,9", where it is the first column and tenth row in the 2D array (y,x) or (j,i)
        int startColumn = Integer.parseInt(shipStartCoord.split(",", 2)[1]);
        int startRow = Integer.parseInt(shipStartCoord.split(",", 2)[0]);
        int endColumn = Integer.parseInt(shipEndCoord.split(",", 2)[1]);
        int endRow = Integer.parseInt(shipEndCoord.split(",", 2)[0]);
        int tempReg;
        boolean validPlace = true;

        if (startColumn == endColumn && startRow > endRow){
            tempReg = startRow;
            startRow = endRow;
            endRow = tempReg;
        } else if (startColumn > endColumn && startRow == endRow){
            tempReg = startColumn;
            startColumn = endColumn;
            endColumn = tempReg;
        }

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

    /*=================================================================================================
    |  void placeShip(char shipChar, String shipStartCoord, String shipEndCoord)                      |
    |-------------------------------------------------------------------------------------------------|
    |  int shipChar - The character signifying the ship being placed                                  |
    |-------------------------------------------------------------------------------------------------|
    |  String shipStartCoord - An valid start coordinate                                              |
    |-------------------------------------------------------------------------------------------------|
    |  String shipEndCoord - An valid end coordinate                                                  |
    |-------------------------------------------------------------------------------------------------|
    |  returns void                                                                                   |
    |-------------------------------------------------------------------------------------------------|
    |  This method places ships with known valid start and end coordinates                            |
    =================================================================================================*/
    public void placeShip(char shipChar, String shipStartCoord, String shipEndCoord){
        // sets the y and x coordinates from the example form of "0,9", where it is the first column and tenth row in the 2D array (y,x) or (j,i)
        int startColumn = Integer.parseInt(shipStartCoord.split(",", 2)[1]);
        int startRow = Integer.parseInt(shipStartCoord.split(",", 2)[0]);
        int endColumn = Integer.parseInt(shipEndCoord.split(",", 2)[1]);
        int endRow = Integer.parseInt(shipEndCoord.split(",", 2)[0]);
        int tempReg;

        if (startColumn == endColumn && startRow > endRow){
            tempReg = startRow;
            startRow = endRow;
            endRow = tempReg;
        } else if (startColumn > endColumn && startRow == endRow){
            tempReg = startColumn;
            startColumn = endColumn;
            endColumn = tempReg;
        }

        /*
        System.out.println(shipStartCoord);
        System.out.println(shipEndCoord);
        System.out.println(startRow + "," + startColumn);
        System.out.println(endRow + "," + endColumn);
        */

        for (int j = startRow; j <= endRow; j++) { // check this first for array index out of bounds exceptions, (start end index hunch)
            for (int i = startColumn; i <= endColumn; i++) {
                this.shipsGrid[j][i] = shipChar;
            }
        }
    }

    /*=================================================================================================
    |  char[][] getGrid(String header, int gridSize, String fileName)                                 |
    |-------------------------------------------------------------------------------------------------|
    |  String header - A string header prior to the grid in focus                                     |
    |-------------------------------------------------------------------------------------------------|
    |  int gridSize - The size of the grid                                                            |
    |-------------------------------------------------------------------------------------------------|
    |  String fileName - The name of the file getting parsed                                          |
    |-------------------------------------------------------------------------------------------------|
    |  returns char[][] - The grid from the file                                                      |
    |-------------------------------------------------------------------------------------------------|
    |  This method automatically gets a selected grid from a file                                     |
    =================================================================================================*/
    // automatic method to get a grid arrays from a file
    public static char[][] getGrid(String header, int gridSize, String fileName){
        final char[][] EMPTY_GRID = new char[gridSize][gridSize];

        char[][] grid = new char[gridSize][gridSize];
        String lineIn;

        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            
            lineIn = in.readLine();
            while (lineIn != null){
                if (lineIn.compareTo(header) == 0){
                    for (int i = 0; i < gridSize; i++){
                        lineIn = in.readLine();
                        for (int j = 0; j < gridSize; j++){
                            grid[i][j] = lineIn.charAt(j);
                        }
                    }
                } else {
                    lineIn = in.readLine();
                }
            }

            in.close();
        } catch (IOException e) {
            System.out.println("Oops, something went wrong with the file " + e.getMessage());
            grid = EMPTY_GRID;
        } catch (ArrayIndexOutOfBoundsException f) {
            System.out.println("Oops, something went wrong with grid " + f.getMessage());
            grid = EMPTY_GRID;
        }

        return grid;
    }

    /*=================================================================================================
    |  boolean saveGrids(String fileName, int gridSize, Grids player, Grids CPU,                      |
    |                    String playerShipsHeader, String playerShotsHeader,                          |
    |                    String cpuShipsHeader, String cpuShotsHeader)                                |
    |-------------------------------------------------------------------------------------------------|
    |  String fileName - The name of the file where the grids will be saved                           |
    |-------------------------------------------------------------------------------------------------|
    |  int gridSize - The size of the grid                                                            |
    |-------------------------------------------------------------------------------------------------|
    |  Grids player - The player's grids object                                                       |
    |-------------------------------------------------------------------------------------------------|
    |  Grids CPU - The CPU's grids object                                                             |
    |-------------------------------------------------------------------------------------------------|
    |  String playerShipsHeader - The header for the player's ships grid                              |
    |-------------------------------------------------------------------------------------------------|
    |  String playerShotsHeader - The header for the player's shots grid                              |
    |-------------------------------------------------------------------------------------------------|
    |  String cpuShipsHeader - The header for the CPU's ships grid                                    |
    |-------------------------------------------------------------------------------------------------|
    |  String cpuShotsHeader - The header for the CPU's shots grid                                    |
    |-------------------------------------------------------------------------------------------------|
    |  returns boolean - True if the grids were successfully saved, false otherwise                   |
    |-------------------------------------------------------------------------------------------------|
    |  This method automatically saves the current state of both players' grids to a specified file   |
    =================================================================================================*/
    public static boolean saveGrids(String fileName, int gridSize, Grids player, Grids CPU, String playerShipsHeader, String playerShotsHeader, String cpuShipsHeader, String cpuShotsHeader){
        boolean gridsSavedCheck = false;

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, false));
            
            out.write(playerShipsHeader);
            out.newLine();
            for (int i = 0; i < gridSize; i++){
                for (int j = 0; j < gridSize; j++){
                    out.write(player.shipsGrid[i][j]);
                }
                out.newLine();   
            }

            out.write(cpuShipsHeader);
            out.newLine();
            for (int i = 0; i < gridSize; i++){
                for (int j = 0; j < gridSize; j++){
                    out.write(CPU.shipsGrid[i][j]);
                }
                out.newLine();   
            }

            out.write(playerShotsHeader);
            out.newLine();
            for (int i = 0; i < gridSize; i++){
                for (int j = 0; j < gridSize; j++){
                    out.write(player.shotsGrid[i][j]);
                }
                out.newLine();   
            }

            out.write(cpuShotsHeader);
            out.newLine();
            for (int i = 0; i < gridSize; i++){
                for (int j = 0; j < gridSize; j++){
                    out.write(CPU.shotsGrid[i][j]);
                }
                out.newLine();   
            }

            gridsSavedCheck = true;
            out.close();
        } catch (IOException e) {
            System.out.println("Oops, something went wrong with the file " + e.getMessage());
        }

        return gridsSavedCheck;
    }

    /*==============================================================================================================
    |  boolean checkShipsGrid(char[][] checkSavedGrid, char[] shipCharArray, int gridSize)                         |
    |--------------------------------------------------------------------------------------------------------------|
    |  char[][] checkSavedGrid - The grid to be checked for valid characters                                       |
    |--------------------------------------------------------------------------------------------------------------|
    |  char[] shipCharArray - An array of characters representing the ships                                        |
    |--------------------------------------------------------------------------------------------------------------|
    |  int gridSize - The size of the grid                                                                         |
    |--------------------------------------------------------------------------------------------------------------|
    |  returns boolean - True if the grid contains only valid characters, false otherwise                          |
    |--------------------------------------------------------------------------------------------------------------|
    |  This method checks if a saved ships grid contains only valid characters (empty, hit, miss, or ship pieces)  |
    ==============================================================================================================*/
    public static boolean checkShipsGrid(char[][] checkSavedGrid, char[] shipCharArray, int gridSize){
        final char EMPTY_CHAR = '-';
        final char HIT_CHAR = 'X';
        final char MISS_CHAR = 'O';
        boolean validGrid = true;
        boolean validIndex = false;
        int i = 0;
        int j = 0;

        // nested while loops that run while the grid is valid
        while (i < gridSize && validGrid == true){
            while (j < gridSize && validGrid == true){
                // checks if the square is simply empty or has a hit or miss character
                if (checkSavedGrid[i][j] == EMPTY_CHAR || checkSavedGrid[i][j] == HIT_CHAR || checkSavedGrid[i][j] == MISS_CHAR){
                    validIndex = true;
                // checks if the square has pieces
                } else {
                    for (int k = 0; k < shipCharArray.length; k++){
                        if (checkSavedGrid[i][j] == shipCharArray[k]){
                            validIndex = true;
                        }
                    }
                }
                // if by the end of checking for empty, hit, miss, or ship characters the valid intex variable is still false, the grid is invalid
                if (validIndex == false){
                    validGrid = false;
                }
                j++;
            }
            // reset the j counter, increments the i counter, and index validity boolean
            j = 0;
            i++;
            validIndex = false;
        }

        return validGrid;
    }

    /*==============================================================================================================
    |  boolean checkShotsGrid(char[][] checkSavedGrid, int gridSize)                                               |
    |--------------------------------------------------------------------------------------------------------------|
    |  char[][] checkSavedGrid - The grid to be checked for valid characters                                       |
    |--------------------------------------------------------------------------------------------------------------|
    |  int gridSize - The size of the grid                                                                         |
    |--------------------------------------------------------------------------------------------------------------|
    |  returns boolean - True if the grid contains only valid characters, false otherwise                          |
    |--------------------------------------------------------------------------------------------------------------|
    |  This method checks if a saved shots grid contains only valid characters (empty, hit, or miss)               |
    ==============================================================================================================*/
    public static boolean checkShotsGrid(char[][] checkSavedGrid, int gridSize){
        final char EMPTY_CHAR = '-';
        final char HIT_CHAR = 'X';
        final char MISS_CHAR = 'O';
        boolean validGrid = true;
        boolean validIndex = false;
        int i = 0;
        int j = 0;

        // nested while loops that run while the grid is valid
        while (i < gridSize && validGrid == true){
            while (j < gridSize && validGrid == true){
                // checks if the square is simply empty or has a hit or miss character
                if (checkSavedGrid[i][j] == EMPTY_CHAR || checkSavedGrid[i][j] == HIT_CHAR || checkSavedGrid[i][j] == MISS_CHAR){
                    validIndex = true;
                }
                // if by the end of checking for empty, hit, miss, or ship characters the valid intex variable is still false, the grid is invalid
                if (validIndex == false){
                    validGrid = false;
                }
                j++;
            }
            // reset the j counter, increments the i counter, and index validity boolean
            j = 0;
            i++;
            validIndex = false;
        }

        return validGrid;
    }

    /*======================================================================================================
    |  boolean checkLoss()                                                                                 |
    |------------------------------------------------------------------------------------------------------|
    |  returns boolean - True if the grid meets the lose condition (no ship pieces left), false otherwise  |
    |------------------------------------------------------------------------------------------------------|
    |  This method checks to see if a grid meets the lose condition by verifying                           |
    |  if there are no ship pieces left on the grid.                                                       |
    ======================================================================================================*/
    public boolean checkLoss(){
        final char EMPTY_CHAR = '-';
        final char HIT_CHAR = 'X';
        final char MISS_CHAR = 'O';
        boolean gameEnd = false;
        boolean pieceCharDetected = false;
        int i = 0;
        int j = 0;

        // nested while loops that run while the grid is valid
        while (i < gridSize && gameEnd == false){
            while (j < gridSize && gameEnd == false){
                // checks if the square is simply empty or has a hit or miss character
                if (this.shipsGrid[i][j] != EMPTY_CHAR && this.shipsGrid[i][j] != HIT_CHAR && this.shipsGrid[i][j] != MISS_CHAR){
                    pieceCharDetected = true;
                }
                j++;
            }
            // reset the j counter, increments the i counter, and index validity boolean
            j = 0;
            i++;
        }

        // if by the end of checking for empty, hit, miss, or ship characters the valid intex variable is still false, the grid is invalid
        if (pieceCharDetected == false){
            gameEnd = true;
        }

        return gameEnd;
    }

    /*=================================================================================================
    |  boolean updateShot(String shotCoord, Grids shooter, Grids target)                              |
    |-------------------------------------------------------------------------------------------------|
    |  String shotCoord - The coordinate of the shot                                                  |
    |-------------------------------------------------------------------------------------------------|
    |  Grids shooter - The grids object of the player taking the shot                                 |
    |-------------------------------------------------------------------------------------------------|
    |  Grids target - The grids object of the player being targeted                                   |
    |-------------------------------------------------------------------------------------------------|
    |  returns boolean - True if the shot is valid and updated, false if the shot was a repeat        |
    |-------------------------------------------------------------------------------------------------|
    |  This method updates the grids based on the shot coordinates provided, marking hits and misses. |
    =================================================================================================*/
    public static boolean updateShot(String shotCoord, Grids shooter, Grids target){
        final char EMPTY_CHAR = '-';
        final char HIT_CHAR = 'X';
        final char MISS_CHAR = 'O';

        // sets the y and x coordinates from the example form of "0,9", where it is the first column and tenth row in the 2D array (y,x) or (j,i)
        int column = Integer.parseInt(shotCoord.split(",", 2)[1]);
        int row = Integer.parseInt(shotCoord.split(",", 2)[0]);
        boolean validShot = true;

        // checks if a shot is a repeat, a hit, or a miss
        if (target.shipsGrid[row][column] == HIT_CHAR || target.shipsGrid[row][column] == MISS_CHAR){
            validShot = false;
        } else if (target.shipsGrid[row][column] != EMPTY_CHAR && target.shipsGrid[row][column] != HIT_CHAR && target.shipsGrid[row][column] != MISS_CHAR){
            System.out.println("\nHit detected!");
            target.shipsGrid[row][column] = HIT_CHAR;
            shooter.shotsGrid[row][column] = HIT_CHAR;
        } else {
            target.shipsGrid[row][column] = MISS_CHAR;
            shooter.shotsGrid[row][column] = MISS_CHAR;
        }

        return validShot;
    }

    /*===========================================================================
    |  void loadGrids()                                                         |
    |---------------------------------------------------------------------------|
    |  char[][] savedShipsGrid - A valid saved ships grid                       |
    |---------------------------------------------------------------------------|
    |  char[][] savedShotsGrid - A valid saved shots grid                       |
    |---------------------------------------------------------------------------|
    |  returns void                                                             |
    |---------------------------------------------------------------------------|
    |  This mutator method loads grids by modying the fields of a grid's object |
    ===========================================================================*/
    public void loadGrids(char[][] savedShipsGrid, char[][] savedShotsGrid){
        this.shipsGrid = savedShipsGrid;
        this.shotsGrid = savedShotsGrid;
    }

    /*========================================================================
    |  void clearGrids()                                                     |
    |------------------------------------------------------------------------|
    |  returns void                                                          |
    |------------------------------------------------------------------------|
    |  This method clears a grid object's grids by resetting them to default |
    ========================================================================*/
    public void clearGrids(){
        // fills the ships and shots grids with '-'
        for (int i = 0; i < gridSize; i++){
            for (int j = 0; j < gridSize; j++){
                this.shipsGrid[i][j] = '-';
                this.shotsGrid[i][j] = '-';
            }
        }
    }
}