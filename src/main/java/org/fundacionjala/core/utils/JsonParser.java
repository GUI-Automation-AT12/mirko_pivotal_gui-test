package org.fundacionjala.core.utils;

import org.json.simple.JSONObject;
import org.fundacionjala.pivotal.entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class JsonParser {
    public static List<User> getUsersFromJsonArray(){
        List<User> userList = new ArrayList<>();
        for (Object obj : JsonFilesReader.jsonArrayFromJsonFile("src/test/resources/JsonFiles/DefaultUsers.json")) {
            JSONObject jsonObj = (JSONObject)((JSONObject)obj).get("user");
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
        return userList;
    }
}
