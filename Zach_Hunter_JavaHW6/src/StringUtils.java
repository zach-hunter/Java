public class StringUtils implements CustomerConstants {
    /**
     * Adds spaces to email, last name, and first name strings based on CustomerConstants
     * @param customer A Customer object
     * @return new Customer object with formatted email, last name, and firstname
     */
    public static Customer formatCustomer(Customer customer) {
        StringBuilder email = new StringBuilder(customer.getEmail());
        for (int i = 0; i < EMAIL_LENGTH - customer.getEmail().length(); i++) {
            email.append(" ");
        }
        StringBuilder firstName = new StringBuilder(customer.getFirstName());
        for (int i = 0; i < FIRST_LENGTH - customer.getFirstName().length(); i++) {
            firstName.append(" ");
        }
        StringBuilder lastName = new StringBuilder(customer.getLastName());
        for (int i = 0; i < LAST_LENGTH - customer.getLastName().length(); i++) {
            lastName.append(" ");
        }
        Customer spaced = new Customer(email.toString(), lastName.toString(), firstName.toString());
        return spaced;
    }
}
