package com.muran.mrshop.ui.more.rp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.muran.mrshop.R;
import com.muran.mrshop.base.BaseActivity;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.utils.ShakeListener;
import com.muran.mrshop.utils.ShakeUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import io.swagger.client.ApiException;
import io.swagger.client.api.RpApi;
import io.swagger.client.model.GeneralNumber;
import io.swagger.client.model.RPInfo;
import io.swagger.client.model.RPOpenRecord;

public class RpShakeActivity extends BaseActivity {
    private static final String TAG = "Shake";
    private static final int SENSOR_SHAKE = 10;
    private RPInfo rpInfo;
    @BindView(R.id.tv_shakerp_balance_count)
    TextView balanceCount;
    private Dialog dialog;
    private List<RPOpenRecord> rpOpenRecords = new ArrayList<RPOpenRecord>();
    RPOpenRecordAdapter adapter;
    @BindView(R.id.rp_shake_list)
    ListView rpShakeList;
    ShakeUtil shakeUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rp_shake);
        hideActionBar();
        rpShakeList.setDivider(null);
        getSetting();
        shakeList();
        shakeUtil = new ShakeUtil(this, new ShakeListener() {
            @Override
            public void Handler() {
                Message msg = new Message();
                msg.what = SENSOR_SHAKE;
                handler.sendMessage(msg);
            }
        }).setVibrator(true).setSound(true, ShakeUtil.DEFAULTRES)
                .setAnimation(true, null, null);

    }

    protected void autoUpdate() {
        Timer autoUpdate = new Timer();
        autoUpdate.schedule(new TimerTask() {
            int index = 2;

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        index += 1;
                        if (index >= rpOpenRecords.size()) {
                            index = 0;
                        }
                        rpShakeList.smoothScrollToPosition(index);
                    }
                });
            }
        }, 0, 3000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        shakeUtil.register();
    }


    @Override
    protected void onPause() {
        super.onPause();
        shakeUtil.unregister();
    }

    /**
     * 动作执行
     */
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SENSOR_SHAKE:
                    if (rpInfo.getShakeRPBalanceTimeToday() == 0) {
                        Toast.makeText(RpShakeActivity.this, "今日次数已用完！", Toast.LENGTH_SHORT).show();
                    } else {
                        //调用摇红包
                        shakeRp();
                    }
                    break;
            }
        }
    };

    protected void shakeList() {
        final RpApi rpApi = getApp().getApi().rpApi(this);
        if (rpApi == null)
            return;
        getApp().getApi().execute(this, new Api.ApiMethod<List<RPOpenRecord>>() {
            @Override
            public List<RPOpenRecord> api() throws ApiException {
                Integer count = 6;
                return rpApi.rpAppShakerpListGet(count);
            }
        }, new Api.ApiComplete<List<RPOpenRecord>>() {
            @Override
            public void onComplete(List<RPOpenRecord> result, ApiException ex) {
                if (result != null) {
                    rpOpenRecords = result;
                    adapter = new RPOpenRecordAdapter();
                    rpShakeList.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    autoUpdate();
                } else {

                }

            }
        });
    }

    //摇红包
    protected void shakeRp() {
        final RpApi rpApi = getApp().getApi().rpApi(this);
        if (rpApi == null)
            return;
        getApp().getApi().execute(this, new Api.ApiMethod<GeneralNumber>() {
            @Override
            public GeneralNumber api() throws ApiException {
                return rpApi.rpAppShakerpPost();
            }
        }, new Api.ApiComplete<GeneralNumber>() {
            @Override
            public void onComplete(GeneralNumber result, ApiException ex) {
                if (result != null) {
                    showDialog(result.getValue() + "");
                    getSetting();
                    shakeList();
                } else {
                    dialog(ex.getError().getInfo());
                }

            }
        });
    }
    protected void dialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shakeUtil.setNoShake();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
    /**
     * 弹出摇红包成功对话框
     */
    protected void showDialog(String number) {

            dialog = null;
            dialog = new Dialog(this, R.style.DialogStyleBottom);
            dialog.setContentView(R.layout.dialog_rp_gone);
            TextView textView = (TextView) dialog.findViewById(R.id.tv_gone_rp);
            ImageView imageView = (ImageView) dialog.findViewById(R.id.imageView);
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
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    shakeUtil.setNoShake();
                }
            });
            WindowManager wm = this.getWindowManager();
            WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
            lp.width = wm.getDefaultDisplay().getWidth();
            lp.height = wm.getDefaultDisplay().getHeight();
            dialog.getWindow().setAttributes(lp);

            dialog.show();
    }

    //获取摇一摇设置
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
                    balanceCount.setText("今天还有" + result.getShakeRPBalanceTimeToday() + "次机会");
                } else {

                }

            }
        });
    }

    private class RPOpenRecordAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return rpOpenRecords.size();
        }

        @Override
        public Object getItem(int position) {
            return rpOpenRecords.get(position);
        }

        @Override
        public long getItemId(int position) {
            RPOpenRecord rpOpenRecord = rpOpenRecords.get(position);
            return rpOpenRecord.getUsId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            RPOpenRecordViewHodler holder = null;
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            if (convertView != null) {
                holder = (RPOpenRecordViewHodler) convertView.getTag();
            } else {
                LayoutInflater inflater = LayoutInflater.from(RpShakeActivity.this);
                convertView = inflater.inflate(R.layout.item_rp_shake, null);
                holder = new RPOpenRecordViewHodler();
                convertView.setTag(holder);
                holder.tvGrade = (TextView) convertView.findViewById(R.id.tv_shake_user_grade);
                holder.tvGoneMoney = (TextView) convertView.findViewById(R.id.tv_shake_number);
                holder.tvGoneTime = (TextView) convertView.findViewById(R.id.tv_shake_time);
                holder.tvUsername = (TextView) convertView.findViewById(R.id.tv_shake_user);
                RPOpenRecord rpOpenRecord = (RPOpenRecord) getItem(position);
                if (rpOpenRecord.getGrade() < 0) {
                    holder.tvGrade.setText("游客");
                } else if (rpOpenRecord.getGrade() == 0) {
                    holder.tvGrade.setText("普通会员");
                } else {
                    holder.tvGrade.setText(rpOpenRecord.getGrade() + "星会员");
                }
                holder.tvUsername.setText(rpOpenRecord.getName());
                holder.tvGoneTime.setText(formatter.format(rpOpenRecord.getTime()));
                holder.tvGoneMoney.setText(rpOpenRecord.getAmount() + "元");
            }

            return convertView;
        }


    }

    private class RPOpenRecordViewHodler {

        public TextView tvUsername, tvGoneTime, tvGoneMoney, tvGrade;
    }
}
