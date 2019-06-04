package com.example.gpts.listplaces.viewmodel

import com.example.gpts.listplaces.model.Place

class PlaceVM (val place : Place) {

    val name: String

    init {
        name = place.name
    }
}
