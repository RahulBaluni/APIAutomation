package tests;

import httprequests.EndPoints;
import org.junit.jupiter.api.BeforeAll;
import utils.FileUtils;
import java.io.IOException;
import java.util.Properties;

public class BaseSpec {

    FileUtils fileUtils = new FileUtils();

    @BeforeAll
    public void setup() throws IOException {
        configureEndpoints();
        System.out.println(" I am inside setup function");
        System.out.println(EndPoints.getUsersEndpoint());
    }

    private void configureEndpoints() throws IOException {
        Properties properties = fileUtils.readPropertiesFile("endpoints.properties");
        EndPoints.endpoints = fileUtils.loadPropertiesFileInHashMap(properties);
    }
}
