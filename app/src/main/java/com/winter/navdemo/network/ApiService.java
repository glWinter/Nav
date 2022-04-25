package com.winter.navdemo.network;

import com.winter.navdemo.bean.BaseResponse;
import com.winter.navdemo.bean.RequestUser;
import com.winter.navdemo.bean.Person;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/login/info")
    Call<BaseResponse<Person>> getUser(@Body RequestUser requestUser);
}
