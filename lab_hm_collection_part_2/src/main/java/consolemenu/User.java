package consolemenu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User {
    private static final Logger log = LogManager.getLogger(User.class);
    private Menu menu;

    public User() {
        menu = new Menu();
    }

    public void openMenu() {
        menu.showDescriptionsFirst();
    }

    public void makeChoice() {
        int n = 0;
        int i = 0;
        while (n<12) {
            i = inputNumber();
            if (i == 0) {
                menu.shutDown();
            }
            menu.showInfo(i);
            menu.showDescriptionsSecond();
            if(inputString().equalsIgnoreCase(("BACK"))){
                continue;
            }
            menu.shutDown();
            n++;
        }
    }

    public int inputNumber() {
        int n = -1;
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                n = scan.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                continue;
            }
            if (menu.getMap().get(n) == null || n == 0) {
                log.info("Input number from 1 to 12 :");
                continue;
            }
            return n;
        }
    }
    public String inputString(){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        return s;
    }
}
