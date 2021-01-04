package org.fundacionjala.pivotal.context;

import org.fundacionjala.pivotal.entities.EntitiesParser;
import org.fundacionjala.pivotal.entities.Project;
import org.fundacionjala.pivotal.entities.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Context {
    private final List<User> usersList;
    private final List<Project> projectList;
    private final List<String> editedUsersList;
    private final List<Project> projectListToDelete;

    /**
     * Constructor for Context class.
     */
    public Context() throws IOException {
        this.usersList = EntitiesParser.getUsersListFromJson();
        this.projectList = EntitiesParser.getProjectListFromJson();
        this.editedUsersList = new ArrayList<>();
        this.projectListToDelete = new ArrayList<>();
    }

    /**
     * Searches for a specific User in userList by a provided alias.
     * @param alias provided alias
     * @return User if the alias matches, otherwise return null.
     */
    public User getUserByAlias(final String alias) {
        for (User user : this.usersList) {
            if (alias.equals(user.getAlias())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Searches for a specific Project in projectList providing its name.
     * @param projectName provided to search
     * @return Project if the name matches, otherwise return null.
     */
    public Project getProjectByName(final String projectName) {
        for (Project project : this.projectList) {
            if (projectName.equals(project.getName())) {
                return project;
            }
        }
        return null;
    }

    /**
     * Get the List of Edited Users.
     * @return editedUsersList
     */
    public List<String> getEditedUsersList() {
        return editedUsersList;
    }

    /**
     * Get the List of Projects to delete after some Test Scenarios.
     * @return projectListToDelete
     */
    public List<Project> getProjectListToDelete() {
        return projectListToDelete;
    }
}
