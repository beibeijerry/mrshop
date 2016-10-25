package io.swagger.client.model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class SimpleAppGoodsOrder  implements Serializable{
  
  @SerializedName("orderNo")
  private String orderNo = null;
  @SerializedName("goodsNo")
  private String goodsNo = null;
  @SerializedName("goodsThumb")
  private String goodsThumb = null;
  @SerializedName("goodsTitle")
  private String goodsTitle = null;
  @SerializedName("goodsDetail")
  private String goodsDetail = null;
  @SerializedName("count")
  private Integer count = null;
  @SerializedName("goodsTotalPrice")
  private BigDecimal goodsTotalPrice = null;
  @SerializedName("postage")
  private BigDecimal postage = null;
  @SerializedName("status")
  private Integer status = null;
  @SerializedName("statusDes")
  private String statusDes = null;
  @SerializedName("createTime")
  private Date createTime = null;
  @SerializedName("logisticsName")
  private String logisticsName = null;
  @SerializedName("logisticsNo")
  private String logisticsNo = null;
  @SerializedName("shippingAddress")
  private String shippingAddress = null;
  @SerializedName("remarks")
  private String remarks = null;

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
   **/
  @ApiModelProperty(value = "")
  public String getGoodsNo() {
    return goodsNo;
  }
  public void setGoodsNo(String goodsNo) {
    this.goodsNo = goodsNo;
  }

  /**
   * \u5546\u54C1\u7F29\u7387\u56FE
   **/
  @ApiModelProperty(value = "\u5546\u54C1\u7F29\u7387\u56FE")
  public String getGoodsThumb() {
    return goodsThumb;
  }
  public void setGoodsThumb(String goodsThumb) {
    this.goodsThumb = goodsThumb;
  }

  /**
   * \u5546\u54C1\u6807\u9898
   **/
  @ApiModelProperty(value = "\u5546\u54C1\u6807\u9898")
  public String getGoodsTitle() {
    return goodsTitle;
  }
  public void setGoodsTitle(String goodsTitle) {
    this.goodsTitle = goodsTitle;
  }

  /**
   * \u8D2D\u4E70\u7684\u989C\u8272\u5927\u5C0F\u4FE1\u606F
   **/
  @ApiModelProperty(value = "\u8D2D\u4E70\u7684\u989C\u8272\u5927\u5C0F\u4FE1\u606F")
  public String getGoodsDetail() {
    return goodsDetail;
  }
  public void setGoodsDetail(String goodsDetail) {
    this.goodsDetail = goodsDetail;
  }

  /**
   * \u5546\u54C1\u6570\u91CF
   **/
  @ApiModelProperty(value = "\u5546\u54C1\u6570\u91CF")
  public Integer getCount() {
    return count;
  }
  public void setCount(Integer count) {
    this.count = count;
  }

  /**
   * \u8BA2\u5355\u5546\u54C1\u603B\u4EF7
   **/
  @ApiModelProperty(value = "\u8BA2\u5355\u5546\u54C1\u603B\u4EF7")
  public BigDecimal getGoodsTotalPrice() {
    return goodsTotalPrice;
  }
  public void setGoodsTotalPrice(BigDecimal goodsTotalPrice) {
    this.goodsTotalPrice = goodsTotalPrice;
  }

  /**
   * \u8BA2\u5355\u90AE\u5BC4\u8D39\u7528
   **/
  @ApiModelProperty(value = "\u8BA2\u5355\u90AE\u5BC4\u8D39\u7528")
  public BigDecimal getPostage() {
    return postage;
  }
  public void setPostage(BigDecimal postage) {
    this.postage = postage;
  }

  /**
   * \u8BA2\u5355\u72B6\u6001\uFF1A 0 \u4EE3\u4ED8\u6B3E  1 \u4EE3\u53D1\u8D27  2 \u5DF2\u53D1\u8D27  3 \u5F85\u8BC4\u4EF7  4 \u5DF2\u5B8C\u6210   5\u5173\u95ED
   **/
  @ApiModelProperty(value = "\u8BA2\u5355\u72B6\u6001\uFF1A 0 \u4EE3\u4ED8\u6B3E  1 \u4EE3\u53D1\u8D27  2 \u5DF2\u53D1\u8D27  3 \u5F85\u8BC4\u4EF7  4 \u5DF2\u5B8C\u6210   5\u5173\u95ED")
  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * \u72B6\u6001\u540D\u79F0
   **/
  @ApiModelProperty(value = "\u72B6\u6001\u540D\u79F0")
  public String getStatusDes() {
    return statusDes;
  }
  public void setStatusDes(String statusDes) {
    this.statusDes = statusDes;
  }

  /**
   * \u8BA2\u5355\u521B\u5EFA\u65F6\u95F4
   **/
  @ApiModelProperty(value = "\u8BA2\u5355\u521B\u5EFA\u65F6\u95F4")
  public Date getCreateTime() {
    return createTime;
  }
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  /**
   * \u7269\u6D41\u516C\u53F8\u540D\u79F0
   **/
  @ApiModelProperty(value = "\u7269\u6D41\u516C\u53F8\u540D\u79F0")
  public String getLogisticsName() {
    return logisticsName;
  }
  public void setLogisticsName(String logisticsName) {
    this.logisticsName = logisticsName;
  }

  /**
   * \u7269\u6D41\u7F16\u53F7
   **/
  @ApiModelProperty(value = "\u7269\u6D41\u7F16\u53F7")
  public String getLogisticsNo() {
    return logisticsNo;
  }
  public void setLogisticsNo(String logisticsNo) {
    this.logisticsNo = logisticsNo;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getShippingAddress() {
    return shippingAddress;
  }
  public void setShippingAddress(String shippingAddress) {
    this.shippingAddress = shippingAddress;
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SimpleAppGoodsOrder simpleAppGoodsOrder = (SimpleAppGoodsOrder) o;
    return (orderNo == null ? simpleAppGoodsOrder.orderNo == null : orderNo.equals(simpleAppGoodsOrder.orderNo)) &&
        (goodsNo == null ? simpleAppGoodsOrder.goodsNo == null : goodsNo.equals(simpleAppGoodsOrder.goodsNo)) &&
        (goodsThumb == null ? simpleAppGoodsOrder.goodsThumb == null : goodsThumb.equals(simpleAppGoodsOrder.goodsThumb)) &&
        (goodsTitle == null ? simpleAppGoodsOrder.goodsTitle == null : goodsTitle.equals(simpleAppGoodsOrder.goodsTitle)) &&
        (goodsDetail == null ? simpleAppGoodsOrder.goodsDetail == null : goodsDetail.equals(simpleAppGoodsOrder.goodsDetail)) &&
        (count == null ? simpleAppGoodsOrder.count == null : count.equals(simpleAppGoodsOrder.count)) &&
        (goodsTotalPrice == null ? simpleAppGoodsOrder.goodsTotalPrice == null : goodsTotalPrice.equals(simpleAppGoodsOrder.goodsTotalPrice)) &&
        (postage == null ? simpleAppGoodsOrder.postage == null : postage.equals(simpleAppGoodsOrder.postage)) &&
        (status == null ? simpleAppGoodsOrder.status == null : status.equals(simpleAppGoodsOrder.status)) &&
        (statusDes == null ? simpleAppGoodsOrder.statusDes == null : statusDes.equals(simpleAppGoodsOrder.statusDes)) &&
        (createTime == null ? simpleAppGoodsOrder.createTime == null : createTime.equals(simpleAppGoodsOrder.createTime)) &&
        (logisticsName == null ? simpleAppGoodsOrder.logisticsName == null : logisticsName.equals(simpleAppGoodsOrder.logisticsName)) &&
        (logisticsNo == null ? simpleAppGoodsOrder.logisticsNo == null : logisticsNo.equals(simpleAppGoodsOrder.logisticsNo)) &&
        (shippingAddress == null ? simpleAppGoodsOrder.shippingAddress == null : shippingAddress.equals(simpleAppGoodsOrder.shippingAddress)) &&
        (remarks == null ? simpleAppGoodsOrder.remarks == null : remarks.equals(simpleAppGoodsOrder.remarks));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (orderNo == null ? 0: orderNo.hashCode());
    result = 31 * result + (goodsNo == null ? 0: goodsNo.hashCode());
    result = 31 * result + (goodsThumb == null ? 0: goodsThumb.hashCode());
    result = 31 * result + (goodsTitle == null ? 0: goodsTitle.hashCode());
    result = 31 * result + (goodsDetail == null ? 0: goodsDetail.hashCode());
    result = 31 * result + (count == null ? 0: count.hashCode());
    result = 31 * result + (goodsTotalPrice == null ? 0: goodsTotalPrice.hashCode());
    result = 31 * result + (postage == null ? 0: postage.hashCode());
    result = 31 * result + (status == null ? 0: status.hashCode());
    result = 31 * result + (statusDes == null ? 0: statusDes.hashCode());
    result = 31 * result + (createTime == null ? 0: createTime.hashCode());
    result = 31 * result + (logisticsName == null ? 0: logisticsName.hashCode());
    result = 31 * result + (logisticsNo == null ? 0: logisticsNo.hashCode());
    result = 31 * result + (shippingAddress == null ? 0: shippingAddress.hashCode());
    result = 31 * result + (remarks == null ? 0: remarks.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SimpleAppGoodsOrder {\n");
    
    sb.append("  orderNo: ").append(orderNo).append("\n");
    sb.append("  goodsNo: ").append(goodsNo).append("\n");
    sb.append("  goodsThumb: ").append(goodsThumb).append("\n");
    sb.append("  goodsTitle: ").append(goodsTitle).append("\n");
    sb.append("  goodsDetail: ").append(goodsDetail).append("\n");
    sb.append("  count: ").append(count).append("\n");
    sb.append("  goodsTotalPrice: ").append(goodsTotalPrice).append("\n");
    sb.append("  postage: ").append(postage).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  statusDes: ").append(statusDes).append("\n");
    sb.append("  createTime: ").append(createTime).append("\n");
    sb.append("  logisticsName: ").append(logisticsName).append("\n");
    sb.append("  logisticsNo: ").append(logisticsNo).append("\n");
    sb.append("  shippingAddress: ").append(shippingAddress).append("\n");
    sb.append("  remarks: ").append(remarks).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
