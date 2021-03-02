package com.nasahome.app

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nasahome.app.databinding.ActivityMainBinding
import com.nasahome.app.extension.readDataFromAsset
import com.nasahome.app.extension.toDate
import com.nasahome.app.model.PhotoDetailsItem
import com.nasahome.app.viewmodel.PhotosViewModel

class MainActivity : AppCompatActivity() {

    private val viewModelPhotos: PhotosViewModel by viewModels()
    private val fileName = "data.json"
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initPhotosList()
    }

    /***
     * load data from json file and prepare list
     */
    private fun initPhotosList() {
        val photoCollectionType = object : TypeToken<Collection<PhotoDetailsItem>>() {}.type
        viewModelPhotos.photosList =
            Gson().fromJson(readDataFromAsset(fileName), photoCollectionType)
        viewModelPhotos.photosList.sortedBy { it.date.toDate() }
    }
}