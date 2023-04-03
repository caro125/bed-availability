package com.example.myapplication


import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot



class Adminpage1 : AppCompatActivity() {
    private lateinit var firstname1: EditText
    private lateinit var lastname1: EditText
    private lateinit var text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adminpage1)
       firstname1 = findViewById(R.id.inputFirstName)
        lastname1= findViewById(R.id.inputLastName)
        text= findViewById(R.id.textViewResult)
        val Button = findViewById<Button>(R.id.saveButton)
        Button.setOnClickListener {
            val firstName = firstname1.text.toString()
            val lastName = lastname1.text.toString()

            saveFireStore(firstName, lastName)

        }

    }

    fun saveFireStore(firstname: String, lastname: String) {
        val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String, Any> = HashMap()
        user["firstName"] = firstname
        user["lastName"] = lastname

        db.collection("users")
            .add(user)
            .addOnSuccessListener {
                Toast.makeText(this@Adminpage1, "record added successfully ", Toast.LENGTH_SHORT ).show()
            }
            .addOnFailureListener{
                Toast.makeText(this@Adminpage1, "record Failed to add ", Toast.LENGTH_SHORT ).show()
            }

    }


    }
