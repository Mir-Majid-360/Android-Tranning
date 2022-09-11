package com.example.androidjourney.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidjourney.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var  binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnLogout.setOnClickListener {

            val sharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("flag",false)
            editor.apply()

        }


    }
}