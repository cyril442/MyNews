package com.example.mynews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.example.mynews.Fragments.Tab1Fragment
import com.example.mynews.Fragments.Tab2Fragment
import com.example.mynews.Fragments.Tab3Fragment
import com.example.mynews.Fragments.Tab4Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

        // 5) Setting Up of the value pager Adapter

    var pagerAdapter : CustompagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 6) settiong Up of the page Adapter in the Oncreate

        pagerAdapter = CustompagerAdapter(supportFragmentManager)
        pagerAdapter!!.addFragments(Tab1Fragment(), "Fragment 1")
        pagerAdapter!!.addFragments(Tab2Fragment(), "Fragment 2")
        pagerAdapter!!.addFragments(Tab3Fragment(), "Fragment 3")
        pagerAdapter!!.addFragments(Tab4Fragment(), "Fragment 4")

        //7) Adding pagerAdapter to viewpager
        customViewPager.adapter = pagerAdapter

        //8) Setting up viewpager with tabLayout
        customTabLayout.setupWithViewPager(customViewPager)


        // 1) Set the Custom Toolbar to the MainActivity
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


    }

    //2) Creation of the Menu associated to the toolbar when onCreate Activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_main, menu)
        return true
    }

    //3) Management of the clicks on the item of the menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Each case is treated
        when (item.itemId) {
            R.id.action_search -> {
                val intent = Intent(this, SearchActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_notification -> {
                Toast.makeText(this, "Notification Button Clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_about -> {
                Toast.makeText(this, "About Button Clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_help -> {
                Toast.makeText(this, "help Button Clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            // In else, we return the default value
            else -> return super.onOptionsItemSelected(item)
        }

    }
}
