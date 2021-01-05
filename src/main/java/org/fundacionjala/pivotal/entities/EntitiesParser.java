package org.fundacionjala.pivotal.entities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public final class EntitiesParser {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static List<User> userList = null;
    private static List<Project> projectList = null;

    private static final String JSON_FILES_PATH = "src/main/java/org/fundacionjala/pivotal/config/jsonFiles/";
    private static final String USER_JSON_FILE_NAME = "DefaultUsers.json";
    private static final String PROJECT_JSON_FILE_NAME = "DefaultProjects.json";

    private EntitiesParser() {
    }

    /**
     * Get a list of Users from a from DefaultUsers json file.
     * @return userList
     */
    public static List<User> getUsersListFromJson() throws IOException {
        if (userList == null) {
            userList = objectMapper.readValue(
                    new File(JSON_FILES_PATH + USER_JSON_FILE_NAME), new TypeReference<>() { });
        }
        return userList;
    }

    /**
     * Get a list of Projects from a from DefaultProjects json file.
     * @return projectList
     */
    public static List<Project> getProjectListFromJson() throws IOException {
        if (projectList == null) {
            projectList = objectMapper.readValue(
                    new File(JSON_FILES_PATH + PROJECT_JSON_FILE_NAME), new TypeReference<>() { });
        }
        return projectList;
    }
}
