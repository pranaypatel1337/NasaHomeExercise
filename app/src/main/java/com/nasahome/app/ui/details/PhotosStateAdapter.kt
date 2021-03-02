package com.nasahome.app.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nasahome.app.model.PhotoDetailsItem
import com.nasahome.app.ui.details.PhotoDetailsFragment.Companion.fragmentPosition

class PhotosStateAdapter(
    fragmentActivity: FragmentActivity,
    private val photoList: List<PhotoDetailsItem>
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = photoList.size

    override fun createFragment(position: Int): Fragment {
        return PhotoDetailsChildFragment().apply {
            arguments = Bundle().apply {
                putInt(fragmentPosition, position)
            }
        }
    }

}