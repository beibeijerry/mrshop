package com.muran.mrshop.ui.more.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.muran.mrshop.R;
import com.muran.mrshop.base.BaseActivity;
import com.muran.mrshop.data.Api;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.swagger.client.ApiException;
import io.swagger.client.api.ShApi;
import io.swagger.client.model.ShippingAddress;

public class MyAddressActivity extends BaseActivity {
    /** RecyclerView对象 */
    private RecyclerView recyclerView;
    /** 图片资源 */
    private List<ShippingAddress> mDataset=new ArrayList<ShippingAddress>();
    /** 数据适配器 */
    private AddressAdapter mAdapter;

    @BindView(R.id.img_btn_back)
    LinearLayout btnBack;
    @BindView(R.id.tv_title_header)
    TextView title;
    @BindView(R.id.btnRight)
    Button btnRight;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);
        hideActionBar();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        // 设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        getAddress();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        title.setText("管理收货地址");
        btnRight.setText("新增");
        btnRight.setVisibility(View.VISIBLE);
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyAddressActivity.this,EditAddressActivity.class);
                intent.putExtra("operate",false);
                MyAddressActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.push_right_in,
                        R.anim.push_left_out);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        getAddress();
    }

    //获取收货地址list
    protected void getAddress(){
        final ShApi shApi = getApp().getApi().shApi(this);
        if (shApi == null)
            return;
        getApp().getApi().execute(this, new Api.ApiMethod<List<ShippingAddress>>() {
            @Override
            public List<ShippingAddress> api() throws ApiException {
                return shApi.shAppShippingaddressGet();
            }
        }, new Api.ApiComplete<List<ShippingAddress>>() {
            @Override
            public void onComplete(List<ShippingAddress> result, ApiException ex) {
                if (result != null) {
                    mDataset=result;
                    mAdapter = new AddressAdapter(mDataset);
                    recyclerView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();

                } else {

                }

            }
        });
    }

    public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {

        private List<ShippingAddress> mDataset; // 外面传入的数据

        public  class ViewHolder extends RecyclerView.ViewHolder {

            TextView receiver,receiverPhone,address;
            LinearLayout llAddressEdit;
            // TODO Auto-generated method stub
            public ViewHolder(View v) {
                super(v);
            }

        }

        public AddressAdapter(List<ShippingAddress> mDataset) {
            this.mDataset = mDataset;
        }

        /**
         * 获取总的条目数量
         */
        @Override
        public int getItemCount() {
            // TODO Auto-generated method stub
            return mDataset.size();
        }

        /**
         * 创建ViewHolder
         */
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // TODO Auto-generated method stub
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_address, parent, false);
            ViewHolder holder = new ViewHolder(v);
            holder.receiver = (TextView) v.findViewById(R.id.tv_receiver);
            holder.address=(TextView)v.findViewById(R.id.tv_address);
            holder.receiverPhone=(TextView)v.findViewById(R.id.tv_receiver_phone);
            holder.llAddressEdit=(LinearLayout)v.findViewById(R.id.ll_address_edit);
            return holder;
        }

        /**
         * 将数据绑定到ViewHolder上
         */
        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.receiver.setText(mDataset.get(position).getReceiverName());
            holder.address.setText(mDataset.get(position).getAddress()+" "+mDataset.get(position).getDetailAddress());
            holder.receiverPhone.setText(mDataset.get(position).getReceiverPhone());
            holder.llAddressEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(MyAddressActivity.this,EditAddressActivity.class);
                    intent.putExtra("operate",true);
                    intent.putExtra("addressId",mDataset.get(position).getAuId());
                    MyAddressActivity.this.startActivity(intent);
                    overridePendingTransition(R.anim.push_right_in,
                            R.anim.push_left_out);
                }
            });
        }
    }
}
