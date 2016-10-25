package com.muran.mrshop.data;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;

import com.alibaba.fastjson.JSON;
import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.DatabaseOptions;
import com.couchbase.lite.Document;
import com.couchbase.lite.Emitter;
import com.couchbase.lite.Manager;
import com.couchbase.lite.Mapper;
import com.couchbase.lite.UnsavedRevision;
import com.couchbase.lite.View;
import com.couchbase.lite.android.AndroidContext;
import com.couchbase.lite.auth.AuthenticatorFactory;
import com.couchbase.lite.util.Log;
import com.muran.mrshop.utils.ACache;
import com.muran.mrshop.utils.BitmapUtil;
import com.muran.mrshop.utils.GlideImageLoader;
import com.muran.mrshop.utils.MapToModel;


import net.qiujuer.genius.blur.StackBlur;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import io.swagger.client.model.GoodsCategory;
import io.swagger.client.model.UserAccountInfo;
import io.swagger.client.model.UserInfo;
import io.swagger.client.model.VIPRPInfo;

/**
 * Created by Steven on 5/20/16.
 */
public class DataCenter {

    private static final String TAG = "DataCenter";
    private Context context;
    private static DataCenter instance;
//    ACache cache = null;
    private static final String STORAGE_TYPE = Manager.SQLITE_STORAGE;
    private static final boolean ENCRYPTION_ENABLED = false;
    private static final String ENCRYPTION_KEY = "seekrit";
    private Manager mManager;
    private Database mDatabase;

    public static DataCenter getDataCenter(Context context) {
        if (instance == null)
            instance = new DataCenter(context);
        return instance;
    }

    private Session session=new Session();

    private DataCenter(Context context) {
        this.context = context;
//        cache = ACache.get(context);
    }

    private Manager getManager() {
        if (mManager == null) {
            try {
                AndroidContext aContext = new AndroidContext(context);
                mManager = new Manager(aContext, Manager.DEFAULT_OPTIONS);
            } catch (Exception e) {
                Log.e(TAG, "Cannot create Manager object", e);
            }
        }
        return mManager;
    }

    public Database getDatabase() {
        return mDatabase;
    }

    public void setDatabase(Database database) {
        this.mDatabase = database;
    }

    public Database getUserDatabase() {

        try {
            String dbName = "dbmrshop";
            DatabaseOptions options = new DatabaseOptions();
            options.setCreate(true);
            options.setStorageType(STORAGE_TYPE);
            options.setEncryptionKey(ENCRYPTION_ENABLED ? ENCRYPTION_KEY : null);
            return getManager().openDatabase(dbName, options);
        } catch (CouchbaseLiteException e) {
            Log.e(TAG, "Cannot create database for name: " , e);
        }
        return null;
    }


    public Session getCurrentSession() {
        return session;
    }

    public void readSession() {
//        session = (Session) cache.getAsObject("session");
            String profileDocID = "sessionId" ;
            Document doc = mDatabase.getDocument(profileDocID);
            session.setId((String)doc.getProperty("sid"));
            session.setUserInfo((UserInfo) MapToModel.mapToObject(UserInfo.class,(Map<String, Object>) doc.getProperty("userinfo")));
            session.setUserAccountInfo((UserAccountInfo)MapToModel.mapToObject(UserAccountInfo.class,(Map<String, Object>) doc.getProperty("useracinfo")));
            session.setBindMobile(doc.getProperty("isbindmobile")==null?false:(boolean)doc.getProperty("isbindmobile"));
            android.util.Log.d(TAG, "readSession: "+session.getId()+session);

    }

    public void updateSession(Session session) {
        this.session = session;
        persistSession();
    }

    public void resetSession() {
        session.setId(null);
        session.setUserInfo(null);
        session.setBindMobile(false);
        session.setUserAccountInfo(null);
        persistSession();
    }

    public void persistSession() {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                cache.put("session", session);
                String profileDocID = "sessionId" ;
                Document profile = mDatabase.getExistingDocument(profileDocID);
                if (profile == null) {
                    Map<String, Object> properties = new HashMap<String, Object>();
                    properties.put("type", "session");
                    properties.put("sid", session.getId());
                    properties.put("userinfo",session.getUserInfo());
                    properties.put("useracinfo",session.getUserAccountInfo());
                    properties.put("isbindmobile",session.isBindMobile());
                    profile = mDatabase.getDocument(profileDocID);
                    try {
                        profile.putProperties(properties);
                    } catch (CouchbaseLiteException e) {
                        e.printStackTrace();
                    }
                    android.util.Log.d(TAG, "run: new");
                }else {
                    try {
                        profile.update(new Document.DocumentUpdater() {
                            @Override
                            public boolean update(UnsavedRevision newRevision) {
                                Map<String, Object> properties = newRevision.getUserProperties();
                                properties.put("type", session);
                                properties.put("sid", session.getId());
                                properties.put("userinfo",session.getUserInfo());
                                properties.put("useracinfo",session.getUserAccountInfo());
                                properties.put("isbindmobile",session.isBindMobile());
                                newRevision.setUserProperties(properties);
                                return true;
                            }
                        });
                    } catch (CouchbaseLiteException e) {
                        e.printStackTrace();
                    }
                    android.util.Log.d(TAG, "run: update");
                }
            }
        }).start();
    }






    public void clearData() {
        resetSession();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mDatabase.delete();
                } catch (CouchbaseLiteException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    //获取订单状态
    public List<OrderStatus> getOrderStatus() {
        List<OrderStatus> list = new ArrayList<OrderStatus>();
        list.add(new OrderStatus(0, "待付款"));
        list.add(new OrderStatus(1, "待发货"));
        list.add(new OrderStatus(2, "已发货"));
        list.add(new OrderStatus(3, "待评价"));
        list.add(new OrderStatus(4, "已完毕"));
        list.add(new OrderStatus(5, "关闭"));

        return list;

    }
}
