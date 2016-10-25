package io.swagger.client.model;

import io.swagger.client.model.NameValue;
import java.util.*;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class GradeDes  implements Serializable{
  
  @SerializedName("grade")
  private Integer grade = null;
  @SerializedName("gradeAlias")
  private String gradeAlias = null;
  @SerializedName("des")
  private List<NameValue> des = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getGrade() {
    return grade;
  }
  public void setGrade(Integer grade) {
    this.grade = grade;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getGradeAlias() {
    return gradeAlias;
  }
  public void setGradeAlias(String gradeAlias) {
    this.gradeAlias = gradeAlias;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public List<NameValue> getDes() {
    return des;
  }
  public void setDes(List<NameValue> des) {
    this.des = des;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GradeDes gradeDes = (GradeDes) o;
    return (grade == null ? gradeDes.grade == null : grade.equals(gradeDes.grade)) &&
        (gradeAlias == null ? gradeDes.gradeAlias == null : gradeAlias.equals(gradeDes.gradeAlias)) &&
        (des == null ? gradeDes.des == null : des.equals(gradeDes.des));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (grade == null ? 0: grade.hashCode());
    result = 31 * result + (gradeAlias == null ? 0: gradeAlias.hashCode());
    result = 31 * result + (des == null ? 0: des.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class GradeDes {\n");
    
    sb.append("  grade: ").append(grade).append("\n");
    sb.append("  gradeAlias: ").append(gradeAlias).append("\n");
    sb.append("  des: ").append(des).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
