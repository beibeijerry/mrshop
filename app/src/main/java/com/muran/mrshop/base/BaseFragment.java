package com.muran.mrshop.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.muran.mrshop.MuranApplication;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.data.DataCenter;
import com.muran.mrshop.data.Session;
import com.muran.mrshop.dialog.FlippingLoadingDialog;

import butterknife.ButterKnife;
import io.swagger.client.ApiException;
import io.swagger.client.api.UsApi;
import io.swagger.client.model.UserInfo;

/**
 * Created by Steven on 5/24/16.
 */
public class BaseFragment extends Fragment implements IMuranComponent {

    IMuranComponent muranComponent;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        muranComponent = new MuranComponent(getActivity());
    }

    protected View inflateContentView(LayoutInflater inflater, int viewId) {
        View view = inflater.inflate(viewId, null);
        ButterKnife.bind(this, view);
        return view;
    }

    public void shake(View... views) {
        muranComponent.shake(views);
    }

    public void hideKeyboard() {
        muranComponent.hideKeyboard();
    }

    public void showKeyboard() {
        muranComponent.showKeyboard();
    }

    public Session getCurrentSessioin() {
        return muranComponent.getCurrentSessioin();
    }

    public UserInfo getUserInfo() {
        if (muranComponent.getUserInfo()==null)
        {
            getDataCenter().resetSession();
           getActivity().finish();

        }
        return muranComponent.getUserInfo();
    }

    public MuranApplication getApp() {
        return muranComponent.getApp();
    }

    public Api getApi() {
        return muranComponent.getApi();
    }

    public SVProgressHUD getHud() {
        return muranComponent.getHud();
    }

    @Override
    public DataCenter getDataCenter() {
        return muranComponent.getDataCenter();
    }

    @Override
    public void goToCommonWebViewActivity(Context context, String url,String title) {
        muranComponent.goToCommonWebViewActivity(context, url,title);
    }

    @Override
    public void loadImgToView(String key, ImageView imageView) {
        muranComponent.loadImgToView(key, imageView);
    }
    protected FlippingLoadingDialog mLoadingDialog;
    public FlippingLoadingDialog getLoadingDialog(String msg) {
        if (mLoadingDialog == null)
            mLoadingDialog = new FlippingLoadingDialog(getContext(), msg);
        return mLoadingDialog;
    }
}
