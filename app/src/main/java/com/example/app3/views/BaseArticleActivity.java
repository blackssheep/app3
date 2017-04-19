package com.example.app3.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by 黑羊 on 2017/3/31.
 */

public class BaseArticleActivity extends ActionBarActivity {
    protected FragmentManager mFragmentManager;
    protected int mFrgmContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    protected void setFragmentContainer(int container) {
        mFrgmContainer = container;
    }

    protected void addFragment(Fragment fragment) {
        mFragmentManager.beginTransaction().add(mFrgmContainer, fragment).commit();
    }

    protected void replaceFragment(Fragment fragment) {
        mFragmentManager.beginTransaction().replace(mFrgmContainer, fragment).commit();
    }
}
