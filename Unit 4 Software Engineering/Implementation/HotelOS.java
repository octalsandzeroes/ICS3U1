import java.util.*;
import java.io.*;

public class HotelOS {
    public static void main(String[] args) {
        final String EMPLOYEE_LIST = "employeelist.txt";
        final String RESERVATIONS_LIST = "reservationslist.txt";
        final String ROOMS_LIST = "roomslist.txt";
        final String ADMIN_ID = "000000";
        final String ADMIN_OPTIONS = "1) List the available rooms for a given date\n" + //
                                    "2) List all the reservations for a given date\n" + //
                                    "3) Look up all the reservations made under a certain name\n" + //
                                    "4) Make a reservation for a room\n" + //
                                    "5) Cancel a reservation for a room\n" + //
                                    "6) Change the details on a reservation\n" + //
                                    "7) Change PIN number\n" + //
                                    "0) Log out\n";

        Scanner sc = new Scanner(System.in);
        
        int loginType = 0;
        String loginString;
        String employeeName;

        while (true){
            do {
                loginString = employeelogin(sc, EMPLOYEE_LIST, ADMIN_ID);
                loginType = Integer.parseInt(loginString.split("\\|", 4)[0]); // | is a metacharacter in regex, so it has to be escape charactered
                employeeName = loginString.split("\\|", 4)[3];
            } while (loginType == 0);
/*
            try {  
                BufferedReader in = new BufferedReader(new FileReader(EMPLOYEE_LIST));
                int counter = 0;
                String lineIn = in.readLine();
                while (lineIn != null){
                    counter++;
                    lineIn = in.readLine();
                }
                String[] strarr = new String[counter];
                counter = 0;
                in.close();

                BufferedReader in2 = new BufferedReader(new FileReader(EMPLOYEE_LIST));
                lineIn = in2.readLine();
                while (counter < strarr.length){
                    strarr[counter] = lineIn;
                    lineIn = in2.readLine();
                    counter++;
                }
                
                for (int i = 0; i < strarr.length; i++){
                    System.out.println(strarr[i]);
                }
                in2.close();
            } catch (IOException e){
                System.out.println("E");
            }
*/
            while (loginType == 1){
                
            }

            while (loginType == 2){
                
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
