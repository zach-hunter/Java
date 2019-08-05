import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        MenuIO myMenu = new MenuIO();
        boolean isUserDone = false;
        ArrayList<Player> playerList = new ArrayList<Player>();
        while (!isUserDone) {
            myMenu.displayMenu();
            int menuChoice = myMenu.menuChoice();
            if (menuChoice == 1) {
                myMenu.displayLineup(playerList);
            }
            if (menuChoice == 2) {
                playerList.add(myMenu.addPlayer());
            }
            if (menuChoice == 3) {
                playerList.remove(myMenu.removePlayer(playerList));
            }
            if (menuChoice == 4) {
                myMenu.movePlayer(playerList);
            }
            if (menuChoice == 5) {
                //myMenu.editPos();
            }
            if (menuChoice == 6) {
                //myMenu.editStats();
            }
            if (menuChoice == 7) {
                isUserDone = true;
            }

        }
    }
}
