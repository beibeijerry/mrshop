package com.muran.mrshop.api;

import android.util.Log;

import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.Pair;

/**
 * Created by Administrator on 2016/8/24.
 */
public class WxAuthApi {

    String basePath = "https://api.weixin.qq.com/";
    ApiInvoker apiInvoker = ApiInvoker.getInstance();

    public void addHeader(String key, String value) {
        getInvoker().addDefaultHeader(key, value);
    }

    public ApiInvoker getInvoker() {
        return apiInvoker;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getBasePath() {
        return basePath;
    }

    //获取user_token,openid
    public WxRes getWxRes (String appId,String secret,String code,String grant_type) throws ApiException {
        Object localVarPostBody = null;
        if (appId == null) {
            throw new ApiException(400, "Missing the required parameter 'inviteCode' when calling WxRes");
        }
        if (secret == null) {
            throw new ApiException(400, "Missing the required parameter 'secret' when calling WxRes");
        }
        if (code == null) {
            throw new ApiException(400, "Missing the required parameter 'code' when calling WxRes");
        }
        if (grant_type == null) {
            throw new ApiException(400, "Missing the required parameter 'grant_type' when calling WxRes");
        }
        String localVarPath = "sns/oauth2/access_token".replaceAll("\\{format\\}","json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        // header params
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        // form params
        Map<String, String> localVarFormParams = new HashMap<String, String>();

        localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "appId", appId));
        localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "code", code));
        localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "secret", secret));
        localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "grant_type", grant_type));

        String[] localVarContentTypes = {

        };
        String localVarContentType = localVarContentTypes.length > 0 ? localVarContentTypes[0] : "application/json";

        if (localVarContentType.startsWith("multipart/form-data")) {
            // file uploading
            MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
            localVarPostBody = localVarBuilder.build();
        } else {
            // normal form params
        }

        try {
            String localVarResponse = apiInvoker.invokeAPI(basePath, localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);
            if(localVarResponse != null){
                Log.d("result",localVarResponse);
                return (WxRes) ApiInvoker.deserialize(localVarResponse.toString(), "", WxRes.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            throw ex;
        }
    }
}
