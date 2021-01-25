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
 * A retention policy blocks permanent deletion of content for a specified amount of time. Admins can apply policies to specified folders, or an entire enterprise. A file version retention is a  record for a retained file version. To use this feature, you must  have the manage retention policies scope enabled for your API key via  your application management console. For more information about retention policies, please visit our help documentation
 */
@Schema(description = "A retention policy blocks permanent deletion of content for a specified amount of time. Admins can apply policies to specified folders, or an entire enterprise. A file version retention is a  record for a retained file version. To use this feature, you must  have the manage retention policies scope enabled for your API key via  your application management console. For more information about retention policies, please visit our help documentation")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-25T11:35:18.602705+01:00[Europe/Zurich]")
public class FileVersionRetention {
  @JsonProperty("id")
  private String id = null;

  /**
   * &#x60;file_version_retention&#x60;
   */
  public enum TypeEnum {
    RETENTION("file_version_retention");

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

  @JsonProperty("file_version")
  private AllOfFileVersionRetentionFileVersion fileVersion = null;

  @JsonProperty("file")
  private AllOfFileVersionRetentionFile file = null;

  @JsonProperty("applied_at")
  private DateTime appliedAt = null;

  @JsonProperty("disposition_at")
  private DateTime dispositionAt = null;

  @JsonProperty("winning_retention_policy")
  private AllOfFileVersionRetentionWinningRetentionPolicy winningRetentionPolicy = null;

  public FileVersionRetention id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The unique identifier for this file version retention.
   * @return id
  **/
  @Schema(example = "11446498", description = "The unique identifier for this file version retention.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public FileVersionRetention type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * &#x60;file_version_retention&#x60;
   * @return type
  **/
  @Schema(example = "file_version_retention", description = "`file_version_retention`")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public FileVersionRetention fileVersion(AllOfFileVersionRetentionFileVersion fileVersion) {
    this.fileVersion = fileVersion;
    return this;
  }

   /**
   * Get fileVersion
   * @return fileVersion
  **/
  @Schema(description = "")
  public AllOfFileVersionRetentionFileVersion getFileVersion() {
    return fileVersion;
  }

  public void setFileVersion(AllOfFileVersionRetentionFileVersion fileVersion) {
    this.fileVersion = fileVersion;
  }

  public FileVersionRetention file(AllOfFileVersionRetentionFile file) {
    this.file = file;
    return this;
  }

   /**
   * Get file
   * @return file
  **/
  @Schema(description = "")
  public AllOfFileVersionRetentionFile getFile() {
    return file;
  }

  public void setFile(AllOfFileVersionRetentionFile file) {
    this.file = file;
  }

  public FileVersionRetention appliedAt(DateTime appliedAt) {
    this.appliedAt = appliedAt;
    return this;
  }

   /**
   * When this file version retention object was created
   * @return appliedAt
  **/
  @Schema(example = "2012-12-12T10:53:43-08:00", description = "When this file version retention object was created")
  public DateTime getAppliedAt() {
    return appliedAt;
  }

  public void setAppliedAt(DateTime appliedAt) {
    this.appliedAt = appliedAt;
  }

  public FileVersionRetention dispositionAt(DateTime dispositionAt) {
    this.dispositionAt = dispositionAt;
    return this;
  }

   /**
   * When the retention expires on this file version retention
   * @return dispositionAt
  **/
  @Schema(example = "2012-12-12T10:53:43-08:00", description = "When the retention expires on this file version retention")
  public DateTime getDispositionAt() {
    return dispositionAt;
  }

  public void setDispositionAt(DateTime dispositionAt) {
    this.dispositionAt = dispositionAt;
  }

  public FileVersionRetention winningRetentionPolicy(AllOfFileVersionRetentionWinningRetentionPolicy winningRetentionPolicy) {
    this.winningRetentionPolicy = winningRetentionPolicy;
    return this;
  }

   /**
   * Get winningRetentionPolicy
   * @return winningRetentionPolicy
  **/
  @Schema(description = "")
  public AllOfFileVersionRetentionWinningRetentionPolicy getWinningRetentionPolicy() {
    return winningRetentionPolicy;
  }

  public void setWinningRetentionPolicy(AllOfFileVersionRetentionWinningRetentionPolicy winningRetentionPolicy) {
    this.winningRetentionPolicy = winningRetentionPolicy;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileVersionRetention fileVersionRetention = (FileVersionRetention) o;
    return Objects.equals(this.id, fileVersionRetention.id) &&
        Objects.equals(this.type, fileVersionRetention.type) &&
        Objects.equals(this.fileVersion, fileVersionRetention.fileVersion) &&
        Objects.equals(this.file, fileVersionRetention.file) &&
        Objects.equals(this.appliedAt, fileVersionRetention.appliedAt) &&
        Objects.equals(this.dispositionAt, fileVersionRetention.dispositionAt) &&
        Objects.equals(this.winningRetentionPolicy, fileVersionRetention.winningRetentionPolicy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, fileVersion, file, appliedAt, dispositionAt, winningRetentionPolicy);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileVersionRetention {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    fileVersion: ").append(toIndentedString(fileVersion)).append("\n");
    sb.append("    file: ").append(toIndentedString(file)).append("\n");
    sb.append("    appliedAt: ").append(toIndentedString(appliedAt)).append("\n");
    sb.append("    dispositionAt: ").append(toIndentedString(dispositionAt)).append("\n");
    sb.append("    winningRetentionPolicy: ").append(toIndentedString(winningRetentionPolicy)).append("\n");
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
