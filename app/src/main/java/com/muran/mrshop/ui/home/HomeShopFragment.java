package com.muran.mrshop.ui.home;

import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.Query;
import com.couchbase.lite.UnsavedRevision;
import com.couchbase.lite.util.JSONUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.muran.mrshop.R;
import com.muran.mrshop.base.BaseFragment;
import com.muran.mrshop.data.Api;
import com.muran.mrshop.ui.LaunchActivity;
import com.muran.mrshop.ui.more.my.EditAddressActivity;
import com.muran.mrshop.utils.DeviceUtil;
import com.muran.mrshop.utils.MapToModel;
import com.muran.mrshop.utils.WebUrlUtil;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import butterknife.BindView;
import io.swagger.client.ApiException;
import io.swagger.client.api.RpApi;
import io.swagger.client.api.ShApi;
import io.swagger.client.model.GoodsCategory;
import io.swagger.client.model.GoodsInfo;
import io.swagger.client.model.ShInfoSettingVersion;
import io.swagger.client.model.ShippingAddress;
import io.swagger.client.model.SimpleGoodsInfo;
import io.swagger.client.model.VIPRPInfo;
import krelve.view.Kanner;
import krelve.view.KannerItemOnClickListener;
import lib.homhomlib.design.SlidingLayout;

/**
 * Created by Steven on 5/20/16.
 */
public class HomeShopFragment extends BaseFragment implements SlidingLayout.SlidingListener, ViewPager.OnClickListener, ListView.OnItemClickListener, ViewPager.OnPageChangeListener {
    @BindView(R.id.shopSlidingLayout)
    SlidingLayout slidingLayout;
    private String TAG = "SHOP";
    private int maxPullDelta = 0;
    TextView pullDownTextView;
    TextView pullUpTextView;

    private Database mDatabase = null;

    private enum State {
        NeedLoadMore,//需要加载更多
        NeedRefreshNew,//需要刷新
        LoadingMore,//正在加载更多
        RefreshingNew,//正在刷新数据
        Normal;//没有操作
    }

    private State downState = State.Normal;
    private State upState = State.Normal;

    private boolean updatebanner = false;
    private boolean updatecategory = false;

    @BindView(R.id.kanner)
    Kanner kanner;
    private CategoryAdapter mAdapter;
    @BindView(R.id.listView)
    com.muran.mrshop.utils.ScrollListView listView;
    private List<String> banners = new ArrayList<String>();
    private List<SimpleGoodsInfo> simpleInfos = new ArrayList<SimpleGoodsInfo>();
    private List<GoodsCategory> list = new ArrayList<GoodsCategory>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        maxPullDelta = DeviceUtil.dp2px(getActivity(), 30);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getUserInfo()!=null&&getUserInfo().getPerson()!=null)
            mDatabase = getDataCenter().getUserDatabase();
        else
        {
            getActivity().finish();
            getDataCenter().resetSession();
            getActivity().startActivity(new Intent(getActivity(), LaunchActivity.class));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflateContentView(inflater, R.layout.fragment_home_shop);
        slidingLayout.setSlidingListener(this);
        pullDownTextView = (TextView) slidingLayout.findViewById(R.id.pullDownTextView);
        pullUpTextView = (TextView) slidingLayout.findViewById(R.id.pullUpTextView);
//        getBanners();

        mAdapter = new CategoryAdapter();
        listView.setDivider(null);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(this);

        if (banners.isEmpty() || list.isEmpty()) {
            getShVersion();
        }
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        GoodsCategory category = (GoodsCategory) mAdapter.getItem(position);
        CategoryViewHodler holder = (CategoryViewHodler) view.getTag();
        String url = WebUrlUtil.getGoodsListByCategory(category.getAuId(), getCurrentSessioin().getId());
        goToCommonWebViewActivity(getActivity(), url, category.getTitle());
        getActivity().overridePendingTransition(R.anim.push_right_in,
                R.anim.push_left_out);
    }


    //初始化轮播图
    private void initKanner() {

        kanner.setImagesUrl(banners);
        kanner.setOnClickListener(new KannerItemOnClickListener() {
            @Override
            public void ItemOnClick() {
                Log.d(TAG, "onClick: item" + kanner.getCurrentItem());
                long id = simpleInfos.get(kanner.getCurrentItem() - 1).getAuId();
                String title = simpleInfos.get(kanner.getCurrentItem() - 1).getTitle();
                goToCommonWebViewActivity(getActivity(), WebUrlUtil.getGoodsDetailUrl(id, getCurrentSessioin().getId()), title);
            }
        });
    }

    //获取轮播图
    private void getBanners() {
        final ShApi shApi = getApp().getApi().shApi(getActivity());
        if (shApi == null)
            return;
        getApp().getApi().execute(getActivity(), new Api.ApiMethod<List<SimpleGoodsInfo>>() {
            @Override
            public List<SimpleGoodsInfo> api() throws ApiException {
                return shApi.shHomesettingGet();
            }
        }, new Api.ApiComplete<List<SimpleGoodsInfo>>() {
            @Override
            public void onComplete(List<SimpleGoodsInfo> result, ApiException ex) {
                if (result != null) {
                    for (int i = 0; i < result.size(); i++) {
                        SimpleGoodsInfo goodsInfo = result.get(i);
                        banners.add(getApp().IMG_DOMAIN + goodsInfo.getThumb());
                    }
                    simpleInfos = result;
                    bannersList();
                    initKanner();
                } else {

                }
            }
        });
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSlidingOffset(View view, float delta) {
        Logger.d("SlidingLayout: delta:" + delta);
        maxPullDelta = (int) Math.ceil(delta);
        if (downState == State.Normal && delta < 0) {//开始加载更多
            upState = State.NeedLoadMore;
            pullUpTextView.setText("加载中...");

        }
        if (upState == State.Normal && delta > 0) {//开始下拉刷新
            downState = State.NeedRefreshNew;
            pullDownTextView.setText("刷新中...");

        }
    }

    @Override
    public void onSlidingStateChange(View view, int state) {
        Logger.d("SlidingLayout: state:" + state);
        if (state == 1) {
            if (upState == State.NeedLoadMore) {
                loadMore();

            }
            if (downState == State.NeedRefreshNew) {
                refreshNew();
            }
        }
    }


    //加载更多
    private void loadMore() {
        final ShApi shApi = getApi().shApi(getActivity());
        if (shApi == null) return;
        upState = State.LoadingMore;
        getApi().execute(getActivity()
                , new Api.ApiMethod<List<GoodsCategory>>() {
                    @Override
                    public List<GoodsCategory> api() throws ApiException {
                        int lastSort = 0;
                        if (!list.isEmpty()) {
                            lastSort = list.get(list.size() - 1).getSort();
                        }
                        return shApi.shAppGoodsCategorysGet(lastSort, 5);
                    }
                }
                , new Api.ApiComplete<List<GoodsCategory>>() {
                    @Override
                    public void onComplete(List<GoodsCategory> result, ApiException ex) {
                        pullUpTextView.setText("上拉加载更多数据");
                        upState = State.Normal;
                        if (result != null && !result.isEmpty()) {
                            list.addAll(result);
                            mAdapter.notifyDataSetChanged();
                            int max = Math.min(result.size(), 1);
                            Log.d(TAG, "onComplete: size" + (list.size() - result.size() + max));
                            listView.smoothScrollToPositionFromTop(list.size() - result.size() + max, -maxPullDelta);
                            categoryList();

//                            listView.smoothScrollByOffset(-maxPullDelta);
                        }
                        if (ex != null) {
                            Toast.makeText(getActivity(), "加载更多失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    //获取是否更新分类或banners
    private void getShVersion() {
        final ShApi shApi = getApi().shApi(getActivity());
        if (shApi == null) return;
        getApi().execute(getActivity()
                , new Api.ApiMethod<ShInfoSettingVersion>() {
                    @Override
                    public ShInfoSettingVersion api() throws ApiException {
                        return shApi.shVersionGet();
                    }
                }
                , new Api.ApiComplete<ShInfoSettingVersion>() {
                    @Override
                    public void onComplete(ShInfoSettingVersion result, ApiException ex) {
                        if (result != null) {
                            saveVersion(result);
                        }
                    }
                });
    }

    //存储version
    private void saveVersion(ShInfoSettingVersion version) {
        getDataCenter().setDatabase(getDataCenter().getUserDatabase());
        String profileDocID = "pVersionId:" + getCurrentSessioin().getId();
        Document profile = mDatabase.getExistingDocument(profileDocID);
        final Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("pVersionId",getCurrentSessioin().getId());
        properties.put("type", "version");
        properties.put("bannerVersion", version.getHomeBannerSettingVersion());
        properties.put("categoryVersion", version.getGoodsCategoryVersion());
        if (profile == null) {
            try {
                profile=mDatabase.getDocument(profileDocID);
                profile.putProperties(properties);
                getBanners();
                loadMore();
            } catch (CouchbaseLiteException e) {
                com.couchbase.lite.util.Log.e(TAG, "Cannot create a new version", e);
            }
        } else {
            if (("version".equals(profile.getProperty("type")))) {
                Date bannerVer = new Date((long) profile.getProperty("bannerVersion"));
                Date categoryVer = new Date((long) profile.getProperty("categoryVersion"));
                Log.d(TAG, "saveVersion: " + bannerVer + version.getHomeBannerSettingVersion());
                if (categoryVer.before(version.getGoodsCategoryVersion())) {
                    updatecategory = true;
                    boolean b = categoryVer == version.getGoodsCategoryVersion();
                    Logger.d("list: state:" + b);
                    try {
                        profile = mDatabase.getDocument(profileDocID);
                        profile.update(new Document.DocumentUpdater() {
                            @Override
                            public boolean update(UnsavedRevision newRevision) {
                                newRevision.setProperties(properties);
                                try {
                                    newRevision.save(false);
                                } catch (CouchbaseLiteException e) {
                                    e.printStackTrace();
                                }
                                return false;
                            }
                        });
                    } catch (CouchbaseLiteException e) {
                        com.couchbase.lite.util.Log.e(TAG, "Cannot create a new version", e);
                    }
                    list.clear();
                    loadMore();
                } else {
                    String cId = "pCategoriesId:" + getCurrentSessioin().getId();
                    Document pCategory = mDatabase.getExistingDocument(cId);
                    if (pCategory != null && ("category".equals(pCategory.getProperty("type")))) {
                        List<GoodsCategory> dbList = (List<GoodsCategory>) pCategory.getProperty("categories");
                        for (int i = 0; i < dbList.size(); i++) {
                            GoodsCategory gc = (GoodsCategory) MapToModel.mapToObject(GoodsCategory.class, (Map<String, Object>) dbList.get(i));
                            list.add(gc);
                        }
                        Logger.d("list: state:" + pCategory + list.size() + pCategory.getProperty("categories"));
                        mAdapter.notifyDataSetChanged();
                        int max = Math.min(list.size(), 1);
                        Log.d(TAG, "onComplete: size" + (list.size() - list.size() + max));
                        listView.smoothScrollToPositionFromTop(list.size() - list.size() + max, -maxPullDelta);
                    }

                }
                if (bannerVer.before(version.getHomeBannerSettingVersion())) {
                    updatebanner = true;
                    try {
                        profile = mDatabase.getDocument(profileDocID);
                        profile.update(new Document.DocumentUpdater() {
                            @Override
                            public boolean update(UnsavedRevision newRevision) {
                                newRevision.setProperties(properties);
                                try {
                                    newRevision.save(false);
                                } catch (CouchbaseLiteException e) {
                                    e.printStackTrace();
                                }
                                return false;
                            }
                        });
                    } catch (CouchbaseLiteException e) {
                        com.couchbase.lite.util.Log.e(TAG, "Cannot create a new version", e);
                    }
                    banners.clear();
                    simpleInfos.clear();
                    getBanners();
                } else {
                    String bId = "pBannersId:" + getCurrentSessioin().getId();
                    Document pCategory = mDatabase.getExistingDocument(bId);
                    if (pCategory != null && ("banner".equals(pCategory.getProperty("type")))) {
                        List<SimpleGoodsInfo> sg = (List<SimpleGoodsInfo>) pCategory.getProperty("banners");
                        Logger.d("simpleInfos: state:" + simpleInfos);
                        for (int i = 0; i < sg.size(); i++) {
                            SimpleGoodsInfo goodsInfo = (SimpleGoodsInfo) MapToModel.mapToObject(SimpleGoodsInfo.class, (Map<String, Object>) sg.get(i));
                            simpleInfos.add(goodsInfo);
                            banners.add(getApp().IMG_DOMAIN + goodsInfo.getThumb());
                        }
                        initKanner();
                    }
                }
            }


        }
    }


    //存储banners
    private void bannersList() {
        getDataCenter().setDatabase(getDataCenter().getUserDatabase());
        String profileDocID = "pBannersId:" + getCurrentSessioin().getId();
        Document profile = mDatabase.getExistingDocument(profileDocID);
        final Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("type", "banner");
        properties.put("banners", simpleInfos);

        if (profile == null) {
            try {
                profile = mDatabase.getDocument(profileDocID);
                profile.putProperties(properties);

            } catch (CouchbaseLiteException e) {
                com.couchbase.lite.util.Log.e(TAG, "Cannot create a new category", e);
            }
        } else {
            try {
                profile = mDatabase.getDocument(profileDocID);
                profile.update(new Document.DocumentUpdater() {
                    @Override
                    public boolean update(UnsavedRevision newRevision) {

                        newRevision.setProperties(properties);
                        try {
                            newRevision.save(false);
                        } catch (CouchbaseLiteException e) {
                            e.printStackTrace();
                        }
                        return false;
                    }
                });

            } catch (CouchbaseLiteException e) {
                com.couchbase.lite.util.Log.e(TAG, "Cannot create a new category", e);
            }

        }
    }


    //存储分类
    private void categoryList() {
        getDataCenter().setDatabase(getDataCenter().getUserDatabase());
        String profileDocID = "pCategoriesId:" + getCurrentSessioin().getId();
        Document profile = mDatabase.getExistingDocument(profileDocID);
        final Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("type", "category");
        properties.put("categories", list);
        boolean b=profile==null;
        if (b) {
            try {
                profile = mDatabase.getDocument(profileDocID);
                profile.putProperties(properties);
                Log.d(TAG, "categoryList: "+list);
            } catch (CouchbaseLiteException e) {
                com.couchbase.lite.util.Log.e(TAG, "Cannot create a new category", e);
            }
        } else {
            try {
                profile = mDatabase.getDocument(profileDocID);
                profile.update(new Document.DocumentUpdater() {
                    @Override
                    public boolean update(UnsavedRevision newRevision) {
                        newRevision.setProperties(properties);
                        try {
                            Log.d(TAG, "update: "+properties);
                            newRevision.save(false);
                        } catch (CouchbaseLiteException e) {
                            e.printStackTrace();
                        }
                        return false;
                    }
                });
            } catch (CouchbaseLiteException e) {
                com.couchbase.lite.util.Log.e(TAG, "Cannot create a new category", e);
            }

        }
    }


    //下啦刷新
    private void refreshNew() {

    }

    @Override
    public void onSlidingChangePointer(View view, int pointerId) {

    }

    public class CategoryAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            GoodsCategory goodsCategory = list.get(position);
            return goodsCategory.getAuId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CategoryViewHodler holder = null;
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            convertView = inflater.inflate(R.layout.item_category_list, null);
            holder = new CategoryViewHodler();
            convertView.setTag(holder);
            holder.imgThumb = (ImageView) convertView.findViewById(R.id.img_thumb);
            holder.name = (TextView) convertView.findViewById(R.id.tv_category_name);
            holder.subName = (TextView) convertView.findViewById(R.id.tv_category_subTitle);
            holder.startMoney = (TextView) convertView.findViewById(R.id.tv_start_money);

            GoodsCategory category = list.get(position);
            loadImgToView(getApp().IMG_DOMAIN + category.getThumb(), holder.imgThumb);
            holder.name.setText(category.getTitle());
            holder.subName.setText(category.getSubTitle());
            holder.startMoney.setText(category.getStartPrice() + "元起");

            return convertView;
        }
    }

    private class CategoryViewHodler {
        public ImageView imgThumb;
        public TextView name, subName, startMoney;
    }
}
















