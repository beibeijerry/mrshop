package com.muran.mrshop.ui.more.userinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.muran.mrshop.base.BaseActivity;
import com.muran.mrshop.R;
import com.muran.mrshop.data.Api;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.orhanobut.logger.Logger;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;

import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;
import io.swagger.client.ApiException;
import io.swagger.client.api.UsApi;

/**
 * Created by Steven on 5/24/16.
 */
public class UserInfoSettingActivity extends BaseActivity implements View.OnClickListener, GalleryFinal.OnHanlderResultCallback, OnItemClickListener {

    private static final int REQUEST_CODE_TAKE_PHOTO = 1;
    private static final int REQUEST_CODE_GALLERY = 2;
    private static final int REQUEST_CODE_CROP_IMG = 3;
    @BindView(R.id.imageSettingImageView)
    ImageView imageSettingImageView;
    @BindView(R.id.imageSettingBtn)
    Button imageSettingBtn;
    @BindView(R.id.mobile)
    TextView mobile;
    @BindView(R.id.name)
    EditText name;

    DialogPlus dialogPlus;
    @BindView(R.id.scrollView)
    ScrollView scrollView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo_setting);
        showActionBar("设置用户信息");

        dialogPlus = DialogPlus.newDialog(this).setAdapter(new DialogAdapter()).setOnItemClickListener(this)
                .setExpanded(false).setCancelable(true).setHeader(R.layout.view_selectpic_header).create();


        mobile.setText("账户：" + getUserInfo().getPerson().getMobile());
        name.setText(getUserInfo().getPerson().getName());
        imageSettingImageView.setClickable(false);
        if (getUserInfo().getPerson().getAvatar() != null)
            loadImgToView(getUserInfo().getPerson().getAvatar(), imageSettingImageView);
        imageSettingBtn.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.userinfo_setting_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.save) {
            if (name.getText() == null) {
                shake(name);
                return true;
            }
            final UsApi usApi = getApi().usApi(UserInfoSettingActivity.this);
            if (usApi == null) return true;
            getApi().execute(UserInfoSettingActivity.this,
                    new Api.ApiMethod<Object>() {
                        @Override
                        public Object api() throws ApiException {
//                            UpdateUser updateUser = new UpdateUser();
//                            updateUser.setUsId(getUserInfo().getAuId());
//                            updateUser.setAvatar(getUserInfo().getAvatar());
//                            updateUser.setName(name.getText().toString());
//                            updateUser.setMobile(getUserInfo().getMobile());
//                            usApi.updateUserInfo(updateUser);
                            return new Object();
                        }
                    },
                    new Api.ApiComplete<Object>() {
                        @Override
                        public void onComplete(Object result, ApiException ex) {
                            if (result != null) {
                                getUserInfo().getPerson().setName(name.getText().toString());
                                getDataCenter().persistSession();
                                UserInfoSettingActivity.this.finish();
                            }
                        }
                    },
                    true, "更新用户", "成功", "失败"

            );
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        dialogPlus.show();
    }

    /**
     * 处理成功
     *
     * @param reqeustCode
     * @param resultList
     */
    @Override
    public void onHanlderSuccess(final int reqeustCode, List<PhotoInfo> resultList) {
        final PhotoInfo photo = resultList.get(0);
        switch (reqeustCode) {
            case REQUEST_CODE_TAKE_PHOTO:
            case REQUEST_CODE_GALLERY:
                FunctionConfig functionConfig = new FunctionConfig.Builder().setEnableCamera(true)
                        .setEnableEdit(false).setEnableCrop(true).setCropWidth(120).setCropHeight(120).setCropSquare(true).build();
                GalleryFinal.openCrop(REQUEST_CODE_CROP_IMG, functionConfig, photo.getPhotoPath(), this);
                break;
            case REQUEST_CODE_CROP_IMG://获取上传token,上传文件，更新用户数据。
//                final SysApi sysApi = getApi().sysApi(this);
//                getHud().showWithStatus("更新头像");
//                getApi().execute(this,
//                        new Api.ApiMethod<UploadFileToken>() {
//                            @Override
//                            public UploadFileToken api() throws ApiException {
//                                Logger.d("获取上传token");
//                                return sysApi.getUploadFileToken(0, 0, null);
//                            }
//                        },
//                        new Api.ApiComplete<UploadFileToken>() {
//                            @Override
//                            public void onComplete(final UploadFileToken result, ApiException ex) {
//                                Logger.d("获取上传token：" + result.getKey());
//                                if (result != null) {
//                                    Logger.d("上传文件");
//                                    UploadManager uploadManager = new UploadManager(new Configuration.Builder().build());
//                                    getHud().showWithStatus("上传文件");
//                                    uploadManager.put(photo.getPhotoPath(), result.getKey(), result.getToken(), new UpCompletionHandler() {
//                                        @Override
//                                        public void complete(final String key, ResponseInfo info, final JSONObject response) {
//                                            Logger.d("上传结束");
//                                            if (info.isOK()) {
//                                                Logger.d("更新用户数据。");
//                                                final UsApi usApi = getApi().usApi(UserInfoSettingActivity.this);
//                                                getApi().execute(UserInfoSettingActivity.this,
//                                                        new Api.ApiMethod<Object>() {
//                                                            @Override
//                                                            public Object api() throws ApiException {
//                                                                UpdateUser updateUser = new UpdateUser();
//                                                                updateUser.setUsId(getUserInfo().getAuId());
//                                                                updateUser.setAvatar(key);
//                                                                updateUser.setName(getUserInfo().getName());
//                                                                updateUser.setMobile(getUserInfo().getMobile());
//                                                                usApi.updateUserInfo(updateUser);
//                                                                return new Object();
//                                                            }
//                                                        },
//                                                        new Api.ApiComplete<Object>() {
//                                                            @Override
//                                                            public void onComplete(Object result, ApiException ex) {
//                                                                if (result != null) {
//                                                                    getHud().showSuccessWithStatus("更新成功");
//                                                                    getUserInfo().setAvatar(key);
//                                                                    getDataCenter().persistSession();
//                                                                    loadImgToView(getUserInfo().getAvatar(), imageSettingImageView);
//                                                                } else {
//                                                                    getHud().showErrorWithStatus("更新失败");
//                                                                }
//                                                            }
//                                                        }
//
//                                                );
//                                            } else {
//                                                getHud().showErrorWithStatus("上传失败");
//                                            }
//                                        }
//                                    }, null);
//
//
//                                } else {
//                                    getHud().showErrorWithStatus("授权失败");
//                                }
//                            }
//                        });
//                break;
        }
    }

    /**
     * 处理失败或异常
     *
     * @param requestCode
     * @param errorMsg
     */
    @Override
    public void onHanlderFailure(int requestCode, String errorMsg) {
        getHud().showErrorWithStatus(errorMsg);
    }

    @Override
    public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
        dialogPlus.dismiss();
        switch (position) {
            case 0://拍照
                GalleryFinal.openCamera(REQUEST_CODE_TAKE_PHOTO, this);
                break;
            case 1://相册
                GalleryFinal.openGallerySingle(REQUEST_CODE_GALLERY, this);
                break;
        }
    }


    private class DialogAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object getItem(int position) {
            String title = null;
            switch (position) {
                case 0:
                    title = "拍照";
                    break;
                case 1:
                    title = "相册";
                    break;
                case 2:
                    title = "取消";
            }
            return title;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(UserInfoSettingActivity.this).inflate(R.layout.item_menu_select_pic, null);
            TextView tv = (TextView) view.findViewById(R.id.textView);
            String title = (String) getItem(position);
            tv.setText(title);
            if (title.equals("取消")) tv.setTextColor(getResources().getColor(R.color.red));
            else tv.setTextColor(getResources().getColor(R.color.themeColor));
            return view;
        }
    }

}
