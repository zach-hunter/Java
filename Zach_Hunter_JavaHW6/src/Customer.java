import java.util.Comparator;

/**
 * A Customer is an email address, first name, and last name
 */
public class Customer implements CustomerConstants, Comparable<Customer> {
    private String email;
    private String lastName;
    private String firstName;

    /**
     * Constructs a new Customer with provided email, lastname, and firstname
     * @param email Customer's email
     * @param lastName Customer's last name
     * @param firstName Customer's first name
     */
    public Customer(String email, String lastName, String firstName) {
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
    }

    /**
     *
     * @return Customer's email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets email of customer
     * @param email Customer's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return Customer's last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets lastname of Customer
     * @param lastName Customer's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return Customer's first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets firstname of Customer
     * @param firstName Customer's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sorts by customer email
     */
    static final Comparator<Customer> BY_EMAIL = new Comparator<Customer>() {
        @Override
        public int compare(Customer o1, Customer o2) {
            return o1.getEmail().compareTo(o2.getEmail());
        }
    };
    /**
     * Sorts by customer first name
     */
    static final Comparator<Customer> BY_FIRST = new Comparator<Customer>() {
        @Override
        public int compare(Customer o1, Customer o2) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    };

    /**
     * Sorts by customer last name natively
     * @param o A Customer object
     * @return 0, <0, >0 depending on object's relation comparatively
     */
    @Override
    public int compareTo(Customer o) {
        return this.getLastName().compareTo(o.getLastName());
    }

    /**
     * Formats string to display email, first name, and last name
     * @return formatted display string
     */
    @Override
    public String toString() {
        return String.format("%s  %s  %s%n", getEmail(), getFirstName(), getLastName());
    }

    /**
     * Determines if two objects are the same
     * @param obj Any object
     * @return true if same, false if different. Based on customer email.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Customer)) return false;

        Customer that = (Customer) obj;

        return this.getEmail().equals(that.getEmail());
    }

    @Override
    public int hashCode() {
        int result = 19;
        result = 37 * result + this.getEmail().hashCode();
        return result;
    }
}
