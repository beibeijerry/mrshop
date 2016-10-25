package io.swagger.client.model;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u4E2A\u4EBA\u4FE1\u606F
 **/
@ApiModel(description = "\u4E2A\u4EBA\u4FE1\u606F")
public class PersonInfo  implements Serializable{
  
  @SerializedName("usId")
  private Long usId = null;
  @SerializedName("accCode")
  private Long accCode = null;
  @SerializedName("username")
  private String username = null;
  @SerializedName("mobile")
  private String mobile = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("avatar")
  private String avatar = null;
  @SerializedName("gender")
  private Boolean gender = null;
  @SerializedName("birthday")
  private Date birthday = null;
  @SerializedName("createTime")
  private Date createTime = null;
  @SerializedName("updateTime")
  private Date updateTime = null;

  /**
   * \u7528\u6237\u81EA\u589Eid
   **/
  @ApiModelProperty(value = "\u7528\u6237\u81EA\u589Eid")
  public Long getUsId() {
    return usId;
  }
  public void setUsId(Long usId) {
    this.usId = usId;
  }

  /**
   * \u8D26\u6237\u53F7
   **/
  @ApiModelProperty(value = "\u8D26\u6237\u53F7")
  public Long getAccCode() {
    return accCode;
  }
  public void setAccCode(Long accCode) {
    this.accCode = accCode;
  }

  /**
   * \u7528\u6237\u767B\u5F55\u540D
   **/
  @ApiModelProperty(value = "\u7528\u6237\u767B\u5F55\u540D")
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * \u624B\u673A\u53F7
   **/
  @ApiModelProperty(value = "\u624B\u673A\u53F7")
  public String getMobile() {
    return mobile;
  }
  public void setMobile(String mobile) {
    this.mobile = mobile;
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
   * \u7528\u6237\u5934\u50CF
   **/
  @ApiModelProperty(value = "\u7528\u6237\u5934\u50CF")
  public String getAvatar() {
    return avatar;
  }
  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  /**
   * true:\u7537 false:\u5973
   **/
  @ApiModelProperty(value = "true:\u7537 false:\u5973")
  public Boolean getGender() {
    return gender;
  }
  public void setGender(Boolean gender) {
    this.gender = gender;
  }

  /**
   * \u51FA\u751F\u5E74\u6708
   **/
  @ApiModelProperty(value = "\u51FA\u751F\u5E74\u6708")
  public Date getBirthday() {
    return birthday;
  }
  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  /**
   * \u521B\u5EFA/\u6CE8\u518C\u65F6\u95F4
   **/
  @ApiModelProperty(value = "\u521B\u5EFA/\u6CE8\u518C\u65F6\u95F4")
  public Date getCreateTime() {
    return createTime;
  }
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  /**
   * \u66F4\u65B0\u65F6\u95F4
   **/
  @ApiModelProperty(value = "\u66F4\u65B0\u65F6\u95F4")
  public Date getUpdateTime() {
    return updateTime;
  }
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonInfo personInfo = (PersonInfo) o;
    return (usId == null ? personInfo.usId == null : usId.equals(personInfo.usId)) &&
        (accCode == null ? personInfo.accCode == null : accCode.equals(personInfo.accCode)) &&
        (username == null ? personInfo.username == null : username.equals(personInfo.username)) &&
        (mobile == null ? personInfo.mobile == null : mobile.equals(personInfo.mobile)) &&
        (name == null ? personInfo.name == null : name.equals(personInfo.name)) &&
        (avatar == null ? personInfo.avatar == null : avatar.equals(personInfo.avatar)) &&
        (gender == null ? personInfo.gender == null : gender.equals(personInfo.gender)) &&
        (birthday == null ? personInfo.birthday == null : birthday.equals(personInfo.birthday)) &&
        (createTime == null ? personInfo.createTime == null : createTime.equals(personInfo.createTime)) &&
        (updateTime == null ? personInfo.updateTime == null : updateTime.equals(personInfo.updateTime));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (usId == null ? 0: usId.hashCode());
    result = 31 * result + (accCode == null ? 0: accCode.hashCode());
    result = 31 * result + (username == null ? 0: username.hashCode());
    result = 31 * result + (mobile == null ? 0: mobile.hashCode());
    result = 31 * result + (name == null ? 0: name.hashCode());
    result = 31 * result + (avatar == null ? 0: avatar.hashCode());
    result = 31 * result + (gender == null ? 0: gender.hashCode());
    result = 31 * result + (birthday == null ? 0: birthday.hashCode());
    result = 31 * result + (createTime == null ? 0: createTime.hashCode());
    result = 31 * result + (updateTime == null ? 0: updateTime.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonInfo {\n");
    
    sb.append("  usId: ").append(usId).append("\n");
    sb.append("  accCode: ").append(accCode).append("\n");
    sb.append("  username: ").append(username).append("\n");
    sb.append("  mobile: ").append(mobile).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  avatar: ").append(avatar).append("\n");
    sb.append("  gender: ").append(gender).append("\n");
    sb.append("  birthday: ").append(birthday).append("\n");
    sb.append("  createTime: ").append(createTime).append("\n");
    sb.append("  updateTime: ").append(updateTime).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
