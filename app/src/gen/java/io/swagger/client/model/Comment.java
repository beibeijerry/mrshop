package io.swagger.client.model;

import io.swagger.client.model.AddComment;
import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class Comment extends AddComment implements Serializable{
  
  @SerializedName("orderNo")
  private String orderNo = null;
  @SerializedName("content")
  private String content = null;
  @SerializedName("mark")
  private Integer mark = null;
  @SerializedName("auId")
  private Long auId = null;
  @SerializedName("goodsId")
  private Long goodsId = null;
  @SerializedName("goodsTitle")
  private String goodsTitle = null;
  @SerializedName("goodsThumb")
  private String goodsThumb = null;
  @SerializedName("goodsPrice")
  private BigDecimal goodsPrice = null;
  @SerializedName("usId")
  private Long usId = null;
  @SerializedName("usName")
  private String usName = null;
  @SerializedName("usAvatar")
  private String usAvatar = null;
  @SerializedName("createTime")
  private Date createTime = null;

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
   * \u8BC4\u4EF7\u5185\u5BB9
   **/
  @ApiModelProperty(value = "\u8BC4\u4EF7\u5185\u5BB9")
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * \u8BC4\u5206\uFF080-5\uFF09
   **/
  @ApiModelProperty(value = "\u8BC4\u5206\uFF080-5\uFF09")
  public Integer getMark() {
    return mark;
  }
  public void setMark(Integer mark) {
    this.mark = mark;
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

  /**
   **/
  @ApiModelProperty(value = "")
  public Long getGoodsId() {
    return goodsId;
  }
  public void setGoodsId(Long goodsId) {
    this.goodsId = goodsId;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getGoodsTitle() {
    return goodsTitle;
  }
  public void setGoodsTitle(String goodsTitle) {
    this.goodsTitle = goodsTitle;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getGoodsThumb() {
    return goodsThumb;
  }
  public void setGoodsThumb(String goodsThumb) {
    this.goodsThumb = goodsThumb;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getGoodsPrice() {
    return goodsPrice;
  }
  public void setGoodsPrice(BigDecimal goodsPrice) {
    this.goodsPrice = goodsPrice;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Long getUsId() {
    return usId;
  }
  public void setUsId(Long usId) {
    this.usId = usId;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getUsName() {
    return usName;
  }
  public void setUsName(String usName) {
    this.usName = usName;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getUsAvatar() {
    return usAvatar;
  }
  public void setUsAvatar(String usAvatar) {
    this.usAvatar = usAvatar;
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
    Comment comment = (Comment) o;
    return (orderNo == null ? comment.orderNo == null : orderNo.equals(comment.orderNo)) &&
        (content == null ? comment.content == null : content.equals(comment.content)) &&
        (mark == null ? comment.mark == null : mark.equals(comment.mark)) &&
        (auId == null ? comment.auId == null : auId.equals(comment.auId)) &&
        (goodsId == null ? comment.goodsId == null : goodsId.equals(comment.goodsId)) &&
        (goodsTitle == null ? comment.goodsTitle == null : goodsTitle.equals(comment.goodsTitle)) &&
        (goodsThumb == null ? comment.goodsThumb == null : goodsThumb.equals(comment.goodsThumb)) &&
        (goodsPrice == null ? comment.goodsPrice == null : goodsPrice.equals(comment.goodsPrice)) &&
        (usId == null ? comment.usId == null : usId.equals(comment.usId)) &&
        (usName == null ? comment.usName == null : usName.equals(comment.usName)) &&
        (usAvatar == null ? comment.usAvatar == null : usAvatar.equals(comment.usAvatar)) &&
        (createTime == null ? comment.createTime == null : createTime.equals(comment.createTime));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (orderNo == null ? 0: orderNo.hashCode());
    result = 31 * result + (content == null ? 0: content.hashCode());
    result = 31 * result + (mark == null ? 0: mark.hashCode());
    result = 31 * result + (auId == null ? 0: auId.hashCode());
    result = 31 * result + (goodsId == null ? 0: goodsId.hashCode());
    result = 31 * result + (goodsTitle == null ? 0: goodsTitle.hashCode());
    result = 31 * result + (goodsThumb == null ? 0: goodsThumb.hashCode());
    result = 31 * result + (goodsPrice == null ? 0: goodsPrice.hashCode());
    result = 31 * result + (usId == null ? 0: usId.hashCode());
    result = 31 * result + (usName == null ? 0: usName.hashCode());
    result = 31 * result + (usAvatar == null ? 0: usAvatar.hashCode());
    result = 31 * result + (createTime == null ? 0: createTime.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Comment {\n");
    sb.append("  " + super.toString()).append("\n");
    sb.append("  orderNo: ").append(orderNo).append("\n");
    sb.append("  content: ").append(content).append("\n");
    sb.append("  mark: ").append(mark).append("\n");
    sb.append("  auId: ").append(auId).append("\n");
    sb.append("  goodsId: ").append(goodsId).append("\n");
    sb.append("  goodsTitle: ").append(goodsTitle).append("\n");
    sb.append("  goodsThumb: ").append(goodsThumb).append("\n");
    sb.append("  goodsPrice: ").append(goodsPrice).append("\n");
    sb.append("  usId: ").append(usId).append("\n");
    sb.append("  usName: ").append(usName).append("\n");
    sb.append("  usAvatar: ").append(usAvatar).append("\n");
    sb.append("  createTime: ").append(createTime).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
