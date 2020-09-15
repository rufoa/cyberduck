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

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * List of OpenID Connect providers
 */
@Schema(description = "List of OpenID Connect providers")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-09-11T16:33:00.814633+02:00[Europe/Zurich]")
public class OpenIdAuthInfo {
  @JsonProperty("items")
  private List<OpenIdProvider> items = new ArrayList<>();

  public OpenIdAuthInfo items(List<OpenIdProvider> items) {
    this.items = items;
    return this;
  }

  public OpenIdAuthInfo addItemsItem(OpenIdProvider itemsItem) {
    this.items.add(itemsItem);
    return this;
  }

   /**
   * List of available OpenID Connect identity providers
   * @return items
  **/
  @Schema(required = true, description = "List of available OpenID Connect identity providers")
  public List<OpenIdProvider> getItems() {
    return items;
  }

  public void setItems(List<OpenIdProvider> items) {
    this.items = items;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OpenIdAuthInfo openIdAuthInfo = (OpenIdAuthInfo) o;
    return Objects.equals(this.items, openIdAuthInfo.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OpenIdAuthInfo {\n");
    
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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
