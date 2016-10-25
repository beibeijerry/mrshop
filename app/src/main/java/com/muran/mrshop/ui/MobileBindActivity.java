package com.muran.mrshop.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.muran.mrshop.MuranApplication;
import com.muran.mrshop.R;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.utils.DataVerify;
import com.muran.mrshop.utils.TimeButton;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.umeng.message.UTrack;

import io.swagger.client.ApiException;
import io.swagger.client.api.SysApi;
import io.swagger.client.api.UsApi;
import io.swagger.client.model.GeneralString;
import io.swagger.client.model.SmsResultInfo;
import io.swagger.client.model.UserInfo;

public class MobileBindActivity extends Activity {
    private static final String TAG = "Mobile";
    public Handler handler = new Handler();

    private Button  btnLogin;
    private TimeButton btnSendCode;
    private MuranApplication app;
    private EditText editPhone, editCode;
    private boolean isOldUser=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app=MuranApplication.app;

        setContentView(R.layout.activity_mobile_bind);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSendCode = (TimeButton) findViewById(R.id.btnSendCode);

        editCode = (EditText) findViewById(R.id.edit_code);
        editPhone = (EditText) findViewById(R.id.edit_phone);
        app.getDataCenter().readSession();
        btnSendCode.onCreate(savedInstanceState);
        initView();
    }
    //初始化view
    private void initView() {
        btnSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkData()) {
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
                app.mobile=editPhone.getText().toString().trim();
                app.veryCode=editCode.getText().toString().trim();
                if (checkData()) {
                    //绑定
                    bindMobile();
                }
            }
        });
    }
    //检测数据
    private boolean checkData() {
        String txt = editPhone.getText().toString();
        if (txt.length() == 0) {
            Toast.makeText(MobileBindActivity.this, "请输入手机号", Toast.LENGTH_LONG);
            return false;
        } else {
            boolean su = DataVerify.getDataVerify().verifyMobile(txt.trim());
            if (su) {
                return true;
            } else {
                Toast.makeText(MobileBindActivity.this, "手机号格式不正确", Toast.LENGTH_LONG);
                return false;
            }
        }
    }
    //发送验证码
    private void sendCode() {
        final SysApi sysApi = app.getApi().sysApi(MobileBindActivity.this);
        if (sysApi == null)
            return;
        app.getApi().execute(MobileBindActivity.this, new Api.ApiMethod<SmsResultInfo>() {
            @Override
            public SmsResultInfo api() throws ApiException {
                return sysApi.sendSMS(editPhone.getText().toString().trim(), 1);
            }
        }, new Api.ApiComplete<SmsResultInfo>() {
            @Override
            public void onComplete(SmsResultInfo result, ApiException ex) {
                if (result != null) {
                    isOldUser=result.getIsExist();
                    app.bussId=result.getBussId();
                    Log.d(TAG, "onComplete: "+app.bussId);
                    Toast.makeText(MobileBindActivity.this, "短信发送成功", Toast.LENGTH_LONG);
                } else {
                    //失败

                }
            }
        }, true, "提示", "发送成功", "发送失败");
    }


    private void bindMobile(){
        final UsApi usApi = app.getApi().usApi(MobileBindActivity.this);
        if (usApi == null)
            return;
        app.getApi().execute(MobileBindActivity.this, new Api.ApiMethod<GeneralString>() {
            @Override
            public GeneralString api() throws ApiException {
                return usApi.bindMobile(editPhone.getText().toString().toString(),editCode.getText().toString().trim(),app.bussId);
            }
        }, new Api.ApiComplete<GeneralString>() {
            @Override
            public void onComplete(GeneralString result, ApiException ex) {
                if (result != null) {
                    finish();
                }else {
                    app.mobile=null;
                    app.bussId=null;
                    app.veryCode=null;
                }
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            app.getDataCenter().resetSession();
            int currentVersion = android.os.Build.VERSION.SDK_INT;
            if (currentVersion > android.os.Build.VERSION_CODES.ECLAIR_MR1) {
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(startMain);
                System.exit(0);
            } else {// android2.1
                ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                am.restartPackage(getPackageName());
            }
        }
        return false;
    }

}
