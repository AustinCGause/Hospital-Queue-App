package mainpackage;

import java.util.*;

public class Room {

    public static List<Room> listRooms = new ArrayList<>();

    public static void setRooms() {
        Room pediatrics1 = new Room();
        Room pediatrics2 = new Room();
        Room emergencyRoom1 = new Room();
        Room emergencyRoom2 = new Room();
        Room outpatient1 = new Room();
        Room outpatient2 = new Room();
        Room orthopedics1 = new Room();
        Room orthopedics2 = new Room();

        listRooms.addAll(Arrays.asList(
            pediatrics1, pediatrics2, 
            emergencyRoom1, emergencyRoom2, 
            outpatient1, outpatient2, 
            orthopedics1, orthopedics2
        ));
    }

}