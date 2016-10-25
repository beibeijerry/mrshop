package com.muran.mrshop.base;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.muran.mrshop.MuranApplication;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.data.DataCenter;
import com.muran.mrshop.data.Session;
import com.muran.mrshop.utils.CircleImageView;

import io.swagger.client.model.UserInfo;

/**
 * Created by Steven on 5/24/16.
 */
public interface IMuranComponent {
    void shake(View... views);

    void hideKeyboard();

    void showKeyboard();

    Session getCurrentSessioin();

    UserInfo getUserInfo();

    MuranApplication getApp();

    Api getApi();

    SVProgressHUD getHud();

    DataCenter getDataCenter();

    void goToCommonWebViewActivity(Context context, String url,String title);

    void loadImgToView(String key, ImageView imageView);


}
