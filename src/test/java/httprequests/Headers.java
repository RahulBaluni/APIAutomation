package httprequests;

import java.util.HashMap;

public class Headers {
    private HashMap<String, String> headersMap=new HashMap<>();

    public HashMap<String, String> getHeaders(){

        headersMap.put("content-type", "application/json");
        return headersMap;
    }
}
