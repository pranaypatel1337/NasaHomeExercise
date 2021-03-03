package com.nasahome.app.ui.home

import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.nasahome.app.R
import com.nasahome.app.base.BaseFragment
import com.nasahome.app.databinding.FragmentHomeBinding
import com.nasahome.app.extension.toast
import com.nasahome.app.utils.ItemOffsetDecoration
import com.nasahome.app.viewmodel.PhotosViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, PhotosViewModel>(R.layout.fragment_home) {
    override val viewmodel: PhotosViewModel by sharedViewModel()


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
                    root.findNavController().navigate(R.id.photoDetailsFragment)
                }
            }
            recyclerViewPlanetsInfo.apply {
                adapter = photoListAdapter
                addItemDecoration(
                    ItemOffsetDecoration(
                        this@HomeFragment.requireContext(),
                        R.dimen.dimen_space_item
                    )
                )
                (layoutManager as StaggeredGridLayoutManager).gapStrategy=StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
            }
        }
    }
}