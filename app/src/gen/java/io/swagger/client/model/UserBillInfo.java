package io.swagger.client.model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class UserBillInfo  implements Serializable{
  
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserBillInfo userBillInfo = (UserBillInfo) o;
    return (time == null ? userBillInfo.time == null : time.equals(userBillInfo.time)) &&
        (amount == null ? userBillInfo.amount == null : amount.equals(userBillInfo.amount)) &&
        (remarks == null ? userBillInfo.remarks == null : remarks.equals(userBillInfo.remarks)) &&
        (type == null ? userBillInfo.type == null : type.equals(userBillInfo.type)) &&
        (outIn == null ? userBillInfo.outIn == null : outIn.equals(userBillInfo.outIn)) &&
        (flowNo == null ? userBillInfo.flowNo == null : flowNo.equals(userBillInfo.flowNo));
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
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserBillInfo {\n");
    
    sb.append("  time: ").append(time).append("\n");
    sb.append("  amount: ").append(amount).append("\n");
    sb.append("  remarks: ").append(remarks).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  outIn: ").append(outIn).append("\n");
    sb.append("  flowNo: ").append(flowNo).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
