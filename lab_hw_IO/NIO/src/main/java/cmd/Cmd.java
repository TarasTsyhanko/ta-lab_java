package cmd;

import constant.MyProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Cmd {
    private static final Logger LOG = LogManager.getLogger(Cmd.class);

    public Cmd() {
        File file = new File(new MyProperties().getProperty("my_disk_c"));
        MyDisks.setFiles(file);
        LOG.info(file.getAbsolutePath());
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
                File f = new File(new MyProperties().getProperty("my_disk_c"));
                MyDisks.setFiles(f);
                LOG.info(f.getAbsolutePath());
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
