import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    /**
     * Adds an entry to the map if user entered name and number exist
     * @param currentMap Treemap consisting of (name, phonenumber)
     * @return Updated map if user entries were valid, else returns original map
     */
    public static Map<String, String> addEntry(Map<String, String> currentMap)  {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter name: ");
        String newName = input.nextLine();
        if (newName != null && !newName.isEmpty()) {
            System.out.println("Enter phone number: ");
            String newNumber = input.nextLine();
            if (newNumber != null && !newNumber.isEmpty()) {
                currentMap.put(newName, newNumber);
                System.out.println("%nThis entry has been saved.%n");
                return currentMap;
            }
            else {
                System.out.println("%nInvalid entry - Must enter phone number.%n");
                return currentMap;
            }
        }
        else {
            System.out.println("%nInvalid entry - Must enter name.%n");
            return currentMap;
        }

    }

    public static Map<String, String> delEntry(Map<String, String> currentMap) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name to delete: ");
        String delName = input.nextLine();
        if (delName != null && !delName.isEmpty()) {
            if (currentMap.containsKey(delName)) {
                currentMap.remove(delName);
                return currentMap;
                }
            else {
                System.out.println("Invalid entry - Name not found.");
                return currentMap;
            }
        }
        else {
            System.out.println("%nInvalid entry - Must enter name to delete.%n");
            return currentMap;
        }
    }

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    Map<String, Integer> addressBook = new TreeMap<>();
        boolean isFinished = false;
        /**
         * Will loop for user input and map data output until user indicates they are done.
         */
	    while(!isFinished) {
            System.out.println("1 - List entries%n" +
                    "2 - Add Entry%n" +
                    "3 - Delete Entry%n" +
                    "4 - Exit%n");
            
        }
    }
}
