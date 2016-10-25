package com.muran.mrshop;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.muran.mrshop.common.Conf;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.data.DataCenter;
import com.muran.mrshop.data.Session;
import com.muran.mrshop.utils.GlideImageLoader;
import com.orhanobut.logger.Logger;
import com.tencent.bugly.Bugly;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.umeng.message.IUmengCallback;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ImageLoader;
import cn.finalteam.galleryfinal.ThemeConfig;
import cn.sharesdk.framework.ShareSDK;


/**
 * Created by Steven on 5/20/16.
 */
public class MuranApplication extends Application {

    private static final String TAG = "Application";
    public static MuranApplication app = null;
    private static Context mContext;
    private final static String WEICHAT_APP_ID = "wx3995b32f6cd5d97e";
    private final static String WEIBO_APP_KEY = "1753798173";
    private final static String QQ_APP_ID = "1105357871";
    //妙享乐购
//    public final static String WEIXIN_APP_ID = "wx2487a417b90ace70";
//    public final static String WEIXIN_APP_SECRET = "122e391f443b1b1cf59ce56b3aea0387";
    //妙享助手
    public final static String WEIXIN_APP_ID = Conf.WEIXIN_APP_ID;
    public final static String WEIXIN_APP_SECRET = Conf.WEIXIN_APP_SECRET;
    public final static String IMG_DOMAIN = "http://img.mxlg369.com/";
    private final static String Bug_APP_ID="1105632171";//应用宝bug app id

    DataCenter dataCenter;
    Api api;
    public IWXAPI wxapi;

    public Api getApi() {
        return api;
    }

    public DataCenter getDataCenter() {
        return dataCenter;
    }

    public static Context getContext() {
        return mContext;
    }
    public String mobile,veryCode;
    public Long bussId;
    public boolean isBindMobile;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        ShareSDK.initSDK(this);

        Logger.init("com.muran.mrshop");

        dataCenter = DataCenter.getDataCenter(this);
        dataCenter.setDatabase(dataCenter.getUserDatabase());
        dataCenter.readSession();
        if (dataCenter.getCurrentSession() == null)
            dataCenter.updateSession(new Session());
        api = new Api();
        ThemeConfig theme = new ThemeConfig.Builder().setTitleBarBgColor(getResources().getColor(R.color.colorPrimary)).build();
        FunctionConfig functionConfig = new FunctionConfig.Builder().setEnableCamera(true)
                .setEnableEdit(false).setEnableCrop(true).setCropSquare(true).setEnablePreview(true).build();
        ImageLoader imageLoader = new GlideImageLoader();
        CoreConfig coreConfig = new CoreConfig.Builder(this, imageLoader, theme).setFunctionConfig(functionConfig).build();
        GalleryFinal.init(coreConfig);
        mContext = getApplicationContext();
        initWXAndPush();

    }

    //初始化微信和推送注册
    public void initWXAndPush(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                regToWx();
                initPush();
                Bugly.init(mContext, Bug_APP_ID, false);
            }
        }).start();

    }

    //注册到微信
    private void regToWx() {
        wxapi = WXAPIFactory.createWXAPI(this, WEIXIN_APP_ID, true);
        wxapi.registerApp(app.WEIXIN_APP_ID);
    }

    public PushAgent mPushAgent;
    public SharedPreferences sp;

    //推送相关
    private void initPush() {
        mPushAgent = PushAgent.getInstance(this);
        mPushAgent.setNotificationPlaySound(MsgConstant.NOTIFICATION_PLAY_SDK_ENABLE);//声音
        mPushAgent.setNotificationPlayLights(MsgConstant.NOTIFICATION_PLAY_SDK_ENABLE); //呼吸灯
        mPushAgent.setNotificationPlayVibrate(MsgConstant.NOTIFICATION_PLAY_SDK_ENABLE); //振动
        sp = mContext.getSharedPreferences("SP", MODE_PRIVATE);
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.d(TAG, "deviceToken: " + deviceToken);

                //存入数据
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("Exist_token", true);
                editor.commit();
                app.mPushAgent.enable(new IUmengCallback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onFailure(String s, String s1) {

                    }
                });
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });

    }
}
