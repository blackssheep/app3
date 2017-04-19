package com.example.app3.net.handle;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 黑羊 on 2017/4/15.
 */

public class LoginHandle implements RespHandler<String,JSONObject> {
    @Override
    public String parse(JSONObject data) {
        try {
            Boolean is= Boolean.valueOf(data.get("infostatus").toString()).booleanValue();
           // if(is){
                String msg=data.get("inforesult").toString();
                JSONObject content=new JSONObject(msg);
                return content.get("usertoken_str").toString();
          //  }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
