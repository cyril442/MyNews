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
import com.example.mynews.NewYorkTimesApi.NytWrapper
import com.example.mynews.NewYorkTimesApi.mapNytDataToDataFromNyt

import com.example.mynews.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class Tab1Fragment : Fragment() {


    private val TAG = Tab1Fragment::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val call = App.nytService.getNytDataTopStories()
        call.enqueue(object : Callback<NytWrapper>{

            override fun onResponse(call: Call<NytWrapper>, response: Response<NytWrapper>) {

                Log.i(TAG, "NYT response : ${response.body()}")
                response?.body()?.let {
                    val dataFromNyt = mapNytDataToDataFromNyt(it)

                    Log.i(TAG, "DataFromNyt response : $dataFromNyt")
                }

            }
            override fun onFailure(call: Call<NytWrapper>, t: Throwable) {
                Log.e(TAG, "Nyt response : Could not load ! ", t)
                Toast.makeText(activity, "could not load Nyt Datas", Toast.LENGTH_SHORT).show()
            }


        })
    }


}
