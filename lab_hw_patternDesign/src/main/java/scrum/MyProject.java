package scrum;

public class MyProject {
    private static int count;
    private int projectNumber;

    public MyProject() {
        count++;
        projectNumber = count;
    }

    public int getProjectNumber() {
        return projectNumber;
    }

    @Override
    public String toString() {
        return "MyProject" + projectNumber;
    }
}
