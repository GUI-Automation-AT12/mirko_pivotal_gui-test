package org.fundacionjala.pivotal.entities;

import org.fundacionjala.core.utils.IdGenerator;

import java.util.HashMap;
import java.util.Map;

public class User {

    // My profile section
    private String userName;
    private String name;
    private String initials;
    private String startPage;
    private String timeZone;
    private String defaultStoryType;

    // My profile photo

    // Email & Password

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

    /**
     * Process all information stored for a User as a map.
     * @param userInformation
     */
    public void processInformation(final Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = composeMapStrategy(userInformation);
        userInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }

    private HashMap<String, Runnable> composeMapStrategy(final Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("User name", () -> setUserName(userInformation.get("User name")));
        strategyMap.put("Name", () -> setName(userInformation.get("Name")));
        strategyMap.put("Initials", () -> setInitials(userInformation.get("Initials")));
        return strategyMap;
    }
}
