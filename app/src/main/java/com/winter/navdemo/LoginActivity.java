package com.winter.navdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.winter.navdemo.bean.BaseResponse;
import com.winter.navdemo.bean.RequestUser;
import com.winter.navdemo.bean.Person;
import com.winter.navdemo.manager.UserManager;
import com.winter.navdemo.network.ApiService;
import com.winter.navdemo.network.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }


    private void login(){
        RequestUser requestUser = new RequestUser();
        requestUser.setAccount("gaolei");
        requestUser.setPassword("123456");
        RetrofitUtils.getInstance().get().create(ApiService.class).getUser(requestUser)
                .enqueue(new Callback<BaseResponse<Person>>() {
                    @Override
                    public void onResponse(Call<BaseResponse<Person>> call, Response<BaseResponse<Person>> response) {
                        if(response.body()!=null&&response.body().code==200){
                            Person user = response.body().t;
                            UserManager.getInstance().save(user);
                            runOnUiThread(() -> finish());
                        }
                    }
                    @Override
                    public void onFailure(Call<BaseResponse<Person>> call, Throwable t) {
                        Log.d("test","t = "+t.getMessage());
                    }
                });
    }
}
