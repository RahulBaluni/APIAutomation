package steps;

import httprequests.EndPoints;
import httprequests.Requests;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import providers.UsersDetails;
import requestbody.BodyBuilder;
import utils.FileUtils;

public class UsersSteps {

    Requests requests = new Requests();
    FileUtils fileUtils = new FileUtils();
    BodyBuilder bodybuilder = new BodyBuilder();
    Response response;
    UsersDetails usersDetails = new UsersDetails();

    @Step
    @DisplayName("Step to retrieve Users list")
    public UsersSteps whenIRetrieveUsers(){
        System.out.println("I am in whenIRetrieveUsers method");
        response = requests.getRequest(EndPoints.getUsersEndpoint());
        usersDetails.setGetUsersResponse(response);
        Allure.addAttachment("getRequest",requests.requestWriter.toString());
        Allure.addAttachment("getRequestResponse",response.asString());
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        return this;

    }

    @Step
    public UsersSteps thenIVerifyUsers(){
        System.out.println("I am in thenIVerifyUsers method");
        System.out.println(usersDetails.getPage());
        System.out.println(usersDetails.getEmail());
        Assertions.assertEquals("emma.wong@reqres.com", usersDetails.getEmail(), "Email doesn't match");
        System.out.println(usersDetails.getSupportText());
        return this;
    }

    @Step
    public UsersSteps whenICreateUser(String name, String job){
        System.out.println("I am in whenICreateUser method");
        response = requests
                .postRequest(EndPoints
                        .createUsersEndpoint(), bodybuilder
                        .getCreateUserBody(name, job));
        Allure.addAttachment("createUsersResponse", response.asString());
        System.out.println(response.asString());
        System.out.println(response.statusCode());
        return this;
    }

    public UsersSteps whenIUpdateUser(String name, String job){
        System.out.println("I am in when I UpdateUser method");
        response = requests
                .patchRequest(EndPoints
                        .updateUsersEndpoint(), bodybuilder
                        .getUpdateUserBody(name, job));
        Allure.addAttachment("updateUsersResponse", response.asString());
        Assertions.assertEquals(200, response.statusCode(), "Status code not matched");
        System.out.println(response.asString());
        System.out.println(response.statusCode());
        return this;
    }
}
