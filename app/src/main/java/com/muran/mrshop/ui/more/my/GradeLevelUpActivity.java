package com.muran.mrshop.ui.more.my;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.muran.mrshop.R;
import com.muran.mrshop.base.BaseActivity;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.ui.LaunchActivity;
import com.muran.mrshop.ui.MainActivity;
import com.muran.mrshop.utils.CircleImageView;
import com.muran.mrshop.utils.DownloadImageTask;
import com.muran.mrshop.utils.EditUtil;
import com.muran.mrshop.utils.ShopToast;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.swagger.client.ApiException;
import io.swagger.client.api.AcApi;
import io.swagger.client.api.RpApi;
import io.swagger.client.api.UsApi;
import io.swagger.client.api.WpApi;
import io.swagger.client.model.GeneralString;
import io.swagger.client.model.GradeInfo;
import io.swagger.client.model.RPOpenRecord;
import io.swagger.client.model.UserAccountInfo;
import io.swagger.client.model.UserInfo;
import io.swagger.client.model.WxAppPay;
import io.swagger.client.model.WxPay;

//会员升级
public class GradeLevelUpActivity extends BaseActivity implements ListView.OnItemClickListener {

    private static final String TAG = "UP";
    @BindView(R.id.lv_grade)
    ListView listView;

    @BindView(R.id.tv_grade_cur)
    TextView curGrade;
    @BindView(R.id.tv_grade_cur_tip)
    TextView gradeTip;
    @BindView(R.id.btn_grade_pay)
    Button btnPay;

    @BindView(R.id.img_btn_back)
    LinearLayout btnBack;
    @BindView(R.id.tv_title_header)
    TextView title;
    @BindView(R.id.img_level_up)
    ImageView imglevelUp;

    List<GradeInfo> records = new ArrayList<GradeInfo>();
    GradeInfoAdapter adapter;

    UserAccountInfo userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_level_up);
        hideActionBar();
        getAcInfo();
        listView.setOnItemClickListener(this);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPayMethod();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.back_left_in,
                        R.anim.back_right_out);
            }
        });
        title.setText("会员升级");
    }

    //获取个人账户信息
    protected void getAcInfo() {
        final AcApi acApi = getApp().getApi().acApi(this);
        if (acApi == null)
            return;
        getApp().getApi().execute(this, new Api.ApiMethod<UserAccountInfo>() {
            @Override
            public UserAccountInfo api() throws ApiException {
                return acApi.acAppInfoGet();
            }
        }, new Api.ApiComplete<UserAccountInfo>() {
            @Override
            public void onComplete(UserAccountInfo result, ApiException ex) {
                if (result != null) {
                    userInfo = result;
                    getCurrentSessioin().setUserAccountInfo(result);
                    if (userInfo.getGrade() < 0) {
                        curGrade.setText("您是游客");
                    } else if (userInfo.getGrade() == 0) {
                        curGrade.setText("您是普通会员");
                    } else {
                        curGrade.setText("您是" + userInfo.getGrade() + "星会员");
                    }
                    if (userInfo.getGrade() >= 5) {
                        gradeTip.setText("");
                        imglevelUp.setImageDrawable(getResources().getDrawable(R.drawable.finish));
                    }
                    getRecord();
                } else {
                    //失败
                    Log.d("open22获取失败:", ex.getMessage());
                }
            }
        });
    }

    //获取用户信息
    private void getUser() {
        final UsApi usApi = getApp().getApi().usApi(this);
        if (usApi == null)
            return;
        getApp().getApi().execute(this, new Api.ApiMethod<UserInfo>() {
            @Override
            public UserInfo api() throws ApiException {
                return usApi.getUserOwnInfo();
            }
        }, new Api.ApiComplete<UserInfo>() {
            @Override
            public void onComplete(UserInfo result, ApiException ex) {
                if (result != null) {
                    DownloadImageTask task=new DownloadImageTask();
                    task.execute(result.getPerson().getAvatar());
                    getApp().getDataCenter().getCurrentSession().setUserInfo(result);
                    getApp().getDataCenter().updateSession(getDataCenter().getCurrentSession());
                }
            }
        });
    }

    //获取会员级别记录
    protected void getRecord() {
        final UsApi usApi = getApp().getApi().usApi(this);
        if (usApi == null)
            return;
        getApp().getApi().execute(this, new Api.ApiMethod<List<GradeInfo>>() {
            @Override
            public List<GradeInfo> api() throws ApiException {
                return usApi.getGradeList();
            }
        }, new Api.ApiComplete<List<GradeInfo>>() {
            @Override
            public void onComplete(List<GradeInfo> result, ApiException ex) {
                if (result != null) {
                    int curGrade = getApp().getDataCenter().getCurrentSession().getUserInfo().getRelation().getGrade().getGrade();
                    for (GradeInfo item : result) {
                        if (item.getGrade() > curGrade && item.getGrade() != 0) {
                            if (item.getMoney().compareTo(userInfo.getPaySum()) > 0) {
                                item.setMoney(item.getMoney().subtract(userInfo.getPaySum()));
                            }
                            records.add(item);
                        }
                    }
                    adapter = new GradeInfoAdapter();
                    listView.setAdapter(adapter);
                } else {

                }

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        showPayMethod();
    }

    private Dialog payMethodDialog;

    //充值类型对话框
    private void showPayMethod() {
        if (payMethodDialog == null) {
            payMethodDialog = new Dialog(this, R.style.DialogStyleBottom);
            View viewSex = getLayoutInflater().inflate(R.layout.dialog_pay_method, null);
            payMethodDialog.setContentView(viewSex, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            Button btnCard = (Button) payMethodDialog.findViewById(R.id.btn_card_pay);
            Button btnWeixin = (Button) payMethodDialog.findViewById(R.id.btn_weixin_pay);
            btnWeixin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    payMethodDialog.cancel();
                    showPayDialog(payMethod.weixin);
                }
            });
            btnCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPayDialog(payMethod.card);
                    payMethodDialog.cancel();
                }
            });
            payMethodDialog.setCancelable(true);
            payMethodDialog.setCanceledOnTouchOutside(true);
        }
        payMethodDialog.getWindow().setGravity(Gravity.BOTTOM);
        payMethodDialog.getWindow().setWindowAnimations(R.style.dialog_bottom_inout);
        WindowManager wm = this.getWindowManager();
        WindowManager.LayoutParams lp = payMethodDialog.getWindow().getAttributes();

        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//        payMethodDialog.getWindow().setAttributes(lp);
        payMethodDialog.onWindowAttributesChanged(lp);
        payMethodDialog.show();
    }

    //支付方式
    public enum payMethod {
        card,
        weixin
    }

    private Dialog payDialog;

    //充值对话框
    private void showPayDialog(final payMethod method) {
        payDialog = null;
        payDialog = new Dialog(this, R.style.DialogStyleBottom);
        payDialog.setContentView(R.layout.dialog_pay);
        Button save = (Button) payDialog.findViewById(R.id.btn_pay_save);
        final Button cancel = (Button) payDialog.findViewById(R.id.btn_pay_cancel);
        final TextView textView = (TextView) payDialog.findViewById(R.id.tv_pay_title);
        final EditText editText = (EditText) payDialog.findViewById(R.id.edit_pay_input);
        switch (method) {
            case card:
                textView.setText("充值卡号");
                editText.setHint("请输入充值卡号");
                editText.setInputType(EditorInfo.TYPE_CLASS_TEXT);
//                EditUtil.setEnglishAndNumber(editText,getResources().getResourceName(R.string.login_only_can_input));
                break;
            case weixin:
                textView.setText("充值金额");
                editText.setHint("请输入充值金额");
                editText.setInputType(EditorInfo.TYPE_CLASS_PHONE);
                EditUtil.setPricePoint(editText);
                break;
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (method) {
                    case card:
                        preCard(editText.getText().toString().trim());
                        break;
                    case weixin:
                        BigDecimal money = BigDecimal.valueOf(Double.parseDouble(editText.getText().toString().trim()));
                        preWeiXin(money);
                        break;
                }

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payDialog.dismiss();
            }
        });
        payDialog.setCancelable(true);
        payDialog.setCanceledOnTouchOutside(true);
        payDialog.getWindow().setGravity(Gravity.BOTTOM);
        payDialog.getWindow().setWindowAnimations(R.style.dialog_bottom_inout);


        WindowManager wm = this.getWindowManager();
        WindowManager.LayoutParams lp = payMethodDialog.getWindow().getAttributes();
        lp.width = wm.getDefaultDisplay().getWidth();
        lp.height = wm.getDefaultDisplay().getHeight();
        payDialog.getWindow().setAttributes(lp);
        payDialog.show();
    }

    //充值卡充值
    protected void preCard(final String cardNo) {
        final AcApi acApi = getApp().getApi().acApi(this);
        if (acApi == null)
            return;
        getApp().getApi().execute(this, new Api.ApiMethod<GeneralString>() {
            @Override
            public GeneralString api() throws ApiException {

                return acApi.acAppPrecardPut(cardNo);
            }
        }, new Api.ApiComplete<GeneralString>() {
            @Override
            public void onComplete(GeneralString result, ApiException ex) {
                if (result != null) {
                    payDialog.dismiss();
                    records = new ArrayList<GradeInfo>();
                    getAcInfo();
                    getUser();
                } else {
                    //失败
                    ShopToast.show(GradeLevelUpActivity.this, ex.getError().getInfo());
                }
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
                    payDialog.dismiss();
                    PayReq req = new PayReq();
                    req.appId = result.getAppId();
                    req.partnerId = result.getPartnerId();
                    req.prepayId = result.getPrepayId();
                    req.nonceStr = result.getNonceStr();
                    req.timeStamp = result.getTimestamp() + "";
                    req.packageValue = result.getPackage();
                    req.sign = result.getSign();
                    req.extData = "app data"; // optional
//                    Toast.makeText(GradeLevelUpActivity.this, "正常调起支付", Toast.LENGTH_SHORT).show();
                    // 在支付之前，如果应用没有注册到微信，应该先调用IWXMsg.registerApp将应用注册到微信
                    getApp().wxapi.sendReq(req);

                } else {
                    //失败
                    ShopToast.show(GradeLevelUpActivity.this, ex.getError().getInfo());
                }
            }
        });
    }


    private class GradeInfoAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return records.size();
        }

        @Override
        public Object getItem(int position) {
            return records.get(position);
        }

        @Override
        public long getItemId(int position) {
            GradeInfo rpOpenRecord = records.get(position);
            return rpOpenRecord.getGrade();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            GradeInfoViewHodler holder = null;
            SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日 HH:mm");
            if (convertView != null) {
                holder = (GradeInfoViewHodler) convertView.getTag();
            } else {
                LayoutInflater inflater = LayoutInflater.from(GradeLevelUpActivity.this);
                convertView = inflater.inflate(R.layout.item_list_grade, null);
                holder = new GradeInfoViewHodler();
                convertView.setTag(holder);

                holder.tvGradename = (TextView) convertView.findViewById(R.id.tv_grade_name);
                holder.tvGradeMoney = (TextView) convertView.findViewById(R.id.tv_grade_money);
                GradeInfo rpOpenRecord = (GradeInfo) getItem(position);
                holder.tvGradename.setText(rpOpenRecord.getName());
                holder.tvGradeMoney.setText("充值" + rpOpenRecord.getMoney() + "元");
            }

            return convertView;
        }


    }

    private class GradeInfoViewHodler {
        public TextView tvGradename, tvGradeMoney;
    }
}
