package secondtask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandImpl implements Command {
    private static final Logger log = LogManager.getLogger(CommandImpl.class);
    @Override
    public void execute(String str) {
        log.info("This is object of class that implements command. Param:" + str);
    }
}
