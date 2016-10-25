package com.muran.mrshop.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Steven on 6/7/16.
 */
public class DataVerify {

    private final static String PATTERN_MOBILE = "^[1][3,4,5,8,7][0-9]{9}$";
    private final static String PATTERN_URL = "(?i)\\b((?:[a-z][\\w-]+:(?:/{1,3}|[a-z0-9%])|www\\d{0,3}[.]|[a-z0-9.\\-]+[.][a-z]{2,4}/)(?:[^\\s()<>]+|\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\))+(?:\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\)|[^\\s`!()\\[\\]{};:'\".,<>?«»“”‘’]))";

    private DataVerify() {
    }

    private static DataVerify instatnce = null;

    public static DataVerify getDataVerify() {
        if (instatnce == null) instatnce = new DataVerify();
        return instatnce;
    }

    public boolean verfiy(String text, String pattern) {
        if (text == null || pattern == null) return false;
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile(pattern); // 验证手机号
        m = p.matcher(text);
        b = m.matches();
        return b;
    }


    public boolean verifyMobile(String mobile) {
        return verfiy(mobile,PATTERN_MOBILE);
    }
    public boolean verifyURL(String url){
        return verfiy(url,PATTERN_URL);
    }
}
