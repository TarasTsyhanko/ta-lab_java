package scrum.stateImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scrum.Create;
import scrum.State;

public class InProgressState implements State {
    private static final Logger LOG = LogManager.getLogger(InProgressState.class);

    public void codeReview(Create create) {
        create.setState(new PeerReviewState());
        LOG.info("Project is in CodeReview");
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
