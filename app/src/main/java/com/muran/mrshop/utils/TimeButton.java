package com.muran.mrshop.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/9/24.
 */

public class TimeButton  extends Button {
    private long lenght = 60 * 1000;// 倒计时长度,这里给了默认60秒
    private String textAfter = "秒后重新获取";
    private String textBefore = "获取验证码";
    private final String TIME = "time";
    private final String CTIME = "ctime";
    private Timer timer;
    private TimerTask timerTask;
    private long time;
    Map<String, Long> map = new HashMap<String, Long>();

    public TimeButton(Context context) {
        super(context);

    }

    public TimeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        // setOnClickListener(this);
    }

    @SuppressLint("HandlerLeak")
    Handler han = new Handler() {
        public void handleMessage(android.os.Message msg) {
            TimeButton.this.setText(time / 1000 + textAfter);
            time -= 1000;
            if (time < 0) {
                TimeButton.this.setEnabled(true);
                TimeButton.this.setText(textBefore);
                TimeButton.this.setTextColor(Color.parseColor("#2A8EDB"));
                clearTimer();
            }
        };
    };

    private void initTimer() {
        time = lenght;
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                //   Log.e("yung", time / 1000 + "");
                han.sendEmptyMessage(0x01);
            }
        };
    }

    private void clearTimer() {
        if (timerTask != null) {
            timerTask.cancel();
            timerTask = null;
        }
        if (timer != null)
            timer.cancel();
        timer = null;
    }
    public void ok(){
        this.setEnabled(false);
        initTimer();
        this.setText(time / 1000 + textAfter);
        // ColorStateList csl = (ColorStateList) color.getColorStateList(R.color.fontcolor);
        //  this.setTextColor(Color.parseColor("#c0c0c0"));
        timer.schedule(timerTask, 0, 1000);
    }
    /**
     * 和activity的onDestroy()方法同步
     */
    public void onDestroy() {
//        if (UserApplication.map == null)
//            UserApplication.map = new HashMap<String, Long>();
//        UserApplication.map.put(TIME, time);
//        UserApplication.map.put(CTIME, System.currentTimeMillis());
//        clearTimer();
    }

    /**
     * 和activity的onCreate()方法同步
     */
    public void onCreate(Bundle bundle) {
//        Log.e("yung", UserApplication.map + "");
//        if (UserApplication.map == null)
//            return;
//        if (UserApplication.map.size() <= 0)// 这里表示没有上次未完成的计时
//            return;
//        long time = System.currentTimeMillis() - UserApplication.map.get(CTIME)
//                - UserApplication.map.get(TIME);
//        UserApplication.map.clear();
//        if (time > 0)
//            return;
//        else {
//            initTimer();
//            this.time = Math.abs(time);
//            timer.schedule(timerTask, 0, 1000);
//            this.setText(time + textAfter);
//            this.setEnabled(false);
//        }
    }

    /** * 设置计时时候显示的文本 */
    public TimeButton setTextAfter(String text1) {
        this.textAfter = text1;
        return this;
    }

    /** * 设置点击之前的文本 */
    public TimeButton setTextBefore(String text0) {
        this.textBefore = text0;
        this.setText(textBefore);
        this.setTextColor(Color.parseColor("#c0c0c0"));
        return this;
    }

    /**
     * 设置到计时长度
     *
     * @param lenght
     *            时间 默认毫秒
     * @return
     */
    public TimeButton setLenght(long lenght) {
        this.lenght = lenght;
        return this;
    }
}