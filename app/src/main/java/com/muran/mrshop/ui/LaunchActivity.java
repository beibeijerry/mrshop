package com.muran.mrshop.ui;

import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iflytek.autoupdate.IFlytekUpdate;
import com.iflytek.autoupdate.IFlytekUpdateListener;
import com.iflytek.autoupdate.UpdateConstants;
import com.iflytek.autoupdate.UpdateErrorCode;
import com.iflytek.autoupdate.UpdateInfo;
import com.iflytek.autoupdate.UpdateType;
import com.iflytek.autoupdate.e.c;
import com.iflytek.autoupdate.e.f;
import com.muran.mrshop.base.BaseActivity;
import com.muran.mrshop.MuranApplication;
import com.muran.mrshop.R;
import com.muran.mrshop.data.Api;
import com.umeng.message.UTrack;

import io.swagger.client.ApiException;
import io.swagger.client.api.UsApi;
import io.swagger.client.model.UserInfo;

/**
 * Created by Steven on 5/23/16.
 */
public class LaunchActivity extends Activity {
    private static final String TAG = "Laugh";
    MuranApplication app;
    private Toast mToast;
    private IFlytekUpdate updManager;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lauch);
        mContext = this.getApplicationContext();
        app=MuranApplication.app;
        mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        initUpdate();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (MuranApplication.app.getDataCenter().getCurrentSession().getId()== null) {
                    LaunchActivity.this.finish();
                    LaunchActivity.this.startActivity(new Intent(LaunchActivity.this, AuthActivity.class));
                    LaunchActivity.this.overridePendingTransition(R.anim.push_right_in,
                            R.anim.push_left_out);
                } else {
                    getUser();
                }
            }
        }, 3000);
    }
    //获取用户信息
    private void getUser() {
        final UsApi usApi = app.getApi().usApi(this);
        if (usApi == null)
            return;
        app.getApi().execute(this, new Api.ApiMethod<UserInfo>() {
            @Override
            public UserInfo api() throws ApiException {
                return usApi.getUserOwnInfo();
            }
        }, new Api.ApiComplete<UserInfo>() {
            @Override
            public void onComplete(UserInfo result, ApiException ex) {
                if (result != null) {
                    app.getDataCenter().getCurrentSession().setUserInfo(result);
                    app.getDataCenter().updateSession(app.getDataCenter().getCurrentSession());
                    //开启推送并设置注册的回调处理
                    if (app.sp.getBoolean("Exist_token", false))
//                        initPushAlias();
                    LaunchActivity.this.finish();
                    LaunchActivity.this.startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                    LaunchActivity.this.overridePendingTransition(R.anim.push_right_in,
                            R.anim.push_left_out);
                } else {
                    //失败
                    app.getDataCenter().resetSession();
                }
            }
        });
    }

    private void initPushAlias() {
        String mxlg_id = app.getDataCenter().getCurrentSession().getUserInfo().getPerson().getUsId() + "";
        app.mPushAgent.removeAlias(mxlg_id, "MXLG_ID", new UTrack.ICallBack() {
            @Override
            public void onMessage(boolean isSuccess, String message) {

            }
        });

        app.mPushAgent.addAlias(mxlg_id, "MXLG_ID", new UTrack.ICallBack() {
            @Override
            public void onMessage(boolean isSuccess, String message) {

            }
        });
        app.mPushAgent.addExclusiveAlias(mxlg_id, "MXLG_ID", new UTrack.ICallBack() {
            @Override
            public void onMessage(boolean isSuccess, String message) {
            }
        });
    }


    //初始化自动更新
    private void initUpdate() {
        //初始化自动更新对象
        updManager  = IFlytekUpdate.getInstance(mContext);
        //开启调试模式,默认不开启
        updManager.setDebugMode(true);
        //开启wifi环境下检测更新,仅对自动更新有效,强制更新失效
        updManager.setParameter(UpdateConstants.EXTRA_WIFIONLY, "true");
        //设置通知栏使用应用icon,详情请见示例
        updManager.setParameter(UpdateConstants.EXTRA_NOTI_ICON, "true");
        //设置更新提示类型,默认为通知栏提示
        updManager.setParameter(UpdateConstants.EXTRA_STYLE, UpdateConstants.UPDATE_UI_NITIFICATION);
        // 启动自动更新
        updManager.autoUpdate(LaunchActivity.this, updateListener);
    }

    //自动更新回调方法,详情参考demo
    private IFlytekUpdateListener updateListener = new IFlytekUpdateListener() {
        @Override
        public void onResult(int errorcode, UpdateInfo result) {
            if (errorcode == UpdateErrorCode.OK && result != null) {
                Log.d(TAG, "onResult: "+result);
                if (result.getUpdateType() == UpdateType.NoNeed) {

                    return;
                }
                updManager.showUpdateInfo(LaunchActivity.this, result);
            }
//            else {
//                showTip("请求更新失败！\n更新错误码：" + errorcode);
//            }
        }
    };


    private void showTip(final String str) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mToast.setText(str);
                mToast.show();
            }
        });
    }
}
