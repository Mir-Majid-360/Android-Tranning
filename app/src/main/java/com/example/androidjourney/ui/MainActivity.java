package com.example.androidjourney.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidjourney.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        MyDBHelper dbHelper = new MyDBHelper(this);
        dbHelper.addContacts("majid","987654321");
        dbHelper.addContacts("abc","8765437654");
        dbHelper.addContacts("def","8765430987");
        dbHelper.addContacts("ghi","8765432345");
        dbHelper.addContacts("jkl","8765432345");
    }
}