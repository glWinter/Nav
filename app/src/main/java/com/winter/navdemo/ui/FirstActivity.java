package com.winter.navdemo.ui;


import android.os.Bundle;

import androidx.annotation.Nullable;

import com.winter.navdemo.MainActivity;
import com.winter.navdemo.R;
import com.winter.navdemo.base.BaseActivity;


public class FirstActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_splash_activity_layout);
        startActivityDelay(this, MainActivity.class,2000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
