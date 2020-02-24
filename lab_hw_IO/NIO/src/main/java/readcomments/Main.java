package readcomments;

import constant.MyProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        LOG.info(Readers.openJavaFile(new MyProperties().getProperty("java_file_for_read")));
    }
}
