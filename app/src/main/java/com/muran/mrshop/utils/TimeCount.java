package com.muran.mrshop.utils;

import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.widget.TextView;

import com.muran.mrshop.R;

/**
 * Created by Administrator on 2016/8/30.
 */
public class TimeCount implements Runnable {
    private TextView timeCount;
    private Handler mHandler = new Handler();//全局handler
    int i = 0;//时间差
    private RunPostlistener runlistener;

    public TimeCount(TextView textView, int time, RunPostlistener listener) {
        timeCount = textView;
        i = time;
        runlistener = listener;
    }

    public static String getInterval(int interval) {
        String txt = null;
        if (interval >= 0) {
            long day = interval / (24 * 3600);//Ìì
            long hour = interval % (24 * 3600) / 3600;//Ð¡Ê±
            long minute = interval % 3600 / 60;//·ÖÖÓ
            long second = interval % 60;//Ãë
            if (day > 0) {
                txt += day + "天" + hour + "时" + minute + "分" + second + "秒";
            } else if (hour > 0) {
                txt += hour + "时" + minute + "分" + second + "秒";
            } else if (minute > 0) {
                txt += minute + "分" + second + "秒";
            } else if (second > 0) {
                txt += second + "秒";
            }
        }
        return txt;
    }

    @Override
    public void run() {
        while (i > 0)//整个倒计时执行的循环
        {
            i--;
            mHandler.post(new Runnable() //通过它在UI主线程中修改显示的剩余时间
            {
                public void run() {
                    timeCount.setText(getInterval(i));//显示剩余时间
                }
            });
            try {
                Thread.sleep(1000);//线程休眠一秒钟     这个就是倒计时的间隔时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //倒计时结束执行
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                runPost();
            }
        });
    }

    public void runPost() {
        runlistener.Run();
    }
}

