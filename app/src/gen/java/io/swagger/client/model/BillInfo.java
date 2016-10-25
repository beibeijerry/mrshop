package io.swagger.client.model;

import io.swagger.client.model.UserBillInfo;
import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class BillInfo extends UserBillInfo implements Serializable{
  
  @SerializedName("time")
  private Date time = null;
  @SerializedName("amount")
  private BigDecimal amount = null;
  @SerializedName("remarks")
  private String remarks = null;
  @SerializedName("type")
  private Integer type = null;
  @SerializedName("outIn")
  private Integer outIn = null;
  @SerializedName("flowNo")
  private String flowNo = null;
  @SerializedName("accountId")
  private Long accountId = null;
  @SerializedName("usIdOrAgentCode")
  private String usIdOrAgentCode = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("avatar")
  private String avatar = null;
  @SerializedName("mobile")
  private String mobile = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public Date getTime() {
    return time;
  }
  public void setTime(Date time) {
    this.time = time;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getRemarks() {
    return remarks;
  }
  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getType() {
    return type;
  }
  public void setType(Integer type) {
    this.type = type;
  }

  /**
   * 0 \u652F\u51FA  1 \u6536\u5165
   **/
  @ApiModelProperty(value = "0 \u652F\u51FA  1 \u6536\u5165")
  public Integer getOutIn() {
    return outIn;
  }
  public void setOutIn(Integer outIn) {
    this.outIn = outIn;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getFlowNo() {
    return flowNo;
  }
  public void setFlowNo(String flowNo) {
    this.flowNo = flowNo;
  }

  /**
   * \u7ECF\u9500\u5546\u6216\u8005\u7528\u6237\u7684Id
   **/
  @ApiModelProperty(required = true, value = "\u7ECF\u9500\u5546\u6216\u8005\u7528\u6237\u7684Id")
  public Long getAccountId() {
    return accountId;
  }
  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getUsIdOrAgentCode() {
    return usIdOrAgentCode;
  }
  public void setUsIdOrAgentCode(String usIdOrAgentCode) {
    this.usIdOrAgentCode = usIdOrAgentCode;
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
  public String getMobile() {
    return mobile;
  }
  public void setMobile(String mobile) {
    this.mobile = mobile;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillInfo billInfo = (BillInfo) o;
    return (time == null ? billInfo.time == null : time.equals(billInfo.time)) &&
        (amount == null ? billInfo.amount == null : amount.equals(billInfo.amount)) &&
        (remarks == null ? billInfo.remarks == null : remarks.equals(billInfo.remarks)) &&
        (type == null ? billInfo.type == null : type.equals(billInfo.type)) &&
        (outIn == null ? billInfo.outIn == null : outIn.equals(billInfo.outIn)) &&
        (flowNo == null ? billInfo.flowNo == null : flowNo.equals(billInfo.flowNo)) &&
        (accountId == null ? billInfo.accountId == null : accountId.equals(billInfo.accountId)) &&
        (usIdOrAgentCode == null ? billInfo.usIdOrAgentCode == null : usIdOrAgentCode.equals(billInfo.usIdOrAgentCode)) &&
        (name == null ? billInfo.name == null : name.equals(billInfo.name)) &&
        (avatar == null ? billInfo.avatar == null : avatar.equals(billInfo.avatar)) &&
        (mobile == null ? billInfo.mobile == null : mobile.equals(billInfo.mobile));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (time == null ? 0: time.hashCode());
    result = 31 * result + (amount == null ? 0: amount.hashCode());
    result = 31 * result + (remarks == null ? 0: remarks.hashCode());
    result = 31 * result + (type == null ? 0: type.hashCode());
    result = 31 * result + (outIn == null ? 0: outIn.hashCode());
    result = 31 * result + (flowNo == null ? 0: flowNo.hashCode());
    result = 31 * result + (accountId == null ? 0: accountId.hashCode());
    result = 31 * result + (usIdOrAgentCode == null ? 0: usIdOrAgentCode.hashCode());
    result = 31 * result + (name == null ? 0: name.hashCode());
    result = 31 * result + (avatar == null ? 0: avatar.hashCode());
    result = 31 * result + (mobile == null ? 0: mobile.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillInfo {\n");
    sb.append("  " + super.toString()).append("\n");
    sb.append("  time: ").append(time).append("\n");
    sb.append("  amount: ").append(amount).append("\n");
    sb.append("  remarks: ").append(remarks).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  outIn: ").append(outIn).append("\n");
    sb.append("  flowNo: ").append(flowNo).append("\n");
    sb.append("  accountId: ").append(accountId).append("\n");
    sb.append("  usIdOrAgentCode: ").append(usIdOrAgentCode).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  avatar: ").append(avatar).append("\n");
    sb.append("  mobile: ").append(mobile).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
