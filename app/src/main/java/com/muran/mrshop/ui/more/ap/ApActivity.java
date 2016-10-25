package com.muran.mrshop.ui.more.ap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.muran.mrshop.R;
import com.muran.mrshop.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Steven on 6/8/16.
 */
public class ApActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.inviteBtn)
    LinearLayout inviteBtn;
    @BindView(R.id.myTeamBtn)
    LinearLayout myTeamBtn;
    @BindView(R.id.inviteGiftRuleBtn)
    LinearLayout inviteGiftRuleBtn;
    @BindView(R.id.helpBtn)
    LinearLayout helpBtn;
    @BindView(R.id.showCountTextView)
    TextView showCountTextView;
    @BindView(R.id.teamCountTextView)
    TextView teamCountTextView;
    @BindView(R.id.apAdBtn)
    LinearLayout apAdBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ap);
        ButterKnife.bind(this);
        showActionBar("众推");
        apAdBtn.setOnClickListener(this);
        inviteBtn.setOnClickListener(this);
        myTeamBtn.setOnClickListener(this);
        inviteGiftRuleBtn.setOnClickListener(this);
        helpBtn.setOnClickListener(this);
        showCountTextView.setText("...");
        teamCountTextView.setText("...");
    }

    @Override
    public void onStart() {
        super.onStart();
//        final MpApi api = getApi().mpApi(this);
//        if (api == null) return;
//        getApi().execute(this, new Api.ApiMethod<TeamPromotionInfo>() {
//            @Override
//            public TeamPromotionInfo api() throws ApiException {
//                return api.getTeamRelatedInfo();
//            }
//        }, new Api.ApiComplete<TeamPromotionInfo>() {
//
//            @Override
//            public void onComplete(TeamPromotionInfo result, ApiException ex) {
//                if (result != null) {
//                    showCountTextView.setText(result.getMembers()+"");
//                    teamCountTextView.setText(result.getRead() + "");
//                }
//            }
//        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.inviteBtn:
                InviteActivity.goToInvitePage(this, this);
                break;
            case R.id.myTeamBtn:
                goToCommonWebViewActivity(this, "http://miaox.top/v140/miaox/team_member", "我的团队成员");
                break;
            case R.id.inviteGiftRuleBtn:
                goToCommonWebViewActivity(this, "http://miaox.top/v140/miaox/invite_intro", "邀请规则");
                break;
            case R.id.helpBtn:
                goToCommonWebViewActivity(this, "http://linkms/v140/pages/public_push_help", "众推帮助");
                break;
            case R.id.apAdBtn:
//                Intent intent = new Intent(this, AdSettingActivity.class);
//                intent.putExtra("ad_type", 1);
//                this.startActivity(intent);
                break;
        }


    }


}
