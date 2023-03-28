package mainpackage;
import java.util.Scanner;

public class Main {

    // FIXME: IS THIS WORKING??????
    public static void loginMessage() {
        System.out.println("\n~~~SGMC Hospital Patient Queue System v0.2~~~");
        System.out.println("          ~~Welcome back Austin~~");
    }

    public static void mainMenuSelectionMessages() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1) Register a new patient");
        System.out.println("2) View a current patients information");
        System.out.print("3) Log out\n\n> ");
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

        // FIXME: Refactor this in some way to reduce nesting, I.E. method or otherwise
        // Script to confirm patient information is accurate
        System.out.println("\nIs the below information accurate?\n");
        newPatient.printPatientInformation();
        System.out.print("\n1 for y, 2 for n: ");
        userSelection = Integer.parseInt(input.nextLine());
        if (userSelection == 2) {
            while (true) {
                System.out.println("\nWhat information is incorrect?");
                System.out.println("1) Patient Name (current name: " + newPatient.patientName + ")");
                System.out.println("2) Patient Age (current age: " + newPatient.patientAge);
                System.out.print("3) Patient Insurance Status (current status: " + newPatient.hasInsurance + ")\n\n> ");
                userSelection = Integer.parseInt(input.nextLine());
                switch (userSelection) {
                    // FIXME: add options for changing specific user info
                }
            }
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
                    case 1:
                        patientRegistrationMenuOption(input, userSelection);
                        break;

                    // Case 2 is for viewing a patients information
                    case 2:
                        // FIXME
                        break;

                    // Case 3 "logs out" the user, a.k.a. shuts down the program
                    case 3:
                        break masterWhile;
                }
            }
        }
        System.out.println("\nThank you for using the SGMC Patient Queueing System! :)");
        // Closes the scanner to prevent data leaks
        input.close();
    }
}