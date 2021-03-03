package com.nasahome.app.di

import com.nasahome.app.viewmodel.PhotosViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModules = module {
    viewModel {
        PhotosViewModel(androidApplication())
    }
}