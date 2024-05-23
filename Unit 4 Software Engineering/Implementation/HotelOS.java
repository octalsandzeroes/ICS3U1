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
        String loginString;
        String employeeName;
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
                    case 1:
                        fileArray = getfile(ROOMS_LIST);
                        matchArray = getnotmatch(getfile(RESERVATIONS_LIST), getdate(sc));
                        if (fileArray[0].compareTo("") == 0){
                            System.out.println("No available rooms.\n");
                        } else if (matchArray[0].compareTo("") == 0){
                            System.out.println("All rooms are available: ");
                            for (int i = 0; i < fileArray.length; i++){
                                System.out.printf("%d) Room %s%n", i+1, fileArray[i]);
                            }
                        } else {
                            dateAvailableRoomsArray = getdateavailablerooms(fileArray, matchArray);
                            System.out.println("The available rooms are: ");
                            for (int i = 0; i < dateAvailableRoomsArray.length; i++){
                                System.out.printf("%d) Room %s%n", i+1, fileArray[i]);
                            }
                        }
                        taskDone = true;
                        validOption = false;
                        break;
                    case 2:
                        matchArray = getmatch(getfile(RESERVATIONS_LIST), getdate(sc));
                        System.out.println("Guest Name|Date Booked|Room Number|Employee Name");
                        for (String i: matchArray){
                            System.out.println(i);
                        }
                        taskDone = true;
                        validOption = false;
                        break;
                    case 3:
                        taskDone = true;
                        validOption = false;
                        break;
                    case 4:
                        taskDone = true;
                        validOption = false;
                        break;
                    case 5:
                        taskDone = true;
                        validOption = false;
                        break;
                    case 6:
                        taskDone = true;
                        validOption = false;
                        break;
                    case 7:
                        taskDone = true;
                        validOption = false;
                        break;
                    case 8:
                        taskDone = true;
                        validOption = false;
                        break;
                    case 9:
                        taskDone = true;
                        validOption = false;
                        break;
                    case 10:
                        taskDone = true;
                        validOption = false;
                        break;
                    case 11:
                        taskDone = true;
                        validOption = false;
                        break;
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
            }
        }
    }

    /*====================================================================
    |  String getname(Scanner sc)                                        |
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


    public static String getdate (Scanner sc){
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
                    if (Integer.parseInt(dateCheckArray[0]) >= 1 && Integer.parseInt(dateCheckArray[0]) <= 31 && 
                    Integer.parseInt(dateCheckArray[1]) >= 1 && Integer.parseInt(dateCheckArray[1]) <= 12 && 
                    Integer.parseInt(dateCheckArray[2]) >= 2024 && Integer.parseInt(dateCheckArray[2]) <= 2054){
                            validDate = true;
                    }
                } catch (NumberFormatException e){
                    System.out.print("Invalid date, please retry: ");
                }
            }
            if (validDate == false) System.out.print("Invalid date, please retry: ");
        }

        return date;
    }


    public static String[] getfile (String fileName){
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
        
        // assigns the data from each line into each index in the file storing array
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


    public static String[] getmatch (String[] fileArray, String match){
        String[] matchArray;
        String[] parsedArray;
        int arraySizeCounter = 0;

        if (fileArray[0].compareTo("") != 0){
            for (int i = 0; i < fileArray.length; i++){
                // initializes the string with parsed data from each element of the file storing array
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
                    // initializes the string with parsed data from each element of the file storing array
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

    public static String[] getnotmatch (String[] fileArray, String match){
        String[] notMatchArray;
        String[] parsedArray;
        int arraySizeCounter = 0;
        boolean validMatch = false;
        
        if (fileArray[0].compareTo("") != 0){
            for (int i = 0; i < fileArray.length; i++){
                // initializes the string with parsed data from each element of the file storing array
                parsedArray =  fileArray[i].split("\\|", 0);
                // compares the parsed array with the data to match and increments a counter if a match is not detected
                for (int j = 0; j < parsedArray.length; j++){
                    if (parsedArray[j].compareTo(match) == 0){
                        validMatch = true;
                    }
                }
                if (validMatch == false){
                    arraySizeCounter++;
                }
                validMatch = false;
            }

            if (arraySizeCounter != 0){
                notMatchArray = new String[arraySizeCounter];
                arraySizeCounter = 0;

                for (int i = 0; i < fileArray.length; i++){
                    // initializes the string with parsed data from each element of the file storing array
                    parsedArray =  fileArray[i].split("\\|", 0);
                    // compares the parsed array with the data to match and saves the data if no match is detected
                    for (int j = 0; j < parsedArray.length; j++){
                        if (parsedArray[j].compareTo(match) == 0){
                            validMatch = true;
                        }
                    }
                    if (validMatch == false){
                        notMatchArray[arraySizeCounter] = fileArray[i];
                        arraySizeCounter++;
                    }
                    validMatch = false;
                }
            } else {
                notMatchArray = new String[1];
                notMatchArray[0] = "";
            }
        } else {
            notMatchArray = new String[1];
            notMatchArray[0] = "";
        }

        return notMatchArray;
    }

    
    public static String[] getdateavailablerooms (String[] fileArray, String[] notMatchArray){
        String[] dateAvailableRoomArray;
        int arraySizeCounter = 0;

        for (int i = 0; i < fileArray.length; i++){
            for (int j = 0; j < notMatchArray.length; j++){
                if (fileArray[i].compareTo(notMatchArray[j].split("\\|", 0)[3]) == 0){
                    arraySizeCounter++;
                }
            }
        }
        
        if (arraySizeCounter != 0){
            dateAvailableRoomArray = new String[arraySizeCounter];
            arraySizeCounter = 0;

            for (int i = 0; i < fileArray.length; i++){
                for (int j = 0; j < notMatchArray.length; j++){
                    if (fileArray[i].compareTo(notMatchArray[j].split("\\|", 0)[3]) == 0){
                        dateAvailableRoomArray[arraySizeCounter] = fileArray[i];
                    }
                }
            }
        } else {
            dateAvailableRoomArray = new String[1];
            dateAvailableRoomArray[0] = "";
        }

        return dateAvailableRoomArray;
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
        final String exitCode = "0";
        
        int intCheck;
        String lineIn;
        String loginString = null, employeeID = null, pin = null;
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
                System.out.print("Enter a 4 digit pin or enter \"0\" to go back: ");
                while (employeeIDCheck == true && pinCheck == false){
                    // gets a legal employee ID
                    do {
                        // gets a numerical pin
                        try{
                            pin = sc.nextLine();
                            intCheck = Integer.parseInt(pin);

                            // checks if the pin is the exit code or if it is invalid
                            if (pin.compareTo(exitCode) == 0){
                                employeeIDCheck = false;
                            } else if (pin.length() != 4){
                                System.out.print("Invalid pin, please retry: ");
                                pin = null;
                            }
                        } catch (NumberFormatException e){
                            System.out.print("Invalid pin, please retry: ");
                            pin = null;
                        }
                    } while (pin == null || pin.length() != 4 && pin.compareTo(exitCode) != 0);
                    
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



}
