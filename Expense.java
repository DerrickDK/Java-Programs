//This program asks the user to input a file, calculates the total services in the file, and outputs the value to another .txt file.

import java.io.*;
import java.util.*;
public class Expense {
    //This askUser method's purpose is to ask the user what file he/she is looking for and it returns the value, which is stored in main.
    public static String askUser() {
        Scanner console = new Scanner(System.in);
        System.out.println("Input a file you're looking for: ");
        String enterFile = console.next();
        return enterFile;
    }
    //This fileExist method checks to see if the file the user inputs exist or not. It returns the values true or false.
    public static boolean fileExist(String fileName) {
        File userFile = new File(fileName);
        if (userFile.exists()) {
            return true;
        } else {
            return false;
        }
    }
    //This userFile method's purpose states that once the fileExist, it'll retrieve the file and we store it in main.
    public static File userFile(String fileName) {
        File userFile = new File(fileName);
        return userFile;
    }
    //This scanFile method uses a while loop to scan the text file the user inputs.
    public static void scanFile(File hotelFile) throws FileNotFoundException {
        Scanner scanFile = new Scanner(hotelFile); //Create a Scanner object to scan the user's file which is passed in the parameter.
        double conferenceTot = 0.0;
        double dinnerTot = 0.0;
        double spaTot = 0.0;
        double roomTot = 0.0;
        double lodgingTot = 0.0;
        while (scanFile.hasNextLine()) { //This while loop test the condition that if the user's file has another line in the input
            String fileLine = scanFile.nextLine(); 
            Scanner lineScan = new Scanner(fileLine); //or i could have done new Scanner(fileLine).useDelimiter(";");
            // the new delimiter to tokenize words is a semicolon
            lineScan.useDelimiter(";"); 
            lineScan.next(); 
            String service = lineScan.next(); //second token is the service
            //While scanning the file line by line, once the condition in the if statement is met, the loop proceeds and sums the total service for each service.
            if (service.equals("Conference")) {
                conferenceTot = conferenceTot + lineScan.nextDouble();
            }
            if (service.equals("Dinner")) {
                dinnerTot = dinnerTot + lineScan.nextDouble();
            }
            if (service.equals("Spa")) {
                spaTot = spaTot + lineScan.nextDouble();
            }
            if (service.equals("Room Service")) {
                roomTot = roomTot + lineScan.nextDouble();
            }
            if (service.equals("Lodging")) {
                lodgingTot = lodgingTot + lineScan.nextDouble();
            }
        }
        System.out.printf("Dinner expenses: %.2f\n", dinnerTot);
        System.out.printf("Lodging expenses: %.2f\n", lodgingTot);
        System.out.printf("Conference expenses: %.2f\n", conferenceTot);
        System.out.printf("Room Service expenses: %.2f\n", roomTot);
        System.out.printf("Spa expenses: %.2f\n", spaTot);
        PrintStream out = new PrintStream(new File("hotel_out.txt")); //Outputs each service value into another text file called hotel_out.txt.
        out.printf("Dinner expenses: %.2f\n", dinnerTot);
        out.printf("Lodging expenses: %.2f\n",lodgingTot);
        out.printf("Conference expenses: %.2f\n", conferenceTot);
        out.printf("Room Service expenses: %.2f\n", roomTot);
        out.printf("Spa expenses: %.2f\n", spaTot);
    }
    public static void main(String[] args) throws FileNotFoundException{
        String fileName = askUser();
        boolean fileChecker = fileExist(fileName);
        while (!fileChecker) {
            //while the fileName is not the fileName the user inputs condition is true, let's do these 3 statements to keep asking the user for the right file.
            System.out.println("File does not exist\n");
            fileName = askUser(); //do the askUser() method again.
            fileChecker = fileExist(fileName); //do the fileExist(fileName) method again.
            // loop will end when the condition is false.
        }
        File userFile = userFile(fileName);
        scanFile(userFile); //we only just passed the userFile inside the scanFile(File hotelFile) method

    }
}
