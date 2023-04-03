package mainpackage;

import java.util.*;

public class Room {

    String roomName;
    int roomNumber;
    boolean hasPatient;

    public static List<Room> listRooms = new ArrayList<>();

    public Room (String roomName, int roomNumber, boolean hasPatient) {
        this.roomName = roomName;
        this.roomNumber = roomNumber;
        this.hasPatient = hasPatient;
    }

    public static void setRooms() {
        Room pediatrics1 = new Room("Pediatrics 1", 1001, false);
        Room pediatrics2 = new Room("Pediatrics 2", 1002, false);
        Room emergencyRoom1 = new Room("Emergency Room 1", 2001, false);
        Room emergencyRoom2 = new Room("Emergency Room 2", 2002, false);
        Room outpatient1 = new Room("Outpatient 1", 3001, false);
        Room outpatient2 = new Room("Outpatient 2", 3002, false);
        Room orthopedics1 = new Room("Orthopedics 1", 4001, false);
        Room orthopedics2 = new Room("Orthopedics 2", 4002, false);

        listRooms.addAll(Arrays.asList(
            pediatrics1, pediatrics2, 
            emergencyRoom1, emergencyRoom2, 
            outpatient1, outpatient2, 
            orthopedics1, orthopedics2
        ));
    }

}