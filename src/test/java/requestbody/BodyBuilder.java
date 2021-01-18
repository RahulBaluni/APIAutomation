package requestbody;

import com.google.gson.Gson;
import payload.createdraftuserpayload.CreateDraftUserPayload;
import payload.createdraftuserpayload.Message;
import payload.createdraftuserpayload.Payload;
import payload.createuserpayload.CreateUserPayload;
import payload.gmailusersmessagessendpayload.Body;
import payload.gmailusersmessagessendpayload.GmailUsersMessagesSendPayload;
import payload.loginuserpayload.LoginUserPayload;
import payload.registeruserpayload.RegisterUserPayload;
import payload.unsuccessfulloginuserpayload.UnsuccessfulLoginUserPayload;
import payload.unsuccessfulregisteruserpayload.UnsuccessfulRegisterUserPayload;
import payload.updateuserpayload.UpdateUserPayload;
import payload.updateuserpayload.UpdateUserPutPayload;

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

    public String getGmailUsersMessagesSendBody(){
        return new Gson()
                .toJson(new GmailUsersMessagesSendPayload()
                        .toBuilder()
                        .id("4")
                        .historyId("4.1")
                        .internalDate("1-18-21")
                        .payload(new payload
                                .gmailusersmessagessendpayload
                                .Payload()
                                .toBuilder()
                                .body(new Body()
                                        .toBuilder()
                                        .attachmentId("1")
                                        .data("Personal")
                                        .size(500)
                                        .build())
                                .filename("test")
                                .mimeType("TestType")
                                .partId("321")
                                .build())
                        .raw("12")
                        .sizeEstimate(100)
                        .snippet("TDS")
                        .threadId("101")
                        .build());
    }
}
