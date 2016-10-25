package io.swagger.client.model;

import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u7ED1\u5B9A\u7528\u6237\u4FE1\u606F\u65F6\u8FD4\u56DE\u7684\u5BF9\u8C61
 **/
@ApiModel(description = "\u7ED1\u5B9A\u7528\u6237\u4FE1\u606F\u65F6\u8FD4\u56DE\u7684\u5BF9\u8C61")
public class BindReturn  implements Serializable{
  
  @SerializedName("result")
  private Boolean result = null;
  @SerializedName("watched")
  private Boolean watched = null;
  @SerializedName("info")
  private String info = null;

  /**
   * \u8BE5\u7528\u6237\u5173\u7CFB\u662F\u5426\u7ED1\u5B9A\u6210\u529F
   **/
  @ApiModelProperty(value = "\u8BE5\u7528\u6237\u5173\u7CFB\u662F\u5426\u7ED1\u5B9A\u6210\u529F")
  public Boolean getResult() {
    return result;
  }
  public void setResult(Boolean result) {
    this.result = result;
  }

  /**
   * \u8BE5\u7528\u6237\u662F\u5426\u5173\u6CE8\u4E86\u5FAE\u4FE1\u53F7
   **/
  @ApiModelProperty(value = "\u8BE5\u7528\u6237\u662F\u5426\u5173\u6CE8\u4E86\u5FAE\u4FE1\u53F7")
  public Boolean getWatched() {
    return watched;
  }
  public void setWatched(Boolean watched) {
    this.watched = watched;
  }

  /**
   * \u63D0\u793A\u4FE1\u606F
   **/
  @ApiModelProperty(value = "\u63D0\u793A\u4FE1\u606F")
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
    BindReturn bindReturn = (BindReturn) o;
    return (result == null ? bindReturn.result == null : result.equals(bindReturn.result)) &&
        (watched == null ? bindReturn.watched == null : watched.equals(bindReturn.watched)) &&
        (info == null ? bindReturn.info == null : info.equals(bindReturn.info));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.result == null ? 0: this.result.hashCode());
    result = 31 * result + (watched == null ? 0: watched.hashCode());
    result = 31 * result + (info == null ? 0: info.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class BindReturn {\n");
    
    sb.append("  result: ").append(result).append("\n");
    sb.append("  watched: ").append(watched).append("\n");
    sb.append("  info: ").append(info).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
