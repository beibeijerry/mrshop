package com.muran.mrshop.ui.more.rp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.muran.mrshop.MuranApplication;
import com.muran.mrshop.R;
import com.muran.mrshop.base.BaseActivity;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.ui.more.my.GradeLevelUpActivity;
import com.muran.mrshop.utils.CircleImageView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.swagger.client.ApiException;
import io.swagger.client.api.RpApi;
import io.swagger.client.model.RPOpenRecord;
import io.swagger.client.model.VIPRPInfo;

public class RpDetailActivity extends BaseActivity {

    private String TAG = "RP_DETAIL";
    @BindView(R.id.rpDetaillistView)
    ListView listView;
    List<RPOpenRecord> records = new ArrayList<RPOpenRecord>();
    RPOpenRecordAdapter adapter;
    private Long viprpId;
    private MuranApplication app;

    Button btnAddLevel;
    TextView tvRpLimit, tvRpCount, tvGoneCount;
    @BindView(R.id.img_btn_back)
    LinearLayout btnBack;
    @BindView(R.id.tv_title_header)
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideActionBar();
        setContentView(R.layout.activity_rp_detail);
        app = MuranApplication.app;
        viprpId = getIntent().getLongExtra("vipRpId", 0);

        listView = (ListView) findViewById(R.id.rpDetaillistView);

        btnAddLevel = (Button) findViewById(R.id.btn_add_level);
        tvRpLimit = (TextView) findViewById(R.id.tv_rp_level);
        tvRpCount = (TextView) findViewById(R.id.tv_rp_count);
        tvGoneCount = (TextView) findViewById(R.id.tv_rp_gone_count);
        btnAddLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //去充值
                startActivity(new Intent(RpDetailActivity.this, GradeLevelUpActivity.class));
                overridePendingTransition(R.anim.push_right_in,
                        R.anim.push_left_out);
            }
        });
        adapter = new RPOpenRecordAdapter();
        listView.setAdapter(adapter);
        getRecord();
        getVipRp();
        initTitle();
    }

    //初始化title
    private void initTitle(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.back_left_in,
                        R.anim.back_right_out);
            }
        });
        title.setText("红包详情");
    }


    //获取红包信息
    protected void getVipRp() {
        final RpApi rpApi = app.getApi().rpApi(this);
        if (rpApi == null)
            return;
        app.getApi().execute(this, new Api.ApiMethod<VIPRPInfo>() {
            @Override
            public VIPRPInfo api() throws ApiException {
                Long id = viprpId;
                return rpApi.rpAppViprpViprpidGet(id);
            }
        }, new Api.ApiComplete<VIPRPInfo>() {
            @Override
            public void onComplete(VIPRPInfo result, ApiException ex) {
                if (result != null) {
                    if (result.getMinGrade() <= app.getDataCenter().getCurrentSession().getUserInfo().getRelation().getGrade().getGrade()) {
                        btnAddLevel.setVisibility(View.GONE);
                    } else {
                        btnAddLevel.setVisibility(View.VISIBLE);
                    }
                    if (result.getMinGrade() > 0) {
                        tvRpLimit.setText("特权红包仅限" + result.getMinGrade() + "星以上会员");
                    } else if(result.getMinGrade()<0)
                    {
                        tvRpLimit.setText("全民红包");
                    }else {
                        tvRpLimit.setText("特权红包仅限普通以上会员");
                    }
                    tvRpCount.setText(result.getCount() + "个红包共" + result.getTotalMoney() + "元");
                    if (result.getGoneCount()== result.getCount()) {
                        tvGoneCount.setText("已全部领取");
                    } else {
                        tvGoneCount.setText(result.getGoneCount() + "个红包已被领取，剩余" +(result.getCount()-result.getGoneCount()) + "个");
                    }
                } else {

                }

            }
        }, false, null, "获取成功", "获取失败");
    }

    //获取领取记录
    protected void getRecord() {
        final RpApi rpApi = app.getApi().rpApi(this);
        if (rpApi == null)
            return;
        app.getApi().execute(this, new Api.ApiMethod<List<RPOpenRecord>>() {
            @Override
            public List<RPOpenRecord> api() throws ApiException {
                Long id = viprpId;
                return rpApi.rpAppViprpViprpidGetlistGet(id);
            }
        }, new Api.ApiComplete<List<RPOpenRecord>>() {
            @Override
            public void onComplete(List<RPOpenRecord> result, ApiException ex) {
                if (result != null) {
                    records = result;
                    adapter.notifyDataSetChanged();
                } else {

                }

            }
        });
    }

    private class RPOpenRecordAdapter extends BaseAdapter {

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
            RPOpenRecord rpOpenRecord = records.get(position);
            return rpOpenRecord.getUsId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            RPOpenRecordViewHodler holder = null;
            SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日 HH:mm");

                LayoutInflater inflater = LayoutInflater.from(RpDetailActivity.this);
                convertView = inflater.inflate(R.layout.item_gone_rp, null);
                holder = new RPOpenRecordViewHodler();
                convertView.setTag(holder);
                holder.imgAvater = (CircleImageView) convertView.findViewById(R.id.img_avater);
                holder.tvGoneMoney = (TextView) convertView.findViewById(R.id.tv_gone_money);
                holder.tvGoneTime = (TextView) convertView.findViewById(R.id.tv_gone_time);
                holder.tvUsername = (TextView) convertView.findViewById(R.id.tv_username);
                Log.d(TAG, "getView: "+position);
                RPOpenRecord rpOpenRecord = (RPOpenRecord) getItem(position);
                loadImgToView(rpOpenRecord.getAvatar(), holder.imgAvater);
                holder.tvUsername.setText(rpOpenRecord.getName());
                holder.tvGoneTime.setText(formatter.format(rpOpenRecord.getTime()));
                holder.tvGoneMoney.setText(rpOpenRecord.getAmount() + "元");

            return convertView;
        }


    }

    private class RPOpenRecordViewHodler {
        public CircleImageView imgAvater;
        public TextView tvUsername, tvGoneTime, tvGoneMoney;
    }
}
