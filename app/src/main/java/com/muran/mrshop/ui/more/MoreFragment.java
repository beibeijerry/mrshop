package com.muran.mrshop.ui.more;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.muran.mrshop.R;
import com.muran.mrshop.base.BaseFragment;
import com.muran.mrshop.ui.LoginActivity;
import com.muran.mrshop.ui.more.ap.ApActivity;
import com.muran.mrshop.ui.more.userinfo.UserInfoSettingActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Steven on 5/20/16.
 */
public class MoreFragment extends BaseFragment implements View.OnClickListener {


    @BindView(R.id.avatar)
    ImageView avatarImg;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.mobile)
    TextView mobile;
    @BindView(R.id.userInfoBtn)
    LinearLayout userInfoBtn;
    @BindView(R.id.adSettingBtn)
    LinearLayout adSettingBtn;
    @BindView(R.id.aboutBtn)
    LinearLayout aboutBtn;
    @BindView(R.id.loginoutBtn)
    Button loginoutBtn;
    @BindView(R.id.promoteBtn)
    LinearLayout promoteBtn;
    @BindView(R.id.activateBtn)
    LinearLayout activateBtn;
    @BindView(R.id.accountsBtn)
    LinearLayout accountsBtn;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.chargeBtn)
    LinearLayout chargeBtn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflateContentView(inflater, R.layout.fragment_more);
        loginoutBtn.setOnClickListener(this);
        aboutBtn.setOnClickListener(this);
        adSettingBtn.setOnClickListener(this);
        userInfoBtn.setOnClickListener(this);
        chargeBtn.setOnClickListener(this);
        promoteBtn.setOnClickListener(this);
        accountsBtn.setOnClickListener(this);
        activateBtn.setOnClickListener(this);
        ButterKnife.bind(this, view);
        return view;
    }

    public void onStart() {
        super.onStart();
        mobile.setText(getUserInfo().getPerson().getMobile());
        name.setText(getUserInfo().getPerson().getName());
        if (getUserInfo().getPerson().getAvatar() != null)
            Glide.with(this).load(getApi().getImgUrl(getUserInfo().getPerson().getAvatar())).into(avatarImg);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginoutBtn:
                getDataCenter().clearData();
                this.getActivity().finish();
                getActivity().startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.userInfoBtn:
                getActivity().startActivity(new Intent(getActivity(), UserInfoSettingActivity.class));
                break;
            case R.id.aboutBtn:
                goToCommonWebViewActivity(getActivity(), "http://miaox.top/v140/pages/about", "关于");
                break;
            case R.id.adSettingBtn:
//                getActivity().startActivity(new Intent(getActivity(), AdSettingActivity.class));
                break;
            case R.id.chargeBtn://付费推广
                goToCommonWebViewActivity(getActivity(), "http://miaox.top/v140/pages/pay_for_promotion", "付费推广");
                break;
            case R.id.promoteBtn:
                getActivity().startActivity(new Intent(getActivity(), ApActivity.class));
                break;
            case R.id.activateBtn:
                goToCommonWebViewActivity(getActivity(), "http://miaox.top/v140/miaox/activation", "激活账户");
                break;
            case R.id.accountsBtn:
//                AdAccountListActivity.goToAdAccountListPage(getActivity());
                break;
        }
    }
}
