package com.example.mynews.Fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynews.App
import com.example.mynews.ItemNewsAdapter
import com.example.mynews.NewYorkTimesApi.Multimedia
import com.example.mynews.NewYorkTimesApi.NytWrapper
import com.example.mynews.NewYorkTimesApi.mapNytDataToDataFromNyt

import com.example.mynews.R
import com.google.gson.GsonBuilder

import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_tab1.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Tab1Fragment : Fragment(), View.OnClickListener {


    companion object {
        fun newInstance(): Tab1Fragment {
            return Tab1Fragment()
        }
    }

    //9) to Bind the Adapter to the RecyclerView and Main Activity
    lateinit var datasFromNyt: MutableList<DataFromNyt>
    //11) Set the adapter
    lateinit var newsAdapter: ItemNewsAdapter

    lateinit var recyclerView: RecyclerView


    private val TAG = Tab1Fragment::class.java.simpleName




    override fun onCreate(savedInstanceState: Bundle?) {


        val call = App.nytService.getNytDataTopStories()
        call.enqueue(object : Callback<NytWrapper> {


            //HOW TO WAIT TO GET RESPONSE OR FAILURE?


            override fun onResponse(call: Call<NytWrapper>, response: Response<NytWrapper>) {

                //  Log.i(TAG, "NYT response : ${response.body()}")
                response.body()?.let {

                    val dataFromNyt = mapNytDataToDataFromNyt(it)
                    Log.i(TAG, "DataFromNyt response : $dataFromNyt")


                }




            }

            override fun onFailure(call: Call<NytWrapper>, t: Throwable) {
                Log.e(TAG, "Nyt response : Could not load ! ", t)
                Toast.makeText(activity, "could not load Nyt Datas", Toast.LENGTH_SHORT).show()
            }

        })



        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tab1, container, false)

        //10) Initialize the DatasfromNyt into the onCreateView
        datasFromNyt = mutableListOf<DataFromNyt>()
//        // ICI trois test en local:
        datasFromNyt.add(
            DataFromNyt(
                "Il est libre Max!",
                "Monde ",
                " > France",
                "28 juin 2019",
                "https://www.nytimes.com/2019/03/06/us/politics/us-trade-deficit.html",
                "https://static01.nyt.com/images/2019/03/06/reader-center/06dc-deficit-hp/06dc-deficit-hp-thumbStandard.jpg",
                "The United States trade deficit in goods reached $891.3 billion in 2018 — the highest it’s ever been."
            )
        )
        datasFromNyt.add(
            DataFromNyt(
                "C'est sur",
                "europe",
                "brexit",
                "12 mars 2019",
                "https://www.nytimes.com/2019/03/06/business/bank-regulation.html",
                "https://static01.nyt.com/images/2019/03/07/business/06dc-crisis1/06dc-crisis1-thumbStandard.jpg",
                "The Federal Reserve said that it would no longer give banks a passing or failing grade on a portion of the annual stress tests used to ensure a bank had sufficient resources to lend during an economic downturn."
            )
        )
        datasFromNyt.add(
            DataFromNyt(
                "Il est CANAILLOUX!",
                "France ",
                " > Bearn",
                "28 juin 2019",
                "https://www.nytimes.com/2019/03/06/us/politics/us-trade-deficit.html",
                "https://static01.nyt.com/images/2019/03/06/reader-center/06dc-deficit-hp/06dc-deficit-hp-thumbStandard.jpg",
                "The United States trade deficit in goods reached $891.3 billion in 2018 — the highest it’s ever been."
            )

        )




//        //12) Initialize newsAdapter into the onCreate
        newsAdapter = ItemNewsAdapter(datasFromNyt, this)


        //14) Collect the Recycler View from the Layout
        recyclerView = view.findViewById(R.id.top_stories_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(false)
        recyclerView.adapter = newsAdapter

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



    }

    override fun onClick(view: View) {
        Toast.makeText(activity, "clické sur item + {${tag}}", Toast.LENGTH_SHORT).show()
    }

}
