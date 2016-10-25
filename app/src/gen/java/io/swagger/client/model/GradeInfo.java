package io.swagger.client.model;

import java.math.BigDecimal;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u7EA7\u522B\u4FE1\u606F
 **/
@ApiModel(description = "\u7EA7\u522B\u4FE1\u606F")
public class GradeInfo  implements Serializable{
  
  @SerializedName("grade")
  private Integer grade = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("money")
  private BigDecimal money = null;
  @SerializedName("inviteMax")
  private Integer inviteMax = null;
  @SerializedName("payBonus")
  private Integer payBonus = null;
  @SerializedName("rpBonus")
  private Integer rpBonus = null;

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
   * \u7EA7\u522B\u540D\u79F0
   **/
  @ApiModelProperty(value = "\u7EA7\u522B\u540D\u79F0")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * \u5145\u503C\u91D1\u989D
   **/
  @ApiModelProperty(value = "\u5145\u503C\u91D1\u989D")
  public BigDecimal getMoney() {
    return money;
  }
  public void setMoney(BigDecimal money) {
    this.money = money;
  }

  /**
   * \u63A8\u8350\u4EBA\u6570\u9650\u5236
   **/
  @ApiModelProperty(value = "\u63A8\u8350\u4EBA\u6570\u9650\u5236")
  public Integer getInviteMax() {
    return inviteMax;
  }
  public void setInviteMax(Integer inviteMax) {
    this.inviteMax = inviteMax;
  }

  /**
   * \u5145\u503C\u8FD4\u4F63\u6BD4\u4F8B  \u5355\u4F4D\uFF05
   **/
  @ApiModelProperty(value = "\u5145\u503C\u8FD4\u4F63\u6BD4\u4F8B  \u5355\u4F4D\uFF05")
  public Integer getPayBonus() {
    return payBonus;
  }
  public void setPayBonus(Integer payBonus) {
    this.payBonus = payBonus;
  }

  /**
   * \u7EA2\u5305\u8FD4\u4F63\u6BD4\u4F8B  \u5355\u4F4D\uFF05
   **/
  @ApiModelProperty(value = "\u7EA2\u5305\u8FD4\u4F63\u6BD4\u4F8B  \u5355\u4F4D\uFF05")
  public Integer getRpBonus() {
    return rpBonus;
  }
  public void setRpBonus(Integer rpBonus) {
    this.rpBonus = rpBonus;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GradeInfo gradeInfo = (GradeInfo) o;
    return (grade == null ? gradeInfo.grade == null : grade.equals(gradeInfo.grade)) &&
        (name == null ? gradeInfo.name == null : name.equals(gradeInfo.name)) &&
        (money == null ? gradeInfo.money == null : money.equals(gradeInfo.money)) &&
        (inviteMax == null ? gradeInfo.inviteMax == null : inviteMax.equals(gradeInfo.inviteMax)) &&
        (payBonus == null ? gradeInfo.payBonus == null : payBonus.equals(gradeInfo.payBonus)) &&
        (rpBonus == null ? gradeInfo.rpBonus == null : rpBonus.equals(gradeInfo.rpBonus));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (grade == null ? 0: grade.hashCode());
    result = 31 * result + (name == null ? 0: name.hashCode());
    result = 31 * result + (money == null ? 0: money.hashCode());
    result = 31 * result + (inviteMax == null ? 0: inviteMax.hashCode());
    result = 31 * result + (payBonus == null ? 0: payBonus.hashCode());
    result = 31 * result + (rpBonus == null ? 0: rpBonus.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class GradeInfo {\n");
    
    sb.append("  grade: ").append(grade).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  money: ").append(money).append("\n");
    sb.append("  inviteMax: ").append(inviteMax).append("\n");
    sb.append("  payBonus: ").append(payBonus).append("\n");
    sb.append("  rpBonus: ").append(rpBonus).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
