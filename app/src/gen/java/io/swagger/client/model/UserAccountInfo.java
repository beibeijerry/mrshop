package io.swagger.client.model;

import java.math.BigDecimal;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class UserAccountInfo  implements Serializable{
  
  @SerializedName("usId")
  private Long usId = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("avatar")
  private String avatar = null;
  @SerializedName("accountId")
  private Long accountId = null;
  @SerializedName("rpSum")
  private BigDecimal rpSum = null;
  @SerializedName("rpSort")
  private Long rpSort = null;
  @SerializedName("grade")
  private Integer grade = null;
  @SerializedName("gradeName")
  private String gradeName = null;
  @SerializedName("balance")
  private BigDecimal balance = null;
  @SerializedName("invateBalance")
  private Integer invateBalance = null;
  @SerializedName("invateMax")
  private Integer invateMax = null;
  @SerializedName("nextGradeDif")
  private BigDecimal nextGradeDif = null;
  @SerializedName("paySum")
  private BigDecimal paySum = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public Long getUsId() {
    return usId;
  }
  public void setUsId(Long usId) {
    this.usId = usId;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getAvatar() {
    return avatar;
  }
  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Long getAccountId() {
    return accountId;
  }
  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getRpSum() {
    return rpSum;
  }
  public void setRpSum(BigDecimal rpSum) {
    this.rpSum = rpSum;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Long getRpSort() {
    return rpSort;
  }
  public void setRpSort(Long rpSort) {
    this.rpSort = rpSort;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getGrade() {
    return grade;
  }
  public void setGrade(Integer grade) {
    this.grade = grade;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getGradeName() {
    return gradeName;
  }
  public void setGradeName(String gradeName) {
    this.gradeName = gradeName;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getBalance() {
    return balance;
  }
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  /**
   * \u63A8\u8350\u5269\u4F59\u4EBA\u6570
   **/
  @ApiModelProperty(value = "\u63A8\u8350\u5269\u4F59\u4EBA\u6570")
  public Integer getInvateBalance() {
    return invateBalance;
  }
  public void setInvateBalance(Integer invateBalance) {
    this.invateBalance = invateBalance;
  }

  /**
   * \u63A8\u8350\u4EBA\u6570\u6700\u5927\u503C
   **/
  @ApiModelProperty(value = "\u63A8\u8350\u4EBA\u6570\u6700\u5927\u503C")
  public Integer getInvateMax() {
    return invateMax;
  }
  public void setInvateMax(Integer invateMax) {
    this.invateMax = invateMax;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getNextGradeDif() {
    return nextGradeDif;
  }
  public void setNextGradeDif(BigDecimal nextGradeDif) {
    this.nextGradeDif = nextGradeDif;
  }

  /**
   * \u5145\u503C/\u6D88\u8D39\u7D2F\u8BA1\u91D1\u989D
   **/
  @ApiModelProperty(value = "\u5145\u503C/\u6D88\u8D39\u7D2F\u8BA1\u91D1\u989D")
  public BigDecimal getPaySum() {
    return paySum;
  }
  public void setPaySum(BigDecimal paySum) {
    this.paySum = paySum;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAccountInfo userAccountInfo = (UserAccountInfo) o;
    return (usId == null ? userAccountInfo.usId == null : usId.equals(userAccountInfo.usId)) &&
        (name == null ? userAccountInfo.name == null : name.equals(userAccountInfo.name)) &&
        (avatar == null ? userAccountInfo.avatar == null : avatar.equals(userAccountInfo.avatar)) &&
        (accountId == null ? userAccountInfo.accountId == null : accountId.equals(userAccountInfo.accountId)) &&
        (rpSum == null ? userAccountInfo.rpSum == null : rpSum.equals(userAccountInfo.rpSum)) &&
        (rpSort == null ? userAccountInfo.rpSort == null : rpSort.equals(userAccountInfo.rpSort)) &&
        (grade == null ? userAccountInfo.grade == null : grade.equals(userAccountInfo.grade)) &&
        (gradeName == null ? userAccountInfo.gradeName == null : gradeName.equals(userAccountInfo.gradeName)) &&
        (balance == null ? userAccountInfo.balance == null : balance.equals(userAccountInfo.balance)) &&
        (invateBalance == null ? userAccountInfo.invateBalance == null : invateBalance.equals(userAccountInfo.invateBalance)) &&
        (invateMax == null ? userAccountInfo.invateMax == null : invateMax.equals(userAccountInfo.invateMax)) &&
        (nextGradeDif == null ? userAccountInfo.nextGradeDif == null : nextGradeDif.equals(userAccountInfo.nextGradeDif)) &&
        (paySum == null ? userAccountInfo.paySum == null : paySum.equals(userAccountInfo.paySum));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (usId == null ? 0: usId.hashCode());
    result = 31 * result + (name == null ? 0: name.hashCode());
    result = 31 * result + (avatar == null ? 0: avatar.hashCode());
    result = 31 * result + (accountId == null ? 0: accountId.hashCode());
    result = 31 * result + (rpSum == null ? 0: rpSum.hashCode());
    result = 31 * result + (rpSort == null ? 0: rpSort.hashCode());
    result = 31 * result + (grade == null ? 0: grade.hashCode());
    result = 31 * result + (gradeName == null ? 0: gradeName.hashCode());
    result = 31 * result + (balance == null ? 0: balance.hashCode());
    result = 31 * result + (invateBalance == null ? 0: invateBalance.hashCode());
    result = 31 * result + (invateMax == null ? 0: invateMax.hashCode());
    result = 31 * result + (nextGradeDif == null ? 0: nextGradeDif.hashCode());
    result = 31 * result + (paySum == null ? 0: paySum.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAccountInfo {\n");
    
    sb.append("  usId: ").append(usId).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  avatar: ").append(avatar).append("\n");
    sb.append("  accountId: ").append(accountId).append("\n");
    sb.append("  rpSum: ").append(rpSum).append("\n");
    sb.append("  rpSort: ").append(rpSort).append("\n");
    sb.append("  grade: ").append(grade).append("\n");
    sb.append("  gradeName: ").append(gradeName).append("\n");
    sb.append("  balance: ").append(balance).append("\n");
    sb.append("  invateBalance: ").append(invateBalance).append("\n");
    sb.append("  invateMax: ").append(invateMax).append("\n");
    sb.append("  nextGradeDif: ").append(nextGradeDif).append("\n");
    sb.append("  paySum: ").append(paySum).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
