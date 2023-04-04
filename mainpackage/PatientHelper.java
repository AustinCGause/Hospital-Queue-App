package mainpackage;
import java.util.*;

public class PatientHelper {

    public static void printPatientIdNumbers() {
        System.out.println(Arrays.toString(Patient.listIdNumbers.toArray()));
    }

    public static void patientStageSelectionPrompt() {
        System.out.println("\nWhich stage would you like to move the patient to?");
        System.out.println("1) Waiting room");
        System.out.println("2) In room");
        System.out.println("3) Seen by nurse");
        System.out.println("4) Seen by doctor");
        System.out.println("5) Checking out");
        System.out.print("6) Away (Checked Out)\n\n> ");
    }

    public static void searchForPatient(Scanner input) {
        System.out.print("\nPlease enter patient's Id #: ");
        int userInput = Integer.parseInt(input.nextLine());

        HelperClass.seperator();

        Patient currentPatient = Hospital.mapAllPatients.get(userInput);

        currentPatient.printPatientInformation();

        HelperClass.seperator();

        System.out.print("Would you like to update this information?");
        if (HelperClass.yesOrNoSelection(input) == 2) 
            return;

        currentPatient.updatePatientInformation(input, currentPatient);
    }

    public static void patientRegistration(Scanner input) {

        System.out.print("\nPatients Name (First Last): ");
        String newPatientName = input.nextLine();

        System.out.print("\nPatients Age: ");
        int newPatientAge = Integer.parseInt(input.nextLine());

        System.out.print("\nPatient has Insurance? (true or false): ");
        boolean patientInsuranceStatus = Boolean.parseBoolean(input.nextLine());

        Patient newPatient = new PatientBuilder()
            .setPatientName(newPatientName)
            .setPatientAge(newPatientAge)
            .setInsuraceStatus(patientInsuranceStatus)
            .build();

        System.out.println("\nAssign patient to waiting room?");
        if (HelperClass.yesOrNoSelection(input) == 2){
            newPatient.setPatientStage(input);
        }

        HelperClass.seperator();

        System.out.println("Is the below information accurate?\n");
        newPatient.printPatientInformation();
        if (HelperClass.yesOrNoSelection(input) == 2) {
            newPatient.updatePatientInformation(input, newPatient);
        }
    }
    
}
