package com.nasahome.app.ui.details

import androidx.fragment.app.activityViewModels
import com.nasahome.app.R
import com.nasahome.app.base.BaseFragment
import com.nasahome.app.databinding.FragmentHomeBinding
import com.nasahome.app.databinding.FragmentPhotoDetailsBinding
import com.nasahome.app.viewmodel.PhotosViewModel

class PhotoDetailsFragment:BaseFragment<FragmentPhotoDetailsBinding,PhotosViewModel>(R.layout.fragment_photo_details) {
    override val viewmodel: PhotosViewModel by activityViewModels()

}