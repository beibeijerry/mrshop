package io.swagger.client.model;

import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u8C03\u7528\u5FAE\u4FE1\u652F\u4ED8\u63A7\u4EF6\u7684\u53C2\u6570\u5BF9\u8C61
 **/
@ApiModel(description = "\u8C03\u7528\u5FAE\u4FE1\u652F\u4ED8\u63A7\u4EF6\u7684\u53C2\u6570\u5BF9\u8C61")
public class WxPay  implements Serializable{
  
  @SerializedName("appId")
  private String appId = null;
  @SerializedName("timestamp")
  private Long timestamp = null;
  @SerializedName("nonceStr")
  private String nonceStr = null;
  @SerializedName("_package")
  private String _package = null;
  @SerializedName("signType")
  private String signType = null;
  @SerializedName("paySign")
  private String paySign = null;

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
   * \u7B7E\u540D\u7C7B\u578B
   **/
  @ApiModelProperty(value = "\u7B7E\u540D\u7C7B\u578B")
  public String getSignType() {
    return signType;
  }
  public void setSignType(String signType) {
    this.signType = signType;
  }

  /**
   * \u7B7E\u540D
   **/
  @ApiModelProperty(value = "\u7B7E\u540D")
  public String getPaySign() {
    return paySign;
  }
  public void setPaySign(String paySign) {
    this.paySign = paySign;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WxPay wxPay = (WxPay) o;
    return (appId == null ? wxPay.appId == null : appId.equals(wxPay.appId)) &&
        (timestamp == null ? wxPay.timestamp == null : timestamp.equals(wxPay.timestamp)) &&
        (nonceStr == null ? wxPay.nonceStr == null : nonceStr.equals(wxPay.nonceStr)) &&
        (_package == null ? wxPay._package == null : _package.equals(wxPay._package)) &&
        (signType == null ? wxPay.signType == null : signType.equals(wxPay.signType)) &&
        (paySign == null ? wxPay.paySign == null : paySign.equals(wxPay.paySign));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (appId == null ? 0: appId.hashCode());
    result = 31 * result + (timestamp == null ? 0: timestamp.hashCode());
    result = 31 * result + (nonceStr == null ? 0: nonceStr.hashCode());
    result = 31 * result + (_package == null ? 0: _package.hashCode());
    result = 31 * result + (signType == null ? 0: signType.hashCode());
    result = 31 * result + (paySign == null ? 0: paySign.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class WxPay {\n");
    
    sb.append("  appId: ").append(appId).append("\n");
    sb.append("  timestamp: ").append(timestamp).append("\n");
    sb.append("  nonceStr: ").append(nonceStr).append("\n");
    sb.append("  _package: ").append(_package).append("\n");
    sb.append("  signType: ").append(signType).append("\n");
    sb.append("  paySign: ").append(paySign).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
