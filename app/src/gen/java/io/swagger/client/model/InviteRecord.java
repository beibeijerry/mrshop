package io.swagger.client.model;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u7ED1\u5B9A\u7528\u6237\u4FE1\u606F\u65F6\u8FD4\u56DE\u7684\u5BF9\u8C61
 **/
@ApiModel(description = "\u7ED1\u5B9A\u7528\u6237\u4FE1\u606F\u65F6\u8FD4\u56DE\u7684\u5BF9\u8C61")
public class InviteRecord  implements Serializable{
  
  @SerializedName("autoId")
  private Long autoId = null;
  @SerializedName("headImg")
  private String headImg = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("usId")
  private Long usId = null;
  @SerializedName("intro")
  private Long intro = null;
  @SerializedName("inviteTime")
  private Date inviteTime = null;
  @SerializedName("status")
  private Integer status = null;

  /**
   * \u81EA\u589Eid
   **/
  @ApiModelProperty(value = "\u81EA\u589Eid")
  public Long getAutoId() {
    return autoId;
  }
  public void setAutoId(Long autoId) {
    this.autoId = autoId;
  }

  /**
   * \u5934\u50CF
   **/
  @ApiModelProperty(value = "\u5934\u50CF")
  public String getHeadImg() {
    return headImg;
  }
  public void setHeadImg(String headImg) {
    this.headImg = headImg;
  }

  /**
   * \u7528\u6237\u6635\u79F0
   **/
  @ApiModelProperty(value = "\u7528\u6237\u6635\u79F0")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * usid
   **/
  @ApiModelProperty(value = "usid")
  public Long getUsId() {
    return usId;
  }
  public void setUsId(Long usId) {
    this.usId = usId;
  }

  /**
   * \u9080\u8BF7\u4EBA\u7684usid
   **/
  @ApiModelProperty(value = "\u9080\u8BF7\u4EBA\u7684usid")
  public Long getIntro() {
    return intro;
  }
  public void setIntro(Long intro) {
    this.intro = intro;
  }

  /**
   * \u9080\u8BF7\u65F6\u95F4
   **/
  @ApiModelProperty(value = "\u9080\u8BF7\u65F6\u95F4")
  public Date getInviteTime() {
    return inviteTime;
  }
  public void setInviteTime(Date inviteTime) {
    this.inviteTime = inviteTime;
  }

  /**
   * \u72B6\u6001 0:\u7ED1\u5B9A\u6210\u529F 1:\u7ED1\u5B9A\u89E3\u9664
   **/
  @ApiModelProperty(value = "\u72B6\u6001 0:\u7ED1\u5B9A\u6210\u529F 1:\u7ED1\u5B9A\u89E3\u9664")
  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InviteRecord inviteRecord = (InviteRecord) o;
    return (autoId == null ? inviteRecord.autoId == null : autoId.equals(inviteRecord.autoId)) &&
        (headImg == null ? inviteRecord.headImg == null : headImg.equals(inviteRecord.headImg)) &&
        (name == null ? inviteRecord.name == null : name.equals(inviteRecord.name)) &&
        (usId == null ? inviteRecord.usId == null : usId.equals(inviteRecord.usId)) &&
        (intro == null ? inviteRecord.intro == null : intro.equals(inviteRecord.intro)) &&
        (inviteTime == null ? inviteRecord.inviteTime == null : inviteTime.equals(inviteRecord.inviteTime)) &&
        (status == null ? inviteRecord.status == null : status.equals(inviteRecord.status));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (autoId == null ? 0: autoId.hashCode());
    result = 31 * result + (headImg == null ? 0: headImg.hashCode());
    result = 31 * result + (name == null ? 0: name.hashCode());
    result = 31 * result + (usId == null ? 0: usId.hashCode());
    result = 31 * result + (intro == null ? 0: intro.hashCode());
    result = 31 * result + (inviteTime == null ? 0: inviteTime.hashCode());
    result = 31 * result + (status == null ? 0: status.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InviteRecord {\n");
    
    sb.append("  autoId: ").append(autoId).append("\n");
    sb.append("  headImg: ").append(headImg).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  usId: ").append(usId).append("\n");
    sb.append("  intro: ").append(intro).append("\n");
    sb.append("  inviteTime: ").append(inviteTime).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
