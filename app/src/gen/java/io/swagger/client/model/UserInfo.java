package io.swagger.client.model;

import io.swagger.client.model.PersonInfo;
import io.swagger.client.model.RelationInfo;
import java.io.Serializable;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


/**
 * web\u7AEF\u83B7\u53D6\u7528\u6237\u4FE1\u606F\u7684\u5B9E\u4F53\u5BF9\u8C61
 **/
@ApiModel(description = "web\u7AEF\u83B7\u53D6\u7528\u6237\u4FE1\u606F\u7684\u5B9E\u4F53\u5BF9\u8C61")
public class UserInfo  implements Serializable{
  
  @SerializedName("person")
  private PersonInfo person = null;
  @SerializedName("relation")
  private RelationInfo relation = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public PersonInfo getPerson() {
    return person;
  }
  public void setPerson(PersonInfo person) {
    this.person = person;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public RelationInfo getRelation() {
    return relation;
  }
  public void setRelation(RelationInfo relation) {
    this.relation = relation;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserInfo userInfo = (UserInfo) o;
    return (person == null ? userInfo.person == null : person.equals(userInfo.person)) &&
        (relation == null ? userInfo.relation == null : relation.equals(userInfo.relation));
  }

  @Override 
  public int hashCode() {
    int result = 17;
    result = 31 * result + (person == null ? 0: person.hashCode());
    result = 31 * result + (relation == null ? 0: relation.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserInfo {\n");
    
    sb.append("  person: ").append(person).append("\n");
    sb.append("  relation: ").append(relation).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
