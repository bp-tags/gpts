package com.discordtime.gpts.remote

import androidx.lifecycle.LiveData

interface RemoteAPI<T> {

    fun get(): LiveData<List<T>>

}