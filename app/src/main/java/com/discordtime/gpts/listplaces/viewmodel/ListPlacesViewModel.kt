package com.discordtime.gpts.listplaces.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.discordtime.gpts.listplaces.model.Place
import com.discordtime.gpts.repository.IPlaceRepository

class ListPlacesViewModel(val repository: IPlaceRepository): ViewModel() {

    fun fetch() : LiveData<List<Place>> {
        return repository.getPlaces()
    }

}