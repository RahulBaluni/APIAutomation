package tests;

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
public class UsersSpec extends BaseSpec{

    UsersSteps userssteps = new UsersSteps();

    @Test
    @Tag("get_users")
    @Description("Get Users List")
    @DisplayName("Get API Test")
    @Severity(SeverityLevel.CRITICAL)
    public void getUsersTest() {
        userssteps.whenIRetrieveUsers().thenIVerifyUsers();
    }

    @Test
    @Tag("update_users")
    public void updateUserTest() {
        userssteps.whenIUpdateUser("Rocky", "KillerAF");
    }

    @Test
    @Tag("create_users")
    public void createUserTest() {
        userssteps.whenICreateUser("Anmol", "QA Automation");
    }

    @Test
    public void delayedResponseTest() {
        userssteps.whenIRetrieveDelayedResponse("40");
    }
}
