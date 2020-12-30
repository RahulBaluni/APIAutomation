package httprequests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Requests {

    Headers headers=new Headers();

    public Response getRequest(){

        return given().headers(headers.getHeaders()).get();

    }


}
