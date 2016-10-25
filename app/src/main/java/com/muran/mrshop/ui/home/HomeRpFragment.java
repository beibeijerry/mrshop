package com.muran.mrshop.ui.home;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.muran.mrshop.MuranApplication;
import com.muran.mrshop.R;
import com.muran.mrshop.base.BaseFragment;
import com.muran.mrshop.base.BaseLazyFragment;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.ui.more.my.GradeLevelUpActivity;
import com.muran.mrshop.ui.more.rp.RpCheckInActivity;
import com.muran.mrshop.ui.more.rp.RpDetailActivity;
import com.muran.mrshop.ui.more.rp.RpShakeActivity;
import com.muran.mrshop.utils.DeviceUtil;
import com.muran.mrshop.utils.FloatingActionsMenuHidable;
import com.muran.mrshop.utils.TimeOperater;
import com.orhanobut.logger.Logger;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import io.swagger.client.ApiException;
import io.swagger.client.api.RpApi;
import io.swagger.client.model.GeneralNumber;
import io.swagger.client.model.UserInfo;
import io.swagger.client.model.VIPRPInfo;
import lib.homhomlib.design.SlidingLayout;

public class HomeRpFragment extends BaseLazyFragment implements SlidingLayout.SlidingListener, ListView.OnItemClickListener, View.OnClickListener, ViewPager.OnPageChangeListener {
    private String TAG = "RP";
    private int maxPullDelta = 0;
    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.RPslidingLayout)
    SlidingLayout slidingLayout;

    private boolean isExpand=false;
    TextView pullDownTextView;
    TextView pullUpTextView;
    TextView noMoreview;
    List<VIPRPInfo> viprpInfos=new ArrayList<VIPRPInfo>();
    VIPRPInfoAdapter adapter;
    private Dialog dialog;//领取红包对话框

    @BindView(R.id.btn_plus)
    FloatingActionsMenu plus;

    @BindView(R.id.btn_shake)
    FloatingActionButton btnShake;

    @BindView(R.id.btn_signin)
    FloatingActionButton btnSign;
    private boolean firstOpen=false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        maxPullDelta = DeviceUtil.dp2px(getActivity(), 30);
        if (savedInstanceState != null) {

        }
        firstOpen=true;
//        viprpInfos.clear();
//        getDataCenter().readVipRpCache();
//        viprpInfos =getDataCenter().getViprpInfosList() ;
//        if (!viprpInfos.isEmpty()){
//            for (VIPRPInfo vip:viprpInfos) {
//                if (vip.getSecondStart()!=null&&vip.getSecondStart() > 0){
//                    refreshStatus(vip.getAuId());
//                }
//            }
//        }
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflateContentView(inflater, R.layout.fragment_home_rp);
        slidingLayout.setSlidingListener(this);
        listView.setDivider(null);
        pullDownTextView = (TextView) slidingLayout.findViewById(R.id.pullDownTextView);
        pullUpTextView = (TextView) slidingLayout.findViewById(R.id.pullUpTextView);

        isPrepared=true;

        loadData();
//        if (viprpInfos.isEmpty())
//            initData();
        return view;
    }


    @Override
    public void onSlidingOffset(View view, float delta) {

        Logger.d("SlidingLayout: delta:" + delta);
        if (upState==State.LoadingMore||downState==State.RefreshingNew){
            Log.d(TAG, "onSlidingOffset: 正在操作");
            return;
        }
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
        Logger.d("SlidingLayout: state:" + state);
        if (state == 1) {
            if (upState == State.NeedLoadMore)
            {
                loadMore();

            }
            if (downState == State.NeedRefreshNew)
            {
                refreshNew();
            }
        }
    }

    @Override
    public void onSlidingChangePointer(View view, int pointerId) {
        Logger.d("SlidingLayout: pointerId" + pointerId);
    }

    //item click
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        VIPRPInfo viprpInfo = (VIPRPInfo) adapter.getItem(position);
        VIPRPInfoViewHodler holder = (VIPRPInfoViewHodler) view.getTag();
        //点击逻辑
        switch (holder.status) {
            case -1:
                showDialog(viprpInfo.getAuId(), holder);
                break;
            case 0:
                noPermissionDialog(viprpInfo.getAuId(), "无权限，请升级");
                break;
            case 1:
                // 查看红包详情
                Intent intent = new Intent(getActivity(), RpDetailActivity.class);
                intent.putExtra("vipRpId", id);
                getActivity().startActivity(intent);
                getActivity().overridePendingTransition(R.anim.push_right_in,
                        R.anim.push_left_out);
                break;
            case 2:
                // 未开始红包处理
                break;
        }
    }

    /**
     * 弹出领取成功对话框
     */
    protected void showDialog(Long id, VIPRPInfoViewHodler hodler) {
        dialog=null;
        if (dialog == null) {
            dialog = new Dialog(getActivity(), R.style.DialogStyleBottom);
            dialog.setContentView(R.layout.dialog_rp_gone);
            TextView textView = (TextView) dialog.findViewById(R.id.tv_gone_rp);
            ImageView imageView=(ImageView)dialog.findViewById(R.id.imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.setCanceledOnTouchOutside(true);
            getRp(id, hodler, textView, dialog);
            dialog.getWindow().setGravity(Gravity.CENTER_VERTICAL);
            dialog.getWindow().setWindowAnimations(R.style.dialog_bottom_inout);

            WindowManager wm = getActivity().getWindowManager();
            WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
            lp.width = wm.getDefaultDisplay().getWidth();
            lp.height = wm.getDefaultDisplay().getHeight();
            dialog.getWindow().setAttributes(lp);
        }

    }

    //领取红包
    private void getRp(final Long viprpId, final VIPRPInfoViewHodler hodler, final TextView textView, final Dialog dialog) {
        final SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日 HH:mm");
        final RpApi rpApi = getApp().getApi().rpApi(getActivity());
        if (rpApi == null)
            return;
        getApp().getApi().execute(getActivity(), new Api.ApiMethod<GeneralNumber>() {
            @Override
            public GeneralNumber api() throws ApiException {
                Long id = viprpId;
                return rpApi.rpAppViprpViprpidGetPost(id);
            }
        }, new Api.ApiComplete<GeneralNumber>() {
            @Override
            public void onComplete(GeneralNumber result, ApiException ex) {
                if (result != null) {
                    dialog.show();
                    String rpOpenText = formatter.format(new Date());
                    String rpTitle = "";
                    rpTitle = "已获得" + result.getValue() + "元\n" + rpOpenText;
                    textView.setText(result.getValue() + "元");
                    hodler.rpTitle.setText(rpTitle);
                    hodler.status = 1; // 成功领取
                    hodler.rpStartTime.setText("查看详情");

                    ((GradientDrawable) hodler.llRpBg.getBackground().getCurrent()).setColor(getResources().getColor(R.color.rp_gone));
                } else {
                    dialog.dismiss();
                    noPermissionDialog(viprpId, ex.getError().getInfo());
                }
                refreshStatus(viprpId);
            }
        });
    }

    //刷新红包状态
    private void refreshStatus(final Long vid){
        final SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日 HH:mm");
        final RpApi rpApi = getApp().getApi().rpApi(getActivity());
        if (rpApi == null)
            return;
        getApp().getApi().execute(getActivity(), new Api.ApiMethod<VIPRPInfo>() {
            @Override
            public VIPRPInfo api() throws ApiException {
                Long id = vid;
                return rpApi.rpAppViprpViprpidGet(id);
            }
        }, new Api.ApiComplete<VIPRPInfo>() {
            @Override
            public void onComplete(VIPRPInfo result, ApiException ex) {
                if (result != null) {
                    if (viprpInfos!=null&&!viprpInfos.isEmpty()){
                        int i=0;
                        List<VIPRPInfo> copylist=new ArrayList<VIPRPInfo>();
                        copylist.addAll(viprpInfos);
                        for (VIPRPInfo info:copylist) {
                            if (info.getAuId()==vid){
                                viprpInfos.remove(info);
                                viprpInfos.add(i,result);
//                                getDataCenter().updateVipRp(viprpInfos);
                            }else {
                                i++;
                            }
                        }
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    dialog.dismiss();
                }

            }
        });
    }

    //无权限对话框
    protected void noPermissionDialog(final Long id, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(message);
        builder.setTitle("提示");
        builder.setPositiveButton("查看详情", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent = new Intent(getActivity(), RpDetailActivity.class);
                intent.putExtra("vipRpId", id);
                getActivity().startActivity(intent);
            }
        });
        builder.setNegativeButton("去充值", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent=new Intent(getActivity(), GradeLevelUpActivity.class);
                getActivity().startActivity(intent);
            }
        });
        builder.create().show();
    }



    private enum State {
        NeedLoadMore,//需要加载更多
        NeedRefreshNew,//需要刷新
        LoadingMore,//正在加载更多
        RefreshingNew,//正在刷新数据
        Normal;//没有操作
    }

    private State downState = State.Normal;
    private State upState = State.Normal;

    public HomeRpFragment() {
    }

    //加载更多
    private void loadMore() {
        final RpApi rpApi = getApi().rpApi(getActivity());
        if (rpApi == null) return;
        upState = State.LoadingMore;
        getApi().execute(getActivity()
                , new Api.ApiMethod<List<VIPRPInfo>>() {
                    @Override
                    public List<VIPRPInfo> api() throws ApiException {
                        Date time =null;
                        if (viprpInfos.size()-1>0)
                            time= viprpInfos.get(viprpInfos.size()-1).getCreateTime();
                        return rpApi.rpAppViprpGet(time, 5, "up");
                    }
                }
                , new Api.ApiComplete<List<VIPRPInfo>>() {
                    @Override
                    public void onComplete(List<VIPRPInfo> result, ApiException ex) {
                        pullUpTextView.setText("上拉加载更多数据");
                        if (result != null && !result.isEmpty()) {
                            viprpInfos.addAll(result);
                            adapter.notifyDataSetChanged();
                            int max = Math.min(result.size(),1);
                            listView.smoothScrollToPosition(viprpInfos.size() - result.size() );
                        }
                        if (ex != null) {
                            Toast.makeText(getActivity(), "加载更多失败", Toast.LENGTH_SHORT).show();
                        }
                        upState = State.Normal;
                    }
                }
        );
    }

    //初始化
    private void initData() {
        final RpApi rpApi = getApi().rpApi(getActivity());
        if (rpApi == null) return;
        upState = State.LoadingMore;
        getApi().execute(getActivity()
                , new Api.ApiMethod<List<VIPRPInfo>>() {
                    @Override
                    public List<VIPRPInfo> api() throws ApiException {
                        return rpApi.rpAppViprpGet(null, 5, "up");
                    }
                }
                , new Api.ApiComplete<List<VIPRPInfo>>() {
                    @Override
                    public void onComplete(List<VIPRPInfo> result, ApiException ex) {
                        pullUpTextView.setText("上拉加载更多数据");
                        upState = State.Normal;
                        if (result != null && !result.isEmpty()) {
                            viprpInfos.addAll(result);
                            adapter.notifyDataSetChanged();
                            int max = Math.min(result.size(), 2);
                            listView.smoothScrollToPosition(viprpInfos.size() - result.size() + max);
                        }
                        if (ex != null) {
                            Toast.makeText(getActivity(), "加载更多失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }



    @Override
    public void onSaveInstanceState(Bundle outBundle) {
        super.onSaveInstanceState(outBundle);
    }

    @Override
    public void onClick(View v) {

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

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    @Override
    protected void loadData() {
        if (!isPrepared || !isVisible) {
            return;
        }
        adapter = new VIPRPInfoAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        btnShake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RpShakeActivity.class);
                getActivity().startActivity(intent);
            }
        });
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RpCheckInActivity.class);
                getActivity().startActivity(intent);
            }
        });
        if (firstOpen)
            getLoadingDialog("正在努力加载数据...  ").show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshNew();
            }
        },1000);

    }
    //刷新数据
    public void refreshNew() {
        Log.d("RP", "刷新");
        final RpApi rpApi = getApi().rpApi(getActivity());
        if (rpApi == null) return;
        downState = State.RefreshingNew;
        getApi().execute(getActivity()
                , new Api.ApiMethod<List<VIPRPInfo>>() {
                    @Override
                    public List<VIPRPInfo> api() throws ApiException {
                        Date time = null;
                        if (!viprpInfos.isEmpty())
                            time=viprpInfos.get(0).getCreateTime();
                        return rpApi.rpAppViprpGet(time, null, "down");
                    }
                }
                , new Api.ApiComplete<List<VIPRPInfo>>() {
                    @Override
                    public void onComplete(List<VIPRPInfo> result, ApiException ex) {
                        pullDownTextView.setText("下拉刷新");
                        if (!viprpInfos.isEmpty()){
                            for (VIPRPInfo vip:viprpInfos) {
                                if ((vip.getSecondStart()!=null&&vip.getSecondStart() > 0)||!vip.getOpened()){
                                    refreshStatus(vip.getAuId());
                                }

                            }
                        }
                        if (result != null && !result.isEmpty()) {
                            viprpInfos.addAll(0, result);
                            adapter.notifyDataSetChanged();
                            listView.smoothScrollToPosition(0);
                        }

                        downState = State.Normal;
                        if (firstOpen)
                            getLoadingDialog("正在努力加载数据...  ").dismiss();
                        firstOpen=false;
                    }
                }
        );
    }

    private class VIPRPInfoAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return viprpInfos.size();
        }

        @Override
        public Object getItem(int position) {
            return viprpInfos.get(position);
        }

        @Override
        public long getItemId(int position) {
            VIPRPInfo viprpInfo = viprpInfos.get(position);
            return viprpInfo.getAuId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            VIPRPInfoViewHodler holder = null;
            GradientDrawable mGrad = null;
            String rpTypeTitle = "";
            String rpTitle = "";
            String rpSubTitle = "";
            String rpOpenText = "";
            String rpGradeLimit="";
            BigDecimal rpBalance = new BigDecimal(0);
            SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日 HH:mm");
//            if (convertView != null) {
//                holder = (VIPRPInfoViewHodler) convertView.getTag();
//            } else {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            convertView = inflater.inflate(R.layout.item_list_rp, null);
            holder = new VIPRPInfoViewHodler();
            convertView.setTag(holder);
            holder.llRpBg = (LinearLayout) convertView.findViewById(R.id.ll_rp_bg);
            holder.rpTitle = (TextView) convertView.findViewById(R.id.tv_rp_title);
            holder.rpStartTime = (TextView) convertView.findViewById(R.id.tv_start_time);
            holder.rpGradeLevelLimit = (TextView) convertView.findViewById(R.id.tv_grade_level_limit);
            holder.tvDate = (TextView) convertView.findViewById(R.id.tvDate);

            mGrad = (GradientDrawable) holder.llRpBg.getBackground().getCurrent();
            VIPRPInfo viprpInfo = (VIPRPInfo) getItem(position);
            boolean read = false;

            if (viprpInfo.getRpType() == 1) {
                rpBalance = viprpInfo.getTotalMoney().subtract(viprpInfo.getGoneMoney());
                rpTypeTitle = "拼手气红包";
            } else {
                rpBalance = (viprpInfo.getMoney().multiply(BigDecimal.valueOf(viprpInfo.getCount()))).subtract(viprpInfo.getGoneMoney());
                rpTypeTitle = "普通红包";
            }
            if (viprpInfo.getMinGrade() == 0) {
                rpGradeLimit=rpTypeTitle+" 限普通会员";
            } else if(viprpInfo.getMinGrade()<0){
                rpGradeLimit=rpTypeTitle+" 全民红包";
            }
            else {
                rpGradeLimit=(rpTypeTitle + " 限" + viprpInfo.getMinGrade() + "星以上会员");
            }
            if (viprpInfo.getSecondStart() > 0) {
                // 未开始
                rpTitle = "活动未开始\n总金额:" + rpBalance + "元 共"+viprpInfo.getCount()+"个";
                holder.status = 2; // 未开始
                mGrad.setColor(getResources().getColor(R.color.rp_nostart));
                int i = Integer.parseInt(viprpInfo.getSecondStart() + "");
                Long vid=viprpInfo.getAuId();
                new Thread(new TimeCount(holder.rpStartTime, i, holder,vid)).start();
            } else {
                if (viprpInfo.getOpened()) {
                    // 已拆封
                    rpOpenText = formatter.format(viprpInfo.getOpenedTime());
                    if (viprpInfo.getGotMoneySuccessed()) {
                        rpTitle = "已获得:" + viprpInfo.getGotMoney() + "元\n" + rpOpenText;
                    } else {
                        rpTitle = viprpInfo.getGotNoMoneyReason() + "\n" + rpOpenText;
                    }
                    holder.status = 1; // 成功领取
                    rpSubTitle = "查看详情";
                    mGrad.setColor(getResources().getColor(R.color.rp_gone));
                } else {
                    // 未拆封

                    if (getUserInfo().getRelation()!=null&&getUserInfo().getRelation().getGrade().getGrade() < viprpInfo.getMinGrade()) {
                        //无权限,未拆封
                        if (viprpInfo.getMinGrade() <= 0) {
                            rpTitle = "该红包仅限普通会员以上会员领取，您无权领取哦";
                        } else {
                            rpTitle = "该红包仅限" + viprpInfo.getMinGrade() + "星以上会员领取，您无权领取哦";
                        }
                        rpSubTitle = "点击升级会员";
                        holder.status = 0;
                        mGrad.setColor(getResources().getColor(R.color.rp_time));
                    } else {
                        //有权限未拆封
                        rpTitle = "未拆封";
                        rpSubTitle = "点击领取";
                        holder.status = -1; //未拆
                        mGrad.setColor(getResources().getColor(R.color.rp_nogone));
                    }
                }
                holder.rpStartTime.setText(rpSubTitle);
            }
            holder.rpGradeLevelLimit.setText(rpGradeLimit);
            holder.rpTitle.setText(rpTitle);
            TimeOperater toperate = new TimeOperater(getContext());
            holder.tvDate.setText(toperate.formatTimeString(viprpInfo.getCreateTime().getTime()));
//            }

            return convertView;
        }

        //倒计时类
        class TimeCount implements Runnable {
            private TextView timeCount;
            private Handler mHandler = new Handler();//全局handler
            VIPRPInfoViewHodler hodler;
            int i = 0;//时间差
            Long vid;
            public TimeCount(TextView textView, int time, VIPRPInfoViewHodler viprpInfoViewHodler,Long vid) {
                timeCount = textView;
                i = time;
                hodler = viprpInfoViewHodler;
                this.vid=vid;
            }

            @Override
            public void run() {
                while (i > 0)//整个倒计时执行的循环
                {
                    i--;
                    mHandler.post(new Runnable() //通过它在UI主线程中修改显示的剩余时间
                    {
                        public void run() {
                            timeCount.setText(getInterval(i));//显示剩余时间
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

                        hodler.rpTitle.setText("未拆封");
                        hodler.rpStartTime.setText("点击领取");
                        hodler.status = -1; //未拆
                        ((GradientDrawable) hodler.llRpBg.getBackground().getCurrent()).setColor(getResources().getColor(R.color.rp_nogone));
                    }
                });
            }
        }

    }

    public static String getInterval(int interval) {
        String txt = null;
        if (interval >= 0) {
            long day = interval / (24 * 3600);//Ìì
            long hour = interval % (24 * 3600) / 3600;//Ð¡Ê±
            long minute = interval % 3600 / 60;//·ÖÖÓ
            long second = interval % 60;//Ãë

            txt = "倒计时" + day + "天" + hour + "时" + minute + "分" + second + "秒";
        }
        return txt;
    }

    public static int getTimeInterval(String data) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int interval = 0;
        try {
            Date currentTime = new Date();//
            Date beginTime = dateFormat.parse(data);
            interval = (int) ((beginTime.getTime() - currentTime.getTime()) / (1000));//
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return interval;
    }

    private class VIPRPInfoViewHodler {
        public LinearLayout llRpBg;
        public int status;
        public TextView rpTitle, rpStartTime, rpGradeLevelLimit, tvDate;
    }
}
