package com.muran.mrshop.ui.more.rp;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.muran.mrshop.R;
import com.muran.mrshop.base.BaseActivity;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.utils.RunPostlistener;
import com.muran.mrshop.utils.TimeCount;

import butterknife.BindView;
import io.swagger.client.ApiException;
import io.swagger.client.api.RpApi;
import io.swagger.client.model.GeneralNumber;
import io.swagger.client.model.RPInfo;

public class RpCheckInActivity extends BaseActivity {
    public static final String TAG = "Checkin";
    @BindView(R.id.img_btn_ad)
    ImageView btnAd;
    @BindView(R.id.btn_check_in)
    Button btnCheckIn;
    private RPInfo rpInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rp_check_in);
        getSetting();
        hideActionBar();
    }

    //获取签到设置
    protected void getSetting() {
        final RpApi rpApi = getApp().getApi().rpApi(this);
        if (rpApi == null)
            return;
        getApp().getApi().execute(this, new Api.ApiMethod<RPInfo>() {
            @Override
            public RPInfo api() throws ApiException {
                return rpApi.rpAppInfoGet();
            }
        }, new Api.ApiComplete<RPInfo>() {
            @Override
            public void onComplete(RPInfo result, ApiException ex) {
                if (result != null) {
                    rpInfo = result;
                    loadImgToView(getApp().IMG_DOMAIN+result.getCheckInAdLink(),btnAd);
                    if (!result.getCheckIn())
                    timeCount(result.getCheckInAdReadTime());
                    else
                        btnCheckIn.setText("今日已签到");
                } else {

                }

            }
        });
    }

    int i=0;
    Handler mHandler=new Handler();

    protected void timeCount(int time){

        i=time;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i > 0)//整个倒计时执行的循环
                {
                     i--;
                    mHandler.post(new Runnable() //通过它在UI主线程中修改显示的剩余时间
                    {
                        public void run() {
                            btnCheckIn.setText(i+"秒后领取");//显示剩余时间
                        }
                    });
                    try {
                        Thread.sleep(1000);//线程休眠一秒钟     这个就是倒计时的间隔时间
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //倒计时结束执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (rpInfo.getCheckIn()){
                            btnCheckIn.setText("今日已签到");
                        }else {
                            btnCheckIn.setText("点击签到");
                        }
                        btnCheckIn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                checkIn();
                            }
                        });
                    }
                });
            }
        }).start();
    }

    //签到
    protected void checkIn(){
        final RpApi rpApi = getApp().getApi().rpApi(this);
        if (rpApi == null)
            return;
        getApp().getApi().execute(this, new Api.ApiMethod<GeneralNumber>() {
            @Override
            public GeneralNumber  api() throws ApiException {
                return rpApi.rpAppCheckinPost();
            }
        }, new Api.ApiComplete<GeneralNumber>() {
            @Override
            public void onComplete(GeneralNumber  result, ApiException ex) {
                if (result != null) {
                    showDialog(result.getValue()+"");
                    getSetting();
                } else {
                    Log.d("提示:", ex.getError().getInfo());
                    dialog( ex.getError().getInfo());
                }

            }
        });
    }

    protected void dialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(RpCheckInActivity.this);
        builder.setMessage(message);
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
    Dialog dialog;
    /**
     * 弹出摇红包成功对话框
     */
    protected void showDialog(String number) {

        if (dialog == null) {
            dialog = new Dialog(this, R.style.DialogStyleBottom);
            dialog.setContentView(R.layout.dialog_rp_gone);
            TextView textView = (TextView) dialog.findViewById(R.id.tv_gone_rp);
            ImageView imageView=(ImageView)dialog.findViewById(R.id.imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            textView.setText(number + "元");
            dialog.setCanceledOnTouchOutside(true);
            dialog.getWindow().setGravity(Gravity.CENTER_VERTICAL);
            dialog.getWindow().setWindowAnimations(R.style.dialog_bottom_inout);

            WindowManager wm = this.getWindowManager();
            WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
            lp.width = wm.getDefaultDisplay().getWidth();
            lp.height = wm.getDefaultDisplay().getHeight();
            dialog.getWindow().setAttributes(lp);
        }
        dialog.show();
    }
}
