package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.Pair;

import io.swagger.client.model.*;

import java.util.*;

import io.swagger.client.model.UserBillInfo;
import java.util.Date;
import io.swagger.client.model.UserAccountInfo;
import io.swagger.client.model.GeneralString;

import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class AcApi extends BaseApi{
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
   * \u83B7\u53D6\u7528\u6237\u8D26\u5355\u4FE1\u606F
   * 
   * @param type 1\u6447\u7EA2\u5305  2\u7B7E\u5230\u7EA2\u5305  3 vip\u7EA2\u5305  4 \u5145\u503C  6 \u63A8\u8350\u5956\u52B1  7 \u6D88\u8D39\uFF08null\u8868\u793A\u67E5\u8BE2\u5168\u90E8\uFF09
   * @param count \u83B7\u53D6\u6570\u91CF. \u9ED8\u8BA4 10\u6761
   * @param lastTime \u4E0A\u8C03\u8BB0\u5F55\u7684\u65F6\u95F4
   * @return List<UserBillInfo>
   */
  public List<UserBillInfo>  acAppBillGet (Integer type, Integer count, Date lastTime) throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/ac/app/bill".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "type", type));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "count", count));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "lastTime", lastTime));


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
        return (List<UserBillInfo>) ApiInvoker.deserialize(localVarResponse, "array", UserBillInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u83B7\u53D6\u7528\u6237\u8D26\u6237\u4FE1\u606F
   * 
   * @return UserAccountInfo
   */
  public UserAccountInfo  acAppInfoGet () throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/ac/app/info".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();



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
        return (UserAccountInfo) ApiInvoker.deserialize(localVarResponse, "", UserAccountInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u7528\u6237\u652F\u4ED8\u8BA2\u5355
   * 
   * @param orderNo \u8BA2\u5355\u53F7
   * @return GeneralString
   */
  public GeneralString  acAppOrderpayPost (String orderNo) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'orderNo' is set
    if (orderNo == null) {
       throw new ApiException(400, "Missing the required parameter 'orderNo' when calling acAppOrderpayPost");
    }
    

    // create path and map variables
    String localVarPath = "/ac/app/orderpay".replaceAll("\\{format\\}","json");

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
      
      if (orderNo != null) {
        localVarBuilder.addTextBody("orderNo", ApiInvoker.parameterToString(orderNo), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("orderNo", ApiInvoker.parameterToString(orderNo));
    }

    try {
      String localVarResponse = apiInvoker.invokeAPI(basePath, localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);
      if(localVarResponse != null){
        return (GeneralString) ApiInvoker.deserialize(localVarResponse, "", GeneralString.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u7528\u6237\u4F7F\u7528\u5145\u503C\u5361\u5145\u503C
   * 
   * @param cardNo 
   * @return GeneralString
   */
  public GeneralString  acAppPrecardPut (String cardNo) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'cardNo' is set
    if (cardNo == null) {
       throw new ApiException(400, "Missing the required parameter 'cardNo' when calling acAppPrecardPut");
    }
    

    // create path and map variables
    String localVarPath = "/ac/app/precard".replaceAll("\\{format\\}","json");

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
      
      if (cardNo != null) {
        localVarBuilder.addTextBody("cardNo", ApiInvoker.parameterToString(cardNo), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("cardNo", ApiInvoker.parameterToString(cardNo));
    }

    try {
      String localVarResponse = apiInvoker.invokeAPI(basePath, localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);
      if(localVarResponse != null){
        return (GeneralString) ApiInvoker.deserialize(localVarResponse, "", GeneralString.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
}
