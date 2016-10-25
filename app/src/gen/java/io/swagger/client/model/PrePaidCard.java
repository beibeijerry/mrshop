package io.swagger.client.model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class PrePaidCard  implements Serializable{
  
  @SerializedName("cardNo")
  private String cardNo = null;
  @SerializedName("cardAmount")
  private BigDecimal cardAmount = null;
  @SerializedName("status")
  private Integer status = null;
  @SerializedName("createTime")
  private Date createTime = null;
  @SerializedName("consumeTime")
  private Date consumeTime = null;
  @SerializedName("consumeUsId")
  private Long consumeUsId = null;
  @SerializedName("consumeUsName")
  private String consumeUsName = null;
  @SerializedName("consumeUsAvatar")
  private String consumeUsAvatar = null;

  /**
   * \u5145\u503C\u5361\u7F16\u53F7
   **/
  @ApiModelProperty(value = "\u5145\u503C\u5361\u7F16\u53F7")
  public String getCardNo() {
    return cardNo;
  }
  public void setCardNo(String cardNo) {
    this.cardNo = cardNo;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getCardAmount() {
    return cardAmount;
  }
  public void setCardAmount(BigDecimal cardAmount) {
    this.cardAmount = cardAmount;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
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

  /**
   * \u4F7F\u7528\u65F6\u95F4
   **/
  @ApiModelProperty(value = "\u4F7F\u7528\u65F6\u95F4")
  public Date getConsumeTime() {
    return consumeTime;
  }
  public void setConsumeTime(Date consumeTime) {
    this.consumeTime = consumeTime;
  }

  /**
   * \u4F7F\u7528\u4EBAID
   **/
  @ApiModelProperty(value = "\u4F7F\u7528\u4EBAID")
  public Long getConsumeUsId() {
    return consumeUsId;
  }
  public void setConsumeUsId(Long consumeUsId) {
    this.consumeUsId = consumeUsId;
  }

  /**
   * \u4F7F\u7528\u4EBA\u59D3\u540D
   **/
  @ApiModelProperty(value = "\u4F7F\u7528\u4EBA\u59D3\u540D")
  public String getConsumeUsName() {
    return consumeUsName;
  }
  public void setConsumeUsName(String consumeUsName) {
    this.consumeUsName = consumeUsName;
  }

  /**
   * \u4F7F\u7528\u4EBA\u5934\u50CF
   **/
  @ApiModelProperty(value = "\u4F7F\u7528\u4EBA\u5934\u50CF")
  public String getConsumeUsAvatar() {
    return consumeUsAvatar;
  }
  public void setConsumeUsAvatar(String consumeUsAvatar) {
    this.consumeUsAvatar = consumeUsAvatar;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrePaidCard prePaidCard = (PrePaidCard) o;
    return (cardNo == null ? prePaidCard.cardNo == null : cardNo.equals(prePaidCard.cardNo)) &&
        (cardAmount == null ? prePaidCard.cardAmount == null : cardAmount.equals(prePaidCard.cardAmount)) &&
        (status == null ? prePaidCard.status == null : status.equals(prePaidCard.status)) &&
        (createTime == null ? prePaidCard.createTime == null : createTime.equals(prePaidCard.createTime)) &&
        (consumeTime == null ? prePaidCard.consumeTime == null : consumeTime.equals(prePaidCard.consumeTime)) &&
        (consumeUsId == null ? prePaidCard.consumeUsId == null : consumeUsId.equals(prePaidCard.consumeUsId)) &&
        (consumeUsName == null ? prePaidCard.consumeUsName == null : consumeUsName.equals(prePaidCard.consumeUsName)) &&
        (consumeUsAvatar == null ? prePaidCard.consumeUsAvatar == null : consumeUsAvatar.equals(prePaidCard.consumeUsAvatar));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (cardNo == null ? 0: cardNo.hashCode());
    result = 31 * result + (cardAmount == null ? 0: cardAmount.hashCode());
    result = 31 * result + (status == null ? 0: status.hashCode());
    result = 31 * result + (createTime == null ? 0: createTime.hashCode());
    result = 31 * result + (consumeTime == null ? 0: consumeTime.hashCode());
    result = 31 * result + (consumeUsId == null ? 0: consumeUsId.hashCode());
    result = 31 * result + (consumeUsName == null ? 0: consumeUsName.hashCode());
    result = 31 * result + (consumeUsAvatar == null ? 0: consumeUsAvatar.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PrePaidCard {\n");
    
    sb.append("  cardNo: ").append(cardNo).append("\n");
    sb.append("  cardAmount: ").append(cardAmount).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  createTime: ").append(createTime).append("\n");
    sb.append("  consumeTime: ").append(consumeTime).append("\n");
    sb.append("  consumeUsId: ").append(consumeUsId).append("\n");
    sb.append("  consumeUsName: ").append(consumeUsName).append("\n");
    sb.append("  consumeUsAvatar: ").append(consumeUsAvatar).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
