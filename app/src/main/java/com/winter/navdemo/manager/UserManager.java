package com.winter.navdemo.manager;

import android.content.Context;
import android.content.Intent;

import com.kunminx.architecture.ui.callback.UnPeekLiveData;
import com.winter.navdemo.LoginActivity;
import com.winter.navdemo.bean.Person;

public class UserManager {
    public static Person mUser = null;

    public UnPeekLiveData<Person> mutableLiveData = new UnPeekLiveData<>();

    private static class HOLDER{
        private static final UserManager userManager = new UserManager();
    }

    public static UserManager getInstance(){
        return HOLDER.userManager;
    }

    public UnPeekLiveData<Person> test(Context context){
        context.startActivity(new Intent(context, LoginActivity.class));
        return mutableLiveData;
    }

    public void save(Person user){
        mUser = user;
        mutableLiveData.postValue(user);
    }






}
