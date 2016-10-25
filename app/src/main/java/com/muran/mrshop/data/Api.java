package com.muran.mrshop.data;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.muran.mrshop.MuranApplication;
import com.muran.mrshop.api.WxAuthApi;
import com.muran.mrshop.utils.DeviceUtil;
import com.orhanobut.logger.Logger;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.swagger.client.ApiException;
import io.swagger.client.JsonUtil;
import io.swagger.client.api.AcApi;
import io.swagger.client.api.RpApi;
import io.swagger.client.api.ShApi;
import io.swagger.client.api.SysApi;
import io.swagger.client.api.UsApi;
import io.swagger.client.api.WpApi;
import io.swagger.client.model.WxPay;

/**
 * Created by Steven on 5/23/16.
 */
public class Api {

    private final static String HOST_IMG = "img.mxlg369.com";
    private final static String CLIENT_KEY = "client_android";
    private final static String VERSION = "1.0.0";
    private final static String USER_SYS="wechat";
    ExecutorService executor = Executors.newSingleThreadExecutor();
    private Map<SoftReference<Context>, SoftReference<SVProgressHUD>> dialogs = new HashMap<>();//ProgerssHUD 一个contex不能同时出现两个，负责就会报错，所以采用这样的方式保证一个context只有一个。

    public Api() {
    }

    public interface ApiMethod<T> {
        T api() throws ApiException;
    }

    public interface ApiComplete<T> {
        void onComplete(T result, ApiException ex);
    }

    public <T> void execute(Context context, final ApiMethod<T> method, final ApiComplete<T> complete) {
        execute(context, method, complete, false);
    }

    public <T> void execute(Context context, final ApiMethod<T> method, final ApiComplete<T> complete, final boolean progressDialog) {
        execute(context, method, complete, progressDialog, null, null, null);
    }

    public <T> void execute(Context context, final ApiMethod<T> method, final ApiComplete<T> complete, final boolean progressDialog, String progressTitle, final String successTitle, final String failtureTitle) {
        final Handler handler = new Handler();
        final SVProgressHUD hud = newProgressHUD(context);
        if (progressDialog) {
            if (progressTitle != null)
                hud.showWithStatus(progressTitle);
            else hud.show();
        }
        executor.execute(new Runnable() {
            @Override
            public void run() {
                T t = null;
                ApiException ex = null;
                try {
                    t = method.api();
                    if (t != null) Logger.json(JsonUtil.serialize(t));
                } catch (final ApiException e) {
                    e.printStackTrace();
                    ex = e;
                } finally {
                    final T t1 = t;
                    final ApiException ex1 = ex;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (progressDialog) {
                                if (t1 != null) {
                                    if (successTitle != null)
                                        hud.showSuccessWithStatus(successTitle);
                                    else hud.dismiss();
                                }
                                if (ex1 != null) {
                                    if (failtureTitle != null)
                                        hud.showErrorWithStatus(failtureTitle);
                                    else hud.dismiss();
                                }
                            }
                            if (complete != null) complete.onComplete(t1, ex1);
                        }
                    });
                }
            }
        });
    }

    public AcApi acApi(Context context) {
        String netEnv = DeviceUtil.netEnv(context);
        if (netEnv == null) {
            SVProgressHUD hud = newProgressHUD(context);
            hud.showErrorWithStatus("没有网络连接哦");
            return null;
        }
        AcApi api = new AcApi();
        api.addHeader("session-id", MuranApplication.app.getDataCenter().getCurrentSession().getId());
        api.addHeader("client-key", CLIENT_KEY);
        api.addHeader("user-sys",USER_SYS);
        api.addHeader("client-net-env", netEnv);
        api.addHeader("version", VERSION);
        return api;
    }

    public SysApi sysApi(Context context) {
        String netEnv = DeviceUtil.netEnv(context);
        if (netEnv == null) {
            SVProgressHUD hud = newProgressHUD(context);
            hud.showErrorWithStatus("没有网络连接哦");
            return null;
        }
        SysApi api = new SysApi();
        api.addHeader("session-id", MuranApplication.app.getDataCenter().getCurrentSession().getId());
        api.addHeader("client-key", CLIENT_KEY);
        api.addHeader("user-sys",USER_SYS);
        api.addHeader("client-net-env", netEnv);
        api.addHeader("version", VERSION);
        return api;
    }

    public ShApi shApi(Context context) {
        String netEnv = DeviceUtil.netEnv(context);
        if (netEnv == null) {
            SVProgressHUD hud = newProgressHUD(context);
            hud.showErrorWithStatus("没有网络连接哦");
            return null;
        }
        ShApi api = new ShApi();
        api.addHeader("session-id", MuranApplication.app.getDataCenter().getCurrentSession().getId());
        api.addHeader("client-key", CLIENT_KEY);
        api.addHeader("user-sys",USER_SYS);
        api.addHeader("client-net-env", netEnv);
        api.addHeader("version", VERSION);
        return api;
    }

    public UsApi usApi(Context context) {
        String netEnv = DeviceUtil.netEnv(context);
        if (netEnv == null) {
            SVProgressHUD hud = newProgressHUD(context);
            hud.showErrorWithStatus("没有网络连接哦");
            return null;
        }
        UsApi api = new UsApi();
        api.addHeader("session-id", MuranApplication.app.getDataCenter().getCurrentSession().getId());
        api.addHeader("client-key", CLIENT_KEY);
        api.addHeader("user-sys",USER_SYS);
        api.addHeader("client-net-env", netEnv);
        api.addHeader("version", VERSION);
        return api;
    }
    public RpApi rpApi(Context context) {
        String netEnv = DeviceUtil.netEnv(context);
        if (netEnv == null) {
            SVProgressHUD hud = newProgressHUD(context);
            hud.showErrorWithStatus("没有网络连接哦");
            return null;
        }
        RpApi api = new RpApi();
        api.addHeader("session-id", MuranApplication.app.getDataCenter().getCurrentSession().getId());
        api.addHeader("user-sys",USER_SYS);
        api.addHeader("client-key", CLIENT_KEY);
        api.addHeader("client-net-env", netEnv);
        api.addHeader("version", VERSION);
        return api;
    }

    public WpApi wpApi(Context context) {
        String netEnv = DeviceUtil.netEnv(context);
        if (netEnv == null) {
            SVProgressHUD hud = newProgressHUD(context);
            hud.showErrorWithStatus("没有网络连接哦");
            return null;
        }
        WpApi api = new WpApi();
        api.addHeader("session-id", MuranApplication.app.getDataCenter().getCurrentSession().getId());
        api.addHeader("user-sys",USER_SYS);
        api.addHeader("client-key", CLIENT_KEY);
        api.addHeader("client-net-env", netEnv);
        api.addHeader("version", VERSION);
        return api;
    }

    public WxAuthApi wxAuthApi(Context context) {
        String netEnv = DeviceUtil.netEnv(context);
        if (netEnv == null) {
            SVProgressHUD hud = newProgressHUD(context);
            hud.showErrorWithStatus("没有网络连接哦");
            return null;
        }
        WxAuthApi api = new WxAuthApi();
        api.addHeader("session-id", MuranApplication.app.getDataCenter().getCurrentSession().getId());
        api.addHeader("user-sys",USER_SYS);
        api.addHeader("client-key", CLIENT_KEY);
        api.addHeader("client-net-env", netEnv);
        api.addHeader("version", VERSION);
        return api;
    }





    public SVProgressHUD dismissProgressHUD(Context context) {
        SoftReference<Context> softReference = null;
        List<SoftReference<Context>> nullSofts = new ArrayList<>();
        SVProgressHUD hud = null;
        for (SoftReference<Context> contextSoftReference : dialogs.keySet()) {
            if (contextSoftReference.get() == null) {
                nullSofts.add(contextSoftReference);
                continue;
            }
            if (contextSoftReference.get() == context) {
                softReference = contextSoftReference;
                hud = dialogs.get(contextSoftReference).get();
                if (hud != null && hud.isShowing()) hud.dismiss();
            }
        }
        for (SoftReference<Context> soft : nullSofts) {
            dialogs.remove(soft);
        }
        if (softReference != null) dialogs.remove(softReference);
        return hud;
    }

    public SVProgressHUD newProgressHUD(Context context) {
        SVProgressHUD hud = dismissProgressHUD(context);
        if (hud == null) hud = new SVProgressHUD(context);
        SoftReference<Context> softContext = new SoftReference<Context>(context);
        SoftReference<SVProgressHUD> softHUD = new SoftReference<SVProgressHUD>(hud);
        dialogs.put(softContext, softHUD);
        return hud;
    }


    public String getArticleEditPageUrl(String tinyKey) {
        return "http://miaox.top/v140/miaox/article_editor/" + tinyKey;
    }

    public String getShareUrlForArticle(Long usId, String tinyKey) {
        return "http://html.miaox.top/" + usId + "_" + tinyKey + ".html";
    }

    public String getImgUrl(String key) {
        if (!key.startsWith("http")) return "http://" + HOST_IMG + "/" + key;
        return key;
    }


    public Map<String, String> getWebClientHeader(Context context) {
        Map<String, String> header = new HashMap<>();
        header.put("session-id", MuranApplication.app.getDataCenter().getCurrentSession().getId());
        header.put("client-key", CLIENT_KEY);
        String netEnv = DeviceUtil.netEnv(context);
        header.put("client-net-env", netEnv);
        header.put("version", VERSION);
        return header;
    }

}


