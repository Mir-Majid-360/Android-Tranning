package com.example.androidjourney.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import com.example.androidjourney.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var  binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val sharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
           val editor=  sharedPreferences.edit()
            editor.putBoolean("flag",true)
            editor.apply()

            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)

        }

    }
}