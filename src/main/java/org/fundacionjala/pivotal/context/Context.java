package org.fundacionjala.pivotal.context;

import org.fundacionjala.core.utils.JsonParser;
import org.fundacionjala.pivotal.entities.User;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private List<User> usersList;
    private List<String> editedUsersList;

    /**
     * Constructor for Context class.
     */
    public Context() {
        this.usersList = JsonParser.getUsersFromJsonArray();
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
