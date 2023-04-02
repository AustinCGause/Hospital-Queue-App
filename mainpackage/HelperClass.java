package mainpackage;
import java.util.*;

public class HelperClass {
    
    public static void seperator() {
        System.out.println("\n------------------------------\n");
    }

    public static int yesOrNoSelection(Scanner input) {
        System.out.print("\n(1 for y, 2 for n): ");
        int userSelection = Integer.parseInt(input.nextLine());

        return userSelection;
    }

    // FIXME: Make a method that removes the need for a while loop to validate whether a users input is in the correct range

    public static void enumerateRooms(List<Room> listRooms) {

        for (int i = 0; i < listRooms.size(); ++i) {
            System.out.println(i + 1 + ": " + listRooms.get(i).roomName);
        }

    }

}