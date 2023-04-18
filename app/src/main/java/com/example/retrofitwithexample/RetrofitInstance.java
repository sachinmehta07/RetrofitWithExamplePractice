package com.example.retrofitwithexample;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
   public static RetrofitInstance instance;

    ApiInterface apiInterface;

    private Context context;

    public void Myservice(Context context) {
        this.context = context;
    }

    OkHttpClient client = new OkHttpClient().newBuilder()

//            .addInterceptor(new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                    Request request = chain.request().newBuilder()
//                            .build();
//                    Response response = null;
//                    try {
//                        response = chain.withConnectTimeout(15, TimeUnit.SECONDS)
//                                .withReadTimeout(15, TimeUnit.SECONDS)
//                                .proceed(request);
//                    } catch (SocketTimeoutException e) {
//                        // Request timed out, display Toast message
//                        new Handler(Looper.getMainLooper()).post(new Runnable() {
//                            @Override
//                            public void run() {
//                                Log.d("msg", "reqTimeOut: ");
//                                Toast.makeText(context, "Request timed out", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                    }
//                    return response;
//                }
//            })

            .connectTimeout(15, TimeUnit.SECONDS) // set connection timeout to 15 seconds
            .readTimeout(30, TimeUnit.SECONDS) // set read timeout to 30 seconds
            .writeTimeout(30, TimeUnit.SECONDS) // set write timeout to 30 seconds
            .build();

    RetrofitInstance(){
            String api = "https://jsonplaceholder.typicode.";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(api)
                .client(client)
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
