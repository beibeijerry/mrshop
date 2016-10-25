package io.swagger.client.model;

import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class KeyValue  implements Serializable{
  
  @SerializedName("name")
  private String name = null;
  @SerializedName("value")
  private String value = null;

  /**
   * key\u7684\u540D\u79F0
   **/
  @ApiModelProperty(value = "key\u7684\u540D\u79F0")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * \u503C
   **/
  @ApiModelProperty(value = "\u503C")
  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeyValue keyValue = (KeyValue) o;
    return (name == null ? keyValue.name == null : name.equals(keyValue.name)) &&
        (value == null ? keyValue.value == null : value.equals(keyValue.value));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (name == null ? 0: name.hashCode());
    result = 31 * result + (value == null ? 0: value.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeyValue {\n");
    
    sb.append("  name: ").append(name).append("\n");
    sb.append("  value: ").append(value).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
