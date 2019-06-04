package com.example.gpts.listplaces.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gpts.R
import com.example.gpts.listplaces.model.Place
import com.example.gpts.listplaces.viewmodel.PlaceVM
import kotlinx.android.synthetic.main.activity_main.*

class ListPlacesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_places.adapter = ListPlacesAdapter(this,getList())
        rv_places.layoutManager = LinearLayoutManager(this)

    }


    fun getList() : List<PlaceVM> {
        var list : List<PlaceVM> = listOf(PlaceVM(Place("Cesar")))

        return list
    }
}
