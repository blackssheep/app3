package com.example.app3.net.impl;

import com.android.volley.Request;
import com.android.volley.Response;
import com.example.app3.listener.DataListener;
import com.example.app3.net.CustomRequest;
import com.example.app3.net.LoginApl;
import com.example.app3.net.handle.LoginHandle;
import com.example.app3.net.mgr.RequestQueueMgr;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by 黑羊 on 2017/4/15.
 */

public class LoginApllmpl extends AbsNetwork<String,JSONObject> implements LoginApl {
    public LoginApllmpl(){
        mRespHandler=new LoginHandle();
    }

    @Override
    public void login(String name, String password, final DataListener<String> listener, Response.ErrorListener errorListener) {
        HashMap<String,String> hashMap=new HashMap<String, String>();
        hashMap.put("user_name",name);
        hashMap.put("user_password",password);
        CustomRequest request = new CustomRequest(Request.Method.POST,
                "http://192.168.1.135:5000/v1/user/login/", hashMap, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (listener != null) {
                    // 解析结果
                    listener.onComplete(mRespHandler.parse(response));
                }
            }
        }, errorListener
        );
        RequestQueueMgr.getRequestQueue().add(request);    }
}
