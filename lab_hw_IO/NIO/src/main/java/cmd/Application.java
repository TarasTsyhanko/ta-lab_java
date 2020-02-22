package cmd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.regex.Pattern;

import static constant.Constants.*;

public class Application {
    private static final Logger LOG = LogManager.getLogger(Application.class);
    private Cmd cmd;

    public Application() {
        cmd = new Cmd();
        run();
    }

    public void run() {
        while (true) {
            String string = new Scanner(System.in).nextLine().trim();
            if (Pattern.compile(DIR_REGEX).matcher(string).matches()) {
                cmd.dir();
            } else if (Pattern.compile(EXIT_REGEX).matcher(string).find(0)) {
                cmd.exit();
            } else if (Pattern.compile(CD_REGEX).matcher(string).find(0)) {
                string = string.substring(2).trim();
                cmd.cd(string);
            } else {
                LOG.info("'" + string + "' is not recognized as an internal or external command,\n" +
                        "operable program or batch file.");
            }
        }
    }
}
