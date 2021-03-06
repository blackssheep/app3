package com.example.app3.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 黑羊 on 2017/4/7.
 */

public class getBitmap {
    public Bitmap getLocalBitmap(String url){
        try {
            FileInputStream fis=new FileInputStream(url);
            return BitmapFactory.decodeStream(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Bitmap getHttpBitmap(String url){
        URL myFileUrl=null;
        Bitmap bitmap =null;
        try {
            myFileUrl=new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection conn=(HttpURLConnection)myFileUrl.openConnection();
            conn.setConnectTimeout(0);
            conn.setDoInput(true);
            conn.connect();
            InputStream is=conn.getInputStream();
            bitmap=BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
