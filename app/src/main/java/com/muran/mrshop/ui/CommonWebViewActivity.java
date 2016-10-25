package com.muran.mrshop.ui;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.muran.mrshop.R;
import com.muran.mrshop.base.BaseActivity;
import com.muran.mrshop.ui.more.my.MyAddressActivity;
import com.muran.mrshop.ui.more.my.WxPayActivity;
import com.muran.mrshop.utils.DeviceUtil;
import com.muran.mrshop.utils.WebUrlUtil;
import com.orhanobut.logger.Logger;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;

/**
 * Created by Steven on 5/20/16.
 */
public class CommonWebViewActivity extends BaseActivity {
    private static final String TAG = "webview";
    @BindView(R.id.webView)
    protected WebView webView;
    private ProgressBar mProgressBar;

    @BindView(R.id.img_btn_back)
    LinearLayout btnBack;
    @BindView(R.id.tv_title_header)
    TextView tvtitle;

    private static final String APP_CACHE_DIRNAME = "/webcache"; // web缓存目录

    protected int getContentViewId() {
        return R.layout.activity_webview;
    }
    private  String url;
    String title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        addProgressBar();
        configWebView(webView);
        hideActionBar();
         title = getIntent().getStringExtra("title");
        if (title == null) title = "";

        url = getIntent().getStringExtra("url");
        if (url == null)
            Log.w(CommonWebViewActivity.class.getSimpleName(), "url is null");
        else {
            initPush();
            webView.loadUrl(url, getApi().getWebClientHeader(this));
        }
        initTitle(title);

    }
    //接收推送参数
    private void initPush(){
        Bundle bun = getIntent().getExtras();
        if (bun != null) {
            if(getApp().getDataCenter().getCurrentSession().getId()!=null){
            Set<String> keySet = bun.keySet();
            for (String key : keySet) {
                String value = bun.getString(key);
                if (key.equals("url")) {
                    Log.d(TAG, "initPush: "+value);
                    if (value.startsWith("account")) {
                        title="我的账单";
                        url = WebUrlUtil.getMyOrderUrl(getCurrentSessioin().getId());
                    } else if (value.startsWith("friend")) {
                        title="我的好友";
                        url = WebUrlUtil.getMyFriendsUrl(getCurrentSessioin().getId());
                    }
                }
            }
            }
            else {
                this.finish();
                getDataCenter().resetSession();
                Intent intent1 = new Intent(CommonWebViewActivity.this, LaunchActivity.class);
                CommonWebViewActivity.this.startActivity(intent1);
            }
        }
    }
    //初始化title
    private void initTitle(String titlet) {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    finish();
                }
                overridePendingTransition(R.anim.back_left_in,
                        R.anim.back_right_out);
            }
        });
        tvtitle.setEllipsize(TextUtils.TruncateAt.END);//
        tvtitle.setSingleLine();
        tvtitle.setText(titlet);
    }

    protected void configWebView(final WebView webView) {

        WebSettings mWebSettings = webView.getSettings();
        Log.d("TT", "configWebView: " + mWebSettings.getUserAgentString());
        mWebSettings.setSupportZoom(false);
        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setUseWideViewPort(true);
        mWebSettings.setDefaultTextEncodingName("UTF-8");
        mWebSettings.setLoadsImagesAutomatically(true);
        mWebSettings.setJavaScriptEnabled(true);
        mWebSettings.setDomStorageEnabled(true);

        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.setHorizontalScrollBarEnabled(false);

        mWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        // 建议缓存策略为，判断是否有网络，有的话，使用LOAD_DEFAULT,无网络时，使用LOAD_CACHE_ELSE_NETWORK
        String netEnv = DeviceUtil.netEnv(this);
        if (netEnv == null) {
            mWebSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); // 设置缓存模式
        }
        else {
            mWebSettings.setCacheMode(WebSettings.LOAD_DEFAULT); // 设置缓存模式
        }

        // 开启database storage API功能
        mWebSettings.setDatabaseEnabled(true);
        String cacheDirPath = getFilesDir().getAbsolutePath()+ APP_CACHE_DIRNAME;
        Log.i("cachePath", cacheDirPath);
        // 设置数据库缓存路径
        mWebSettings.setDatabasePath(cacheDirPath); // API 19 deprecated
        // 设置Application caches缓存目录
        mWebSettings.setAppCachePath(cacheDirPath);
        // 开启Application Cache功能
        mWebSettings.setAppCacheEnabled(true);


//        webView.setOnTouchListener(new View.OnTouchListener() {//禁止左右滑动
//            public boolean onTouch(View v, MotionEvent event) {
//                return (event.getAction() == MotionEvent.ACTION_MOVE);
//            }
//        });
        //内部跳转
        webView.setWebViewClient(new MyWebViewClient());
        //        加载进度
//        if (progressBar) {
//            webView.setWebChromeClient(new WebChromeClient() {
//                @Override
//                public void onProgressChanged(WebView view, int newProgress) {
//                    if (!getHud().isShowing()) {
//                        getHud().getProgressBar().setMax(100);
//                        getHud().showWithProgress(newProgress + "", SVProgressHUD.SVProgressHUDMaskType.Black);
//                    }
//                    getHud().getProgressBar().setProgress(newProgress);
//                    getHud().setText(newProgress + "");
//                    if (newProgress >= getHud().getProgressBar().getMax()) getHud().dismiss();
//                }
//
//
//                @Override
//                public void onReceivedTitle(WebView view, String title) {
//                    Logger.d(title);
//                }
//            });
//        }


    }

    public class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Logger.d("load:>>" + url);
            //调用拨号程序
            if (url.startsWith("mailto:") || url.startsWith("geo:") || url.startsWith("tel:")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            } else if (url.startsWith("app:")) {

                String[] paras = url.split("\\|");
                Log.d(TAG, "shouldOverrideUrlLoading: " + paras[0]);
                if (paras.length > 0) {
                    String action = paras[0];
                    if (action.endsWith("recharge")) {
                        String pattern = ".*money=(.*)";
                        // 创建 Pattern 对象
                        Pattern r = Pattern.compile(pattern);
                        // 现在创建 matcher 对象
                        Matcher m = r.matcher(url);

                        if (m.find()) {
                            System.out.println("Found value: " + m.group(0));
                            System.out.println("Found value: " + m.group(1));
//                            System.out.println("Found value: " + m.group(2) );
                        } else {
                            System.out.println("NO MATCH");
                        }

                        Intent intent = new Intent(CommonWebViewActivity.this, WxPayActivity.class);
                        intent.putExtra("money", m.group(1));
                        CommonWebViewActivity.this.startActivity(intent);
                    } else if (action.endsWith("edit_address")) {
                        Intent intent = new Intent(CommonWebViewActivity.this, MyAddressActivity.class);
                        CommonWebViewActivity.this.startActivity(intent);
                    }
                }

            }
            else if(url.startsWith("mqqwpa:")){
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                webView.goBack();
            }
            else if (url.startsWith("btn:refresh")) {
                view.loadUrl(url.substring(11, url.length()));
            } else {
                view.loadUrl(url);
            }
            return true;
        }


        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);

        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            // 这里进行无网络或错误处理，具体可以根据errorCode的值进行判断，做跟详细的处理。
            if (failingUrl.startsWith("btn:refresh"))
                failingUrl = failingUrl.substring(11, failingUrl.length());
            view.loadUrl("file:///android_asset/neterror.html?failUrl=" + failingUrl);

        }

    }
    public class WebChromeClient extends android.webkit.WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                mProgressBar.setVisibility(View.GONE);
            } else {
                if (mProgressBar.getVisibility() == View.GONE)
                    mProgressBar.setVisibility(View.VISIBLE);
                mProgressBar.setProgress(newProgress);
            }
            super.onProgressChanged(view, newProgress);
        }
    }
    /**
     * 添加进度条
     */
    public void addProgressBar() {
        mProgressBar = new ProgressBar(this, null,
                android.R.attr.progressBarStyleHorizontal);
        mProgressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(
                AbsoluteLayout.LayoutParams.MATCH_PARENT, 5, 0, 0));
        mProgressBar.setProgressDrawable(this.getResources()
                .getDrawable(R.drawable.bg_pb_web_loading));
        webView.addView(mProgressBar);//添加进度条至LoadingWebView中

        webView.setWebChromeClient(new WebChromeClient());//设置setWebChromeClient对象
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        finish();
                    }
                    overridePendingTransition(R.anim.back_left_in,
                            R.anim.back_right_out);
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //刷新
        webView.reload();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        webView.destroy();
    }

}
