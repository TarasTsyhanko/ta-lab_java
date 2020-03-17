package scrum.stateImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scrum.Create;
import scrum.State;

public class PeerReviewState implements State {
    private static final Logger LOG = LogManager.getLogger(PeerReviewState.class);

    public void inProgress(Create create) {
        create.setState(new InProgressState());
        LOG.info("Project is inProgress");
    }

    public void inTest(Create create) {
        create.setState(new InTestState());
        LOG.info("Project is inTest");
    }

    public void blockedProject(Create create) {
        create.setState(new BlockedState());
        LOG.info("Project is blocked");
    }
}
