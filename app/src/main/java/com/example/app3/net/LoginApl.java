package com.example.app3.net;

import com.android.volley.Response;
import com.example.app3.listener.DataListener;

/**
 * Created by 黑羊 on 2017/4/15.
 */

public interface LoginApl {
    public void login(String name, String password, final DataListener<String> listener,
                      Response.ErrorListener errorListener);
}
