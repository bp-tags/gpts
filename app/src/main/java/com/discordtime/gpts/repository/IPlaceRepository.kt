package com.discordtime.gpts.repository

import androidx.lifecycle.LiveData
import com.discordtime.gpts.listplaces.model.Place

interface IPlaceRepository {

    fun getPlaces(): LiveData<List<Place>>

}