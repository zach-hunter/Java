import java.util.Scanner;

public class Main {



    public static double getLoan(Scanner input, String prompt) {
        double loan = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (input.hasNextDouble()) {
                loan = input.nextDouble();
                if (loan < 0) {
                    System.out.println("Error! Number must be greater than 0.0");
                    input.nextLine();
                }
                else if (loan > 1000000) {
                    System.out.println("Error! Number must be less than 1000000");
                    input.nextLine();
                }
                else {
                    isValid = true;
                }
            } else {
                System.out.println("Error! Invalid decimal value. Try Again." );
                input.next();
            }
        }
        return loan;
    }

    public static double getInterest(Scanner input, String prompt) {
        double interest = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (input.hasNextDouble()) {
                interest = input.nextDouble();
                if (interest < 0) {
                    System.out.println("Error! Number must be greater than 0.0");
                    input.nextLine();
                }
                else if (interest > 20) {
                    System.out.println("Error! Number must be less than 20");
                    input.nextLine();
                }
                else {
                    isValid = true;
                }
            }
            else {
                System.out.println("Error! Invalid decimal value. Try Again." );
                input.next();
            }
        }
        return interest;
    }

    public static int getYears(Scanner input, String prompt) {
        int years = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (input.hasNextInt()) {
                years = input.nextInt();
                if (years < 0) {
                    System.out.println("Error! Number must be greater than 0");
                    input.nextLine();
                }
                else if (years > 100) {
                    System.out.println("Error! Number must be less than 100");
                    input.nextLine();
                }
                else {
                    isValid = true;
                }
            } else {
                System.out.println("Error! Invalid integer value. Try Again." );
                input.next();
            }
        }
        return years;
    }

    public static boolean isUserDone(Scanner input, String prompt){
        String userContinue = " ";
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            userContinue = input.next();
            if (userContinue.equals("n") || userContinue.equals("y")) {
                isValid = true;
            }
            else if (userContinue.equals("")) {
                System.out.println("Error! This entry is required. Try Again.");
                input.nextLine();
            }
            else {
                System.out.println("Error! Entry must be 'y' or 'n'. Try Again");
                input.nextLine();
            }
        }
        return userContinue.equals("y") ? false : true;

    }

    public static final int PERCENT_DECIMAL = 100;
    public static final int MONTHS_YEAR = 12;

    public static void main(String[] args) {
	    boolean isUserDone = false;
	    while (!isUserDone) {
            Scanner luigi = new Scanner(System.in);
            double loanAmount = getLoan(luigi, "Enter loan amount: ");
            double interestRate = getInterest(luigi, "Enter yearly interest rate: ");
            int numYears = getYears(luigi, "Enter the number of years: ");
            double monthlyPayment = loanAmount * ((interestRate/PERCENT_DECIMAL/MONTHS_YEAR)/(1-Math.pow((1+(interestRate/PERCENT_DECIMAL/MONTHS_YEAR)),-(numYears*MONTHS_YEAR))));
            System.out.format("%n%-22s $%.2f%n", "Loan Amount: ", loanAmount);
            System.out.format("%-22s %f%%%n", "Yearly Interest Rate: ", interestRate);
            System.out.format("%-22s %d%n", "Number of Years: ", numYears);
            System.out.format("%-22s $%.2f%n%n", "Monthly Payment: ", monthlyPayment);
            System.out.println();
            isUserDone = isUserDone(luigi, "Would you like to continue? (y/n): ");
        }
    }
}
