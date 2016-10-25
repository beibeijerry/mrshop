package io.swagger.client.model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class PrePaidCardCreateRecord  implements Serializable{
  
  @SerializedName("createNo")
  private String createNo = null;
  @SerializedName("money")
  private BigDecimal money = null;
  @SerializedName("count")
  private Integer count = null;
  @SerializedName("status")
  private Integer status = null;
  @SerializedName("createTime")
  private Date createTime = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public String getCreateNo() {
    return createNo;
  }
  public void setCreateNo(String createNo) {
    this.createNo = createNo;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getMoney() {
    return money;
  }
  public void setMoney(BigDecimal money) {
    this.money = money;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getCount() {
    return count;
  }
  public void setCount(Integer count) {
    this.count = count;
  }

  /**
   * 0 \u521D\u59CB\uFF0C\u672A\u6279\u91CF\u6FC0\u6D3B  1 \u5DF2\u5236\u5361\uFF08\u5DF2\u6279\u91CF\u6FC0\u6D3B\uFF09
   **/
  @ApiModelProperty(value = "0 \u521D\u59CB\uFF0C\u672A\u6279\u91CF\u6FC0\u6D3B  1 \u5DF2\u5236\u5361\uFF08\u5DF2\u6279\u91CF\u6FC0\u6D3B\uFF09")
  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Date getCreateTime() {
    return createTime;
  }
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrePaidCardCreateRecord prePaidCardCreateRecord = (PrePaidCardCreateRecord) o;
    return (createNo == null ? prePaidCardCreateRecord.createNo == null : createNo.equals(prePaidCardCreateRecord.createNo)) &&
        (money == null ? prePaidCardCreateRecord.money == null : money.equals(prePaidCardCreateRecord.money)) &&
        (count == null ? prePaidCardCreateRecord.count == null : count.equals(prePaidCardCreateRecord.count)) &&
        (status == null ? prePaidCardCreateRecord.status == null : status.equals(prePaidCardCreateRecord.status)) &&
        (createTime == null ? prePaidCardCreateRecord.createTime == null : createTime.equals(prePaidCardCreateRecord.createTime));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (createNo == null ? 0: createNo.hashCode());
    result = 31 * result + (money == null ? 0: money.hashCode());
    result = 31 * result + (count == null ? 0: count.hashCode());
    result = 31 * result + (status == null ? 0: status.hashCode());
    result = 31 * result + (createTime == null ? 0: createTime.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PrePaidCardCreateRecord {\n");
    
    sb.append("  createNo: ").append(createNo).append("\n");
    sb.append("  money: ").append(money).append("\n");
    sb.append("  count: ").append(count).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  createTime: ").append(createTime).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
