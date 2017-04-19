package com.example.app3.net;

import com.android.volley.Response.ErrorListener;
import com.example.app3.listener.DataListener;

/**
 * Created by 黑羊 on 2017/4/11.
 */

public interface RegisterApl {

    public void isRegister(String name, final DataListener<Boolean> listener,
                           ErrorListener errorListener);
    public void Register(String name, String pwd, String question, String answer, final DataListener<Boolean> listener,
                         ErrorListener errorListener);
}
