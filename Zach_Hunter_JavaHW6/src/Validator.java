import java.util.Scanner;

/**
 * Validates emails, firstnames, and lastnames for Customers
 */
public class Validator {
    public static String validateEmail() {
        Scanner input = new Scanner(System.in);
        String email = input.next();
        if (email.equals("") || email.equals(" ")) {
            System.out.println("Invalid entry, email cannot be empty.");
            validateEmail();
        } else {
            //email not null doNothing();
        }
        return email;
    }

    public static String validateFirstName() {
        Scanner input = new Scanner(System.in);
        String firstName = input.next();
        if (firstName.equals("") || firstName.equals(" ")) {
            System.out.println("Invalid entry, email cannot be empty.");
            validateFirstName();
        } else {
            //firstname not null doNothing();
        }
        return firstName;
    }

    public static String validateLastName() {
        Scanner input = new Scanner(System.in);
        String lastName = input.next();
        if (lastName.equals("") || lastName.equals(" ")) {
            System.out.println("Invalid entry, last name cannot be empty.");
            validateLastName();
        } else {
            //lastName not null doNothing();
        }
        return lastName;
    }
}
