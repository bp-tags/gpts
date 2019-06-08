package com.discordtime.gpts.listplaces.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.discordtime.gpts.R
import com.discordtime.gpts.listplaces.model.Place
import com.discordtime.gpts.listplaces.viewmodel.ListPlacesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class ListPlacesActivity : AppCompatActivity() {

    private val listPlacesViewModel: ListPlacesViewModel by viewModel()
    private lateinit var listPlaces: List<Place>
    private lateinit var listPlacesAdapter: ListPlacesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listPlaces = listOf()
        listPlacesAdapter = ListPlacesAdapter(this)
        listPlacesAdapter.listPlaces = listPlaces

        rv_places.adapter = listPlacesAdapter
        rv_places.layoutManager = LinearLayoutManager(this)

        fetchPlaces()
    }

    private fun fetchPlaces() {
        listPlacesViewModel.fetch().observe(this, Observer { places ->
            listPlacesAdapter.listPlaces = places
            listPlacesAdapter.notifyDataSetChanged()
        })
    }

}
