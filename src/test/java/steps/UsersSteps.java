package steps;

import httprequests.EndPoints;
import httprequests.Requests;
import io.restassured.response.Response;
import requestbody.BodyBuilder;
import utils.FileUtils;

public class UsersSteps {

    Requests requests = new Requests();
    FileUtils fileUtils = new FileUtils();
    BodyBuilder bodybuilder = new BodyBuilder();
    Response response;
    public UsersSteps whenIRetrieveUsers(){
        System.out.println("I am in whenIRetrieveUsers method");
        response = requests.getRequest(EndPoints.getUsersEndpoint());
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        return this;

    }

    public UsersSteps thenIVerifyUsers(){
        System.out.println("I am in thenIVerifyUsers method");
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
