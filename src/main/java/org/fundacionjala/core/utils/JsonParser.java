package org.fundacionjala.core.utils;

import org.json.simple.JSONObject;
import org.fundacionjala.pivotal.entities.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class JsonParser {

    private static List<User> userList = null;
    private static List<Map<String, String>> driverPropertiesList = null;

    private JsonParser() {
    }

    /**
     * Get a list of Users from a JSONArray read from json file.
     * @return userList
     */
    public static List<User> getUsersFromJsonArray() {
        if (userList == null) {
            userList = new ArrayList<>();
            for (Object obj : JsonFilesReader.jsonArrayFromJsonFile("src/test/resources/JsonFiles/DefaultUsers.json")) {
                JSONObject jsonObj = (JSONObject) ((JSONObject) obj).get("user");
                Map<String, String> userInformation = new HashMap<>();
                userInformation.put("Alias", (String) jsonObj.get("Alias"));
                userInformation.put("Email", (String) jsonObj.get("Email"));
                userInformation.put("Password", (String) jsonObj.get("Password"));
                userInformation.put("User name", (String) jsonObj.get("User name"));
                userInformation.put("Name", (String) jsonObj.get("Name"));
                userInformation.put("Initials", (String) jsonObj.get("Initials"));
                User user = new User();
                user.processInformation(userInformation);
                userList.add(user);
            }
        }
        return userList;
    }

    /**
     * Get a list of Maps that contains Drivers' Properties from a JSONArray read from json file.
     * @return driverPropertiesList
     */
    public static List<Map<String, String>> getDriverPropsFromJsonArray() {
        if (driverPropertiesList == null) {
            driverPropertiesList = new ArrayList<>();
            for (Object obj : JsonFilesReader.
                    jsonArrayFromJsonFile("src/test/resources/JsonFiles/DriverProperties.json")) {
                JSONObject jsonObj = (JSONObject) ((JSONObject) obj).get("webDriver");
                Map<String, String> webDriverInfo = new HashMap<>();
                webDriverInfo.put("name", jsonObj.get("name").toString());
                webDriverInfo.put("implicitWaitingSeconds", jsonObj.get("implicitWaitingSeconds").toString());
                webDriverInfo.put("explicitWaitingSeconds", jsonObj.get("explicitWaitingSeconds").toString());
                webDriverInfo.put("sleepingTimeMills", jsonObj.get("sleepingTimeMills").toString());
                driverPropertiesList.add(webDriverInfo);
            }
        }
        return driverPropertiesList;
    }
}
