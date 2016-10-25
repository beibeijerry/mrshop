package io.swagger.client.model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u7EA2\u5305\u9886\u53D6\u8BB0\u5F55
 **/
@ApiModel(description = "\u7EA2\u5305\u9886\u53D6\u8BB0\u5F55")
public class RPOpenRecord  implements Serializable{
  
  @SerializedName("usId")
  private Long usId = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("avatar")
  private String avatar = null;
  @SerializedName("grade")
  private Integer grade = null;
  @SerializedName("amount")
  private BigDecimal amount = null;
  @SerializedName("time")
  private Date time = null;

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
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getAvatar() {
    return avatar;
  }
  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getGrade() {
    return grade;
  }
  public void setGrade(Integer grade) {
    this.grade = grade;
  }

  /**
   * \u9886\u53D6\u91D1\u989D
   **/
  @ApiModelProperty(value = "\u9886\u53D6\u91D1\u989D")
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Date getTime() {
    return time;
  }
  public void setTime(Date time) {
    this.time = time;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RPOpenRecord rPOpenRecord = (RPOpenRecord) o;
    return (usId == null ? rPOpenRecord.usId == null : usId.equals(rPOpenRecord.usId)) &&
        (name == null ? rPOpenRecord.name == null : name.equals(rPOpenRecord.name)) &&
        (avatar == null ? rPOpenRecord.avatar == null : avatar.equals(rPOpenRecord.avatar)) &&
        (grade == null ? rPOpenRecord.grade == null : grade.equals(rPOpenRecord.grade)) &&
        (amount == null ? rPOpenRecord.amount == null : amount.equals(rPOpenRecord.amount)) &&
        (time == null ? rPOpenRecord.time == null : time.equals(rPOpenRecord.time));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (usId == null ? 0: usId.hashCode());
    result = 31 * result + (name == null ? 0: name.hashCode());
    result = 31 * result + (avatar == null ? 0: avatar.hashCode());
    result = 31 * result + (grade == null ? 0: grade.hashCode());
    result = 31 * result + (amount == null ? 0: amount.hashCode());
    result = 31 * result + (time == null ? 0: time.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class RPOpenRecord {\n");
    
    sb.append("  usId: ").append(usId).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  avatar: ").append(avatar).append("\n");
    sb.append("  grade: ").append(grade).append("\n");
    sb.append("  amount: ").append(amount).append("\n");
    sb.append("  time: ").append(time).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
