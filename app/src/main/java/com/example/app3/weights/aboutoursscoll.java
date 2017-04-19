package com.example.navigationdrawerdemo;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
/**
 * Created by Administrator on 2016/3/17.
 * 实现跑马灯效果的TextView
 */
public class aboutoursscoll extends TextView {
    public aboutoursscoll(Context context) {
        super(context);
    }
    public aboutoursscoll(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public aboutoursscoll(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //返回textview是否处在选中的状态
    //而只有选中的textview才能够实现跑马灯效果
    @Override
    public boolean isFocused() {
        return true;
    }
}