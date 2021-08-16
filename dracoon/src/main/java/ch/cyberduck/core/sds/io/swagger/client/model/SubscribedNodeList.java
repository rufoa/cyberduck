/*
 * DRACOON API
 * REST Web Services for DRACOON<br><br>This page provides an overview of all available and documented DRACOON APIs, which are grouped by tags.<br>Each tag provides a collection of APIs that are intended for a specific area of the DRACOON.<br><br><a title='Developer Information' href='https://developer.dracoon.com'>Developer Information</a>&emsp;&emsp;<a title='Get SDKs on GitHub' href='https://github.com/dracoon'>Get SDKs on GitHub</a><br><br><a title='Terms of service' href='https://www.dracoon.com/terms/general-terms-and-conditions/'>Terms of service</a>
 *
 * OpenAPI spec version: 4.30.0-beta.4
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.sds.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import ch.cyberduck.core.sds.io.swagger.client.model.Range;
import ch.cyberduck.core.sds.io.swagger.client.model.SubscribedNode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * List of subscribed nodes
 */
@Schema(description = "List of subscribed nodes")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-08-16T11:28:10.116221+02:00[Europe/Zurich]")
public class SubscribedNodeList {
  @JsonProperty("range")
  private Range range = null;

  @JsonProperty("items")
  private List<SubscribedNode> items = new ArrayList<>();

  public SubscribedNodeList range(Range range) {
    this.range = range;
    return this;
  }

   /**
   * Get range
   * @return range
  **/
  @Schema(required = true, description = "")
  public Range getRange() {
    return range;
  }

  public void setRange(Range range) {
    this.range = range;
  }

  public SubscribedNodeList items(List<SubscribedNode> items) {
    this.items = items;
    return this;
  }

  public SubscribedNodeList addItemsItem(SubscribedNode itemsItem) {
    this.items.add(itemsItem);
    return this;
  }

   /**
   * List of subscribed nodes
   * @return items
  **/
  @Schema(required = true, description = "List of subscribed nodes")
  public List<SubscribedNode> getItems() {
    return items;
  }

  public void setItems(List<SubscribedNode> items) {
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
    SubscribedNodeList subscribedNodeList = (SubscribedNodeList) o;
    return Objects.equals(this.range, subscribedNodeList.range) &&
        Objects.equals(this.items, subscribedNodeList.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(range, items);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscribedNodeList {\n");
    
    sb.append("    range: ").append(toIndentedString(range)).append("\n");
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
