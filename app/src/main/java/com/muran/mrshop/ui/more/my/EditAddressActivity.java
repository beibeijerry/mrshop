package com.muran.mrshop.ui.more.my;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.muran.mrshop.R;
import com.muran.mrshop.base.BaseActivity;
import com.muran.mrshop.data.Api;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.swagger.client.ApiException;
import io.swagger.client.api.ShApi;
import io.swagger.client.api.SysApi;
import io.swagger.client.model.AddOrUpdateShippingAddress;
import io.swagger.client.model.Area;
import io.swagger.client.model.GeneralString;
import io.swagger.client.model.ShippingAddress;

public class EditAddressActivity extends BaseActivity {

    @BindView(R.id.ll_area_select)
    LinearLayout areaSelect;
    OptionsPickerView pvOptions;
    @BindView(R.id.edit_address)
    TextView address;
    @BindView(R.id.vMasker)
    View vMasker;
    @BindView(R.id.img_btn_back)
    LinearLayout btnBack;
    @BindView(R.id.tv_title_header)
    TextView title;
    @BindView(R.id.btn_delete_address)
    Button btnDelete;
    @BindView(R.id.btn_save_address)
    Button btnSave;
    @BindView(R.id.tv_receiver)
    EditText edReceiver;
    @BindView(R.id.tv_receiver_phone)
    EditText edReceiverPhone;
    @BindView(R.id.edit_postcode)
    EditText edPostcode;
    @BindView(R.id.edit_detail_address)
    EditText edDetailAddress;

    private ArrayList<Area> options1Items = new ArrayList<Area>();
    private ArrayList<ArrayList<Area>> options2Items = new ArrayList<ArrayList<Area>>();
    private ArrayList<ArrayList<ArrayList<Area>>> options3Items = new ArrayList<ArrayList<ArrayList<Area>>>();
    private boolean operate = false;
    private long addressId = 0;
    private List<Area> allArea = new ArrayList<Area>();
    private ShippingAddress addressModel = new ShippingAddress();
    private String provinceCode="";
    private String cityCode="";
    private String areaCode="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_address);
        hideActionBar();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.back_left_in,
                        R.anim.back_right_out);
            }
        });
        operate = getIntent().getBooleanExtra("operate", false);
        addressId = getIntent().getLongExtra("addressId", 0);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //删除地址
               dialog();
            }
        });
        if (operate) {
            title.setText("修改地址");
            btnDelete.setVisibility(View.VISIBLE);
            getAddressById();
        } else {
            title.setText("新增地址");
            btnDelete.setVisibility(View.GONE);
            getAllArea();
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setReceiverName(edReceiver.getText().toString().trim());
                model.setReceiverPhone(edReceiverPhone.getText().toString().trim());
                model.setAddress(address.getText().toString().trim());
                model.setDetailAddress(edDetailAddress.getText().toString().trim());
                model.setPostcode(edPostcode.getText().toString().trim());
                model.setProvinceCode(provinceCode);
                model.setCityCode(cityCode);
                model.setAreaCode(areaCode);
                //新增修改地址
                if (operate) {
                    //修改
                    editAddress();
                } else {
                    //新增
                    insertAddress();
                }
            }
        });

    }
    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(EditAddressActivity.this);
        builder.setMessage("确认删除吗？");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                deleteAddress();

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
    //删除地址
    private void deleteAddress() {
        final ShApi shApi = getApp().getApi().shApi(this);
        if (shApi == null)
            return;
        getApp().getApi().execute(this, new Api.ApiMethod<GeneralString >() {
            @Override
            public GeneralString  api() throws ApiException {
                return shApi.shAppShippingaddressAddressIdDelete(addressId);
            }
        }, new Api.ApiComplete<GeneralString >() {
            @Override
            public void onComplete(GeneralString  result, ApiException ex) {
                if (result != null) {
                    finish();
                    overridePendingTransition(R.anim.back_left_in,
                            R.anim.back_right_out);
                } else {

                }
            }
        });
    }

    //修改地址
    private void editAddress() {
        final ShApi shApi = getApp().getApi().shApi(this);
        if (shApi == null)
            return;
        getApp().getApi().execute(this, new Api.ApiMethod<ShippingAddress>() {
            @Override
            public ShippingAddress api() throws ApiException {
                return shApi.shAppShippingaddressAddressIdPut(addressId, model);
            }
        }, new Api.ApiComplete<ShippingAddress>() {
            @Override
            public void onComplete(ShippingAddress result, ApiException ex) {
                if (result != null) {
                    finish();
                    overridePendingTransition(R.anim.back_left_in,
                            R.anim.back_right_out);
                } else {

                }
            }
        });
    }

    //根据id获取地址
    private void getAddressById() {
        final ShApi shApi = getApp().getApi().shApi(this);
        if (shApi == null)
            return;
        getApp().getApi().execute(this, new Api.ApiMethod<ShippingAddress>() {
            @Override
            public ShippingAddress api() throws ApiException {
                return shApi.shAppShippingaddressAddressIdGet(addressId);
            }
        }, new Api.ApiComplete<ShippingAddress>() {
            @Override
            public void onComplete(ShippingAddress result, ApiException ex) {
                if (result != null) {
                    addressModel = result;
                    address.setText(result.getAddress());
                    edDetailAddress.setText(result.getDetailAddress());
                    edPostcode.setText(result.getPostcode());
                    edReceiver.setText(result.getReceiverName());
                    edReceiverPhone.setText(result.getReceiverPhone());
                    provinceCode=result.getProvinceCode();
                    cityCode=result.getCityCode();
                    areaCode=result.getAreaCode();
                    getAllArea();
                } else {

                }
            }
        });
    }

    //获取区域信息
    private void getAllArea() {
        final SysApi sysApi = getApp().getApi().sysApi(this);
        if (sysApi == null)
            return;
        getApp().getApi().execute(this, new Api.ApiMethod<List<Area>>() {
            @Override
            public List<Area> api() throws ApiException {
                return sysApi.getAreas(null, true);
            }
        }, new Api.ApiComplete<List<Area>>() {
            @Override
            public void onComplete(List<Area> result, ApiException ex) {
                if (result != null) {
                    allArea = result;
                    initPvOptions();
                } else {

                }
            }
        });
    }

    //区域选择器
    private void initPvOptions() {
        //选项选择器
        pvOptions = new OptionsPickerView(this);
        int item1position=0;
        int item2position=0;
        int item3position=0;
        for (int i=0;i<allArea.size();i++) {
            Area area=allArea.get(i);
            if (area.getCode().equals(provinceCode))
            {
                item1position=i;
            }
            options1Items.add(area);
        }
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager)EditAddressActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                pvOptions.show();
            }
        });
        if (options1Items != null && options1Items.size() > 0) {
            for (Area area1 : options1Items) {
                ArrayList<Area> options2Items_01 = new ArrayList<Area>();
                if (area1.getChildren() != null) {
                    for (int i=0;i<area1.getChildren().size();i++)
                    {
                        Area child=area1.getChildren().get(i);
                        if (child.getCode().equals(provinceCode))
                        {
                            item2position=i;
                        }
                        options2Items_01.add(child);
                    }
                    options2Items.add(options2Items_01);
                }
            }
        }
        if (options2Items != null && options2Items.size() > 0) {
            for (ArrayList<Area> area2List : options2Items) {
                ArrayList<ArrayList<Area>> options3Items_01 = new ArrayList<>();
                for (Area child2 : area2List) {
                    if (child2.getChildren() != null) {
                        ArrayList<Area> options3Items_01_01 = new ArrayList<Area>();
                        for (int i=0;i<child2.getChildren().size();i++)
                        {
                            Area child=child2.getChildren().get(i);
                            if (child.getCode().equals(provinceCode))
                            {
                                item3position=i;
                            }
                            options3Items_01_01.add(child);
                        }
                        options3Items_01.add(options3Items_01_01);
                    }
                }
                options3Items.add(options3Items_01);
            }
        }
        //三级联动效果
        pvOptions.setPicker(options1Items, options2Items, options3Items, true);
        //设置选择的三级单位
//        pvOptions.setLabels("省", "市", "区");
        pvOptions.setTitle("选择城市");
        pvOptions.setCyclic(false, false, false);
        //设置默认选中的三级项目
        //监听确定选择按钮
        Log.d("Tag","initPvOptions: "+item1position+item2position+item3position);
        pvOptions.setSelectOptions(item1position, item2position,item3position);
        pvOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {

            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1).getPickerViewText() + " "
                        + options2Items.get(options1).get(option2).getPickerViewText() + " "
                        + options3Items.get(options1).get(option2).get(options3).getPickerViewText();
                address.setText(tx);
                provinceCode=options1Items.get(options1).getCode();
                cityCode=options2Items.get(options1).get(option2).getCode();
                areaCode=options3Items.get(options1).get(option2).get(options3).getCode();
                vMasker.setVisibility(View.GONE);
            }
        });

    }

    private AddOrUpdateShippingAddress model = new AddOrUpdateShippingAddress();

    //新增收货地址
    private void insertAddress() {
        final ShApi shApi = getApp().getApi().shApi(this);
        if (shApi == null)
            return;
        getApp().getApi().execute(this, new Api.ApiMethod<ShippingAddress>() {
            @Override
            public ShippingAddress api() throws ApiException {
                return shApi.shAppShippingaddressPost(model);
            }
        }, new Api.ApiComplete<ShippingAddress>() {
            @Override
            public void onComplete(ShippingAddress result, ApiException ex) {
                if (result != null) {
                    finish();
                    overridePendingTransition(R.anim.back_left_in,
                            R.anim.back_right_out);
                } else {

                }
            }
        });
    }
}
