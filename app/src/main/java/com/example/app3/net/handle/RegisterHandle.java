package com.example.app3.net.handle;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 黑羊 on 2017/4/11.
 */

public class RegisterHandle implements RespHandler<Boolean,JSONObject> {
    private Boolean is;
    @Override
    public Boolean parse(JSONObject data) {
        try {
            is= Boolean.valueOf(data.get("infostatus").toString()).booleanValue();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return is;
    }
}
