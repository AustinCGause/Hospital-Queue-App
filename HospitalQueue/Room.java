package HospitalQueue;

public class Room {

    int roomNumber;

    public Room(int patientRoom) {
        this.roomNumber = patientRoom;
    }

    public void printRoom() {
        System.out.println("Patient is in room: " + this.roomNumber);
    }

}