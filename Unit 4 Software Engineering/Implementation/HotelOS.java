import java.util.*;
import java.io.*;

public class HotelOS {
    public static void main(String[] args) {
        final String EMPLOYEE_LIST = "employeelist.txt";
        final String RESERVATIONS_LIST = "reservationslist.txt";
        final String ROOMS_LIST = "roomslist.txt";
        final String ADMIN_ID = "000000";
        final String ADMIN_OPTIONS = "\n1) List the available rooms for a given date\n" + //
                                    "2) List all the reservations for a given date\n" + //
                                    "3) Look up all the reservations made under a certain name\n" + //
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
        
        int loginType = 0;
        int userInput = -1;
        String loginString;
        String employeeName;
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

                while (validOption == false) {
                    try {
                        userInput = Integer.parseInt(sc.nextLine());
                        validOption = true;
                    } catch (NumberFormatException e){
                        System.out.print("Invalid option, please retry: ");
                    }
                }

                switch (userInput) {
                    case 1:
                        System.out.println(getname(sc));
                        taskDone = true;
                        validOption = false;
                        break;
                    case 0:
                        loginType = 0;
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
        
        do{
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
                } catch (NumberFormatException e) {
                    System.out.print("Invalid date, please retry: ");
                }
            }
            if (validDate == false) System.out.print("Invalid date, please retry: ");
        }

        return date;
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
                while (employeeIDCheck == true && pinCheck == false) {
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
