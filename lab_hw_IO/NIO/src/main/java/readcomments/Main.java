package readcomments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static constant.Constants.FILE_JAVA_PATH;

public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        LOG.info(Readers.openJavaFile(FILE_JAVA_PATH));
    }
}
