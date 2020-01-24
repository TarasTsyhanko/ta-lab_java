package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MainLogger {

    private static final Logger LOG = LogManager.getLogger(MainLogger.class);

    public static void main(String[] args) {

        LOG.trace(" This will be printed on TRACE");
        LOG.debug("This Will Be Printed On Debug");
        LOG.info("This Will Be Printed On Info");
        LOG.warn("This Will Be Printed On Warn");
        LOG.error("This Will Be Printed On Error");
        LOG.fatal("This Will Be Printed On Fatal");

    }

}
