import java.util.*;
import java.io.*;

public class HotelOS {
    public static void main(String[] args){
        final String EMPLOYEE_LIST = "employeelist.txt";
        final String RESERVATIONS_LIST = "reservationslist.txt";
        final String ROOMS_LIST = "roomslist.txt";
        final String ADMIN_ID = "000000";
        final String ADMIN_OPTIONS = "\n1) List the available rooms for a given date\n" + //
                                    "2) List all the reservations for a given date\n" + //
                                    "3) List all the reservations made under a certain name\n" + //
                                    "4) Make a reservation for a room\n" + //
                                    "5) Cancel a reservation for a room\n" + //
                                    "6) Change the details on a reservation\n" + //
                                    "7) Change PIN number\n" + //
                                    "8) Add a hotel room\n" + //
                                    "9) Delete a hotel room\n" + //
                                    "10) Add an employee\n" + //
                                    "11) Delete an employee\n" + //
                                    "0) Log out\n";
        final String GENERAL_OPTIONS = "\n1) List the available rooms for a given date\n" + //
                                    "2) List all the reservations for a given date\n" + //
                                    "3) Look up all the reservations made under a certain name\n" + //
                                    "4) Make a reservation for a room\n" + //
                                    "5) Cancel a reservation for a room\n" + //
                                    "6) Change the details on a reservation\n" + //
                                    "7) Change PIN number\n" + //
                                    "0) Log out\n";

        Scanner sc = new Scanner(System.in);
        
        String[] fileArray;
        String[] matchArray;
        String[] dateAvailableRoomsArray;
        String[] loginStringArray;
        String loginString;
        String employeeName;
        String selectedLine;
        String newLine;
        int loginType = 0;
        int userInput = -1;
        boolean validOption = false;
        boolean taskDone = true;

        while (true){
            do {
                loginString = employeelogin(sc, EMPLOYEE_LIST, ADMIN_ID);
                loginType = Integer.parseInt(loginString.split("\\|", 4)[0]); // | is a metacharacter in regex, so it has to be escape charactered
                employeeName = loginString.split("\\|", 4)[3];
            } while (loginType == 0);

            while (loginType == 1){
                if (taskDone == true){
                    System.out.println(ADMIN_OPTIONS);
                    System.out.print("Enter a numeric option: ");
                    taskDone = false;
                }

                while (validOption == false){
                    try {
                        userInput = Integer.parseInt(sc.nextLine());
                        validOption = true;
                    } catch (NumberFormatException e){
                        System.out.print("Invalid option, please retry: ");
                    }
                }

                switch (userInput){
                    // 1) List the available rooms for a given date
                    case 1:
                        // gets the list of all existing rooms
                        fileArray = getfile(ROOMS_LIST);
                        
                        // gets the list of reserved rooms for a given date
                        matchArray = getmatch(getfile(RESERVATIONS_LIST), getdate(sc));

                        // if there are no rooms in the hotel 
                        if (fileArray[0].compareTo("") == 0){
                            System.out.println("\nThere are no available rooms.\n");
                        // if there are no reserved rooms
                        } else if (matchArray[0].compareTo("") == 0){
                            System.out.println("\nAll rooms are available: ");
                            for (int i = 0; i < fileArray.length; i++){
                                System.out.printf("%d) Room %s%n", i+1, fileArray[i]);
                            }
                        } else {
                            dateAvailableRoomsArray = getdateavailablerooms(fileArray, matchArray);
                            // if some rooms are available
                            if (dateAvailableRoomsArray[0].compareTo("") != 0){
                                System.out.println("\nThe available rooms are: ");
                                for (int i = 0; i < dateAvailableRoomsArray.length; i++){
                                    System.out.printf("%d) Room %s%n", i+1, dateAvailableRoomsArray[i]);
                                }
                            // if all rooms are unavailable
                            } else {
                                System.out.println("\nThere are no available rooms.");
                            }
                        }  
                        taskDone = true;
                        validOption = false;
                        break;
                    // 2) List all the reservations for a given date
                    case 2:
                        // gets the reservations matching a given date
                        matchArray = getmatch(getfile(RESERVATIONS_LIST), getdate(sc));
                        System.out.println("\nThe reservations for that date are as follows: ");
                        System.out.println("Guest Name|Date Booked|Room Number|Employee Name");
                        for (String i: matchArray){
                            System.out.println(i);
                        }
                        taskDone = true;
                        validOption = false;
                        break;
                    // 3) List all the reservations made under a certain name
                    case 3:
                        // gets the reservations matching a given name
                        matchArray = getmatch(getfile(RESERVATIONS_LIST), getname(sc));
                        System.out.println("\nThe reservations for that name are as follows: ");
                        System.out.println("Guest Name|Date Booked|Room Number|Employee Name");
                        for (String i: matchArray){
                            System.out.println(i);
                        }
                        taskDone = true;
                        validOption = false;
                        break;
                    // 4) Make a reservation for a room
                    case 4:
                        // gets the details for a new reservations and concatonizes them into a string
                        newLine = createreservation(sc, ROOMS_LIST, RESERVATIONS_LIST, employeeName);
                        // writes to the reservation file if a reservation is available
                        if (newLine.compareTo("") != 0){
                            System.out.println("\nReservation created:");
                            System.out.println(newLine);
                            writetofile(RESERVATIONS_LIST, newLine);
                        }
                        taskDone = true;
                        validOption = false;
                        break;
                    // 5) Cancel a reservation for a room
                    case 5:
                        // prints the list of reservations and gets a selected reservation
                        selectedLine = selectreservation(sc, RESERVATIONS_LIST);
                        // overwrites the file without the selected reservation if a reservation is able to be selected
                        if (selectedLine.compareTo("") != 0){
                            System.out.println("Reservation removed.");
                            deleteline(RESERVATIONS_LIST, selectedLine);
                        } else {
                            System.out.println("\nThere are no available reservations.");
                        }
                        taskDone = true;
                        validOption = false;
                        break;
                    // 6) Change the details on a reservation
                    case 6:
                        // prints the list of reservations and gets a selected reservation
                        selectedLine = selectreservation(sc, RESERVATIONS_LIST);
                        // writes to the reservation file the replacement if a reservation is able to be selected
                        if (selectedLine.compareTo("") != 0){
                            // removes the old reservation entry
                            deleteline(RESERVATIONS_LIST, selectedLine);
                            // gets the new details to edit the reservation and concatonizes them into a string
                            newLine = createreservation(sc, ROOMS_LIST, RESERVATIONS_LIST, employeeName);
                            // writes to the reservation file if a reservation is available
                            if (newLine.compareTo("") != 0){
                                System.out.println("\nReservation changed:");
                                System.out.println(newLine);
                                writetofile(RESERVATIONS_LIST, newLine);
                            }
                        } else {
                            System.out.println("\nThere are no available reservations.");
                        }
                        taskDone = true;
                        validOption = false;
                        break;
                    // 7) Change PIN number
                    case 7:
                        // gets all employees
                        fileArray = getfile(EMPLOYEE_LIST);

                        // gets the login string without the employee type
                        loginStringArray = loginString.split("\\|", 2);

                        if (fileArray[0].compareTo("") != 0){
                            for (int i = 0; i < fileArray.length; i++){
                                if (fileArray[i].compareTo(loginStringArray[1]) == 0){
                                    // gets the new login string with the new pin
                                    loginStringArray[1] = changepin(sc, EMPLOYEE_LIST, loginString);
                                    // saves the new login string to the login string array
                                    fileArray[i] = loginStringArray[1];
                                    // assigns the login string with the updated information
                                    loginString = loginStringArray[0] + "|" + loginStringArray[1];
                                }
                            }
                            // writes to the employee list file the updated info
                            overwritefile(EMPLOYEE_LIST, fileArray);
                        } else {
                            // gets the new login string with the new pin
                            loginStringArray[1] = changepin(sc, EMPLOYEE_LIST, loginString);
                            // writes to the employee list file the updated info
                            writetofile(EMPLOYEE_LIST, loginStringArray[1]);
                            // assigns the login string with the updated information
                            loginString = loginStringArray[0] + "|" + loginStringArray[1];
                        }
                        taskDone = true;
                        validOption = false;
                        break;
                    // 8) Add a hotel room
                    case 8:
                        taskDone = true;
                        validOption = false;
                        break;
                    // 9) Delete a hotel room
                    case 9:
                        taskDone = true;
                        validOption = false;
                        break;
                    // 10) Add an employee
                    case 10:
                        taskDone = true;
                        validOption = false;
                        break;
                    // 11) Delete an employee
                    case 11:
                        taskDone = true;
                        validOption = false;
                        break;
                    // 0) Log out
                    case 0:
                        loginType = 0;
                        taskDone = true;
                        validOption = false;
                        break;
                    default:
                        System.out.print("Invalid option, please retry: ");
                        validOption = false;
                        break;
                }
            }

            while (loginType == 2){
                System.out.println(GENERAL_OPTIONS);

                if (taskDone == true){
                    System.out.println(ADMIN_OPTIONS);
                    System.out.print("Enter a numeric option: ");
                    taskDone = false;
                }

                while (validOption == false){
                    try {
                        userInput = Integer.parseInt(sc.nextLine());
                        validOption = true;
                    } catch (NumberFormatException e){
                        System.out.print("Invalid option, please retry: ");
                    }
                }

                switch (userInput){
                    // 1) List the available rooms for a given date
                    case 1:
                        // gets the list of all existing rooms
                        fileArray = getfile(ROOMS_LIST);
                        
                        // gets the list of reserved rooms for a given date
                        matchArray = getmatch(getfile(RESERVATIONS_LIST), getdate(sc));

                        // if there are no rooms in the hotel 
                        if (fileArray[0].compareTo("") == 0){
                            System.out.println("\nThere are no available rooms.\n");
                        // if there are no reserved rooms
                        } else if (matchArray[0].compareTo("") == 0){
                            System.out.println("\nAll rooms are available: ");
                            for (int i = 0; i < fileArray.length; i++){
                                System.out.printf("%d) Room %s%n", i+1, fileArray[i]);
                            }
                        } else {
                            dateAvailableRoomsArray = getdateavailablerooms(fileArray, matchArray);
                            // if some rooms are available
                            if (dateAvailableRoomsArray[0].compareTo("") != 0){
                                System.out.println("\nThe available rooms are: ");
                                for (int i = 0; i < dateAvailableRoomsArray.length; i++){
                                    System.out.printf("%d) Room %s%n", i+1, dateAvailableRoomsArray[i]);
                                }
                            // if all rooms are unavailable
                            } else {
                                System.out.println("\nThere are no available rooms.");
                            }
                        }  
                        taskDone = true;
                        validOption = false;
                        break;
                    // 2) List all the reservations for a given date
                    case 2:
                        // gets the reservations matching a given date
                        matchArray = getmatch(getfile(RESERVATIONS_LIST), getdate(sc));
                        System.out.println("\nThe reservations for that date are as follows: ");
                        System.out.println("Guest Name|Date Booked|Room Number|Employee Name");
                        for (String i: matchArray){
                            System.out.println(i);
                        }
                        taskDone = true;
                        validOption = false;
                        break;
                    // 3) List all the reservations made under a certain name
                    case 3:
                        // gets the reservations matching a given name
                        matchArray = getmatch(getfile(RESERVATIONS_LIST), getname(sc));
                        System.out.println("\nThe reservations for that name are as follows: ");
                        System.out.println("Guest Name|Date Booked|Room Number|Employee Name");
                        for (String i: matchArray){
                            System.out.println(i);
                        }
                        taskDone = true;
                        validOption = false;
                        break;
                    // 4) Make a reservation for a room
                    case 4:
                        // gets the details for a new reservations and concatonizes them into a string
                        newLine = createreservation(sc, ROOMS_LIST, RESERVATIONS_LIST, employeeName);
                        // writes to the reservation file if a reservation is available
                        if (newLine.compareTo("") != 0){
                            System.out.println("\nReservation created:");
                            System.out.println(newLine);
                            writetofile(RESERVATIONS_LIST, newLine);
                        }
                        taskDone = true;
                        validOption = false;
                        break;
                    // 5) Cancel a reservation for a room
                    case 5:
                        // prints the list of reservations and gets a selected reservation
                        selectedLine = selectreservation(sc, RESERVATIONS_LIST);
                        // overwrites the file without the selected reservation if a reservation is able to be selected
                        if (selectedLine.compareTo("") != 0){
                            System.out.println("Reservation removed.");
                            deleteline(RESERVATIONS_LIST, selectedLine);
                        } else {
                            System.out.println("\nThere are no available reservations.");
                        }
                        taskDone = true;
                        validOption = false;
                        break;
                    // 6) Change the details on a reservation
                    case 6:
                        // prints the list of reservations and gets a selected reservation
                        selectedLine = selectreservation(sc, RESERVATIONS_LIST);
                        // writes to the reservation file the replacement if a reservation is able to be selected
                        if (selectedLine.compareTo("") != 0){
                            // removes the old reservation entry
                            deleteline(RESERVATIONS_LIST, selectedLine);
                            // gets the new details to edit the reservation and concatonizes them into a string
                            newLine = createreservation(sc, ROOMS_LIST, RESERVATIONS_LIST, employeeName);
                            // writes to the reservation file if a reservation is available
                            if (newLine.compareTo("") != 0){
                                System.out.println("\nReservation changed:");
                                System.out.println(newLine);
                                writetofile(RESERVATIONS_LIST, newLine);
                            }
                        } else {
                            System.out.println("\nThere are no available reservations.");
                        }
                        taskDone = true;
                        validOption = false;
                        break;
                    // 7) Change PIN number
                    case 7:
                        // gets all employees
                        fileArray = getfile(EMPLOYEE_LIST);

                        // gets the login string without the employee type
                        loginStringArray = loginString.split("\\|", 2);

                        if (fileArray[0].compareTo("") != 0){
                            for (int i = 0; i < fileArray.length; i++){
                                if (fileArray[i].compareTo(loginStringArray[1]) == 0){
                                    // gets the new login string with the new pin
                                    loginStringArray[1] = changepin(sc, EMPLOYEE_LIST, loginString);
                                    // saves the new login string to the login string array
                                    fileArray[i] = loginStringArray[1];
                                    // assigns the login string with the updated information
                                    loginString = loginStringArray[0] + "|" + loginStringArray[1];
                                }
                            }
                            // writes to the employee list file the updated info
                            overwritefile(EMPLOYEE_LIST, fileArray);
                        } else {
                            // gets the new login string with the new pin
                            loginStringArray[1] = changepin(sc, EMPLOYEE_LIST, loginString);
                            // writes to the employee list file the updated info
                            writetofile(EMPLOYEE_LIST, loginStringArray[1]);
                            // assigns the login string with the updated information
                            loginString = loginStringArray[0] + "|" + loginStringArray[1];
                        }
                        taskDone = true;
                        validOption = false;
                        break;
                    // 0) Log out
                    case 0:
                        loginType = 0;
                        taskDone = true;
                        validOption = false;
                        break;
                    default:
                        System.out.print("Invalid option, please retry: ");
                        validOption = false;
                        break;
                }
            }
        }
    }

    /*====================================================================
    |  String getname (Scanner sc)                                       |
    |--------------------------------------------------------------------|
    |  Scanner sc - The System.in scanner object                         |
    |--------------------------------------------------------------------|
    |  returns String - A valid name                                     |
    |--------------------------------------------------------------------|
    |  This method prompts and gets a valid name from the user           |
    ====================================================================*/
    public static String getname(Scanner sc){
	    String nameString;
        boolean validName = true;
        boolean validChar = false;
        int nameCheckCounter = 0;
        int lowercaseCounter = (int) 'a';
        int uppercaseCounter = (int) 'A';
        
        System.out.print("Enter a first and last name like such '[FIRST] [LAST]': ");
        
        do {
            if (validName == false) validName = true;
            nameString = sc.nextLine();
            
            // name validity check
            while (validName == true && nameCheckCounter <= nameString.length() - 1){
                while (validName == true && lowercaseCounter <= (int) 'z'){
                    if (nameString.charAt(nameCheckCounter) == (char) lowercaseCounter || nameString.charAt(nameCheckCounter) == ' '){
                        validChar = true;
                    }
                    lowercaseCounter++;
                }
                while (validName == true && uppercaseCounter <= (int) 'Z'){
                    if (nameString.charAt(nameCheckCounter) == (char) uppercaseCounter || nameString.charAt(nameCheckCounter) == ' '){
                        validChar = true;
                    }
                    uppercaseCounter++;
                }
                if (validChar == true){
                    nameCheckCounter++;
                    validChar = false;
                    lowercaseCounter = (int) 'a';
                    uppercaseCounter = (int) 'A';
                } else {
                    nameCheckCounter = 0;
                    validName = false;
                    validChar = false;
                    lowercaseCounter = (int) 'a';
                    uppercaseCounter = (int) 'A';
                    System.out.print("The name entered is invalid, please retry: ");
                }
            }
        } while (validName == false);

        return nameString;
    }

    /*====================================================================
    |  String getdate (Scanner sc)                                       |
    |--------------------------------------------------------------------|
    |  Scanner sc - The System.in scanner object                         |
    |--------------------------------------------------------------------|
    |  returns String - A valid date                                     |
    |--------------------------------------------------------------------|
    |  This method prompts and gets a valid date from the user           |
    ====================================================================*/
    public static String getdate(Scanner sc){
        final int MIN_DAY = 1;
        final int MIN_MONTH = 1;
        final int MIN_YEAR = 2024;
        final int MAX_DAY = 31;
        final int MAX_MONTH = 12;
        final int MAX_YEAR = 2054;

        String[] dateCheckArray;
        String date = null;
        boolean validDate = false;

        System.out.print("Enter a date in the \"DD/MM/YYYY\" format: ");
        while (validDate == false){
            date = sc.nextLine();
            dateCheckArray = date.split("/", 0);
            // checks the formatting
            if (dateCheckArray.length == 3){
                // checks that the entered date is valid
                try {
                    if (Integer.parseInt(dateCheckArray[0]) >= MIN_DAY && Integer.parseInt(dateCheckArray[0]) <= MAX_DAY && 
                    Integer.parseInt(dateCheckArray[1]) >= MIN_MONTH && Integer.parseInt(dateCheckArray[1]) <= MAX_MONTH && 
                    Integer.parseInt(dateCheckArray[2]) >= MIN_YEAR && Integer.parseInt(dateCheckArray[2]) <= MAX_YEAR){
                        validDate = true;
                    } else {
                        System.out.print("Invalid date, please retry: ");
                    }
                } catch (NumberFormatException e){
                    System.out.print("Invalid date, please retry: ");
                }
            } else {
                System.out.print("Invalid date, please retry: ");
            }
            
        }

        return date;
    }

    /*====================================================================
    |  String getfile (String fileName)                                  |
    |--------------------------------------------------------------------|
    |  String fileName - The string with the name of the file to parse   |
    |--------------------------------------------------------------------|
    |  returns String[] - The contents of the file in an array of lines  |
    |--------------------------------------------------------------------|
    |  This method saves each line in a file to an array                 |
    ====================================================================*/
    public static String[] getfile(String fileName){
        String[] fileArray;
        String lineIn;
        int arraySizeCounter = 0;

        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));

            // gets the number of lines in the file
            lineIn = in.readLine();
            while (lineIn != null){
                arraySizeCounter++;
                lineIn = in.readLine();
            }
            in.close();
        } catch (IOException e){
            System.out.println("An error occured! Please call a support technician. " + e.getMessage());
        }
        
        // assigns the data from each line into each index in the file array
        if (arraySizeCounter != 0){
            fileArray = new String[arraySizeCounter];
            try {
                BufferedReader in = new BufferedReader(new FileReader(fileName));

                lineIn = in.readLine();
                // a for loop can be used since the size of the file has been found
                for (int i = 0; i < arraySizeCounter; i++){
                    fileArray[i] = lineIn;
                    lineIn = in.readLine();
                }
                in.close();
            } catch (IOException e){
                System.out.println("An error occured! Please call a support technician. " + e.getMessage());
            }
        // niche case if there is nothing in the file
        } else {
            fileArray = new String[1];
            fileArray[0] = "";
        }
        
        return fileArray;
    }

    /*====================================================================
    |  getmatch(String[] fileArray, String match)                        |
    |--------------------------------------------------------------------|
    |  String[] fileArray - The array storing an entire file             |
    |--------------------------------------------------------------------|
    |  String match - The string to detect a match to                    |
    |--------------------------------------------------------------------|
    |  returns String[] - The array of matching elements                 |
    |--------------------------------------------------------------------|
    |  This method checks for matches and return an array of matches     |
    ====================================================================*/
    public static String[] getmatch(String[] fileArray, String match){
        String[] matchArray;
        String[] parsedArray;
        int arraySizeCounter = 0;

        if (fileArray[0].compareTo("") != 0){
            for (int i = 0; i < fileArray.length; i++){
                // initializes the string with parsed data from each element of the file array
                parsedArray =  fileArray[i].split("\\|", 0);
                // compares the parsed array with the data to match and increments a counter if a match is detected
                for (int j = 0; j < parsedArray.length; j++){
                    if (parsedArray[j].compareTo(match) == 0){
                        arraySizeCounter++;
                    }
                }
            }

            if (arraySizeCounter != 0){
                matchArray = new String[arraySizeCounter];
                arraySizeCounter = 0;

                for (int i = 0; i < fileArray.length; i++){
                    // initializes the string with parsed data from each element of the file array
                    parsedArray =  fileArray[i].split("\\|", 0);
                    // compares the parsed array with the data to match and increments a counter if a match is detected
                    for (int j = 0; j < parsedArray.length; j++){
                        if (parsedArray[j].compareTo(match) == 0){
                            matchArray[arraySizeCounter] = fileArray[i];
                            arraySizeCounter++;
                        }
                    }
                }
            } else {
                matchArray = new String[1];
                matchArray[0] = "";
            }
        } else {
            matchArray = new String[1];
            matchArray[0] = "";
        }

        return matchArray;
    }

    /*====================================================================
    |  writetofile(String fileName, String newLine)                      |
    |--------------------------------------------------------------------|
    |  String fileName - The name of the file to write to                |
    |--------------------------------------------------------------------|
    |  String newLine - The string to write                              |
    |--------------------------------------------------------------------|
    |  returns void                                                      |
    |--------------------------------------------------------------------|
    |  This method appends data to a file                                |
    ====================================================================*/
    public static void writetofile(String fileName, String newLine){
        final boolean APPEND_STATE = true;
        
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, APPEND_STATE));

            out.write(newLine);
            out.newLine();

            out.close();
        } catch (IOException e){
            System.out.println("An error occured! Please call a support technician. " + e.getMessage());
        }
    }

    /*====================================================================
    |  overwritefile(String fileName, String[] fileArray)                |
    |--------------------------------------------------------------------|
    |  String fileName - The name of the file to write to                |
    |--------------------------------------------------------------------|
    |  String[] fileArray - The string array to overwrite the file with  |
    |--------------------------------------------------------------------|
    |  returns void                                                      |
    |--------------------------------------------------------------------|
    |  This method overwrites data in file                               |
    ====================================================================*/
    public static void overwritefile(String fileName, String[] fileArray){
        final boolean APPEND_STATE = false;
        
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, APPEND_STATE));

            for (int i = 0; i < fileArray.length; i++){
                out.write(fileArray[i]);
                out.newLine();
            }

            out.close();
        } catch (IOException e){
            System.out.println("An error occured! Please call a support technician. " + e.getMessage());
        }
    }
    
    /*====================================================================
    |  deleteline(String fileName, String matchLine)                     |
    |--------------------------------------------------------------------|
    |  String fileName - The name of the file to write to                |
    |--------------------------------------------------------------------|
    |  String matchLine - The string to match                            |
    |--------------------------------------------------------------------|
    |  returns void                                                      |
    |--------------------------------------------------------------------|
    |  This method deletes a line from a file                            |
    ====================================================================*/
    public static void deleteline(String fileName, String matchLine){
        String[] fileArray;
        String[] newFileArray;
        int arraySizeCounter = 0;

        // gets the contents of the file prior to deletion
        fileArray = getfile(fileName);
        // if the file array is not empty
        if (fileArray[0].compareTo("") != 0){
            // reads through the file array and increments a counter if a match is not detected
            for (int i = 0; i < fileArray.length; i++){
                if (fileArray[i].compareTo(matchLine) != 0){
                    arraySizeCounter++;
                }
            }

            if (arraySizeCounter != 0){
                // initializes the new file array and resets the counter
                newFileArray = new String[arraySizeCounter];
                arraySizeCounter = 0;

                // reads through the file array once more adds to the new file array the element in the file array if a match is not detected
                for (int i = 0; i < fileArray.length; i++){
                    if (fileArray[i].compareTo(matchLine) != 0){
                        newFileArray[arraySizeCounter] = fileArray[i];
                        arraySizeCounter++;
                    }
                }

                overwritefile(fileName, newFileArray);
            }
        }
    }

    /*============================================================================
    |  String employeelogin(Scanner sc, String EMPLOYEE_LIST, String ADMIN_ID)   |
    |----------------------------------------------------------------------------|
    |  Scanner sc - The System.in scanner object                                 |
    |----------------------------------------------------------------------------|
    |  String EMPLOYEE_LIST - The string with the employee list file string      |
    |----------------------------------------------------------------------------|
    |  String ADMIN_ID - The string with admin user ID                           |
    |----------------------------------------------------------------------------|
    |  returns String - A login code string                                      |
    |----------------------------------------------------------------------------|
    |  This method prompts for a employee login until it is successful           |
    ============================================================================*/
    public static String employeelogin(Scanner sc, String EMPLOYEE_LIST, String ADMIN_ID){
        final String EXIT_CODE = "0";
        
        String lineIn;
        String loginString = null, employeeID = null, pin = null;
        int intCheck;
        boolean employeeIDCheck = false, pinCheck = false;

        while (employeeIDCheck == false && pinCheck == false){
            System.out.print("Enter a 6 digit integer employee ID: ");
            // gets a legal employee ID
            do {
                try{
                    employeeID = sc.nextLine();
                    intCheck = Integer.parseInt(employeeID);

                    if (employeeID.length() != 6){
                        System.out.print("Invalid employee ID, please retry: ");
                    }
                } catch (NumberFormatException e){
                    System.out.print("Invalid employee ID, please retry: ");
                    employeeID = null;
                }
            } while (employeeID == null || employeeID.length() != 6);
            // validates the employee ID
            try{
                BufferedReader readID = new BufferedReader(new FileReader(EMPLOYEE_LIST));
                // reads through the file to find a matching employee ID
                lineIn = readID.readLine();
                while (lineIn != null && employeeIDCheck == false){
                    if (lineIn.split("\\|", 3)[0].compareTo(employeeID) == 0){ // | is a metacharacter in regex, so it has to be escape charactered
                        employeeIDCheck = true;
                    } else {
                        lineIn = readID.readLine();
                    }
                }
                if (employeeIDCheck == false) System.out.println("The employee ID you entered does not exist.");
            
                // gets a pin and validates it
                System.out.print("Enter a 4-digit pin or enter \"0\" to go abort: ");
                while (employeeIDCheck == true && pinCheck == false){
                    // gets a legal employee ID
                    do {
                        // gets a numerical pin
                        try{
                            pin = sc.nextLine();
                            intCheck = Integer.parseInt(pin);

                            // checks if the pin is the exit code or if it is invalid
                            if (pin.compareTo(EXIT_CODE) == 0){
                                employeeIDCheck = false;
                            } else if (pin.length() != 4){
                                System.out.print("Invalid pin, please retry: ");
                                pin = null;
                            }
                        } catch (NumberFormatException e){
                            System.out.print("Invalid pin, please retry: ");
                            pin = null;
                        }
                    } while (pin == null || pin.length() != 4 && pin.compareTo(EXIT_CODE) != 0);
                    
                    if (pin.compareTo(lineIn.split("\\|", 3)[1]) == 0){
                        pinCheck = true;
                        System.out.printf("%nWelcome %s%n", lineIn.split("\\|", 3)[2]);
                        if (employeeID.compareTo(ADMIN_ID) == 0){
                            loginString = "1|" + lineIn;
                        } else {
                            loginString = "2|" + lineIn;
                        }
                    } else {
                        System.out.print("Invalid pin, please retry: ");
                        pin = null;
                    }
                }

                readID.close();
            } catch (IOException e){
                System.out.println("An error occured! Please call a support technician. " + e.getMessage());
            }
        }

        return loginString;
    }

    /*====================================================================
    |  getdateavailablerooms(String[] fileArray, String[] matchArray)    |
    |--------------------------------------------------------------------|
    |  String[] fileArray - The array storing an entire file             |
    |--------------------------------------------------------------------|
    |  String[] matchArray - The array storing an strings to match       |
    |--------------------------------------------------------------------|
    |  returns String[] - The array of rooms available on a given date   |
    |--------------------------------------------------------------------|
    |  This method finds rooms that are available on a given date        |
    ====================================================================*/
    public static String[] getdateavailablerooms(String[] fileArray, String[] matchArray){
        String[] dateAvailableRoomArray;
        int arraySizeCounter = 0;

        for (int i = 0; i < fileArray.length; i++){
            for (int j = 0; j < matchArray.length; j++){
                // compares total rooms to the section of the reservation string that is the room
                if (fileArray[i].compareTo(matchArray[j].split("\\|", 0)[2]) != 0){
                    arraySizeCounter++;
                }
            }
        }
        
        if (arraySizeCounter != 0){
            dateAvailableRoomArray = new String[arraySizeCounter];
            arraySizeCounter = 0;

            for (int i = 0; i < fileArray.length; i++){
                for (int j = 0; j < matchArray.length; j++){
                    if (fileArray[i].compareTo(matchArray[j].split("\\|", 0)[2]) != 0){
                        dateAvailableRoomArray[arraySizeCounter] = fileArray[i];
                        arraySizeCounter++;
                    }
                }
            }
        } else {
            dateAvailableRoomArray = new String[1];
            dateAvailableRoomArray[0] = "";
        }

        return dateAvailableRoomArray;
    }

    /*=====================================================================================================
    |  createreservation(Scanner sc, String ROOMS_LIST, String RESERVATIONS_LIST, String employeename)    |
    |-----------------------------------------------------------------------------------------------------|
    |  Scanner sc - The System.in scanner object                                                          |
    |-----------------------------------------------------------------------------------------------------|
    |  String ROOMS_LIST - The string of the name of the file listing all the rooms                       |
    |-----------------------------------------------------------------------------------------------------|
    |  String RESERVATIONS_LIST - The string of the name of the file listing all the reservations         |
    |-----------------------------------------------------------------------------------------------------|
    |  String employeeName - The name of the employee currently using the system                          |
    |-----------------------------------------------------------------------------------------------------|
    |  returns String - The reservation created                                                           |
    |-----------------------------------------------------------------------------------------------------|
    |  This method allows the user to create a new reservation for a guest                                |
    =====================================================================================================*/
    public static String createreservation(Scanner sc, String ROOMS_LIST, String RESERVATIONS_LIST, String employeename){
        String[] roomsListArray;
        String[] reservationListArray;
        String[] dateAvailableRoomsArray;
        String reservationString = "";
        String guestName;
        String date;
        int roomChoice;
        boolean validRoomChosen = false;

        // gets a valid name and date
        guestName = getname(sc);
        date = getdate(sc);

        // gets the list of all existing rooms
        roomsListArray = getfile(ROOMS_LIST);
                        
        // gets the list of reserved rooms for a given date
        reservationListArray = getmatch(getfile(RESERVATIONS_LIST), date);

        // if there are no rooms in the hotel 
        if (roomsListArray[0].compareTo("") == 0){
            System.out.println("\nThere are no available rooms.\n");
            reservationString = "";
        // if there are no reserved rooms
        } else {
            // if there are no reservations on a given date, the date available rooms array is the rooms list array 
            if (reservationListArray[0].compareTo("") == 0){
                System.out.println("\nAll rooms are available: ");
                dateAvailableRoomsArray = roomsListArray;
            // otherwise if there are reservations, get the available rooms on the given date
            } else {
                System.out.println("\nThe available rooms are: ");
                dateAvailableRoomsArray = getdateavailablerooms(roomsListArray, reservationListArray);
            }

            // if some rooms are available
            if (dateAvailableRoomsArray[0].compareTo("") != 0){
                for (int i = 0; i < dateAvailableRoomsArray.length; i++){
                    System.out.printf("%d) Room %s%n", i+1, dateAvailableRoomsArray[i]);
                }

                // gets a valid room option
                System.out.print("Enter a numeric option from the list: ");
                while (validRoomChosen == false){
                    try {
                        roomChoice = Integer.parseInt(sc.nextLine());
                        if (roomChoice >= 1 && roomChoice <= dateAvailableRoomsArray.length){
                            // concatonizes the reservation data
                            reservationString = guestName + "|" + date + "|" + dateAvailableRoomsArray[roomChoice-1] + "|" + employeename;
                            validRoomChosen = true;
                        } else {
                            System.out.print("Invalid option, please retry: ");
                        }
                    } catch (NumberFormatException e){
                        System.out.print("Invalid option, please retry: ");
                    }
                }              

            // if all rooms are unavailable
            } else {
                System.out.println("\nThere are no available rooms.");
                reservationString = "";
            }
        }

        return reservationString;
    }


    /*================================================================================================
    |  selectreservation(Scanner sc, String fileName)                                                |
    |------------------------------------------------------------------------------------------------|
    |  Scanner sc - The System.in scanner object                                                     |
    |------------------------------------------------------------------------------------------------|
    |  String fileName - The string of the name of the file listing all the reservations             |
    |------------------------------------------------------------------------------------------------|
    |  returns String - The selected reservation                                                     |
    |------------------------------------------------------------------------------------------------|
    |  This method allows the user to select a reservation from a list                               |
    ================================================================================================*/
    public static String selectreservation(Scanner sc, String fileName){
        String[] reservationListArray;
        String selectedReservation = "";
        int roomChoice;
        boolean validReservationChosen = false;

        reservationListArray = getfile(fileName);
        if (reservationListArray[0].compareTo("") == 0){
            System.out.println("\nThere are no reservations.");
            selectedReservation = "";
        } else {
            System.out.println("\nReservations:");
            System.out.println("Guest Name|Date Booked|Room Number|Employee Name");
            for (int i = 0; i < reservationListArray.length; i++){
                System.out.printf("%d) %s%n", i+1, reservationListArray[i]);
            }

            // gets a valid room option
            System.out.print("Enter a numeric option from the list: ");
            while (validReservationChosen == false){
                try {
                    roomChoice = Integer.parseInt(sc.nextLine());
                    if (roomChoice >= 1 && roomChoice <= reservationListArray.length){
                        // concatonizes the reservation data
                        selectedReservation = reservationListArray[roomChoice-1];
                        validReservationChosen = true;
                    } else {
                        System.out.print("Invalid option, please retry: ");
                    }
                } catch (NumberFormatException e){
                    System.out.print("Invalid option, please retry: ");
                }
            }        
        }

        return selectedReservation;
    }


    /*================================================================================================
    |  changepin(Scanner sc, String EMPLOYEE_LIST, String loginString)                               |
    |------------------------------------------------------------------------------------------------|
    |  Scanner sc - The System.in scanner object                                                     |
    |------------------------------------------------------------------------------------------------|
    |  String EMPLOYEE_LIST - The string of the name of the file listing all the employees           |
    |------------------------------------------------------------------------------------------------|
    |  String loginString - The string containing the details of the user currently logged in        |
    |------------------------------------------------------------------------------------------------|
    |  returns String - The new PIN                                                                  |
    |------------------------------------------------------------------------------------------------|
    |  This method allows the user to change their PIN                                               |
    ================================================================================================*/
    public static String changepin(Scanner sc, String EMPLOYEE_LIST, String loginString){
        final String EXIT_CODE = "0";

        String[] newloginStringArray;
        String newLoginString;
        String newPin;
        int intCheck;
        boolean abortCheck = false;

        newLoginString = loginString.split("\\|", 2)[1]; // assigns the part of the login string without the account type
        newloginStringArray = newLoginString.split("\\|", 0);

        System.out.print("Enter a new 4-digit pin or enter \"0\" to go abort: ");
        do {
            // gets a numerical pin
            try{
                newPin = sc.nextLine();
                intCheck = Integer.parseInt(newPin);

                // checks if the pin is the exit code and if so aborts changing the pin
                if (newPin.compareTo(EXIT_CODE) == 0){
                    abortCheck = true;
                    System.out.println("Pin change aborted.");
                } else if (newPin.length() != 4){
                    System.out.print("Invalid pin, please retry: ");
                    newPin = null;
                }
            } catch (NumberFormatException e){
                System.out.print("Invalid pin, please retry: ");
                newPin = null;
            }
        } while (newPin == null || newPin.length() != 4 && newPin.compareTo(EXIT_CODE) != 0);

        if (abortCheck == false){
            // assigns the new pin to the index in the array corresponding to a pin
            newloginStringArray[1] = newPin;
            newLoginString = newloginStringArray[0] + "|" + newloginStringArray[1] + "|" + newloginStringArray[2];
            System.out.println("Success, your new pin is " + newLoginString);
        } else {
            newLoginString = loginString;
        }

        return newLoginString;
    }
}
