package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.Pair;

import io.swagger.client.model.*;

import java.util.*;

import io.swagger.client.model.Area;
import io.swagger.client.model.UploadFileToken;
import io.swagger.client.model.FileInfo;
import io.swagger.client.model.SmsResultInfo;
import io.swagger.client.model.Error;
import io.swagger.client.model.GeneralString;
import java.io.File;

import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class SysApi extends BaseApi{
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
   * \u83B7\u53D6\u7701\u5E02\u533A\u4FE1\u606F
   * 
   * @param code \u67E5\u8BE2\u7684\u7236\u7C7B\u533A\u57DFcode\uFF0C\u5982\u679C\u4E0D\u586B\uFF0C\u5219\u9ED8\u8BA4\u53D6\u7701\u7EA7\u4FE1\u606F
   * @param recursion \u662F\u5426\u9012\u5F52\u83B7\u53D6\u4E0B\u7EA7\u4FE1\u606F\uFF0C\u9ED8\u8BA4false
   * @return List<Area>
   */
  public List<Area>  getAreas (String code, Boolean recursion) throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/sys/area".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "code", code));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "recursion", recursion));


    String[] localVarContentTypes = {
      "application/json"
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
        return (List<Area>) ApiInvoker.deserialize(localVarResponse, "array", Area.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u83B7\u53D6\u6587\u4EF6\u957F\u4F20\u7684token
   * \u83B7\u53D6\u4E03\u725B\u6587\u4EF6\u4E0A\u4F20\u7684token
   * @param type 0 \u7528\u6237\u5934\u50CF 1 \u7528\u6237\u5E7F\u544A\u7D20\u6750\u56FE\u7247 2 \u7528\u6237\u6587\u7AE0\u6587\u4EF6html 3 \u6587\u7AE0\u5E93\u6587\u7AE0\u6587\u4EF6html 5 \u79D2\u4EAB\u4E00\u822C\u7D20\u6750\u56FE\u7247\u3001\u7F51\u9875\u7B49\u6587\u4EF6 6 \u5176\u5B83
   * @param subType type&#x3D;1\u65F6\u4F20\u5165 0 \u4E00\u822C\u901A\u680F\u56FE\u7247 1 \u56FE\u6587\u3001\u4F18\u60E0\u5238\u7B49\u6B63\u65B9\u5F62\u56FE\u7247 2 \u5BF9\u8BDD\u6846\u56FE\u7247.\u9ED8\u8BA4\u4E3A0
   * @param key \u5982\u679C\u643A\u5E26\u4E86\u672C\u53C2\u6570\uFF0C\u8868\u660E\u662F\u8986\u76D6\u4E0A\u4F20\u3002
   * @return UploadFileToken
   */
  public UploadFileToken  getUploadFileToken (Integer type, Integer subType, String key) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'type' is set
    if (type == null) {
       throw new ApiException(400, "Missing the required parameter 'type' when calling getUploadFileToken");
    }
    

    // create path and map variables
    String localVarPath = "/sys/files/upLoadToken".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "type", type));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "subType", subType));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "key", key));


    String[] localVarContentTypes = {
      "application/json"
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
        return (UploadFileToken) ApiInvoker.deserialize(localVarResponse, "", UploadFileToken.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u83B7\u53D6\u7528\u6237\u6587\u4EF6\u5217\u8868
   * 
   * @param type 
   * @return List<FileInfo>
   */
  public List<FileInfo>  getUserFiles (Integer type) throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/sys/files".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "type", type));


    String[] localVarContentTypes = {
      "application/json"
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
        return (List<FileInfo>) ApiInvoker.deserialize(localVarResponse, "array", FileInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u624B\u673A\u9A8C\u8BC1\u7801\u77ED\u4FE1
   * \u53D1\u9001\u624B\u673A\u9A8C\u8BC1\u7801\u77ED\u4FE1\uFF0C\u6CE8\u518C\u767B\u5F55\u7B49\u3002
   * @param mobile 
   * @param type \u5206\u7C7B 0\uFF1A\u6CE8\u518C\u767B\u5F55 \u9ED8\u8BA40  1\uFF1A\u5FAE\u4FE1\u7ED1\u5B9A\u624B\u673A\u53F7
   * @return SmsResultInfo
   */
  public SmsResultInfo  sendSMS (String mobile, Integer type) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'mobile' is set
    if (mobile == null) {
       throw new ApiException(400, "Missing the required parameter 'mobile' when calling sendSMS");
    }
    

    // create path and map variables
    String localVarPath = "/sys/sms".replaceAll("\\{format\\}","json");

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
      
      if (mobile != null) {
        localVarBuilder.addTextBody("mobile", ApiInvoker.parameterToString(mobile), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (type != null) {
        localVarBuilder.addTextBody("type", ApiInvoker.parameterToString(type), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("mobile", ApiInvoker.parameterToString(mobile));
localVarFormParams.put("type", ApiInvoker.parameterToString(type));
    }

    try {
      String localVarResponse = apiInvoker.invokeAPI(basePath, localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);
      if(localVarResponse != null){
        return (SmsResultInfo) ApiInvoker.deserialize(localVarResponse, "", SmsResultInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u670D\u52A1\u5668\u7248\u672C\u4FE1\u606F
   * \u83B7\u53D6\u670D\u52A1\u5668\u7684\u7248\u672C\u4FE1\u606F
   * @return GeneralString
   */
  public GeneralString  sysVersionGet () throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/sys/version".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();



    String[] localVarContentTypes = {
      "application/json"
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
   * \u76F4\u63A5\u4E0A\u4F20\u6587\u4EF6
   * \u8FD9\u91CC\u4F7F\u7528\u670D\u52A1\u5668\u76F4\u63A5\u4E0A\u4F20\u6587\u4EF6\uFF0C\u5BA2\u6237\u7AEF\u4E0D\u7528\u5728\u8C03\u7528\u4E03\u725B\u4E0A\u4F20\u6587\u4EF6
   * @param file \u4E0A\u4F20\u6587\u4EF6
   * @return GeneralString
   */
  public GeneralString  uploadFile (File file) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'file' is set
    if (file == null) {
       throw new ApiException(400, "Missing the required parameter 'file' when calling uploadFile");
    }
    

    // create path and map variables
    String localVarPath = "/sys/files/upload".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();



    String[] localVarContentTypes = {
      "multipart/form-data"
    };
    String localVarContentType = localVarContentTypes.length > 0 ? localVarContentTypes[0] : "application/json";

    if (localVarContentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      
      if (file != null) {
        localVarBuilder.addBinaryBody("file", file);
      }
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      
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
}
