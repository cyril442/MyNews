package com.example.mynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class SearchActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val toolbar = findViewById<Toolbar>(R.id.toolbar_search_activity)
        setSupportActionBar(toolbar)
        supportActionBar!!. setDisplayHomeAsUpEnabled(true)

        val button = findViewById<Button>(R.id.button_search)

        button.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Search Button Clicked", Toast.LENGTH_SHORT).show()
        })

    }
}
