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
import ch.cyberduck.core.sds.io.swagger.client.model.CharacterRules;
import ch.cyberduck.core.sds.io.swagger.client.model.PasswordExpiration;
import ch.cyberduck.core.sds.io.swagger.client.model.UserInfo;
import ch.cyberduck.core.sds.io.swagger.client.model.UserLockout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.joda.time.DateTime;
/**
 * Login password policies
 */
@Schema(description = "Login password policies")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-08-16T11:28:10.116221+02:00[Europe/Zurich]")
public class LoginPasswordPolicies {
  @JsonProperty("characterRules")
  private CharacterRules characterRules = null;

  @JsonProperty("minLength")
  private Integer minLength = null;

  @JsonProperty("rejectDictionaryWords")
  private Boolean rejectDictionaryWords = null;

  @JsonProperty("rejectUserInfo")
  private Boolean rejectUserInfo = null;

  @JsonProperty("rejectKeyboardPatterns")
  private Boolean rejectKeyboardPatterns = null;

  @JsonProperty("numberOfArchivedPasswords")
  private Integer numberOfArchivedPasswords = null;

  @JsonProperty("passwordExpiration")
  private PasswordExpiration passwordExpiration = null;

  @JsonProperty("userLockout")
  private UserLockout userLockout = null;

  @JsonProperty("updatedAt")
  private DateTime updatedAt = null;

  @JsonProperty("updatedBy")
  private UserInfo updatedBy = null;

  public LoginPasswordPolicies characterRules(CharacterRules characterRules) {
    this.characterRules = characterRules;
    return this;
  }

   /**
   * Get characterRules
   * @return characterRules
  **/
  @Schema(required = true, description = "")
  public CharacterRules getCharacterRules() {
    return characterRules;
  }

  public void setCharacterRules(CharacterRules characterRules) {
    this.characterRules = characterRules;
  }

  public LoginPasswordPolicies minLength(Integer minLength) {
    this.minLength = minLength;
    return this;
  }

   /**
   * Minimum number of characters a password must contain
   * minimum: 1
   * maximum: 1024
   * @return minLength
  **/
  @Schema(required = true, description = "Minimum number of characters a password must contain")
  public Integer getMinLength() {
    return minLength;
  }

  public void setMinLength(Integer minLength) {
    this.minLength = minLength;
  }

  public LoginPasswordPolicies rejectDictionaryWords(Boolean rejectDictionaryWords) {
    this.rejectDictionaryWords = rejectDictionaryWords;
    return this;
  }

   /**
   * Determines whether a password must NOT contain word(s) from a dictionary
   * @return rejectDictionaryWords
  **/
  @Schema(required = true, description = "Determines whether a password must NOT contain word(s) from a dictionary")
  public Boolean isRejectDictionaryWords() {
    return rejectDictionaryWords;
  }

  public void setRejectDictionaryWords(Boolean rejectDictionaryWords) {
    this.rejectDictionaryWords = rejectDictionaryWords;
  }

  public LoginPasswordPolicies rejectUserInfo(Boolean rejectUserInfo) {
    this.rejectUserInfo = rejectUserInfo;
    return this;
  }

   /**
   * Determines whether a password must NOT contain user info (first name, last name, email, user name)
   * @return rejectUserInfo
  **/
  @Schema(required = true, description = "Determines whether a password must NOT contain user info (first name, last name, email, user name)")
  public Boolean isRejectUserInfo() {
    return rejectUserInfo;
  }

  public void setRejectUserInfo(Boolean rejectUserInfo) {
    this.rejectUserInfo = rejectUserInfo;
  }

  public LoginPasswordPolicies rejectKeyboardPatterns(Boolean rejectKeyboardPatterns) {
    this.rejectKeyboardPatterns = rejectKeyboardPatterns;
    return this;
  }

   /**
   * Determines whether a password must NOT contain keyboard patterns (e.g. &#x60;qwertz&#x60;, &#x60;asdf&#x60;)  (min. 4 character pattern)
   * @return rejectKeyboardPatterns
  **/
  @Schema(required = true, description = "Determines whether a password must NOT contain keyboard patterns (e.g. `qwertz`, `asdf`)  (min. 4 character pattern)")
  public Boolean isRejectKeyboardPatterns() {
    return rejectKeyboardPatterns;
  }

  public void setRejectKeyboardPatterns(Boolean rejectKeyboardPatterns) {
    this.rejectKeyboardPatterns = rejectKeyboardPatterns;
  }

  public LoginPasswordPolicies numberOfArchivedPasswords(Integer numberOfArchivedPasswords) {
    this.numberOfArchivedPasswords = numberOfArchivedPasswords;
    return this;
  }

   /**
   * Number of passwords to archive  (must be between &#x60;0&#x60; and &#x60;10&#x60;; &#x60;0&#x60; means that password history is disabled)
   * minimum: 1
   * maximum: 10
   * @return numberOfArchivedPasswords
  **/
  @Schema(required = true, description = "Number of passwords to archive  (must be between `0` and `10`; `0` means that password history is disabled)")
  public Integer getNumberOfArchivedPasswords() {
    return numberOfArchivedPasswords;
  }

  public void setNumberOfArchivedPasswords(Integer numberOfArchivedPasswords) {
    this.numberOfArchivedPasswords = numberOfArchivedPasswords;
  }

  public LoginPasswordPolicies passwordExpiration(PasswordExpiration passwordExpiration) {
    this.passwordExpiration = passwordExpiration;
    return this;
  }

   /**
   * Get passwordExpiration
   * @return passwordExpiration
  **/
  @Schema(required = true, description = "")
  public PasswordExpiration getPasswordExpiration() {
    return passwordExpiration;
  }

  public void setPasswordExpiration(PasswordExpiration passwordExpiration) {
    this.passwordExpiration = passwordExpiration;
  }

  public LoginPasswordPolicies userLockout(UserLockout userLockout) {
    this.userLockout = userLockout;
    return this;
  }

   /**
   * Get userLockout
   * @return userLockout
  **/
  @Schema(required = true, description = "")
  public UserLockout getUserLockout() {
    return userLockout;
  }

  public void setUserLockout(UserLockout userLockout) {
    this.userLockout = userLockout;
  }

  public LoginPasswordPolicies updatedAt(DateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Modification date
   * @return updatedAt
  **/
  @Schema(required = true, description = "Modification date")
  public DateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(DateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public LoginPasswordPolicies updatedBy(UserInfo updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }

   /**
   * Get updatedBy
   * @return updatedBy
  **/
  @Schema(required = true, description = "")
  public UserInfo getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(UserInfo updatedBy) {
    this.updatedBy = updatedBy;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginPasswordPolicies loginPasswordPolicies = (LoginPasswordPolicies) o;
    return Objects.equals(this.characterRules, loginPasswordPolicies.characterRules) &&
        Objects.equals(this.minLength, loginPasswordPolicies.minLength) &&
        Objects.equals(this.rejectDictionaryWords, loginPasswordPolicies.rejectDictionaryWords) &&
        Objects.equals(this.rejectUserInfo, loginPasswordPolicies.rejectUserInfo) &&
        Objects.equals(this.rejectKeyboardPatterns, loginPasswordPolicies.rejectKeyboardPatterns) &&
        Objects.equals(this.numberOfArchivedPasswords, loginPasswordPolicies.numberOfArchivedPasswords) &&
        Objects.equals(this.passwordExpiration, loginPasswordPolicies.passwordExpiration) &&
        Objects.equals(this.userLockout, loginPasswordPolicies.userLockout) &&
        Objects.equals(this.updatedAt, loginPasswordPolicies.updatedAt) &&
        Objects.equals(this.updatedBy, loginPasswordPolicies.updatedBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(characterRules, minLength, rejectDictionaryWords, rejectUserInfo, rejectKeyboardPatterns, numberOfArchivedPasswords, passwordExpiration, userLockout, updatedAt, updatedBy);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginPasswordPolicies {\n");
    
    sb.append("    characterRules: ").append(toIndentedString(characterRules)).append("\n");
    sb.append("    minLength: ").append(toIndentedString(minLength)).append("\n");
    sb.append("    rejectDictionaryWords: ").append(toIndentedString(rejectDictionaryWords)).append("\n");
    sb.append("    rejectUserInfo: ").append(toIndentedString(rejectUserInfo)).append("\n");
    sb.append("    rejectKeyboardPatterns: ").append(toIndentedString(rejectKeyboardPatterns)).append("\n");
    sb.append("    numberOfArchivedPasswords: ").append(toIndentedString(numberOfArchivedPasswords)).append("\n");
    sb.append("    passwordExpiration: ").append(toIndentedString(passwordExpiration)).append("\n");
    sb.append("    userLockout: ").append(toIndentedString(userLockout)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
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
