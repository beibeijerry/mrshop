package com.muran.mrshop.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2016/8/24.
 */
@ApiModel(description = "")
public class WxRes implements Serializable {
    @SerializedName("access_token")
    private String access_token = null;
    @SerializedName("expires_in")
    private String expires_in = null;
    @SerializedName("refresh_token")
    private String refresh_token = null;
    @SerializedName("openid")
    private String openid = null;
    @SerializedName("scope")
    private String scope = null;
    @SerializedName("unionid")
    private String unionid = null;


    @ApiModelProperty(value = "")
    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
    @ApiModelProperty(value = "")
    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }
    @ApiModelProperty(value = "")
    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
    @ApiModelProperty(value = "")
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
    @ApiModelProperty(value = "")
    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
    @ApiModelProperty(value = "")
    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
