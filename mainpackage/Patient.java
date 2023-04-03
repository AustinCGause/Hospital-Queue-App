package mainpackage;
import java.util.*;

public class Patient {

    String patientName;
    int patientAge;
    int patientId;
    boolean hasInsurance;
    Room patientRoom;

    public static enum PatientState {
        WAITING_ROOM,
        IN_ROOM,
        SEEN_BY_NURSE,
        SEEN_BY_DOCTOR,
        CHECK_OUT,
        AWAY
    }
    private PatientState patientStage;

    public static List<Integer> listIdNumbers = new ArrayList<>();

    public Patient(String patientName, int patientAge, int patientId, boolean hasInsurance, PatientState patientStage) {
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientId = patientId;
        this.hasInsurance = hasInsurance;
        this.patientStage = patientStage;
    }

    public void printPatientInformation() {
        System.out.println("Patients name: " + this.patientName);
        System.out.println("Patients age: " + this.patientAge);
        System.out.println("Patients Id Number: " + this.patientId);
        System.out.println("Patient has insurance: " + this.hasInsurance);
        System.out.println("Patients current status: " + this.patientStage);
    }

    public void setPatientStage(Scanner input) {
        PatientHelper.patientStageSelectionPrompt();
        int userSelection = Integer.parseInt(input.nextLine());

        while (userSelection < 1 || userSelection > 6) {
            userSelection = Integer.parseInt(input.nextLine());
        }

        switch(userSelection) {
            case 1:
                this.patientStage = PatientState.WAITING_ROOM;
                break;
            case 2:
                this.patientStage = PatientState.IN_ROOM;
                setPatientRoom(input);
                break;
            case 3:
                this.patientStage = PatientState.SEEN_BY_NURSE;
                break;
            case 4:
                this.patientStage = PatientState.SEEN_BY_DOCTOR;
                break;
            case 5:
                this.patientStage = PatientState.CHECK_OUT;
                break;
            case 6:
                this.patientStage = PatientState.AWAY;
                break;
            default:
                System.out.println("\n!!!!!Please enter a valid option!!!!!");
        }
    }

    public void setPatientRoom(Scanner input) {
        System.out.print("/n What room do you want to assign the patient to?");

        int userSelection = Integer.parseInt(input.nextLine());

        System.out.println(userSelection);
    }

    public void updatePatientInformation(Scanner input, Patient newPatient) {
        int userSelection;

        nestedWhile : {
            while (true) {
                HelperClass.seperator();

                System.out.println("What information would you like to change?");
                System.out.println("1) Patient Name (current name: " + newPatient.patientName + ")");
                System.out.println("2) Patient Age (current age: " + newPatient.patientAge + ")");
                System.out.println("3) Patient Insurance Status (current status: " + newPatient.hasInsurance + ")");
                System.out.print("4) Exit patient information editor\n\n> ");

                userSelection = Integer.parseInt(input.nextLine());
                switch (userSelection) {
                    case 1:
                        break;

                    case 2:
                        break;

                    case 3:
                        break;

                    case 4:
                        break nestedWhile;

                    default:
                        System.out.println("\n!!!!!Please enter a valid option!!!!!");
                }
            }
        }
    }

}