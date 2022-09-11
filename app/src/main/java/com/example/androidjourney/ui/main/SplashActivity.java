package com.example.androidjourney.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.androidjourney.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding binding;

    String TAG ="SPLASH SCREEN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);

               Boolean check = sharedPreferences.getBoolean("flag",false);

                Log.d(TAG,"first Value");


                Intent intent;

                if (check) {// user is logged in
                    intent = new Intent(SplashActivity.this,HomeActivity.class);
                } else {
                    intent = new Intent(SplashActivity.this,LoginActivity.class);
                }

                startActivity(intent);

            }
        },4000);

    }
}