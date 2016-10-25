package com.muran.mrshop.base;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.muran.mrshop.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/9/2.
 */
public class BaseTitleActivity  extends BaseActivity{

    @BindView(R.id.tv_title_header)
    TextView title;
    @BindView(R.id.btnRight)
    Button btnRight;
    @BindView(R.id.img_btn_back)
    ImageButton btnBack;

}
