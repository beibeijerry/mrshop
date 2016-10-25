package com.muran.mrshop.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.muran.mrshop.MuranApplication;
import com.muran.mrshop.R;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.dialog.FlippingLoadingDialog;
import com.muran.mrshop.ui.more.rp.RpDetailActivity;
import com.muran.mrshop.utils.DataVerify;
import com.muran.mrshop.utils.DownloadImageTask;
import com.muran.mrshop.utils.TimeButton;
import com.muran.mrshop.wxapi.WXEntryActivity;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.umeng.message.IUmengCallback;
import com.umeng.message.UTrack;

import io.swagger.client.ApiException;
import io.swagger.client.api.SysApi;
import io.swagger.client.api.UsApi;
import io.swagger.client.model.GeneralString;
import io.swagger.client.model.SmsResultInfo;
import io.swagger.client.model.UserInfo;
import io.swagger.client.model.WechatLoginInfo;

public class AuthActivity extends Activity {
    private static final String TAG = "Login";
    public Handler handler = new Handler();

    private Button btnAuth, btnLogin;
    private TimeButton btnSendCode;
    private MuranApplication app;
    private EditText editPhone, editCode;
    private boolean isOldUser = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        app = MuranApplication.app;
        btnAuth = (Button) findViewById(R.id.btnAuth);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSendCode = (TimeButton) findViewById(R.id.btnSendCode);

        editCode = (EditText) findViewById(R.id.edit_code);
        editPhone = (EditText) findViewById(R.id.edit_phone);
        app.getDataCenter().readSession();
//        if (app.getDataCenter().getCurrentSession().getId() != null) {
////            getUserInfo();
//            Intent intent1 = new Intent(AuthActivity.this, MainActivity.class);
//            AuthActivity.this.startActivity(intent1);
//        }
        btnSendCode.onCreate(savedInstanceState);
        initView();

    }
    protected FlippingLoadingDialog mLoadingDialog;
    public FlippingLoadingDialog getLoadingDialog(String msg) {
        if (mLoadingDialog == null)
            mLoadingDialog = new FlippingLoadingDialog(this, msg);
        return mLoadingDialog;
    }
    //初始化view
    private void initView() {

        btnAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.mobile = null;
                app.bussId = null;
                app.veryCode = null;
                if (!app.wxapi.isWXAppInstalled()) {
                    //提醒用户没有安装微信
                    String url = "http://weixin.qq.com";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    return;
                }
                SendAuth.Req req = new SendAuth.Req();
                //授权读取用户信息
                req.scope = "snsapi_userinfo";
                //自定义信息
                req.state = "wechat_sdk_demo_test";
                //向微信发送请求
                app.wxapi.sendReq(req);
            }
        });
        btnLogin.setEnabled(false);
        btnSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sendCodeCheckData()) {
                    btnLogin.setEnabled(true);
                    //发送验证码
                    sendCode();
                    btnSendCode.setTextAfter("秒后重新获取").setTextBefore("获取验证码")
                            .setLenght(60 * 1000).ok();
                }
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.mobile = editPhone.getText().toString().trim();
                app.veryCode = editCode.getText().toString().trim();
                if (loginCheckData()) {

                    //登录、注册
                    if (isOldUser) {
                        //登录
                        getLoadingDialog("正在登录...  ").show();
                        login();
                    } else {
                        //弹出对话框
                        createUserDialog();
                    }
                }
            }
        });
    }

    //无权限对话框
    protected void createUserDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("创建？绑定");
        builder.setTitle("提示");
        builder.setPositiveButton("创建新用户", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                getLoadingDialog("正在登录...  ").show();
                login();
            }
        });
        builder.setNegativeButton("绑定微信", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

                if (!app.wxapi.isWXAppInstalled()) {
                    //提醒用户没有安装微信
                    String url = "http://weixin.qq.com";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    return;
                }
                SendAuth.Req req = new SendAuth.Req();
                //授权读取用户信息
                req.scope = "snsapi_userinfo";
                //自定义信息
                req.state = "wechat_sdk_demo_test";
                //向微信发送请求
                app.wxapi.sendReq(req);
            }
        });
        builder.create().show();
    }

    //检测数据
    private boolean sendCodeCheckData() {
        String txt = editPhone.getText().toString();
        if (txt.length() == 0) {
            Toast.makeText(AuthActivity.this, "请输入手机号", Toast.LENGTH_LONG);
            return false;
        } else {
            boolean su = DataVerify.getDataVerify().verifyMobile(txt.trim());
            if (su) {
                return true;
            } else {
                Toast.makeText(AuthActivity.this, "手机号格式不正确", Toast.LENGTH_LONG);
                return false;
            }
        }
    }

    private boolean loginCheckData() {
        String code = editCode.getText().toString().trim();
        if (sendCodeCheckData()) {
            if (code.length() == 0) {
                Toast.makeText(AuthActivity.this, "请输入验证码", Toast.LENGTH_LONG);
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    //发送验证码
    private void sendCode() {
        final SysApi sysApi = app.getApi().sysApi(AuthActivity.this);
        if (sysApi == null)
            return;
        app.getApi().execute(AuthActivity.this, new Api.ApiMethod<SmsResultInfo>() {
            @Override
            public SmsResultInfo api() throws ApiException {
                return sysApi.sendSMS(editPhone.getText().toString().trim(), 0);
            }
        }, new Api.ApiComplete<SmsResultInfo>() {
            @Override
            public void onComplete(SmsResultInfo result, ApiException ex) {
                if (result != null) {
                    isOldUser = result.getIsExist();
                    app.bussId = result.getBussId();
                    Toast.makeText(AuthActivity.this, "短信发送成功", Toast.LENGTH_LONG);
                } else {
                    //失败

                }
            }
        }, true, "提示", "发送成功", "发送失败");
    }

    public void login() {
        final UsApi usApi = app.getApi().usApi(AuthActivity.this);
        if (usApi == null)
            return;
        app.getApi().execute(AuthActivity.this, new Api.ApiMethod<WechatLoginInfo>() {
            @Override
            public WechatLoginInfo api() throws ApiException {
                Log.d(TAG, "api: " + app.mobile + app.bussId);
                return usApi.weChatAppOAuth2("", app.mobile, app.veryCode, app.bussId);
            }
        }, new Api.ApiComplete<WechatLoginInfo>() {
            @Override
            public void onComplete(WechatLoginInfo result, ApiException ex) {
                if (result != null) {
                    //成功获取，获取用户信息
                    Log.d("open2获取成功：", result.getSessionId());
                    app.getDataCenter().getCurrentSession().setId(result.getSessionId());
                    app.isBindMobile = result.getIsBindMobile();
                    getUserInfo();
                } else {
                    app.mobile = null;
                    app.bussId = null;
                    app.veryCode = null;
                }
            }
        });
    }

    //获取用户信息
    private void getUserInfo() {
        final UsApi usApi = app.getApi().usApi(AuthActivity.this);
        if (usApi == null)
            return;
        app.getApi().execute(AuthActivity.this, new Api.ApiMethod<UserInfo>() {
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
                    finish();
                    getLoadingDialog("正在登录...  ").dismiss();
                    Intent intent1 = new Intent(AuthActivity.this, MainActivity.class);
                    AuthActivity.this.startActivity(intent1);
                    editCode.setText("");
                    DownloadImageTask task=new DownloadImageTask();
                    task.execute(result.getPerson().getAvatar());
                } else {
                    //失败
                    app.getDataCenter().resetSession();
                    finish();
                }
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
    protected void onResume() {
        super.onResume();
        if (app.getDataCenter().getCurrentSession().getId() != null) {
//            getUserInfo();
            Intent intent1 = new Intent(AuthActivity.this, MainActivity.class);
            AuthActivity.this.startActivity(intent1);
        }
    }
}
