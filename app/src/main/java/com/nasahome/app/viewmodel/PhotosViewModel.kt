package com.nasahome.app.viewmodel

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nasahome.app.base.BaseViewModel
import com.nasahome.app.extension.readDataFromAsset
import com.nasahome.app.extension.toDate
import com.nasahome.app.model.PhotoDetailsItem
import kotlinx.coroutines.launch

class PhotosViewModel(private val application: Application) : BaseViewModel() {
    var photosList = mutableListOf<PhotoDetailsItem>()
    var selectedItem: Int = 0
    private val fileName = "data.json"

    init {
        preparePhotoList()
    }

    /**
     * Parse json data into photos list
     */
    private fun preparePhotoList() {
        viewModelScope.launch {
            val photoCollectionType = object : TypeToken<Collection<PhotoDetailsItem>>() {}.type
            photosList =
                Gson().fromJson(application.assets.readDataFromAsset(fileName), photoCollectionType)
            photosList.sortBy { it.date.toDate() }
        }
    }
}