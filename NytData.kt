package com.example.mynews.NewYorkTimesApi

import com.google.gson.annotations.SerializedName

data class NytWrapper ( val results : ArrayList<ResultsData>,
                       val multimedia : ArrayList<Multimedia>)


data class ResultsData (
    val section : String,
    val subsection : String,
    val title : String,
    @SerializedName("url") val urlArticle : String,
    @SerializedName("updated_date") val date : String,
    @SerializedName ("multimedia") val multimedia : ArrayList<Multimedia>
)

data class Multimedia (
    @SerializedName("url") val iconUrl : String,
    val caption : String

)
