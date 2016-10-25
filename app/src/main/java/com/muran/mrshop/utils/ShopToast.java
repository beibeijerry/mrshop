package com.muran.mrshop.utils;

import android.app.Activity;

/**
 * Created by Administrator on 2016/9/1.
 */
public class ShopToast {
    public static void show(Activity context, String msg){
        android.widget.Toast.makeText(context, msg, android.widget.Toast.LENGTH_SHORT).show();
    }
}
