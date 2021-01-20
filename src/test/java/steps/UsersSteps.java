package steps;

import httprequests.EndPoints;
import io.qameta.allure.Step;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import providers.UsersDetails;

import java.util.concurrent.TimeUnit;


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

}
