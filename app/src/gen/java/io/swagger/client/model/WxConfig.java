package io.swagger.client.model;

import java.util.*;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u5FAE\u4FE1js\u914D\u7F6E\u5BF9\u8C61
 **/
@ApiModel(description = "\u5FAE\u4FE1js\u914D\u7F6E\u5BF9\u8C61")
public class WxConfig  implements Serializable{
  
  @SerializedName("debug")
  private Boolean debug = null;
  @SerializedName("appId")
  private String appId = null;
  @SerializedName("noncestr")
  private String noncestr = null;
  @SerializedName("timestamp")
  private Integer timestamp = null;
  @SerializedName("signature")
  private String signature = null;
  @SerializedName("jsApiList")
  private List<String> jsApiList = null;

  /**
   * \u662F\u5426\u662Fdebug\u6A21\u5F0F
   **/
  @ApiModelProperty(value = "\u662F\u5426\u662Fdebug\u6A21\u5F0F")
  public Boolean getDebug() {
    return debug;
  }
  public void setDebug(Boolean debug) {
    this.debug = debug;
  }

  /**
   * \u5E94\u7528\u7684appId
   **/
  @ApiModelProperty(value = "\u5E94\u7528\u7684appId")
  public String getAppId() {
    return appId;
  }
  public void setAppId(String appId) {
    this.appId = appId;
  }

  /**
   * \u968F\u673A\u5B57\u7B26\u4E32
   **/
  @ApiModelProperty(value = "\u968F\u673A\u5B57\u7B26\u4E32")
  public String getNoncestr() {
    return noncestr;
  }
  public void setNoncestr(String noncestr) {
    this.noncestr = noncestr;
  }

  /**
   * \u65F6\u95F4\u6233
   **/
  @ApiModelProperty(value = "\u65F6\u95F4\u6233")
  public Integer getTimestamp() {
    return timestamp;
  }
  public void setTimestamp(Integer timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * sha1\u7B7E\u540D
   **/
  @ApiModelProperty(value = "sha1\u7B7E\u540D")
  public String getSignature() {
    return signature;
  }
  public void setSignature(String signature) {
    this.signature = signature;
  }

  /**
   * js api\u4FE1\u606F
   **/
  @ApiModelProperty(value = "js api\u4FE1\u606F")
  public List<String> getJsApiList() {
    return jsApiList;
  }
  public void setJsApiList(List<String> jsApiList) {
    this.jsApiList = jsApiList;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WxConfig wxConfig = (WxConfig) o;
    return (debug == null ? wxConfig.debug == null : debug.equals(wxConfig.debug)) &&
        (appId == null ? wxConfig.appId == null : appId.equals(wxConfig.appId)) &&
        (noncestr == null ? wxConfig.noncestr == null : noncestr.equals(wxConfig.noncestr)) &&
        (timestamp == null ? wxConfig.timestamp == null : timestamp.equals(wxConfig.timestamp)) &&
        (signature == null ? wxConfig.signature == null : signature.equals(wxConfig.signature)) &&
        (jsApiList == null ? wxConfig.jsApiList == null : jsApiList.equals(wxConfig.jsApiList));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (debug == null ? 0: debug.hashCode());
    result = 31 * result + (appId == null ? 0: appId.hashCode());
    result = 31 * result + (noncestr == null ? 0: noncestr.hashCode());
    result = 31 * result + (timestamp == null ? 0: timestamp.hashCode());
    result = 31 * result + (signature == null ? 0: signature.hashCode());
    result = 31 * result + (jsApiList == null ? 0: jsApiList.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class WxConfig {\n");
    
    sb.append("  debug: ").append(debug).append("\n");
    sb.append("  appId: ").append(appId).append("\n");
    sb.append("  noncestr: ").append(noncestr).append("\n");
    sb.append("  timestamp: ").append(timestamp).append("\n");
    sb.append("  signature: ").append(signature).append("\n");
    sb.append("  jsApiList: ").append(jsApiList).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
