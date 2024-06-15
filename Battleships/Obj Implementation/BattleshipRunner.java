import java.util.*;

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
        final String PLAYER_SHIPS_HEADER = "Player ships:";
        final String PLAYER_SHOTS_HEADER = "Player shots:";
        final String CPU_SHIPS_HEADER = "CPU ships:";
        final String CPU_SHOTS_HEADER = "CPU shots:";
        final String SURRENDER_CHAR = "0";
        final String SAVE_CHAR = "1";

        char[][] playerShipsGrid;
        char[][] cpuShipsGrid;
        char[][] playerShotsGrid;
        char[][] cpuShotsGrid;
        String saveFileName;
        String inputCoord;
        String shotCoord;
        String shipStartCoord;
        String shipEndCoord;
        int menuChoice = 0;
        boolean validCoord = false;
        boolean validPlace = false;
        boolean validLoad = true;
        boolean validShot = true;
        boolean playerFirst = true;
        boolean gameEnd = false;
        boolean quitGame = false;

        Scanner sc = new Scanner(System.in);
        
        // prints the game choices
        System.out.println("[Batextships]");
        System.out.println("1) New Game");
        System.out.println("2) Load Game");
        System.out.println("3) List Rules");
        System.out.println("4) Quit Game");
        // gets a valid integer choice from the user
        System.out.print("Enter a choice: ");
        while (quitGame == false){
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
                            System.out.printf("Enter the start coordinate of your %s (length of %d) in \"[Column],[Row]\" format: ", SHIP_NAME_ARRAY[i], SHIP_SIZE_ARRAY[i]);
                            do {
                                inputCoord = getString(sc);
                                validCoord = Grids.coordCheck(inputCoord, GRID_SIZE);
                                if (validCoord == false) System.out.print("Invalid coordinate, please retry: ");
                            } while (validCoord == false);
                            shipStartCoord = Grids.convertCoord(inputCoord);
                            validCoord = false;
                            // prompts for a ending coordinate and checks if it is valid
                            System.out.printf("Enter the end coordinate of your %s (length of %d) in \"[Column],[Row]\" format: ", SHIP_NAME_ARRAY[i], SHIP_SIZE_ARRAY[i]);
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
                    System.out.println("\n[CPU Grids]");
                    CPU.printGrids();

                    // randomizes who goes first
                    // player turn
                    if ((int) Math.random()*2 == 0){
                        playerFirst = true;
                    // cpu turn
                    } else {
                        playerFirst = false;
                    }

                    break;
                case 2:
                    System.out.print("Enter the name of your save file: ");
                    saveFileName = getString(sc);
                    
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
                            System.out.println("\n[CPU Grids]");
                            CPU.printGrids();
                        }
                    }

                    // randomizes who goes first
                    // player turn
                    if ((int) Math.random()*2 == 0){
                        playerFirst = true;
                    // cpu turn
                    } else {
                        playerFirst = false;
                    }

                    break;
                // display the game rules
                case 3:
                    
                    break;
                // quit game option
                case 4:
                    quitGame = true;
                    break;
                default:
                    System.out.print("Invalid input, please retry: ");
                    break;
            }        

            // while loop to stay inside of when the game is running
            System.out.println(playerFirst);
            while (gameEnd == false && (menuChoice == 1 || menuChoice == 2)){
                if (playerFirst == true){
                    if (gameEnd == false){
                        do{
                            // prompts for a starting coordinate and checks if it is valid
                            System.out.printf("Enter \"%s\" to surrender, or enter \"%s\" to save the game progress.%n", SURRENDER_CHAR, SAVE_CHAR);
                            System.out.printf("Otherwise, enter a coordinate to shoot at in \"[Column],[Row]\" format: ");
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
                                    System.out.printf("Otherwise, enter a coordinate to shoot at in \"[Column],[Row]\" format: ");
                                } else {
                                    validCoord = Grids.coordCheck(inputCoord, GRID_SIZE);
                                    if (validCoord == false) System.out.print("Invalid coordinate, please retry: ");
                                }
                            } while (validCoord == false && gameEnd == false);
                            shotCoord = Grids.convertCoord(inputCoord);
                            validCoord = false;

                            validShot = Grids.updateShot(shotCoord, Player, CPU);
                        } while (validShot == false);

                        System.out.print("Player Turn:");
                        System.out.println("\n[Player Grids]");
                        Player.printGrids();
                        System.out.println("\n[CPU Grids]");
                        CPU.printGrids();

                        gameEnd = CPU.checkLoss();
                        if (gameEnd == true){
                            System.out.println("Player Win!");
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
                        System.out.println("\n[CPU Grids]");
                        CPU.printGrids();

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
                        System.out.println("\n[CPU Grids]");
                        CPU.printGrids();

                        gameEnd = Player.checkLoss();
                        if (gameEnd == true){
                            System.out.println("CPU Win!");
                        }
                    }

                    if (gameEnd == false){
                        do{
                            // prompts for a starting coordinate and checks if it is valid
                            System.out.printf("Enter \"%s\" to surrender, or enter \"%s\" to save the game progress.%n", SURRENDER_CHAR, SAVE_CHAR);
                            System.out.printf("Otherwise, enter a coordinate to shoot at in \"[Column],[Row]\" format: ");
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
                                    System.out.printf("Otherwise, enter a coordinate to shoot at in \"[Column],[Row]\" format: ");
                                } else {
                                    validCoord = Grids.coordCheck(inputCoord, GRID_SIZE);
                                    if (validCoord == false) System.out.print("Invalid coordinate, please retry: ");
                                }
                            } while (validCoord == false && gameEnd == false);
                            shotCoord = Grids.convertCoord(inputCoord);
                            validCoord = false;

                            validShot = Grids.updateShot(shotCoord, Player, CPU);
                        } while (validShot == false);

                        System.out.print("Player Turn:");
                        System.out.println("\n[Player Grids]");
                        Player.printGrids();
                        System.out.println("\n[CPU Grids]");
                        CPU.printGrids();

                        gameEnd = CPU.checkLoss();
                        if (gameEnd == true){
                            System.out.println("Player Win!");
                        }
                    }
                }
            }
        
            System.out.println("Game Ended.");
            Player.clearGrids();
            CPU.clearGrids();
        }

        sc.close();
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