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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.joda.time.DateTime;
/**
 * Membership is used to signify that a user is part of a group.
 */
@Schema(description = "Membership is used to signify that a user is part of a group.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-25T11:35:18.602705+01:00[Europe/Zurich]")
public class GroupMembership {
  @JsonProperty("id")
  private String id = null;

  /**
   * &#x60;group_membership&#x60;
   */
  public enum TypeEnum {
    MEMBERSHIP("group_membership");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("user")
  private AllOfGroupMembershipUser user = null;

  @JsonProperty("group")
  private AllOfGroupMembershipGroup group = null;

  /**
   * The role of the user in the group.
   */
  public enum RoleEnum {
    MEMBER("member"),
    ADMIN("admin");

    private String value;

    RoleEnum(String value) {
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
    public static RoleEnum fromValue(String text) {
      for (RoleEnum b : RoleEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("role")
  private RoleEnum role = null;

  @JsonProperty("created_at")
  private DateTime createdAt = null;

  @JsonProperty("modified_at")
  private DateTime modifiedAt = null;

  public GroupMembership id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The unique identifier for this group membership
   * @return id
  **/
  @Schema(example = "11446498", description = "The unique identifier for this group membership")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GroupMembership type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * &#x60;group_membership&#x60;
   * @return type
  **/
  @Schema(example = "group_membership", description = "`group_membership`")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public GroupMembership user(AllOfGroupMembershipUser user) {
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @Schema(description = "")
  public AllOfGroupMembershipUser getUser() {
    return user;
  }

  public void setUser(AllOfGroupMembershipUser user) {
    this.user = user;
  }

  public GroupMembership group(AllOfGroupMembershipGroup group) {
    this.group = group;
    return this;
  }

   /**
   * Get group
   * @return group
  **/
  @Schema(description = "")
  public AllOfGroupMembershipGroup getGroup() {
    return group;
  }

  public void setGroup(AllOfGroupMembershipGroup group) {
    this.group = group;
  }

  public GroupMembership role(RoleEnum role) {
    this.role = role;
    return this;
  }

   /**
   * The role of the user in the group.
   * @return role
  **/
  @Schema(example = "member", description = "The role of the user in the group.")
  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  public GroupMembership createdAt(DateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * The time this membership was created.
   * @return createdAt
  **/
  @Schema(example = "2012-12-12T10:53:43-08:00", description = "The time this membership was created.")
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateTime createdAt) {
    this.createdAt = createdAt;
  }

  public GroupMembership modifiedAt(DateTime modifiedAt) {
    this.modifiedAt = modifiedAt;
    return this;
  }

   /**
   * The time this membership was last modified.
   * @return modifiedAt
  **/
  @Schema(example = "2012-12-12T10:53:43-08:00", description = "The time this membership was last modified.")
  public DateTime getModifiedAt() {
    return modifiedAt;
  }

  public void setModifiedAt(DateTime modifiedAt) {
    this.modifiedAt = modifiedAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupMembership groupMembership = (GroupMembership) o;
    return Objects.equals(this.id, groupMembership.id) &&
        Objects.equals(this.type, groupMembership.type) &&
        Objects.equals(this.user, groupMembership.user) &&
        Objects.equals(this.group, groupMembership.group) &&
        Objects.equals(this.role, groupMembership.role) &&
        Objects.equals(this.createdAt, groupMembership.createdAt) &&
        Objects.equals(this.modifiedAt, groupMembership.modifiedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, user, group, role, createdAt, modifiedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupMembership {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
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
