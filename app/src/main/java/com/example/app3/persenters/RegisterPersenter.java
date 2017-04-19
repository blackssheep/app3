package com.example.app3.persenters;

import com.android.volley.Response;
import com.example.app3.listener.DataListener;
import com.example.app3.net.RegisterApl;
import com.example.app3.net.impl.RedisterApllmpl;
import com.example.app3.views.RegisterActivity;

/**
 * Created by 黑羊 on 2017/4/14.
 */

public class RegisterPersenter {
    RegisterApl registerApl=new RedisterApllmpl();
    RegisterActivity signupActivity;
    Response.ErrorListener mErrorListener = new Response.ErrorListener() {
        public void onErrorResponse(com.android.volley.VolleyError error) {
              int i=1;
        };
    };

    public RegisterPersenter(RegisterActivity sign){
        signupActivity=sign;
    }
    public void IsExite(String username){
        if(username.isEmpty()){
            return;
        }
        registerApl.isRegister(username, new DataListener<Boolean>() {
            @Override
            public void onComplete(Boolean result) {
                if(!result)
                signupActivity.Sign_Name_Error("Username has Exite");
            }
        },mErrorListener);
    }
    public void Register(String username,String pwd,String repwd,String question,String answer){
        signupActivity.showLoading();
        if (!validate(username,pwd,repwd,question,answer)) {
            signupActivity.hideLoading();
            return;
        }
        registerApl.Register(username,pwd,question,answer, new DataListener<Boolean>() {
            @Override
            public void onComplete(Boolean result) {
                signupActivity.hideLoading();
            }
        },mErrorListener);
    }

    private boolean validate(String username, String pwd,
                             String repwd, String question, String answer){
        boolean valid = true;
        if(username.isEmpty()||username.length() < 4 || username.length() > 10){
            valid=false;
            signupActivity.Sign_Name_Error("Username between 4 and 10 alphanumeric characters");
        }
        if(pwd.isEmpty()||pwd.length() < 4 || pwd.length() > 10){
            valid=false;
            signupActivity.Sign_Pwd_Error("Password between 4 and 10 alphanumeric characters");
        }
        if(!pwd.equals(repwd)){
            valid=false;
            signupActivity.Sign_Pwd_Error("Password is not equal RePassword");
        }
        if(answer.isEmpty()){
            valid=false;
            signupActivity.Sign_Answer_Error("Answer is not Null");
        }
        return valid;
    }
}
