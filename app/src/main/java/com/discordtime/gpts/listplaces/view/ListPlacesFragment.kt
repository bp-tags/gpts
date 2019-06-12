package com.discordtime.gpts.listplaces.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.discordtime.gpts.R
import com.discordtime.gpts.listplaces.model.Place
import com.discordtime.gpts.listplaces.viewmodel.ListPlacesViewModel
import kotlinx.android.synthetic.main.fragment_list_places.*
import org.koin.android.viewmodel.ext.android.viewModel

class ListPlacesFragment: Fragment() {

    private val listPlacesViewModel: ListPlacesViewModel by viewModel()
    private lateinit var listPlaces: List<Place>
    private lateinit var listPlacesAdapter: ListPlacesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_places, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listPlaces = listOf()
        listPlacesAdapter = ListPlacesAdapter(view.context)
        listPlacesAdapter.listPlaces = listPlaces

        rv_places.adapter = listPlacesAdapter
        rv_places.layoutManager = LinearLayoutManager(view.context)

        fetchPlaces()
    }

    private fun fetchPlaces() {
        listPlacesViewModel.fetch().observe(this, Observer { places ->
            listPlacesAdapter.listPlaces = places
            listPlacesAdapter.notifyDataSetChanged()
        })
    }

}