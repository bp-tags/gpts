package com.discordtime.gpts.di

import com.discordtime.gpts.listplaces.viewmodel.ListPlacesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelModule = module {
    viewModel { ListPlacesViewModel() }
}