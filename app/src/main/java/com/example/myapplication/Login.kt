package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
class Login : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var fetchdata:Button

    lateinit var btnLogin: Button

    private lateinit var insertdata: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // View Binding
        val firebase : DatabaseReference = FirebaseDatabase.getInstance().getReference()
        btnLogin = findViewById(R.id.button)




}}