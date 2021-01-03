package providers;


import dto.GetUsersResponse;
import io.restassured.response.Response;

public class UsersDetails {

    private GetUsersResponse getUsersResponse;

    public Integer getPage(){
        return getUsersResponse.getPage();
    }

    public String getEmail(){
        return getUsersResponse.getData().get(2).getEmail();
    }

    public String getSupportText(){
        return getUsersResponse.getSupport().getText();
    }

    public void setGetUsersResponse(Response response){
        getUsersResponse = response.getBody().as(GetUsersResponse.class);
    }


}
