package io.swagger.client.model;

import io.swagger.client.model.GoodsReq;
import io.swagger.client.model.KeyValue;
import java.math.BigDecimal;
import java.util.*;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class AddOrUpdateGoodsInfo  implements Serializable{
  
  @SerializedName("categoryId")
  private Long categoryId = null;
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
  @SerializedName("detail")
  private String detail = null;
  @SerializedName("attr")
  private List<KeyValue> attr = null;
  @SerializedName("req")
  private List<GoodsReq> req = null;
  @SerializedName("publish")
  private Boolean publish = null;
  @SerializedName("goodsNo")
  private String goodsNo = null;

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
   * \u5546\u54C1\u5E93\u5B58\u5217\u8868
   **/
  @ApiModelProperty(value = "\u5546\u54C1\u5E93\u5B58\u5217\u8868")
  public List<GoodsReq> getReq() {
    return req;
  }
  public void setReq(List<GoodsReq> req) {
    this.req = req;
  }

  /**
   * \u662F\u5426\u76F4\u63A5\u53D1\u5E03
   **/
  @ApiModelProperty(value = "\u662F\u5426\u76F4\u63A5\u53D1\u5E03")
  public Boolean getPublish() {
    return publish;
  }
  public void setPublish(Boolean publish) {
    this.publish = publish;
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
    AddOrUpdateGoodsInfo addOrUpdateGoodsInfo = (AddOrUpdateGoodsInfo) o;
    return (categoryId == null ? addOrUpdateGoodsInfo.categoryId == null : categoryId.equals(addOrUpdateGoodsInfo.categoryId)) &&
        (thumb == null ? addOrUpdateGoodsInfo.thumb == null : thumb.equals(addOrUpdateGoodsInfo.thumb)) &&
        (banner == null ? addOrUpdateGoodsInfo.banner == null : banner.equals(addOrUpdateGoodsInfo.banner)) &&
        (title == null ? addOrUpdateGoodsInfo.title == null : title.equals(addOrUpdateGoodsInfo.title)) &&
        (subTitle == null ? addOrUpdateGoodsInfo.subTitle == null : subTitle.equals(addOrUpdateGoodsInfo.subTitle)) &&
        (price == null ? addOrUpdateGoodsInfo.price == null : price.equals(addOrUpdateGoodsInfo.price)) &&
        (detail == null ? addOrUpdateGoodsInfo.detail == null : detail.equals(addOrUpdateGoodsInfo.detail)) &&
        (attr == null ? addOrUpdateGoodsInfo.attr == null : attr.equals(addOrUpdateGoodsInfo.attr)) &&
        (req == null ? addOrUpdateGoodsInfo.req == null : req.equals(addOrUpdateGoodsInfo.req)) &&
        (publish == null ? addOrUpdateGoodsInfo.publish == null : publish.equals(addOrUpdateGoodsInfo.publish)) &&
        (goodsNo == null ? addOrUpdateGoodsInfo.goodsNo == null : goodsNo.equals(addOrUpdateGoodsInfo.goodsNo));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (categoryId == null ? 0: categoryId.hashCode());
    result = 31 * result + (thumb == null ? 0: thumb.hashCode());
    result = 31 * result + (banner == null ? 0: banner.hashCode());
    result = 31 * result + (title == null ? 0: title.hashCode());
    result = 31 * result + (subTitle == null ? 0: subTitle.hashCode());
    result = 31 * result + (price == null ? 0: price.hashCode());
    result = 31 * result + (detail == null ? 0: detail.hashCode());
    result = 31 * result + (attr == null ? 0: attr.hashCode());
    result = 31 * result + (req == null ? 0: req.hashCode());
    result = 31 * result + (publish == null ? 0: publish.hashCode());
    result = 31 * result + (goodsNo == null ? 0: goodsNo.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddOrUpdateGoodsInfo {\n");
    
    sb.append("  categoryId: ").append(categoryId).append("\n");
    sb.append("  thumb: ").append(thumb).append("\n");
    sb.append("  banner: ").append(banner).append("\n");
    sb.append("  title: ").append(title).append("\n");
    sb.append("  subTitle: ").append(subTitle).append("\n");
    sb.append("  price: ").append(price).append("\n");
    sb.append("  detail: ").append(detail).append("\n");
    sb.append("  attr: ").append(attr).append("\n");
    sb.append("  req: ").append(req).append("\n");
    sb.append("  publish: ").append(publish).append("\n");
    sb.append("  goodsNo: ").append(goodsNo).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
