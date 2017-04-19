package com.example.app3.persenters;

import com.android.volley.Response;
import com.example.app3.listener.DataListener;
import com.example.app3.net.LoginApl;
import com.example.app3.net.impl.LoginApllmpl;
import com.example.app3.views.LoginActivity;

/**
 * Created by 黑羊 on 2017/4/15.
 */

public class LoginPersenter {
    LoginApl loginApi=new LoginApllmpl();
    LoginActivity loginActivity;
    Response.ErrorListener mErrorListener = new Response.ErrorListener() {
        public void onErrorResponse(com.android.volley.VolleyError error) {
            int i=1;
        };
    };

    public LoginPersenter(LoginActivity sign){
        loginActivity=sign;
    }

    public void login(String username,String pwd){
        loginActivity.showLoading();
        if (!validate(username,pwd)) {
            loginActivity.hideLoading();
            return;
        }
        loginApi.login(username,pwd,new DataListener<String>() {
            @Override
            public void onComplete(String result) {
                loginActivity.hideLoading();
            }
        },mErrorListener);
    }

    private boolean validate(String username, String pwd){
        boolean valid = true;
        if(username.isEmpty()||username.length() < 4 || username.length() > 10){
            valid=false;
            loginActivity.Login_Name_Error("Username between 4 and 10 alphanumeric characters");
        }
        if(pwd.isEmpty()||pwd.length() < 4 || pwd.length() > 10){
            valid=false;
            loginActivity.Login_Pwd_Error("Password between 4 and 10 alphanumeric characters");
        }
        return valid;
    }
}
