package io.swagger.client.model;

import java.math.BigDecimal;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class RPSetting  implements Serializable{
  
  @SerializedName("grade")
  private Integer grade = null;
  @SerializedName("shakeRPTimePerDay")
  private Integer shakeRPTimePerDay = null;
  @SerializedName("shakeRPMinAmount")
  private BigDecimal shakeRPMinAmount = null;
  @SerializedName("shakeRPMaxAmount")
  private BigDecimal shakeRPMaxAmount = null;
  @SerializedName("checkInRPMinAmount")
  private BigDecimal checkInRPMinAmount = null;
  @SerializedName("checkInRPMaxAmount")
  private BigDecimal checkInRPMaxAmount = null;

  /**
   * \u7EA7\u522B
   **/
  @ApiModelProperty(value = "\u7EA7\u522B")
  public Integer getGrade() {
    return grade;
  }
  public void setGrade(Integer grade) {
    this.grade = grade;
  }

  /**
   * \u6BCF\u65E5\u53EF\u4EE5\u6447\u7EA2\u5305\u7684\u6B21\u6570
   **/
  @ApiModelProperty(value = "\u6BCF\u65E5\u53EF\u4EE5\u6447\u7EA2\u5305\u7684\u6B21\u6570")
  public Integer getShakeRPTimePerDay() {
    return shakeRPTimePerDay;
  }
  public void setShakeRPTimePerDay(Integer shakeRPTimePerDay) {
    this.shakeRPTimePerDay = shakeRPTimePerDay;
  }

  /**
   * \u6447\u7EA2\u5305\u6700\u5C0F\u503C
   **/
  @ApiModelProperty(value = "\u6447\u7EA2\u5305\u6700\u5C0F\u503C")
  public BigDecimal getShakeRPMinAmount() {
    return shakeRPMinAmount;
  }
  public void setShakeRPMinAmount(BigDecimal shakeRPMinAmount) {
    this.shakeRPMinAmount = shakeRPMinAmount;
  }

  /**
   * \u6447\u7EA2\u5305\u6700\u5927\u503C
   **/
  @ApiModelProperty(value = "\u6447\u7EA2\u5305\u6700\u5927\u503C")
  public BigDecimal getShakeRPMaxAmount() {
    return shakeRPMaxAmount;
  }
  public void setShakeRPMaxAmount(BigDecimal shakeRPMaxAmount) {
    this.shakeRPMaxAmount = shakeRPMaxAmount;
  }

  /**
   * \u7B7E\u5230\u7EA2\u5305\u6700\u5C0F\u91D1\u989D
   **/
  @ApiModelProperty(value = "\u7B7E\u5230\u7EA2\u5305\u6700\u5C0F\u91D1\u989D")
  public BigDecimal getCheckInRPMinAmount() {
    return checkInRPMinAmount;
  }
  public void setCheckInRPMinAmount(BigDecimal checkInRPMinAmount) {
    this.checkInRPMinAmount = checkInRPMinAmount;
  }

  /**
   * \u7B7E\u5230\u7EA2\u5305\u6700\u5927\u91D1\u989D
   **/
  @ApiModelProperty(value = "\u7B7E\u5230\u7EA2\u5305\u6700\u5927\u91D1\u989D")
  public BigDecimal getCheckInRPMaxAmount() {
    return checkInRPMaxAmount;
  }
  public void setCheckInRPMaxAmount(BigDecimal checkInRPMaxAmount) {
    this.checkInRPMaxAmount = checkInRPMaxAmount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RPSetting rPSetting = (RPSetting) o;
    return (grade == null ? rPSetting.grade == null : grade.equals(rPSetting.grade)) &&
        (shakeRPTimePerDay == null ? rPSetting.shakeRPTimePerDay == null : shakeRPTimePerDay.equals(rPSetting.shakeRPTimePerDay)) &&
        (shakeRPMinAmount == null ? rPSetting.shakeRPMinAmount == null : shakeRPMinAmount.equals(rPSetting.shakeRPMinAmount)) &&
        (shakeRPMaxAmount == null ? rPSetting.shakeRPMaxAmount == null : shakeRPMaxAmount.equals(rPSetting.shakeRPMaxAmount)) &&
        (checkInRPMinAmount == null ? rPSetting.checkInRPMinAmount == null : checkInRPMinAmount.equals(rPSetting.checkInRPMinAmount)) &&
        (checkInRPMaxAmount == null ? rPSetting.checkInRPMaxAmount == null : checkInRPMaxAmount.equals(rPSetting.checkInRPMaxAmount));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (grade == null ? 0: grade.hashCode());
    result = 31 * result + (shakeRPTimePerDay == null ? 0: shakeRPTimePerDay.hashCode());
    result = 31 * result + (shakeRPMinAmount == null ? 0: shakeRPMinAmount.hashCode());
    result = 31 * result + (shakeRPMaxAmount == null ? 0: shakeRPMaxAmount.hashCode());
    result = 31 * result + (checkInRPMinAmount == null ? 0: checkInRPMinAmount.hashCode());
    result = 31 * result + (checkInRPMaxAmount == null ? 0: checkInRPMaxAmount.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class RPSetting {\n");
    
    sb.append("  grade: ").append(grade).append("\n");
    sb.append("  shakeRPTimePerDay: ").append(shakeRPTimePerDay).append("\n");
    sb.append("  shakeRPMinAmount: ").append(shakeRPMinAmount).append("\n");
    sb.append("  shakeRPMaxAmount: ").append(shakeRPMaxAmount).append("\n");
    sb.append("  checkInRPMinAmount: ").append(checkInRPMinAmount).append("\n");
    sb.append("  checkInRPMaxAmount: ").append(checkInRPMaxAmount).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
