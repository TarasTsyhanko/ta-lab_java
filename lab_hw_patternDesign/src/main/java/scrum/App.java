package scrum;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String key;
        Create create = new Create();
        do {
            LOG.info("   1 - Add Project" + "      2 - inProgress   ");
            LOG.info("   3 - codeReview     " + "  4 - inTest    ");
            LOG.info("   5 - Done Project   " + "  6 - Blocked Project     ");
            LOG.info("   L - Get Product List" + " Q - exit");
            LOG.info("   Please, select menu point.");
            key = scan.nextLine().toUpperCase();
            try {
                switch (key) {
                    case "1":
                        create.addProjectToDo();
                        break;
                    case "2":
                        create.inProgress();
                        break;
                    case "3":
                        create.codeReview();
                        break;
                    case "4":
                        create.inTest();
                        break;
                    case "5":
                        create.done();
                        break;
                    case "6":
                        create.blockedProject();
                        break;
                    case "L":
                        create.getProjectsList();
                        break;
                }
            } catch (Exception e) {
            }
        } while (!key.equals("Q"));
    }
}
