package com.example.app3.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.app3.R;
import com.example.app3.utils.SelectPicture;
import com.example.app3.utils.getBitmap;
import com.example.app3.views.fragments.ArticleFragment;
import com.jaiky.imagespickers.ImageSelectorActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import info.hoang8f.android.segmented.SegmentedGroup;

public class MainActivity extends BaseArticleActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        RadioGroup.OnCheckedChangeListener{
    public static final int REQUEST_CODE = 123;
    private ArrayList<String> path = new ArrayList<>();
    getBitmap bitmap;
    ImageView headImg;
    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.user_img) ImageView user_img;
    @Bind(R.id.drawer_layout) DrawerLayout drawer;
    @Bind(R.id.segmented4) SegmentedGroup segmentedGroup;
    @Bind(R.id.nav_view) NavigationView navigationView;
    @Bind(R.id.main_ss_btn) Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragmentContainer(R.id.articles_container);
        ButterKnife.bind(this);//简化findviewbyid()

        initdrawer();
        //初始显示的Fragment
        ArticleFragment articleFragment = new ArticleFragment();
        articleFragment.setRetainInstance(true);
        addFragment(articleFragment);
    }
    private void initdrawer() {
        //初始化顶部选择按钮
        segmentedGroup.setTintColor(0xFF1b7ce8);
        segmentedGroup.setOnCheckedChangeListener(this);

        //初始化侧边栏
        navigationView.setNavigationItemSelectedListener(this);
        //获取顶部布局
        View head=navigationView.getHeaderView(0);
        headImg= (ImageView) head.findViewById(R.id.imageView);
        headImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectPicture t=new SelectPicture(MainActivity.this,MainActivity.this);
                t.Picture();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,FindActivity.class);
                startActivity(intent);
            }
        });
        user_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.my_main) {


        } else if (id == R.id.my_mess) {


        } else if (id == R.id.my_attent) {


        } else if (id == R.id.my_fan) {

        } else if (id == R.id.my_collect) {

        } else if (id == R.id.up_or_pub) {
            Intent intent=new Intent(MainActivity.this,WriteActivity.class);
            startActivity(intent);

        } else if (id == R.id.fit) {

            Intent intent = new Intent(MainActivity.this,
                    ShezhiActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            List<String> pathList = data.getStringArrayListExtra(ImageSelectorActivity.EXTRA_RESULT);
            path.clear();
            path.addAll(pathList);
            setImageView();
        }
    }

    private void setImageView() {
        bitmap=new getBitmap();
        headImg.setImageBitmap(bitmap.getLocalBitmap(path.get(0)));
    }
}
