package io.swagger.client.model;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class UserUnionInfo  implements Serializable{
  
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
  @SerializedName("inviteCode")
  private String inviteCode = null;
  @SerializedName("inviteCount")
  private Integer inviteCount = null;
  @SerializedName("agCode")
  private String agCode = null;
  @SerializedName("introId")
  private Long introId = null;
  @SerializedName("grade")
  private Integer grade = null;
  @SerializedName("gradeName")
  private String gradeName = null;

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

  /**
   * \u63A8\u8350\u7801
   **/
  @ApiModelProperty(value = "\u63A8\u8350\u7801")
  public String getInviteCode() {
    return inviteCode;
  }
  public void setInviteCode(String inviteCode) {
    this.inviteCode = inviteCode;
  }

  /**
   * \u63A8\u8350\u4EBA\u6570
   **/
  @ApiModelProperty(value = "\u63A8\u8350\u4EBA\u6570")
  public Integer getInviteCount() {
    return inviteCount;
  }
  public void setInviteCount(Integer inviteCount) {
    this.inviteCount = inviteCount;
  }

  /**
   * \u7ECF\u9500\u5546\u7F16\u53F7
   **/
  @ApiModelProperty(value = "\u7ECF\u9500\u5546\u7F16\u53F7")
  public String getAgCode() {
    return agCode;
  }
  public void setAgCode(String agCode) {
    this.agCode = agCode;
  }

  /**
   * \u4ECB\u7ECD\u4EBAid
   **/
  @ApiModelProperty(value = "\u4ECB\u7ECD\u4EBAid")
  public Long getIntroId() {
    return introId;
  }
  public void setIntroId(Long introId) {
    this.introId = introId;
  }

  /**
   * \u4F1A\u5458\u7EA7\u522B
   **/
  @ApiModelProperty(value = "\u4F1A\u5458\u7EA7\u522B")
  public Integer getGrade() {
    return grade;
  }
  public void setGrade(Integer grade) {
    this.grade = grade;
  }

  /**
   * \u4F1A\u5458\u7EA7\u522B\u540D\u79F0
   **/
  @ApiModelProperty(value = "\u4F1A\u5458\u7EA7\u522B\u540D\u79F0")
  public String getGradeName() {
    return gradeName;
  }
  public void setGradeName(String gradeName) {
    this.gradeName = gradeName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserUnionInfo userUnionInfo = (UserUnionInfo) o;
    return (usId == null ? userUnionInfo.usId == null : usId.equals(userUnionInfo.usId)) &&
        (accCode == null ? userUnionInfo.accCode == null : accCode.equals(userUnionInfo.accCode)) &&
        (username == null ? userUnionInfo.username == null : username.equals(userUnionInfo.username)) &&
        (mobile == null ? userUnionInfo.mobile == null : mobile.equals(userUnionInfo.mobile)) &&
        (name == null ? userUnionInfo.name == null : name.equals(userUnionInfo.name)) &&
        (avatar == null ? userUnionInfo.avatar == null : avatar.equals(userUnionInfo.avatar)) &&
        (gender == null ? userUnionInfo.gender == null : gender.equals(userUnionInfo.gender)) &&
        (birthday == null ? userUnionInfo.birthday == null : birthday.equals(userUnionInfo.birthday)) &&
        (createTime == null ? userUnionInfo.createTime == null : createTime.equals(userUnionInfo.createTime)) &&
        (updateTime == null ? userUnionInfo.updateTime == null : updateTime.equals(userUnionInfo.updateTime)) &&
        (inviteCode == null ? userUnionInfo.inviteCode == null : inviteCode.equals(userUnionInfo.inviteCode)) &&
        (inviteCount == null ? userUnionInfo.inviteCount == null : inviteCount.equals(userUnionInfo.inviteCount)) &&
        (agCode == null ? userUnionInfo.agCode == null : agCode.equals(userUnionInfo.agCode)) &&
        (introId == null ? userUnionInfo.introId == null : introId.equals(userUnionInfo.introId)) &&
        (grade == null ? userUnionInfo.grade == null : grade.equals(userUnionInfo.grade)) &&
        (gradeName == null ? userUnionInfo.gradeName == null : gradeName.equals(userUnionInfo.gradeName));
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
    result = 31 * result + (inviteCode == null ? 0: inviteCode.hashCode());
    result = 31 * result + (inviteCount == null ? 0: inviteCount.hashCode());
    result = 31 * result + (agCode == null ? 0: agCode.hashCode());
    result = 31 * result + (introId == null ? 0: introId.hashCode());
    result = 31 * result + (grade == null ? 0: grade.hashCode());
    result = 31 * result + (gradeName == null ? 0: gradeName.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserUnionInfo {\n");
    
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
    sb.append("  inviteCode: ").append(inviteCode).append("\n");
    sb.append("  inviteCount: ").append(inviteCount).append("\n");
    sb.append("  agCode: ").append(agCode).append("\n");
    sb.append("  introId: ").append(introId).append("\n");
    sb.append("  grade: ").append(grade).append("\n");
    sb.append("  gradeName: ").append(gradeName).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
