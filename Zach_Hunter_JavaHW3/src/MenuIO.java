import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class MenuIO {

    public static final int MENU_MIN = 1;
    public static final int MENU_MAX = 7;

    public void displayMenu() {
        System.out.println(
                "\nMENU OPTIONS \n" +
                        "1 - Display lineup \n" +
                        "2 - Add player \n" +
                        "3 - Remove player \n" +
                        "4 - Move player \n" +
                        "5 - Edit player position \n" +
                        "6 - Edit player stats \n" +
                        "7 - Exit Program \n");

    }

    public int menuChoice() {
        while (true) {
            int choice;
            System.out.print("Menu option: ");
            Scanner input = new Scanner(System.in);
            if (!input.hasNextInt()) {
                System.out.println("Not a valid option. Please try again.");
                input.next();
                continue;
            }
            choice = input.nextInt();
            if (choice < MENU_MIN || choice > MENU_MAX) {
                System.out.println("Not a valid option. Please try again.");
                continue;
            } else {
                return choice;
            }
        }
    }

    public void displayLineup(ArrayList<Player> players) {
        System.out.println("POSITIONS\n C, 1B, 2B, 3B, SS, LF, CF, RF, P\n");
        if (players.isEmpty()) {
            System.out.println("Team data file could not be found.\nYou can create a new one if you want");
            System.out.println("======================================================");
        } else {
            for (int i = 0; i < players.size(); i++) {
                System.out.println(players.get(i));
            }
        }

    }


    public Player addPlayer() {
        Player player = new Player();
        Scanner input = new Scanner(System.in);
        System.out.print("Name: ");
        player.setPlayerName(input.nextLine());
        System.out.print("Position: ");
        player.setPlayerPos(input.nextLine());
        System.out.print("At Bats: ");
        boolean isCorrect = false;
        while (!isCorrect) {
            if (!input.hasNextInt()) {
                System.out.println("Not a valid number. Please try again.");
                input.next();
                continue;
            }
            int bats = input.nextInt();
            if (bats < 0) {
                System.out.println("Bats must be 0 or greater");
                continue;
            } else {
                player.setPlayerBats(bats);
                isCorrect = true;
            }
        }
        System.out.print("Hits: ");
        isCorrect = false;
        while (!isCorrect) {
            if (!input.hasNextInt()) {
                System.out.println("Not a valid number. Please try again.");
                input.next();
                continue;
            }
            int hits = input.nextInt();
            if (hits < 0) {
                System.out.println("Hits must be 0 or greater");
                continue;
            }
            if (hits > player.getPlayerBats()) {
                System.out.println("Hits must be less than bats");
                continue;
            } else {
                player.setPlayerHits(hits);
                player.setPlayerAverage();
                isCorrect = true;
            }
        }
        System.out.printf("%s was added.%n", player.getPlayerName());
        return player;
    }

    public int removePlayer(ArrayList<Player> players) {
        System.out.print("Enter position of player to remove: ");
        Scanner input = new Scanner(System.in);
        while (true) {
            if (!input.hasNextInt()) {
                System.out.println("Not a valid number. Please try again");
                input.next();
                continue;
            }
            int playerRemove = input.nextInt() - MENU_MIN;
            if (playerRemove < 0 || playerRemove > players.size()){
                System.out.println("That position doesn't exist. Please try again.");
                continue;
            }
            else {
                System.out.printf("%s removed.%n", players.get(playerRemove).getPlayerName());
                return playerRemove;
            }
        }
    }

    public ArrayList<Player> movePlayer(ArrayList<Player> players) {
        System.out.print("Current lineup number: ");
        Scanner input = new Scanner(System.in);
        while (true) {
            if (!input.hasNextInt()) {
                System.out.println("Not a valid number. Please try again");
                input.next();
                continue;
            }
            int currentNumber = input.nextInt() - MENU_MIN;
            if (currentNumber < 0 || currentNumber > players.size()) {
                System.out.println("Not a valid lineup number. Please try again");
                continue;
            }
            System.out.print("New lineup number: ");
            while (true) {
                if (!input.hasNextInt()) {
                    System.out.println("Not a valid number. Please try again");
                    input.next();
                    continue;
                }
                int newNumber = input.nextInt() - MENU_MIN;
                if (newNumber < 0 || newNumber > players.size()) {
                    System.out.println("Not a valid lineup number. Please try again");
                    continue;
                }
               else {
                    players.add(newNumber, players.get(currentNumber));
                    if (newNumber <= currentNumber) {
                        players.remove((currentNumber+1));
                    } else {
                        players.remove(currentNumber);
                    }
                    return players;
                }
            }
        }
    }
}