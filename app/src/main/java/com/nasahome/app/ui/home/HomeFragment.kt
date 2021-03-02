package com.nasahome.app.ui.home

import androidx.fragment.app.activityViewModels
import com.nasahome.app.R
import com.nasahome.app.base.BaseFragment
import com.nasahome.app.databinding.FragmentHomeBinding
import com.nasahome.app.viewmodel.PhotosViewModel

class HomeFragment:BaseFragment<FragmentHomeBinding,PhotosViewModel>(R.layout.fragment_home) {
    override val viewmodel: PhotosViewModel by activityViewModels()

}