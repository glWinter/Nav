package com.winter.navdemo.manager;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.MutableLiveData;

import com.kunminx.architecture.ui.callback.UnPeekLiveData;
import com.winter.navdemo.LoginActivity;

public class UserManager {
    public static boolean flag = false;
    public UnPeekLiveData<String> mutableLiveData = new UnPeekLiveData<>();

    private static class HOLDER{
        private static final UserManager userManager = new UserManager();
    }

    public static UserManager getInstance(){
        return HOLDER.userManager;
    }

    public UnPeekLiveData<String> test(Context context){
        context.startActivity(new Intent(context, LoginActivity.class));
        return mutableLiveData;
    }






}
