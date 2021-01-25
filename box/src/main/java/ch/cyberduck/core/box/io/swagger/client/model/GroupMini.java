/*
 * Box Platform API
 * [Box Platform](https://box.dev) provides functionality to provide access to content stored within [Box](https://box.com). It provides endpoints for basic manipulation of files and folders, management of users within an enterprise, as well as more complex topics such as legal holds and retention policies.
 *
 * OpenAPI spec version: 2.0.0
 * Contact: devrel@box.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.box.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import ch.cyberduck.core.box.io.swagger.client.model.GroupBase;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Mini representation of a group, including id and name of group.
 */
@Schema(description = "Mini representation of a group, including id and name of group.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-25T11:35:18.602705+01:00[Europe/Zurich]")
public class GroupMini extends GroupBase {
  @JsonProperty("name")
  private String name = null;

  /**
   * The type of the group.
   */
  public enum GroupTypeEnum {
    MANAGED_GROUP("managed_group"),
    ALL_USERS_GROUP("all_users_group");

    private String value;

    GroupTypeEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static GroupTypeEnum fromValue(String text) {
      for (GroupTypeEnum b : GroupTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("group_type")
  private GroupTypeEnum groupType = null;

  public GroupMini name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the group
   * @return name
  **/
  @Schema(example = "Support", description = "The name of the group")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GroupMini groupType(GroupTypeEnum groupType) {
    this.groupType = groupType;
    return this;
  }

   /**
   * The type of the group.
   * @return groupType
  **/
  @Schema(example = "managed_group", description = "The type of the group.")
  public GroupTypeEnum getGroupType() {
    return groupType;
  }

  public void setGroupType(GroupTypeEnum groupType) {
    this.groupType = groupType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupMini groupMini = (GroupMini) o;
    return Objects.equals(this.name, groupMini.name) &&
        Objects.equals(this.groupType, groupMini.groupType) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, groupType, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupMini {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    groupType: ").append(toIndentedString(groupType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
