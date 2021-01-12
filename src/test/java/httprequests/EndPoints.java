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

    public static String deleteUsersEndpoint(String id, String name) {
        return String.format(endpoints
                .get("baseurl") + endpoints
                .get("deleteUser"),id, name);
    }

    public static String registerUsersEndpoint() {
        return endpoints
                .get("baseurl") + endpoints
                .get("registerUser");
    }

    public static String loginUserEndpoint() {
        return endpoints
                .get("baseurl") + endpoints
                .get("loginUser");
    }
}
