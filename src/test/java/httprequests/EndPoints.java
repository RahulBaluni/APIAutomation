package httprequests;

import java.util.HashMap;

public class EndPoints {

    public static HashMap<String, String> endpoints;

    public static String getUsersEndpoint() {
        return endpoints
                .get("baseurl") + endpoints
                .get("getUsers");
    }
    public static String createUsersEndpoint() {
        return endpoints
                .get("baseurl") + endpoints
                .get("createUser");
    }
    public static String updateUsersEndpoint() {
        return endpoints
                .get("baseurl") + endpoints
                .get("updateUser");
    }
}
