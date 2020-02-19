package comperreaderwritter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOG = LogManager.getLogger(readcomments.Main.class);
    public static void main(String[] args) {
        LOG.info("BufferReader/Writer - "+Times.takeTime1()+" - milliseconds");
        LOG.info("StreamInput/Output - "+Times.takeTime2()+" - milliseconds");
        LOG.info("Just Reader/Writer - "+Times.takeTime3()+" - milliseconds");
        LOG.info("Scanner/PrintWriter - "+Times.takeTime4()+" - milliseconds");

    }
}
