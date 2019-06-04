package com.example.gpts.listplaces.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gpts.R
import com.example.gpts.listplaces.viewmodel.PlaceVM
import kotlinx.android.synthetic.main.item_list_places.view.*

class ListPlacesAdapter(val context:Context, val places:List<PlaceVM>)  :
    RecyclerView.Adapter<ListPlacesAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        return  ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_places,parent,false))

    }

    override fun getItemCount(): Int {

        return  places.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(places[position])
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvPlaceName = itemView.tv_placename

        fun bindView(placeVM: PlaceVM){
            tvPlaceName.text = placeVM.name
        }

    }
}