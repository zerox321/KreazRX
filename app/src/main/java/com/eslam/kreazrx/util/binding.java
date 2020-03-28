package com.eslam.kreazrx.util;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

public class binding {
    @BindingAdapter("loadImage")
    public static void loadImage(ImageView view, String imageUrl) {
        if (!imageUrl.isEmpty()) {
            Glide.with(view.getContext())
                    .load(imageUrl)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .into(view);
        }
    }
}
