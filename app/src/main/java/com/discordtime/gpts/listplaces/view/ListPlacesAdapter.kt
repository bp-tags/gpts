package com.discordtime.gpts.listplaces.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.discordtime.gpts.R
import com.discordtime.gpts.listplaces.model.Place
import kotlinx.android.synthetic.main.item_list_places.view.*

class ListPlacesAdapter(private val context:Context)  :
    RecyclerView.Adapter<ListPlacesAdapter.ViewHolder>(){

    var listPlaces: List<Place> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_places,parent,false))
    }

    override fun getItemCount() : Int {
        return listPlaces.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(listPlaces[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvPlaceName: TextView = itemView.tv_placename

        fun bindView(place: Place){
            tvPlaceName.text = place.name
        }
    }
}