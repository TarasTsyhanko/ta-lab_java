package consolemenu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User {
    private static final Logger log = LogManager.getLogger(User.class);

    public static int input() {
        int n =-1;
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                n = scan.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                continue;
            }
            if (n < 0 || n > 12) {
                log.info("Input number from 1 to 12 :");
                continue;
            }
            return n;
        }
    }
}
