package com.example.app3.net.impl;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.example.app3.listener.DataListener;
import com.example.app3.net.CustomRequest;
import com.example.app3.net.RegisterApl;
import com.example.app3.net.handle.RegisterHandle;
import com.example.app3.net.mgr.RequestQueueMgr;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by 黑羊 on 2017/4/11.
 */

public class RedisterApllmpl extends AbsNetwork<Boolean,JSONObject> implements RegisterApl {
    public RedisterApllmpl(){
        mRespHandler=new RegisterHandle();
    }
    @Override
    public void isRegister(String name, final DataListener<Boolean> listener, ErrorListener errorListener) {
        HashMap<String,String> hashMap=new HashMap<String, String>();
        hashMap.put("user_name",name);
        CustomRequest request = new CustomRequest(Request.Method.GET,
                "http://192.168.1.135:5000/v1/user/signup/", hashMap, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (listener != null) {
                    // 解析结果
                    listener.onComplete(mRespHandler.parse(response));
                }
            }
        }, errorListener
        );
        RequestQueueMgr.getRequestQueue().add(request);
    }

    @Override
    public void Register(String name, String pwd, String question, String answer, final DataListener<Boolean> listener, ErrorListener errorListener) {
        HashMap<String,String> hashMap=new HashMap<String, String>();
        hashMap.put("user_name",name);
        hashMap.put("user_password",pwd);
        hashMap.put("user_question",question);
        hashMap.put("user_answer",answer);
        CustomRequest request = new CustomRequest(Request.Method.POST,
                "http://192.168.1.135:5000/v1/user/signup/", hashMap, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (listener != null) {
                    // 解析结果
                    listener.onComplete(mRespHandler.parse(response));
                }
            }
        }, errorListener
        );
        RequestQueueMgr.getRequestQueue().add(request);
    }
}
