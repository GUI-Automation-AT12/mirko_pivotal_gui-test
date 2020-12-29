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
     * @param uAlias
     */
    public void setAlias(final String uAlias) {
        this.alias = uAlias;
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
     * @param uEmail
     */
    public void setEmail(final String uEmail) {
        this.email = uEmail;
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
     * @param uPassword
     */
    public void setPassword(final String uPassword) {
        this.password = uPassword;
    }

    /**
     * Sets UserName to a User.
     * @param userUserName
     */
    public void setUserName(final String userUserName) {
        userName = userUserName.replaceAll("UNIQUE_ID", IdGenerator.getUniqueId());
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
     * @param uName
     */
    public void setName(final String uName) {
        this.name = uName;
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
        strategyMap.put("Alias", () -> setAlias(userInformation.get("Alias")));
        strategyMap.put("Name", () -> setName(userInformation.get("Name")));
        strategyMap.put("Initials", () -> setInitials(userInformation.get("Initials")));
        strategyMap.put("Email", () -> setEmail(userInformation.get("Email")));
        strategyMap.put("Password", () -> setPassword(userInformation.get("Password")));
        strategyMap.put("User name", () -> setUserName(userInformation.get("User name")));
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
