package io.swagger.client.model;

import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u540E\u53F0\u7BA1\u7406\u5458\u4FE1\u606F
 **/
@ApiModel(description = "\u540E\u53F0\u7BA1\u7406\u5458\u4FE1\u606F")
public class AddAdmin  implements Serializable{
  
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddAdmin addAdmin = (AddAdmin) o;
    return (code == null ? addAdmin.code == null : code.equals(addAdmin.code)) &&
        (username == null ? addAdmin.username == null : username.equals(addAdmin.username)) &&
        (name == null ? addAdmin.name == null : name.equals(addAdmin.name)) &&
        (gender == null ? addAdmin.gender == null : gender.equals(addAdmin.gender)) &&
        (mobile == null ? addAdmin.mobile == null : mobile.equals(addAdmin.mobile)) &&
        (email == null ? addAdmin.email == null : email.equals(addAdmin.email)) &&
        (idNumber == null ? addAdmin.idNumber == null : idNumber.equals(addAdmin.idNumber));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (code == null ? 0: code.hashCode());
    result = 31 * result + (username == null ? 0: username.hashCode());
    result = 31 * result + (name == null ? 0: name.hashCode());
    result = 31 * result + (gender == null ? 0: gender.hashCode());
    result = 31 * result + (mobile == null ? 0: mobile.hashCode());
    result = 31 * result + (email == null ? 0: email.hashCode());
    result = 31 * result + (idNumber == null ? 0: idNumber.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddAdmin {\n");
    
    sb.append("  code: ").append(code).append("\n");
    sb.append("  username: ").append(username).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  gender: ").append(gender).append("\n");
    sb.append("  mobile: ").append(mobile).append("\n");
    sb.append("  email: ").append(email).append("\n");
    sb.append("  idNumber: ").append(idNumber).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
