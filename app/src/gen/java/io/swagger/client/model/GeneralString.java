package io.swagger.client.model;

import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class GeneralString  implements Serializable{
  
  @SerializedName("value")
  private String value = null;

  /**
   **/
  @ApiModelProperty(value = "")
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
    GeneralString generalString = (GeneralString) o;
    return (value == null ? generalString.value == null : value.equals(generalString.value));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (value == null ? 0: value.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeneralString {\n");
    
    sb.append("  value: ").append(value).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
