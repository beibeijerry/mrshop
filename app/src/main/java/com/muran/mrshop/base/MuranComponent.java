package com.muran.mrshop.base;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.bumptech.glide.Glide;
import com.muran.mrshop.MuranApplication;
import com.muran.mrshop.R;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.data.DataCenter;
import com.muran.mrshop.data.Session;
import com.muran.mrshop.ui.CommonWebViewActivity;
import com.muran.mrshop.ui.MainActivity;
import com.muran.mrshop.utils.CircleImageView;
import com.umeng.message.UTrack;

import io.swagger.client.ApiException;
import io.swagger.client.api.UsApi;
import io.swagger.client.model.UserInfo;

/**
 * Created by Steven on 5/24/16.
 */
public class MuranComponent implements IMuranComponent {

    Context context;
    MuranApplication app = null;
    Api api;
    Animation shakeAnimation;
    // 插值器
    CycleInterpolator cycleInterpolator;
    // 振动器
    Vibrator shakeVibrator;

    SVProgressHUD hud;

    public MuranComponent(Context context) {
        this.context = context;
        app = MuranApplication.app;
        api = app.getApi();
        hud = new SVProgressHUD(context);

        // 初始化振动器
        shakeVibrator = (Vibrator) context.getSystemService(Service.VIBRATOR_SERVICE);
        // 初始化震动动画
        shakeAnimation = new TranslateAnimation(0, 10, 0, 0);
        shakeAnimation.setDuration(300);
        cycleInterpolator = new CycleInterpolator(8);
        shakeAnimation.setInterpolator(cycleInterpolator);
    }

    public void shake(View... views) {
        for (View view : views) {
            view.startAnimation(shakeAnimation);
        }
        shakeVibrator.vibrate(new long[]{0, 500}, -1);
    }

    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

    }

    public void showKeyboard() {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (!imm.isActive()) imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public Session getCurrentSessioin() {
        return app.getDataCenter().getCurrentSession();
    }

    public UserInfo getUserInfo() {
        return getCurrentSessioin().getUserInfo();
    }



    public MuranApplication getApp() {
        return app;
    }

    public Api getApi() {
        return api;
    }

    public SVProgressHUD getHud() {
        return hud;
    }

    @Override
    public DataCenter getDataCenter() {
        return app.getDataCenter();
    }

    @Override
    public void goToCommonWebViewActivity(Context context, String url, String title) {
        Intent intent = new Intent(context, CommonWebViewActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("title", title);
        context.startActivity(intent);

    }


    @Override
    public void loadImgToView(String key, ImageView imageView) {
        if (key == null) return;
        Glide.with(context).load(getApi().getImgUrl(key)).into(imageView);
    }


}
