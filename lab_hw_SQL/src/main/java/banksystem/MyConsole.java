package banksystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class MyConsole {
    private static Logger log = LogManager.getLogger(MyConsole.class);
    private static Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        while (true) {
            try {
                int res= scanner.nextInt();
                return res;
            } catch (Exception e) {
                log.info("You input incorrect type, try again :");
            }
        }
    }

    public static String readString() {
        while (true) {
            String res;
            try {
                res = scanner.next();
            } catch (Exception e) {
                log.info("You input incorrect type, try again :");
                continue;
            }
            return res;
        }
    }
}
