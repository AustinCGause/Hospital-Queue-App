package mainpackage;
import mainpackage.Patient.PatientState;

public class PatientBuilder {

    private static int generatePatientIdNumber() {
        int idNumber = (int)Math.floor(Math.random() * (999_999 - 100_000 + 1) + 100_000);

        while (Patient.listIdNumbers.contains(idNumber)) {
            idNumber = (int)Math.floor(Math.random() * (999_999 - 100_000 + 1) + 100_000);
        }
        Patient.listIdNumbers.add(idNumber);

        return idNumber;
    }

    String patientName = "John Doe";
    int patientAge = 0;
    public int patientId = 123_456;
    boolean hasInsurance = false;
    PatientState patientStage = PatientState.WAITING_ROOM;
    
    PatientBuilder setPatientName(String patientName) {
        this.patientName = patientName;
        return this;
    }

    PatientBuilder setPatientAge(int patientAge) {
        this.patientAge = patientAge;
        return this;
    }

    PatientBuilder setInsuraceStatus(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
        return this;
    }

    PatientBuilder setPatientStage(PatientState patientStage) {
        this.patientStage = patientStage;
        return this;
    }

    Patient build() {
        this.patientId = generatePatientIdNumber();
        Hospital.mapAllPatients.put(this.patientId, new Patient(patientName, patientAge, patientId, hasInsurance, patientStage));
        return new Patient(patientName, patientAge, patientId, hasInsurance, patientStage);
    }
}