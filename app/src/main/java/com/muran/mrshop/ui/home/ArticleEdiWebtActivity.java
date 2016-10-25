package com.muran.mrshop.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.muran.mrshop.R;
import com.muran.mrshop.base.IMuranComponent;
import com.muran.mrshop.ui.CommonWebViewActivity;

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by Steven on 6/7/16.
 */
public class ArticleEdiWebtActivity extends CommonWebViewActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showActionBar("");
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        } else if (id == R.id.share) {
//            String shareUrl = getApi().getShareUrlForArticle(getUserInfo().getAuId(), getIntent().getStringExtra("tinyKey"));
            OnekeyShare oks = new OnekeyShare();
            //关闭sso授权
            oks.disableSSOWhenAuthorize();
            // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
            //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
            // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
            oks.setTitle(getIntent().getStringExtra("title"));
            // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
//            oks.setTitleUrl(shareUrl);
            // text是分享文本，所有平台都需要这个字段
            oks.setText(getIntent().getStringExtra("desc"));
            // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
            //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
            // url仅在微信（包括好友和朋友圈）中使用
//            oks.setUrl(shareUrl);
            // comment是我对这条分享的评论，仅在人人网和QQ空间使用
            oks.setComment(getIntent().getStringExtra("desc"));
            // site是分享此内容的网站名称，仅在QQ空间使用
            oks.setSite(getString(R.string.app_name));
            // siteUrl是分享此内容的网站地址，仅在QQ空间使用
            oks.setSiteUrl("http://miaox.top");
            oks.setImageUrl(getIntent().getStringExtra("thumb"));
            String[] imgsArray = new String[]{getIntent().getStringExtra("thumb")};
            oks.setImageArray(imgsArray);
            // 启动分享GUI
            oks.show(this);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.article_edite_activity, menu);
        return true;
    }


//    public static void goToArticleEditPage(Context context, IMuranComponent component, ArticleInfo article) {
//        Bundle bundle = new Bundle();
//        bundle.putString("desc", article.getDescription());
//        bundle.putString("thumb", component.getApi().getImgUrl(article.getThumb()));
//        bundle.putString("title", article.getTitle());
//        bundle.putString("tinyKey", article.getTinyKey());
//        bundle.putString("url", component.getApi().getArticleEditPageUrl(article.getTinyKey()));
//        Intent intent = new Intent(context, ArticleEdiWebtActivity.class);
//        intent.putExtras(bundle);
//        context.startActivity(intent);
//    }
}
