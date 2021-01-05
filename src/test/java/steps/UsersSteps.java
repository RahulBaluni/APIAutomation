package steps;

import dto.GetUsersResponse;
import httprequests.EndPoints;
import httprequests.Requests;
import io.restassured.response.Response;
import providers.UsersDetails;
import requestbody.BodyBuilder;
import utils.FileUtils;
import org.junit.jupiter.api.Assertions;

public class UsersSteps {

    Requests requests = new Requests();
    FileUtils fileUtils = new FileUtils();
    BodyBuilder bodybuilder = new BodyBuilder();
    Response response;
    UsersDetails usersDetails = new UsersDetails();
    public UsersSteps whenIRetrieveUsers(){
        System.out.println("I am in whenIRetrieveUsers method");
        response = requests.getRequest(EndPoints.getUsersEndpoint());
        usersDetails.setGetUsersResponse(response);
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        return this;

    }

    public UsersSteps thenIVerifyUsers(){
        System.out.println("I am in thenIVerifyUsers method");
        System.out.println(usersDetails.getPage());
        System.out.println(usersDetails.getEmail());
        Assertions.assertEquals("emma.wong@reqres.com", usersDetails.getEmail(), "Email dosen't match");
        System.out.println(usersDetails.getSupportText());
        return this;
    }

    public UsersSteps whenICreateUser(String name, String job){
        System.out.println("I am in whenICreateUser method");
        response = requests
                .postRequest(EndPoints
                        .createUsersEndpoint(), bodybuilder
                        .getCreateUserBody(name, job));
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
        System.out.println(response.asString());
        System.out.println(response.statusCode());
        return this;
    }
}
