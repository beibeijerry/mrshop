package io.swagger.client.model;

import java.math.BigDecimal;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class RPRank  implements Serializable{
  
  @SerializedName("rank")
  private Long rank = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("avatar")
  private String avatar = null;
  @SerializedName("rpSum")
  private BigDecimal rpSum = null;
  @SerializedName("grade")
  private Integer grade = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public Long getRank() {
    return rank;
  }
  public void setRank(Long rank) {
    this.rank = rank;
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
  public BigDecimal getRpSum() {
    return rpSum;
  }
  public void setRpSum(BigDecimal rpSum) {
    this.rpSum = rpSum;
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RPRank rPRank = (RPRank) o;
    return (rank == null ? rPRank.rank == null : rank.equals(rPRank.rank)) &&
        (name == null ? rPRank.name == null : name.equals(rPRank.name)) &&
        (avatar == null ? rPRank.avatar == null : avatar.equals(rPRank.avatar)) &&
        (rpSum == null ? rPRank.rpSum == null : rpSum.equals(rPRank.rpSum)) &&
        (grade == null ? rPRank.grade == null : grade.equals(rPRank.grade));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (rank == null ? 0: rank.hashCode());
    result = 31 * result + (name == null ? 0: name.hashCode());
    result = 31 * result + (avatar == null ? 0: avatar.hashCode());
    result = 31 * result + (rpSum == null ? 0: rpSum.hashCode());
    result = 31 * result + (grade == null ? 0: grade.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class RPRank {\n");
    
    sb.append("  rank: ").append(rank).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  avatar: ").append(avatar).append("\n");
    sb.append("  rpSum: ").append(rpSum).append("\n");
    sb.append("  grade: ").append(grade).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
