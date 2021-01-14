package providers;

import dto.getusers.GetUsersResponse;
import dto.loginuser.LoginUserResponse;
import dto.putupdateuser.PutUpdateUserResponse;
import dto.registeruser.RegisterUserResponse;
import io.restassured.response.Response;

public class UsersDetails {

    private GetUsersResponse getUsersResponse;
    private RegisterUserResponse registerUserResponse;
    private LoginUserResponse loginUserResponse;
    private PutUpdateUserResponse putUpdateUserResponse;

    public Integer getPage(){
        return getUsersResponse.getPage();
    }

    public String getEmail(){
        return getUsersResponse.getData().get(2).getEmail();
    }

   // public String getEmail1(){ return getUsersResponse.getData().stream().filter(data -> data.);
   // }

    public String getSupportText(){
        return getUsersResponse.getSupport().getText();
    }

    //To map the response to DTO class
    public void setGetUsersResponse(Response response){
        getUsersResponse = response.getBody().as(GetUsersResponse.class);
    }

    public void setRegisterUserResponse(Response response){
        registerUserResponse = response.getBody().as(RegisterUserResponse.class);
    }

    public void setLoginUserResponse(Response response){
        loginUserResponse = response.getBody().as(LoginUserResponse.class);
    }

    public void getUpdateAtResponse(Response response){
        putUpdateUserResponse = response.getBody().as(PutUpdateUserResponse.class);
    }
}