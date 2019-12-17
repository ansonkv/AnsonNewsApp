package com.anson.newsapp.ui.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.anson.newsapp.common.ImageLoader
import okio.JvmStatic

object BindingUtil {

    @BindingAdapter("loadImage")
    @JvmStatic
    fun loadImageFromNetwork(imageView: ImageView, url: String) {
        ImageLoader.loadImage(imageView, url)
    }

}