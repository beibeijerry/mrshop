package io.swagger.client.model;

import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class AddGoodsOrder  implements Serializable{
  
  @SerializedName("goodsId")
  private Long goodsId = null;
  @SerializedName("goodsReqId")
  private Long goodsReqId = null;
  @SerializedName("count")
  private Integer count = null;
  @SerializedName("shippingAddressId")
  private Long shippingAddressId = null;
  @SerializedName("remarks")
  private String remarks = null;

  /**
   * \u5546\u54C1ID
   **/
  @ApiModelProperty(value = "\u5546\u54C1ID")
  public Long getGoodsId() {
    return goodsId;
  }
  public void setGoodsId(Long goodsId) {
    this.goodsId = goodsId;
  }

  /**
   * \u5546\u54C1\u5E93\u5B58ID
   **/
  @ApiModelProperty(value = "\u5546\u54C1\u5E93\u5B58ID")
  public Long getGoodsReqId() {
    return goodsReqId;
  }
  public void setGoodsReqId(Long goodsReqId) {
    this.goodsReqId = goodsReqId;
  }

  /**
   * \u8D2D\u4E70\u6570\u91CF
   **/
  @ApiModelProperty(value = "\u8D2D\u4E70\u6570\u91CF")
  public Integer getCount() {
    return count;
  }
  public void setCount(Integer count) {
    this.count = count;
  }

  /**
   * \u90AE\u5BC4\u5730\u5740ID
   **/
  @ApiModelProperty(value = "\u90AE\u5BC4\u5730\u5740ID")
  public Long getShippingAddressId() {
    return shippingAddressId;
  }
  public void setShippingAddressId(Long shippingAddressId) {
    this.shippingAddressId = shippingAddressId;
  }

  /**
   * \u5907\u6CE8
   **/
  @ApiModelProperty(value = "\u5907\u6CE8")
  public String getRemarks() {
    return remarks;
  }
  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddGoodsOrder addGoodsOrder = (AddGoodsOrder) o;
    return (goodsId == null ? addGoodsOrder.goodsId == null : goodsId.equals(addGoodsOrder.goodsId)) &&
        (goodsReqId == null ? addGoodsOrder.goodsReqId == null : goodsReqId.equals(addGoodsOrder.goodsReqId)) &&
        (count == null ? addGoodsOrder.count == null : count.equals(addGoodsOrder.count)) &&
        (shippingAddressId == null ? addGoodsOrder.shippingAddressId == null : shippingAddressId.equals(addGoodsOrder.shippingAddressId)) &&
        (remarks == null ? addGoodsOrder.remarks == null : remarks.equals(addGoodsOrder.remarks));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (goodsId == null ? 0: goodsId.hashCode());
    result = 31 * result + (goodsReqId == null ? 0: goodsReqId.hashCode());
    result = 31 * result + (count == null ? 0: count.hashCode());
    result = 31 * result + (shippingAddressId == null ? 0: shippingAddressId.hashCode());
    result = 31 * result + (remarks == null ? 0: remarks.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddGoodsOrder {\n");
    
    sb.append("  goodsId: ").append(goodsId).append("\n");
    sb.append("  goodsReqId: ").append(goodsReqId).append("\n");
    sb.append("  count: ").append(count).append("\n");
    sb.append("  shippingAddressId: ").append(shippingAddressId).append("\n");
    sb.append("  remarks: ").append(remarks).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
