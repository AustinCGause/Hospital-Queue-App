package hospitalQueue.mainPackage;
import java.util.*;

public class Patient {

    String patientName;
    int patientAge;
    int patientId;
    boolean hasInsurance;

    public static enum PatientState {
        WAITING_ROOM,
        IN_ROOM,
        SEEN_BY_NURSE,
        SEEN_BY_DOCTOR,
        CHECK_OUT,
        AWAY
    }
    private PatientState patientStage;

    public static List<Integer> listIdNumbers = new ArrayList<Integer>();

    public static void printPatientIdNumbers() {
        System.out.println(Arrays.toString(listIdNumbers.toArray()));
    }

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

    public static void patientStageSelectionPrompt() {
        System.out.println("\nWhich stage would you like to move the patient to?");
        System.out.println("1) Waiting room");
        System.out.println("2) In room");
        System.out.println("3) Seen by nurse");
        System.out.println("4) Seen by doctor");
        System.out.println("5) Checking out");
        System.out.print("6) Away (Checked Out)\n\n> ");
    }

    public void setPatientStage(int userSelection) {
        switch(userSelection) {
            case 1:
                this.patientStage = PatientState.WAITING_ROOM;
                break;
            case 2:
                this.patientStage = PatientState.IN_ROOM;
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
}