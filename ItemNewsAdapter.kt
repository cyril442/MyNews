package com.example.mynews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynews.Fragments.DataFromNyt


class ItemNewsAdapter (val datasFromNyt : List<DataFromNyt>, val itemClickListener : View.OnClickListener )
    : RecyclerView.Adapter<ItemNewsAdapter.ViewHolder>()  {

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder (itemView) {
        val cardView = itemView.findViewById<CardView>(R.id.card_view)
        val iconView = itemView.findViewById<ImageView>(R.id.icon)
        val sectionView = cardView.findViewById<TextView>(R.id.section)
        val subsectionView = cardView.findViewById<TextView>(R.id.subsection)
        val titleView = cardView.findViewById<TextView>(R.id.title)
        val dateView = cardView.findViewById<TextView>(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return ViewHolder(viewItem)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataFromNyt = datasFromNyt[position]
        holder.cardView.setOnClickListener(itemClickListener)
        holder.cardView.tag = position
        holder.sectionView.text = dataFromNyt.section
        holder.subsectionView.text = dataFromNyt.subsection
        holder.titleView.text = dataFromNyt.title
        holder.dateView.text = dataFromNyt.date
       // holder.iconView. = dataFromNyt.iconUrl
    }

    override fun getItemCount(): Int {
        return datasFromNyt.size

    }



}

