package tests;

import httprequests.EndPoints;
import httprequests.Headers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import utils.FileUtils;

import java.io.IOException;
import java.util.Properties;

public class BaseSpec {

    FileUtils fileUtils = new FileUtils();
    Headers headers = new Headers();

    @BeforeAll
    public void setup() throws IOException {
        configureEndpoints();
        System.out.println(" I am insidre setup function");
    }

    @BeforeEach
    public void clearTestContext(){
        System.out.println("I am cleartestcontext fucnction");
        headers.resetHeaders();
    }

    private void configureEndpoints() throws IOException {
        Properties properties = fileUtils.readPropertiesFile("endpoints.properties");
        EndPoints.endpoints = fileUtils.loadPropertiesFileInHashMap(properties);
    }
}
