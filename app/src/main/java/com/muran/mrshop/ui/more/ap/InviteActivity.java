package com.muran.mrshop.ui.more.ap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.muran.mrshop.R;
import com.muran.mrshop.base.IMuranComponent;
import com.muran.mrshop.ui.CommonWebViewActivity;

import butterknife.BindView;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by Steven on 6/22/16.
 */
public class InviteActivity extends CommonWebViewActivity implements View.OnClickListener {


    @BindView(R.id.inviteBtn)
    Button inviteBtn;

    protected int getContentViewId() {
        return R.layout.activity_ap_invite;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showActionBar("邀请成员");
        inviteBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String title = "秒享|社交媒体新营销平台";
        String des = "免费发布广告到朋友圈、Qzone、新浪微博等各大社交媒体，邀请朋友一起做推广，中小企业推广利器。";
        String url = getIntent().getStringExtra("url");
        String thumb = "http://img.miaox.top/mx_logo.png";
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(title);
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl(url);
        // text是分享文本，所有平台都需要这个字段
        oks.setText(des);
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(url);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment(des);
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://miaox.top");
        oks.setImageUrl(thumb);
        String[] imgsArray = new String[]{thumb};
        oks.setImageArray(imgsArray);
        // 启动分享GUI
        oks.show(this);
    }

    public static void goToInvitePage(Context context, IMuranComponent component) {
        Bundle bundle = new Bundle();
        bundle.putString("url", "http://miaox.top/v140/miaox/invite_member/" + component.getDataCenter().getCurrentSession().getUserInfo().getPerson().getUsId());
        Intent intent = new Intent(context, InviteActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

}
