package com.winter.navdemo.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    private static class HOLDER{
        private static RetrofitUtils instance = new RetrofitUtils();
    }

    public static RetrofitUtils getInstance(){
        return HOLDER.instance;
    }
    public Retrofit get(){
        return new Retrofit.Builder()
                .client(getClient())
                .baseUrl("http://101.43.93.100:8080")
                .addConverterFactory(GsonConverterFactory.create()).build();
    }
    public OkHttpClient getClient(){
        return  new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .build();
    }
}
