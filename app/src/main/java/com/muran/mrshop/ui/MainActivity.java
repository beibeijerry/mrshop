package com.muran.mrshop.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.muran.mrshop.MuranApplication;
import com.muran.mrshop.R;
import com.muran.mrshop.base.BaseActivity;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.ui.home.HomeMyFragment;
import com.muran.mrshop.ui.home.HomeRpFragment;
import com.muran.mrshop.ui.home.HomeShopFragment;
import com.umeng.message.UTrack;

import java.util.Set;

import butterknife.BindView;
import io.swagger.client.ApiException;
import io.swagger.client.api.UsApi;
import io.swagger.client.model.UserInfo;

public class MainActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private static final String TAG = "Main";
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.homeTabRadioButton)
    RadioButton homeTab;
    @BindView(R.id.statTabRadioButton)
    RadioButton statTab;
    @BindView(R.id.moreTabRadioButton)
    RadioButton moreTab;

    public Handler handler = new Handler();
    private MuranApplication app;
    MainPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        app = MuranApplication.app;
                getSupportActionBar().hide();
        homeTab.setOnCheckedChangeListener(MainActivity.this);
        statTab.setOnCheckedChangeListener(MainActivity.this);
        moreTab.setOnCheckedChangeListener(MainActivity.this);
        homeTab.setChecked(true);
        adapter = new MainPagerAdapter(MainActivity.this.getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(MainActivity.this);
        viewPager.setOffscreenPageLimit(2);//把三个界面都缓存下来，否则将导致手机没内部viewpager状态问题。
        initPush();

    }


    //接收推送参数
    private void initPush(){
        Bundle bun = getIntent().getExtras();
        if (bun != null) {
            if(getApp().getDataCenter().getCurrentSession().getId()!=null){
            Set<String> keySet = bun.keySet();
            for (String key : keySet) {
                String value = bun.getString(key);
                if (key.equals("tabIndex")) {
                    Integer item = Integer.valueOf(value);
                    if (item != null) {
                        viewPager.setCurrentItem(item);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            }
            }else {
                finish();
                getDataCenter().resetSession();
                Intent intent1 = new Intent(MainActivity.this, LaunchActivity.class);
                MainActivity.this.startActivity(intent1);
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (homeTab == buttonView && isChecked == true && viewPager.getCurrentItem() != 0) {
            viewPager.setCurrentItem(0);
        }
        if (statTab == buttonView && isChecked == true && viewPager.getCurrentItem() != 1) {
            viewPager.setCurrentItem(1);
        }
        if (moreTab == buttonView && isChecked == true && viewPager.getCurrentItem() != 2) {
            viewPager.setCurrentItem(2);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0 && !homeTab.isChecked()) {
            homeTab.setChecked(true);
        }
        if (position == 1 && !statTab.isChecked()) {
            statTab.setChecked(true);
        }
        if (position == 2 && !moreTab.isChecked()) {
            moreTab.setChecked(true);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class MainPagerAdapter extends FragmentStatePagerAdapter {
        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new HomeShopFragment();
                case 1:
                    return new HomeRpFragment();
                case 2:
                    return new HomeMyFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    /**
     * 监听Back键按下事件,方法2:
     * 注意:
     * 返回值表示:是否能完全处理该事件
     * 在此处返回false,所以会继续传播该事件.
     * 在具体项目中此处的返回值视情况而定.
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
//            dialog();
            int currentVersion = android.os.Build.VERSION.SDK_INT;
            if (currentVersion > android.os.Build.VERSION_CODES.ECLAIR_MR1) {
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(startMain);
            } else {// android2.1
                ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                am.restartPackage(getPackageName());
            }
        }
        return false;
    }
    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("确认退出吗？");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                app.getDataCenter().resetSession();
                int currentVersion = android.os.Build.VERSION.SDK_INT;
                if (currentVersion > android.os.Build.VERSION_CODES.ECLAIR_MR1) {
                    Intent startMain = new Intent(Intent.ACTION_MAIN);
                    startMain.addCategory(Intent.CATEGORY_HOME);
                    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(startMain);
                    System.exit(0);
                } else {// android2.1
                    ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                    am.restartPackage(getPackageName());
                }

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
}
