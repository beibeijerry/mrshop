package io.swagger.client.model;

import java.math.BigDecimal;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class AddOrUpdateGoodsCategory  implements Serializable{
  
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddOrUpdateGoodsCategory addOrUpdateGoodsCategory = (AddOrUpdateGoodsCategory) o;
    return (title == null ? addOrUpdateGoodsCategory.title == null : title.equals(addOrUpdateGoodsCategory.title)) &&
        (subTitle == null ? addOrUpdateGoodsCategory.subTitle == null : subTitle.equals(addOrUpdateGoodsCategory.subTitle)) &&
        (startPrice == null ? addOrUpdateGoodsCategory.startPrice == null : startPrice.equals(addOrUpdateGoodsCategory.startPrice)) &&
        (thumb == null ? addOrUpdateGoodsCategory.thumb == null : thumb.equals(addOrUpdateGoodsCategory.thumb)) &&
        (sort == null ? addOrUpdateGoodsCategory.sort == null : sort.equals(addOrUpdateGoodsCategory.sort));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (title == null ? 0: title.hashCode());
    result = 31 * result + (subTitle == null ? 0: subTitle.hashCode());
    result = 31 * result + (startPrice == null ? 0: startPrice.hashCode());
    result = 31 * result + (thumb == null ? 0: thumb.hashCode());
    result = 31 * result + (sort == null ? 0: sort.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddOrUpdateGoodsCategory {\n");
    
    sb.append("  title: ").append(title).append("\n");
    sb.append("  subTitle: ").append(subTitle).append("\n");
    sb.append("  startPrice: ").append(startPrice).append("\n");
    sb.append("  thumb: ").append(thumb).append("\n");
    sb.append("  sort: ").append(sort).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
