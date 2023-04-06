package com.example.retrofitwithexample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
   public static RetrofitInstance instance;

    ApiInterface apiInterface;

    RetrofitInstance(){
            String api = "https://jsonplaceholder.typicode.com";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface =  retrofit.create(ApiInterface.class);
    }
     public static RetrofitInstance instance(){
         if(instance == null){
             instance = new RetrofitInstance();
         }
         return instance;
     }

//    This code is implementing the Singleton design pattern for the RetrofitInstance class.
//    The Singleton pattern ensures that only one instance of the class can be created throughout the lifetime of the application.
//    Here, a static method instance() is defined, which returns an instance of the RetrofitInstance class.
//    The if condition checks if the instance is null (not created yet), then creates a new instance using the constructor new RetrofitInstance() and assigns it to the instance variable.
//    If the instance already exists, it just returns the existing instance.
//    This ensures that every time the instance() method is called, it returns the same instance of the RetrofitInstance class.
}
