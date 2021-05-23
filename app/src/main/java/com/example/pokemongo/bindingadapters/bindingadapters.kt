package com.example.pokemongo.bindingadapters

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.pokemongo.R

object BindingAdapter {

    @BindingAdapter("imageUrl")
    @JvmStatic fun bindImage(imgView: ImageView, imgUrl: String?) {

        imgUrl?.let {

            Glide.with(imgView.context)
                .load(it)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_error_image)
                .into(imgView)
        }
    }

}