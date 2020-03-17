package scrum.stateImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scrum.Create;
import scrum.State;

public class AddProjectToDo implements State {
    private static final Logger LOG = LogManager.getLogger(AddProjectToDo.class);

    public void addProjectToDo(Create create){
        create.addProjectToList();
    }
    public void inProgress(Create create){
        create.setState(new InProgressState());
        LOG.info("Project is inProgress");
    }
    public void blockedProject(Create create){
        create.setState(new BlockedState());
        LOG.info("Project is blocked");
    }
}
