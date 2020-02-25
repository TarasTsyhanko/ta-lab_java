package scrum.stateImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scrum.Create;
import scrum.State;

public class DoneState implements State {
    private static final Logger LOG = LogManager.getLogger(Double.class);

    public void addProjectToDo(Create create) {
        create.addProjectToList();
        create.setState(new AddProjectToDo());
        LOG.info("AddProject - is not allowed");
    }
}
