import java.util.*;
import java.io.*;

/*
 * BatextshipRunner
 *
 * By Andrew Martinus
 *
 * Last modified on June 17, 2024
 *
 * This program is the main class of a text-based implementation of the classic Battleship game featuring
 * a manual setup and saving/loading game functionality, rulebook, and an AI opponent
 */

public class BatextshipRunner{
    public static void main(String[] args) {
        // static variables for the grid size and number of ships
        final int GRID_SIZE = 10;
        final int NUM_SHIPS = 5;
        // static array variables for the lengths and characters associated with each ship
        // array format = [Destroyer, Cruiser, Submarine, Battleship, Carrier]
        final int[] SHIP_SIZE_ARRAY = {2, 3, 3, 4, 5};
        final char[] SHIP_CHAR_ARRAY = {'D', 'C', 'S', 'B', 'A'};
        final String[] SHIP_NAME_ARRAY = {"Destroyer", "Cruiser", "Submarine", "Battleship", "Aircraft Carrier"};
        final String PLAYER_SHIPS_HEADER = "Player ships:";
        final String PLAYER_SHOTS_HEADER = "Player shots:";
        final String CPU_SHIPS_HEADER = "CPU ships:";
        final String CPU_SHOTS_HEADER = "CPU shots:";
        final String SURRENDER_CHAR = "0";
        final String SAVE_CHAR = "1";
        
        // character arrays for parsing file data
        char[][] playerShipsGrid;
        char[][] cpuShipsGrid;
        char[][] playerShotsGrid;
        char[][] cpuShotsGrid;
        // string variables for inputs and storing coordinates
        String saveFileName;
        String inputCoord;
        String shotCoord;
        String shipStartCoord;
        String shipEndCoord;
        // integer variable for menu choice
        int menuChoice = 0;
        // boolean check variables
        boolean validCoord = false;
        boolean validPlace = false;
        boolean validLoad = true;
        boolean validShot = true;
        boolean playerFirst = true;
        boolean gameEnd = false;
        boolean quitGame = false;

        Scanner sc = new Scanner(System.in);

        while (quitGame == false){
            // prints the game choices
            System.out.println("\n[Batextships]");
            System.out.println("1) New Game");
            System.out.println("2) Load Game");
            System.out.println("3) List Rules");
            System.out.println("4) Quit Game");
            // gets a valid integer choice from the user
            System.out.print("Enter a choice: ");

            menuChoice = getInt(sc);

            // creates the grid objects for the player and CPU
            Grids Player = new Grids(GRID_SIZE);
            Grids CPU = new Grids(GRID_SIZE);

            switch (menuChoice){
                case 1:
                    // prints the empty grid to start the game
                    System.out.println();
                    Player.printPlaceGrid();
                    // creates the player ship objects
                    for (int i = 0; i < NUM_SHIPS; i++){
                        do {
                            // prompts for a starting coordinate and checks if it is valid
                            System.out.printf("Enter the start coordinate of your %s (length of %d) in \"[COLUMN],[ROW]\" format: ", SHIP_NAME_ARRAY[i], SHIP_SIZE_ARRAY[i]);
                            do {
                                inputCoord = getString(sc);
                                validCoord = Grids.coordCheck(inputCoord, GRID_SIZE);
                                if (validCoord == false) System.out.print("Invalid coordinate, please retry: ");
                            } while (validCoord == false);
                            shipStartCoord = Grids.convertCoord(inputCoord);
                            validCoord = false;
                            // prompts for a ending coordinate and checks if it is valid
                            System.out.printf("Enter the end coordinate of your %s (length of %d) in \"[COLUMN],[ROW]\" format: ", SHIP_NAME_ARRAY[i], SHIP_SIZE_ARRAY[i]);
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
                        Player.placeShip(SHIP_CHAR_ARRAY[i], shipStartCoord, shipEndCoord);
                        // prints the updated grid
                        System.out.println();
                        Player.printPlaceGrid();
                    }

                    // creates the CPU ship objects
                    for (int i = 0; i < NUM_SHIPS; i++){
                        do {
                            // prompts for a starting coordinate and checks if it is valid
                            shipStartCoord = (int) (Math.random()*10) + "," + (int) (Math.random()*10);
                            // prompts for a ending coordinate and checks if it is valid
                            shipEndCoord = (int) (Math.random()*10) + "," + (int) (Math.random()*10);
                            // checks if the placement of the ship is valid
                            validPlace = CPU.placeCheck(shipStartCoord, shipEndCoord, SHIP_SIZE_ARRAY[i]);
                        } while (validPlace == false);
                        // System.out.println(shipStartCoord + "  " + shipEndCoord);
                        validPlace = false;
                        // creates a new ship object depending on the current ship (janky but no other viable option)
                        CPU.placeShip(SHIP_CHAR_ARRAY[i], shipStartCoord, shipEndCoord);
                        // CPU.printPlaceGrid();
                    }

                    System.out.println("\n[Player Grids]");
                    Player.printGrids();
                    // System.out.println("\n[CPU Grids]");
                    // CPU.printGrids();

                    // randomizes who goes first
                    // player turn
                    if ((int) (Math.random()*2) == 0){
                        playerFirst = true;
                    // cpu turn
                    } else {
                        playerFirst = false;
                    }

                    // prints the result of the first turn randomization
                    if (playerFirst == true){
                        System.out.println("The player has the first move!");
                    } else {
                        System.out.println("The CPU has the first move!");
                    }

                    break;
                case 2:
                    System.out.print("Enter the name of your save file: ");
                    saveFileName = getString(sc);

                    try{
                        BufferedReader testIn = new BufferedReader(new FileReader(saveFileName));
                        testIn.readLine();
                        validLoad = true;
                        testIn.close();
                    } catch (IOException e){
                        System.out.println("Oops, something went wrong with the file " + e.getMessage());
                        validLoad = false;
                        gameEnd = true;
                    }
                    
                    // runs to get the player ships and shots grids only if the valid load boolean is true
                    if (validLoad == true){
                        playerShipsGrid = Grids.getGrid(PLAYER_SHIPS_HEADER, GRID_SIZE, saveFileName);
                        playerShotsGrid = Grids.getGrid(PLAYER_SHOTS_HEADER, GRID_SIZE, saveFileName);
                        
                        // runs to check the player ships grid only if the valid load boolean is true
                        if (validLoad == true){
                            /*
                            for (int i = 0; i < GRID_SIZE; i++){
                                for (int j = 0; j < GRID_SIZE; j++){
                                    System.out.print(playerShipsGrid[i][j]);
                                }
                                System.out.println();
                            }
                            */

                            if (playerShipsGrid == null){
                                System.out.println("Invalid or missing data detected in save file.");
                                validLoad = false;
                                gameEnd = true;
                            } else {
                                validLoad = Grids.checkShipsGrid(playerShipsGrid, SHIP_CHAR_ARRAY, GRID_SIZE);
                                if (validLoad == false){
                                    System.out.println("Invalid or missing data detected in save file.");
                                    validLoad = false;
                                    gameEnd = true;
                                }
                            }
                        }

                        // runs to check the player shots grid only if the valid load boolean is true
                        if (validLoad == true){
                            if (playerShotsGrid == null){
                                System.out.println("Invalid or missing data detected in save file.");
                                validLoad = false;
                                gameEnd = true;
                            } else {
                                validLoad = Grids.checkShotsGrid(playerShotsGrid, GRID_SIZE);
                                if (validLoad == false){
                                    System.out.println("Invalid or missing data detected in save file.");
                                    validLoad = false;
                                    gameEnd = true;
                                }
                            }
                        }

                        // passes the valid grids to the object as fields
                        if (validLoad == true){
                            Player.loadGrids(playerShipsGrid, playerShotsGrid);
                            System.out.println("\n[Player Grids]");
                            Player.printGrids();
                        }
                    }

                    // runs to get the CPU ships and shots grid only if the valid load boolean is true
                    if (validLoad == true){
                        cpuShipsGrid = Grids.getGrid(CPU_SHIPS_HEADER, GRID_SIZE, saveFileName);
                        cpuShotsGrid = Grids.getGrid(CPU_SHOTS_HEADER, GRID_SIZE, saveFileName);

                        // runs to check the CPU ships grid only if the valid load boolean is true
                        if (validLoad == true){
                            if (cpuShipsGrid == null){
                                System.out.println("Invalid or missing data detected in save file.");
                                validLoad = false;
                                gameEnd = true;
                            } else {
                                validLoad = Grids.checkShipsGrid(cpuShipsGrid, SHIP_CHAR_ARRAY, GRID_SIZE);
                                if (validLoad == false){
                                    System.out.println("Invalid or missing data detected in save file.");
                                    validLoad = false;
                                    gameEnd = true;
                                }
                            }
                        }

                        // runs to check CPU shots grid only if the valid load boolean is true
                        if (validLoad == true){
                            if (cpuShotsGrid == null){
                                System.out.println("Invalid or missing data detected in save file.");
                                validLoad = false;
                                gameEnd = true;
                            } else {
                                validLoad = Grids.checkShotsGrid(cpuShotsGrid, GRID_SIZE);
                                if (validLoad == false){
                                    System.out.println("Invalid or missing data detected in save file.");
                                    validLoad = false;
                                    gameEnd = true;
                                }
                            }
                        }

                        // passes the valid grids to the object as fields
                        if (validLoad == true){
                            CPU.loadGrids(cpuShipsGrid, cpuShotsGrid);
                            // System.out.println("\n[CPU Grids]");
                            // CPU.printGrids();
                        }
                    }

                    // prints that the player has the first move as the player save functionality saves on the player's turn
                    if (validLoad == true){
                        playerFirst = true;
                        System.out.println("The player has the first move!");
                    }
                    break;
                // display the game rules
                case 3:
                    System.out.println("\nWelcome to Batextships!");
                    System.out.println();
                    System.out.println("Battleship is a game played by two players. Each player has two boards that they play with: ");
                    System.out.println("the ship board, and the shots board. Each board is a 10 x 10 grid.");
                    System.out.println();
                    System.out.println("At the beginning of the game, each player will place 5 ships of different sizes on the ship board. ");
                    System.out.println("The ships and their sizes are:");
                    for (int i = 0; i < SHIP_NAME_ARRAY.length; i++){
                        System.out.printf(" - %s (%d squares long) [%c]%n", SHIP_NAME_ARRAY[i], SHIP_SIZE_ARRAY[i], SHIP_CHAR_ARRAY[i]);    
                    }
                    System.out.println();
                    System.out.println("The ships may be placed vertically or horizontally, but NOT diagonally.");
                    System.out.println();
                    System.out.println("After the ships have been placed, the players then take turns firing shots at their opponent's ships.");
                    System.out.println("A shot is fired by choosing a location by giving the coordinates corresponding to a row and column in [COLUMN],[ROW] form.");
                    System.out.println("The player is then told whether it is a hit (if the square contains one of their opponent's ships) ");
                    System.out.println("or a miss (if the square does not contain a ship). The results of the guess are then recorded on the shots board,");
                    System.out.println("with an 'X' signifying a hit and an 'O' signifying a miss. Squares not fired at yet are represent by a '-'.");
                    System.out.println();
                    System.out.println("When the opponent fires at a player, the results of the opponent's guess are recorded on the player's ship board.");
                    System.out.println("A ship is sunk if all squares on that ship have been hit.");
                    System.out.println("The game is won when all of an opponent's ships have been sunk.");
                    System.out.println();
                    System.out.println("Presently, this implementation of Battleship allows the player to play against an AI opponent as the second player.");
                    System.out.println("For the best experience possible, please play in fullscreen mode.");
                    System.out.println();
                    System.out.println("Good luck and have fun playing Batextships!");
                    System.out.println();
                    break;
                // quit game option
                case 4:
                    quitGame = true;
                    break;
                default:
                    System.out.println("Invalid input, please retry.");
                    break;
            }        

            // while loop to stay inside of when the game is running
            while (gameEnd == false && (menuChoice == 1 || menuChoice == 2)){
                if (playerFirst == true){
                    if (gameEnd == false){
                        do{
                            // prompts for a starting coordinate and checks if it is valid
                            System.out.printf("Enter \"%s\" to surrender, or enter \"%s\" to save the game progress.%n", SURRENDER_CHAR, SAVE_CHAR);
                            System.out.printf("Otherwise, enter a coordinate to shoot at in \"[COLUMN],[ROW]\" format: ");
                            do {
                                inputCoord = getString(sc);
                                if (inputCoord.compareTo(SURRENDER_CHAR) == 0) {
                                    gameEnd = true;
                                } else if (inputCoord.compareTo(SAVE_CHAR) == 0 ){
                                    System.out.print("Enter the name of the file to save to: ");
                                    saveFileName = getString(sc);
                                    if (Grids.saveGrids(saveFileName, GRID_SIZE, Player, CPU, PLAYER_SHIPS_HEADER, PLAYER_SHOTS_HEADER, CPU_SHIPS_HEADER, CPU_SHOTS_HEADER) == true){
                                        System.out.println("\nGrids saved.");
                                    }
                                    System.out.printf("Enter \"%s\" to surrender, or enter \"%s\" to save the game progress.%n", SURRENDER_CHAR, SAVE_CHAR);
                                    System.out.printf("Otherwise, enter a coordinate to shoot at in \"[COLUMN],[ROW]\" format: ");
                                } else {
                                    validCoord = Grids.coordCheck(inputCoord, GRID_SIZE);
                                    if (validCoord == false) System.out.print("Invalid coordinate, please retry: ");
                                }
                            } while (validCoord == false && gameEnd == false);
                            if (gameEnd == false){
                                shotCoord = Grids.convertCoord(inputCoord);
                                validCoord = false;

                                validShot = Grids.updateShot(shotCoord, Player, CPU);
                            }
                        } while (validShot == false);

                        // forfeiture check
                        if (gameEnd == false){
                            System.out.print("\nPlayer Turn:");
                            System.out.println("\n[Player Grids]");
                            Player.printGrids();
                            // System.out.println("\n[CPU Grids]");
                            // CPU.printGrids();

                            gameEnd = CPU.checkLoss();
                            if (gameEnd == true){
                                System.out.println("Player Win!");
                            }
                        } else {
                            System.out.println("\nThe player has surrendered.");
                        }
                    }

                    if (gameEnd == false){
                        do{
                            // generates a coordinate
                            shotCoord = (int) (Math.random()*10) + "," + (int) (Math.random()*10);
                            validShot = Grids.updateShot(shotCoord, CPU, Player);
                        } while (validShot == false);

                        System.out.print("CPU Turn:");
                        System.out.println("\n[Player Grids]");
                        Player.printGrids();
                        // System.out.println("\n[CPU Grids]");
                        // CPU.printGrids();

                        gameEnd = Player.checkLoss();
                        if (gameEnd == true){
                            System.out.println("CPU Win!");
                        }
                    }
                } else {
                    if (gameEnd == false){
                        do{
                            // generates a coordinate
                            shotCoord = (int) (Math.random()*10) + "," + (int) (Math.random()*10);
                            validShot = Grids.updateShot(shotCoord, CPU, Player);
                        } while (validShot == false);

                        System.out.print("CPU Turn:");
                        System.out.println("\n[Player Grids]");
                        Player.printGrids();
                        // System.out.println("\n[CPU Grids]");
                        // CPU.printGrids();

                        gameEnd = Player.checkLoss();
                        if (gameEnd == true){
                            System.out.println("CPU Win!");
                        }
                    }

                    if (gameEnd == false){
                        do{
                            // prompts for a starting coordinate and checks if it is valid
                            System.out.printf("Enter \"%s\" to surrender, or enter \"%s\" to save the game progress.%n", SURRENDER_CHAR, SAVE_CHAR);
                            System.out.printf("Otherwise, enter a coordinate to shoot at in \"[COLUMN],[ROW]\" format: ");
                            do {
                                inputCoord = getString(sc);
                                if (inputCoord.compareTo(SURRENDER_CHAR) == 0) {
                                    gameEnd = true;
                                } else if (inputCoord.compareTo(SAVE_CHAR) == 0 ){
                                    System.out.print("Enter the name of the file to save to: ");
                                    saveFileName = getString(sc);
                                    if (Grids.saveGrids(saveFileName, GRID_SIZE, Player, CPU, PLAYER_SHIPS_HEADER, PLAYER_SHOTS_HEADER, CPU_SHIPS_HEADER, CPU_SHOTS_HEADER) == true){
                                        System.out.println("Grids saved.");
                                    }
                                    System.out.printf("Enter \"%s\" to surrender, or enter \"%s\" to save the game progress.%n", SURRENDER_CHAR, SAVE_CHAR);
                                    System.out.printf("Otherwise, enter a coordinate to shoot at in \"[COLUMN],[ROW]\" format: ");
                                } else {
                                    validCoord = Grids.coordCheck(inputCoord, GRID_SIZE);
                                    if (validCoord == false) System.out.print("Invalid coordinate, please retry: ");
                                }
                            } while (validCoord == false && gameEnd == false);
                            if (gameEnd == false){
                                shotCoord = Grids.convertCoord(inputCoord);
                                validCoord = false;

                                validShot = Grids.updateShot(shotCoord, Player, CPU);
                            }
                        } while (validShot == false);

                        // forfeiture check
                        if (gameEnd == false){
                            System.out.print("Player Turn:");
                            System.out.println("\n[Player Grids]");
                            Player.printGrids();
                            // System.out.println("\n[CPU Grids]");
                            // CPU.printGrids();

                            gameEnd = CPU.checkLoss();
                            if (gameEnd == true){
                                System.out.println("Player Win!");
                            }
                        } else {
                            System.out.println("The player has surrendered.");
                        }
                    }
                }
            }
        
            if (quitGame == true){
                System.out.println("Game Ended.");
                Player.clearGrids();
                CPU.clearGrids();
                gameEnd = false;
            }
        }

        sc.close();
    }

    /*====================================================================
    |  String getString (Scanner sc)                                     |
    |--------------------------------------------------------------------|
    |  Scanner sc - The System.in scanner object                         |
    |--------------------------------------------------------------------|
    |  returns String - A valid string                                   |
    |--------------------------------------------------------------------|
    |  This method prompts and gets a string input from the user         |
    ====================================================================*/
    public static String getString(Scanner sc){
        String userInput = sc.nextLine();
        return userInput;
    }

    /*=====================================================================
    |  String getChar (Scanner sc)                                        |
    |---------------------------------------------------------------------|
    |  Scanner sc - The System.in scanner object                          |
    |---------------------------------------------------------------------|
    |  returns char - A valid character                                   |
    |---------------------------------------------------------------------|
    |  This method prompts and gets a valid character input from the user |
    =====================================================================*/
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

    /*====================================================================
    |  String getInt (Scanner sc)                                        |
    |--------------------------------------------------------------------|
    |  Scanner sc - The System.in scanner object                         |
    |--------------------------------------------------------------------|
    |  returns int - A valid int                                         |
    |--------------------------------------------------------------------|
    |  This method prompts and gets a valid integer input from the user  |
    ====================================================================*/
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