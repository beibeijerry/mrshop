package com.muran.mrshop.ui.more.my;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.muran.mrshop.R;
import com.muran.mrshop.base.BaseActivity;
import com.muran.mrshop.data.OrderStatus;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MyOrderActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.vPager)
    ViewPager viewPager;
    @BindView(R.id.indicator)
    TabPageIndicator indicator;
    private List<OrderStatus> orderStatuses = new ArrayList<OrderStatus>();
    StatusPagerAdapter adapter = null;
    @BindView(R.id.img_btn_back)
    LinearLayout btnBack;
    @BindView(R.id.tv_title_header)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        hideActionBar();
        orderStatuses = getDataCenter().getOrderStatus();
        adapter = new StatusPagerAdapter(getSupportFragmentManager(), orderStatuses);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        title.setText("我的订单");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    public class StatusPagerAdapter extends FragmentPagerAdapter {

        private List<OrderStatus> statuses;

        public StatusPagerAdapter(FragmentManager fm, List<OrderStatus> statuses) {
            super(fm);
            this.statuses = statuses;
        }

        @Override
        public Fragment getItem(int arg0) {
            return null;
//            return new OrderListFragment(statuses.get(arg0));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return statuses.get(position).getStatusDes();
        }

        @Override
        public int getCount() {
            return statuses.size();
        }

    }
}
