package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import steps.UsersSteps;

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

        userssteps
                .whenIRetrieveUsers()
                .thenIVerifyUserEmail();
    }

    @Test
    @Tag("update_users")
    public void updateUserTest() {
        userssteps
                .whenIUpdateUser("Rocky", "KillerAF").thenIVerifyJob().thenIVerifyName();
    }

    @Test
    @Tag("created_users")
    public void createUserNameTest() {
        userssteps
                .whenIUpdateUser("Anmol", "QA Automation").thenIVerifyCreatedName().thenIVerifyCreatedJob();
    }

    @Test
    @Tag("create_users")
    public void createUserTest() {

        userssteps
                .whenICreateUser("Anmol", "QA Automation");
    }

    @Test
    @Tag("delete_users")
    public void deleteUserTest() {
        userssteps
                .whenIRetrieveUsers()
                .whenIDeleteUser("5","anmol");
    }

    @Test
    @Tag("register_users")
    public void registerUserTest() {

        userssteps
                .whenIRegisterUser("eve.holt@reqres.in","pistol");
    }

    @Test
    @Tag("unsuccessful_register_users")
    public void unsuccessfulRegisterUserTest() {

        userssteps
                .whenUserRegistrationUnsuccessful("sydney@fife");
    }

    @Test
    @Tag("login_users")
    public void loginUserTest() {
        userssteps
                .whenUserLogin("eve.holt@reqres.in","cityslicka");
    }

    @Test
    @Tag("Unsuccessful_login_users")
    public void unsuccessfulLoginUserTest() {
        userssteps
                .whenUserLoginUnsuccessful("peter@klaven");
    }

    @Test
    @Tag("Update_users_AsPut")
    public void updateUserPutTest() {
        userssteps
                .whenUpdateUserAsPut("morpheus","zion residents");
    }

    @Test
    @Tag("CreateUserDraft")
    public void createUserDraftTest() {

        userssteps
                .whenICreateUserDraft();
    }
}