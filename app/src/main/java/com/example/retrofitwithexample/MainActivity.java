package com.example.retrofitwithexample;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofitwithexample.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<UserModel> userModelsList;

    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        RetrofitInstance.instance().Myservice(this);
        RetrofitInstance.instance().apiInterface.getUser().enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                userModelsList = response.body();
                activityMainBinding.rvCustom.setAdapter(new userAdapter(userModelsList));
//                for (int i = 0; i < userModelsList.size() ; i++) {
//                    Log.d("api", "onResponse: "+userModelsList.get(i).getTitle());
//                }
            }
            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
               // Log.d("msg", "onFailure: "+t.getLocalizedMessage());
            }
        });
        UserModel newUser = new UserModel(1, 123, "New User", "https://example.com/new-user", "https://example.com/new-user-thumbnail");
       RetrofitInstance.instance().apiInterface.createUser(newUser).enqueue(new Callback<UserModel>() {
           @Override
           public void onResponse(Call<UserModel> call, Response<UserModel> response) {
               Log.d("msg", "onResponse: ");
           }
           @Override
           public void onFailure(Call<UserModel> call, Throwable t) {
               Log.d("msg", "onFailure: ");

           }
       });
    }
}