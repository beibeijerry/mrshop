package io.swagger.client.model;

import java.math.BigDecimal;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class GeneralNumber  implements Serializable{
  
  @SerializedName("value")
  private BigDecimal value = null;

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public BigDecimal getValue() {
    return value;
  }
  public void setValue(BigDecimal value) {
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
    GeneralNumber generalNumber = (GeneralNumber) o;
    return (value == null ? generalNumber.value == null : value.equals(generalNumber.value));
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
    sb.append("class GeneralNumber {\n");
    
    sb.append("  value: ").append(value).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
