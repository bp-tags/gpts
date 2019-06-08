package com.discordtime.gpts.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FirestoreAPI<T>: RemoteAPI<T> {

    override fun get(): LiveData<List<T>> {
        return MutableLiveData<List<T>>()
    }

}