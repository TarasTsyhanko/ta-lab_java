package cmd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Cmd {
    private static final Logger LOG = LogManager.getLogger(Cmd.class);

    public Cmd() {
        MyDisks.setFiles(new File("C:\\"));
        LOG.info("C:\\>");
    }

    public void dir() {
        for (File file : MyDisks.getFiles()) {
            if (file.isDirectory()) {
                LOG.info("<DIR>  " + "       " + file.getName());
            } else {
                LOG.info("<file> " + file.length() + " " + file.getName());
            }
        }
    }

    public void cd(String directory) {
        for (File file : MyDisks.getFiles()) {
            if (file.getName().equalsIgnoreCase(directory)) {
                MyDisks.setFiles(file);
                LOG.info(" Directory of " + file.getAbsolutePath());
                break;
            } else if (directory.equals("..")) {
                MyDisks.setFiles(file.getParentFile().getParentFile());
                LOG.info(file.getParentFile().getParentFile().getAbsolutePath());
                break;
            } else if (directory.equals("/")) {
                MyDisks.setFiles( new File("C:\\"));
                LOG.info("C:\\>");
                break;
            } else if (file.getName().equals(directory) && file.isFile()) {
                LOG.info("The directory name is invalid.");
            }
        }
    }

    public void exit() {
        System.exit(0);
    }
}
