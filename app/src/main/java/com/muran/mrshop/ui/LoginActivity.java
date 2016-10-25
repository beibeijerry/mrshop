package com.muran.mrshop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.muran.mrshop.base.BaseActivity;
import com.muran.mrshop.R;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.utils.DataVerify;

import butterknife.BindView;
import io.swagger.client.ApiException;
import io.swagger.client.model.GeneralString;

/**
 * Created by Steven on 5/23/16.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.mobileEditText)
    EditText mobileEditText;
    @BindView(R.id.verifyCodeEditText)
    EditText verifyCodeEditText;
    @BindView(R.id.getVerifyCodeBtn)
    Button getVerifyCodeBtn;
    @BindView(R.id.loginBtn)
    Button loginBtn;
    GeneralString generalString = null;
    Handler handler = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getVerifyCodeBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
        loginBtn.setEnabled(false);
        getSupportActionBar().hide();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                int what = msg.what;
                if (what > 0) {
                    getVerifyCodeBtn.setEnabled(false);
                    getVerifyCodeBtn.setText(what + "秒后重新获取");
                    handler.sendEmptyMessageDelayed(--what, 1000);
                } else {
                    getVerifyCodeBtn.setEnabled(true);
                    getVerifyCodeBtn.setText("获取验证码");
                }
            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getVerifyCodeBtn:
                if (!DataVerify.getDataVerify().verifyMobile(mobileEditText.getText().toString())) {
                    shake(mobileEditText);
                    return;
                }
//                final SysApi sysApi = getApi().sysApiysApi(this);
//                if (sysApi == null) return;
//                getVerifyCodeBtn.setEnabled(false);
//                hideKeyboard();
//                getApi().execute(this, new Api.ApiMethod<GeneralString>() {
//                    @Override
//                    public GeneralString api() throws ApiException {
//                        return sysApi.sendSMS(LoginActivity.this.mobileEditText.getText().toString(), 0);
//                    }
//                }, new Api.ApiComplete<GeneralString>() {
//                    @Override
//                    public void onComplete(GeneralString result, ApiException ex) {
//                        if (result != null) {
//                            generalString = result;
//                            handler.sendEmptyMessage(59);
//                            loginBtn.setEnabled(true);
//                        } else {
//                            getVerifyCodeBtn.setEnabled(true);
//                        }
//                    }
//                }, true, null, "获取成功", "获取失败");
//                break;
//            case R.id.loginBtn:
//                if(verifyCodeEditText.getText()==null){
//                    shake(verifyCodeEditText);
//                    return;
//                }
//                final UsApi usApi = getApi().usApi(this);
//                if (usApi == null) return;
//                getApi().execute(this, new Api.ApiMethod<UserInfo>() {
//
//                    @Override
//                    public UserInfo api() throws ApiException {
//                        return usApi.addUserOrLoginUser(LoginActivity.this.mobileEditText.getText().toString(), LoginActivity.this.verifyCodeEditText.getText().toString(),Long.parseLong(generalString.getValue()), null);
//                    }
//                }, new Api.ApiComplete<UserInfo>() {
//                    @Override
//                    public void onComplete(UserInfo result, ApiException ex) {
//                        if(result !=null){
//                            getApp().getDataCenter().getCurrentSession().setUserInfo(result);
//                            getApp().getDataCenter().persistSession();
//                            LoginActivity.this.finish();
//                            LoginActivity.this.startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                        }
//                    }
//                }, true, "正在登陆", "登陆成功", "登陆失败");
//
//
                break;
        }
    }
}
