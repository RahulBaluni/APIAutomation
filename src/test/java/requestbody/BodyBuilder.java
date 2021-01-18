package requestbody;

import com.google.gson.Gson;
import payload.*;

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

    public String getRegisterUserBody(String email, String password){
        return new Gson()
                .toJson(RegisterUserPayload.builder()
                        .email(email)
                        .password(password)
                        .build());
    }

    public String getUnsuccessfulRegisterUserBody(String email){
        return new Gson()
                .toJson(UnsuccessfulRegisterUserPayload.builder()
                        .email(email)
                        .build());
    }

    public String getLoginUserBody(String email, String password){
        return new Gson()
                .toJson(LoginUserPayload.builder()
                        .email(email)
                        .password(password)
                        .build());
    }

    public String getUnsuccessfulLoginUserBody(String email){
        return new Gson()
                .toJson(UnsuccessfulLoginUserPayload.builder()
                        .email(email)
                        .build());
    }

    public String getUpdateUserPutBody(String name, String job){
        return new Gson()
                .toJson(UpdateUserPutPayload
                        .builder()
                        .name(name)
                        .job(job)
                        .build());
    }

    public String getCreatUserDraftBody(){
        return new Gson()
                .toJson(new CreateDraftUserPayload()
                        .toBuilder()
                        .id("0")
                        .message(new Message()
                                .toBuilder()
                                .historyId("1")
                                .id("1.1")
                                .internalDate("1/18/21")
                                .payload(new Payload()
                                        .toBuilder()
                                        .filename("test")
                                        .mimeType("MimeType")
                                        .partId("123")
                                        .build())
                                .raw("11")
                                .sizeEstimate(10)
                                .snippet("Test")
                                .threadId("100")
                                .build())
                        .build());

    }
}
