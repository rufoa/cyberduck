/*
 * DRACOON API
 * REST Web Services for DRACOON<br>built at: 2020-08-05 12:38:27<br><br>This page provides an overview of all available and documented DRACOON APIs, which are grouped by tags.<br>Each tag provides a collection of APIs that are intended for a specific area of the DRACOON.<br><br><a title='Developer Information' href='https://developer.dracoon.com'>Developer Information</a>&emsp;&emsp;<a title='Get SDKs on GitHub' href='https://github.com/dracoon'>Get SDKs on GitHub</a><br><br><a title='Terms of service' href='https://www.dracoon.com/terms/general-terms-and-conditions/'>Terms of service</a>
 *
 * OpenAPI spec version: 4.24.0.crypto_upgrade-SNAPSHOT
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.sds.io.swagger.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Request model for configuring a room
 */
@Schema(description = "Request model for configuring a room")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-09-11T16:33:00.814633+02:00[Europe/Zurich]")
public class ConfigRoomRequest {
  @JsonProperty("recycleBinRetentionPeriod")
  private Integer recycleBinRetentionPeriod = null;

  @JsonProperty("inheritPermissions")
  private Boolean inheritPermissions = null;

  @JsonProperty("takeOverPermissions")
  private Boolean takeOverPermissions = null;

  @JsonProperty("adminIds")
  private List<Long> adminIds = null;

  @JsonProperty("adminGroupIds")
  private List<Long> adminGroupIds = null;

  /**
   * Behaviour when new users are added to the group:  * &#x60;autoallow&#x60;  * &#x60;pending&#x60;    Only relevant if &#x60;adminGroupIds&#x60; has items.
   */
  public enum NewGroupMemberAcceptanceEnum {
    AUTOALLOW("autoallow"),
    PENDING("pending");

    private String value;

    NewGroupMemberAcceptanceEnum(String value) {
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
    public static NewGroupMemberAcceptanceEnum fromValue(String text) {
      for (NewGroupMemberAcceptanceEnum b : NewGroupMemberAcceptanceEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("newGroupMemberAcceptance")
  private NewGroupMemberAcceptanceEnum newGroupMemberAcceptance = NewGroupMemberAcceptanceEnum.AUTOALLOW;

  @JsonProperty("hasActivitiesLog")
  private Boolean hasActivitiesLog = true;

  /**
   * Classification ID:  * &#x60;1&#x60; - public  * &#x60;2&#x60; - internal  * &#x60;3&#x60; - confidential  * &#x60;4&#x60; - strictly confidential    Provided (or default) classification is taken from room  when file gets uploaded without any classification.
   */
  public enum ClassificationEnum {
    NUMBER_1(1),
    NUMBER_2(2),
    NUMBER_3(3),
    NUMBER_4(4);

    private Integer value;

    ClassificationEnum(Integer value) {
      this.value = value;
    }
    @JsonValue
    public Integer getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static ClassificationEnum fromValue(String text) {
      for (ClassificationEnum b : ClassificationEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("classification")
  private ClassificationEnum classification = ClassificationEnum.NUMBER_2;

  @JsonProperty("hasRecycleBin")
  private Boolean hasRecycleBin = null;

  public ConfigRoomRequest recycleBinRetentionPeriod(Integer recycleBinRetentionPeriod) {
    this.recycleBinRetentionPeriod = recycleBinRetentionPeriod;
    return this;
  }

   /**
   * Retention period for deleted nodes in days
   * minimum: 0
   * maximum: 9999
   * @return recycleBinRetentionPeriod
  **/
  @Schema(description = "Retention period for deleted nodes in days")
  public Integer getRecycleBinRetentionPeriod() {
    return recycleBinRetentionPeriod;
  }

  public void setRecycleBinRetentionPeriod(Integer recycleBinRetentionPeriod) {
    this.recycleBinRetentionPeriod = recycleBinRetentionPeriod;
  }

  public ConfigRoomRequest inheritPermissions(Boolean inheritPermissions) {
    this.inheritPermissions = inheritPermissions;
    return this;
  }

   /**
   * Inherit permissions from parent room  (default: &#x60;false&#x60; if &#x60;parentId&#x60; is &#x60;0&#x60;; otherwise: &#x60;true&#x60;)
   * @return inheritPermissions
  **/
  @Schema(description = "Inherit permissions from parent room  (default: `false` if `parentId` is `0`; otherwise: `true`)")
  public Boolean isInheritPermissions() {
    return inheritPermissions;
  }

  public void setInheritPermissions(Boolean inheritPermissions) {
    this.inheritPermissions = inheritPermissions;
  }

  public ConfigRoomRequest takeOverPermissions(Boolean takeOverPermissions) {
    this.takeOverPermissions = takeOverPermissions;
    return this;
  }

   /**
   * Take over existing permissions
   * @return takeOverPermissions
  **/
  @Schema(description = "Take over existing permissions")
  public Boolean isTakeOverPermissions() {
    return takeOverPermissions;
  }

  public void setTakeOverPermissions(Boolean takeOverPermissions) {
    this.takeOverPermissions = takeOverPermissions;
  }

  public ConfigRoomRequest adminIds(List<Long> adminIds) {
    this.adminIds = adminIds;
    return this;
  }

  public ConfigRoomRequest addAdminIdsItem(Long adminIdsItem) {
    if (this.adminIds == null) {
      this.adminIds = new ArrayList<>();
    }
    this.adminIds.add(adminIdsItem);
    return this;
  }

   /**
   * List of user ids  A room requires at least one admin (user or group)
   * @return adminIds
  **/
  @Schema(description = "List of user ids  A room requires at least one admin (user or group)")
  public List<Long> getAdminIds() {
    return adminIds;
  }

  public void setAdminIds(List<Long> adminIds) {
    this.adminIds = adminIds;
  }

  public ConfigRoomRequest adminGroupIds(List<Long> adminGroupIds) {
    this.adminGroupIds = adminGroupIds;
    return this;
  }

  public ConfigRoomRequest addAdminGroupIdsItem(Long adminGroupIdsItem) {
    if (this.adminGroupIds == null) {
      this.adminGroupIds = new ArrayList<>();
    }
    this.adminGroupIds.add(adminGroupIdsItem);
    return this;
  }

   /**
   * List of group ids  A room requires at least one admin (user or group)
   * @return adminGroupIds
  **/
  @Schema(description = "List of group ids  A room requires at least one admin (user or group)")
  public List<Long> getAdminGroupIds() {
    return adminGroupIds;
  }

  public void setAdminGroupIds(List<Long> adminGroupIds) {
    this.adminGroupIds = adminGroupIds;
  }

  public ConfigRoomRequest newGroupMemberAcceptance(NewGroupMemberAcceptanceEnum newGroupMemberAcceptance) {
    this.newGroupMemberAcceptance = newGroupMemberAcceptance;
    return this;
  }

   /**
   * Behaviour when new users are added to the group:  * &#x60;autoallow&#x60;  * &#x60;pending&#x60;    Only relevant if &#x60;adminGroupIds&#x60; has items.
   * @return newGroupMemberAcceptance
  **/
  @Schema(description = "Behaviour when new users are added to the group:  * `autoallow`  * `pending`    Only relevant if `adminGroupIds` has items.")
  public NewGroupMemberAcceptanceEnum getNewGroupMemberAcceptance() {
    return newGroupMemberAcceptance;
  }

  public void setNewGroupMemberAcceptance(NewGroupMemberAcceptanceEnum newGroupMemberAcceptance) {
    this.newGroupMemberAcceptance = newGroupMemberAcceptance;
  }

  public ConfigRoomRequest hasActivitiesLog(Boolean hasActivitiesLog) {
    this.hasActivitiesLog = hasActivitiesLog;
    return this;
  }

   /**
   * Is activities log active (for rooms only)
   * @return hasActivitiesLog
  **/
  @Schema(description = "Is activities log active (for rooms only)")
  public Boolean isHasActivitiesLog() {
    return hasActivitiesLog;
  }

  public void setHasActivitiesLog(Boolean hasActivitiesLog) {
    this.hasActivitiesLog = hasActivitiesLog;
  }

  public ConfigRoomRequest classification(ClassificationEnum classification) {
    this.classification = classification;
    return this;
  }

   /**
   * Classification ID:  * &#x60;1&#x60; - public  * &#x60;2&#x60; - internal  * &#x60;3&#x60; - confidential  * &#x60;4&#x60; - strictly confidential    Provided (or default) classification is taken from room  when file gets uploaded without any classification.
   * @return classification
  **/
  @Schema(description = "Classification ID:  * `1` - public  * `2` - internal  * `3` - confidential  * `4` - strictly confidential    Provided (or default) classification is taken from room  when file gets uploaded without any classification.")
  public ClassificationEnum getClassification() {
    return classification;
  }

  public void setClassification(ClassificationEnum classification) {
    this.classification = classification;
  }

  public ConfigRoomRequest hasRecycleBin(Boolean hasRecycleBin) {
    this.hasRecycleBin = hasRecycleBin;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.10.0  Is recycle bin active (for rooms only)  Recycle bin is always on (disabling is not possible).
   * @return hasRecycleBin
  **/
  @Schema(description = "&#128679; Deprecated since v4.10.0  Is recycle bin active (for rooms only)  Recycle bin is always on (disabling is not possible).")
  public Boolean isHasRecycleBin() {
    return hasRecycleBin;
  }

  public void setHasRecycleBin(Boolean hasRecycleBin) {
    this.hasRecycleBin = hasRecycleBin;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConfigRoomRequest configRoomRequest = (ConfigRoomRequest) o;
    return Objects.equals(this.recycleBinRetentionPeriod, configRoomRequest.recycleBinRetentionPeriod) &&
        Objects.equals(this.inheritPermissions, configRoomRequest.inheritPermissions) &&
        Objects.equals(this.takeOverPermissions, configRoomRequest.takeOverPermissions) &&
        Objects.equals(this.adminIds, configRoomRequest.adminIds) &&
        Objects.equals(this.adminGroupIds, configRoomRequest.adminGroupIds) &&
        Objects.equals(this.newGroupMemberAcceptance, configRoomRequest.newGroupMemberAcceptance) &&
        Objects.equals(this.hasActivitiesLog, configRoomRequest.hasActivitiesLog) &&
        Objects.equals(this.classification, configRoomRequest.classification) &&
        Objects.equals(this.hasRecycleBin, configRoomRequest.hasRecycleBin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recycleBinRetentionPeriod, inheritPermissions, takeOverPermissions, adminIds, adminGroupIds, newGroupMemberAcceptance, hasActivitiesLog, classification, hasRecycleBin);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfigRoomRequest {\n");
    
    sb.append("    recycleBinRetentionPeriod: ").append(toIndentedString(recycleBinRetentionPeriod)).append("\n");
    sb.append("    inheritPermissions: ").append(toIndentedString(inheritPermissions)).append("\n");
    sb.append("    takeOverPermissions: ").append(toIndentedString(takeOverPermissions)).append("\n");
    sb.append("    adminIds: ").append(toIndentedString(adminIds)).append("\n");
    sb.append("    adminGroupIds: ").append(toIndentedString(adminGroupIds)).append("\n");
    sb.append("    newGroupMemberAcceptance: ").append(toIndentedString(newGroupMemberAcceptance)).append("\n");
    sb.append("    hasActivitiesLog: ").append(toIndentedString(hasActivitiesLog)).append("\n");
    sb.append("    classification: ").append(toIndentedString(classification)).append("\n");
    sb.append("    hasRecycleBin: ").append(toIndentedString(hasRecycleBin)).append("\n");
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
