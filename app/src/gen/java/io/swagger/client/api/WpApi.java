package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.Pair;

import io.swagger.client.model.*;

import java.util.*;

import io.swagger.client.model.WxPay;
import java.math.BigDecimal;

import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class WpApi  extends BaseApi{
  String basePath = "https://"+api_domain+"/api";
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

  /**
   * \u5FAE\u4FE1\u516C\u4F17\u53F7\u5145\u503C\u9884\u4EA4\u6613\u6216\u4E0B\u5355\u63A5\u53E3
   * \u5FAE\u4FE1\u516C\u4F17\u53F7\u5F00\u53D1\u65F6\uFF0C\u8C03\u7528\u6B64\u63A5\u53E3\u8FDB\u884C\u5FAE\u4FE1\u516C\u4F17\u53F7\u5145\u503C\u652F\u4ED8\u4E0B\u5355\u63A5\u53E3\u3002\n
   * @param money \u5145\u503C\u91D1\u989D.
   * @return WxAppPay
   */
  public WxAppPay  preWechatAppRecharge (BigDecimal money) throws ApiException {
    Object localVarPostBody = null;

    // verify the required parameter 'money' is set
    if (money == null) {
      throw new ApiException(400, "Missing the required parameter 'money' when calling preWechatAppRecharge");
    }


    // create path and map variables
    String localVarPath = "/wp/recharge/app/pre".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();



    String[] localVarContentTypes = {
            "application/x-www-form-urlencoded"
    };
    String localVarContentType = localVarContentTypes.length > 0 ? localVarContentTypes[0] : "application/json";

    if (localVarContentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();

      if (money != null) {
        localVarBuilder.addTextBody("money", ApiInvoker.parameterToString(money), ApiInvoker.TEXT_PLAIN_UTF8);
      }


      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("money", ApiInvoker.parameterToString(money));
    }

    try {
      String localVarResponse = apiInvoker.invokeAPI(basePath, localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);
      if(localVarResponse != null){
        return (WxAppPay) ApiInvoker.deserialize(localVarResponse, "", WxAppPay.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u5FAE\u4FE1\u516C\u4F17\u53F7\u5145\u503C\u9884\u4EA4\u6613\u6216\u4E0B\u5355\u63A5\u53E3
   * \u5FAE\u4FE1\u516C\u4F17\u53F7\u5F00\u53D1\u65F6\uFF0C\u8C03\u7528\u6B64\u63A5\u53E3\u8FDB\u884C\u5FAE\u4FE1\u516C\u4F17\u53F7\u5145\u503C\u652F\u4ED8\u4E0B\u5355\u63A5\u53E3\u3002\n
   * @param money \u5145\u503C\u91D1\u989D.
   * @return WxPay
   */
  public WxPay  preWechatRecharge (BigDecimal money) throws ApiException {
    Object localVarPostBody = null;

    // verify the required parameter 'money' is set
    if (money == null) {
      throw new ApiException(400, "Missing the required parameter 'money' when calling preWechatRecharge");
    }


    // create path and map variables
    String localVarPath = "/wp/recharge/pre".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();



    String[] localVarContentTypes = {
            "application/x-www-form-urlencoded"
    };
    String localVarContentType = localVarContentTypes.length > 0 ? localVarContentTypes[0] : "application/json";

    if (localVarContentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();

      if (money != null) {
        localVarBuilder.addTextBody("money", ApiInvoker.parameterToString(money), ApiInvoker.TEXT_PLAIN_UTF8);
      }


      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("money", ApiInvoker.parameterToString(money));
    }

    try {
      String localVarResponse = apiInvoker.invokeAPI(basePath, localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);
      if(localVarResponse != null){
        return (WxPay) ApiInvoker.deserialize(localVarResponse, "", WxPay.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
}
