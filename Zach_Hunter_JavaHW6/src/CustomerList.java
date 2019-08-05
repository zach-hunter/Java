import java.util.ArrayList;
import java.util.Collections;

/**
 * List of Customers
 */
public class CustomerList {
    private static ArrayList<Customer> customerArrayList = new ArrayList<>();

    /**
     * Adds a customer to the list
     * @param customer A Customer object added to list
     */
    public static void add(Customer customer) {
        customerArrayList.add(customer);
    }

    /**
     * Deletes a customer from the list
     * @param index The list's index location of the customer to delete
     */
    public static void delete(int index) {
        customerArrayList.remove(index);
    }

    /**
     * Updates a customer
     * @param index The list's index location of customer to update
     * @param firstName New first name
     * @param lastName New last name
     */
    public static void update(int index, String firstName, String lastName) {
        customerArrayList.get(index).setFirstName(firstName);
        customerArrayList.get(index).setLastName(lastName);
    }

    /**
     * Sorts list by customer email
     */
    public static void sortByEmail() {
        Collections.sort(customerArrayList, Customer.BY_EMAIL);
    }

    /**
     * Sorts list by customer last name (native)
     */
    public static void sortByLast() {
        Collections.sort(customerArrayList, Customer::compareTo);
    }

    /**
     * Sorts list by customer first name
     */
    public static void sortByFirst() {
        Collections.sort(customerArrayList, Customer.BY_FIRST);
    }

    /**
     *
     * @return the array list of Customers
     */
    public static ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }

    /**
     * Display Customers in array list. If empty display error.
     * @return String of formatted Customers
     */
    public static String displayList() {
        if (getCustomerArrayList().isEmpty()) {
            return "No customers yet! Please add some through the menu or in the customers.txt file.";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Customer customer : getCustomerArrayList()) {
                sb.append(String.format("%s", StringUtils.formatCustomer(customer)));
            }
            return sb.toString();
        }
    }

    /**
     * Searches list for matching email. Deletes if matched, if not displays error
     * @param email Email to search list for a match
     */
    public static void deleteCustomer(String email) {
        boolean isFound = false;
        for (int i = 0; i<getCustomerArrayList().size(); i++) {
            if(getCustomerArrayList().get(i).getEmail().equals(email)) {
                System.out.printf("%s %s deleted.%n", getCustomerArrayList().get(i).getFirstName(), getCustomerArrayList().get(i).getLastName());
                delete(i);
                isFound = true;
            } //else doNothing();
        }
        if (!isFound) {
            System.out.printf("%s is not a current customer's email.%n", email);
        }
    }

    /**
     * Updates customer first and last name if matching email is found, else display error message
     * @param email Email to search for match
     */
    public static void updateCustomer(String email) {
        boolean isFound = false;
        for (int i = 0; i<getCustomerArrayList().size(); i++) {
            if(getCustomerArrayList().get(i).getEmail().equals(email)) {
                isFound = true;
                System.out.print("Enter new first name: ");
                String firstName = Validator.validateFirstName();
                System.out.print("Enter new last name: ");
                String lastName = Validator.validateLastName();
                update(i, firstName, lastName);
                System.out.printf("%s updated.%n", email);
            } //else doNothing();
        }
        if (!isFound) {
            System.out.printf("%s is not a current customer's email.%n", email);
        }
    }


    @Override
    public String toString() {
        if (getCustomerArrayList().isEmpty()) {
            return "No customers yet! Please add some through the menu or in the customers.txt file.";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Customer customer : getCustomerArrayList()) {
                sb.append(String.format("%s\n", customer));
            }
            return sb.toString();
        }
    }
    // Not sure if equals and hashcode are needed for something used entirely as static
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if(!(obj instanceof CustomerList)) return false;

        CustomerList that = (CustomerList) obj;

        return this.getCustomerArrayList().equals(that.getCustomerArrayList());
    }

    @Override
    public int hashCode() {
        int result = 19;
        result = 37 * result + getCustomerArrayList().hashCode();
        return result;
    }
}
