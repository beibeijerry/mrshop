package io.swagger.client.model;

import io.swagger.client.model.AgentInfo;
import io.swagger.client.model.GradeInfo;
import io.swagger.client.model.UserInfo;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u4E2A\u4EBA\u4FE1\u606F
 **/
@ApiModel(description = "\u4E2A\u4EBA\u4FE1\u606F")
public class RelationInfo  implements Serializable{
  
  @SerializedName("agent")
  private AgentInfo agent = null;
  @SerializedName("intro")
  private UserInfo intro = null;
  @SerializedName("grade")
  private GradeInfo grade = null;
  @SerializedName("inviteUrl")
  private String inviteUrl = null;
  @SerializedName("inviteCode")
  private String inviteCode = null;
  @SerializedName("inviteCount")
  private Integer inviteCount = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public AgentInfo getAgent() {
    return agent;
  }
  public void setAgent(AgentInfo agent) {
    this.agent = agent;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public UserInfo getIntro() {
    return intro;
  }
  public void setIntro(UserInfo intro) {
    this.intro = intro;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public GradeInfo getGrade() {
    return grade;
  }
  public void setGrade(GradeInfo grade) {
    this.grade = grade;
  }

  /**
   * \u63A8\u8350\u5730\u5740
   **/
  @ApiModelProperty(value = "\u63A8\u8350\u5730\u5740")
  public String getInviteUrl() {
    return inviteUrl;
  }
  public void setInviteUrl(String inviteUrl) {
    this.inviteUrl = inviteUrl;
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RelationInfo relationInfo = (RelationInfo) o;
    return (agent == null ? relationInfo.agent == null : agent.equals(relationInfo.agent)) &&
        (intro == null ? relationInfo.intro == null : intro.equals(relationInfo.intro)) &&
        (grade == null ? relationInfo.grade == null : grade.equals(relationInfo.grade)) &&
        (inviteUrl == null ? relationInfo.inviteUrl == null : inviteUrl.equals(relationInfo.inviteUrl)) &&
        (inviteCode == null ? relationInfo.inviteCode == null : inviteCode.equals(relationInfo.inviteCode)) &&
        (inviteCount == null ? relationInfo.inviteCount == null : inviteCount.equals(relationInfo.inviteCount));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (agent == null ? 0: agent.hashCode());
    result = 31 * result + (intro == null ? 0: intro.hashCode());
    result = 31 * result + (grade == null ? 0: grade.hashCode());
    result = 31 * result + (inviteUrl == null ? 0: inviteUrl.hashCode());
    result = 31 * result + (inviteCode == null ? 0: inviteCode.hashCode());
    result = 31 * result + (inviteCount == null ? 0: inviteCount.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelationInfo {\n");
    
    sb.append("  agent: ").append(agent).append("\n");
    sb.append("  intro: ").append(intro).append("\n");
    sb.append("  grade: ").append(grade).append("\n");
    sb.append("  inviteUrl: ").append(inviteUrl).append("\n");
    sb.append("  inviteCode: ").append(inviteCode).append("\n");
    sb.append("  inviteCount: ").append(inviteCount).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
