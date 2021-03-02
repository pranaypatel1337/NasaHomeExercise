package com.nasahome.app.ui.home

import androidx.fragment.app.activityViewModels
import com.nasahome.app.R
import com.nasahome.app.base.BaseFragment
import com.nasahome.app.databinding.FragmentHomeBinding
import com.nasahome.app.extension.toast
import com.nasahome.app.utils.ItemOffsetDecoration
import com.nasahome.app.viewmodel.PhotosViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, PhotosViewModel>(R.layout.fragment_home) {
    override val viewmodel: PhotosViewModel by activityViewModels()


    override fun initialize() {
        super.initialize()
        binding.apply {
            val photoListAdapter = PhotoListAdapter(
                R.layout.list_item_nasa_photo,
                viewmodel.photosList
            ) { photoDetailsItem, position ->
                run {
                    this@HomeFragment.toast(photoDetailsItem.title)
                    viewmodel.selectedItem = position
                }
            }
            recyclerViewPlanetsInfo.apply {
                adapter = photoListAdapter
                addItemDecoration(ItemOffsetDecoration(this@HomeFragment.requireContext(),R.dimen.dimen_space_item))
            }
        }
    }
}