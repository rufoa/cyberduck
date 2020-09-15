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
 * Chunk upload response
 */
@Schema(description = "Chunk upload response")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-09-11T16:33:00.814633+02:00[Europe/Zurich]")
public class ChunkUploadResponse implements OneOfinlineResponse406 {
  @JsonProperty("size")
  private Long size = null;

  @JsonProperty("hash")
  private String hash = null;

  public ChunkUploadResponse size(Long size) {
    this.size = size;
    return this;
  }

   /**
   * Chunk size
   * @return size
  **/
  @Schema(required = true, description = "Chunk size")
  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  public ChunkUploadResponse hash(String hash) {
    this.hash = hash;
    return this;
  }

   /**
   * Hash value of transferred chunk
   * @return hash
  **/
  @Schema(required = true, description = "Hash value of transferred chunk")
  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChunkUploadResponse chunkUploadResponse = (ChunkUploadResponse) o;
    return Objects.equals(this.size, chunkUploadResponse.size) &&
        Objects.equals(this.hash, chunkUploadResponse.hash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(size, hash);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChunkUploadResponse {\n");
    
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
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
