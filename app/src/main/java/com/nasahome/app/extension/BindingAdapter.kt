package com.nasahome.app.extension

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import coil.load
import coil.size.Scale
import com.nasahome.app.R

class BindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun bindImage(imageView: AppCompatImageView, url: String?) {
            url?.let {
                imageView.load(it) {
                    crossfade(true)
                    scale(Scale.FIT)
                }
            } ?: kotlin.run {
                imageView.load(R.drawable.ic_launcher_background)
            }
        }

        @JvmStatic
        @BindingAdapter("value")
        fun formatCopyrightValue(textView: AppCompatTextView, name: String?) {
            name?.let {
                textView.text = textView.context.getString(R.string.str_copyright, name)
            } ?: kotlin.run {
                textView.hide()
            }
        }

        @JvmStatic
        @BindingAdapter("description")
        fun setDescription(textView: AppCompatTextView, description: String?) {
            description?.let {
                textView.text = description
            } ?: kotlin.run {
                textView.hide()
            }
        }

        @JvmStatic
        @BindingAdapter("dateformat")
        fun formatDate(textView: AppCompatTextView, dateValue: String?) {
            dateValue?.let {
                textView.text = dateValue.toDate().formatDate()
            } ?: kotlin.run {
                textView.hide()
            }
        }
    }
}