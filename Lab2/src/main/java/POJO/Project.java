package POJO;

import java.util.ArrayList;

public class Project {
    String projectID;
    ArrayList<String> tasks;

    public Project(String projectID, ArrayList<String> list) {
        this.projectID = projectID;
        this.tasks=new ArrayList<>(list);
    }

    public String getProjectID() {
        return projectID;
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

}
