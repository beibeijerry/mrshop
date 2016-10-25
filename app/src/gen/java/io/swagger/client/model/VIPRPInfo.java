package io.swagger.client.model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class VIPRPInfo  implements Serializable{
  
  @SerializedName("auId")
  private Long auId = null;
  @SerializedName("rpType")
  private Integer rpType = null;
  @SerializedName("count")
  private Integer count = null;
  @SerializedName("money")
  private BigDecimal money = null;
  @SerializedName("totalMoney")
  private BigDecimal totalMoney = null;
  @SerializedName("minGrade")
  private Integer minGrade = null;
  @SerializedName("goneCount")
  private Integer goneCount = null;
  @SerializedName("goneMoney")
  private BigDecimal goneMoney = null;
  @SerializedName("opened")
  private Boolean opened = null;
  @SerializedName("gotMoneySuccessed")
  private Boolean gotMoneySuccessed = null;
  @SerializedName("gotMoney")
  private BigDecimal gotMoney = null;
  @SerializedName("gotNoMoneyReason")
  private String gotNoMoneyReason = null;
  @SerializedName("openedTime")
  private Date openedTime = null;
  @SerializedName("createTime")
  private Date createTime = null;
  @SerializedName("startTime")
  private Date startTime = null;
  @SerializedName("secondStart")
  private Long secondStart = null;

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
   * \u7EA2\u5305\u7C7B\u578B\u3002 0\u666E\u901A\u7EA2\u5305  1\u62FC\u624B\u6C14\u7EA2\u5305
   **/
  @ApiModelProperty(value = "\u7EA2\u5305\u7C7B\u578B\u3002 0\u666E\u901A\u7EA2\u5305  1\u62FC\u624B\u6C14\u7EA2\u5305")
  public Integer getRpType() {
    return rpType;
  }
  public void setRpType(Integer rpType) {
    this.rpType = rpType;
  }

  /**
   * \u7EA2\u5305\u4E2A\u6570
   **/
  @ApiModelProperty(value = "\u7EA2\u5305\u4E2A\u6570")
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
   * \u7EA2\u5305\u53C2\u4E0E\u7684\u6700\u5C0F\u7EA7\u522B\u9650\u5236
   **/
  @ApiModelProperty(value = "\u7EA2\u5305\u53C2\u4E0E\u7684\u6700\u5C0F\u7EA7\u522B\u9650\u5236")
  public Integer getMinGrade() {
    return minGrade;
  }
  public void setMinGrade(Integer minGrade) {
    this.minGrade = minGrade;
  }

  /**
   * \u5DF2\u9886\u53D6\u4E2A\u6570
   **/
  @ApiModelProperty(value = "\u5DF2\u9886\u53D6\u4E2A\u6570")
  public Integer getGoneCount() {
    return goneCount;
  }
  public void setGoneCount(Integer goneCount) {
    this.goneCount = goneCount;
  }

  /**
   * \u5DF2\u9886\u53D6\u91D1\u989D
   **/
  @ApiModelProperty(value = "\u5DF2\u9886\u53D6\u91D1\u989D")
  public BigDecimal getGoneMoney() {
    return goneMoney;
  }
  public void setGoneMoney(BigDecimal goneMoney) {
    this.goneMoney = goneMoney;
  }

  /**
   * \u662F\u5426\u5DF2\u9886\u53D6
   **/
  @ApiModelProperty(value = "\u662F\u5426\u5DF2\u9886\u53D6")
  public Boolean getOpened() {
    return opened;
  }
  public void setOpened(Boolean opened) {
    this.opened = opened;
  }

  /**
   * \u662F\u5426\u5DF2\u9886\u53D6
   **/
  @ApiModelProperty(value = "\u662F\u5426\u5DF2\u9886\u53D6")
  public Boolean getGotMoneySuccessed() {
    return gotMoneySuccessed;
  }
  public void setGotMoneySuccessed(Boolean gotMoneySuccessed) {
    this.gotMoneySuccessed = gotMoneySuccessed;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getGotMoney() {
    return gotMoney;
  }
  public void setGotMoney(BigDecimal gotMoney) {
    this.gotMoney = gotMoney;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getGotNoMoneyReason() {
    return gotNoMoneyReason;
  }
  public void setGotNoMoneyReason(String gotNoMoneyReason) {
    this.gotNoMoneyReason = gotNoMoneyReason;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Date getOpenedTime() {
    return openedTime;
  }
  public void setOpenedTime(Date openedTime) {
    this.openedTime = openedTime;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Date getCreateTime() {
    return createTime;
  }
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

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
   * \u8DDD\u79BB\u5F00\u59CB\u5269\u4F59\u65F6\u95F4\uFF08\u79D2\u6570\uFF09
   **/
  @ApiModelProperty(value = "\u8DDD\u79BB\u5F00\u59CB\u5269\u4F59\u65F6\u95F4\uFF08\u79D2\u6570\uFF09")
  public Long getSecondStart() {
    return secondStart;
  }
  public void setSecondStart(Long secondStart) {
    this.secondStart = secondStart;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VIPRPInfo vIPRPInfo = (VIPRPInfo) o;
    return (auId == null ? vIPRPInfo.auId == null : auId.equals(vIPRPInfo.auId)) &&
        (rpType == null ? vIPRPInfo.rpType == null : rpType.equals(vIPRPInfo.rpType)) &&
        (count == null ? vIPRPInfo.count == null : count.equals(vIPRPInfo.count)) &&
        (money == null ? vIPRPInfo.money == null : money.equals(vIPRPInfo.money)) &&
        (totalMoney == null ? vIPRPInfo.totalMoney == null : totalMoney.equals(vIPRPInfo.totalMoney)) &&
        (minGrade == null ? vIPRPInfo.minGrade == null : minGrade.equals(vIPRPInfo.minGrade)) &&
        (goneCount == null ? vIPRPInfo.goneCount == null : goneCount.equals(vIPRPInfo.goneCount)) &&
        (goneMoney == null ? vIPRPInfo.goneMoney == null : goneMoney.equals(vIPRPInfo.goneMoney)) &&
        (opened == null ? vIPRPInfo.opened == null : opened.equals(vIPRPInfo.opened)) &&
        (gotMoneySuccessed == null ? vIPRPInfo.gotMoneySuccessed == null : gotMoneySuccessed.equals(vIPRPInfo.gotMoneySuccessed)) &&
        (gotMoney == null ? vIPRPInfo.gotMoney == null : gotMoney.equals(vIPRPInfo.gotMoney)) &&
        (gotNoMoneyReason == null ? vIPRPInfo.gotNoMoneyReason == null : gotNoMoneyReason.equals(vIPRPInfo.gotNoMoneyReason)) &&
        (openedTime == null ? vIPRPInfo.openedTime == null : openedTime.equals(vIPRPInfo.openedTime)) &&
        (createTime == null ? vIPRPInfo.createTime == null : createTime.equals(vIPRPInfo.createTime)) &&
        (startTime == null ? vIPRPInfo.startTime == null : startTime.equals(vIPRPInfo.startTime)) &&
        (secondStart == null ? vIPRPInfo.secondStart == null : secondStart.equals(vIPRPInfo.secondStart));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (auId == null ? 0: auId.hashCode());
    result = 31 * result + (rpType == null ? 0: rpType.hashCode());
    result = 31 * result + (count == null ? 0: count.hashCode());
    result = 31 * result + (money == null ? 0: money.hashCode());
    result = 31 * result + (totalMoney == null ? 0: totalMoney.hashCode());
    result = 31 * result + (minGrade == null ? 0: minGrade.hashCode());
    result = 31 * result + (goneCount == null ? 0: goneCount.hashCode());
    result = 31 * result + (goneMoney == null ? 0: goneMoney.hashCode());
    result = 31 * result + (opened == null ? 0: opened.hashCode());
    result = 31 * result + (gotMoneySuccessed == null ? 0: gotMoneySuccessed.hashCode());
    result = 31 * result + (gotMoney == null ? 0: gotMoney.hashCode());
    result = 31 * result + (gotNoMoneyReason == null ? 0: gotNoMoneyReason.hashCode());
    result = 31 * result + (openedTime == null ? 0: openedTime.hashCode());
    result = 31 * result + (createTime == null ? 0: createTime.hashCode());
    result = 31 * result + (startTime == null ? 0: startTime.hashCode());
    result = 31 * result + (secondStart == null ? 0: secondStart.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class VIPRPInfo {\n");
    
    sb.append("  auId: ").append(auId).append("\n");
    sb.append("  rpType: ").append(rpType).append("\n");
    sb.append("  count: ").append(count).append("\n");
    sb.append("  money: ").append(money).append("\n");
    sb.append("  totalMoney: ").append(totalMoney).append("\n");
    sb.append("  minGrade: ").append(minGrade).append("\n");
    sb.append("  goneCount: ").append(goneCount).append("\n");
    sb.append("  goneMoney: ").append(goneMoney).append("\n");
    sb.append("  opened: ").append(opened).append("\n");
    sb.append("  gotMoneySuccessed: ").append(gotMoneySuccessed).append("\n");
    sb.append("  gotMoney: ").append(gotMoney).append("\n");
    sb.append("  gotNoMoneyReason: ").append(gotNoMoneyReason).append("\n");
    sb.append("  openedTime: ").append(openedTime).append("\n");
    sb.append("  createTime: ").append(createTime).append("\n");
    sb.append("  startTime: ").append(startTime).append("\n");
    sb.append("  secondStart: ").append(secondStart).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
