package org.fundacionjala.pivotal.entities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public final class EntitiesParser {

    private static List<User> userList = null;
    private static final String JSON_FILE_PATH =
            "src/main/java/org/fundacionjala/pivotal/config/jsonFiles/DefaultUsers.json";

    private EntitiesParser() {
    }

    /**
     * Get a list of Users from a from DefaultUsers json file.
     * @return userList
     */
    public static List<User> getUsersListFromJson() throws IOException {
        if (userList == null) {
            ObjectMapper objectMapper = new ObjectMapper();
            userList = objectMapper.readValue(
                    new File(JSON_FILE_PATH), new TypeReference<>() { });
        }
        return userList;
    }
}
