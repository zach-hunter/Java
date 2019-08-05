import com.sun.nio.sctp.IllegalReceiveException;

import java.io.*;
import java.util.Scanner;

/**
 * Reads Customer email, firstname, and lastname from customers.txt.
 * Creates customers.txt if it does not exit
 * Creates a new customer with email, firstname, and lastname
 * Adds Customer to the CustomerList
 */
public class CustomerDAO {
    public static void read() throws IOException {
        String fileName = "customers.txt";
        new FileOutputStream(fileName, true).close();
        try (Scanner in  =
                     new Scanner(
                             new BufferedReader(
                                     new FileReader(fileName)))) {
            while (in.hasNext()) {
                String emailAddress = "";
                if (in.hasNext()) {
                    emailAddress = in.next();
                } else {
                    throw new IllegalArgumentException("Invalid format1");
                }
                if (emailAddress.equals("")) {
                    throw new IllegalArgumentException("Email address cannot be null");
                } //else not null, doNothing();
                String firstName = "";
                if (in.hasNext()) {
                    firstName = in.next();
                } else {
                    throw new IllegalReceiveException("Invalid format2");
                }
                if (firstName.equals("")) {
                    throw new IllegalArgumentException("Last name cannot be null");
                } //else not null, doNothing();
                String lastName = "";
                if (in.hasNext()) {
                    lastName = in.next();
                } else {
                    throw new IllegalReceiveException("Invalid format3");
                }
                if (lastName.equals("")) {
                    throw new IllegalArgumentException("First name cannot be null");
                } //else not null, doNothing();

                Customer customer = new Customer(emailAddress, lastName, firstName);
                CustomerList.add(customer);
            }
            in.close();
        }
    }

    /**
     * Writes Customers in CustomerList to customers.txt
     * Creates customers.txt if it does not exist
     * @throws IllegalArgumentException if CustomerList is empty
     * @return true if file write was successful, else return false
     * @throws IOException If file couldn't be written to
     */
    public static boolean write() throws IOException {
        if (CustomerList.getCustomerArrayList() == null) {
            throw new IllegalArgumentException("Nothing saved! Customer list is null");
        } // else course is not null, doNothing();

        String fileName = "customers.txt";
        new FileOutputStream(fileName, true).close();

        try (PrintWriter out =
                     new PrintWriter(
                             new BufferedWriter(
                                     new FileWriter(fileName)))) {
            out.print(CustomerList.displayList());
            return true;
        } catch (IOException iOEx) {
            return false;
        }
    }
}
