import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	System.out.println("Welcome to the Customer Maintenance application\n");
	try {
		CustomerDAO.read();
	} catch (IOException iOEx) {
		System.out.println(iOEx.getMessage());
	}
	CustomerMaintApp.displayMenu();
    }

}
