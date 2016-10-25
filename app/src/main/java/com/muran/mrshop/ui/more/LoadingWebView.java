package com.muran.mrshop.ui.more;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.muran.mrshop.R;
import com.muran.mrshop.ui.more.my.MyAddressActivity;
import com.muran.mrshop.ui.more.my.WxPayActivity;
import com.muran.mrshop.utils.DeviceUtil;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/9/21.
 */

public class LoadingWebView extends WebView {
    private ProgressBar mProgressBar;
    /**
     * 网页缓存目录
     */
    private static final String cacheDirPath = Environment
            .getExternalStorageDirectory() + "/LoadingWebViewDome/webCache/";

    public LoadingWebView(Context context) {
        super(context, null);
    }

    public LoadingWebView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public LoadingWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initContext(context);
    }

    private void initContext(Context context) {
        requestFocus();
        WebSettings mWebSettings = getSettings();
        Log.d("TT", "configWebView: " + mWebSettings.getUserAgentString());
        mWebSettings.setSupportZoom(false);
        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setUseWideViewPort(true);
        mWebSettings.setDefaultTextEncodingName("UTF-8");
        mWebSettings.setLoadsImagesAutomatically(true);
        mWebSettings.setJavaScriptEnabled(true);
        mWebSettings.setDomStorageEnabled(true);

        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        setHorizontalScrollBarEnabled(false);

        mWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        // 建议缓存策略为，判断是否有网络，有的话，使用LOAD_DEFAULT,无网络时，使用LOAD_CACHE_ELSE_NETWORK
        String netEnv = DeviceUtil.netEnv(getContext());
        if (netEnv == null) {
            mWebSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); // 设置缓存模式
        }
        else {
            mWebSettings.setCacheMode(WebSettings.LOAD_DEFAULT); // 设置缓存模式
        }

        // 开启database storage API功能
        mWebSettings.setDatabaseEnabled(true);
        // 设置数据库缓存路径
        mWebSettings.setDatabasePath(cacheDirPath); // API 19 deprecated
        // 设置Application caches缓存目录
        mWebSettings.setAppCachePath(cacheDirPath);
        // 开启Application Cache功能
        mWebSettings.setAppCacheEnabled(true);
    }

    /**
     * 加载网页url
     *
     * @param url
     */
    public void loadMessageUrl(String url,Map<String, String> additionalHttpHeaders) {
         url="http://www.baidu.com";
        super.loadUrl(url,additionalHttpHeaders);
        setWebViewClient(new MyWebViewClient());
    }
    public class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            //调用拨号程序
            if (url.startsWith("mailto:") || url.startsWith("geo:") || url.startsWith("tel:")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                getContext().startActivity(intent);
            } else if (url.startsWith("app:")) {

                String[] paras = url.split("\\|");
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
                        Intent intent = new Intent(getContext(), WxPayActivity.class);
                        intent.putExtra("money", m.group(1));
                        getContext().startActivity(intent);
                    } else if (action.endsWith("edit_address")) {
                        Intent intent = new Intent(getContext(), MyAddressActivity.class);
                        getContext().startActivity(intent);
                    }
                }
            } else if (url.startsWith("btn:refresh")) {
                view.loadUrl(url.substring(11, url.length()));
            } else {
                view.loadUrl(url);
            }
            return true;
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            // 这里进行无网络或错误处理，具体可以根据errorCode的值进行判断，做跟详细的处理。
            if (failingUrl.startsWith("btn:refresh"))
                failingUrl = failingUrl.substring(11, failingUrl.length());
            view.loadUrl("file:///android_asset/neterror.html?failUrl=" + failingUrl);

        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
    }

    public class WebChromeClient extends android.webkit.WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                mProgressBar.setVisibility(GONE);
            } else {
                if (mProgressBar.getVisibility() == GONE)
                    mProgressBar.setVisibility(VISIBLE);
                mProgressBar.setProgress(newProgress);
            }
            super.onProgressChanged(view, newProgress);
        }
    }
    /**
     * 添加进度条
     */
    public void addProgressBar() {
        mProgressBar = new ProgressBar(getContext(), null,
                android.R.attr.progressBarStyleHorizontal);
        mProgressBar.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT, 5, 0, 0));
        mProgressBar.setProgressDrawable(getContext().getResources()
                .getDrawable(R.drawable.bg_pb_web_loading));
        addView(mProgressBar);//添加进度条至LoadingWebView中

        setWebChromeClient(new WebChromeClient());//设置setWebChromeClient对象
    }



    /**
     * 回收webview
     */
    public void destroyWebView() {
        clearCache(true);
        clearHistory();
    }
}
