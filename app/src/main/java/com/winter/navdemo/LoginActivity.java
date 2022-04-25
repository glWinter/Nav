package com.winter.navdemo;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.winter.navdemo.bean.BaseResponse;
import com.winter.navdemo.bean.RequestUser;
import com.winter.navdemo.bean.User;
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
                .enqueue(new Callback<BaseResponse<User>>() {
                    @Override
                    public void onResponse(Call<BaseResponse<User>> call, Response<BaseResponse<User>> response) {
                        if(response.body()!=null&&response.body().code==200){
                            User user = response.body().t;
                            UserManager.flag = true;
                            UserManager.getInstance().mutableLiveData.postValue("a");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    finish();
                                }
                            });
                        }
                    }
                    @Override
                    public void onFailure(Call<BaseResponse<User>> call, Throwable t) {

                    }
                });
    }
}
