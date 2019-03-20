package com.example.mynews

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.widget.Toolbar
import com.example.mynews.Fragments_Search.CalendarFragment

class SearchActivity : AppCompatActivity(), View.OnClickListener, CalendarFragment.CalendarFragmentListener {


    lateinit var calendarFragment : CalendarFragment


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val toolbar = findViewById<Toolbar>(R.id.toolbar_search_activity)
        setSupportActionBar(toolbar)
        supportActionBar!!. setDisplayHomeAsUpEnabled(true)

        // Recuperation of the Fragment into the Search Activity
        calendarFragment = CalendarFragment()



        // the FindViewById from the Fragments collected into the Search Activity for Treatment before request HTTP to the server
        val editTextForSearch = findViewById<EditText>(R.id.edit_query)
        val button = findViewById<Button>(R.id.button_search)






        // OnClick of the button Search
        button.setOnClickListener(View.OnClickListener {
            val querytext = editTextForSearch.text
            var begin = calendarFragment.entryDate

            Toast.makeText(this, "Search Button Clicked", Toast.LENGTH_SHORT).show()
            Log.i("Texte affiché ", " $querytext")
            Log.i("BEG", " $begin ")


        })

    }
    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onDateBegin(entryDate: String) {

     }

}
