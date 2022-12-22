package db_github_api.API;

import java.util.ArrayList;

import db_github_api.MainComponents.Model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonAPI {

    @GET("/users")
    Call<ArrayList<Model>> getUsers();

    @GET("/users/{login}")
    Call<Model> getUsers(@Path("login") String login);

}
