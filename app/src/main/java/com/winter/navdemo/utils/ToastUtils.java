package com.winter.navdemo.utils;

import android.widget.Toast;

public class ToastUtils {
    private static Toast toast;
    public static void Show(String msg){
        if(toast == null){
            toast = Toast.makeText(App.getApp(),msg,Toast.LENGTH_SHORT);
        }else{
            toast.setText(msg);
        }
        toast.show();
    }

    public static void show(int resId){
        if(toast == null){
            toast = Toast.makeText(App.getApp(),resId,Toast.LENGTH_SHORT);
        }else{
            toast.setText(resId);
        }
        toast.show();
    }
}
