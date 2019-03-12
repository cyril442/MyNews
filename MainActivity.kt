package com.example.mynews

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.mynews.Fragments.DataFromNyt
import com.example.mynews.Fragments.Tab1Fragment
import com.example.mynews.Fragments.Tab2Fragment
import com.example.mynews.Fragments.Tab3Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


        //9) to Bind the Adapter to the RecyclerView and Main Activity
        lateinit var datasFromNyt : MutableList<DataFromNyt>
        //11) Set the adapter
        lateinit var newsAdapter : ItemNewsAdapter

        // 5) Setting Up of the value pager Adapter
    var pagerAdapter : CustompagerAdapter? = null

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




//        //10) Initialize the DatasfromNyt into the onCreate
        datasFromNyt = mutableListOf<DataFromNyt>()
        // ICI deux test en local:
        datasFromNyt.add(DataFromNyt("Il est libre Max!", "Monde", "France", "28 juin 2019", "https://www.nytimes.com/2019/03/06/us/politics/us-trade-deficit.html", "https://static01.nyt.com/images/2019/03/06/reader-center/06dc-deficit-hp/06dc-deficit-hp-thumbStandard.jpg", "The United States trade deficit in goods reached $891.3 billion in 2018 — the highest it’s ever been."))
        datasFromNyt.add(DataFromNyt("C'est sur", "europe", "Serbie", "12 mars 2019", "https://www.nytimes.com/2019/03/06/business/bank-regulation.html", "https://static01.nyt.com/images/2019/03/07/business/06dc-crisis1/06dc-crisis1-thumbStandard.jpg", "The Federal Reserve said that it would no longer give banks a passing or failing grade on a portion of the annual stress tests used to ensure a bank had sufficient resources to lend during an economic downturn."))

//        //12) Initialize newsAdapter onto the onCreate
        newsAdapter = ItemNewsAdapter(datasFromNyt, this)

//        //14) Collect the Recycler View from the Layout
        val recyclerView = findViewById<RecyclerView>(R.id.top_stories_recycler_view)
            recyclerView.layoutManager = LinearLayoutManager(this)
           // recyclerView.setHasFixedSize(true)
            recyclerView.adapter = newsAdapter



        // 6) setting Up of the page Adapter in the Oncreate

        pagerAdapter = CustompagerAdapter(supportFragmentManager)
        pagerAdapter!!.addFragments(Tab1Fragment(), "Top Stories")
        pagerAdapter!!.addFragments(Tab2Fragment(), "Most Popular")
        pagerAdapter!!.addFragments(Tab3Fragment(), "Sport")


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
    // 13) Implementation of the OnClick on the item
    override fun onClick(view: View) {
        if( view.tag != null){
            Log.i("MainActivityClick", "Click sur un élément de la liste")

        }
    }
}
