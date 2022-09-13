package com.example.androidjourney.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.androidjourney.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


//        MyDBHelper dbHelper = new MyDBHelper(this);
//        dbHelper.addContacts("majid","987654321");
//        dbHelper.addContacts("abc","8765437654");
//        dbHelper.addContacts("def","8765430987");
//        dbHelper.addContacts("ghi","8765432345");
//        dbHelper.addContacts("jkl","8765432345");


        MyDBHelper dbHelper = new MyDBHelper(this);
        ArrayList<ContactModel>  arrContacts =  dbHelper.fetchContacts();

        for(int i = 0;i <arrContacts.size();i++){

            Log.d("CONTACTS","Name :"+ arrContacts.get(i).name + "Phone_no : " + arrContacts.get(i).phone_no);
        }
    }
}