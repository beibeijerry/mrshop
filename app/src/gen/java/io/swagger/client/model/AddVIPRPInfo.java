package io.swagger.client.model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class AddVIPRPInfo  implements Serializable{
  
  @SerializedName("startTime")
  private Date startTime = null;
  @SerializedName("rpType")
  private Integer rpType = null;
  @SerializedName("count")
  private Integer count = null;
  @SerializedName("money")
  private BigDecimal money = null;
  @SerializedName("totalMoney")
  private BigDecimal totalMoney = null;
  @SerializedName("indefMaxMoney")
  private BigDecimal indefMaxMoney = null;
  @SerializedName("minGrade")
  private Integer minGrade = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public Date getStartTime() {
    return startTime;
  }
  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  /**
   * \u7EA2\u5305\u7C7B\u578B\u3002 0\u666E\u901A\u7EA2\u5305  1\u62FC\u624B\u6C14\u7EA2\u5305
   **/
  @ApiModelProperty(required = true, value = "\u7EA2\u5305\u7C7B\u578B\u3002 0\u666E\u901A\u7EA2\u5305  1\u62FC\u624B\u6C14\u7EA2\u5305")
  public Integer getRpType() {
    return rpType;
  }
  public void setRpType(Integer rpType) {
    this.rpType = rpType;
  }

  /**
   * \u7EA2\u5305\u4E2A\u6570
   **/
  @ApiModelProperty(required = true, value = "\u7EA2\u5305\u4E2A\u6570")
  public Integer getCount() {
    return count;
  }
  public void setCount(Integer count) {
    this.count = count;
  }

  /**
   * \u5355\u4E2A\u7EA2\u5305\u91D1\u989D\u3002\uFF08type=0)
   **/
  @ApiModelProperty(value = "\u5355\u4E2A\u7EA2\u5305\u91D1\u989D\u3002\uFF08type=0)")
  public BigDecimal getMoney() {
    return money;
  }
  public void setMoney(BigDecimal money) {
    this.money = money;
  }

  /**
   * \u603B\u91D1\u989D\uFF08type=1)
   **/
  @ApiModelProperty(value = "\u603B\u91D1\u989D\uFF08type=1)")
  public BigDecimal getTotalMoney() {
    return totalMoney;
  }
  public void setTotalMoney(BigDecimal totalMoney) {
    this.totalMoney = totalMoney;
  }

  /**
   * \u5355\u4E2A\u7EA2\u5305\u6700\u5927\u91D1\u989D\u3002
   **/
  @ApiModelProperty(value = "\u5355\u4E2A\u7EA2\u5305\u6700\u5927\u91D1\u989D\u3002")
  public BigDecimal getIndefMaxMoney() {
    return indefMaxMoney;
  }
  public void setIndefMaxMoney(BigDecimal indefMaxMoney) {
    this.indefMaxMoney = indefMaxMoney;
  }

  /**
   * \u7EA2\u5305\u53C2\u4E0E\u7684\u6700\u5C0F\u7EA7\u522B\u9650\u5236
   **/
  @ApiModelProperty(value = "\u7EA2\u5305\u53C2\u4E0E\u7684\u6700\u5C0F\u7EA7\u522B\u9650\u5236")
  public Integer getMinGrade() {
    return minGrade;
  }
  public void setMinGrade(Integer minGrade) {
    this.minGrade = minGrade;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddVIPRPInfo addVIPRPInfo = (AddVIPRPInfo) o;
    return (startTime == null ? addVIPRPInfo.startTime == null : startTime.equals(addVIPRPInfo.startTime)) &&
        (rpType == null ? addVIPRPInfo.rpType == null : rpType.equals(addVIPRPInfo.rpType)) &&
        (count == null ? addVIPRPInfo.count == null : count.equals(addVIPRPInfo.count)) &&
        (money == null ? addVIPRPInfo.money == null : money.equals(addVIPRPInfo.money)) &&
        (totalMoney == null ? addVIPRPInfo.totalMoney == null : totalMoney.equals(addVIPRPInfo.totalMoney)) &&
        (indefMaxMoney == null ? addVIPRPInfo.indefMaxMoney == null : indefMaxMoney.equals(addVIPRPInfo.indefMaxMoney)) &&
        (minGrade == null ? addVIPRPInfo.minGrade == null : minGrade.equals(addVIPRPInfo.minGrade));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (startTime == null ? 0: startTime.hashCode());
    result = 31 * result + (rpType == null ? 0: rpType.hashCode());
    result = 31 * result + (count == null ? 0: count.hashCode());
    result = 31 * result + (money == null ? 0: money.hashCode());
    result = 31 * result + (totalMoney == null ? 0: totalMoney.hashCode());
    result = 31 * result + (indefMaxMoney == null ? 0: indefMaxMoney.hashCode());
    result = 31 * result + (minGrade == null ? 0: minGrade.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddVIPRPInfo {\n");
    
    sb.append("  startTime: ").append(startTime).append("\n");
    sb.append("  rpType: ").append(rpType).append("\n");
    sb.append("  count: ").append(count).append("\n");
    sb.append("  money: ").append(money).append("\n");
    sb.append("  totalMoney: ").append(totalMoney).append("\n");
    sb.append("  indefMaxMoney: ").append(indefMaxMoney).append("\n");
    sb.append("  minGrade: ").append(minGrade).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
