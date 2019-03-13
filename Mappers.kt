package com.example.mynews.NewYorkTimesApi

import com.example.mynews.Fragments.DataFromNyt

fun mapNytDataToDataFromNyt (nytWrapper: NytWrapper) : DataFromNyt {
    val dataFromNytFirst : ResultsData = nytWrapper.results.first()
     val dataFromNytSecond : Multimedia = nytWrapper.results.first().multimedia.first()



    return DataFromNyt(
        title = dataFromNytFirst.title,
        section = dataFromNytFirst.section,
        subsection = dataFromNytFirst.subsection,
        date = dataFromNytFirst.date,
        urlArticle = dataFromNytFirst.urlArticle,
        iconUrl = dataFromNytSecond.iconUrl,
        caption = dataFromNytSecond.caption

    )

}