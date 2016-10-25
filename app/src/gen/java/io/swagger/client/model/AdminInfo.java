package io.swagger.client.model;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u540E\u53F0\u7BA1\u7406\u5458\u4FE1\u606F
 **/
@ApiModel(description = "\u540E\u53F0\u7BA1\u7406\u5458\u4FE1\u606F")
public class AdminInfo  implements Serializable{
  
  @SerializedName("autoId")
  private Long autoId = null;
  @SerializedName("code")
  private String code = null;
  @SerializedName("username")
  private String username = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("gender")
  private Boolean gender = null;
  @SerializedName("mobile")
  private String mobile = null;
  @SerializedName("email")
  private String email = null;
  @SerializedName("idNumber")
  private String idNumber = null;
  @SerializedName("createTime")
  private Date createTime = null;
  @SerializedName("modifyTime")
  private Date modifyTime = null;
  @SerializedName("createUser")
  private String createUser = null;
  @SerializedName("modifyUser")
  private String modifyUser = null;
  @SerializedName("enable")
  private Boolean enable = null;

  /**
   * \u7528\u6237\u81EA\u589Eid
   **/
  @ApiModelProperty(value = "\u7528\u6237\u81EA\u589Eid")
  public Long getAutoId() {
    return autoId;
  }
  public void setAutoId(Long autoId) {
    this.autoId = autoId;
  }

  /**
   * \u7F16\u53F7
   **/
  @ApiModelProperty(value = "\u7F16\u53F7")
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  /**
   * \u767B\u5F55\u540D
   **/
  @ApiModelProperty(value = "\u767B\u5F55\u540D")
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * \u59D3\u540D
   **/
  @ApiModelProperty(value = "\u59D3\u540D")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
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
   * \u7535\u8BDD
   **/
  @ApiModelProperty(value = "\u7535\u8BDD")
  public String getMobile() {
    return mobile;
  }
  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  /**
   * \u90AE\u7BB1
   **/
  @ApiModelProperty(value = "\u90AE\u7BB1")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * \u8EAB\u4EFD\u8BC1\u53F7
   **/
  @ApiModelProperty(value = "\u8EAB\u4EFD\u8BC1\u53F7")
  public String getIdNumber() {
    return idNumber;
  }
  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
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
  public Date getModifyTime() {
    return modifyTime;
  }
  public void setModifyTime(Date modifyTime) {
    this.modifyTime = modifyTime;
  }

  /**
   * \u521B\u5EFA\u4EBA\u59D3\u540D
   **/
  @ApiModelProperty(value = "\u521B\u5EFA\u4EBA\u59D3\u540D")
  public String getCreateUser() {
    return createUser;
  }
  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  /**
   * \u6700\u540E\u4FEE\u6539\u4EBA\u59D3\u540D
   **/
  @ApiModelProperty(value = "\u6700\u540E\u4FEE\u6539\u4EBA\u59D3\u540D")
  public String getModifyUser() {
    return modifyUser;
  }
  public void setModifyUser(String modifyUser) {
    this.modifyUser = modifyUser;
  }

  /**
   * \u6709\u6548\u72B6\u6001
   **/
  @ApiModelProperty(value = "\u6709\u6548\u72B6\u6001")
  public Boolean getEnable() {
    return enable;
  }
  public void setEnable(Boolean enable) {
    this.enable = enable;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdminInfo adminInfo = (AdminInfo) o;
    return (autoId == null ? adminInfo.autoId == null : autoId.equals(adminInfo.autoId)) &&
        (code == null ? adminInfo.code == null : code.equals(adminInfo.code)) &&
        (username == null ? adminInfo.username == null : username.equals(adminInfo.username)) &&
        (name == null ? adminInfo.name == null : name.equals(adminInfo.name)) &&
        (gender == null ? adminInfo.gender == null : gender.equals(adminInfo.gender)) &&
        (mobile == null ? adminInfo.mobile == null : mobile.equals(adminInfo.mobile)) &&
        (email == null ? adminInfo.email == null : email.equals(adminInfo.email)) &&
        (idNumber == null ? adminInfo.idNumber == null : idNumber.equals(adminInfo.idNumber)) &&
        (createTime == null ? adminInfo.createTime == null : createTime.equals(adminInfo.createTime)) &&
        (modifyTime == null ? adminInfo.modifyTime == null : modifyTime.equals(adminInfo.modifyTime)) &&
        (createUser == null ? adminInfo.createUser == null : createUser.equals(adminInfo.createUser)) &&
        (modifyUser == null ? adminInfo.modifyUser == null : modifyUser.equals(adminInfo.modifyUser)) &&
        (enable == null ? adminInfo.enable == null : enable.equals(adminInfo.enable));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (autoId == null ? 0: autoId.hashCode());
    result = 31 * result + (code == null ? 0: code.hashCode());
    result = 31 * result + (username == null ? 0: username.hashCode());
    result = 31 * result + (name == null ? 0: name.hashCode());
    result = 31 * result + (gender == null ? 0: gender.hashCode());
    result = 31 * result + (mobile == null ? 0: mobile.hashCode());
    result = 31 * result + (email == null ? 0: email.hashCode());
    result = 31 * result + (idNumber == null ? 0: idNumber.hashCode());
    result = 31 * result + (createTime == null ? 0: createTime.hashCode());
    result = 31 * result + (modifyTime == null ? 0: modifyTime.hashCode());
    result = 31 * result + (createUser == null ? 0: createUser.hashCode());
    result = 31 * result + (modifyUser == null ? 0: modifyUser.hashCode());
    result = 31 * result + (enable == null ? 0: enable.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminInfo {\n");
    
    sb.append("  autoId: ").append(autoId).append("\n");
    sb.append("  code: ").append(code).append("\n");
    sb.append("  username: ").append(username).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  gender: ").append(gender).append("\n");
    sb.append("  mobile: ").append(mobile).append("\n");
    sb.append("  email: ").append(email).append("\n");
    sb.append("  idNumber: ").append(idNumber).append("\n");
    sb.append("  createTime: ").append(createTime).append("\n");
    sb.append("  modifyTime: ").append(modifyTime).append("\n");
    sb.append("  createUser: ").append(createUser).append("\n");
    sb.append("  modifyUser: ").append(modifyUser).append("\n");
    sb.append("  enable: ").append(enable).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
