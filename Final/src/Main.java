import java.util.ArrayList;
import java.util.Arrays;

public class Main {

        public static void main(String[] args) {
            System.out.printf("%b", isCorrect());
        }

    public static boolean isCorrect() {
        try {
            int i = 0;
            i = i/0;
            return true;
        }
        finally {
            return true;
        }
    }


}
