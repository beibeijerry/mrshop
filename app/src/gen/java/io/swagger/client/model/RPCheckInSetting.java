package io.swagger.client.model;

import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class RPCheckInSetting  implements Serializable{
  
  @SerializedName("checkInAdLink")
  private String checkInAdLink = null;
  @SerializedName("checkInAdReadTime")
  private Integer checkInAdReadTime = null;

  /**
   * \u7B7E\u5230\u6D77\u62A5\u5730\u5740key
   **/
  @ApiModelProperty(value = "\u7B7E\u5230\u6D77\u62A5\u5730\u5740key")
  public String getCheckInAdLink() {
    return checkInAdLink;
  }
  public void setCheckInAdLink(String checkInAdLink) {
    this.checkInAdLink = checkInAdLink;
  }

  /**
   * \u7B7E\u5230\u6D77\u62A5\u9605\u8BFB\u5012\u8BA1\u65F6\u79D2\u6570
   **/
  @ApiModelProperty(value = "\u7B7E\u5230\u6D77\u62A5\u9605\u8BFB\u5012\u8BA1\u65F6\u79D2\u6570")
  public Integer getCheckInAdReadTime() {
    return checkInAdReadTime;
  }
  public void setCheckInAdReadTime(Integer checkInAdReadTime) {
    this.checkInAdReadTime = checkInAdReadTime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RPCheckInSetting rPCheckInSetting = (RPCheckInSetting) o;
    return (checkInAdLink == null ? rPCheckInSetting.checkInAdLink == null : checkInAdLink.equals(rPCheckInSetting.checkInAdLink)) &&
        (checkInAdReadTime == null ? rPCheckInSetting.checkInAdReadTime == null : checkInAdReadTime.equals(rPCheckInSetting.checkInAdReadTime));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (checkInAdLink == null ? 0: checkInAdLink.hashCode());
    result = 31 * result + (checkInAdReadTime == null ? 0: checkInAdReadTime.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class RPCheckInSetting {\n");
    
    sb.append("  checkInAdLink: ").append(checkInAdLink).append("\n");
    sb.append("  checkInAdReadTime: ").append(checkInAdReadTime).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
