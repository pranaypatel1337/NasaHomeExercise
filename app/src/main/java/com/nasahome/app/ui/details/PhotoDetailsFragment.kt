package com.nasahome.app.ui.details

import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.nasahome.app.R
import com.nasahome.app.base.BaseFragment
import com.nasahome.app.databinding.FragmentHomeBinding
import com.nasahome.app.databinding.FragmentPhotoDetailsBinding
import com.nasahome.app.viewmodel.PhotosViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class PhotoDetailsFragment :
    BaseFragment<FragmentPhotoDetailsBinding, PhotosViewModel>(R.layout.fragment_photo_details) {
    override val viewmodel: PhotosViewModel by sharedViewModel()

    override fun initialize() {
        super.initialize()
        binding.apply {
            viewPagerPhotos.adapter = PhotosStateAdapter(
                this@PhotoDetailsFragment.requireActivity(),
                viewmodel.photosList
            )
            viewPagerPhotos.post {
                viewPagerPhotos.setCurrentItem(viewmodel.selectedItem,false)
            }
        }
        initViewClick()
    }

    private fun initViewClick() {
        binding.buttonNext.setOnClickListener {
            binding.viewPagerPhotos.apply {
                if (currentItem < viewmodel.photosList.size) {
                    currentItem += 1
                }
            }

        }
        binding.buttonPrevious.setOnClickListener {
            binding.viewPagerPhotos.apply {
                if (currentItem >= 0) {
                    currentItem -= 1
                }
            }
        }
        binding.viewPagerPhotos.apply {
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    binding.buttonPrevious.isEnabled = position != 0
                    binding.buttonNext.isEnabled = position != viewmodel.photosList.size - 1

                }
            })
        }
    }

    companion object {
        const val fragmentPosition: String = "fragmentPosition"
    }
}