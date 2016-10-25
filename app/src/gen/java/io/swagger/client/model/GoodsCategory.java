package io.swagger.client.model;

import io.swagger.client.model.AddOrUpdateGoodsCategory;
import java.math.BigDecimal;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class GoodsCategory  implements Serializable{
  
  @SerializedName("title")
  private String title = null;
  @SerializedName("subTitle")
  private String subTitle = null;
  @SerializedName("startPrice")
  private BigDecimal startPrice = null;
  @SerializedName("thumb")
  private String thumb = null;
  @SerializedName("sort")
  private Integer sort = null;
  @SerializedName("auId")
  private Long auId = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getSubTitle() {
    return subTitle;
  }
  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getStartPrice() {
    return startPrice;
  }
  public void setStartPrice(BigDecimal startPrice) {
    this.startPrice = startPrice;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getThumb() {
    return thumb;
  }
  public void setThumb(String thumb) {
    this.thumb = thumb;
  }

  /**
   * \u6392\u5E8F
   **/
  @ApiModelProperty(value = "\u6392\u5E8F")
  public Integer getSort() {
    return sort;
  }
  public void setSort(Integer sort) {
    this.sort = sort;
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
    GoodsCategory goodsCategory = (GoodsCategory) o;
    return (title == null ? goodsCategory.title == null : title.equals(goodsCategory.title)) &&
        (subTitle == null ? goodsCategory.subTitle == null : subTitle.equals(goodsCategory.subTitle)) &&
        (startPrice == null ? goodsCategory.startPrice == null : startPrice.equals(goodsCategory.startPrice)) &&
        (thumb == null ? goodsCategory.thumb == null : thumb.equals(goodsCategory.thumb)) &&
        (sort == null ? goodsCategory.sort == null : sort.equals(goodsCategory.sort)) &&
        (auId == null ? goodsCategory.auId == null : auId.equals(goodsCategory.auId));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (title == null ? 0: title.hashCode());
    result = 31 * result + (subTitle == null ? 0: subTitle.hashCode());
    result = 31 * result + (startPrice == null ? 0: startPrice.hashCode());
    result = 31 * result + (thumb == null ? 0: thumb.hashCode());
    result = 31 * result + (sort == null ? 0: sort.hashCode());
    result = 31 * result + (auId == null ? 0: auId.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class GoodsCategory {\n");
    sb.append("  " + super.toString()).append("\n");
    sb.append("  title: ").append(title).append("\n");
    sb.append("  subTitle: ").append(subTitle).append("\n");
    sb.append("  startPrice: ").append(startPrice).append("\n");
    sb.append("  thumb: ").append(thumb).append("\n");
    sb.append("  sort: ").append(sort).append("\n");
    sb.append("  auId: ").append(auId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
