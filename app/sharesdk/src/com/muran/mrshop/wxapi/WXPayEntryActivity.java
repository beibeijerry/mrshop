package com.muran.mrshop.wxapi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import com.muran.mrshop.MuranApplication;
import com.muran.mrshop.R;
import com.muran.mrshop.data.Api;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import io.swagger.client.ApiException;
import io.swagger.client.api.UsApi;
import io.swagger.client.model.UserInfo;

/**
 * Created by Administrator on 2016/9/9.
 */
public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";

    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_result);

        api = WXAPIFactory.createWXAPI(this, MuranApplication.WEIXIN_APP_ID);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            this.finish();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.pay_result_tip);
            if (resp.errCode == 0) {
                //成功
                builder.setMessage("支付成功");
                getUser();
            } else if (resp.errCode == -1) {
                //错误
                builder.setMessage(resp.errStr);
            } else {
                //用户取消
                builder.setMessage(resp.errStr);
            }
            builder.show();
        }
    }
    //获取用户信息
    private void getUser() {
        final UsApi usApi = MuranApplication.app.getApi().usApi(this);
        if (usApi == null)
            return;
        MuranApplication.app.getApi().execute(this, new Api.ApiMethod<UserInfo>() {
            @Override
            public UserInfo api() throws ApiException {
                return usApi.getUserOwnInfo();
            }
        }, new Api.ApiComplete<UserInfo>() {
            @Override
            public void onComplete(UserInfo result, ApiException ex) {
                if (result != null) {
                    MuranApplication.app.getDataCenter().getCurrentSession().setUserInfo(result);
                    MuranApplication.app.getDataCenter().updateSession(MuranApplication.app.getDataCenter().getCurrentSession());
                }
            }
        });
    }
}