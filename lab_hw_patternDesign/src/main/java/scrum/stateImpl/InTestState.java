package scrum.stateImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scrum.Create;
import scrum.State;

public class InTestState implements State {
    private static final Logger LOG = LogManager.getLogger(InTestState.class);
    public void inProgress(Create create){
        create.setState(new InProgressState());
        LOG.info("Project is inProgress");
    }
    public void codeReview(Create create){
        create.setState(new PeerReviewState());
        LOG.info("Project is in CodeReview");
    }
    public void done(Create create){
        create.setState(new DoneState());
        LOG.info("Project is done");
    }
    public void blockedProject(Create create){
        create.setState(new BlockedState());
        LOG.info("Project is blocked");
    }
}
