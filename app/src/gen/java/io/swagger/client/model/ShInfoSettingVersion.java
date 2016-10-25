package io.swagger.client.model;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u5546\u57CE\u7684\u9996\u9875\u76F8\u5173\u8BBE\u7F6E\u7248\u672C\u53F7\uFF0C\u7528\u4E8Eapp\u5224\u65AD\u662F\u5426\u9700\u8981\u66F4\u65B0\u672C\u5730\u7F13\u5B58\u6570\u636E\u3002
 **/
@ApiModel(description = "\u5546\u57CE\u7684\u9996\u9875\u76F8\u5173\u8BBE\u7F6E\u7248\u672C\u53F7\uFF0C\u7528\u4E8Eapp\u5224\u65AD\u662F\u5426\u9700\u8981\u66F4\u65B0\u672C\u5730\u7F13\u5B58\u6570\u636E\u3002")
public class ShInfoSettingVersion  implements Serializable{
  
  @SerializedName("homeBannerSettingVersion")
  private Date homeBannerSettingVersion = null;
  @SerializedName("goodsCategoryVersion")
  private Date goodsCategoryVersion = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public Date getHomeBannerSettingVersion() {
    return homeBannerSettingVersion;
  }
  public void setHomeBannerSettingVersion(Date homeBannerSettingVersion) {
    this.homeBannerSettingVersion = homeBannerSettingVersion;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Date getGoodsCategoryVersion() {
    return goodsCategoryVersion;
  }
  public void setGoodsCategoryVersion(Date goodsCategoryVersion) {
    this.goodsCategoryVersion = goodsCategoryVersion;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShInfoSettingVersion shInfoSettingVersion = (ShInfoSettingVersion) o;
    return (homeBannerSettingVersion == null ? shInfoSettingVersion.homeBannerSettingVersion == null : homeBannerSettingVersion.equals(shInfoSettingVersion.homeBannerSettingVersion)) &&
        (goodsCategoryVersion == null ? shInfoSettingVersion.goodsCategoryVersion == null : goodsCategoryVersion.equals(shInfoSettingVersion.goodsCategoryVersion));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (homeBannerSettingVersion == null ? 0: homeBannerSettingVersion.hashCode());
    result = 31 * result + (goodsCategoryVersion == null ? 0: goodsCategoryVersion.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShInfoSettingVersion {\n");
    
    sb.append("  homeBannerSettingVersion: ").append(homeBannerSettingVersion).append("\n");
    sb.append("  goodsCategoryVersion: ").append(goodsCategoryVersion).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
