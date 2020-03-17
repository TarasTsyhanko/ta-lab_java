package scrum;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface State {
    Logger LOG = LogManager.getLogger(Create.class);
    default void addProjectToDo(Create create){
        LOG.info("AddProject - is not allowed");
    }
    default void inProgress(Create create){
        LOG.info("inProgress - is not allowed");
    }
    default void codeReview(Create create){
        LOG.info("codeReview - is not allowed");
    }
    default void inTest(Create create){
        LOG.info("inTest - is not allowed");
    }
    default void done(Create create){
        LOG.info("done - is not allowed");
    }
    default void blockedProject(Create create){
        LOG.info("blockedProject - is not allowed");
    }
}
