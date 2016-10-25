package io.swagger.client.model;

import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u7F51\u7EDC\u4EA4\u4E92\u51FA\u73B0\u9519\u8BEF\u7684\u65F6\u5019\u8FD4\u56DE\u4FE1\u606F\u3002
 **/
@ApiModel(description = "\u7F51\u7EDC\u4EA4\u4E92\u51FA\u73B0\u9519\u8BEF\u7684\u65F6\u5019\u8FD4\u56DE\u4FE1\u606F\u3002")
public class Error  implements Serializable{
  
  @SerializedName("code")
  private Integer code = null;
  @SerializedName("info")
  private String info = null;

  /**
   * \u9519\u8BEF\u4EE3\u7801
   **/
  @ApiModelProperty(value = "\u9519\u8BEF\u4EE3\u7801")
  public Integer getCode() {
    return code;
  }
  public void setCode(Integer code) {
    this.code = code;
  }

  /**
   * \u9519\u8BEF\u63D0\u793A\u4FE1\u606F
   **/
  @ApiModelProperty(value = "\u9519\u8BEF\u63D0\u793A\u4FE1\u606F")
  public String getInfo() {
    return info;
  }
  public void setInfo(String info) {
    this.info = info;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return (code == null ? error.code == null : code.equals(error.code)) &&
        (info == null ? error.info == null : info.equals(error.info));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (code == null ? 0: code.hashCode());
    result = 31 * result + (info == null ? 0: info.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("  code: ").append(code).append("\n");
    sb.append("  info: ").append(info).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
