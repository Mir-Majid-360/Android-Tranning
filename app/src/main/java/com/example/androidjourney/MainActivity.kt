package com.example.androidjourney

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    val Tag ="First Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Tag,"onCreate")
        setContentView(R.layout.activity_main)

    }


    override fun onStart() {
        super.onStart()
        Log.d(Tag,"onStart")
    }

    override fun onResume() {
        Log.d(Tag,"onResume")
        super.onResume()

    }

    override fun onPause() {
        Log.d(Tag,"onPause")
        super.onPause()

    }

    override fun onStop() {
        Log.d(Tag,"onStop")
        super.onStop()

    }

    override fun onRestart() {
        Log.d(Tag,"onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(Tag,"onDestroy")
        super.onDestroy()
    }

}