package org.fundacionjala.pivotal.context;

import java.util.ArrayList;
import java.util.List;

public class ProjectContext {
    private List<String> projectsIdsToDelete;

    /**
     * Constructor for ProjectContext class.
     */
    public ProjectContext() {
        projectsIdsToDelete = new ArrayList<>();
    }

    /**
     * Gets the List of Projects Ids to delete.
     * @return projectsIdsToDelete
     */
    public List<String> getProjectsIdsToDelete() {
        return projectsIdsToDelete;
    }
}
