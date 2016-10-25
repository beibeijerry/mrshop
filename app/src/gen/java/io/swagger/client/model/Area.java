package io.swagger.client.model;

import io.swagger.client.model.Area;
import java.util.*;
import java.io.Serializable;
import io.swagger.annotations.*;

import com.bigkoo.pickerview.model.IPickerViewData;
import com.google.gson.annotations.SerializedName;


/**
 * \u7701\u5E02\u533A\u4FE1\u606F
 **/
@ApiModel(description = "\u7701\u5E02\u533A\u4FE1\u606F")
public class Area implements Serializable,IPickerViewData{
  
  @SerializedName("code")
  private String code = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("children")
  private List<Area> children = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public List<Area> getChildren() {
    return children;
  }
  public void setChildren(List<Area> children) {
    this.children = children;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Area area = (Area) o;
    return (code == null ? area.code == null : code.equals(area.code)) &&
        (name == null ? area.name == null : name.equals(area.name)) &&
        (children == null ? area.children == null : children.equals(area.children));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (code == null ? 0: code.hashCode());
    result = 31 * result + (name == null ? 0: name.hashCode());
    result = 31 * result + (children == null ? 0: children.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Area {\n");
    
    sb.append("  code: ").append(code).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  children: ").append(children).append("\n");
    sb.append("}\n");
    return sb.toString();
  }

  @Override
  public String getPickerViewText() {
    return name;
  }
}
