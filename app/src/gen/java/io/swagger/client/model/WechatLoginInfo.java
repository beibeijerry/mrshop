package io.swagger.client.model;

import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u5FAE\u4FE1\u6388\u6743\u767B\u5F55\u7684\u8FD4\u56DE\u4FE1\u606F
 **/
@ApiModel(description = "\u5FAE\u4FE1\u6388\u6743\u767B\u5F55\u7684\u8FD4\u56DE\u4FE1\u606F")
public class WechatLoginInfo  implements Serializable{
  
  @SerializedName("isBindMobile")
  private Boolean isBindMobile = null;
  @SerializedName("sessionId")
  private String sessionId = null;

  /**
   * \u8FD4\u56DE\u662F\u5426\u7ED1\u5B9A\u624B\u673A\u53F7\u7684\u72B6\u6001
   **/
  @ApiModelProperty(value = "\u8FD4\u56DE\u662F\u5426\u7ED1\u5B9A\u624B\u673A\u53F7\u7684\u72B6\u6001")
  public Boolean getIsBindMobile() {
    return isBindMobile;
  }
  public void setIsBindMobile(Boolean isBindMobile) {
    this.isBindMobile = isBindMobile;
  }

  /**
   * \u767B\u5F55\u7684sssionId
   **/
  @ApiModelProperty(value = "\u767B\u5F55\u7684sssionId")
  public String getSessionId() {
    return sessionId;
  }
  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WechatLoginInfo wechatLoginInfo = (WechatLoginInfo) o;
    return (isBindMobile == null ? wechatLoginInfo.isBindMobile == null : isBindMobile.equals(wechatLoginInfo.isBindMobile)) &&
        (sessionId == null ? wechatLoginInfo.sessionId == null : sessionId.equals(wechatLoginInfo.sessionId));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (isBindMobile == null ? 0: isBindMobile.hashCode());
    result = 31 * result + (sessionId == null ? 0: sessionId.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class WechatLoginInfo {\n");
    
    sb.append("  isBindMobile: ").append(isBindMobile).append("\n");
    sb.append("  sessionId: ").append(sessionId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
