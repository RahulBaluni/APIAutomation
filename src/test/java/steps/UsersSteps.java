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
    public UsersSteps thenIVerifyUsers(){
        Assertions.assertEquals("emma.wong@reqres.com", usersDetails.getEmail(), "Email doesn't match");
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
        validateAndAttachResponse("updateUsers", 201);
        return this;
    }

}
