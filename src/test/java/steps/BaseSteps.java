package steps;

import httprequests.Requests;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import requestbody.BodyBuilder;

public class BaseSteps {

    Requests requests = new Requests();
    BodyBuilder bodybuilder = new BodyBuilder();
    Response response;

    protected void validateAndAttachResponse(String attachmentName, int statusCode) {
        System.out.println(response.asString());
        Allure.addAttachment(attachmentName + "Request", requests.requestWriter.toString());
        Allure.addAttachment(attachmentName + "Response", response.asString());
        Assertions.assertEquals(statusCode, response.statusCode());
    }
}
