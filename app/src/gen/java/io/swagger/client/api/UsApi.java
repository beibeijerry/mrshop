package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.Pair;

import io.swagger.client.model.*;

import java.util.*;

import io.swagger.client.model.AdminInfo;
import io.swagger.client.model.AddAdmin;
import io.swagger.client.model.Error;
import io.swagger.client.model.GeneralString;
import java.math.BigDecimal;
import io.swagger.client.model.BindReturn;
import io.swagger.client.model.InviteRecord;
import io.swagger.client.model.GradeInfo;
import io.swagger.client.model.UserInfo;
import java.util.Date;
import io.swagger.client.model.UserPageData;
import io.swagger.client.model.WechatLoginInfo;
import io.swagger.client.model.WxConfig;

import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class UsApi extends BaseApi{
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
   * \u540E\u53F0\u7BA1\u7406\u5458\u6DFB\u52A0\u63A5\u53E3
   * \u540E\u53F0\u7BA1\u7406\u5458\u6DFB\u52A0\u63A5\u53E3\u3002\n
   * @param body \u7528\u6237\u7684\u4FE1\u606F
   * @return AdminInfo
   */
  public AdminInfo  addAdmin (AddAdmin body) throws ApiException {
    Object localVarPostBody = body;
    

    // create path and map variables
    String localVarPath = "/us/admins".replaceAll("\\{format\\}","json");

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
      String localVarResponse = apiInvoker.invokeAPI(basePath, localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);
      if(localVarResponse != null){
        return (AdminInfo) ApiInvoker.deserialize(localVarResponse, "", AdminInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u65B0\u589E\u4F1A\u5458\u7EA7\u522B\u4FE1\u606F
   * \u65B0\u589E\u4F1A\u5458\u7EA7\u522B\u4FE1\u606F\u3002\n
   * @param grade \u4F1A\u5458\u7EA7\u522B
   * @param name \u4F1A\u5458\u7EA7\u522B\u540D\u79F0
   * @param money \u5145\u503C\u91D1\u989D
   * @param inviteMax \u9080\u8BF7\u4EBA\u6570\u9650\u5236
   * @param payBonus \u5145\u503C\u8FD4\u4F63\u6BD4\u4F8B  \u5355\u4F4D\uFF05.
   * @param rpBonus \u7EA2\u5305\u8FD4\u4F63\u6BD4\u4F8B  \u5355\u4F4D\uFF05.
   * @return GeneralString
   */
  public GeneralString  addGrade (Integer grade, String name, BigDecimal money, Integer inviteMax, Integer payBonus, Integer rpBonus) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'grade' is set
    if (grade == null) {
       throw new ApiException(400, "Missing the required parameter 'grade' when calling addGrade");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
       throw new ApiException(400, "Missing the required parameter 'name' when calling addGrade");
    }
    
    // verify the required parameter 'money' is set
    if (money == null) {
       throw new ApiException(400, "Missing the required parameter 'money' when calling addGrade");
    }
    
    // verify the required parameter 'inviteMax' is set
    if (inviteMax == null) {
       throw new ApiException(400, "Missing the required parameter 'inviteMax' when calling addGrade");
    }
    

    // create path and map variables
    String localVarPath = "/us/grades".replaceAll("\\{format\\}","json");

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
      
      if (grade != null) {
        localVarBuilder.addTextBody("grade", ApiInvoker.parameterToString(grade), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (name != null) {
        localVarBuilder.addTextBody("name", ApiInvoker.parameterToString(name), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (money != null) {
        localVarBuilder.addTextBody("money", ApiInvoker.parameterToString(money), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (inviteMax != null) {
        localVarBuilder.addTextBody("inviteMax", ApiInvoker.parameterToString(inviteMax), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (payBonus != null) {
        localVarBuilder.addTextBody("payBonus", ApiInvoker.parameterToString(payBonus), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (rpBonus != null) {
        localVarBuilder.addTextBody("rpBonus", ApiInvoker.parameterToString(rpBonus), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("grade", ApiInvoker.parameterToString(grade));
localVarFormParams.put("name", ApiInvoker.parameterToString(name));
localVarFormParams.put("money", ApiInvoker.parameterToString(money));
localVarFormParams.put("inviteMax", ApiInvoker.parameterToString(inviteMax));
localVarFormParams.put("payBonus", ApiInvoker.parameterToString(payBonus));
localVarFormParams.put("rpBonus", ApiInvoker.parameterToString(rpBonus));
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
   * \u540E\u53F0\u767B\u9646\u63A5\u53E3
   * \u540E\u53F0\u767B\u9646\u63A5\u53E3\u3002\n
   * @param username \u7528\u6237\u7684username
   * @param password \u7ECF\u8FC7md5\u7B7E\u540D\u7684\u5BC6\u7801
   * @return GeneralString
   */
  public GeneralString  adminLogin (String username, String password) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'username' is set
    if (username == null) {
       throw new ApiException(400, "Missing the required parameter 'username' when calling adminLogin");
    }
    
    // verify the required parameter 'password' is set
    if (password == null) {
       throw new ApiException(400, "Missing the required parameter 'password' when calling adminLogin");
    }
    

    // create path and map variables
    String localVarPath = "/us/admins/login".replaceAll("\\{format\\}","json");

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
      
      if (username != null) {
        localVarBuilder.addTextBody("username", ApiInvoker.parameterToString(username), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (password != null) {
        localVarBuilder.addTextBody("password", ApiInvoker.parameterToString(password), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("username", ApiInvoker.parameterToString(username));
localVarFormParams.put("password", ApiInvoker.parameterToString(password));
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
   * \u540E\u53F0\u767B\u51FA\u63A5\u53E3
   * \u540E\u53F0\u767B\u51FA\u63A5\u53E3\u3002\u5C06sessionid\u4F20\u5165\u540E\u53F0\n
   * @return GeneralString
   */
  public GeneralString  adminLoginOut () throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/us/admins/loginout".replaceAll("\\{format\\}","json");

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
      String localVarResponse = apiInvoker.invokeAPI(basePath, localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);
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
   * \u7BA1\u7406\u5458\u5BC6\u7801\u4FEE\u6539\u63A5\u53E3
   * \u540E\u53F0\u7BA1\u7406\u5458\u6DFB\u52A0\u63A5\u53E3\u3002\n
   * @param oldPassword \u7528\u6237\u7684\u7ECF\u8FC7md5\u8FC7\u7684\u539F\u5BC6\u7801
   * @param newPassword \u7528\u6237\u7684\u7ECF\u8FC7md5\u8FC7\u7684\u65B0\u5BC6\u7801
   * @return GeneralString
   */
  public GeneralString  adminUpdatePwd (String oldPassword, String newPassword) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'oldPassword' is set
    if (oldPassword == null) {
       throw new ApiException(400, "Missing the required parameter 'oldPassword' when calling adminUpdatePwd");
    }
    
    // verify the required parameter 'newPassword' is set
    if (newPassword == null) {
       throw new ApiException(400, "Missing the required parameter 'newPassword' when calling adminUpdatePwd");
    }
    

    // create path and map variables
    String localVarPath = "/us/admins/resetpwd".replaceAll("\\{format\\}","json");

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
      
      if (oldPassword != null) {
        localVarBuilder.addTextBody("oldPassword", ApiInvoker.parameterToString(oldPassword), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (newPassword != null) {
        localVarBuilder.addTextBody("newPassword", ApiInvoker.parameterToString(newPassword), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("oldPassword", ApiInvoker.parameterToString(oldPassword));
localVarFormParams.put("newPassword", ApiInvoker.parameterToString(newPassword));
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
  /**
   * web\u7AEF\u6839\u636Eid  \u7ED1\u5B9A\u7ECF\u9500\u5546\u4FE1\u606F
   * web\u7AEF\u6839\u636Eid  \u7ED1\u5B9A\u7ECF\u9500\u5546\u4FE1\u606F\u3002\n
   * @param autoId \u7528\u6237\u7684usId
   * @param agCode \u7ECF\u9500\u5546code
   * @return GeneralString
   */
  public GeneralString  bindAgent (Long autoId, String agCode) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'autoId' is set
    if (autoId == null) {
       throw new ApiException(400, "Missing the required parameter 'autoId' when calling bindAgent");
    }
    
    // verify the required parameter 'agCode' is set
    if (agCode == null) {
       throw new ApiException(400, "Missing the required parameter 'agCode' when calling bindAgent");
    }
    

    // create path and map variables
    String localVarPath = "/us/users/{autoId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "autoId" + "\\}", apiInvoker.escapeString(autoId.toString()));

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
      
      if (agCode != null) {
        localVarBuilder.addTextBody("agCode", ApiInvoker.parameterToString(agCode), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("agCode", ApiInvoker.parameterToString(agCode));
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
  /**
   * \u7ED1\u5B9A\u9080\u8BF7\u4FE1\u606F
   * \u7ED1\u5B9A\u9080\u8BF7\u4FE1\u606F\u3002\n
   * @param inviteCode \u9080\u8BF7\u7801
   * @return BindReturn
   */
  public BindReturn  bindIntro (String inviteCode) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'inviteCode' is set
    if (inviteCode == null) {
       throw new ApiException(400, "Missing the required parameter 'inviteCode' when calling bindIntro");
    }
    

    // create path and map variables
    String localVarPath = "/us/user/relation".replaceAll("\\{format\\}","json");

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
      
      if (inviteCode != null) {
        localVarBuilder.addTextBody("inviteCode", ApiInvoker.parameterToString(inviteCode), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("inviteCode", ApiInvoker.parameterToString(inviteCode));
    }

    try {
      String localVarResponse = apiInvoker.invokeAPI(basePath, localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);
      if(localVarResponse != null){
        return (BindReturn) ApiInvoker.deserialize(localVarResponse, "", BindReturn.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u5FAE\u4FE1\u7ED1\u5B9A\u624B\u673A\u53F7\u63A5\u53E3
   * \u5FAE\u4FE1\u7ED1\u5B9A\u624B\u673A\u53F7\u63A5\u53E3\u3002\n
   * @param mobile \u624B\u673A\u53F7.
   * @param verifycode \u624B\u673A\u9A8C\u8BC1\u7801.
   * @param bussId \u9A8C\u8BC1\u7801\u4E1A\u52A1id
   * @return GeneralString
   */
  public GeneralString  bindMobile (String mobile, String verifycode, Long bussId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'mobile' is set
    if (mobile == null) {
       throw new ApiException(400, "Missing the required parameter 'mobile' when calling bindMobile");
    }
    
    // verify the required parameter 'verifycode' is set
    if (verifycode == null) {
       throw new ApiException(400, "Missing the required parameter 'verifycode' when calling bindMobile");
    }
    
    // verify the required parameter 'bussId' is set
    if (bussId == null) {
       throw new ApiException(400, "Missing the required parameter 'bussId' when calling bindMobile");
    }
    

    // create path and map variables
    String localVarPath = "/us/mobile/bind".replaceAll("\\{format\\}","json");

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
      
      if (verifycode != null) {
        localVarBuilder.addTextBody("verifycode", ApiInvoker.parameterToString(verifycode), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (bussId != null) {
        localVarBuilder.addTextBody("bussId", ApiInvoker.parameterToString(bussId), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("mobile", ApiInvoker.parameterToString(mobile));
localVarFormParams.put("verifycode", ApiInvoker.parameterToString(verifycode));
localVarFormParams.put("bussId", ApiInvoker.parameterToString(bussId));
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
   * \u6839\u636Eid\u5220\u9664\u7BA1\u7406\u5458\u4FE1\u606F
   * \u6839\u636Eid\u5220\u9664\u7BA1\u7406\u5458\u4FE1\u606F\u3002\n
   * @param autoId id
   * @return GeneralString
   */
  public GeneralString  deleteAdminById (Long autoId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'autoId' is set
    if (autoId == null) {
       throw new ApiException(400, "Missing the required parameter 'autoId' when calling deleteAdminById");
    }
    

    // create path and map variables
    String localVarPath = "/us/admins/{autoId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "autoId" + "\\}", apiInvoker.escapeString(autoId.toString()));

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
      String localVarResponse = apiInvoker.invokeAPI(basePath, localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);
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
   * \u6839\u636Egroupid\u83B7\u53D6\u7BA1\u7406\u5458\u4FE1\u606F
   * \u6839\u636Egroupid\u83B7\u53D6\u7BA1\u7406\u5458\u4FE1\u606F\u3002\n
   * @param groupId id
   * @return AdminInfo
   */
  public AdminInfo  getAdminByGroupId (Long groupId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'groupId' is set
    if (groupId == null) {
       throw new ApiException(400, "Missing the required parameter 'groupId' when calling getAdminByGroupId");
    }
    

    // create path and map variables
    String localVarPath = "/us/admins/groups/{groupId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "groupId" + "\\}", apiInvoker.escapeString(groupId.toString()));

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
        return (AdminInfo) ApiInvoker.deserialize(localVarResponse, "", AdminInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u6839\u636Eid\u83B7\u53D6\u7BA1\u7406\u5458\u4FE1\u606F
   * \u6839\u636Eid\u83B7\u53D6\u7BA1\u7406\u5458\u4FE1\u606F\u3002\n
   * @param autoId id
   * @return AdminInfo
   */
  public AdminInfo  getAdminById (Long autoId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'autoId' is set
    if (autoId == null) {
       throw new ApiException(400, "Missing the required parameter 'autoId' when calling getAdminById");
    }
    

    // create path and map variables
    String localVarPath = "/us/admins/{autoId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "autoId" + "\\}", apiInvoker.escapeString(autoId.toString()));

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
        return (AdminInfo) ApiInvoker.deserialize(localVarResponse, "", AdminInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u6839\u636Eusername\u83B7\u53D6\u7BA1\u7406\u5458\u4FE1\u606F
   * \u6839\u636Eusername\u83B7\u53D6\u7BA1\u7406\u5458\u4FE1\u606F\u3002\n
   * @param username username
   * @return AdminInfo
   */
  public AdminInfo  getAdminByUsername (String username) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'username' is set
    if (username == null) {
       throw new ApiException(400, "Missing the required parameter 'username' when calling getAdminByUsername");
    }
    

    // create path and map variables
    String localVarPath = "/us/admins/getbyusername/{username}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "username" + "\\}", apiInvoker.escapeString(username.toString()));

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
        return (AdminInfo) ApiInvoker.deserialize(localVarResponse, "", AdminInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u83B7\u53D6\u7BA1\u7406\u5458\u4FE1\u606F\u5217\u8868
   * \u83B7\u53D6\u7BA1\u7406\u5458\u4FE1\u606F\u5217\u8868\u3002\n
   * @return List<AdminInfo>
   */
  public List<AdminInfo>  getAdminList () throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/us/admins".replaceAll("\\{format\\}","json");

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
        return (List<AdminInfo>) ApiInvoker.deserialize(localVarResponse, "array", AdminInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u83B7\u53D6\u6211\u7684\u9080\u8BF7\u597D\u53CB\u7684\u5217\u8868
   * \u83B7\u53D6\u6211\u7684\u597D\u53CB\u5217\u8868\u3002\n
   * @return InviteRecord
   */
  public InviteRecord  getFriends () throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/us/user/friend".replaceAll("\\{format\\}","json");

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
        return (InviteRecord) ApiInvoker.deserialize(localVarResponse, "", InviteRecord.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u6839\u636Eid\u83B7\u53D6\u4F1A\u5458\u7EA7\u522B\u4FE1\u606F
   * \u6839\u636Eid\u83B7\u53D6\u4F1A\u5458\u7EA7\u522B\u4FE1\u606F\u3002\n
   * @param grade \u4F1A\u5458\u7EA7\u522B
   * @return GradeInfo
   */
  public GradeInfo  getGrade (Integer grade) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'grade' is set
    if (grade == null) {
       throw new ApiException(400, "Missing the required parameter 'grade' when calling getGrade");
    }
    

    // create path and map variables
    String localVarPath = "/us/grades/{grade}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "grade" + "\\}", apiInvoker.escapeString(grade.toString()));

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
        return (GradeInfo) ApiInvoker.deserialize(localVarResponse, "", GradeInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u83B7\u53D6\u4F1A\u5458\u7EA7\u522B\u4FE1\u606F\u5217\u8868
   * \u83B7\u53D6\u4F1A\u5458\u7EA7\u522B\u4FE1\u606F\u5217\u8868\u3002\n
   * @return List<GradeInfo>
   */
  public List<GradeInfo>  getGradeList () throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/us/grades".replaceAll("\\{format\\}","json");

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
        return (List<GradeInfo>) ApiInvoker.deserialize(localVarResponse, "array", GradeInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * web\u7AEF\u6839\u636Eid\u83B7\u53D6\u7528\u6237\u4FE1\u606F
   * \u6839\u636EusId\u83B7\u53D6\u7528\u6237\u4FE1\u606F\u3002\n
   * @param autoId \u7528\u6237\u7684usId
   * @return UserInfo
   */
  public UserInfo  getUserInfo (Long autoId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'autoId' is set
    if (autoId == null) {
       throw new ApiException(400, "Missing the required parameter 'autoId' when calling getUserInfo");
    }
    

    // create path and map variables
    String localVarPath = "/us/users/{autoId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "autoId" + "\\}", apiInvoker.escapeString(autoId.toString()));

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
        return (UserInfo) ApiInvoker.deserialize(localVarResponse, "", UserInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u524D\u7AEF\u83B7\u53D6\u7528\u6237\u4E2A\u4EBA\u4FE1\u606F
   * \u524D\u7AEF\u8BF7\u6C42\u65F6\u9700\u5C06sessionid\u653E\u5728header\u4E2D\u8FDB\u884C\u8BF7\u6C42\uFF0C\u670D\u52A1\u6BB5\u4F1A\u9A8C\u8BC1sessionid\u662F\u5426\u5408\u6CD5\uFF0C\u5E76\u6839\u636Esessionid\uFF0C\u83B7\u53D6\u7528\u6237\u4FE1\u606F\u5E76\u8FD4\u56DE\u5230\u3002\n
   * @return UserInfo
   */
  public UserInfo  getUserOwnInfo () throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/us/users/owninfo".replaceAll("\\{format\\}","json");

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
        return (UserInfo) ApiInvoker.deserialize(localVarResponse, "", UserInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * web\u7AEF\u5206\u9875\u83B7\u53D6\u7528\u6237\u4FE1\u606F\u5217\u8868
   * web\u7AEF\u5206\u9875\u83B7\u53D6\u7528\u6237\u4FE1\u606F\u5217\u8868\n
   * @param pageIndex \u8D77\u59CB\u9875.
   * @param pageSize \u6BCF\u9875\u8BB0\u5F55\u6570.
   * @param name \u6635\u79F0.
   * @param startTime \u5F00\u59CB\u65F6\u95F4.
   * @param endTime \u5F00\u59CB\u65F6\u95F4.
   * @param grade \u4F1A\u5458\u7EA7\u522B.
   * @param agCode \u6240\u5C5E\u7ECF\u9500\u5546\u7F16\u53F7.
   * @return UserPageData
   */
  public UserPageData  getUserPageList (Integer pageIndex, Integer pageSize, String name, Date startTime, Date endTime, Integer grade, String agCode) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'pageIndex' is set
    if (pageIndex == null) {
       throw new ApiException(400, "Missing the required parameter 'pageIndex' when calling getUserPageList");
    }
    
    // verify the required parameter 'pageSize' is set
    if (pageSize == null) {
       throw new ApiException(400, "Missing the required parameter 'pageSize' when calling getUserPageList");
    }
    

    // create path and map variables
    String localVarPath = "/us/users".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "pageIndex", pageIndex));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "pageSize", pageSize));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "name", name));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "startTime", startTime));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "endTime", endTime));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "grade", grade));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "agCode", agCode));


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
        return (UserPageData) ApiInvoker.deserialize(localVarResponse, "", UserPageData.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u6839\u636EusId\u9501\u5B9A\u6216\u89E3\u9501\u7528\u6237
   * \u6839\u636EusId\u9501\u5B9A\u6216\u89E3\u9501\u7528\u6237\u3002\n
   * @param usId \u7528\u6237\u7684usId
   * @param lock \u9501\u5B9A\u6216\u89E3\u9501\u6807\u5FD7
   * @return GeneralString
   */
  public GeneralString  lockUser (Long usId, Boolean lock) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'usId' is set
    if (usId == null) {
       throw new ApiException(400, "Missing the required parameter 'usId' when calling lockUser");
    }
    
    // verify the required parameter 'lock' is set
    if (lock == null) {
       throw new ApiException(400, "Missing the required parameter 'lock' when calling lockUser");
    }
    

    // create path and map variables
    String localVarPath = "/us/users/{usId}/lock".replaceAll("\\{format\\}","json").replaceAll("\\{" + "usId" + "\\}", apiInvoker.escapeString(usId.toString()));

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
      
      if (lock != null) {
        localVarBuilder.addTextBody("lock", ApiInvoker.parameterToString(lock), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("lock", ApiInvoker.parameterToString(lock));
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
   * \u91CD\u7F6E\u5BC6\u7801
   * \u91CD\u7F6E\u5BC6\u7801\u3002\n
   * @param autoId id
   * @return GeneralString
   */
  public GeneralString  resetPwd (Long autoId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'autoId' is set
    if (autoId == null) {
       throw new ApiException(400, "Missing the required parameter 'autoId' when calling resetPwd");
    }
    

    // create path and map variables
    String localVarPath = "/us/admins/{autoId}/resetpwd".replaceAll("\\{format\\}","json").replaceAll("\\{" + "autoId" + "\\}", apiInvoker.escapeString(autoId.toString()));

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
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
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
  /**
   * app\u8BBE\u5907\u6CE8\u518C\u63A5\u53E3
   * app\u8BBE\u5907\u6CE8\u518C\u63A5\u53E3\u3002\n
   * @param type \u8BBE\u5907\u7C7B\u578Bios\u6216android.
   * @param deviceToken \u8BBE\u5907token.
   * @return GeneralString
   */
  public GeneralString  setDeviceToken (String type, String deviceToken) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'type' is set
    if (type == null) {
       throw new ApiException(400, "Missing the required parameter 'type' when calling setDeviceToken");
    }
    
    // verify the required parameter 'deviceToken' is set
    if (deviceToken == null) {
       throw new ApiException(400, "Missing the required parameter 'deviceToken' when calling setDeviceToken");
    }
    

    // create path and map variables
    String localVarPath = "/us/devices".replaceAll("\\{format\\}","json");

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
      
      if (type != null) {
        localVarBuilder.addTextBody("type", ApiInvoker.parameterToString(type), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (deviceToken != null) {
        localVarBuilder.addTextBody("deviceToken", ApiInvoker.parameterToString(deviceToken), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("type", ApiInvoker.parameterToString(type));
localVarFormParams.put("deviceToken", ApiInvoker.parameterToString(deviceToken));
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
   * \u8BBE\u7F6E\u4F1A\u5458\u7EA7\u522B\u4FE1\u606F
   * \u8BBE\u7F6E\u4F1A\u5458\u7EA7\u522B\u4FE1\u606F\u3002\n
   * @param grade \u4F1A\u5458\u7EA7\u522B
   * @param name \u4F1A\u5458\u7EA7\u522B\u540D\u79F0
   * @param money \u5145\u503C\u91D1\u989D
   * @param inviteMax \u9080\u8BF7\u4EBA\u6570\u9650\u5236
   * @param payBonus \u5145\u503C\u8FD4\u4F63\u6BD4\u4F8B  \u5355\u4F4D\uFF05.
   * @param rpBonus \u7EA2\u5305\u8FD4\u4F63\u6BD4\u4F8B  \u5355\u4F4D\uFF05.
   * @return GeneralString
   */
  public GeneralString  setGrade (Integer grade, String name, BigDecimal money, Integer inviteMax, Integer payBonus, Integer rpBonus) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'grade' is set
    if (grade == null) {
       throw new ApiException(400, "Missing the required parameter 'grade' when calling setGrade");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
       throw new ApiException(400, "Missing the required parameter 'name' when calling setGrade");
    }
    
    // verify the required parameter 'money' is set
    if (money == null) {
       throw new ApiException(400, "Missing the required parameter 'money' when calling setGrade");
    }
    
    // verify the required parameter 'inviteMax' is set
    if (inviteMax == null) {
       throw new ApiException(400, "Missing the required parameter 'inviteMax' when calling setGrade");
    }
    
    // verify the required parameter 'payBonus' is set
    if (payBonus == null) {
       throw new ApiException(400, "Missing the required parameter 'payBonus' when calling setGrade");
    }
    
    // verify the required parameter 'rpBonus' is set
    if (rpBonus == null) {
       throw new ApiException(400, "Missing the required parameter 'rpBonus' when calling setGrade");
    }
    

    // create path and map variables
    String localVarPath = "/us/grades/{grade}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "grade" + "\\}", apiInvoker.escapeString(grade.toString()));

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
      
      if (name != null) {
        localVarBuilder.addTextBody("name", ApiInvoker.parameterToString(name), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (money != null) {
        localVarBuilder.addTextBody("money", ApiInvoker.parameterToString(money), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (inviteMax != null) {
        localVarBuilder.addTextBody("inviteMax", ApiInvoker.parameterToString(inviteMax), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (payBonus != null) {
        localVarBuilder.addTextBody("payBonus", ApiInvoker.parameterToString(payBonus), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (rpBonus != null) {
        localVarBuilder.addTextBody("rpBonus", ApiInvoker.parameterToString(rpBonus), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("name", ApiInvoker.parameterToString(name));
localVarFormParams.put("money", ApiInvoker.parameterToString(money));
localVarFormParams.put("inviteMax", ApiInvoker.parameterToString(inviteMax));
localVarFormParams.put("payBonus", ApiInvoker.parameterToString(payBonus));
localVarFormParams.put("rpBonus", ApiInvoker.parameterToString(rpBonus));
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
  /**
   * \u540E\u53F0\u7BA1\u7406\u5458\u4FEE\u6539\u63A5\u53E3
   * \u540E\u53F0\u7BA1\u7406\u5458\u4FEE\u6539\u63A5\u53E3\u3002\n
   * @param autoId id
   * @param body \u7528\u6237\u7684\u4FE1\u606F
   * @return AdminInfo
   */
  public AdminInfo  updateAdmin (Long autoId, AddAdmin body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'autoId' is set
    if (autoId == null) {
       throw new ApiException(400, "Missing the required parameter 'autoId' when calling updateAdmin");
    }
    

    // create path and map variables
    String localVarPath = "/us/admins/{autoId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "autoId" + "\\}", apiInvoker.escapeString(autoId.toString()));

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
      String localVarResponse = apiInvoker.invokeAPI(basePath, localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);
      if(localVarResponse != null){
        return (AdminInfo) ApiInvoker.deserialize(localVarResponse, "", AdminInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u5FAE\u4FE1app\u6388\u6743\u63A5\u53E3
   * app\u8C03\u7528\u5FAE\u4FE1\u8FD4\u56DEcode app\u4F7F\u7528code\u8BBF\u95EE\u670D\u52A1\u5668\u6362\u56DE\u8BE5\u7528\u6237\u7684sessionId \u7528\u6237\u628AsessionId\u653E\u5230\u5934\u90E8\u4E2D\uFF0C\u5373\u53EF\u8BC6\u522B\u8BE5\u7528\u6237\uFF08\u5982\u679C\u7528\u6237\u4E0D\u5B58\u5728\u5219\u65B0\u5EFA\u7528\u6237\uFF09 \u82E5\u4E09\u4E2A\u53C2\u6570\u90FD\u6709\u5219 \u5C06\u624B\u673A\u53F7\u7ED1\u5B9A\u5230\u5FAE\u4FE1\u8D26\u6237  \u82E5\u65E0code\u53C2\u6570  \u67E5\u8BE2\u624B\u673A\u8D26\u6237\u662F\u5426\u5B58\u5728\uFF0C\u4E0D\u5B58\u5728\u521B\u5EFA\u8D26\u6237\uFF0C\u5B58\u5728\u5219\u624B\u673A\u53F7\u8D26\u6237\u767B\u5F55 \u82E5\u53EA\u6709code\u5219\u662F\u5FAE\u4FE1\u6388\u6743\u767B\u5F55
   * @param code \u5FAE\u4FE1\u56DE\u8C03\u65F6\u8FD4\u56DE\u7684code
   * @param mobile \u624B\u673A\u53F7
   * @param verifycode \u624B\u673A\u9A8C\u8BC1\u7801
   * @param bussId \u9A8C\u8BC1\u7801\u4E1A\u52A1id
   * @return WechatLoginInfo
   */
  public WechatLoginInfo  weChatAppOAuth2 (String code, String mobile, String verifycode, Long bussId) throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/us/wechats/app/oauth2".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "code", code));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "mobile", mobile));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "verifycode", verifycode));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "bussId", bussId));


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
        return (WechatLoginInfo) ApiInvoker.deserialize(localVarResponse, "", WechatLoginInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u5FAE\u4FE1\u516C\u4F17\u53F7\u83DC\u5355\u66F4\u65B0\u63A5\u53E3
   * \u66F4\u65B0\u5FAE\u4FE1\u516C\u4F17\u53F7\u7684\u83DC\u5355\u65F6\u8C03\u7528\u3002\n
   * @return GeneralString
   */
  public GeneralString  weChatCreateMenu () throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/us/wechats/menus".replaceAll("\\{format\\}","json");

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
   * \u5FAE\u4FE1\u4E34\u65F6\u7D20\u6750\u4E0B\u8F7D\u63A5\u53E3
   * \u5FAE\u4FE1\u4E34\u65F6\u7D20\u6750\u4E0B\u8F7D\u3002\n
   * @param mediaIds \u5FAE\u4FE1\u4E34\u65F6mediaid\u7684\u96C6\u5408\uFF0C\u82F1\u6587\u9017\u53F7\u5206\u5272.
   * @return List<String>
   */
  public List<String>  weChatDownloadMedia (String mediaIds) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'mediaIds' is set
    if (mediaIds == null) {
       throw new ApiException(400, "Missing the required parameter 'mediaIds' when calling weChatDownloadMedia");
    }
    

    // create path and map variables
    String localVarPath = "/us/wechats/media".replaceAll("\\{format\\}","json");

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
      
      if (mediaIds != null) {
        localVarBuilder.addTextBody("mediaIds", ApiInvoker.parameterToString(mediaIds), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("mediaIds", ApiInvoker.parameterToString(mediaIds));
    }

    try {
      String localVarResponse = apiInvoker.invokeAPI(basePath, localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);
      if(localVarResponse != null){
        return (List<String>) ApiInvoker.deserialize(localVarResponse, "array", String.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u5FAE\u4FE1\u7F51\u9875\u6388\u6743\u63A5\u53E3
   * \u5FAE\u4FE1\u516C\u4F17\u53F7\u5F00\u53D1\u65F6\uFF0C\u8C03\u7528\u6B64\u63A5\u53E3\u8FDB\u884C\u5FAE\u4FE1\u7F51\u9875\u6388\u6743\u3002\u6388\u6743\u5B8C\u6210\u540E\u4F1A\u5728header\u4E2D\u8FD4\u56DEsessionid\uFF0C\u6BCF\u6B21\u6388\u6743\u5B8C\u6210\u540E\nsessionid\u4F1A\u81EA\u52A8\u66F4\u65B0\uFF0C\u7528\u6237\u4FE1\u606F\u4E5F\u4F1A\u81EA\u52A8\u540C\u6B65\u5FAE\u4FE1\u7AEF\u4FE1\u606F\u8FDB\u884C\u66F4\u65B0\u3002\u524D\u7AEF\u8BF7\u6C42\u65F6\u9700\u5C06sessionid\u653E\u5728header\u4E2D\u8FDB\u884C\n\u8BF7\u6C42\uFF0C\u670D\u52A1\u6BB5\u4F1A\u9A8C\u8BC1sessionid\u662F\u5426\u5408\u6CD5\u3002\n
   * @param uri \u6388\u6743\u5B8C\u6210\u540E\u9700\u8981\u8DF3\u8F6C\u7684\u8DEF\u7531\u6216\u8005\u5B8C\u6574\u7F51\u7EDC\u5730\u5740.
   * @param type \u6388\u6743\u5B8C\u6210\u9700\u8981\u8DF3\u8F6C\u7684\u7C7B\u578B\uFF08router:\u8DEF\u7531 url:\u5B8C\u6574\u7F51\u7EDC\u5730\u5740\uFF09.
   * @param code \u5FAE\u4FE1\u56DE\u8C03\u65F6\u8FD4\u56DE\u7684code
   * @return void
   */
  public void  weChatOAuth2 (String uri, String type, String code) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'uri' is set
    if (uri == null) {
       throw new ApiException(400, "Missing the required parameter 'uri' when calling weChatOAuth2");
    }
    
    // verify the required parameter 'type' is set
    if (type == null) {
       throw new ApiException(400, "Missing the required parameter 'type' when calling weChatOAuth2");
    }
    

    // create path and map variables
    String localVarPath = "/us/wechats/oauth2".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "uri", uri));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "type", type));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "code", code));


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
        return ;
      }
      else {
        return ;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u5FAE\u4FE1js\u6388\u6743\u63A5\u53E3
   * \u83B7\u53D6\u5FAE\u4FE1js\u6388\u6743\u914D\u7F6E\u4FE1\u606F\u3002\n
   * @param url \u9700\u8981js\u6388\u6743\u7684\u5B8C\u6574\u7F51\u7EDC\u5730\u5740.
   * @return WxConfig
   */
  public WxConfig  weChatOAuth2JsConfig (String url) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'url' is set
    if (url == null) {
       throw new ApiException(400, "Missing the required parameter 'url' when calling weChatOAuth2JsConfig");
    }
    

    // create path and map variables
    String localVarPath = "/us/wechats/jsconfig".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "url", url));


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
        return (WxConfig) ApiInvoker.deserialize(localVarResponse, "", WxConfig.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
}
