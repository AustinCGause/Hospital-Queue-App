package mainpackage;
import java.util.Scanner;

public class Main {

    public static void initialLoginMessage() {
        System.out.println("\n~~~SGMC Hospital Patient Queue System v0.3~~~");
        System.out.println("          ~~Welcome back Austin~~");
    }

    public static int mainMenuSelection(Scanner input) {
        HelperClass.seperator();
        // FIXME: Turn these options into an array for scalability
        System.out.println("What would you like to do?");
        System.out.println("1) Register a new patient");
        System.out.println("2) View & edit a current patients information");
        System.out.println("3) View the active queue");
        System.out.print("4) Log out\n\n> ");

        // FIXME: Add a "try catch" instance here to make sure program doesn't crash if an unsupported value is given
        int userSelection = Integer.parseInt(input.nextLine());

        return userSelection;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Room.setRooms();

        initialLoginMessage();

        HelperClass.enumerateRooms(Room.listRooms);

        masterWhile : {
            while (true) {
                switch (mainMenuSelection(input)) {

                    // FIXME: make a method to check whether a patients information is identical to one that already exists
                    case 1:
                        Patient.patientRegistration(input);
                        break;

                    case 2:
                        Patient.searchForPatient(input);
                        break;

                    // FIXME: Make a method to show the active queue
                    case 3:
                        Hospital.displayActiveQueue();
                        break;

                    case 4:
                        break masterWhile;

                    default:
                        System.out.println("\n!!!!!Please enter a valid option!!!!!");
                }
            }
        }

        HelperClass.seperator();
        System.out.println("Thank you for using the SGMC Patient Queueing System! :)\n");
        input.close();
    }
}