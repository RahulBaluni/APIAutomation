package requestbody;

import com.google.gson.Gson;
import payload.CreateUserPayload;

public class BodyBuilder {

    public String getCreateUserBody(String name, String job){

        return new Gson().toJson(CreateUserPayload.builder().name(name).job(job).build());
    }
}
