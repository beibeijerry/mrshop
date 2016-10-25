package io.swagger.client.model;

import io.swagger.client.model.BillInfo;
import java.util.*;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u7279\u6743\u7EA2\u5305\u5206\u9875\u6570\u636E
 **/
@ApiModel(description = "\u7279\u6743\u7EA2\u5305\u5206\u9875\u6570\u636E")
public class BillInfoPageData  implements Serializable{
  
  @SerializedName("pageIndex")
  private Integer pageIndex = null;
  @SerializedName("pageSize")
  private Integer pageSize = null;
  @SerializedName("pageTotal")
  private Integer pageTotal = null;
  @SerializedName("totalRecord")
  private Integer totalRecord = null;
  @SerializedName("data")
  private List<BillInfo> data = null;

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public Integer getPageIndex() {
    return pageIndex;
  }
  public void setPageIndex(Integer pageIndex) {
    this.pageIndex = pageIndex;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public Integer getPageSize() {
    return pageSize;
  }
  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public Integer getPageTotal() {
    return pageTotal;
  }
  public void setPageTotal(Integer pageTotal) {
    this.pageTotal = pageTotal;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public Integer getTotalRecord() {
    return totalRecord;
  }
  public void setTotalRecord(Integer totalRecord) {
    this.totalRecord = totalRecord;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public List<BillInfo> getData() {
    return data;
  }
  public void setData(List<BillInfo> data) {
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
    BillInfoPageData billInfoPageData = (BillInfoPageData) o;
    return (pageIndex == null ? billInfoPageData.pageIndex == null : pageIndex.equals(billInfoPageData.pageIndex)) &&
        (pageSize == null ? billInfoPageData.pageSize == null : pageSize.equals(billInfoPageData.pageSize)) &&
        (pageTotal == null ? billInfoPageData.pageTotal == null : pageTotal.equals(billInfoPageData.pageTotal)) &&
        (totalRecord == null ? billInfoPageData.totalRecord == null : totalRecord.equals(billInfoPageData.totalRecord)) &&
        (data == null ? billInfoPageData.data == null : data.equals(billInfoPageData.data));
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
    sb.append("class BillInfoPageData {\n");
    
    sb.append("  pageIndex: ").append(pageIndex).append("\n");
    sb.append("  pageSize: ").append(pageSize).append("\n");
    sb.append("  pageTotal: ").append(pageTotal).append("\n");
    sb.append("  totalRecord: ").append(totalRecord).append("\n");
    sb.append("  data: ").append(data).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
