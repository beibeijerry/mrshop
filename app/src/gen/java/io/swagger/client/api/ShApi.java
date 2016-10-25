package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.Pair;

import io.swagger.client.model.*;

import java.util.*;

import io.swagger.client.model.GeneralString;
import io.swagger.client.model.CommentPageData;
import io.swagger.client.model.GoodsCategory;
import io.swagger.client.model.AddOrUpdateGoodsCategory;
import io.swagger.client.model.GoodsCategoryPageData;
import io.swagger.client.model.GoodsPageData;
import io.swagger.client.model.GoodsInfo;
import io.swagger.client.model.AddOrUpdateGoodsInfo;
import io.swagger.client.model.GoodsReq;
import io.swagger.client.model.AddOrUpdateGoodsReq;
import java.util.Date;
import io.swagger.client.model.AdminGoodsOrderPageData;
import io.swagger.client.model.AdminGoodsOrder;
import io.swagger.client.model.Comment;
import io.swagger.client.model.AddComment;
import io.swagger.client.model.SimpleGoodsInfo;
import io.swagger.client.model.SimpleAppGoodsOrder;
import io.swagger.client.model.AppGoodsOrder;
import io.swagger.client.model.AddGoodsOrder;
import io.swagger.client.model.ShippingAddress;
import io.swagger.client.model.AddOrUpdateShippingAddress;
import java.util.*;
import io.swagger.client.model.ShInfoSettingVersion;

import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class ShApi extends BaseApi{
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
   * \u5C4F\u853D\u5546\u54C1\u8BC4\u8BBA
   * 
   * @param commentId 
   * @return GeneralString
   */
  public GeneralString  shAdminCommentsCommentIdDelete (Long commentId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'commentId' is set
    if (commentId == null) {
       throw new ApiException(400, "Missing the required parameter 'commentId' when calling shAdminCommentsCommentIdDelete");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/comments/{commentId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "commentId" + "\\}", apiInvoker.escapeString(commentId.toString()));

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
   * \u540E\u53F0\u83B7\u53D6\u5546\u54C1\u8BC4\u8BBA\u5217\u8868
   * 
   * @param pageIndex \u8D77\u59CB\u9875.
   * @param pageSize \u6BCF\u9875\u8BB0\u5F55\u6570.
   * @param goodsId \u5546\u54C1id
   * @return CommentPageData
   */
  public CommentPageData  shAdminCommentsGet (Integer pageIndex, Integer pageSize, Long goodsId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'pageIndex' is set
    if (pageIndex == null) {
       throw new ApiException(400, "Missing the required parameter 'pageIndex' when calling shAdminCommentsGet");
    }
    
    // verify the required parameter 'pageSize' is set
    if (pageSize == null) {
       throw new ApiException(400, "Missing the required parameter 'pageSize' when calling shAdminCommentsGet");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/comments".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "goodsId", goodsId));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "pageIndex", pageIndex));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "pageSize", pageSize));


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
        return (CommentPageData) ApiInvoker.deserialize(localVarResponse, "", CommentPageData.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u5220\u9664\u5206\u7C7B
   * 
   * @param auId 
   * @return GeneralString
   */
  public GeneralString  shAdminGoodsCategorysAuIdDelete (Long auId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'auId' is set
    if (auId == null) {
       throw new ApiException(400, "Missing the required parameter 'auId' when calling shAdminGoodsCategorysAuIdDelete");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/goods/categorys/{auId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "auId" + "\\}", apiInvoker.escapeString(auId.toString()));

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
   * \u83B7\u53D6\u5355\u4E2A\u5206\u7C7B\u4FE1\u606F
   * 
   * @param auId 
   * @return GoodsCategory
   */
  public GoodsCategory  shAdminGoodsCategorysAuIdGet (Long auId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'auId' is set
    if (auId == null) {
       throw new ApiException(400, "Missing the required parameter 'auId' when calling shAdminGoodsCategorysAuIdGet");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/goods/categorys/{auId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "auId" + "\\}", apiInvoker.escapeString(auId.toString()));

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
        return (GoodsCategory) ApiInvoker.deserialize(localVarResponse, "", GoodsCategory.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u66F4\u65B0\u5206\u7C7B\u4FE1\u606F
   * 
   * @param auId 
   * @param body 
   * @return GoodsCategory
   */
  public GoodsCategory  shAdminGoodsCategorysAuIdPut (Long auId, AddOrUpdateGoodsCategory body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'auId' is set
    if (auId == null) {
       throw new ApiException(400, "Missing the required parameter 'auId' when calling shAdminGoodsCategorysAuIdPut");
    }
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling shAdminGoodsCategorysAuIdPut");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/goods/categorys/{auId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "auId" + "\\}", apiInvoker.escapeString(auId.toString()));

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
        return (GoodsCategory) ApiInvoker.deserialize(localVarResponse, "", GoodsCategory.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u540E\u53F0\u83B7\u53D6\u5546\u54C1\u5206\u7C7B\u5217\u8868
   * 
   * @param pageIndex \u8D77\u59CB\u9875.
   * @param pageSize \u6BCF\u9875\u8BB0\u5F55\u6570.
   * @return List<GoodsCategoryPageData>
   */
  public List<GoodsCategoryPageData>  shAdminGoodsCategorysGet (Integer pageIndex, Integer pageSize) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'pageIndex' is set
    if (pageIndex == null) {
       throw new ApiException(400, "Missing the required parameter 'pageIndex' when calling shAdminGoodsCategorysGet");
    }
    
    // verify the required parameter 'pageSize' is set
    if (pageSize == null) {
       throw new ApiException(400, "Missing the required parameter 'pageSize' when calling shAdminGoodsCategorysGet");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/goods/categorys".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "pageIndex", pageIndex));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "pageSize", pageSize));


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
        return (List<GoodsCategoryPageData>) ApiInvoker.deserialize(localVarResponse, "array", GoodsCategoryPageData.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u6DFB\u52A0\u5206\u7C7B
   * 
   * @param body 
   * @return GoodsCategory
   */
  public GoodsCategory  shAdminGoodsCategorysPost (AddOrUpdateGoodsCategory body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling shAdminGoodsCategorysPost");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/goods/categorys".replaceAll("\\{format\\}","json");

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
        return (GoodsCategory) ApiInvoker.deserialize(localVarResponse, "", GoodsCategory.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u540E\u53F0\u83B7\u53D6\u5546\u54C1\u5217\u8868
   * 
   * @param pageIndex \u8D77\u59CB\u9875.
   * @param pageSize \u6BCF\u9875\u8BB0\u5F55\u6570.
   * @param categoryId \u5206\u7C7Bid
   * @param title \u5546\u54C1\u6807\u9898\u6A21\u7CCA\u67E5\u8BE2
   * @param status \u72B6\u6001 0 \u672A\u4E0A\u67B6\uFF0C\u7F16\u8F91\u4E2D  1 \u5DF2\u4E0A\u67B6  2 \u5DF2\u4E0B\u67B6
   * @return List<GoodsPageData>
   */
  public List<GoodsPageData>  shAdminGoodsGet (Integer pageIndex, Integer pageSize, Long categoryId, String title, Integer status) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'pageIndex' is set
    if (pageIndex == null) {
       throw new ApiException(400, "Missing the required parameter 'pageIndex' when calling shAdminGoodsGet");
    }
    
    // verify the required parameter 'pageSize' is set
    if (pageSize == null) {
       throw new ApiException(400, "Missing the required parameter 'pageSize' when calling shAdminGoodsGet");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/goods".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "pageIndex", pageIndex));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "pageSize", pageSize));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "categoryId", categoryId));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "title", title));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "status", status));


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
        return (List<GoodsPageData>) ApiInvoker.deserialize(localVarResponse, "array", GoodsPageData.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u5220\u9664\u5546\u54C1
   * 
   * @param goodsId 
   * @return GeneralString
   */
  public GeneralString  shAdminGoodsGoodsIdDelete (Long goodsId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'goodsId' is set
    if (goodsId == null) {
       throw new ApiException(400, "Missing the required parameter 'goodsId' when calling shAdminGoodsGoodsIdDelete");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/goods/{goodsId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "goodsId" + "\\}", apiInvoker.escapeString(goodsId.toString()));

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
   * \u4FEE\u6539\u5546\u54C1
   * 
   * @param goodsId 
   * @param body 
   * @return GoodsInfo
   */
  public GoodsInfo  shAdminGoodsGoodsIdPut (Long goodsId, AddOrUpdateGoodsInfo body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'goodsId' is set
    if (goodsId == null) {
       throw new ApiException(400, "Missing the required parameter 'goodsId' when calling shAdminGoodsGoodsIdPut");
    }
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling shAdminGoodsGoodsIdPut");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/goods/{goodsId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "goodsId" + "\\}", apiInvoker.escapeString(goodsId.toString()));

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
        return (GoodsInfo) ApiInvoker.deserialize(localVarResponse, "", GoodsInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u4E0A\u4E0B\u67B6\u63A5\u53E3
   * 
   * @param goodsId 
   * @param status 1 \u4E0A\u67B6  2 \u4E0B\u67B6
   * @return GeneralString
   */
  public GeneralString  shAdminGoodsGoodsIdSalesPut (Long goodsId, Integer status) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'goodsId' is set
    if (goodsId == null) {
       throw new ApiException(400, "Missing the required parameter 'goodsId' when calling shAdminGoodsGoodsIdSalesPut");
    }
    
    // verify the required parameter 'status' is set
    if (status == null) {
       throw new ApiException(400, "Missing the required parameter 'status' when calling shAdminGoodsGoodsIdSalesPut");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/goods/{goodsId}/sales".replaceAll("\\{format\\}","json").replaceAll("\\{" + "goodsId" + "\\}", apiInvoker.escapeString(goodsId.toString()));

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
      
      if (status != null) {
        localVarBuilder.addTextBody("status", ApiInvoker.parameterToString(status), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("status", ApiInvoker.parameterToString(status));
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
   * \u7F6E\u9876\u5546\u54C1
   * 
   * @param goodsId 
   * @return GeneralString
   */
  public GeneralString  shAdminGoodsGoodsIdTopPut (Long goodsId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'goodsId' is set
    if (goodsId == null) {
       throw new ApiException(400, "Missing the required parameter 'goodsId' when calling shAdminGoodsGoodsIdTopPut");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/goods/{goodsId}/top".replaceAll("\\{format\\}","json").replaceAll("\\{" + "goodsId" + "\\}", apiInvoker.escapeString(goodsId.toString()));

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
   * \u65B0\u589E\u5546\u54C1
   * 
   * @param body 
   * @return GoodsInfo
   */
  public GoodsInfo  shAdminGoodsPost (AddOrUpdateGoodsInfo body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling shAdminGoodsPost");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/goods".replaceAll("\\{format\\}","json");

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
        return (GoodsInfo) ApiInvoker.deserialize(localVarResponse, "", GoodsInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u65B0\u589E\u5546\u54C1\u5E93\u5B58\uFF08\u5F03\u7528\uFF09
   * 
   * @param body 
   * @return GoodsReq
   */
  public GoodsReq  shAdminGoodsReqsPost (AddOrUpdateGoodsReq body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling shAdminGoodsReqsPost");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/goods/reqs".replaceAll("\\{format\\}","json");

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
        return (GoodsReq) ApiInvoker.deserialize(localVarResponse, "", GoodsReq.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u5220\u9664\u5546\u54C1\u5E93\u5B58\uFF08\u5F03\u7528\uFF09
   * 
   * @param reqId 
   * @return GeneralString
   */
  public GeneralString  shAdminGoodsReqsReqIdDelete (Long reqId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reqId' is set
    if (reqId == null) {
       throw new ApiException(400, "Missing the required parameter 'reqId' when calling shAdminGoodsReqsReqIdDelete");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/goods/reqs/{reqId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "reqId" + "\\}", apiInvoker.escapeString(reqId.toString()));

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
   * \u65B0\u589E\u5546\u54C1\u5E93\u5B58\uFF08\u5F03\u7528\uFF09
   * 
   * @param reqId 
   * @param body 
   * @return GoodsReq
   */
  public GoodsReq  shAdminGoodsReqsReqIdPut (Long reqId, AddOrUpdateGoodsReq body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'reqId' is set
    if (reqId == null) {
       throw new ApiException(400, "Missing the required parameter 'reqId' when calling shAdminGoodsReqsReqIdPut");
    }
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling shAdminGoodsReqsReqIdPut");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/goods/reqs/{reqId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "reqId" + "\\}", apiInvoker.escapeString(reqId.toString()));

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
        return (GoodsReq) ApiInvoker.deserialize(localVarResponse, "", GoodsReq.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u540E\u53F0\u83B7\u53D6\u5546\u54C1\u8BA2\u5355\u5217\u8868
   * 
   * @param pageIndex \u8D77\u59CB\u9875.
   * @param pageSize \u6BCF\u9875\u8BB0\u5F55\u6570.
   * @param goodsId \u5546\u54C1id
   * @param usName \u7528\u6237\u6635\u79F0\u6A21\u7CCA\u67E5\u8BE2
   * @param startTime \u8BA2\u5355\u8D77\u59CB\u65F6\u95F4
   * @param endTime \u8BA2\u5355\u622A\u6B62\u65F6\u95F4
   * @param status \u8BA2\u5355\u72B6\u6001\uFF1A 0 \u4EE3\u4ED8\u6B3E  1 \u4EE3\u53D1\u8D27  2 \u5DF2\u53D1\u8D27  3 \u5F85\u8BC4\u4EF7  4 \u5DF2\u5B8C\u6210   5\u5173\u95ED
   * @param title \u66F4\u52A0\u5546\u54C1\u6807\u9898\u6A21\u7CCA\u67E5\u8BE2
   * @param orderNo 
   * @return AdminGoodsOrderPageData
   */
  public AdminGoodsOrderPageData  shAdminOrdersGet (Integer pageIndex, Integer pageSize, Long goodsId, String usName, Date startTime, Date endTime, Integer status, String title, String orderNo) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'pageIndex' is set
    if (pageIndex == null) {
       throw new ApiException(400, "Missing the required parameter 'pageIndex' when calling shAdminOrdersGet");
    }
    
    // verify the required parameter 'pageSize' is set
    if (pageSize == null) {
       throw new ApiException(400, "Missing the required parameter 'pageSize' when calling shAdminOrdersGet");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/orders".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "goodsId", goodsId));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "usName", usName));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "startTime", startTime));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "endTime", endTime));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "status", status));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "title", title));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "orderNo", orderNo));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "pageIndex", pageIndex));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "pageSize", pageSize));


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
        return (AdminGoodsOrderPageData) ApiInvoker.deserialize(localVarResponse, "", AdminGoodsOrderPageData.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u83B7\u53D6\u8BA2\u5355\u8BE6\u60C5
   * 
   * @param orderNo \u8BA2\u5355\u53F7
   * @return AdminGoodsOrder
   */
  public AdminGoodsOrder  shAdminOrdersOrderNoGet (String orderNo) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'orderNo' is set
    if (orderNo == null) {
       throw new ApiException(400, "Missing the required parameter 'orderNo' when calling shAdminOrdersOrderNoGet");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/orders/{orderNo}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "orderNo" + "\\}", apiInvoker.escapeString(orderNo.toString()));

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
        return (AdminGoodsOrder) ApiInvoker.deserialize(localVarResponse, "", AdminGoodsOrder.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u53D1\u8D27
   * 
   * @param orderNo 
   * @param logisticsName \u7269\u6D41\u516C\u53F8\u540D\u79F0
   * @param logisticsNo \u7269\u6D41\u7F16\u53F7
   * @return GeneralString
   */
  public GeneralString  shAdminOrdersOrderNoPut (String orderNo, String logisticsName, String logisticsNo) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'orderNo' is set
    if (orderNo == null) {
       throw new ApiException(400, "Missing the required parameter 'orderNo' when calling shAdminOrdersOrderNoPut");
    }
    

    // create path and map variables
    String localVarPath = "/sh/admin/orders/{orderNo}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "orderNo" + "\\}", apiInvoker.escapeString(orderNo.toString()));

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
      
      if (logisticsName != null) {
        localVarBuilder.addTextBody("logisticsName", ApiInvoker.parameterToString(logisticsName), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      
      if (logisticsNo != null) {
        localVarBuilder.addTextBody("logisticsNo", ApiInvoker.parameterToString(logisticsNo), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("logisticsName", ApiInvoker.parameterToString(logisticsName));
localVarFormParams.put("logisticsNo", ApiInvoker.parameterToString(logisticsNo));
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
   * \u83B7\u53D6\u8BC4\u8BBA
   * 
   * @param goodsId 
   * @param lastComentTime \u4E0A\u4E2A\u8BC4\u8BBA\u7684\u65F6\u95F4
   * @param count \u83B7\u53D6\u4E2A\u6570\uFF0C\u9ED8\u8BA45\u4E2A
   * @return List<Comment>
   */
  public List<Comment>  shAppCommentsGet (Long goodsId, Date lastComentTime, Integer count) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'goodsId' is set
    if (goodsId == null) {
       throw new ApiException(400, "Missing the required parameter 'goodsId' when calling shAppCommentsGet");
    }
    

    // create path and map variables
    String localVarPath = "/sh/app/comments".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "goodsId", goodsId));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "lastComentTime", lastComentTime));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "count", count));


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
        return (List<Comment>) ApiInvoker.deserialize(localVarResponse, "array", Comment.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u53D1\u8868\u8BC4\u8BBA
   * 
   * @param body 
   * @return Comment
   */
  public Comment  shAppCommentsPost (AddComment body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling shAppCommentsPost");
    }
    

    // create path and map variables
    String localVarPath = "/sh/app/comments".replaceAll("\\{format\\}","json");

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
        return (Comment) ApiInvoker.deserialize(localVarResponse, "", Comment.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * app\u83B7\u53D6\u5546\u54C1\u5206\u7C7B\u5217\u8868
   * 
   * @param sort \u83B7\u53D6\u8FC7\u7684\u4E0A\u4E2A\u5206\u7C7B\u7684\u6392\u5E8F\u53F7\uFF0C\u9ED8\u8BA40
   * @param count \u83B7\u53D6\u6570\u91CF\uFF0C\u9ED8\u8BA45\u4E2A
   * @return List<GoodsCategory>
   */
  public List<GoodsCategory>  shAppGoodsCategorysGet (Integer sort, Integer count) throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/sh/app/goods/categorys".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "count", count));


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
        return (List<GoodsCategory>) ApiInvoker.deserialize(localVarResponse, "array", GoodsCategory.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u83B7\u53D6\u5546\u54C1\u5217\u8868
   * 
   * @param categoryId \u5206\u7C7Bid
   * @param lastTopTime \u4E0A\u4E00\u4E2A\u5546\u54C1\u7684\u7F6E\u9876\u65F6\u95F4\uFF08\u6309\u7167\u8BBE\u7F6E\u7F6E\u9876\u7684\u65F6\u95F4\u6392\u5E8F\uFF09
   * @param count \u83B7\u53D6\u6570\u91CF\uFF0C\u9ED8\u8BA45\u4E2A
   * @return SimpleGoodsInfo
   */
  public SimpleGoodsInfo  shAppGoodsGet (Long categoryId, Date lastTopTime, Integer count) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'categoryId' is set
    if (categoryId == null) {
       throw new ApiException(400, "Missing the required parameter 'categoryId' when calling shAppGoodsGet");
    }
    

    // create path and map variables
    String localVarPath = "/sh/app/goods".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "categoryId", categoryId));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "lastTopTime", lastTopTime));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "count", count));


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
        return (SimpleGoodsInfo) ApiInvoker.deserialize(localVarResponse, "", SimpleGoodsInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u83B7\u53D6\u6211\u7684\u8BA2\u5355
   * 
   * @param status 0 \u4EE3\u4ED8\u6B3E  1 \u4EE3\u53D1\u8D27  2 \u5DF2\u53D1\u8D27  3 \u5F85\u8BC4\u4EF7  4 \u5DF2\u5B8C\u6210  5 \u5DF2\u5173\u95ED
   * @param count \u83B7\u53D6\u6570\u91CF
   * @param lastCreateTime \u4E0A\u4E2A\u8BA2\u5355\u7684\u65F6\u95F4
   * @return List<SimpleAppGoodsOrder>
   */
  public List<SimpleAppGoodsOrder>  shAppOrdersGet (Integer status, Integer count, Date lastCreateTime) throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/sh/app/orders".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "status", status));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "count", count));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "lastCreateTime", lastCreateTime));


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
        return (List<SimpleAppGoodsOrder>) ApiInvoker.deserialize(localVarResponse, "array", SimpleAppGoodsOrder.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u83B7\u53D6\u8BA2\u5355\u8BE6\u60C5
   * 
   * @param orderNo \u8BA2\u5355\u53F7
   * @return AppGoodsOrder
   */
  public AppGoodsOrder  shAppOrdersOrderNoGet (String orderNo) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'orderNo' is set
    if (orderNo == null) {
       throw new ApiException(400, "Missing the required parameter 'orderNo' when calling shAppOrdersOrderNoGet");
    }
    

    // create path and map variables
    String localVarPath = "/sh/app/orders/{orderNo}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "orderNo" + "\\}", apiInvoker.escapeString(orderNo.toString()));

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
        return (AppGoodsOrder) ApiInvoker.deserialize(localVarResponse, "", AppGoodsOrder.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u786E\u8BA4\u6536\u8D27/\u53D6\u6D88\u8BA2\u5355
   * 
   * @param orderNo \u8BA2\u5355\u53F7
   * @param status \u72B6\u6001  3 \u786E\u8BA4\u6536\u8D27  5 \u5173\u95ED
   * @return GeneralString
   */
  public GeneralString  shAppOrdersOrderNoPut (String orderNo, Integer status) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'orderNo' is set
    if (orderNo == null) {
       throw new ApiException(400, "Missing the required parameter 'orderNo' when calling shAppOrdersOrderNoPut");
    }
    
    // verify the required parameter 'status' is set
    if (status == null) {
       throw new ApiException(400, "Missing the required parameter 'status' when calling shAppOrdersOrderNoPut");
    }
    

    // create path and map variables
    String localVarPath = "/sh/app/orders/{orderNo}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "orderNo" + "\\}", apiInvoker.escapeString(orderNo.toString()));

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
      
      if (status != null) {
        localVarBuilder.addTextBody("status", ApiInvoker.parameterToString(status), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("status", ApiInvoker.parameterToString(status));
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
   * \u521B\u5EFA\u8BA2\u5355
   * 
   * @param body 
   * @return AppGoodsOrder
   */
  public AppGoodsOrder  shAppOrdersPost (AddGoodsOrder body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling shAppOrdersPost");
    }
    

    // create path and map variables
    String localVarPath = "/sh/app/orders".replaceAll("\\{format\\}","json");

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
        return (AppGoodsOrder) ApiInvoker.deserialize(localVarResponse, "", AppGoodsOrder.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u5220\u9664\u7528\u6237\u5730\u5740
   * 
   * @param addressId 
   * @return GeneralString
   */
  public GeneralString  shAppShippingaddressAddressIdDelete (Long addressId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'addressId' is set
    if (addressId == null) {
       throw new ApiException(400, "Missing the required parameter 'addressId' when calling shAppShippingaddressAddressIdDelete");
    }
    

    // create path and map variables
    String localVarPath = "/sh/app/shippingaddress/{addressId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "addressId" + "\\}", apiInvoker.escapeString(addressId.toString()));

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
   * \u83B7\u53D6\u5355\u4E2A\u6536\u8D27\u5730\u5740\u4FE1\u606F
   * 
   * @param addressId 
   * @return ShippingAddress
   */
  public ShippingAddress  shAppShippingaddressAddressIdGet (Long addressId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'addressId' is set
    if (addressId == null) {
       throw new ApiException(400, "Missing the required parameter 'addressId' when calling shAppShippingaddressAddressIdGet");
    }
    

    // create path and map variables
    String localVarPath = "/sh/app/shippingaddress/{addressId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "addressId" + "\\}", apiInvoker.escapeString(addressId.toString()));

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
        return (ShippingAddress) ApiInvoker.deserialize(localVarResponse, "", ShippingAddress.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u4FEE\u6539\u6536\u8D27\u5730\u5740
   * 
   * @param addressId 
   * @param body 
   * @return ShippingAddress
   */
  public ShippingAddress  shAppShippingaddressAddressIdPut (Long addressId, AddOrUpdateShippingAddress body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'addressId' is set
    if (addressId == null) {
       throw new ApiException(400, "Missing the required parameter 'addressId' when calling shAppShippingaddressAddressIdPut");
    }
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling shAppShippingaddressAddressIdPut");
    }
    

    // create path and map variables
    String localVarPath = "/sh/app/shippingaddress/{addressId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "addressId" + "\\}", apiInvoker.escapeString(addressId.toString()));

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
        return (ShippingAddress) ApiInvoker.deserialize(localVarResponse, "", ShippingAddress.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u83B7\u53D6\u7528\u6237\u5730\u5740
   * 
   * @return List<ShippingAddress>
   */
  public List<ShippingAddress>  shAppShippingaddressGet () throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/sh/app/shippingaddress".replaceAll("\\{format\\}","json");

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
        return (List<ShippingAddress>) ApiInvoker.deserialize(localVarResponse, "array", ShippingAddress.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u65B0\u589E\u6536\u8D27\u5730\u5740
   * 
   * @param body 
   * @return ShippingAddress
   */
  public ShippingAddress  shAppShippingaddressPost (AddOrUpdateShippingAddress body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling shAppShippingaddressPost");
    }
    

    // create path and map variables
    String localVarPath = "/sh/app/shippingaddress".replaceAll("\\{format\\}","json");

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
        return (ShippingAddress) ApiInvoker.deserialize(localVarResponse, "", ShippingAddress.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u83B7\u53D6\u5546\u54C1\u8BE6\u60C5
   * 
   * @param goodsId 
   * @return GoodsInfo
   */
  public GoodsInfo  shGoodsGoodsIdGet (Long goodsId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'goodsId' is set
    if (goodsId == null) {
       throw new ApiException(400, "Missing the required parameter 'goodsId' when calling shGoodsGoodsIdGet");
    }
    

    // create path and map variables
    String localVarPath = "/sh/goods/{goodsId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "goodsId" + "\\}", apiInvoker.escapeString(goodsId.toString()));

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
        return (GoodsInfo) ApiInvoker.deserialize(localVarResponse, "", GoodsInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u83B7\u53D6\u9996\u9875\u63A8\u8350\u554A\u4F4D\u7F6E\u5546\u54C1\u7B80\u5355\u4FE1\u606F\u3002
   * 
   * @return List<SimpleGoodsInfo>
   */
  public List<SimpleGoodsInfo>  shHomesettingGet () throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/sh/homesetting".replaceAll("\\{format\\}","json");

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
        return (List<SimpleGoodsInfo>) ApiInvoker.deserialize(localVarResponse, "array", SimpleGoodsInfo.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  /**
   * \u66F4\u65B0\u9996\u9875\u63A8\u8350\u4F4D\u5546\u54C1
   * 
   * @param body \u5546\u54C1id array
   * @return GeneralString
   */
  public GeneralString  shHomesettingPut (List<Long> body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling shHomesettingPut");
    }
    

    // create path and map variables
    String localVarPath = "/sh/homesetting".replaceAll("\\{format\\}","json");

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
   * \u6DFB\u52A0\u5546\u54C1\u8FDB\u5165\u9996\u9875\u8F6E\u64AD\u56FE/\u53D6\u6D88\u5546\u54C1\u9996\u9875\u8F6E\u64AD\u56FE
   * 
   * @param goodsId 
   * @return GeneralString
   */
  public GeneralString  shHomesettingTogglePost (Long goodsId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'goodsId' is set
    if (goodsId == null) {
       throw new ApiException(400, "Missing the required parameter 'goodsId' when calling shHomesettingTogglePost");
    }
    

    // create path and map variables
    String localVarPath = "/sh/homesetting/toggle".replaceAll("\\{format\\}","json");

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
      
      if (goodsId != null) {
        localVarBuilder.addTextBody("goodsId", ApiInvoker.parameterToString(goodsId), ApiInvoker.TEXT_PLAIN_UTF8);
      }
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      localVarFormParams.put("goodsId", ApiInvoker.parameterToString(goodsId));
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
   * \u83B7\u53D6\u7248\u672C\u4FE1\u606F
   * 
   * @return ShInfoSettingVersion
   */
  public ShInfoSettingVersion  shVersionGet () throws ApiException {
    Object localVarPostBody = null;
    

    // create path and map variables
    String localVarPath = "/sh/version".replaceAll("\\{format\\}","json");

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
        return (ShInfoSettingVersion) ApiInvoker.deserialize(localVarResponse, "", ShInfoSettingVersion.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
}
