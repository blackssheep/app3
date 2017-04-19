package com.example.app3.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jaiky.imagespickers.ImageLoader;

/**
 * Created by 黑羊 on 2017/3/3.
 */

public class GlideLoader implements ImageLoader {
    @Override
    public void displayImage(Context context, String path, ImageView imageView) {
        Glide.with(context)
                .load(path)
                .placeholder(com.jaiky.imagespickers.R.drawable.global_img_default)
                .centerCrop()
                .into(imageView);
    }
}
