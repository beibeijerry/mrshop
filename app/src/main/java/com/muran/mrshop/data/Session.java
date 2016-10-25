package com.muran.mrshop.data;

import java.io.Serializable;
import java.util.UUID;

import io.swagger.client.model.UserAccountInfo;
import io.swagger.client.model.UserInfo;

/**
 * Created by Steven on 5/20/16.
 */
public class Session implements Serializable{
    private String id;
    private UserInfo userInfo;
    private boolean isBindMobile;
    private UserAccountInfo userAccountInfo;
    public Session(String id) {
        this.id = id;
    }

    public Session() {

    }

    public boolean isBindMobile() {
        return isBindMobile;
    }

    public void setBindMobile(boolean bindMobile) {
        isBindMobile = bindMobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {

        this.userInfo = userInfo;


    }

    public UserAccountInfo getUserAccountInfo() {
        return userAccountInfo;
    }

    public void setUserAccountInfo(UserAccountInfo userAccountInfo) {
        this.userAccountInfo = userAccountInfo;
    }
}
