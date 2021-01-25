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
/**
 * A single of files, folder or web link that matched the search query, including the additional information about the shared link through which the item has been shared with the user.  This response format is only returned when the &#x60;include_recent_shared_links&#x60; query parameter has been set to &#x60;true&#x60;.
 */
@Schema(description = "A single of files, folder or web link that matched the search query, including the additional information about the shared link through which the item has been shared with the user.  This response format is only returned when the `include_recent_shared_links` query parameter has been set to `true`.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-25T11:35:18.602705+01:00[Europe/Zurich]")
public class SearchResultWithSharedLink {
  @JsonProperty("accessible_via_shared_link")
  private Object accessibleViaSharedLink = null;

  @JsonProperty("item")
  private AllOfSearchResultWithSharedLinkItem item = null;

  @JsonProperty("type")
  private Object type = null;

  public SearchResultWithSharedLink accessibleViaSharedLink(Object accessibleViaSharedLink) {
    this.accessibleViaSharedLink = accessibleViaSharedLink;
    return this;
  }

   /**
   * The optional shared link through which the user has access to this item. This value is only returned for items for which the user has recently accessed the file through a shared link. For all other items this value will return &#x60;null&#x60;.
   * @return accessibleViaSharedLink
  **/
  @Schema(example = "https://www.box.com/s/vspke7y05sb214wjokpk", description = "The optional shared link through which the user has access to this item. This value is only returned for items for which the user has recently accessed the file through a shared link. For all other items this value will return `null`.")
  public Object getAccessibleViaSharedLink() {
    return accessibleViaSharedLink;
  }

  public void setAccessibleViaSharedLink(Object accessibleViaSharedLink) {
    this.accessibleViaSharedLink = accessibleViaSharedLink;
  }

  public SearchResultWithSharedLink item(AllOfSearchResultWithSharedLinkItem item) {
    this.item = item;
    return this;
  }

   /**
   * Get item
   * @return item
  **/
  @Schema(description = "")
  public AllOfSearchResultWithSharedLinkItem getItem() {
    return item;
  }

  public void setItem(AllOfSearchResultWithSharedLinkItem item) {
    this.item = item;
  }

  public SearchResultWithSharedLink type(Object type) {
    this.type = type;
    return this;
  }

   /**
   * The result type. The value is always &#x60;search_result&#x60;.
   * @return type
  **/
  @Schema(example = "search_result", description = "The result type. The value is always `search_result`.")
  public Object getType() {
    return type;
  }

  public void setType(Object type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchResultWithSharedLink searchResultWithSharedLink = (SearchResultWithSharedLink) o;
    return Objects.equals(this.accessibleViaSharedLink, searchResultWithSharedLink.accessibleViaSharedLink) &&
        Objects.equals(this.item, searchResultWithSharedLink.item) &&
        Objects.equals(this.type, searchResultWithSharedLink.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessibleViaSharedLink, item, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchResultWithSharedLink {\n");
    
    sb.append("    accessibleViaSharedLink: ").append(toIndentedString(accessibleViaSharedLink)).append("\n");
    sb.append("    item: ").append(toIndentedString(item)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
