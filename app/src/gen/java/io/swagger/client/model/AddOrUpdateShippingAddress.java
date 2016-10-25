package io.swagger.client.model;

import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class AddOrUpdateShippingAddress  implements Serializable{
  
  @SerializedName("detailAddress")
  private String detailAddress = null;
  @SerializedName("postcode")
  private String postcode = null;
  @SerializedName("receiverName")
  private String receiverName = null;
  @SerializedName("receiverPhone")
  private String receiverPhone = null;
  @SerializedName("address")
  private String address = null;
  @SerializedName("provinceCode")
  private String provinceCode = null;
  @SerializedName("cityCode")
  private String cityCode = null;
  @SerializedName("areaCode")
  private String areaCode = null;

  /**
   * \u8BE6\u7EC6\u8857\u9053\u5730\u5740
   **/
  @ApiModelProperty(value = "\u8BE6\u7EC6\u8857\u9053\u5730\u5740")
  public String getDetailAddress() {
    return detailAddress;
  }
  public void setDetailAddress(String detailAddress) {
    this.detailAddress = detailAddress;
  }

  /**
   * \u90AE\u7F16
   **/
  @ApiModelProperty(value = "\u90AE\u7F16")
  public String getPostcode() {
    return postcode;
  }
  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  /**
   * \u6536\u8D27\u4EBA\u5730\u5740
   **/
  @ApiModelProperty(value = "\u6536\u8D27\u4EBA\u5730\u5740")
  public String getReceiverName() {
    return receiverName;
  }
  public void setReceiverName(String receiverName) {
    this.receiverName = receiverName;
  }

  /**
   * \u6536\u8D27\u4EBA\u7535\u8BDD
   **/
  @ApiModelProperty(value = "\u6536\u8D27\u4EBA\u7535\u8BDD")
  public String getReceiverPhone() {
    return receiverPhone;
  }
  public void setReceiverPhone(String receiverPhone) {
    this.receiverPhone = receiverPhone;
  }

  /**
   * \u7701\u5E02\u533A\u4E2D\u6587\u63CF\u8FF0
   **/
  @ApiModelProperty(value = "\u7701\u5E02\u533A\u4E2D\u6587\u63CF\u8FF0")
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * \u7701code
   **/
  @ApiModelProperty(value = "\u7701code")
  public String getProvinceCode() {
    return provinceCode;
  }
  public void setProvinceCode(String provinceCode) {
    this.provinceCode = provinceCode;
  }

  /**
   * \u5E02code
   **/
  @ApiModelProperty(value = "\u5E02code")
  public String getCityCode() {
    return cityCode;
  }
  public void setCityCode(String cityCode) {
    this.cityCode = cityCode;
  }

  /**
   * \u533A\u53BFcode
   **/
  @ApiModelProperty(value = "\u533A\u53BFcode")
  public String getAreaCode() {
    return areaCode;
  }
  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddOrUpdateShippingAddress addOrUpdateShippingAddress = (AddOrUpdateShippingAddress) o;
    return (detailAddress == null ? addOrUpdateShippingAddress.detailAddress == null : detailAddress.equals(addOrUpdateShippingAddress.detailAddress)) &&
        (postcode == null ? addOrUpdateShippingAddress.postcode == null : postcode.equals(addOrUpdateShippingAddress.postcode)) &&
        (receiverName == null ? addOrUpdateShippingAddress.receiverName == null : receiverName.equals(addOrUpdateShippingAddress.receiverName)) &&
        (receiverPhone == null ? addOrUpdateShippingAddress.receiverPhone == null : receiverPhone.equals(addOrUpdateShippingAddress.receiverPhone)) &&
        (address == null ? addOrUpdateShippingAddress.address == null : address.equals(addOrUpdateShippingAddress.address)) &&
        (provinceCode == null ? addOrUpdateShippingAddress.provinceCode == null : provinceCode.equals(addOrUpdateShippingAddress.provinceCode)) &&
        (cityCode == null ? addOrUpdateShippingAddress.cityCode == null : cityCode.equals(addOrUpdateShippingAddress.cityCode)) &&
        (areaCode == null ? addOrUpdateShippingAddress.areaCode == null : areaCode.equals(addOrUpdateShippingAddress.areaCode));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (detailAddress == null ? 0: detailAddress.hashCode());
    result = 31 * result + (postcode == null ? 0: postcode.hashCode());
    result = 31 * result + (receiverName == null ? 0: receiverName.hashCode());
    result = 31 * result + (receiverPhone == null ? 0: receiverPhone.hashCode());
    result = 31 * result + (address == null ? 0: address.hashCode());
    result = 31 * result + (provinceCode == null ? 0: provinceCode.hashCode());
    result = 31 * result + (cityCode == null ? 0: cityCode.hashCode());
    result = 31 * result + (areaCode == null ? 0: areaCode.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddOrUpdateShippingAddress {\n");
    
    sb.append("  detailAddress: ").append(detailAddress).append("\n");
    sb.append("  postcode: ").append(postcode).append("\n");
    sb.append("  receiverName: ").append(receiverName).append("\n");
    sb.append("  receiverPhone: ").append(receiverPhone).append("\n");
    sb.append("  address: ").append(address).append("\n");
    sb.append("  provinceCode: ").append(provinceCode).append("\n");
    sb.append("  cityCode: ").append(cityCode).append("\n");
    sb.append("  areaCode: ").append(areaCode).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
