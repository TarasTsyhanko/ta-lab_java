package scrum;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scrum.stateImpl.AddProjectToDo;

import java.util.LinkedList;
import java.util.List;

public class Create {
    private static final Logger LOG = LogManager.getLogger(Create.class);
    private State state;
    private List<MyProject> projects = new LinkedList<>();

    public Create() {
        state = new AddProjectToDo();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void addProjectToDo() {
        state.addProjectToDo(this);
    }

    public void inProgress() {
        if(projects.isEmpty()){
            LOG.info("You have no planned projects");
        }else {
            state.inProgress(this);
        }
    }

    public void codeReview() {
        state.codeReview(this);
    }

    public void inTest() {
        state.inTest(this);
    }

    public void done() {
        state.done(this);
    }

    public void blockedProject() {
        if(projects.isEmpty()){
            LOG.info("You have no planned projects");
        }else {
            state.blockedProject(this);
        }
    }

    public void addProjectToList() {
        MyProject project = new MyProject();
        projects.add(project);
        LOG.info(project + " add to backlog ");
    }

    public void getProjectsList() {
        LOG.info(projects);
    }
}
