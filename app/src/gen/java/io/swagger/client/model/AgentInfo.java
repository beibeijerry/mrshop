package io.swagger.client.model;

import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u7ECF\u9500\u5546\u4FE1\u606F
 **/
@ApiModel(description = "\u7ECF\u9500\u5546\u4FE1\u606F")
public class AgentInfo  implements Serializable{
  
  @SerializedName("accCode")
  private Long accCode = null;
  @SerializedName("agCode")
  private String agCode = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("phone")
  private String phone = null;
  @SerializedName("addr")
  private String addr = null;
  @SerializedName("bankName")
  private String bankName = null;
  @SerializedName("cardNo")
  private String cardNo = null;
  @SerializedName("payBonus")
  private Integer payBonus = null;
  @SerializedName("rpBonus")
  private Integer rpBonus = null;

  /**
   * \u8D26\u6237\u53F7
   **/
  @ApiModelProperty(value = "\u8D26\u6237\u53F7")
  public Long getAccCode() {
    return accCode;
  }
  public void setAccCode(Long accCode) {
    this.accCode = accCode;
  }

  /**
   * \u7ECF\u9500\u5546\u7F16\u53F7
   **/
  @ApiModelProperty(value = "\u7ECF\u9500\u5546\u7F16\u53F7")
  public String getAgCode() {
    return agCode;
  }
  public void setAgCode(String agCode) {
    this.agCode = agCode;
  }

  /**
   * \u59D3\u540D
   **/
  @ApiModelProperty(value = "\u59D3\u540D")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * \u7535\u8BDD
   **/
  @ApiModelProperty(value = "\u7535\u8BDD")
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * \u5730\u5740
   **/
  @ApiModelProperty(value = "\u5730\u5740")
  public String getAddr() {
    return addr;
  }
  public void setAddr(String addr) {
    this.addr = addr;
  }

  /**
   * \u94F6\u884C\u540D\u79F0
   **/
  @ApiModelProperty(value = "\u94F6\u884C\u540D\u79F0")
  public String getBankName() {
    return bankName;
  }
  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  /**
   * \u94F6\u884C\u5361\u53F7
   **/
  @ApiModelProperty(value = "\u94F6\u884C\u5361\u53F7")
  public String getCardNo() {
    return cardNo;
  }
  public void setCardNo(String cardNo) {
    this.cardNo = cardNo;
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
    AgentInfo agentInfo = (AgentInfo) o;
    return (accCode == null ? agentInfo.accCode == null : accCode.equals(agentInfo.accCode)) &&
        (agCode == null ? agentInfo.agCode == null : agCode.equals(agentInfo.agCode)) &&
        (name == null ? agentInfo.name == null : name.equals(agentInfo.name)) &&
        (phone == null ? agentInfo.phone == null : phone.equals(agentInfo.phone)) &&
        (addr == null ? agentInfo.addr == null : addr.equals(agentInfo.addr)) &&
        (bankName == null ? agentInfo.bankName == null : bankName.equals(agentInfo.bankName)) &&
        (cardNo == null ? agentInfo.cardNo == null : cardNo.equals(agentInfo.cardNo)) &&
        (payBonus == null ? agentInfo.payBonus == null : payBonus.equals(agentInfo.payBonus)) &&
        (rpBonus == null ? agentInfo.rpBonus == null : rpBonus.equals(agentInfo.rpBonus));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (accCode == null ? 0: accCode.hashCode());
    result = 31 * result + (agCode == null ? 0: agCode.hashCode());
    result = 31 * result + (name == null ? 0: name.hashCode());
    result = 31 * result + (phone == null ? 0: phone.hashCode());
    result = 31 * result + (addr == null ? 0: addr.hashCode());
    result = 31 * result + (bankName == null ? 0: bankName.hashCode());
    result = 31 * result + (cardNo == null ? 0: cardNo.hashCode());
    result = 31 * result + (payBonus == null ? 0: payBonus.hashCode());
    result = 31 * result + (rpBonus == null ? 0: rpBonus.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgentInfo {\n");
    
    sb.append("  accCode: ").append(accCode).append("\n");
    sb.append("  agCode: ").append(agCode).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  phone: ").append(phone).append("\n");
    sb.append("  addr: ").append(addr).append("\n");
    sb.append("  bankName: ").append(bankName).append("\n");
    sb.append("  cardNo: ").append(cardNo).append("\n");
    sb.append("  payBonus: ").append(payBonus).append("\n");
    sb.append("  rpBonus: ").append(rpBonus).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
