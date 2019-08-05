import java.io.IOException;
import java.util.Scanner;

/**
 * Controls menu io and validation
 */
public class CustomerMaintApp {
    private static boolean isUserDone = false;

    private static void setIsUserDone() {
        isUserDone = true;
    }

    /**
     * Displays the main menu
     * @throws IOException if validateUserChoice throws IOException
     */
    public static void displayMenu() throws IOException {
            System.out.printf("COMMAND MENU%n" +
                            "%-8s - List all customers%n" +
                            "%-8s - Add a customer%n" +
                            "%-8s - Delete a customer%n" +
                            "%-8s - Update a customer%n" +
                            "%-8s - Show this menu%n" +
                            "%-8s - Exit this application%n" +
                            "%-8s - Sort customers%n",
                    "list", "add", "del", "upd", "help", "exit", "sort");
            CustomerMaintApp.validateUserChoice();
    }

    /**
     * Validates a users choice compared to displayMenu() options until user exits
     * @throws IOException if user exits and write to file fails
     */
    public static void validateUserChoice() throws IOException {
        while (!isUserDone) {
            System.out.print("\nEnter a command: ");
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();
            if (choice.equals("list")) {
                displayList();
            } else if (choice.equals("add")) {
                addCustomer();
            } else if (choice.equals("del")) {
                deleteCustomer();
            } else if (choice.equals("upd")) {
                updateCustomer();
            } else if (choice.equals("help")) {
                System.out.println("\nlist: Displays a list of customer data which consists of first and last name and email\n" +
                        "add: Adds a customer to the list. Will require entry of first name, last name, and email\n" +
                        "del: Deletes a customer based on email address\n" +
                        "upd: Updates an existing customer based on email address\n" +
                        "help: Diplays a detailed list of commands then displays the command menu\n" +
                        "exit: Ensures that all changes to customer data have been saved and terminates the program\n" +
                        "sort: Displays customers sorted by either last name, first name, or email\n");
                displayMenu();
            } else if (choice.equals("exit")) {
                CustomerDAO.write();
                System.out.println("\nLater.");
                setIsUserDone();
            }
            else if (choice.equals("sort")) {
                sortMenu();
            }else {
                System.out.println("\nInvalid entry. Try again or type help to display command details.");
                validateUserChoice();
            }
        }
    }

    private static void displayList() {
        System.out.println(CustomerList.displayList());
    }

    /**
     * Adds a customer email, firstname, and lastname to the list
     */
    private static void addCustomer() {
        System.out.print("Add customer email: ");
        String email = Validator.validateEmail();
        System.out.print("Add customer's first name: ");
        String firstName = Validator.validateFirstName();
        System.out.print("Add customer's last name: ");
        String lastName = Validator.validateLastName();
        Customer customer = new Customer(email, lastName, firstName);
        CustomerList.add(customer);
        System.out.printf("%s %s was added.%n", firstName, lastName);
    }

    /**
     * Deletes a customer based on email from the list
     */
    private static void deleteCustomer() {
       System.out.print("Enter email address of customer to delete: ");
       String email = Validator.validateEmail();
       CustomerList.deleteCustomer(email);
    }

    /**
     * Updates a customer based on email in the list
     */
    private static void updateCustomer() {
        System.out.print("Enter email address of customer to update: ");
        String email = Validator.validateEmail();
        CustomerList.updateCustomer(email);
    }
    public static final int MIN_CHOICE = 1;
    public static final int MID_CHOICE = 2;
    public static final int MAX_CHOICE = 3;
    private static void sortMenu() {
        System.out.println("Choose sorting method:\n" +
                "1. Sort by email address\n" +
                "2. Sort by last name\n" +
                "3. Sort by first name");
        Scanner input = new Scanner(System.in);
        int userChoice = 0;
        if (input.hasNextInt()) {
            userChoice = input.nextInt();
        } else {
            System.out.println("Invalid entry!");
        }
        if (userChoice < MIN_CHOICE || userChoice > MAX_CHOICE) {
            System.out.println("Not a valid option!");
        } else {
            switch (userChoice) {
                case MIN_CHOICE:
                    CustomerList.sortByEmail();
                    break;
                case MID_CHOICE:
                    CustomerList.sortByLast();
                    break;
                case MAX_CHOICE:
                    CustomerList.sortByFirst();
                    break;
            }
            displayList();
        }

    }
}
