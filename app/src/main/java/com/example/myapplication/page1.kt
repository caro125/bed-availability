package com.example.myapplication



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.widget.SearchView

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Myadapter
import java.util.*
import kotlin.collections.ArrayList
class page1 : AppCompatActivity() {
    private lateinit var newRecylerview : RecyclerView
    private lateinit var adapter: Myadapter
    private lateinit var newArrayList : ArrayList<hospital>
    private lateinit var tempArrayList : ArrayList<hospital>

    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page1)
        imageId = arrayOf(
            R.drawable.apolo,
            R.drawable.cmc,
            R.drawable.srm,
            R.drawable.government
        )

        heading = arrayOf(
            "Apollo hospital trichy Ariyamangalam Area, Chennai - Madurai Highway, Trichy ",
            "Christian Medical College Vellore, INDIA, 632002",
            "Trichy SRM Medical College Hospital Research Center, SRM Nagar, Trichy – Chennai Highway",
        "Government medical college")

        newRecylerview =findViewById(R.id.recyclerView)


        newRecylerview.layoutManager = LinearLayoutManager(this)
        newRecylerview.setHasFixedSize(true)
        val positionToScroll = 5
        newRecylerview.smoothScrollToPosition(positionToScroll)
        // Attach the adapter to the RecyclerView
        //newRecylerview.adapter = adapter

        newArrayList = arrayListOf<hospital>()

        getUserdata()

    }
    private fun getUserdata() {

        for(i in imageId.indices){

            val news = hospital(imageId[i],heading[i])
            newArrayList.add(news)

        }
     newRecylerview.adapter=Myadapter(newArrayList)
    }}