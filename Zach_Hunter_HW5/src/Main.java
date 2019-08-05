import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final int CHOICE_ONE = 1;
    public static final int CHOICE_TWO = 2;
    public static final int CHOICE_THREE = 3;
    public static final int CHOICE_FOUR = 4;
    public static final int CHOICE_FIVE = 5;

    public static void main(String[] args) {
        boolean userDone = false;
        while (!userDone) {
            System.out.print("Enter path for CSV file(include extension): ");
            Scanner input = new Scanner(System.in);
            String filePath = input.nextLine();
            CSVReader reader = new CSVReader();
            try {
                reader.read(filePath);

                int userChoice = 0;
                while (userChoice != CHOICE_FOUR && userChoice != CHOICE_FIVE) {
                    System.out.printf("%n1. Number of rows" +
                            "%n2. Number of fields in chosen row" +
                            "%n3. Specific field for chosen row and column" +
                            "%n4. New File" +
                            "%n5. Exit%n");
                    if (!input.hasNextInt()) {
                        System.out.println("Invalid choice. Try again.");
                        input.next();
                        continue;
                    } else {
                        userChoice = input.nextInt();
                    }
                    if (userChoice == CHOICE_ONE) {
                        System.out.printf("Number of Rows: %d%n", reader.numberOfRows());
                    }
                    else if (userChoice == CHOICE_TWO) {
                        System.out.printf("%nRow number: ");
                        boolean isValid = false;
                        int rowNum = 0;
                        while (!isValid) {
                            try {
                                rowNum = input.nextInt();
                                rowNum--;
                                if (rowNum >= 0 && rowNum <= reader.numberOfRows()) {
                                    isValid = true;
                                }
                                else {
                                    System.out.printf("Not within range. Input number between 1 and %d: ", reader.numberOfRows());
                                    input.nextLine();
                                }
                            } catch (InputMismatchException iMmE) {
                                System.out.print("Not a number. Try again: ");
                                input.nextLine();
                            }
                        }
                        System.out.printf("Number of fields in row %d: %d",(rowNum+1), reader.numberOfFields(rowNum));
                    }
                    else if (userChoice == CHOICE_THREE) {
                        System.out.printf("%nRow number: ");
                        boolean isValid = false;
                        int rowNum = 0;
                        while (!isValid) {
                            try {
                                rowNum = input.nextInt();
                                rowNum--;
                                if (rowNum >= 0 && rowNum <= reader.numberOfRows()) {
                                    isValid = true;
                                }
                                else {
                                    System.out.printf("Not within range. Input number between 1 and %d: ", reader.numberOfRows());
                                    input.nextLine();
                                }
                            } catch (InputMismatchException iMmE) {
                                System.out.print("Not a number. Try again: ");
                                input.nextLine();
                            }
                        }
                        System.out.printf("%nColumn number: ");
                        isValid = false;
                        int colNum = 0;
                        while (!isValid) {
                            try {
                                colNum = input.nextInt();
                                colNum--;
                                if (colNum >= 0 && colNum <= reader.numberOfFields(rowNum)) {
                                    isValid = true;
                                }
                                else {
                                    System.out.printf("Not within range. Input number between 1 and %d: ", reader.numberOfFields(rowNum));
                                    input.nextLine();
                                }
                            } catch (InputMismatchException iMmE) {
                                System.out.print("Not a number. Try again: ");
                                input.nextLine();
                            }
                        }
                        System.out.printf("%nField at row %d, column %d is: %s", rowNum+1, colNum+1, reader.field(rowNum, colNum));
                    }
                    else if (userChoice == CHOICE_FOUR) {
                        //loop will exit, doNothing();
                    }
                    else if (userChoice == CHOICE_FIVE) {
                        userDone = true;
                    }
                    else {
                        System.out.println("Invalid choice. Try again.");
                    }
                }
            } catch (IOException iOEx) {
                System.out.println(iOEx.getMessage());
            }
        }
    }
}
