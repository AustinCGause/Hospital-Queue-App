package mainpackage;
import java.util.Scanner;

public class Main {

    public static void seperator() {
        System.out.println("\n------------------------------\n");
    }

    public static void loginMessage() {
        System.out.println("\n~~~SGMC Hospital Patient Queue System v0.3~~~");
        System.out.println("          ~~Welcome back Austin~~");
    }

    public static void mainMenuSelectionMessages() {
        seperator();
        System.out.println("What would you like to do?");
        System.out.println("1) Register a new patient");
        System.out.println("2) View & edit a current patients information");
        System.out.println("3) View the active queue");
        System.out.print("4) Log out\n\n> ");
    }

    public static void patientRegistrationMenuOption(Scanner input, int userSelection) {

        // Prompts user to enter patients name
        System.out.print("\nPatients Name (First Last): ");
        String newPatientName = input.nextLine();

        // Prompts user to enter patients age
        System.out.print("\nPatients Age: ");
        int newPatientAge = Integer.parseInt(input.nextLine());

        // Prompts user to enter current patient insurance status
        System.out.print("\nPatient has Insurance? (true or false): ");
        boolean patientInsuranceStatus = Boolean.parseBoolean(input.nextLine());

        // Build patient using previously prompted variables
        Patient newPatient = new PatientBuilder()
            .setPatientName(newPatientName)
            .setPatientAge(newPatientAge)
            .setInsuraceStatus(patientInsuranceStatus)
            .build();

        // Prompts user to decide if patient status needs to be immediately updated
        // If the user decides it needs to be updated, they go into a loop that waits until they input a valid selection
        System.out.print("\nAssign patient to waiting room? (1 for y, 2 for n): ");
        userSelection = Integer.parseInt(input.nextLine());

        if (userSelection == 2){
            do {
                Patient.patientStageSelectionPrompt();
                userSelection = Integer.parseInt(input.nextLine());
                newPatient.setPatientStage(userSelection);
            } while (userSelection < 1 || userSelection > 6);
        }

        seperator();

        System.out.println("Is the below information accurate?\n");
        newPatient.printPatientInformation();
        System.out.print("\n1 for y, 2 for n: ");

        userSelection = Integer.parseInt(input.nextLine());
        if (userSelection == 2) {
            newPatient.updatePatientInformation(input, newPatient);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Displays a default login message when the program is first ran
        loginMessage();

        // Break symbol for exiting the whole program upon logout
        masterWhile : {
            while (true) {

                // Prompts user to select an option for what they want to do
                mainMenuSelectionMessages();
                int userSelection = Integer.parseInt(input.nextLine());

                switch (userSelection) {
                    // Case 1 is for registering a new patient
                    // FIXME: make a method to check whether a patients information is identical to one that already exists
                    case 1:
                        patientRegistrationMenuOption(input, userSelection);
                        break;

                    // Case 2 is for viewing a patients information
                    case 2:
                        Patient currentPatient = Patient.searchForPatient(input);

                        seperator();

                        System.out.print("Would you like to update this information? (1 for y, 2 for n): ");
                        userSelection = Integer.parseInt(input.nextLine());

                        if (userSelection == 2) 
                            continue;

                        currentPatient.updatePatientInformation(input, currentPatient);
                        break;

                    // FIXME: Make a method to show the active queue
                    case 3:
                    seperator();
                    for (Integer id: Hospital.mapAllPatients.keySet()) {
                        int key = id;
                        String value = Hospital.mapAllPatients.get(key).patientName;
                        System.out.println(key + ": " + value);
                    }
                    break;

                    // Case 3 "logs out" the user, a.k.a. shuts down the program
                    case 4:
                        break masterWhile;

                    // Default runs when the user inputs an invalid option
                    default:
                        System.out.println("\n!!!!!Please enter a valid option!!!!!");
                }
            }
        }
        seperator();
        System.out.println("Thank you for using the SGMC Patient Queueing System! :)\n");
        // Closes the scanner to prevent data leaks
        input.close();
    }
}