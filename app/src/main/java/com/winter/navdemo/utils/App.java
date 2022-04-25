package com.winter.navdemo.utils;

import android.app.Application;

import java.lang.reflect.InvocationTargetException;

public class App {
    public static Application getApp(){
        Application sApplication = null;
        try {
            sApplication = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication")
                    .invoke(null,(Object[]) null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return sApplication;
    }
}
