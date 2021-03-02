package com.nasahome.app.viewmodel

import com.nasahome.app.base.BaseViewModel
import com.nasahome.app.model.PhotoDetailsItem

class PhotosViewModel : BaseViewModel() {
    var photosList = mutableListOf<PhotoDetailsItem>()
    var selectedItem: Int = 0
}