package scrum.stateImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scrum.Create;
import scrum.State;

public class BlockedState implements State {
    private static final Logger LOG = LogManager.getLogger(BlockedState.class);

    public void inProgress(Create create) {
        create.setState(new InProgressState());
        LOG.info("Project is inProgress");
    }

    public void codeReview(Create create) {
        create.setState(new PeerReviewState());
        LOG.info("Project is in CodeReview");
    }
}
