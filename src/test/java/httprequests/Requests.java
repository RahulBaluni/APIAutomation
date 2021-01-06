package httprequests;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import org.apache.commons.io.output.WriterOutputStream;

import java.io.PrintStream;
import java.io.StringWriter;

import static io.restassured.RestAssured.given;

public class Requests {

    Headers headers=new Headers();
    public StringWriter requestWriter;

    public PrintStream getRequestLogger(){
        requestWriter = new StringWriter();
        return new PrintStream(new WriterOutputStream(requestWriter), true);
    }
    public Response getRequest(String endpoint){

        System.out.println("I am inside get request method");
        return given()
                .log()
                .all()
                .filter(new RequestLoggingFilter(getRequestLogger()))
                .headers(headers.getHeaders())
                .get(endpoint);

    }

    public Response postRequest(String endpoint, String body){

        System.out.println("I am inside post request method");
        return given()
                .headers(headers.getHeaders())
                .body(body)
                .post(endpoint);
    }

    public Response patchRequest(String endpoint, String body){
        System.out.println("I am inside update request method");
        return given()
                .log().all()
                .headers(headers.getHeaders())
                .body(body)
                .when()
                .patch(endpoint);
    }
}
