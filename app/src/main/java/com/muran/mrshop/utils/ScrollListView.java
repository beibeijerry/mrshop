package com.muran.mrshop.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/9/5.
 */
public class ScrollListView extends ListView {
    public ScrollListView(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);

    }


    public ScrollListView(Context context, AttributeSet attrs) {

        super(context, attrs);

    }


    public ScrollListView(Context context) {

        super(context);

    }


    @Override

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,

                MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);

    }

}
