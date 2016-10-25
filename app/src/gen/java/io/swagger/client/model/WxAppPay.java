package io.swagger.client.model;

import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * app\u8C03\u7528\u5FAE\u4FE1\u652F\u4ED8\u63A7\u4EF6\u7684\u53C2\u6570\u5BF9\u8C61
 **/
@ApiModel(description = "app\u8C03\u7528\u5FAE\u4FE1\u652F\u4ED8\u63A7\u4EF6\u7684\u53C2\u6570\u5BF9\u8C61")
public class WxAppPay  implements Serializable{
  
  @SerializedName("appId")
  private String appId = null;
  @SerializedName("timestamp")
  private Long timestamp = null;
  @SerializedName("nonceStr")
  private String nonceStr = null;
  @SerializedName("_package")
  private String _package = null;
  @SerializedName("partnerId")
  private String partnerId = null;
  @SerializedName("prepayId")
  private String prepayId = null;
  @SerializedName("sign")
  private String sign = null;

  /**
   * appid
   **/
  @ApiModelProperty(value = "appid")
  public String getAppId() {
    return appId;
  }
  public void setAppId(String appId) {
    this.appId = appId;
  }

  /**
   * \u65F6\u95F4\u6233
   **/
  @ApiModelProperty(value = "\u65F6\u95F4\u6233")
  public Long getTimestamp() {
    return timestamp;
  }
  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * \u968F\u673A\u5B57\u7B26\u4E32
   **/
  @ApiModelProperty(value = "\u968F\u673A\u5B57\u7B26\u4E32")
  public String getNonceStr() {
    return nonceStr;
  }
  public void setNonceStr(String nonceStr) {
    this.nonceStr = nonceStr;
  }

  /**
   * package  \u652F\u4ED8id\u53C2\u6570
   **/
  @ApiModelProperty(value = "package  \u652F\u4ED8id\u53C2\u6570")
  public String getPackage() {
    return _package;
  }
  public void setPackage(String _package) {
    this._package = _package;
  }

  /**
   * \u5546\u6237\u53F7
   **/
  @ApiModelProperty(value = "\u5546\u6237\u53F7")
  public String getPartnerId() {
    return partnerId;
  }
  public void setPartnerId(String partnerId) {
    this.partnerId = partnerId;
  }

  /**
   * \u9884\u4EA4\u6613\u53F7
   **/
  @ApiModelProperty(value = "\u9884\u4EA4\u6613\u53F7")
  public String getPrepayId() {
    return prepayId;
  }
  public void setPrepayId(String prepayId) {
    this.prepayId = prepayId;
  }

  /**
   * \u7B7E\u540D
   **/
  @ApiModelProperty(value = "\u7B7E\u540D")
  public String getSign() {
    return sign;
  }
  public void setSign(String sign) {
    this.sign = sign;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WxAppPay wxAppPay = (WxAppPay) o;
    return (appId == null ? wxAppPay.appId == null : appId.equals(wxAppPay.appId)) &&
        (timestamp == null ? wxAppPay.timestamp == null : timestamp.equals(wxAppPay.timestamp)) &&
        (nonceStr == null ? wxAppPay.nonceStr == null : nonceStr.equals(wxAppPay.nonceStr)) &&
        (_package == null ? wxAppPay._package == null : _package.equals(wxAppPay._package)) &&
        (partnerId == null ? wxAppPay.partnerId == null : partnerId.equals(wxAppPay.partnerId)) &&
        (prepayId == null ? wxAppPay.prepayId == null : prepayId.equals(wxAppPay.prepayId)) &&
        (sign == null ? wxAppPay.sign == null : sign.equals(wxAppPay.sign));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (appId == null ? 0: appId.hashCode());
    result = 31 * result + (timestamp == null ? 0: timestamp.hashCode());
    result = 31 * result + (nonceStr == null ? 0: nonceStr.hashCode());
    result = 31 * result + (_package == null ? 0: _package.hashCode());
    result = 31 * result + (partnerId == null ? 0: partnerId.hashCode());
    result = 31 * result + (prepayId == null ? 0: prepayId.hashCode());
    result = 31 * result + (sign == null ? 0: sign.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class WxAppPay {\n");
    
    sb.append("  appId: ").append(appId).append("\n");
    sb.append("  timestamp: ").append(timestamp).append("\n");
    sb.append("  nonceStr: ").append(nonceStr).append("\n");
    sb.append("  _package: ").append(_package).append("\n");
    sb.append("  partnerId: ").append(partnerId).append("\n");
    sb.append("  prepayId: ").append(prepayId).append("\n");
    sb.append("  sign: ").append(sign).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
