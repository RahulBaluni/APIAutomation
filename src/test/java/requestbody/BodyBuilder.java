package requestbody;

import com.google.gson.Gson;
import payload.CreateUserPayload;
import payload.UpdateUserPayload;

public class BodyBuilder {

    public String getCreateUserBody(String name, String job){
        return new Gson()
                .toJson(CreateUserPayload
                        .builder()
                        .name(name)
                        .job(job)
                        .build());
    }

    public String getUpdateUserBody(String name, String job){
        return new Gson()
                .toJson(UpdateUserPayload
                        .builder()
                        .name(name)
                        .job(job)
                        .build());
    }
}
