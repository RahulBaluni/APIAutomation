package steps;

import httprequests.EndPoints;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import providers.UsersDetails;

public class UsersSteps extends BaseSteps{

    UsersDetails usersDetails = new UsersDetails();

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
    public UsersSteps whenICreateUserDraft(){
        response = requests.postRequest(EndPoints.createUsersDraftEndpoint(), bodybuilder.getCreatUserDraftBody());
        validateAndAttachResponse("createUsersDraft", 400);
        return this;
    }
}
