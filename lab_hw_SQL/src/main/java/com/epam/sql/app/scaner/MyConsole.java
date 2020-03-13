package com.epam.sql.app.scaner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 *  pattern Facade
 */

public class MyConsole {
    private static Logger log = LogManager.getLogger(MyConsole.class);

    private MyConsole() {
    }

    public static int readInt() {
        do {
            Scanner scanner = new Scanner(System.in);
            int input;
            try {
                 input = scanner.nextInt();
                return input;
            } catch (Exception e) {
                log.info("You input incorrect type, try again :");
            }
        }while (true);
    }

    public static String readString() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input;
            try {
                input = scanner.next();
            } catch (Exception e) {
                log.info("You input incorrect type, try again :");
                continue;
            }
            return input;
        }
    }
}
