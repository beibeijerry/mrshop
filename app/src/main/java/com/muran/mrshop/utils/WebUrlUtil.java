package com.muran.mrshop.utils;

import com.muran.mrshop.common.Conf;

/**
 * Created by Administrator on 2016/9/6.
 */
public class WebUrlUtil {
//        public final static String WEB_DOMAIN="http://wx.mxlg369.com/";
    public final static String WEB_DOMAIN = Conf.WEB_DOMAIN;

    private final static String footerUrl="&m=app";
    private static String getFooterUrl(String sId)
    {
        return "s="+sId+footerUrl;
    }
    //商品详情
    public static String getGoodsDetailUrl(long id, String sessionId) {
        return WEB_DOMAIN + "shop/?#!/shop/home/goods/" + id + "?"+getFooterUrl(sessionId);
    }

    //分类下，商品列表
    public static String getGoodsListByCategory(long categoryId, String sessionId) {
        return WEB_DOMAIN + "shop/#!/shop/home/cate/" + categoryId + "?"+getFooterUrl(sessionId);
    }

    //红包排名
    public static String getRpBankUrl(String sessionId) {
        return WEB_DOMAIN + "uc/?#!/uc/ranking?"+getFooterUrl(sessionId);
    }

    //我的账单
    public static String getMyOrderUrl(String sessionId) {
        return WEB_DOMAIN + "uc/#!/uc/bill?"+getFooterUrl(sessionId);
    }

    //客服中心
    public static String getKefuUrl(String sessionId) {
        return WEB_DOMAIN + "/uc/#!/uc/csc?"+getFooterUrl(sessionId);
    }

    //我的好友
    public static String getMyFriendsUrl(String sessionId) {
        return WEB_DOMAIN + "/uc/#!/uc/friends?"+getFooterUrl(sessionId);
    }

    //我的订单
    public static String getMyGoodsOrderUrl(String sessionId)
    {
        return WEB_DOMAIN+"/uc/?#!/uc/order?"+getFooterUrl(sessionId);
    }

    //退货管理
    public static String getRefundOrderUrl(String sessionId)
    {
        return WEB_DOMAIN+"/uc/?#!/uc/returns?"+getFooterUrl(sessionId);
    }

}
