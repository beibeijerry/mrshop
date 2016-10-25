package io.swagger.client.model;

import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class RPInfo  implements Serializable{
  
  @SerializedName("checkInAdLink")
  private String checkInAdLink = null;
  @SerializedName("checkInAdReadTime")
  private Integer checkInAdReadTime = null;
  @SerializedName("shakeRPTimePerDay")
  private Integer shakeRPTimePerDay = null;
  @SerializedName("shakeRPBalanceTimeToday")
  private Integer shakeRPBalanceTimeToday = null;
  @SerializedName("checkIn")
  private Boolean checkIn = null;

  /**
   * \u7B7E\u5230\u5E7F\u544A\u6D77\u62A5\u5730\u5740
   **/
  @ApiModelProperty(required = true, value = "\u7B7E\u5230\u5E7F\u544A\u6D77\u62A5\u5730\u5740")
  public String getCheckInAdLink() {
    return checkInAdLink;
  }
  public void setCheckInAdLink(String checkInAdLink) {
    this.checkInAdLink = checkInAdLink;
  }

  /**
   * \u9605\u8BFB\u79D2\u6570
   **/
  @ApiModelProperty(value = "\u9605\u8BFB\u79D2\u6570")
  public Integer getCheckInAdReadTime() {
    return checkInAdReadTime;
  }
  public void setCheckInAdReadTime(Integer checkInAdReadTime) {
    this.checkInAdReadTime = checkInAdReadTime;
  }

  /**
   * \u6BCF\u65E5\u53EF\u4EE5\u6447\u7EA2\u5305\u7684\u6B21\u6570
   **/
  @ApiModelProperty(required = true, value = "\u6BCF\u65E5\u53EF\u4EE5\u6447\u7EA2\u5305\u7684\u6B21\u6570")
  public Integer getShakeRPTimePerDay() {
    return shakeRPTimePerDay;
  }
  public void setShakeRPTimePerDay(Integer shakeRPTimePerDay) {
    this.shakeRPTimePerDay = shakeRPTimePerDay;
  }

  /**
   * \u4ECA\u65E5\u5269\u4F59\u6447\u7EA2\u5305\u6B21\u6570
   **/
  @ApiModelProperty(required = true, value = "\u4ECA\u65E5\u5269\u4F59\u6447\u7EA2\u5305\u6B21\u6570")
  public Integer getShakeRPBalanceTimeToday() {
    return shakeRPBalanceTimeToday;
  }
  public void setShakeRPBalanceTimeToday(Integer shakeRPBalanceTimeToday) {
    this.shakeRPBalanceTimeToday = shakeRPBalanceTimeToday;
  }

  /**
   * \u4ECA\u65E5\u662F\u5426\u5DF2\u7ECF\u7B7E\u5230
   **/
  @ApiModelProperty(value = "\u4ECA\u65E5\u662F\u5426\u5DF2\u7ECF\u7B7E\u5230")
  public Boolean getCheckIn() {
    return checkIn;
  }
  public void setCheckIn(Boolean checkIn) {
    this.checkIn = checkIn;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RPInfo rPInfo = (RPInfo) o;
    return (checkInAdLink == null ? rPInfo.checkInAdLink == null : checkInAdLink.equals(rPInfo.checkInAdLink)) &&
        (checkInAdReadTime == null ? rPInfo.checkInAdReadTime == null : checkInAdReadTime.equals(rPInfo.checkInAdReadTime)) &&
        (shakeRPTimePerDay == null ? rPInfo.shakeRPTimePerDay == null : shakeRPTimePerDay.equals(rPInfo.shakeRPTimePerDay)) &&
        (shakeRPBalanceTimeToday == null ? rPInfo.shakeRPBalanceTimeToday == null : shakeRPBalanceTimeToday.equals(rPInfo.shakeRPBalanceTimeToday)) &&
        (checkIn == null ? rPInfo.checkIn == null : checkIn.equals(rPInfo.checkIn));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (checkInAdLink == null ? 0: checkInAdLink.hashCode());
    result = 31 * result + (checkInAdReadTime == null ? 0: checkInAdReadTime.hashCode());
    result = 31 * result + (shakeRPTimePerDay == null ? 0: shakeRPTimePerDay.hashCode());
    result = 31 * result + (shakeRPBalanceTimeToday == null ? 0: shakeRPBalanceTimeToday.hashCode());
    result = 31 * result + (checkIn == null ? 0: checkIn.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class RPInfo {\n");
    
    sb.append("  checkInAdLink: ").append(checkInAdLink).append("\n");
    sb.append("  checkInAdReadTime: ").append(checkInAdReadTime).append("\n");
    sb.append("  shakeRPTimePerDay: ").append(shakeRPTimePerDay).append("\n");
    sb.append("  shakeRPBalanceTimeToday: ").append(shakeRPBalanceTimeToday).append("\n");
    sb.append("  checkIn: ").append(checkIn).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
