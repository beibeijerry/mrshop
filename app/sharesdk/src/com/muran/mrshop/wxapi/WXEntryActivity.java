/*
 * 官网地站:http://www.mob.com
 * 技术支持QQ: 4006852216
 * 官方微信:ShareSDK   （如果发布新版本的话，我们将会第一时间通过微信将版本更新内容推送给您。如果使用过程中有任何问题，也可以通过微信与我们取得联系，我们将会在24小时内给予回复）
 *
 * Copyright (c) 2013年 mob.com. All rights reserved.
 */

package com.muran.mrshop.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.muran.mrshop.MuranApplication;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.data.DataCenter;
import com.muran.mrshop.dialog.FlippingLoadingDialog;
import com.muran.mrshop.ui.MainActivity;
import com.muran.mrshop.ui.MobileBindActivity;
import com.muran.mrshop.utils.DownloadImageTask;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.umeng.message.UTrack;

import cn.sharesdk.wechat.utils.WXAppExtendObject;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import io.swagger.client.ApiException;
import io.swagger.client.api.UsApi;
import io.swagger.client.model.GeneralString;
import io.swagger.client.model.UserInfo;
import io.swagger.client.model.WechatLoginInfo;

/**
 * 微信客户端回调activity示例
 */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    private static final String TAG = "WX";
    private MuranApplication app;


    /**
     * 处理微信发出的向第三方应用请求app message
     * <p/>
     * 在微信客户端中的聊天页面有“添加工具”，可以将本应用的图标添加到其中
     * 此后点击图标，下面的代码会被执行。Demo仅仅只是打开自己而已，但你可
     * 做点其他的事情，包括根本不打开任何页面
     */
    public void onGetMessageFromWXReq(WXMediaMessage msg) {
        Intent iLaunchMyself = getPackageManager().getLaunchIntentForPackage(getPackageName());
        startActivity(iLaunchMyself);
    }

    /**
     * 处理微信向第三方应用发起的消息
     * <p/>
     * 此处用来接收从微信发送过来的消息，比方说本demo在wechatpage里面分享
     * 应用时可以不分享应用文件，而分享一段应用的自定义信息。接受方的微信
     * 客户端会通过这个方法，将这个信息发送回接收方手机上的本demo中，当作
     * 回调。
     * <p/>
     * 本Demo只是将信息展示出来，但你可做点其他的事情，而不仅仅只是Toast
     */
    public void onShowMessageFromWXReq(WXMediaMessage msg) {
        if (msg != null && msg.mediaObject != null
                && (msg.mediaObject instanceof WXAppExtendObject)) {
            WXAppExtendObject obj = (WXAppExtendObject) msg.mediaObject;
            Toast.makeText(this, obj.extInfo, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onReq(BaseReq baseReq) {
        Log.d("openId:", baseReq.openId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = MuranApplication.app;
        handleIntent(getIntent());
    }

    @Override
    public void onResp(BaseResp baseResp) {
        Log.d("openId:", baseResp.openId);
        if (baseResp instanceof SendAuth.Resp) {
            SendAuth.Resp newResp = (SendAuth.Resp) baseResp;
            //获取微信传回的code
            String code = newResp.code;
            Log.d("code:", code);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    //等会回调处理
    private void handleIntent(Intent intent) {
        final SendAuth.Resp resp = new SendAuth.Resp(intent.getExtras());
        if (resp.errCode == BaseResp.ErrCode.ERR_OK) {
            getLoadingDialog("正在登录...  ").show();
            //用户同意
            Log.d("code52:", resp.code);
            final UsApi usApi = app.getApi().usApi(WXEntryActivity.this);
            if (usApi == null)
                return;
            app.getApi().execute(WXEntryActivity.this, new Api.ApiMethod<WechatLoginInfo>() {
                @Override
                public WechatLoginInfo api() throws ApiException {
                    Log.d(TAG, "api: " + resp.code + app.mobile + app.veryCode + app.bussId);
                    return usApi.weChatAppOAuth2(resp.code, app.mobile, app.veryCode, app.bussId);
                }
            }, new Api.ApiComplete<WechatLoginInfo>() {
                @Override
                public void onComplete(WechatLoginInfo result, ApiException ex) {
                    if (result != null) {
                        //成功获取，获取用户信息
                        Log.d("open2获取成功：", result.getSessionId());
                        app.getDataCenter().getCurrentSession().setId(result.getSessionId());
                        app.isBindMobile = result.getIsBindMobile();
                        app.getDataCenter().updateSession(app.getDataCenter().getCurrentSession());
                        Log.d(TAG, "onComplete: "+result.getIsBindMobile());
                        if (!result.getIsBindMobile()) {
                            getLoadingDialog("正在登录...  ").dismiss();
                            WXEntryActivity.this.startActivity(new Intent(WXEntryActivity.this, MobileBindActivity.class));
                        } else {
                            getUserInfo();
//                            Intent intent1 = new Intent(WXEntryActivity.this, MainActivity.class);
//                            WXEntryActivity.this.startActivity(intent1);
                        }
                    } else {
                        Toast.makeText(WXEntryActivity.this, "服务器正在维护...", Toast.LENGTH_SHORT);
                        //失败
                        finish();
                    }

                }
            });
        }
    }
    protected FlippingLoadingDialog mLoadingDialog;
    public FlippingLoadingDialog getLoadingDialog(String msg) {
        if (mLoadingDialog == null)
            mLoadingDialog = new FlippingLoadingDialog(this, msg);
        return mLoadingDialog;
    }
    //获取用户信息
    private void getUserInfo() {
        final UsApi usApi = app.getApi().usApi(WXEntryActivity.this);
        if (usApi == null)
            return;
        app.getApi().execute(WXEntryActivity.this, new Api.ApiMethod<UserInfo>() {
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
                        initPush();
                    getLoadingDialog("正在登录...  ").dismiss();
                    DownloadImageTask task=new DownloadImageTask();
                    task.execute(result.getPerson().getAvatar());
                    Intent intent1 = new Intent(WXEntryActivity.this, MainActivity.class);
                    WXEntryActivity.this.startActivity(intent1);
                } else {
                    //失败
                    app.getDataCenter().resetSession();
                }
                finish();
            }
        });
    }

    private void initPush() {
        String mxlg_id = app.getDataCenter().getCurrentSession().getUserInfo().getPerson().getUsId() + "";
        app.mPushAgent.removeAlias(mxlg_id, "MXLG_ID", new UTrack.ICallBack() {
            @Override
            public void onMessage(boolean isSuccess, String message) {
                Log.d(TAG, "remove: " + isSuccess + message);
            }
        });

        app.mPushAgent.addAlias(mxlg_id, "MXLG_ID", new UTrack.ICallBack() {
            @Override
            public void onMessage(boolean isSuccess, String message) {
                Log.d(TAG, "add: " + isSuccess + message);
            }
        });
        app.mPushAgent.addExclusiveAlias(mxlg_id, "MXLG_ID", new UTrack.ICallBack() {
            @Override
            public void onMessage(boolean isSuccess, String message) {
                Log.d(TAG, "exc: " + isSuccess + message);
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return false;
    }
}
