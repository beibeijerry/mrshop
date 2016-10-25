package io.swagger.client.model;

import io.swagger.client.model.AddOrUpdateGoodsReq;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class GoodsReq extends AddOrUpdateGoodsReq implements Serializable{
  
  @SerializedName("goodsId")
  private Long goodsId = null;
  @SerializedName("color")
  private String color = null;
  @SerializedName("size")
  private String size = null;
  @SerializedName("reqCount")
  private Integer reqCount = null;
  @SerializedName("auId")
  private Long auId = null;

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
   **/
  @ApiModelProperty(value = "")
  public String getColor() {
    return color;
  }
  public void setColor(String color) {
    this.color = color;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getSize() {
    return size;
  }
  public void setSize(String size) {
    this.size = size;
  }

  /**
   * \u5E93\u5B58\u91CF
   **/
  @ApiModelProperty(value = "\u5E93\u5B58\u91CF")
  public Integer getReqCount() {
    return reqCount;
  }
  public void setReqCount(Integer reqCount) {
    this.reqCount = reqCount;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public Long getAuId() {
    return auId;
  }
  public void setAuId(Long auId) {
    this.auId = auId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GoodsReq goodsReq = (GoodsReq) o;
    return (goodsId == null ? goodsReq.goodsId == null : goodsId.equals(goodsReq.goodsId)) &&
        (color == null ? goodsReq.color == null : color.equals(goodsReq.color)) &&
        (size == null ? goodsReq.size == null : size.equals(goodsReq.size)) &&
        (reqCount == null ? goodsReq.reqCount == null : reqCount.equals(goodsReq.reqCount)) &&
        (auId == null ? goodsReq.auId == null : auId.equals(goodsReq.auId));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (goodsId == null ? 0: goodsId.hashCode());
    result = 31 * result + (color == null ? 0: color.hashCode());
    result = 31 * result + (size == null ? 0: size.hashCode());
    result = 31 * result + (reqCount == null ? 0: reqCount.hashCode());
    result = 31 * result + (auId == null ? 0: auId.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class GoodsReq {\n");
    sb.append("  " + super.toString()).append("\n");
    sb.append("  goodsId: ").append(goodsId).append("\n");
    sb.append("  color: ").append(color).append("\n");
    sb.append("  size: ").append(size).append("\n");
    sb.append("  reqCount: ").append(reqCount).append("\n");
    sb.append("  auId: ").append(auId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
