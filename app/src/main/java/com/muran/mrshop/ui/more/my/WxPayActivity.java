package com.muran.mrshop.ui.more.my;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.muran.mrshop.R;
import com.muran.mrshop.base.BaseActivity;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.utils.ShopToast;
import com.tencent.mm.sdk.modelpay.PayReq;

import java.math.BigDecimal;

import butterknife.BindView;
import io.swagger.client.ApiException;
import io.swagger.client.api.WpApi;
import io.swagger.client.model.WxAppPay;

public class WxPayActivity extends BaseActivity {

    @BindView(R.id.btn_pay_save)
    Button btnPaySave;
    @BindView(R.id.btn_pay_cancel)
    Button btnCancell;
    @BindView(R.id.img_btn_back)
    LinearLayout btnBack;
    @BindView(R.id.tv_title_header)
    TextView title;
    @BindView(R.id.edit_pay_input)
    EditText payMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx_pay);
        hideActionBar();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String money = getIntent().getStringExtra("money");
        if (money != null)
            payMoney.setText(money);
        title.setText("微信充值");
        btnPaySave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigDecimal money = BigDecimal.valueOf(Double.parseDouble(payMoney.getText().toString().trim()));
                preWeiXin(money);
            }
        });
        btnCancell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.back_left_in,
                        R.anim.back_right_out);
            }
        });
    }


    //微信支付
    protected void preWeiXin(final BigDecimal money) {
        final WpApi wpApi = getApp().getApi().wpApi(this);
        if (wpApi == null)
            return;
        getApp().getApi().execute(this, new Api.ApiMethod<WxAppPay>() {
            @Override
            public WxAppPay api() throws ApiException {

                return wpApi.preWechatAppRecharge(money);
            }
        }, new Api.ApiComplete<WxAppPay>() {
            @Override
            public void onComplete(WxAppPay result, ApiException ex) {
                if (result != null) {
                    PayReq req = new PayReq();
                    req.appId = result.getAppId();
                    req.partnerId = result.getPartnerId();
                    req.prepayId = result.getPrepayId();
                    req.nonceStr = result.getNonceStr();
                    req.timeStamp = result.getTimestamp() + "";
                    req.packageValue = result.getPackage();
                    req.sign = result.getSign();
                    req.extData = "app data"; // optional
//                    Toast.makeText(WxPayActivity.this, "正常调起支付", Toast.LENGTH_SHORT).show();
                    // 在支付之前，如果应用没有注册到微信，应该先调用IWXMsg.registerApp将应用注册到微信
                    getApp().wxapi.sendReq(req);

                } else {
                    //失败
                    ShopToast.show(WxPayActivity.this, ex.getError().getInfo());
                }
            }
        });
    }


}
