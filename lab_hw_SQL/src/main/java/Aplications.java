import banksystem.MyConsole;
import factory.impl.AccountFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Aplications {
    private static Logger log = LogManager.getLogger(AccountFactory.class);
    private App app ;

    public Aplications() {
        app = new App();
        app.logInAccount();
        app.showPersonalDate();
        app.downloadOperations();
        String key;
        do {
            log.info("  -------------------------------------------------------------------------");
            log.info("  |      1 - Show Your operations         |     2 - Show Personal date    |");
            log.info("  |      3 - Choose Bank                  |     4 - Change personal date  |  ");
            log.info("  |      5 - Change the term of Operation |                               |");
            log.info("  |                              EXIT - close App                         |");
            log.info("  -------------------------------------------------------------------------");
            log.info("                    Please, select menu point.");
            key = MyConsole.readString().toUpperCase();
            try {
                switch (key) {
                    case "1":
                        app.showAllOperation();
                        break;
                    case "2":
                        app.showPersonalDate();
                        break;
                    case "3":
                        app.chooseBank();
                        app.workWithBank();
                        app.downloadOperations();
                        break;
                    case "4":
                        app.changePersonalDate();
                        break;
                    case "5":
                        app.changeOperationTerm();
                        break;
                }
            } catch (Exception ignored) {
            }
        } while (!key.equals("EXIT"));
    }
}
