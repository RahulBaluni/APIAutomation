package providers;

import dto.createuser.CreateUserResponse;
import dto.getusers.GetUsersResponse;
import dto.updateuser.UpdateUserResponse;
import io.restassured.response.Response;

public class UsersDetails {

    private GetUsersResponse getUsersResponse;
    private UpdateUserResponse updateUserResponse;
    private CreateUserResponse createUserResponse;


   // public String getEmail1(){ return getUsersResponse.getData().stream().filter(data -> data.);
   // }

    //--------------------------------
    //To map the response to DTO class
    //--------------------------------
    public void setGetUsersResponse(Response response){
        getUsersResponse = response.getBody().as(GetUsersResponse.class);
    }

    public void getUpdatedUserResponse(Response response){
        updateUserResponse = response.getBody().as(UpdateUserResponse.class);
    }

//    public void setCreateUserResponse(Response response){
//        createUserResponse = response.getBody().as(CreateUserResponse.class);
//    }
    //----------------------------------------------------------------------------------------------------------------
    //Validation functions
    public Integer getPage(){
        return getUsersResponse.getPage();
    }

    public String getEmail(){

        return getUsersResponse
                .getData()
                .get(2)
                .getEmail();
    }

    public String getJob(){

        return updateUserResponse
                .getJob();
    }

    public String getUserName(){
        return updateUserResponse
                .getName();
    }

    public String getCreatedName(){
        return createUserResponse
                .getName();
    }

    public String getCreatedJob(){
        return createUserResponse
                .getJob();
    }
}