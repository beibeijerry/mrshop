package com.muran.mrshop.utils;

import android.app.Dialog;
import android.content.Context;

/**
 * Created by Administrator on 2016/8/30.
 */
public class ShopTipDialog extends Dialog {

    public ShopTipDialog(Context context) {
        super(context);
    }

    public ShopTipDialog(Context context,String str, int themeResId) {
        super(context, themeResId);
    }

}
