package io.swagger.client.model;

import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u6587\u4EF6\u4E0A\u4F20token key\u4FE1\u606F
 **/
@ApiModel(description = "\u6587\u4EF6\u4E0A\u4F20token key\u4FE1\u606F")
public class UploadFileToken  implements Serializable{
  
  @SerializedName("token")
  private String token = null;
  @SerializedName("key")
  private String key = null;

  /**
   * token
   **/
  @ApiModelProperty(value = "token")
  public String getToken() {
    return token;
  }
  public void setToken(String token) {
    this.token = token;
  }

  /**
   * \u4E0A\u4F20key
   **/
  @ApiModelProperty(value = "\u4E0A\u4F20key")
  public String getKey() {
    return key;
  }
  public void setKey(String key) {
    this.key = key;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UploadFileToken uploadFileToken = (UploadFileToken) o;
    return (token == null ? uploadFileToken.token == null : token.equals(uploadFileToken.token)) &&
        (key == null ? uploadFileToken.key == null : key.equals(uploadFileToken.key));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (token == null ? 0: token.hashCode());
    result = 31 * result + (key == null ? 0: key.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UploadFileToken {\n");
    
    sb.append("  token: ").append(token).append("\n");
    sb.append("  key: ").append(key).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
