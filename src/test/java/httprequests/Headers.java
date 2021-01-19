package httprequests;

import java.util.HashMap;

 public class Headers {
    private static HashMap<String, String> headersMap=new HashMap<>();

    public HashMap<String, String> getHeaders(){

        headersMap.put("content-type", "application/json");
        return headersMap;
    }

    public void addHeader(String key, String value){

        headersMap.put(key,value);
    }
    public void setAccessToken(){

        headersMap.put("AutToken","asfd12sfs212");
    }

    public void resetHeaders(){

        if(!headersMap.isEmpty()){
            headersMap.clear();
        }
    }
}
