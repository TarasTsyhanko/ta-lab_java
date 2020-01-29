package game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Hero {
    private static final Logger log = LogManager.getLogger(Hero.class);
    private int power = 25;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
        log.info("Hero`s power will be " + this.power);
    }

    public int selectDor() {
        log.info("In front of you 10 doors, choose which YOU want to enter :");
        while (true) {
            return inputInt();
        }
    }

    private int inputInt() {
        int n = 0;
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                n = scan.nextInt();
            } catch (InputMismatchException | NullPointerException e) {
                log.error("Please , input the number from 1 to 10");
                continue;
            }
            if (n > 10 || n < 1) {
                log.info("Please , input number from 1 to 10");
                continue;
            }
            return n;
        }
    }
}
