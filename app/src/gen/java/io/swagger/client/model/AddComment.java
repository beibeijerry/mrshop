package io.swagger.client.model;

import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class AddComment  implements Serializable{
  
  @SerializedName("orderNo")
  private String orderNo = null;
  @SerializedName("content")
  private String content = null;
  @SerializedName("mark")
  private Integer mark = null;

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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddComment addComment = (AddComment) o;
    return (orderNo == null ? addComment.orderNo == null : orderNo.equals(addComment.orderNo)) &&
        (content == null ? addComment.content == null : content.equals(addComment.content)) &&
        (mark == null ? addComment.mark == null : mark.equals(addComment.mark));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (orderNo == null ? 0: orderNo.hashCode());
    result = 31 * result + (content == null ? 0: content.hashCode());
    result = 31 * result + (mark == null ? 0: mark.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddComment {\n");
    
    sb.append("  orderNo: ").append(orderNo).append("\n");
    sb.append("  content: ").append(content).append("\n");
    sb.append("  mark: ").append(mark).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
