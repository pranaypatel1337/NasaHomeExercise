package com.nasahome.app.ui.details

import com.nasahome.app.R
import com.nasahome.app.base.BaseFragment
import com.nasahome.app.databinding.FragmentPhotoDetailsChildBinding
import com.nasahome.app.ui.details.PhotoDetailsFragment.Companion.fragmentPosition
import com.nasahome.app.viewmodel.PhotosViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class PhotoDetailsChildFragment : BaseFragment<FragmentPhotoDetailsChildBinding,
        PhotosViewModel>(R.layout.fragment_photo_details_child) {
    override val viewmodel: PhotosViewModel by sharedViewModel()

    override fun initialize() {
        super.initialize()
        arguments?.containsKey(fragmentPosition)?.apply {
            arguments?.getInt(fragmentPosition, 0)?.let {
                binding.apply {
                    dataModel = viewmodel.photosList[it]
                    executePendingBindings()
                }

            }
        }
    }
}