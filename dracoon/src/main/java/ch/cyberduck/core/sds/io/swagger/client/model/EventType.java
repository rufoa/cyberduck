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
 * Event type information
 */
@Schema(description = "Event type information")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-09-11T16:33:00.814633+02:00[Europe/Zurich]")
public class EventType {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("usableTenantWebhook")
  private Boolean usableTenantWebhook = null;

  @JsonProperty("usableCustomerAdminWebhook")
  private Boolean usableCustomerAdminWebhook = null;

  @JsonProperty("usableNodeWebhook")
  private Boolean usableNodeWebhook = null;

  @JsonProperty("usablePushNotification")
  private Boolean usablePushNotification = null;

  public EventType id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * ID
   * @return id
  **/
  @Schema(required = true, description = "ID")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public EventType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name
   * @return name
  **/
  @Schema(required = true, description = "Name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public EventType usableTenantWebhook(Boolean usableTenantWebhook) {
    this.usableTenantWebhook = usableTenantWebhook;
    return this;
  }

   /**
   * Usable as tenant webhook
   * @return usableTenantWebhook
  **/
  @Schema(required = true, description = "Usable as tenant webhook")
  public Boolean isUsableTenantWebhook() {
    return usableTenantWebhook;
  }

  public void setUsableTenantWebhook(Boolean usableTenantWebhook) {
    this.usableTenantWebhook = usableTenantWebhook;
  }

  public EventType usableCustomerAdminWebhook(Boolean usableCustomerAdminWebhook) {
    this.usableCustomerAdminWebhook = usableCustomerAdminWebhook;
    return this;
  }

   /**
   * Usable as customer admin webhook
   * @return usableCustomerAdminWebhook
  **/
  @Schema(required = true, description = "Usable as customer admin webhook")
  public Boolean isUsableCustomerAdminWebhook() {
    return usableCustomerAdminWebhook;
  }

  public void setUsableCustomerAdminWebhook(Boolean usableCustomerAdminWebhook) {
    this.usableCustomerAdminWebhook = usableCustomerAdminWebhook;
  }

  public EventType usableNodeWebhook(Boolean usableNodeWebhook) {
    this.usableNodeWebhook = usableNodeWebhook;
    return this;
  }

   /**
   * Usable as node webhook
   * @return usableNodeWebhook
  **/
  @Schema(required = true, description = "Usable as node webhook")
  public Boolean isUsableNodeWebhook() {
    return usableNodeWebhook;
  }

  public void setUsableNodeWebhook(Boolean usableNodeWebhook) {
    this.usableNodeWebhook = usableNodeWebhook;
  }

  public EventType usablePushNotification(Boolean usablePushNotification) {
    this.usablePushNotification = usablePushNotification;
    return this;
  }

   /**
   * Usable as push notification
   * @return usablePushNotification
  **/
  @Schema(required = true, description = "Usable as push notification")
  public Boolean isUsablePushNotification() {
    return usablePushNotification;
  }

  public void setUsablePushNotification(Boolean usablePushNotification) {
    this.usablePushNotification = usablePushNotification;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventType eventType = (EventType) o;
    return Objects.equals(this.id, eventType.id) &&
        Objects.equals(this.name, eventType.name) &&
        Objects.equals(this.usableTenantWebhook, eventType.usableTenantWebhook) &&
        Objects.equals(this.usableCustomerAdminWebhook, eventType.usableCustomerAdminWebhook) &&
        Objects.equals(this.usableNodeWebhook, eventType.usableNodeWebhook) &&
        Objects.equals(this.usablePushNotification, eventType.usablePushNotification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, usableTenantWebhook, usableCustomerAdminWebhook, usableNodeWebhook, usablePushNotification);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    usableTenantWebhook: ").append(toIndentedString(usableTenantWebhook)).append("\n");
    sb.append("    usableCustomerAdminWebhook: ").append(toIndentedString(usableCustomerAdminWebhook)).append("\n");
    sb.append("    usableNodeWebhook: ").append(toIndentedString(usableNodeWebhook)).append("\n");
    sb.append("    usablePushNotification: ").append(toIndentedString(usablePushNotification)).append("\n");
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
