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

    // updates (or places) ships of known valid details
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

    // automatic method to get a grid arrays from a file
    public static char[][] getGrid(String header, int gridSize, String fileName){
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
        }

        return grid;
    }

    // automatic method to get a grid arrays from a file
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

    // checks to see if a grid meets the lose condition
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

    // updates (or places) ships of known valid details
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
            System.out.println("You have already shot at this coordinate before, please retry.");
            validShot = false;
        } else if (target.shipsGrid[row][column] != EMPTY_CHAR && target.shipsGrid[row][column] != HIT_CHAR && target.shipsGrid[row][column] != MISS_CHAR){
            target.shipsGrid[row][column] = HIT_CHAR;
            shooter.shotsGrid[row][column] = HIT_CHAR;
        } else {
            target.shipsGrid[row][column] = MISS_CHAR;
            shooter.shotsGrid[row][column] = MISS_CHAR;
        }

        return validShot;

    }

    public void loadGrids(char[][] savedShipsGrid, char[][] savedShotsGrid){
        this.shipsGrid = savedShipsGrid;
        this.shotsGrid = savedShotsGrid;
    }

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
