package org.fundacionjala.pivotal.entities;

import org.fundacionjala.core.utils.IdGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class User {

    private String alias;
    private Set<String> editedFields;
    // My profile section
    private String userName;
    private String name;
    private String initials;

    // Email & Password
    private String email;
    private String password;

    private static final String KEY_ALIAS = "Alias";
    private static final String KEY_NAME = "Name";
    private static final String KEY_INITIALS = "Initials";
    private static final String KEY_EMAIL = "Email";
    private static final String KEY_PASSWORD = "Password";
    private static final String KEY_USERNAME = "User name";
    private static final String STRING_TO_CHANGE = "UNIQUE_ID";

    /**
     * Get the edited Fields for a User.
     * @return editedFields
     */
    public Set<String> getEditedFields() {
        return editedFields;
    }

    /**
     * Set the Fields which were edited for a User.
     * @param edited
     */
    public void setEditedFields(final Set<String> edited) {
        this.editedFields = edited;
    }

    /**
     * Gets the Alias from a User.
     * @return alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets Alias to a User.
     * @param userAlias
     */
    public void setAlias(final String userAlias) {
        this.alias = userAlias;
    }

    /**
     * Gets the Email from a User.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets Email to a User.
     * @param userEmail
     */
    public void setEmail(final String userEmail) {
        this.email = userEmail;
    }

    /**
     * Gets the Password from a User.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets Password to a User.
     * @param userPassword
     */
    public void setPassword(final String userPassword) {
        this.password = userPassword;
    }

    /**
     * Sets UserName to a User.
     * @param userUserName
     */
    public void setUserName(final String userUserName) {
        userName = userUserName.replaceAll(STRING_TO_CHANGE, IdGenerator.getUniqueId());
    }

    /**
     * Gets the UserName from a User.
     * @return UserName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets Name to a User.
     * @param usName
     */
    public void setName(final String usName) {
        this.name = usName;
    }

    /**
     * Gets the Name from a User.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets Initials to a User.
     * @param userInitials
     */
    public void setInitials(final String userInitials) {
        this.initials = userInitials;
    }

    /**
     * Gets the Initials from a User.
     * @return initials.
     */
    public String getInitials() {
        return initials;
    }

    private HashMap<String, Runnable> composeMapStrategy(final Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(KEY_ALIAS, () -> setAlias(userInformation.get(KEY_ALIAS)));
        strategyMap.put(KEY_NAME, () -> setName(userInformation.get(KEY_NAME)));
        strategyMap.put(KEY_INITIALS, () -> setInitials(userInformation.get(KEY_INITIALS)));
        strategyMap.put(KEY_EMAIL, () -> setEmail(userInformation.get(KEY_EMAIL)));
        strategyMap.put(KEY_PASSWORD, () -> setPassword(userInformation.get(KEY_PASSWORD)));
        strategyMap.put(KEY_USERNAME, () -> setUserName(userInformation.get(KEY_USERNAME)));
        return strategyMap;
    }

    /**
     * Process all information stored for a User as a map.
     * @param userInformation
     */
    public void processInformation(final Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = composeMapStrategy(userInformation);
        userInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }
}
