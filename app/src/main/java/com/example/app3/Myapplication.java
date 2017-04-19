package com.example.app3;

import android.app.Application;

import com.example.app3.db.helper.DatabaseMgr;
import com.example.app3.net.mgr.RequestQueueMgr;
import com.example.app3.utils.LoginSession;

/**
 * Created by 黑羊 on 2017/4/13.
 */

public class Myapplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化数据库
        DatabaseMgr.init(this);
        // 初始化网络请求
        RequestQueueMgr.init(this);
        // 初始化
        LoginSession.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        DatabaseMgr.closeDatabase();
        RequestQueueMgr.getRequestQueue().stop();
    }
}
