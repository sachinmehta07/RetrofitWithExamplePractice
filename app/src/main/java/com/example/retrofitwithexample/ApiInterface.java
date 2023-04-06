package com.example.retrofitwithexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("/photos")
   Call<List<UserModel>> getUser();

    @POST("/photos")
     Call<UserModel> createUser(@Body UserModel user);

}
