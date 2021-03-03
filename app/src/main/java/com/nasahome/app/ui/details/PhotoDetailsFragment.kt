package com.nasahome.app.ui.details

import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.nasahome.app.R
import com.nasahome.app.base.BaseFragment
import com.nasahome.app.databinding.FragmentPhotoDetailsBinding
import com.nasahome.app.viewmodel.PhotosViewModel
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class PhotoDetailsFragment :
    BaseFragment<FragmentPhotoDetailsBinding, PhotosViewModel>(R.layout.fragment_photo_details) {
    override val viewmodel: PhotosViewModel by sharedViewModel()

    override fun initialize() {
        super.initialize()
        setPagerAdapter()
        observeViewClick()
        bindViewPagerListener()
    }

    /**
     * Set all images with details using view pager and set selected item
     */
    private fun setPagerAdapter() {
        binding.apply {
            viewPagerPhotos.adapter = PhotosStateAdapter(
                this@PhotoDetailsFragment.requireActivity(),
                viewmodel.photosList
            )
            viewPagerPhotos.post {
                viewPagerPhotos.setCurrentItem(viewmodel.selectedItem, false)
            }
        }
    }

    /**
     * view pager page call back to maintain next previous button state
     */
    private fun bindViewPagerListener() {
        binding.viewPagerPhotos.apply {
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    binding.buttonPrevious.isEnabled = position != 0
                    binding.buttonNext.isEnabled = position != viewmodel.photosList.size - 1
                }
            })
        }
    }

    /**
     * Observe view state and perform event
     */
    private fun observeViewClick() {
        lifecycleScope.launchWhenStarted {
            viewmodel.viewState.collect {
                when (it) {
                    is ViewClickState.ImageViewBackClick -> {
                        binding.root.findNavController().popBackStack()
                    }
                    is ViewClickState.ButtonPreviousClick -> {
                        setViewPagerItem(1)
                    }
                    is ViewClickState.ButtonNextClick -> {
                        setViewPagerItem(0)
                    }
                    else -> {
                    }
                }
            }
        }
    }

    /**
     *
     */
    private fun setViewPagerItem(case: Int) {
        binding.viewPagerPhotos.apply {
            if (case == 0) {
                if (currentItem < viewmodel.photosList.size) {
                    currentItem += 1
                }
            } else {
                if (currentItem >= 0) {
                    currentItem -= 1
                }
            }
        }
    }

    companion object {
        const val fragmentPosition: String = "fragmentPosition"
    }
}