package com.example.app3.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by 黑羊 on 2017/4/17.
 */

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void openActivity(Class<?> activity){
        Intent intent=new Intent(getApplication(),activity);
        startActivity(intent);
    }
}
