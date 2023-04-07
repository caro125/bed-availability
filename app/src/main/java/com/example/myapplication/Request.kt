package com.example.myapplication

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class Request : AppCompatActivity() {
    private lateinit var name: TextView
    private lateinit var database: DatabaseReference
    private lateinit var firebaseDatabase: FirebaseAuth
    private lateinit var position:Text
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var button: Button
    private lateinit var firstname1: EditText
    private lateinit  var age: EditText
    private lateinit var number: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request)
        name=findViewById(R.id.name)
        val name1=intent.getStringExtra("key")
        name.text="Your severity level is "+name1
        var position=intent.getIntExtra("key1",0)
        position=position+1
       // database= Firebase.database.reference
        firebaseAuth=FirebaseAuth.getInstance()
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("bed")
        button=findViewById(R.id.button)
        firstname1 = findViewById(R.id.name1)
        age= findViewById(R.id.name2)
        number=findViewById(R.id.name3)

        button.setOnClickListener{

            if(name1=="normal"){
                val id= position
                val userRef = myRef.child(id.toString()).child("normal")
                var isDecrementDone = false
                var isDecrementDone1 = false
                userRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val value = dataSnapshot.child("vacancy").value.toString()
                        val vacancy = value.toInt()
                        if (vacancy >= 1) { // check if the value has not been decremented
                            Toast.makeText(this@Request, "$vacancy", Toast.LENGTH_SHORT ).show()
                            val occupiedRef = dataSnapshot.ref.child("occupied")
                            val vacant = dataSnapshot.ref.child("vacancy")
                            if (!isDecrementDone) {
                                occupiedRef.runTransaction(object : Transaction.Handler {
                                    override fun doTransaction(mutableData: MutableData): Transaction.Result {
                                        val currentOccupied =
                                            mutableData.getValue(Int::class.java) ?: 0
                                        mutableData.value =
                                            currentOccupied + 1 // decrement the value
                                        isDecrementDone = true

                                        return Transaction.success(mutableData)
                                    }

                                    override fun onComplete(
                                        error: DatabaseError?,
                                        committed: Boolean,
                                        currentData: DataSnapshot?
                                    ) {
                                        TODO("Not yet implemented")
                                    }

                                })
                            }
                            if (!isDecrementDone1) {
                                vacant.runTransaction(object : Transaction.Handler {
                                    override fun doTransaction(mutableData: MutableData): Transaction.Result {
                                        val currentOccupied =
                                            mutableData.getValue(Int::class.java) ?: 0
                                        mutableData.value =
                                            currentOccupied - 1 // decrement the value
                                        isDecrementDone1 = true
                                        return Transaction.success(mutableData)
                                    }

                                    override fun onComplete(
                                        error: DatabaseError?,
                                        committed: Boolean,
                                        currentData: DataSnapshot?
                                    ) {
                                        TODO("Not yet implemented")
                                    }
                                })
                            }
                            val firstName = firstname1.text.toString()
                            val age = age.text.toString()
                            val number1 = number.text.toString()
                            val user1=user(firstName,age,number1,"normal")
                            val userRef = myRef.child(id.toString()).child("detail").push()
                            userRef.setValue(user1, object : DatabaseReference.CompletionListener {
                                override fun onComplete(
                                    error: DatabaseError?,
                                    ref: DatabaseReference
                                ) {
                                    if (error != null) {
                                        // Handle error
                                        Log.d(TAG, "Data could not be saved: $error")
                                    } else {
                                        // Insert successful
                                        Log.d(TAG, "Data inserted successfully!")
                                    }
                                }
                            })


                        }
                        else{
                            Toast.makeText(this@Request, "no vacany", Toast.LENGTH_SHORT ).show()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }
                })}

            else{
                val id= position
                val userRef = myRef.child(id.toString()).child("critical")
                var isDecrementDone = false
                var isDecrementDone1 = false
                userRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val value = dataSnapshot.child("vacancy").value.toString()
                        val vacancy = value.toInt()
                        if (vacancy >= 1) { // check if the value has not been decremented

                            val occupiedRef = dataSnapshot.ref.child("occupied")
                            val vacant = dataSnapshot.ref.child("vacancy")
                            if (!isDecrementDone) {
                                occupiedRef.runTransaction(object : Transaction.Handler {
                                    override fun doTransaction(mutableData: MutableData): Transaction.Result {
                                        val currentOccupied =
                                            mutableData.getValue(Int::class.java) ?: 0
                                        mutableData.value =
                                            currentOccupied + 1 // decrement the value
                                        isDecrementDone = true
                                        return Transaction.success(mutableData)
                                    }

                                    override fun onComplete(
                                        error: DatabaseError?,
                                        committed: Boolean,
                                        currentData: DataSnapshot?
                                    ) {
                                        TODO("Not yet implemented")
                                    }

                                })
                            }
                            if (!isDecrementDone1) {
                                vacant.runTransaction(object : Transaction.Handler {
                                    override fun doTransaction(mutableData: MutableData): Transaction.Result {
                                        val currentOccupied =
                                            mutableData.getValue(Int::class.java) ?: 0
                                        mutableData.value =
                                            currentOccupied - 1 // decrement the value
                                        isDecrementDone1 = true
                                        return Transaction.success(mutableData)
                                    }

                                    override fun onComplete(
                                        error: DatabaseError?,
                                        committed: Boolean,
                                        currentData: DataSnapshot?
                                    ) {
                                        TODO("Not yet implemented")
                                    }
                                })
                            }
                            val firstName = firstname1.text.toString()
                            val age = age.text.toString()
                            val number1 = number.text.toString()
                            val user1=user(firstName,age,number1,"normal")
                            val userRef = myRef.child(id.toString()).child("detail").push()
                            userRef.setValue(user1, object : DatabaseReference.CompletionListener {
                                override fun onComplete(
                                    error: DatabaseError?,
                                    ref: DatabaseReference
                                ) {
                                    if (error != null) {
                                        // Handle error
                                        Log.d(TAG, "Data could not be saved: $error")
                                    } else {
                                        // Insert successful
                                        Log.d(TAG, "Data inserted successfully!")
                                    }
                                }
                            })
                        }
                        else{
                            Toast.makeText(this@Request, "no vacany", Toast.LENGTH_SHORT ).show()
                        }

                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }
                })}


        }

        }


    }


