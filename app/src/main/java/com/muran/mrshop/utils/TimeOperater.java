package com.muran.mrshop.utils;

import android.content.Context;
import android.text.format.DateUtils;
import android.text.format.Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/8/25.
 */
public class TimeOperater {
    private Context mContext;

    private static int flagsDate = DateUtils.FORMAT_SHOW_DATE;//5月11日
    private static int flagsTime = DateUtils.FORMAT_SHOW_TIME ;//16:40（是二进制显示 下午 04:40）
    private static int flagsWeek = DateUtils.FORMAT_SHOW_WEEKDAY;//星期2
    private static int flagsAMPM = DateUtils.FORMAT_CAP_AMPM;
    private static int flagsTimeStyle = DateUtils.FORMAT_12HOUR;//十二小时制

    public TimeOperater(){

    }
    public TimeOperater(Context context){

        this.mContext = context;
    }
    /**
     * 返回自1970年1月1日  至今的毫秒数
     *
     * */
    public long getTime(){

        long currentTime = System.currentTimeMillis();

        return currentTime;
    }
    /**
     * 时间格式转换
     * String ->Date
     *
     * */
    public  Date strToDate(String str){

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {

            date = format.parse(str);

        } catch (ParseException e) {

            e.printStackTrace();
        }
        return date;

    }
    /**
     * 时间格式转换
     * Date ->毫秒
     *
     * */
    public  long dateToMillis(Date date){

        long mills = date.getTime();

        return mills;
    }

    /**
     * 显示时间格式为今天、昨天、yyyy/MM/dd hh:mm
     *
     * @param context
     * @param when
     * @return String
     */
    public  String formatTimeString(long when) {

        Time then = new Time();
        then.set(when);
        Time now = new Time();
        now.setToNow();

        if(then.year == now.year) {
            //今年
            if (then.yearDay == now.yearDay) {
                //今天  --显示格式 上午 10:30
                String time = (String)DateUtils.formatDateTime(mContext, when, flagsTime|flagsTimeStyle);//12小时制
                return time;

            } else if ((now.yearDay - then.yearDay) == 1) {
                //昨天 --显示格式 昨天 10:30
                String time = (String)DateUtils.formatDateTime(mContext, when, flagsTime);//24小时制
                return "昨天" + time;

            }else if ((now.yearDay - then.yearDay) == 2) {
                //前天 -- 显示格式  前天 11:30
                String time = (String)DateUtils.formatDateTime(mContext, when, flagsTime);//24小时制
                return "前天"+ time;

            }else {
                //今年更早之前 MM月dd日
                String flag = "MM月dd日 ";
                String time = (String)DateUtils.formatDateTime(mContext, when, flagsTime);//24小时制
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(flag);
                String date = simpleDateFormat.format(when);
                String dateTime=date+time;
                return dateTime;
            }
        }else {
            //不是今年 -- 显示格式 yyyy年MM月dd日

            String flag = "yyyy年MM月dd日";

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(flag);
            String time = simpleDateFormat.format(when);

            return time;
        }


    }




}
