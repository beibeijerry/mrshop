package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.Pair;

import io.swagger.client.model.*;

import java.util.*;

import io.swagger.client.model.GeneralNumber;
import io.swagger.client.model.Error;
import io.swagger.client.model.GradeDes;
import io.swagger.client.model.RPInfo;
import io.swagger.client.model.RPRank;
import io.swagger.client.model.RPOpenRecord;
import io.swagger.client.model.VIPRPInfo;
import java.util.Date;

import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class RpApi extends BaseApi{
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
   * \u524D\u7AEF-&gt;\u7528\u6237\u7B7E\u5230
   * 
   * @return GeneralNumber
   */
  public GeneralNumber  rpAppCheckinPost () throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/rp/app/checkin".replaceAll("\\{format\\}","json");

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
      String localVarResponse = apiInvoker.invokeAPI(basePath, localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);
      if(localVarResponse != null){
        return (GeneralNumber) ApiInvoker.deserialize(localVarResponse, "", GeneralNumber.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u83B7\u53D6\u4F1A\u5458\u6743\u76CA
   * 
   * @return List<GradeDes>
   */
  public List<GradeDes>  rpAppGradesSettingGet () throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/rp/app/grades/setting".replaceAll("\\{format\\}","json");

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
        return (List<GradeDes>) ApiInvoker.deserialize(localVarResponse, "array", GradeDes.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u524D\u7AEF-&gt;\u83B7\u53D6\u7528\u6237\u7B7E\u5230\u3001\u6447\u7EA2\u5305\u57FA\u672C\u4FE1\u606F\uFF1A\u4ECA\u65E5\u662F\u5426\u5DF2\u7B7E\u5230\u3001\u7B7E\u5230\u7EA2\u5305\u6D77\u62A5\u5E7F\u544A\u5730\u5740\u3001\u7B7E\u5230\u7EA2\u5305\u9605\u8BFB\u65F6\u95F4\u3001\u6447\u7EA2\u5305\u603B\u6B21\u6570\u3001\u4ECA\u65E5\u7528\u6237\u5269\u4F59\u6B21\u6570
   * 
   * @return RPInfo
   */
  public RPInfo  rpAppInfoGet () throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/rp/app/info".replaceAll("\\{format\\}","json");

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
        return (RPInfo) ApiInvoker.deserialize(localVarResponse, "", RPInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u83B7\u53D6\u6392\u540D\u5217\u8868
   * 
   * @param lastRank \u6700\u540E\u4E00\u4E2A\u540D\u6B21\u3002\u9ED8\u8BA4\u4ECE1\u5F00\u59CB\u83B7\u53D6
   * @param count \u6570\u91CF  \u9ED8\u8BA410
   * @return List<RPRank>
   */
  public List<RPRank>  rpAppRankGet (Integer lastRank, Integer count) throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/rp/app/rank".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "lastRank", lastRank));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "count", count));


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
        return (List<RPRank>) ApiInvoker.deserialize(localVarResponse, "array", RPRank.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u524D\u7AEF-&gt;\u83B7\u53D6\u5B9E\u65F6\u6447\u7EA2\u5305\u4FE1\u606F
   * 
   * @param count \u8FD4\u56DE\u5B9E\u65F6\u7684\u4FE1\u606F\u6570\u91CF
   * @return List<RPOpenRecord>
   */
  public List<RPOpenRecord>  rpAppShakerpListGet (Integer count) throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/rp/app/shakerp/list".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "count", count));


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
        return (List<RPOpenRecord>) ApiInvoker.deserialize(localVarResponse, "array", RPOpenRecord.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u524D\u7AEF-&gt;\u7528\u6237\u6447\u7EA2\u5305
   * 
   * @return GeneralNumber
   */
  public GeneralNumber  rpAppShakerpPost () throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/rp/app/shakerp".replaceAll("\\{format\\}","json");

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
      String localVarResponse = apiInvoker.invokeAPI(basePath, localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);
      if(localVarResponse != null){
        return (GeneralNumber) ApiInvoker.deserialize(localVarResponse, "", GeneralNumber.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u524D\u7AEF-&gt;\u83B7\u53D6\u7279\u6743\u7EA2\u5305\u5217\u8868\uFF0C\u4E0A\u62C9\u52A0\u8F7D\u66F4\u591A
   * 
   * @param time \u5217\u8868\u6700\u540E\u4E00\u4E2A\u6216\u7B2C\u4E00\u4E2A\u7EA2\u5305\u7684\u521B\u5EFA\u65F6\u95F4\u3002\u5982\u679C\u4E0D\u643A\u5E26\u8BE5\u53C2\u6570\uFF0C\u5219\u83B7\u53D6\u6700\u65B0\u7684\u3002
   * @param count \u83B7\u53D6\u4E2A\u6570 \u9ED8\u8BA4\u8FD4\u56DE5\u6761
   * @param upOrDown up\u4E0A\u62C9\u52A0\u8F7D\u66F4\u591A  down \u4E0B\u6765\u66F4\u65B0
   * @return List<VIPRPInfo>
   */
  public List<VIPRPInfo>  rpAppViprpGet (Date time, Integer count, String upOrDown) throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/rp/app/viprp".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "time", time));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "count", count));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "upOrDown", upOrDown));


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
        return (List<VIPRPInfo>) ApiInvoker.deserialize(localVarResponse, "array", VIPRPInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u83B7\u53D6\u5355\u4E2A\u7EA2\u5305
   * 
   * @param viprpid 
   * @return VIPRPInfo
   */
  public VIPRPInfo  rpAppViprpViprpidGet (Long viprpid) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'viprpid' is set
    if (viprpid == null) {
       throw new ApiException(400, "Missing the required parameter 'viprpid' when calling rpAppViprpViprpidGet");
    }
    

    // create path and map variables
    String localVarPath = "/rp/app/viprp/{viprpid}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "viprpid" + "\\}", apiInvoker.escapeString(viprpid.toString()));

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
        return (VIPRPInfo) ApiInvoker.deserialize(localVarResponse, "", VIPRPInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u524D\u7AEF-&gt;\u9886\u53D6\u7279\u6743\u7EA2\u5305
   * 
   * @param viprpid 
   * @return GeneralNumber
   */
  public GeneralNumber  rpAppViprpViprpidGetPost (Long viprpid) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'viprpid' is set
    if (viprpid == null) {
       throw new ApiException(400, "Missing the required parameter 'viprpid' when calling rpAppViprpViprpidGetPost");
    }
    

    // create path and map variables
    String localVarPath = "/rp/app/viprp/{viprpid}/get".replaceAll("\\{format\\}","json").replaceAll("\\{" + "viprpid" + "\\}", apiInvoker.escapeString(viprpid.toString()));

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
      String localVarResponse = apiInvoker.invokeAPI(basePath, localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);
      if(localVarResponse != null){
        return (GeneralNumber) ApiInvoker.deserialize(localVarResponse, "", GeneralNumber.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u524D\u7AEF-&gt;\u83B7\u53D6\u7EA2\u5305\u9886\u53D6\u5217\u8868
   * 
   * @param viprpid \u7EA2\u5305id
   * @return List<RPOpenRecord>
   */
  public List<RPOpenRecord>  rpAppViprpViprpidGetlistGet (Long viprpid) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'viprpid' is set
    if (viprpid == null) {
       throw new ApiException(400, "Missing dthe required parameter 'viprpid' when calling rpAppViprpViprpidGetlistGet");
    }
    

    // create path and map variables
    String localVarPath = "/rp/app/viprp/{viprpid}/getlist".replaceAll("\\{format\\}","json").replaceAll("\\{" + "viprpid" + "\\}", apiInvoker.escapeString(viprpid.toString()));

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
        return (List<RPOpenRecord>) ApiInvoker.deserialize(localVarResponse, "array", RPOpenRecord.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
}
