package org.fundacionjala.pivotal.context;

import org.fundacionjala.pivotal.entities.EntitiesParser;
import org.fundacionjala.pivotal.entities.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserContext {
    private final List<User> usersList;
    private final List<String> editedUsersList;

    /**
     * Constructor for UserContext class.
     */
    public UserContext() throws IOException {
        this.usersList = EntitiesParser.getUsersListFromJson();
        this.editedUsersList = new ArrayList<>();
    }

    /**
     * Searches for a specific User in userList by a provided alias.
     * @param alias
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
     * Get the List of Edited Users.
     * @return editedUsersList
     */
    public List<String> getEditedUsersList() {
        return editedUsersList;
    }
}
