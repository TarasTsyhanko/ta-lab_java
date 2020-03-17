package com.epam.sql.app;

import com.epam.sql.app.scaner.MyConsole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** S - single responsibility principle.
 */

public class Menu {
    private static Logger log = LogManager.getLogger(Menu.class);
    private App app ;

    public Menu() {
        app = new App();
        app.logInAccount();
        app.showPersonalDate();
        app.downloadOperations();
        String key;
        do {
            log.info("  -------------------------------------------------------------------------");
            log.info("  |      1 - Show Your operations         |     6 - Delete Operation      |");
            log.info("  |      2 - Change the term of Operation |     7 - Delete Your Account   |  ");
            log.info("  |      3 - Chose Bank for work          |     8 - Delete Client         |");
            log.info("  |      4 - Show Personal date           |         from Data Base        |");
            log.info("  |      5 - Change personal date         |                               | ");
            log.info("  |                        > EXIT - close App                             |");
            log.info("  -------------------------------------------------------------------------");
            log.info("                    Please, select menu point.");
            key = MyConsole.readString().toUpperCase();
            try {
                switch (key) {
                    case "1":
                        app.showAllOperation();
                        break;
                    case "2":
                        app.changeOperationTerm();
                        break;
                    case "3":
                        app.chooseBank();
                        app.workWithBank();
                        app.downloadOperations();
                        break;
                    case "4":
                        app.showPersonalDate();
                        break;
                    case "5":
                        app.changePersonalDate();
                        break;
                    case "6":
                        app.deleteOperation();
                        app.downloadOperations();
                        break;
                    case "7":
                        app.deleteAccount();
                        System.exit(0);
                        break;
                    case "8":
                        app.deleteClientFromDataBase();
                        System.exit(0);
                        break;
                }
            } catch (Exception ignored) {
            }
        } while (!key.equals("EXIT"));
    }
}
