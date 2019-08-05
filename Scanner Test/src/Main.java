import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
public class Main {
    public static void main(String[] args) {

//        String name = "Shane";
//        int id = 747448;
//
//        System.out.printf("%25s%25d%n", name, id);

        // remove - remove an item from the set
        // isEmpty
        // size
        // contains(value) - true or false.
        Set<Integer> distinctNumbers = new LinkedHashSet<>();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a value <= 0 to stop : ");
        int number = input.nextInt();
        while (number > 0) {
            distinctNumbers.add(number);
            number = input.nextInt();
        }
//
//        System.out.println(distinctNumbers);


//        List<Integer> numbers = new LinkedList<>();
//
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter a number > 0, <= 0 to stop : ");
//
//        int number = input.nextInt();
//        while (number > 0) {
//            numbers.add(number);
//            number = input.nextInt();
//        }
//
//        for (int index = 0; index < numbers.size(); index++) {
//            System.out.printf("%4d", numbers.get(index));
//        }
//        System.out.println("");
//
////        numbers.set(1, 50);
////        numbers.remove(6);
////        numbers.isEmpty();
////
//        int sum = 0;
//        for (int element : numbers) {
//            sum += element;
//        }
//
//        double average = (double) sum / (double) numbers.size();
//
//        System.out.printf("Sum is %d, average is %f%n", sum, average);
    }
}