package steps;

import httprequests.EndPoints;
import httprequests.Headers;
import io.qameta.allure.Step;
import org.awaitility.Awaitility;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import providers.UsersDetails;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

public class UsersSteps extends BaseSteps{

    UsersDetails usersDetails = new UsersDetails();
    Headers header = new Headers();

    @Step
    @DisplayName("Step to retrieve Users list")
    public UsersSteps whenIRetrieveUsers(){
        response = requests.getRequest(EndPoints.getUsersEndpoint());
        validateAndAttachResponse("getUsers", 200);
        usersDetails.setGetUsersResponse(response);
        return this;
    }

    @Step
    public UsersSteps thenIVerifyUserEmail(){
        Assertions.assertEquals("emma.wong@reqres.in", usersDetails.getEmail(), "Email doesn't match");
        return this;
    }

    @Step
    public UsersSteps whenICreateUser(String name, String job){
        header.addHeader("header1","value1");
        response = requests.postRequest(EndPoints.createUsersEndpoint(), bodybuilder.getCreateUserBody(name, job));
        validateAndAttachResponse("createUsers", 201);
        return this;
    }

    @Step
    public UsersSteps whenIUpdateUser(String name, String job){
        response = requests.patchRequest(EndPoints.updateUsersEndpoint(), bodybuilder.getUpdateUserBody(name, job));
        validateAndAttachResponse("updateUsers", 200);
        return this;
    }

    @Step
    public UsersSteps thenIVerifyJob(){
        Assertions.assertEquals("KillerAF",usersDetails.getJob(),"Job doesn't match");
        return this;
    }

    @Step
    public UsersSteps thenIVerifyName(){
        Assertions.assertEquals("KillerAF",usersDetails.getUserName(),"Name doesn't match");
        return this;
    }

    @Step
    public UsersSteps thenIVerifyCreatedJob(){
        Assertions.assertEquals("QA Automation",usersDetails.getCreatedJob(),"Job doesn't match");
        return this;
    }

    @Step
    public UsersSteps thenIVerifyCreatedName(){
        Assertions.assertEquals("Anmol",usersDetails.getCreatedName(),"Name doesn't match");
        return this;
    }

    @Step
    public UsersSteps whenIDeleteUser(String id, String name){
        response = requests.deleteRequest(EndPoints.deleteUsersEndpoint(id, name));
        validateAndAttachResponse("deleteUsers", 204);
        return this;
    }

    @Step
    public UsersSteps whenIRegisterUser(String email, String password){
        response = requests.postRequest(EndPoints.registerUsersEndpoint(), bodybuilder.getRegisterUserBody(email, password));
        validateAndAttachResponse("registerUser", 200);
        return this;
    }

    @Step
    public UsersSteps whenUserLogin(String email, String password){
        response = requests.postRequest(EndPoints.loginUserEndpoint(), bodybuilder.getLoginUserBody(email, password));
        validateAndAttachResponse("loginUser", 200);
        return this;
    }

    @Step
    public UsersSteps whenUserLoginUnsuccessful(String email){
        response = requests.postRequest(EndPoints.unsuccessfullRegisterUserEndpoint(), bodybuilder.getUnsuccessfulLoginUserBody(email));
        validateAndAttachResponse("unsuccessfulLogin", 400);
        return this;
    }

    @Step
    public UsersSteps whenUserRegistrationUnsuccessful(String email){
        response = requests.postRequest(EndPoints.unsuccessfullRegisterUserEndpoint(), bodybuilder.getUnsuccessfulRegisterUserBody(email));
        validateAndAttachResponse("registerUserUnsuccessful", 400);
        return this;
    }

    @Step
    public UsersSteps whenUpdateUserAsPut(String name, String job){
        response = requests.putRequest(EndPoints.updatePutUserEndpoint(),bodybuilder.getUpdateUserPutBody(name, job));
        validateAndAttachResponse("updatePutUser", 200);
        usersDetails.getUpdatedUserResponse(response);
        return this;
    }

    @Step
    @DisplayName("retrieving delayed response")
    public UsersSteps whenIRetrieveDelayedResponse(String delay){
        response = requests.getRequest(EndPoints.getDelayedResponseEndpoint(delay));
        Assertions.assertEquals(200, response.getStatusCode(), "code not matched");
        System.out.println(response.asString());
        System.out.println(response.statusCode());
        response = requests.postRequest(EndPoints.createUsersEndpoint(), bodybuilder.getCreateUserBody("anmol", "qa"));
        System.out.println(response.asString());
        System.out.println(response.statusCode());
        Awaitility.await().atMost(5, TimeUnit.SECONDS).until(() -> this.response.getStatusCode()==200);
        validateAndAttachResponse("getDelayed", 201);
        return this;
    }

    public UsersSteps whenICreateUserDraft() throws IOException, ParseException {
        header.resetHeaders();
        header.addHeader("AccessToken","awefgwfak");
        //header.setAccessToken();
        response = requests.postRequest(EndPoints.createUsersDraftEndpoint(), bodybuilder.getCreatUserDraftBody());
        validateAndAttachResponse("createUsersDraft", 400);
        return this;
    }

    @Step
    public UsersSteps whenISendGmailUsersMessages(){
        header.addHeader("header1","value1");
        header.setAccessToken();
        response = requests.postRequest(EndPoints.gmailUsersMessagesSendEndpoint(), bodybuilder.getGmailUsersMessagesSendBody());
        validateAndAttachResponse("gmailUsersMessagesSend", 400);
        return this;
    }

    @Step
    public UsersSteps whenICreateUserDraftByJsonFile() throws IOException, ParseException {
        header.resetHeaders();
        header.addHeader("AccessToken","awefgwfak");
        response = requests.postRequest(EndPoints.createUsersDraftEndpoint(), bodybuilder.getCreatUserDraftBody());
        validateAndAttachResponse("createUsersDraft", 400);
        return this;
    }
}
