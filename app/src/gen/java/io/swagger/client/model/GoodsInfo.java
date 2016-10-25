package io.swagger.client.model;

import io.swagger.client.model.GoodsReq;
import io.swagger.client.model.KeyValue;
import io.swagger.client.model.SimpleGoodsInfo;
import java.math.BigDecimal;
import java.util.*;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class GoodsInfo extends SimpleGoodsInfo implements Serializable{
  
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
  @SerializedName("averageMark")
  private Float averageMark = null;
  @SerializedName("detail")
  private String detail = null;
  @SerializedName("attr")
  private List<KeyValue> attr = null;
  @SerializedName("categoryId")
  private Long categoryId = null;
  @SerializedName("categoryName")
  private String categoryName = null;
  @SerializedName("req")
  private List<GoodsReq> req = null;
  @SerializedName("colors")
  private List<String> colors = null;
  @SerializedName("size")
  private List<String> size = null;

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

  /**
   * \u5E73\u5747\u8BC4\u4EF7\u5F97\u5206
   **/
  @ApiModelProperty(value = "\u5E73\u5747\u8BC4\u4EF7\u5F97\u5206")
  public Float getAverageMark() {
    return averageMark;
  }
  public void setAverageMark(Float averageMark) {
    this.averageMark = averageMark;
  }

  /**
   * \u56FE\u6587\u8BE6\u60C5
   **/
  @ApiModelProperty(value = "\u56FE\u6587\u8BE6\u60C5")
  public String getDetail() {
    return detail;
  }
  public void setDetail(String detail) {
    this.detail = detail;
  }

  /**
   * \u89C4\u683C\u53C2\u6570\u3002
   **/
  @ApiModelProperty(value = "\u89C4\u683C\u53C2\u6570\u3002")
  public List<KeyValue> getAttr() {
    return attr;
  }
  public void setAttr(List<KeyValue> attr) {
    this.attr = attr;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Long getCategoryId() {
    return categoryId;
  }
  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  /**
   * \u5206\u7C7B\u540D\u79F0
   **/
  @ApiModelProperty(value = "\u5206\u7C7B\u540D\u79F0")
  public String getCategoryName() {
    return categoryName;
  }
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public List<GoodsReq> getReq() {
    return req;
  }
  public void setReq(List<GoodsReq> req) {
    this.req = req;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public List<String> getColors() {
    return colors;
  }
  public void setColors(List<String> colors) {
    this.colors = colors;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public List<String> getSize() {
    return size;
  }
  public void setSize(List<String> size) {
    this.size = size;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GoodsInfo goodsInfo = (GoodsInfo) o;
    return (auId == null ? goodsInfo.auId == null : auId.equals(goodsInfo.auId)) &&
        (thumb == null ? goodsInfo.thumb == null : thumb.equals(goodsInfo.thumb)) &&
        (banner == null ? goodsInfo.banner == null : banner.equals(goodsInfo.banner)) &&
        (title == null ? goodsInfo.title == null : title.equals(goodsInfo.title)) &&
        (subTitle == null ? goodsInfo.subTitle == null : subTitle.equals(goodsInfo.subTitle)) &&
        (price == null ? goodsInfo.price == null : price.equals(goodsInfo.price)) &&
        (topTime == null ? goodsInfo.topTime == null : topTime.equals(goodsInfo.topTime)) &&
        (reqTotalCount == null ? goodsInfo.reqTotalCount == null : reqTotalCount.equals(goodsInfo.reqTotalCount)) &&
        (saleCount == null ? goodsInfo.saleCount == null : saleCount.equals(goodsInfo.saleCount)) &&
        (updateTime == null ? goodsInfo.updateTime == null : updateTime.equals(goodsInfo.updateTime)) &&
        (status == null ? goodsInfo.status == null : status.equals(goodsInfo.status)) &&
        (goodsNo == null ? goodsInfo.goodsNo == null : goodsNo.equals(goodsInfo.goodsNo)) &&
        (averageMark == null ? goodsInfo.averageMark == null : averageMark.equals(goodsInfo.averageMark)) &&
        (detail == null ? goodsInfo.detail == null : detail.equals(goodsInfo.detail)) &&
        (attr == null ? goodsInfo.attr == null : attr.equals(goodsInfo.attr)) &&
        (categoryId == null ? goodsInfo.categoryId == null : categoryId.equals(goodsInfo.categoryId)) &&
        (categoryName == null ? goodsInfo.categoryName == null : categoryName.equals(goodsInfo.categoryName)) &&
        (req == null ? goodsInfo.req == null : req.equals(goodsInfo.req)) &&
        (colors == null ? goodsInfo.colors == null : colors.equals(goodsInfo.colors)) &&
        (size == null ? goodsInfo.size == null : size.equals(goodsInfo.size));
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
    result = 31 * result + (averageMark == null ? 0: averageMark.hashCode());
    result = 31 * result + (detail == null ? 0: detail.hashCode());
    result = 31 * result + (attr == null ? 0: attr.hashCode());
    result = 31 * result + (categoryId == null ? 0: categoryId.hashCode());
    result = 31 * result + (categoryName == null ? 0: categoryName.hashCode());
    result = 31 * result + (req == null ? 0: req.hashCode());
    result = 31 * result + (colors == null ? 0: colors.hashCode());
    result = 31 * result + (size == null ? 0: size.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class GoodsInfo {\n");
    sb.append("  " + super.toString()).append("\n");
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
    sb.append("  averageMark: ").append(averageMark).append("\n");
    sb.append("  detail: ").append(detail).append("\n");
    sb.append("  attr: ").append(attr).append("\n");
    sb.append("  categoryId: ").append(categoryId).append("\n");
    sb.append("  categoryName: ").append(categoryName).append("\n");
    sb.append("  req: ").append(req).append("\n");
    sb.append("  colors: ").append(colors).append("\n");
    sb.append("  size: ").append(size).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
