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

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Audit node report
 */
@Schema(description = "Audit node report")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-09-11T16:33:00.814633+02:00[Europe/Zurich]")
public class AuditNodeResponse {
  @JsonProperty("nodeId")
  private Long nodeId = null;

  @JsonProperty("nodeName")
  private String nodeName = null;

  @JsonProperty("nodeParentPath")
  private String nodeParentPath = null;

  @JsonProperty("nodeCntChildren")
  private Integer nodeCntChildren = null;

  @JsonProperty("auditUserPermissionList")
  private List<AuditUserPermission> auditUserPermissionList = new ArrayList<>();

  @JsonProperty("nodeParentId")
  private Long nodeParentId = null;

  @JsonProperty("nodeSize")
  private Long nodeSize = null;

  @JsonProperty("nodeRecycleBinRetentionPeriod")
  private Integer nodeRecycleBinRetentionPeriod = null;

  @JsonProperty("nodeQuota")
  private Long nodeQuota = null;

  @JsonProperty("nodeIsEncrypted")
  private Boolean nodeIsEncrypted = null;

  @JsonProperty("nodeHasActivitiesLog")
  private Boolean nodeHasActivitiesLog = true;

  @JsonProperty("nodeCreatedAt")
  private DateTime nodeCreatedAt = null;

  @JsonProperty("nodeCreatedBy")
  private UserInfo nodeCreatedBy = null;

  @JsonProperty("nodeUpdatedAt")
  private DateTime nodeUpdatedAt = null;

  @JsonProperty("nodeUpdatedBy")
  private UserInfo nodeUpdatedBy = null;

  @JsonProperty("nodeHasRecycleBin")
  private Boolean nodeHasRecycleBin = null;

  public AuditNodeResponse nodeId(Long nodeId) {
    this.nodeId = nodeId;
    return this;
  }

   /**
   * Node ID
   * @return nodeId
  **/
  @Schema(required = true, description = "Node ID")
  public Long getNodeId() {
    return nodeId;
  }

  public void setNodeId(Long nodeId) {
    this.nodeId = nodeId;
  }

  public AuditNodeResponse nodeName(String nodeName) {
    this.nodeName = nodeName;
    return this;
  }

   /**
   * Node name
   * @return nodeName
  **/
  @Schema(required = true, description = "Node name")
  public String getNodeName() {
    return nodeName;
  }

  public void setNodeName(String nodeName) {
    this.nodeName = nodeName;
  }

  public AuditNodeResponse nodeParentPath(String nodeParentPath) {
    this.nodeParentPath = nodeParentPath;
    return this;
  }

   /**
   * Parent node path  &#x60;/&#x60; if node is a root node (room)
   * @return nodeParentPath
  **/
  @Schema(required = true, description = "Parent node path  `/` if node is a root node (room)")
  public String getNodeParentPath() {
    return nodeParentPath;
  }

  public void setNodeParentPath(String nodeParentPath) {
    this.nodeParentPath = nodeParentPath;
  }

  public AuditNodeResponse nodeCntChildren(Integer nodeCntChildren) {
    this.nodeCntChildren = nodeCntChildren;
    return this;
  }

   /**
   * Number of direct children  (no recursion; for rooms / folders only)
   * @return nodeCntChildren
  **/
  @Schema(required = true, description = "Number of direct children  (no recursion; for rooms / folders only)")
  public Integer getNodeCntChildren() {
    return nodeCntChildren;
  }

  public void setNodeCntChildren(Integer nodeCntChildren) {
    this.nodeCntChildren = nodeCntChildren;
  }

  public AuditNodeResponse auditUserPermissionList(List<AuditUserPermission> auditUserPermissionList) {
    this.auditUserPermissionList = auditUserPermissionList;
    return this;
  }

  public AuditNodeResponse addAuditUserPermissionListItem(AuditUserPermission auditUserPermissionListItem) {
    this.auditUserPermissionList.add(auditUserPermissionListItem);
    return this;
  }

   /**
   * List of assigned users with permissions
   * @return auditUserPermissionList
  **/
  @Schema(required = true, description = "List of assigned users with permissions")
  public List<AuditUserPermission> getAuditUserPermissionList() {
    return auditUserPermissionList;
  }

  public void setAuditUserPermissionList(List<AuditUserPermission> auditUserPermissionList) {
    this.auditUserPermissionList = auditUserPermissionList;
  }

  public AuditNodeResponse nodeParentId(Long nodeParentId) {
    this.nodeParentId = nodeParentId;
    return this;
  }

   /**
   * Parent node ID (room or folder)
   * @return nodeParentId
  **/
  @Schema(description = "Parent node ID (room or folder)")
  public Long getNodeParentId() {
    return nodeParentId;
  }

  public void setNodeParentId(Long nodeParentId) {
    this.nodeParentId = nodeParentId;
  }

  public AuditNodeResponse nodeSize(Long nodeSize) {
    this.nodeSize = nodeSize;
    return this;
  }

   /**
   * Node size in byte
   * @return nodeSize
  **/
  @Schema(description = "Node size in byte")
  public Long getNodeSize() {
    return nodeSize;
  }

  public void setNodeSize(Long nodeSize) {
    this.nodeSize = nodeSize;
  }

  public AuditNodeResponse nodeRecycleBinRetentionPeriod(Integer nodeRecycleBinRetentionPeriod) {
    this.nodeRecycleBinRetentionPeriod = nodeRecycleBinRetentionPeriod;
    return this;
  }

   /**
   * Retention period for deleted nodes in days
   * minimum: 0
   * maximum: 9999
   * @return nodeRecycleBinRetentionPeriod
  **/
  @Schema(description = "Retention period for deleted nodes in days")
  public Integer getNodeRecycleBinRetentionPeriod() {
    return nodeRecycleBinRetentionPeriod;
  }

  public void setNodeRecycleBinRetentionPeriod(Integer nodeRecycleBinRetentionPeriod) {
    this.nodeRecycleBinRetentionPeriod = nodeRecycleBinRetentionPeriod;
  }

  public AuditNodeResponse nodeQuota(Long nodeQuota) {
    this.nodeQuota = nodeQuota;
    return this;
  }

   /**
   * Quota in byte
   * @return nodeQuota
  **/
  @Schema(description = "Quota in byte")
  public Long getNodeQuota() {
    return nodeQuota;
  }

  public void setNodeQuota(Long nodeQuota) {
    this.nodeQuota = nodeQuota;
  }

  public AuditNodeResponse nodeIsEncrypted(Boolean nodeIsEncrypted) {
    this.nodeIsEncrypted = nodeIsEncrypted;
    return this;
  }

   /**
   * Encryption state
   * @return nodeIsEncrypted
  **/
  @Schema(description = "Encryption state")
  public Boolean isNodeIsEncrypted() {
    return nodeIsEncrypted;
  }

  public void setNodeIsEncrypted(Boolean nodeIsEncrypted) {
    this.nodeIsEncrypted = nodeIsEncrypted;
  }

  public AuditNodeResponse nodeHasActivitiesLog(Boolean nodeHasActivitiesLog) {
    this.nodeHasActivitiesLog = nodeHasActivitiesLog;
    return this;
  }

   /**
   * Is activities log active (for rooms only)
   * @return nodeHasActivitiesLog
  **/
  @Schema(description = "Is activities log active (for rooms only)")
  public Boolean isNodeHasActivitiesLog() {
    return nodeHasActivitiesLog;
  }

  public void setNodeHasActivitiesLog(Boolean nodeHasActivitiesLog) {
    this.nodeHasActivitiesLog = nodeHasActivitiesLog;
  }

  public AuditNodeResponse nodeCreatedAt(DateTime nodeCreatedAt) {
    this.nodeCreatedAt = nodeCreatedAt;
    return this;
  }

   /**
   * Creation date
   * @return nodeCreatedAt
  **/
  @Schema(description = "Creation date")
  public DateTime getNodeCreatedAt() {
    return nodeCreatedAt;
  }

  public void setNodeCreatedAt(DateTime nodeCreatedAt) {
    this.nodeCreatedAt = nodeCreatedAt;
  }

  public AuditNodeResponse nodeCreatedBy(UserInfo nodeCreatedBy) {
    this.nodeCreatedBy = nodeCreatedBy;
    return this;
  }

   /**
   * Get nodeCreatedBy
   * @return nodeCreatedBy
  **/
  @Schema(description = "")
  public UserInfo getNodeCreatedBy() {
    return nodeCreatedBy;
  }

  public void setNodeCreatedBy(UserInfo nodeCreatedBy) {
    this.nodeCreatedBy = nodeCreatedBy;
  }

  public AuditNodeResponse nodeUpdatedAt(DateTime nodeUpdatedAt) {
    this.nodeUpdatedAt = nodeUpdatedAt;
    return this;
  }

   /**
   * Modification date
   * @return nodeUpdatedAt
  **/
  @Schema(description = "Modification date")
  public DateTime getNodeUpdatedAt() {
    return nodeUpdatedAt;
  }

  public void setNodeUpdatedAt(DateTime nodeUpdatedAt) {
    this.nodeUpdatedAt = nodeUpdatedAt;
  }

  public AuditNodeResponse nodeUpdatedBy(UserInfo nodeUpdatedBy) {
    this.nodeUpdatedBy = nodeUpdatedBy;
    return this;
  }

   /**
   * Get nodeUpdatedBy
   * @return nodeUpdatedBy
  **/
  @Schema(description = "")
  public UserInfo getNodeUpdatedBy() {
    return nodeUpdatedBy;
  }

  public void setNodeUpdatedBy(UserInfo nodeUpdatedBy) {
    this.nodeUpdatedBy = nodeUpdatedBy;
  }

  public AuditNodeResponse nodeHasRecycleBin(Boolean nodeHasRecycleBin) {
    this.nodeHasRecycleBin = nodeHasRecycleBin;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.10.0  Is recycle bin active (for rooms only)  Recycle bin is always on (disabling is not possible).
   * @return nodeHasRecycleBin
  **/
  @Schema(description = "&#128679; Deprecated since v4.10.0  Is recycle bin active (for rooms only)  Recycle bin is always on (disabling is not possible).")
  public Boolean isNodeHasRecycleBin() {
    return nodeHasRecycleBin;
  }

  public void setNodeHasRecycleBin(Boolean nodeHasRecycleBin) {
    this.nodeHasRecycleBin = nodeHasRecycleBin;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuditNodeResponse auditNodeResponse = (AuditNodeResponse) o;
    return Objects.equals(this.nodeId, auditNodeResponse.nodeId) &&
        Objects.equals(this.nodeName, auditNodeResponse.nodeName) &&
        Objects.equals(this.nodeParentPath, auditNodeResponse.nodeParentPath) &&
        Objects.equals(this.nodeCntChildren, auditNodeResponse.nodeCntChildren) &&
        Objects.equals(this.auditUserPermissionList, auditNodeResponse.auditUserPermissionList) &&
        Objects.equals(this.nodeParentId, auditNodeResponse.nodeParentId) &&
        Objects.equals(this.nodeSize, auditNodeResponse.nodeSize) &&
        Objects.equals(this.nodeRecycleBinRetentionPeriod, auditNodeResponse.nodeRecycleBinRetentionPeriod) &&
        Objects.equals(this.nodeQuota, auditNodeResponse.nodeQuota) &&
        Objects.equals(this.nodeIsEncrypted, auditNodeResponse.nodeIsEncrypted) &&
        Objects.equals(this.nodeHasActivitiesLog, auditNodeResponse.nodeHasActivitiesLog) &&
        Objects.equals(this.nodeCreatedAt, auditNodeResponse.nodeCreatedAt) &&
        Objects.equals(this.nodeCreatedBy, auditNodeResponse.nodeCreatedBy) &&
        Objects.equals(this.nodeUpdatedAt, auditNodeResponse.nodeUpdatedAt) &&
        Objects.equals(this.nodeUpdatedBy, auditNodeResponse.nodeUpdatedBy) &&
        Objects.equals(this.nodeHasRecycleBin, auditNodeResponse.nodeHasRecycleBin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodeId, nodeName, nodeParentPath, nodeCntChildren, auditUserPermissionList, nodeParentId, nodeSize, nodeRecycleBinRetentionPeriod, nodeQuota, nodeIsEncrypted, nodeHasActivitiesLog, nodeCreatedAt, nodeCreatedBy, nodeUpdatedAt, nodeUpdatedBy, nodeHasRecycleBin);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuditNodeResponse {\n");
    
    sb.append("    nodeId: ").append(toIndentedString(nodeId)).append("\n");
    sb.append("    nodeName: ").append(toIndentedString(nodeName)).append("\n");
    sb.append("    nodeParentPath: ").append(toIndentedString(nodeParentPath)).append("\n");
    sb.append("    nodeCntChildren: ").append(toIndentedString(nodeCntChildren)).append("\n");
    sb.append("    auditUserPermissionList: ").append(toIndentedString(auditUserPermissionList)).append("\n");
    sb.append("    nodeParentId: ").append(toIndentedString(nodeParentId)).append("\n");
    sb.append("    nodeSize: ").append(toIndentedString(nodeSize)).append("\n");
    sb.append("    nodeRecycleBinRetentionPeriod: ").append(toIndentedString(nodeRecycleBinRetentionPeriod)).append("\n");
    sb.append("    nodeQuota: ").append(toIndentedString(nodeQuota)).append("\n");
    sb.append("    nodeIsEncrypted: ").append(toIndentedString(nodeIsEncrypted)).append("\n");
    sb.append("    nodeHasActivitiesLog: ").append(toIndentedString(nodeHasActivitiesLog)).append("\n");
    sb.append("    nodeCreatedAt: ").append(toIndentedString(nodeCreatedAt)).append("\n");
    sb.append("    nodeCreatedBy: ").append(toIndentedString(nodeCreatedBy)).append("\n");
    sb.append("    nodeUpdatedAt: ").append(toIndentedString(nodeUpdatedAt)).append("\n");
    sb.append("    nodeUpdatedBy: ").append(toIndentedString(nodeUpdatedBy)).append("\n");
    sb.append("    nodeHasRecycleBin: ").append(toIndentedString(nodeHasRecycleBin)).append("\n");
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
