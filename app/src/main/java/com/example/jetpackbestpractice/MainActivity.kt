package com.example.jetpackbestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
    	// hello world
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}