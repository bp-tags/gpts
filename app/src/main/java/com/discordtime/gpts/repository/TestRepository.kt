package com.discordtime.gpts.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.discordtime.gpts.listplaces.model.Place

object TestRepository {

    val placesLiveData:MutableLiveData<List<Place>> = MutableLiveData<List<Place>>()

    fun getArrayList() : ArrayList<Place> {
        val arrayList = ArrayList<Place>()
        arrayList.add(Place("place1", "location1"))
        return arrayList
    }

    fun getPlaceLiveData(): LiveData<List<Place>> {
        placesLiveData.value = getArrayList()
        return placesLiveData
    }




}