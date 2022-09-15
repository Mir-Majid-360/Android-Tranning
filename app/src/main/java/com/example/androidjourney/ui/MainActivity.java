package com.example.androidjourney.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidjourney.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    ArrayList<PostsModel> postsModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        MyDBHelper myDBHelper = new MyDBHelper(this);

        try {

            JSONArray jsonArray = loadJSONfromAssets();
            Log.d("HELLO"," "+jsonArray);



            for (int i =0; i < jsonArray.length(); i++) {


                JSONObject postData = jsonArray.getJSONObject(i);


                int user_id = postData.getInt("userId");
                String title = postData.getString("title");
                String  body = postData.getString("body");

                myDBHelper.addPosts(user_id,title,body);






            }

        } catch (JSONException e) {
            e.printStackTrace();
        }







    }


    public JSONArray loadJSONfromAssets() {

        JSONArray jsonArray = new JSONArray();

        String json = null;
        try {

            InputStream inputStream = getAssets().open("posts.json");


            int sizeOfFile = inputStream.available();

            byte[] bufferData = new byte[sizeOfFile];

            inputStream.read(bufferData);
            inputStream.close();
            json = new String(bufferData, "UTF-8");
             jsonArray = new JSONArray(json);

        } catch (IOException | JSONException e) {
            e.printStackTrace();

        }
        return jsonArray;

    }
}