package com.winter.navdemo.base;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.winter.navdemo.MainActivity;
import com.winter.navdemo.utils.BarUtils;
import com.winter.navdemo.utils.KeyboardUtils;

public class BaseActivity extends AppCompatActivity {

    private Handler handler = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        BarUtils.setStatusBarColor(this, Color.TRANSPARENT);
        BarUtils.setStatusBarLightMode(this, true);
        super.onCreate(savedInstanceState);
        handler = new Handler(getMainLooper());

    }

    public void startActivityDelay(Context context, Class<? extends BaseActivity> clazz, long time){
        handler.postDelayed(() -> context.startActivity(new Intent(context,clazz)),time);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //获取当前获得焦点的View
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View view = getCurrentFocus();
            //调用方法判断是否需要隐藏键盘
            KeyboardUtils.hideKeyboard(ev, view, this);
        }
        return super.dispatchTouchEvent(ev);
    }

}
