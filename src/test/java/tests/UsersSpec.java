package tests;

import httprequests.EndPoints;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import steps.UsersSteps;
import utils.FileUtils;

import java.io.IOException;
import java.util.Properties;

@Feature("Users List Portal")
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
    @Tag("get_users")
    @Description("Get Users List")
    @DisplayName("Get API Test")
    @Severity(SeverityLevel.CRITICAL)
    public void getUsersTest() {
        userssteps
                .whenIRetrieveUsers()
                .thenIVerifyUsers();
    }
    @Test
    @Tag("update_users")
    public void updateUserTest() {
        userssteps
                .whenIUpdateUser("Rocky", "KillerAF");
    }
    @Test
    @Tag("create_users")
    public void createUserTest() {
        userssteps
                .whenICreateUser("Anmol", "QA Automation");
    }
}
