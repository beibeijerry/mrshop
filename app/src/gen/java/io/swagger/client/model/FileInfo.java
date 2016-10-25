package io.swagger.client.model;

import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u6587\u4EF6\u4FE1\u606F
 **/
@ApiModel(description = "\u6587\u4EF6\u4FE1\u606F")
public class FileInfo  implements Serializable{
  
  @SerializedName("auId")
  private Long auId = null;
  @SerializedName("type")
  private Integer type = null;
  @SerializedName("key")
  private String key = null;
  @SerializedName("delable")
  private Boolean delable = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public Long getAuId() {
    return auId;
  }
  public void setAuId(Long auId) {
    this.auId = auId;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getType() {
    return type;
  }
  public void setType(Integer type) {
    this.type = type;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getKey() {
    return key;
  }
  public void setKey(String key) {
    this.key = key;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Boolean getDelable() {
    return delable;
  }
  public void setDelable(Boolean delable) {
    this.delable = delable;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileInfo fileInfo = (FileInfo) o;
    return (auId == null ? fileInfo.auId == null : auId.equals(fileInfo.auId)) &&
        (type == null ? fileInfo.type == null : type.equals(fileInfo.type)) &&
        (key == null ? fileInfo.key == null : key.equals(fileInfo.key)) &&
        (delable == null ? fileInfo.delable == null : delable.equals(fileInfo.delable));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (auId == null ? 0: auId.hashCode());
    result = 31 * result + (type == null ? 0: type.hashCode());
    result = 31 * result + (key == null ? 0: key.hashCode());
    result = 31 * result + (delable == null ? 0: delable.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileInfo {\n");
    
    sb.append("  auId: ").append(auId).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  key: ").append(key).append("\n");
    sb.append("  delable: ").append(delable).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
