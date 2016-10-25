package io.swagger.client.model;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u8BA2\u5355\u7684\u64CD\u4F5C\u8BB0\u5F55
 **/
@ApiModel(description = "\u8BA2\u5355\u7684\u64CD\u4F5C\u8BB0\u5F55")
public class OrderActionRecord  implements Serializable{
  
  @SerializedName("auId")
  private Long auId = null;
  @SerializedName("orderNo")
  private String orderNo = null;
  @SerializedName("actionName")
  private String actionName = null;
  @SerializedName("createTime")
  private Date createTime = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public Long getAuId() {
    return auId;
  }
  public void setAuId(Long auId) {
    this.auId = auId;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getOrderNo() {
    return orderNo;
  }
  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }

  /**
   * \u64CD\u4F5C\u540D\u79F0
   **/
  @ApiModelProperty(value = "\u64CD\u4F5C\u540D\u79F0")
  public String getActionName() {
    return actionName;
  }
  public void setActionName(String actionName) {
    this.actionName = actionName;
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
    OrderActionRecord orderActionRecord = (OrderActionRecord) o;
    return (auId == null ? orderActionRecord.auId == null : auId.equals(orderActionRecord.auId)) &&
        (orderNo == null ? orderActionRecord.orderNo == null : orderNo.equals(orderActionRecord.orderNo)) &&
        (actionName == null ? orderActionRecord.actionName == null : actionName.equals(orderActionRecord.actionName)) &&
        (createTime == null ? orderActionRecord.createTime == null : createTime.equals(orderActionRecord.createTime));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (auId == null ? 0: auId.hashCode());
    result = 31 * result + (orderNo == null ? 0: orderNo.hashCode());
    result = 31 * result + (actionName == null ? 0: actionName.hashCode());
    result = 31 * result + (createTime == null ? 0: createTime.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderActionRecord {\n");
    
    sb.append("  auId: ").append(auId).append("\n");
    sb.append("  orderNo: ").append(orderNo).append("\n");
    sb.append("  actionName: ").append(actionName).append("\n");
    sb.append("  createTime: ").append(createTime).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
