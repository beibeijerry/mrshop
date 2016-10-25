package io.swagger.client.model;

import io.swagger.client.model.UserUnionInfo;
import java.util.*;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u5206\u9875\u6570\u636E\u8F7D\u4F53
 **/
@ApiModel(description = "\u5206\u9875\u6570\u636E\u8F7D\u4F53")
public class UserPageData  implements Serializable{
  
  @SerializedName("pageIndex")
  private Integer pageIndex = null;
  @SerializedName("pageSize")
  private Integer pageSize = null;
  @SerializedName("pageTotal")
  private Integer pageTotal = null;
  @SerializedName("totalRecord")
  private Integer totalRecord = null;
  @SerializedName("data")
  private List<UserUnionInfo> data = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getPageIndex() {
    return pageIndex;
  }
  public void setPageIndex(Integer pageIndex) {
    this.pageIndex = pageIndex;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getPageSize() {
    return pageSize;
  }
  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getPageTotal() {
    return pageTotal;
  }
  public void setPageTotal(Integer pageTotal) {
    this.pageTotal = pageTotal;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getTotalRecord() {
    return totalRecord;
  }
  public void setTotalRecord(Integer totalRecord) {
    this.totalRecord = totalRecord;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public List<UserUnionInfo> getData() {
    return data;
  }
  public void setData(List<UserUnionInfo> data) {
    this.data = data;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserPageData userPageData = (UserPageData) o;
    return (pageIndex == null ? userPageData.pageIndex == null : pageIndex.equals(userPageData.pageIndex)) &&
        (pageSize == null ? userPageData.pageSize == null : pageSize.equals(userPageData.pageSize)) &&
        (pageTotal == null ? userPageData.pageTotal == null : pageTotal.equals(userPageData.pageTotal)) &&
        (totalRecord == null ? userPageData.totalRecord == null : totalRecord.equals(userPageData.totalRecord)) &&
        (data == null ? userPageData.data == null : data.equals(userPageData.data));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (pageIndex == null ? 0: pageIndex.hashCode());
    result = 31 * result + (pageSize == null ? 0: pageSize.hashCode());
    result = 31 * result + (pageTotal == null ? 0: pageTotal.hashCode());
    result = 31 * result + (totalRecord == null ? 0: totalRecord.hashCode());
    result = 31 * result + (data == null ? 0: data.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserPageData {\n");
    
    sb.append("  pageIndex: ").append(pageIndex).append("\n");
    sb.append("  pageSize: ").append(pageSize).append("\n");
    sb.append("  pageTotal: ").append(pageTotal).append("\n");
    sb.append("  totalRecord: ").append(totalRecord).append("\n");
    sb.append("  data: ").append(data).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
