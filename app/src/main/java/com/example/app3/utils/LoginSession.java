
package com.example.app3.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.app3.beans.UserSession;


public class LoginSession {
    static LoginSession sLoginSession;
    SharedPreferences mPreferences;

    private LoginSession(Context context) {
        mPreferences = context.getSharedPreferences("UserInfo", 0);
    }

    public static void init(Context context) {
        if (sLoginSession == null) {
            sLoginSession = new LoginSession(context);
        }
    }

    public static LoginSession getLoginSession() {
        return sLoginSession;
    }

    /**
     * @param userInfo
     */
    public void saveUserInfo(UserSession userInfo) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt("uid", userInfo.userId);
        editor.putString("name", userInfo.name);
        editor.putString("token", userInfo.userToken);
        editor.putInt("user_priilegeid", userInfo.userPri);
        editor.commit();
    }

    public void clear() {
        mPreferences.edit().clear().commit();
    }
    public void clearToken(){SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString("token","");}

    public UserSession getUserInfo() {
        UserSession info = new UserSession();
        info.userId = mPreferences.getInt("uid", 0);
        info.name = mPreferences.getString("name", "游客");
        info.userToken = mPreferences.getString("token", "");
        info.userPri = mPreferences.getInt("user_priilegeid", 0);
        return info;
    }

    public boolean isLogined() {
        return !TextUtils.isEmpty(mPreferences.getString("token", ""));
    }

    public void outLogin() {
    }
}
