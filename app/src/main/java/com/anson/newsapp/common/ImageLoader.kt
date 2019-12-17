package com.anson.newsapp.common

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

object ImageLoader {
    fun loadImage(imageView: ImageView, url: String) {
        Picasso.get().load(url) .into(imageView)

    }
}