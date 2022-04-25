package com.winter.navdemo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationBarView;
import com.winter.navdemo.databinding.ActivityMainBinding;
import com.winter.navdemo.manager.UserManager;
import com.winter.navdemo.utils.ToastUtils;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);

        navView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.navigation_dashboard&&!UserManager.flag){
                    UserManager.getInstance().test(MainActivity.this)
                            .observe(MainActivity.this, s -> {
                                if(TextUtils.equals("a",s)){
                                    ToastUtils.Show(s);
                                    navController.navigate(R.id.navigation_dashboard);
                                    navView.setSelectedItemId(R.id.navigation_dashboard);
                                }
                            });
                }else{
                    navController.navigate(item.getItemId());
                }
                if(item.getItemId() == R.id.navigation_home||item.getItemId() == R.id.navigation_notifications){
                    return true;
                }else{
                    return UserManager.flag;
                }
            }
        });
    }

}