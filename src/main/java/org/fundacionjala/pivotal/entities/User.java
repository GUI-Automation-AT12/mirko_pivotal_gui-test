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

    public void setUserName(String userName) {
        this.userName = userName.replaceAll("UNIQUE_ID", IdGenerator.getUniqueId());
    }

    public String getUserName() {
        return userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getInitials() {
        return initials;
    }

    public void processInformation(Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategyMap(userInformation);
        userInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }

    private HashMap<String, Runnable> composeStrategyMap(Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("User name", () -> setUserName(userInformation.get("User name")));
        strategyMap.put("Name", () -> setName(userInformation.get("Name")));
        strategyMap.put("Initials", () -> setInitials(userInformation.get("Initials")));
        return strategyMap;
    }
}
