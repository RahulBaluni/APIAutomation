package tests;

import httprequests.EndPoints;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import steps.UsersSteps;
import utils.FileUtils;

import java.io.IOException;
import java.util.Properties;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsersSpec {
    UsersSteps userssteps = new UsersSteps();
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

    @Test
    public void getUsersTest() {
        userssteps
                .whenIRetrieveUsers()
                .thenIVerifyUsers();
    }
    @Test
    public void createUserTest() {
        userssteps
                .whenICreateUser("Rocky", "Killer");
    }
    @Test
    public void updateUserTest() {
        userssteps
                .whenIUpdateUser("Rocky", "KillerAF");
    }
}