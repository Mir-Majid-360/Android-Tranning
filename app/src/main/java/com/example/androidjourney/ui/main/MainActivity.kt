package com.example.androidjourney.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androidjourney.R
import com.example.androidjourney.databinding.ActivityMainBinding
import com.example.androidjourney.ui.fragment.FirstFragment
import com.example.androidjourney.ui.fragment.SecondFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val Tag = "MMM: First Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Tag, "onCreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val secondFragment = SecondFragment()
        val firstFragment = FirstFragment()
        changeFragment(firstFragment)


        binding.btn1.setOnClickListener {
            changeFragment(firstFragment)
        }

        binding.btn2.setOnClickListener {

            changeFragment(secondFragment)
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d(Tag, "onStart")
    }

    override fun onResume() {
        Log.d(Tag, "onResume")
        super.onResume()

    }

    override fun onPause() {
        Log.d(Tag, "onPause")
        super.onPause()

    }

    override fun onStop() {
        Log.d(Tag, "onStop")
        super.onStop()

    }

    override fun onRestart() {
        Log.d(Tag, "onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(Tag, "onDestroy")
        super.onDestroy()
    }

    fun changeFragment(fragment: Fragment) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, fragment)
        transaction.commit()


    }

}