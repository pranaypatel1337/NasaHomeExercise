package com.nasahome.app.extension

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nasahome.app.R

class BindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun bindImage(imageView: AppCompatImageView, url: String?) {
            url?.let {
                Glide.with(imageView.context).
                load(it).apply(RequestOptions.noTransformation())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(imageView)
            } ?: kotlin.run {
                Glide.with(imageView.context).
                load(R.drawable.ic_launcher_background).apply(RequestOptions.centerCropTransform())
                    .into(imageView)
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