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

    public static String getDelayedResponseEndpoint(String delay) {
        return String.format(endpoints
                .get("baseurl") + endpoints
                .get("delayedResponseEndpoint"), delay);
    }

    public static String deleteUsersEndpoint(String id, String name) {
        return String.format(endpoints.get("baseurl") + endpoints
                .get("deleteUser"), id, name);
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

    public static String unsuccessfulLoginUserEndpoint() {
        return endpoints
                .get("baseurl") + endpoints
                .get("unsuccessfulLogin");
    }

    public static String unsuccessfullRegisterUserEndpoint() {
        return endpoints
                .get("baseurl") + endpoints
                .get("registerUserUnsuccessful");
    }

    public static String updatePutUserEndpoint() {
        return endpoints
                .get("baseurl") + endpoints
                .get("updatePutUser");
    }

    public static String createUsersDraftEndpoint() {
        return endpoints
                .get("createUsersDraft");
    }

    public static String gmailUsersMessagesSendEndpoint() {
        return endpoints
                .get("gmailUsersMessagesSend");
    }
}
