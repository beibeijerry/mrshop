package io.swagger.client.model;

import io.swagger.client.model.PrePaidCard;
import java.util.*;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * \u5145\u503C\u5361\u5206\u9875\u6570\u636E
 **/
@ApiModel(description = "\u5145\u503C\u5361\u5206\u9875\u6570\u636E")
public class PrePaidCardPageData  implements Serializable{
  
  @SerializedName("pageIndex")
  private Integer pageIndex = null;
  @SerializedName("pageSize")
  private Integer pageSize = null;
  @SerializedName("pageTotal")
  private Integer pageTotal = null;
  @SerializedName("totalRecord")
  private Integer totalRecord = null;
  @SerializedName("data")
  private List<PrePaidCard> data = null;

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
  public List<PrePaidCard> getData() {
    return data;
  }
  public void setData(List<PrePaidCard> data) {
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
    PrePaidCardPageData prePaidCardPageData = (PrePaidCardPageData) o;
    return (pageIndex == null ? prePaidCardPageData.pageIndex == null : pageIndex.equals(prePaidCardPageData.pageIndex)) &&
        (pageSize == null ? prePaidCardPageData.pageSize == null : pageSize.equals(prePaidCardPageData.pageSize)) &&
        (pageTotal == null ? prePaidCardPageData.pageTotal == null : pageTotal.equals(prePaidCardPageData.pageTotal)) &&
        (totalRecord == null ? prePaidCardPageData.totalRecord == null : totalRecord.equals(prePaidCardPageData.totalRecord)) &&
        (data == null ? prePaidCardPageData.data == null : data.equals(prePaidCardPageData.data));
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
    sb.append("class PrePaidCardPageData {\n");
    
    sb.append("  pageIndex: ").append(pageIndex).append("\n");
    sb.append("  pageSize: ").append(pageSize).append("\n");
    sb.append("  pageTotal: ").append(pageTotal).append("\n");
    sb.append("  totalRecord: ").append(totalRecord).append("\n");
    sb.append("  data: ").append(data).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
