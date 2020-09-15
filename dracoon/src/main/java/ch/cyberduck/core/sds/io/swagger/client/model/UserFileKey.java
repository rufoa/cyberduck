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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * User file key
 */
@Schema(description = "User file key")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-09-11T16:33:00.814633+02:00[Europe/Zurich]")
public class UserFileKey {
  @JsonProperty("userId")
  private Long userId = null;

  @JsonProperty("fileKey")
  private FileKey fileKey = null;

  public UserFileKey userId(Long userId) {
    this.userId = userId;
    return this;
  }

   /**
   * Unique identifier for the user
   * @return userId
  **/
  @Schema(required = true, description = "Unique identifier for the user")
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public UserFileKey fileKey(FileKey fileKey) {
    this.fileKey = fileKey;
    return this;
  }

   /**
   * Get fileKey
   * @return fileKey
  **/
  @Schema(required = true, description = "")
  public FileKey getFileKey() {
    return fileKey;
  }

  public void setFileKey(FileKey fileKey) {
    this.fileKey = fileKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserFileKey userFileKey = (UserFileKey) o;
    return Objects.equals(this.userId, userFileKey.userId) &&
        Objects.equals(this.fileKey, userFileKey.fileKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, fileKey);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserFileKey {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    fileKey: ").append(toIndentedString(fileKey)).append("\n");
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
