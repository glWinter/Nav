package com.winter.navdemo.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.winter.navdemo.base.BaseActivity;
import com.winter.navdemo.databinding.MainLoginActivityLayoutBinding;

public class LoginActivity extends BaseActivity {
    MainLoginActivityLayoutBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainLoginActivityLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.title.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(TitleBar titleBar) {
                OnTitleBarListener.super.onLeftClick(titleBar);
                finish();
            }
        });

    }
}
