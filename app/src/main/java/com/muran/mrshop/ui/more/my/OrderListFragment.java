package com.muran.mrshop.ui.more.my;

import android.annotation.TargetApi;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.muran.mrshop.R;
import com.muran.mrshop.base.BaseFragment;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.data.OrderStatus;
import com.muran.mrshop.utils.DeviceUtil;
import com.muran.mrshop.utils.TimeOperater;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import io.swagger.client.ApiException;
import io.swagger.client.api.ShApi;
import io.swagger.client.model.SimpleAppGoodsOrder;
import lib.homhomlib.design.SlidingLayout;

public class OrderListFragment extends BaseFragment implements SlidingLayout.SlidingListener, ListView.OnItemClickListener {


    private OrderStatus orderStatus=new OrderStatus();
    private List<SimpleAppGoodsOrder> list = new ArrayList<SimpleAppGoodsOrder>();
    private OrderListAdapter adapter;

    private int maxPullDelta = 0;
    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.RPslidingLayout)
    SlidingLayout slidingLayout;
    TextView pullDownTextView;
    TextView pullUpTextView;

    private enum State {
        NeedLoadMore,//需要加载更多
        NeedRefreshNew,//需要刷新
        LoadingMore,//正在加载更多
        RefreshingNew,//正在刷新数据
        Normal;//没有操作
    }

    private State downState = State.Normal;
    private State upState = State.Normal;

    public OrderListFragment(){}
//    public OrderListFragment(OrderStatus orderStatus) {
//        this.orderStatus = orderStatus;
//    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        maxPullDelta = DeviceUtil.dp2px(getActivity(), 30);

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflateContentView(inflater, R.layout.fragment_order_list);
        slidingLayout.setSlidingListener(this);
        listView.setDivider(null);
        pullDownTextView = (TextView) slidingLayout.findViewById(R.id.pullDownTextView);
        pullUpTextView = (TextView) slidingLayout.findViewById(R.id.pullUpTextView);
        adapter = new OrderListAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        if (list.isEmpty())
            refreshNew();
        return view;
    }


    public void refreshNew() {
        final ShApi shApi = getApp().getApi().shApi(getActivity());
        if (shApi == null)
            return;
        getApp().getApi().execute(getContext(), new Api.ApiMethod<List<SimpleAppGoodsOrder>>() {
            @Override
            public List<SimpleAppGoodsOrder> api() throws ApiException {
                Date time = null;
                if (!list.isEmpty()) {
                    time = list.get(0).getCreateTime();
                }

                return shApi.shAppOrdersGet(orderStatus.getStatus(), 10, time);
            }
        }, new Api.ApiComplete<List<SimpleAppGoodsOrder>>() {
            @Override
            public void onComplete(List<SimpleAppGoodsOrder> result, ApiException ex) {
                if (result != null) {
                    list.addAll(0, result);
                    adapter.notifyDataSetChanged();

                } else {

                }

            }
        });
    }

    // 加载更多
    public void loadMore() {
        final ShApi shApi = getApp().getApi().shApi(getActivity());
        if (shApi == null)
            return;
        getApp().getApi().execute(getContext(), new Api.ApiMethod<List<SimpleAppGoodsOrder>>() {
            @Override
            public List<SimpleAppGoodsOrder> api() throws ApiException {
                Date time = null;
                if (!list.isEmpty()) {
                    time = list.get(list.size() - 1).getCreateTime();
                }
                return shApi.shAppOrdersGet(orderStatus.getStatus(), 10, time);
            }
        }, new Api.ApiComplete<List<SimpleAppGoodsOrder>>() {
            @Override
            public void onComplete(List<SimpleAppGoodsOrder> result, ApiException ex) {
                if (result != null) {
                    list.addAll(result);
                    adapter.notifyDataSetChanged();

                } else {

                }

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onSlidingOffset(View view, float delta) {
        if (downState == State.Normal && delta < 0) {//开始加载更多
            upState = State.NeedLoadMore;
            pullUpTextView.setText("加载中...");

        }
        if (upState == State.Normal && delta > 0) {//开始下拉刷新
            downState = State.NeedRefreshNew;
            pullDownTextView.setText("刷新中...");

        }
    }

    @Override
    public void onSlidingStateChange(View view, int state) {
        if (state == 1) {
            if (upState == State.NeedLoadMore) {
                loadMore();

            }
            if (downState == State.NeedRefreshNew) {
                refreshNew();
            }
        }
    }

    @Override
    public void onSlidingChangePointer(View view, int pointerId) {

    }


    public class OrderListAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            SimpleAppGoodsOrder order = list.get(position);
            return order;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            OrderViewHodler holder = null;
            GradientDrawable mGrad = null;
            String rpTypeTitle = "";
            String rpTitle = "";
            String rpSubTitle = "";
            String rpOpenText = "";
            BigDecimal rpBalance = new BigDecimal(0);
            SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日 HH:mm");
            if (convertView != null) {
                holder = (OrderViewHodler) convertView.getTag();
            } else {
                LayoutInflater inflater = LayoutInflater.from(getActivity());
                convertView = inflater.inflate(R.layout.item_list_rp, null);
                holder = new OrderViewHodler();
                convertView.setTag(holder);
                holder.llRpBg = (LinearLayout) convertView.findViewById(R.id.ll_rp_bg);
                holder.rpTitle = (TextView) convertView.findViewById(R.id.tv_rp_title);
                holder.rpStartTime = (TextView) convertView.findViewById(R.id.tv_start_time);
                holder.rpGradeLevelLimit = (TextView) convertView.findViewById(R.id.tv_grade_level_limit);
                holder.tvDate = (TextView) convertView.findViewById(R.id.tvDate);


                SimpleAppGoodsOrder order = (SimpleAppGoodsOrder) getItem(position);

                holder.rpTitle.setText(order.getGoodsNo());
                TimeOperater toperate = new TimeOperater(getContext());
                holder.tvDate.setText(toperate.formatTimeString(order.getCreateTime().getTime()));
            }

            return convertView;
        }
    }

    private class OrderViewHodler {
        public LinearLayout llRpBg;
        public int status;
        public TextView rpTitle, rpStartTime, rpGradeLevelLimit, tvDate;
    }

}
