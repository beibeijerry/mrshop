package io.swagger.client.model;

import java.math.BigDecimal;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u8D26\u6237\u7EDF\u8BA1\u4FE1\u606F
 **/
@ApiModel(description = "\u8D26\u6237\u7EDF\u8BA1\u4FE1\u606F")
public class AccountStat  implements Serializable{
  
  @SerializedName("shakeRP")
  private BigDecimal shakeRP = null;
  @SerializedName("checkInRP")
  private BigDecimal checkInRP = null;
  @SerializedName("vipRP")
  private BigDecimal vipRP = null;
  @SerializedName("thirdPay")
  private BigDecimal thirdPay = null;
  @SerializedName("prePayCard")
  private BigDecimal prePayCard = null;
  @SerializedName("userBonus")
  private BigDecimal userBonus = null;
  @SerializedName("shopInCome")
  private BigDecimal shopInCome = null;
  @SerializedName("agentBonus")
  private BigDecimal agentBonus = null;
  @SerializedName("agentClear")
  private BigDecimal agentClear = null;

  /**
   * \u6447\u7EA2\u5305\u7EDF\u8BA1
   **/
  @ApiModelProperty(value = "\u6447\u7EA2\u5305\u7EDF\u8BA1")
  public BigDecimal getShakeRP() {
    return shakeRP;
  }
  public void setShakeRP(BigDecimal shakeRP) {
    this.shakeRP = shakeRP;
  }

  /**
   * \u7B7E\u5230\u7EA2\u5305\u7EDF\u8BA1
   **/
  @ApiModelProperty(value = "\u7B7E\u5230\u7EA2\u5305\u7EDF\u8BA1")
  public BigDecimal getCheckInRP() {
    return checkInRP;
  }
  public void setCheckInRP(BigDecimal checkInRP) {
    this.checkInRP = checkInRP;
  }

  /**
   * \u7279\u6743\u7EA2\u5305\u7EDF\u8BA1
   **/
  @ApiModelProperty(value = "\u7279\u6743\u7EA2\u5305\u7EDF\u8BA1")
  public BigDecimal getVipRP() {
    return vipRP;
  }
  public void setVipRP(BigDecimal vipRP) {
    this.vipRP = vipRP;
  }

  /**
   * \u7528\u6237\u7B2C\u4E09\u65B9\u652F\u4ED8\u8D26\u6237\u5145\u503C
   **/
  @ApiModelProperty(value = "\u7528\u6237\u7B2C\u4E09\u65B9\u652F\u4ED8\u8D26\u6237\u5145\u503C")
  public BigDecimal getThirdPay() {
    return thirdPay;
  }
  public void setThirdPay(BigDecimal thirdPay) {
    this.thirdPay = thirdPay;
  }

  /**
   * \u5145\u503C\u5361\u5145\u503C\u7EDF\u8BA1
   **/
  @ApiModelProperty(value = "\u5145\u503C\u5361\u5145\u503C\u7EDF\u8BA1")
  public BigDecimal getPrePayCard() {
    return prePayCard;
  }
  public void setPrePayCard(BigDecimal prePayCard) {
    this.prePayCard = prePayCard;
  }

  /**
   * \u4F1A\u5458\u63A8\u8350\u5956\u52B1
   **/
  @ApiModelProperty(value = "\u4F1A\u5458\u63A8\u8350\u5956\u52B1")
  public BigDecimal getUserBonus() {
    return userBonus;
  }
  public void setUserBonus(BigDecimal userBonus) {
    this.userBonus = userBonus;
  }

  /**
   * \u5546\u94FA\u6536\u5165
   **/
  @ApiModelProperty(value = "\u5546\u94FA\u6536\u5165")
  public BigDecimal getShopInCome() {
    return shopInCome;
  }
  public void setShopInCome(BigDecimal shopInCome) {
    this.shopInCome = shopInCome;
  }

  /**
   * \u7ECF\u9500\u5546\u5956\u52B1
   **/
  @ApiModelProperty(value = "\u7ECF\u9500\u5546\u5956\u52B1")
  public BigDecimal getAgentBonus() {
    return agentBonus;
  }
  public void setAgentBonus(BigDecimal agentBonus) {
    this.agentBonus = agentBonus;
  }

  /**
   * \u7ECF\u9500\u5546\u7ED3\u7B97
   **/
  @ApiModelProperty(value = "\u7ECF\u9500\u5546\u7ED3\u7B97")
  public BigDecimal getAgentClear() {
    return agentClear;
  }
  public void setAgentClear(BigDecimal agentClear) {
    this.agentClear = agentClear;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountStat accountStat = (AccountStat) o;
    return (shakeRP == null ? accountStat.shakeRP == null : shakeRP.equals(accountStat.shakeRP)) &&
        (checkInRP == null ? accountStat.checkInRP == null : checkInRP.equals(accountStat.checkInRP)) &&
        (vipRP == null ? accountStat.vipRP == null : vipRP.equals(accountStat.vipRP)) &&
        (thirdPay == null ? accountStat.thirdPay == null : thirdPay.equals(accountStat.thirdPay)) &&
        (prePayCard == null ? accountStat.prePayCard == null : prePayCard.equals(accountStat.prePayCard)) &&
        (userBonus == null ? accountStat.userBonus == null : userBonus.equals(accountStat.userBonus)) &&
        (shopInCome == null ? accountStat.shopInCome == null : shopInCome.equals(accountStat.shopInCome)) &&
        (agentBonus == null ? accountStat.agentBonus == null : agentBonus.equals(accountStat.agentBonus)) &&
        (agentClear == null ? accountStat.agentClear == null : agentClear.equals(accountStat.agentClear));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (shakeRP == null ? 0: shakeRP.hashCode());
    result = 31 * result + (checkInRP == null ? 0: checkInRP.hashCode());
    result = 31 * result + (vipRP == null ? 0: vipRP.hashCode());
    result = 31 * result + (thirdPay == null ? 0: thirdPay.hashCode());
    result = 31 * result + (prePayCard == null ? 0: prePayCard.hashCode());
    result = 31 * result + (userBonus == null ? 0: userBonus.hashCode());
    result = 31 * result + (shopInCome == null ? 0: shopInCome.hashCode());
    result = 31 * result + (agentBonus == null ? 0: agentBonus.hashCode());
    result = 31 * result + (agentClear == null ? 0: agentClear.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountStat {\n");
    
    sb.append("  shakeRP: ").append(shakeRP).append("\n");
    sb.append("  checkInRP: ").append(checkInRP).append("\n");
    sb.append("  vipRP: ").append(vipRP).append("\n");
    sb.append("  thirdPay: ").append(thirdPay).append("\n");
    sb.append("  prePayCard: ").append(prePayCard).append("\n");
    sb.append("  userBonus: ").append(userBonus).append("\n");
    sb.append("  shopInCome: ").append(shopInCome).append("\n");
    sb.append("  agentBonus: ").append(agentBonus).append("\n");
    sb.append("  agentClear: ").append(agentClear).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
