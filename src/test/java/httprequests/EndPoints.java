package httprequests;

import java.util.HashMap;

public class EndPoints {

    public static HashMap<String, String> endpoints;

    public static String getUsersEndpoint() {
        return endpoints.get("baseurl") + endpoints.get("getUsers");
    }
}