package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button=findViewById<Button>(R.id.button3)
        button.setOnClickListener{
            val intent= Intent(this,Login::class.java)
            startActivity(intent)
        }
        val button1=findViewById<Button>(R.id.button2)
        button1.setOnClickListener{
            val intent= Intent(this,navigation_drawer::class.java)
            startActivity(intent)
        }
}}