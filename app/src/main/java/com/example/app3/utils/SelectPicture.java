package com.example.app3.utils;

import android.app.Activity;
import android.content.Context;

import com.example.app3.R;
import com.jaiky.imagespickers.ImageConfig;
import com.jaiky.imagespickers.ImageSelector;

import java.util.ArrayList;

/**
 * Created by 黑羊 on 2017/4/7.
 */

public class SelectPicture {
    private ArrayList<String> path = new ArrayList<>();
    private Boolean is=false;

    public static final int REQUEST_CODE = 123;

    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;

    private ImageConfig imageConfig;
    private Context context;
    private Activity activity;

    public SelectPicture(Context context, Activity activity){
        this.context=context;
        this.activity=activity;
    }

    public void Picture(){
        imageConfig = new ImageConfig.Builder(
                new GlideLoader())
                .steepToolBarColor(R.color.titleBlue)
                .titleBgColor(R.color.titleBlue)
                .titleSubmitTextColor(R.color.white)
                .titleTextColor(R.color.white)
                // 开启单选   （默认为多选）
                .singleSelect()
                // 裁剪 (只有单选可裁剪)
                .crop()
                // 开启拍照功能 （默认关闭）
                .showCamera()
                // 设置显示容器
                //.setContainer(llContainer)
                .requestCode(REQUEST_CODE)
                .build();
        ImageSelector.open(activity, imageConfig);
    }
    public void Pictures(){
        imageConfig = new ImageConfig.Builder(
                new GlideLoader())
                .steepToolBarColor(R.color.titleBlue)
                .titleBgColor(R.color.titleBlue)
                .titleSubmitTextColor(R.color.white)
                .titleTextColor(R.color.white)
                //默认为多选
                // 开启拍照功能 （默认关闭）
                .showCamera()
                // 设置显示容器
                //.setContainer(llContainer)
                .requestCode(REQUEST_CODE)
                .build();
        ImageSelector.open(activity, imageConfig);
    }
}
