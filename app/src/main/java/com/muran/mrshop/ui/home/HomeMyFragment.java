package com.muran.mrshop.ui.home;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.muran.mrshop.R;
import com.muran.mrshop.base.BaseFragment;
import com.muran.mrshop.base.BaseLazyFragment;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.ui.LaunchActivity;
import com.muran.mrshop.ui.MainActivity;
import com.muran.mrshop.ui.more.my.GradeLevelUpActivity;
import com.muran.mrshop.ui.more.my.MyAddressActivity;
import com.muran.mrshop.ui.more.my.MyOrderActivity;
import com.muran.mrshop.utils.BitmapUtil;
import com.muran.mrshop.utils.CircleImageView;
import com.muran.mrshop.utils.GlideImageLoader;
import com.muran.mrshop.utils.WebUrlUtil;

import net.qiujuer.genius.blur.StackBlur;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import io.swagger.client.ApiException;
import io.swagger.client.api.AcApi;
import io.swagger.client.model.UserAccountInfo;

public class HomeMyFragment extends BaseLazyFragment implements View.OnClickListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.img_avater)
    CircleImageView imgAvater;

    @BindView(R.id.ll_my_avater)
    LinearLayout llMyavater;

    @BindView(R.id.ll_my_center)
    LinearLayout llMyCenter;

    TextView tvUserLevel, tvBanlance,tvNickname;
    RatingBar ratingBar;
    Button btnRpRank;
//    UserAccountInfo userAccountInfo;

    LinearLayout myOrder, myFriends, myKeFu, myAddress, myLevelUp, myGoodsOrder,refundOrder;

    @BindView(R.id.btn_login_out)
    Button loginOut;

    private String sessionId = "";



    public HomeMyFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getUserInfo()!=null&&getUserInfo().getPerson()!=null)
            mDatabase = getDataCenter().getUserDatabase();
        else
        {
            getActivity().finish();
            getDataCenter().resetSession();
            getActivity().startActivity(new Intent(getActivity(), LaunchActivity.class));
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_my, container, false);
        llMyCenter = (LinearLayout) view.findViewById(R.id.ll_my_center);
        imgAvater = (CircleImageView) llMyCenter.findViewById(R.id.img_avater);
        llMyavater = (LinearLayout) view.findViewById(R.id.ll_my_avater);
        tvBanlance = (TextView) view.findViewById(R.id.tv_user_banlance);
        tvUserLevel = (TextView) view.findViewById(R.id.tv_user_level);
        btnRpRank = (Button) view.findViewById(R.id.btn_rp_rank);
        ratingBar = (RatingBar) view.findViewById(R.id.level_ratingbar);
        myOrder = (LinearLayout) view.findViewById(R.id.ll_my_order);
        myFriends = (LinearLayout) view.findViewById(R.id.ll_my_friends);
        myKeFu = (LinearLayout) view.findViewById(R.id.ll_my_kefu);
        myAddress = (LinearLayout) view.findViewById(R.id.ll_my_address);
        myLevelUp = (LinearLayout) view.findViewById(R.id.ll_my_level_up);
        myGoodsOrder = (LinearLayout) view.findViewById(R.id.ll_goods_order);
        loginOut = (Button) view.findViewById(R.id.btn_login_out);
        tvNickname=(TextView)view.findViewById(R.id.tv_nickname);
        refundOrder=(LinearLayout)view.findViewById(R.id.ll_goods_refundorder);
        //初始化view的各控件
        isPrepared = true;
        sessionId = getApp().getDataCenter().getCurrentSession().getId();
        loadData();
        initView();
        return view;
    }

    private void initView() {

        btnRpRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCommonWebViewActivity(getActivity(), WebUrlUtil.getRpBankUrl(sessionId), "红包排名");
               getActivity().overridePendingTransition(R.anim.push_right_in,
                        R.anim.push_left_out);
            }
        });
        myOrder.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           goToCommonWebViewActivity(v.getContext(), WebUrlUtil.getMyOrderUrl(sessionId), "我的账单");
                                           getActivity().overridePendingTransition(R.anim.push_right_in,
                                                   R.anim.push_left_out);
                                       }
                                   }
        );
        myKeFu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCommonWebViewActivity(v.getContext(), WebUrlUtil.getKefuUrl(sessionId), "客服中心");
                getActivity().overridePendingTransition(R.anim.push_right_in,
                        R.anim.push_left_out);
            }
        });
        myFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCommonWebViewActivity(v.getContext(), WebUrlUtil.getMyFriendsUrl(sessionId), "我推荐的好友");
                getActivity().overridePendingTransition(R.anim.push_right_in,
                        R.anim.push_left_out);
            }
        });
        myLevelUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GradeLevelUpActivity.class));
                getActivity().overridePendingTransition(R.anim.push_right_in,
                        R.anim.push_left_out);
            }
        });
        myAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), MyAddressActivity.class));
                getActivity().overridePendingTransition(R.anim.push_right_in,
                        R.anim.push_left_out);
            }
        });
        myGoodsOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCommonWebViewActivity(v.getContext(), WebUrlUtil.getMyGoodsOrderUrl(sessionId), "我的订单");
                getActivity().overridePendingTransition(R.anim.push_right_in,
                        R.anim.push_left_out);
//                getActivity().startActivity(new Intent(getActivity(),MyOrderActivity.class));
            }
        });
        loginOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getActivity().finish();
//                getDataCenter().resetSession();
                dialog();
            }
        });
        refundOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCommonWebViewActivity(view.getContext(), WebUrlUtil.getRefundOrderUrl(sessionId), "退货退款管理");
                getActivity().overridePendingTransition(R.anim.push_right_in,
                        R.anim.push_left_out);
            }
        });

    }
    private void initData(){
        int grade = 0;
        if (getUserInfo() != null) {
            grade = getUserInfo().getRelation().getGrade().getGrade();
            tvUserLevel.setText(getUserInfo().getRelation().getGrade().getName());
            ratingBar.setRating(Float.valueOf(grade + ""));
            tvNickname.setText(getUserInfo().getPerson().getName());
            loadImgToView(getUserInfo().getPerson().getAvatar(), imgAvater);
            new DownloadImageTask().execute(getUserInfo().getPerson().getAvatar());
        }
        if (getCurrentSessioin().getUserAccountInfo()!=null)
        {
            tvBanlance.setText("￥" + getCurrentSessioin().getUserAccountInfo().getBalance());
            btnRpRank.setText("第" + getCurrentSessioin().getUserAccountInfo().getRpSort() + "名");
        }
    }
    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("确认退出吗？");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                getActivity().finish();
                getDataCenter().resetSession();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
    //获取个人账户信息
    protected void getAcInfo() {
        final AcApi acApi = getApp().getApi().acApi(getActivity());
        if (acApi == null)
            return;
        getApp().getApi().execute(getActivity(), new Api.ApiMethod<UserAccountInfo>() {
            @Override
            public UserAccountInfo api() throws ApiException {
                return acApi.acAppInfoGet();
            }
        }, new Api.ApiComplete<UserAccountInfo>() {
            @Override
            public void onComplete(UserAccountInfo result, ApiException ex) {
                if (result != null) {
//                    userAccountInfo = result;
                    getCurrentSessioin().setUserAccountInfo(result);
                    getDataCenter().updateSession(getCurrentSessioin());
                    if (getCurrentSessioin().getUserAccountInfo()!=null)
                    {
                        tvBanlance.setText("￥" + getCurrentSessioin().getUserAccountInfo().getBalance());
                        btnRpRank.setText("第" + getCurrentSessioin().getUserAccountInfo().getRpSort() + "名");
                    }
                } else {
                    //失败
                    Log.d("open22获取失败:", ex.getMessage());
                }
            }
        });
    }

    int radiusArr[];

    @Override
    protected void loadData() {
        if (!isPrepared || !isVisible) {
            return;
        }
        new Handler().postDelayed(LOAD_DATA,1000);
//        getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                //填充各控件的数据
//                getAcInfo();
//                initView();
//            }
//        });

    }

    private Runnable LOAD_DATA = new Runnable() {
        @Override
        public void run() {
            getAcInfo();
            initData();
        }
    };


    @Override
    public void onResume() {
        super.onResume();
        //填充各控件的数据
        loadData();
    }
    private Database mDatabase = null;
    //异步处理模糊图
    private class DownloadImageTask extends AsyncTask<String, Void, Drawable> {

        private static final String TAG = "My";

        protected Drawable doInBackground(String... urls) {
            return GlideImageLoader.loadImageFromNetwork(urls[0]);
        }

        protected void onPostExecute(Drawable result) {
            BitmapDrawable bd = (BitmapDrawable) result;
            Bitmap bitmap = bd.getBitmap();
            Bitmap  blurred;
            File f = new File("./sdcard/DCIM/Camera/mrshop/avarter.png");
            if (f.exists()){
                blurred=BitmapUtil.convertToBitmap("./sdcard/DCIM/Camera/mrshop/avarter.png");
            }
            else {
                blurred = StackBlur.blur(bitmap, 90, false);
                try {
                    BitmapUtil.saveMyBitmap(blurred,"avarter");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Drawable  drawable = new BitmapDrawable(blurred);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                llMyavater.setBackground(drawable);
            } else {
                llMyavater.setBackgroundDrawable(drawable);
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_my_order:
                getActivity().startActivity(new Intent(getActivity(), MyOrderActivity.class));
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
