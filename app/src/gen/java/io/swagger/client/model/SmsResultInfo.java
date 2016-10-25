package io.swagger.client.model;

import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u53D1\u9001\u77ED\u4FE1\u8FD4\u56DE\u4FE1\u606F
 **/
@ApiModel(description = "\u53D1\u9001\u77ED\u4FE1\u8FD4\u56DE\u4FE1\u606F")
public class SmsResultInfo  implements Serializable{
  
  @SerializedName("code")
  private String code = null;
  @SerializedName("isExist")
  private Boolean isExist = null;
  @SerializedName("bussId")
  private Long bussId = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Boolean getIsExist() {
    return isExist;
  }
  public void setIsExist(Boolean isExist) {
    this.isExist = isExist;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Long getBussId() {
    return bussId;
  }
  public void setBussId(Long bussId) {
    this.bussId = bussId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmsResultInfo smsResultInfo = (SmsResultInfo) o;
    return (code == null ? smsResultInfo.code == null : code.equals(smsResultInfo.code)) &&
        (isExist == null ? smsResultInfo.isExist == null : isExist.equals(smsResultInfo.isExist)) &&
        (bussId == null ? smsResultInfo.bussId == null : bussId.equals(smsResultInfo.bussId));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (code == null ? 0: code.hashCode());
    result = 31 * result + (isExist == null ? 0: isExist.hashCode());
    result = 31 * result + (bussId == null ? 0: bussId.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmsResultInfo {\n");
    
    sb.append("  code: ").append(code).append("\n");
    sb.append("  isExist: ").append(isExist).append("\n");
    sb.append("  bussId: ").append(bussId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
