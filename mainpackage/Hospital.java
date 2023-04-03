package mainpackage;
import java.util.*;

public class Hospital {

    public static HashMap<Integer, Patient> mapAllPatients = new HashMap<>();

    public static void displayActiveQueue() {
        // FIXME: Current implementation does not have desired result, just for debugging
        HelperClass.seperator();
        for (Integer id: mapAllPatients.keySet()) {
            int key = id;
            String value = mapAllPatients.get(key).patientName;
            System.out.println(key + ": " + value);
        }
    }
}