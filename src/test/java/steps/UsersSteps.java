package steps;

import httprequests.EndPoints;
import httprequests.Requests;
import io.restassured.response.Response;
import requestbody.BodyBuilder;
import utils.FileUtils;

public class UsersSteps {

    Requests requests = new Requests();
    FileUtils fileUtils = new FileUtils();
    Response response;
    BodyBuilder bodybuilder = new BodyBuilder();
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
        response = requests.postRequest(EndPoints.createUsersEndpoint(),bodybuilder.getCreateUserBody(name, job));
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
        return this;
    }
}
