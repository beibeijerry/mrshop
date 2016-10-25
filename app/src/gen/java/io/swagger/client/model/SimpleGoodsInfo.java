package io.swagger.client.model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class SimpleGoodsInfo  implements Serializable{
  
  @SerializedName("auId")
  private Long auId = null;
  @SerializedName("thumb")
  private String thumb = null;
  @SerializedName("banner")
  private String banner = null;
  @SerializedName("title")
  private String title = null;
  @SerializedName("subTitle")
  private String subTitle = null;
  @SerializedName("price")
  private BigDecimal price = null;
  @SerializedName("topTime")
  private Date topTime = null;
  @SerializedName("reqTotalCount")
  private Integer reqTotalCount = null;
  @SerializedName("saleCount")
  private Integer saleCount = null;
  @SerializedName("updateTime")
  private Date updateTime = null;
  @SerializedName("status")
  private Integer status = null;
  @SerializedName("goodsNo")
  private String goodsNo = null;

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
   * \u5217\u8868\u663E\u793A\u7684\u662F\u56FE\u7247
   **/
  @ApiModelProperty(value = "\u5217\u8868\u663E\u793A\u7684\u662F\u56FE\u7247")
  public String getThumb() {
    return thumb;
  }
  public void setThumb(String thumb) {
    this.thumb = thumb;
  }

  /**
   * \u8F6E\u64AD\u56FE
   **/
  @ApiModelProperty(value = "\u8F6E\u64AD\u56FE")
  public String getBanner() {
    return banner;
  }
  public void setBanner(String banner) {
    this.banner = banner;
  }

  /**
   * \u4E3B\u6807\u9898
   **/
  @ApiModelProperty(value = "\u4E3B\u6807\u9898")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * \u6B21\u6807\u9898
   **/
  @ApiModelProperty(value = "\u6B21\u6807\u9898")
  public String getSubTitle() {
    return subTitle;
  }
  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getPrice() {
    return price;
  }
  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  /**
   * \u5546\u54C1\u8BBE\u7F6E\u7F6E\u9876\u7684\u65F6\u95F4
   **/
  @ApiModelProperty(value = "\u5546\u54C1\u8BBE\u7F6E\u7F6E\u9876\u7684\u65F6\u95F4")
  public Date getTopTime() {
    return topTime;
  }
  public void setTopTime(Date topTime) {
    this.topTime = topTime;
  }

  /**
   * \u603B\u5E93\u5B58
   **/
  @ApiModelProperty(value = "\u603B\u5E93\u5B58")
  public Integer getReqTotalCount() {
    return reqTotalCount;
  }
  public void setReqTotalCount(Integer reqTotalCount) {
    this.reqTotalCount = reqTotalCount;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getSaleCount() {
    return saleCount;
  }
  public void setSaleCount(Integer saleCount) {
    this.saleCount = saleCount;
  }

  /**
   * \u6700\u540E\u66F4\u65B0\u65F6\u95F4
   **/
  @ApiModelProperty(value = "\u6700\u540E\u66F4\u65B0\u65F6\u95F4")
  public Date getUpdateTime() {
    return updateTime;
  }
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  /**
   * \u72B6\u6001 0 \u7F16\u8F91\u4E2D 1 \u5DF2\u4E0A\u67B6  2 \u5DF2\u4E0B\u67B6  3 \u5DF2\u5220\u9664
   **/
  @ApiModelProperty(value = "\u72B6\u6001 0 \u7F16\u8F91\u4E2D 1 \u5DF2\u4E0A\u67B6  2 \u5DF2\u4E0B\u67B6  3 \u5DF2\u5220\u9664")
  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SimpleGoodsInfo simpleGoodsInfo = (SimpleGoodsInfo) o;
    return (auId == null ? simpleGoodsInfo.auId == null : auId.equals(simpleGoodsInfo.auId)) &&
        (thumb == null ? simpleGoodsInfo.thumb == null : thumb.equals(simpleGoodsInfo.thumb)) &&
        (banner == null ? simpleGoodsInfo.banner == null : banner.equals(simpleGoodsInfo.banner)) &&
        (title == null ? simpleGoodsInfo.title == null : title.equals(simpleGoodsInfo.title)) &&
        (subTitle == null ? simpleGoodsInfo.subTitle == null : subTitle.equals(simpleGoodsInfo.subTitle)) &&
        (price == null ? simpleGoodsInfo.price == null : price.equals(simpleGoodsInfo.price)) &&
        (topTime == null ? simpleGoodsInfo.topTime == null : topTime.equals(simpleGoodsInfo.topTime)) &&
        (reqTotalCount == null ? simpleGoodsInfo.reqTotalCount == null : reqTotalCount.equals(simpleGoodsInfo.reqTotalCount)) &&
        (saleCount == null ? simpleGoodsInfo.saleCount == null : saleCount.equals(simpleGoodsInfo.saleCount)) &&
        (updateTime == null ? simpleGoodsInfo.updateTime == null : updateTime.equals(simpleGoodsInfo.updateTime)) &&
        (status == null ? simpleGoodsInfo.status == null : status.equals(simpleGoodsInfo.status)) &&
        (goodsNo == null ? simpleGoodsInfo.goodsNo == null : goodsNo.equals(simpleGoodsInfo.goodsNo));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (auId == null ? 0: auId.hashCode());
    result = 31 * result + (thumb == null ? 0: thumb.hashCode());
    result = 31 * result + (banner == null ? 0: banner.hashCode());
    result = 31 * result + (title == null ? 0: title.hashCode());
    result = 31 * result + (subTitle == null ? 0: subTitle.hashCode());
    result = 31 * result + (price == null ? 0: price.hashCode());
    result = 31 * result + (topTime == null ? 0: topTime.hashCode());
    result = 31 * result + (reqTotalCount == null ? 0: reqTotalCount.hashCode());
    result = 31 * result + (saleCount == null ? 0: saleCount.hashCode());
    result = 31 * result + (updateTime == null ? 0: updateTime.hashCode());
    result = 31 * result + (status == null ? 0: status.hashCode());
    result = 31 * result + (goodsNo == null ? 0: goodsNo.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SimpleGoodsInfo {\n");
    
    sb.append("  auId: ").append(auId).append("\n");
    sb.append("  thumb: ").append(thumb).append("\n");
    sb.append("  banner: ").append(banner).append("\n");
    sb.append("  title: ").append(title).append("\n");
    sb.append("  subTitle: ").append(subTitle).append("\n");
    sb.append("  price: ").append(price).append("\n");
    sb.append("  topTime: ").append(topTime).append("\n");
    sb.append("  reqTotalCount: ").append(reqTotalCount).append("\n");
    sb.append("  saleCount: ").append(saleCount).append("\n");
    sb.append("  updateTime: ").append(updateTime).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  goodsNo: ").append(goodsNo).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
