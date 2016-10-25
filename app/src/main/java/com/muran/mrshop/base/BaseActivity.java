package com.muran.mrshop.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.muran.mrshop.MuranApplication;
import com.muran.mrshop.R;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.data.DataCenter;
import com.muran.mrshop.data.Session;
import com.muran.mrshop.dialog.FlippingLoadingDialog;
import com.umeng.message.PushAgent;

import butterknife.ButterKnife;
import io.swagger.client.model.UserInfo;

/**
 * Created by Steven on 5/20/16.
 */
public class BaseActivity extends AppCompatActivity implements IMuranComponent {


    private IMuranComponent muranComponent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        muranComponent = new MuranComponent(this);
        PushAgent.getInstance(this).onAppStart();
    }

    @Override
    public void setContentView(int viewID) {
        super.setContentView(viewID);
        afterSetContentView();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        afterSetContentView();
    }

    public void afterSetContentView() {
        ButterKnife.bind(this);
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
            finish();

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
    public void goToCommonWebViewActivity(Context context, String url, String title) {
        muranComponent.goToCommonWebViewActivity(context, url, title);
    }

    @Override
    public void loadImgToView(String key, ImageView imageView) {
        muranComponent.loadImgToView(key, imageView);
    }

    protected void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    protected void showActionBar(String title) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.show();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
            return true;
        }
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            this.finish();  //finish当前activity
            overridePendingTransition(R.anim.back_left_in,
                    R.anim.back_right_out);
            return true;
        }
        return false;
    }
    protected FlippingLoadingDialog mLoadingDialog;
    public FlippingLoadingDialog getLoadingDialog(String msg) {
        if (mLoadingDialog == null)
            mLoadingDialog = new FlippingLoadingDialog(this, msg);
        return mLoadingDialog;
    }
}
