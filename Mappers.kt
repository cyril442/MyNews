package com.example.mynews.NewYorkTimesApi

import com.example.mynews.Fragments.DataFromNyt

fun mapNytDataToDataFromNyt (nytWrapper: NytWrapper) : DataFromNyt {
    val dataFromNytFirst = nytWrapper.results.first()
    val dataFromNytSecond = nytWrapper.multimedia.first()


    return DataFromNyt(
        title = dataFromNytFirst.title,
        section = dataFromNytFirst.section,
        subsection = dataFromNytFirst.subsection,
        date = dataFromNytFirst.date,
        urlArticle = dataFromNytFirst.urlArticle,
        iconUrl = dataFromNytSecond.iconUrl
    )

}