package steps;

import httprequests.EndPoints;
import httprequests.Requests;
import io.restassured.response.Response;
import utils.FileUtils;

public class UsersSteps {

    Requests requests = new Requests();
    FileUtils fileUtils = new FileUtils();
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
}
