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
 * Request model for updating login password policies
 */
@Schema(description = "Request model for updating login password policies")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-09-11T16:33:00.814633+02:00[Europe/Zurich]")
public class UpdateLoginPasswordPolicies {
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

  @JsonProperty("enforceLoginPasswordChange")
  private Boolean enforceLoginPasswordChange = false;

  public UpdateLoginPasswordPolicies characterRules(CharacterRules characterRules) {
    this.characterRules = characterRules;
    return this;
  }

   /**
   * Get characterRules
   * @return characterRules
  **/
  @Schema(description = "")
  public CharacterRules getCharacterRules() {
    return characterRules;
  }

  public void setCharacterRules(CharacterRules characterRules) {
    this.characterRules = characterRules;
  }

  public UpdateLoginPasswordPolicies minLength(Integer minLength) {
    this.minLength = minLength;
    return this;
  }

   /**
   * Minimum number of characters a password must contain
   * minimum: 1
   * maximum: 1024
   * @return minLength
  **/
  @Schema(description = "Minimum number of characters a password must contain")
  public Integer getMinLength() {
    return minLength;
  }

  public void setMinLength(Integer minLength) {
    this.minLength = minLength;
  }

  public UpdateLoginPasswordPolicies rejectDictionaryWords(Boolean rejectDictionaryWords) {
    this.rejectDictionaryWords = rejectDictionaryWords;
    return this;
  }

   /**
   * Determines whether a password must NOT contain word(s) from a dictionary
   * @return rejectDictionaryWords
  **/
  @Schema(description = "Determines whether a password must NOT contain word(s) from a dictionary")
  public Boolean isRejectDictionaryWords() {
    return rejectDictionaryWords;
  }

  public void setRejectDictionaryWords(Boolean rejectDictionaryWords) {
    this.rejectDictionaryWords = rejectDictionaryWords;
  }

  public UpdateLoginPasswordPolicies rejectUserInfo(Boolean rejectUserInfo) {
    this.rejectUserInfo = rejectUserInfo;
    return this;
  }

   /**
   * Determines whether a password must NOT contain user info (first name, last name, email, user name)
   * @return rejectUserInfo
  **/
  @Schema(description = "Determines whether a password must NOT contain user info (first name, last name, email, user name)")
  public Boolean isRejectUserInfo() {
    return rejectUserInfo;
  }

  public void setRejectUserInfo(Boolean rejectUserInfo) {
    this.rejectUserInfo = rejectUserInfo;
  }

  public UpdateLoginPasswordPolicies rejectKeyboardPatterns(Boolean rejectKeyboardPatterns) {
    this.rejectKeyboardPatterns = rejectKeyboardPatterns;
    return this;
  }

   /**
   * Determines whether a password must NOT contain keyboard patterns (e.g. &#x60;qwertz&#x60;, &#x60;asdf&#x60;)  (min. 4 character pattern)
   * @return rejectKeyboardPatterns
  **/
  @Schema(description = "Determines whether a password must NOT contain keyboard patterns (e.g. `qwertz`, `asdf`)  (min. 4 character pattern)")
  public Boolean isRejectKeyboardPatterns() {
    return rejectKeyboardPatterns;
  }

  public void setRejectKeyboardPatterns(Boolean rejectKeyboardPatterns) {
    this.rejectKeyboardPatterns = rejectKeyboardPatterns;
  }

  public UpdateLoginPasswordPolicies numberOfArchivedPasswords(Integer numberOfArchivedPasswords) {
    this.numberOfArchivedPasswords = numberOfArchivedPasswords;
    return this;
  }

   /**
   * Number of passwords to archive  (must be between &#x60;0&#x60; and &#x60;10&#x60;; &#x60;0&#x60; means that password history is disabled)
   * minimum: 1
   * maximum: 10
   * @return numberOfArchivedPasswords
  **/
  @Schema(description = "Number of passwords to archive  (must be between `0` and `10`; `0` means that password history is disabled)")
  public Integer getNumberOfArchivedPasswords() {
    return numberOfArchivedPasswords;
  }

  public void setNumberOfArchivedPasswords(Integer numberOfArchivedPasswords) {
    this.numberOfArchivedPasswords = numberOfArchivedPasswords;
  }

  public UpdateLoginPasswordPolicies passwordExpiration(PasswordExpiration passwordExpiration) {
    this.passwordExpiration = passwordExpiration;
    return this;
  }

   /**
   * Get passwordExpiration
   * @return passwordExpiration
  **/
  @Schema(description = "")
  public PasswordExpiration getPasswordExpiration() {
    return passwordExpiration;
  }

  public void setPasswordExpiration(PasswordExpiration passwordExpiration) {
    this.passwordExpiration = passwordExpiration;
  }

  public UpdateLoginPasswordPolicies userLockout(UserLockout userLockout) {
    this.userLockout = userLockout;
    return this;
  }

   /**
   * Get userLockout
   * @return userLockout
  **/
  @Schema(description = "")
  public UserLockout getUserLockout() {
    return userLockout;
  }

  public void setUserLockout(UserLockout userLockout) {
    this.userLockout = userLockout;
  }

  public UpdateLoginPasswordPolicies enforceLoginPasswordChange(Boolean enforceLoginPasswordChange) {
    this.enforceLoginPasswordChange = enforceLoginPasswordChange;
    return this;
  }

   /**
   * Determines whether a login password change should be enforced for all users  Only takes effect, if login password policies get stricter
   * @return enforceLoginPasswordChange
  **/
  @Schema(description = "Determines whether a login password change should be enforced for all users  Only takes effect, if login password policies get stricter")
  public Boolean isEnforceLoginPasswordChange() {
    return enforceLoginPasswordChange;
  }

  public void setEnforceLoginPasswordChange(Boolean enforceLoginPasswordChange) {
    this.enforceLoginPasswordChange = enforceLoginPasswordChange;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateLoginPasswordPolicies updateLoginPasswordPolicies = (UpdateLoginPasswordPolicies) o;
    return Objects.equals(this.characterRules, updateLoginPasswordPolicies.characterRules) &&
        Objects.equals(this.minLength, updateLoginPasswordPolicies.minLength) &&
        Objects.equals(this.rejectDictionaryWords, updateLoginPasswordPolicies.rejectDictionaryWords) &&
        Objects.equals(this.rejectUserInfo, updateLoginPasswordPolicies.rejectUserInfo) &&
        Objects.equals(this.rejectKeyboardPatterns, updateLoginPasswordPolicies.rejectKeyboardPatterns) &&
        Objects.equals(this.numberOfArchivedPasswords, updateLoginPasswordPolicies.numberOfArchivedPasswords) &&
        Objects.equals(this.passwordExpiration, updateLoginPasswordPolicies.passwordExpiration) &&
        Objects.equals(this.userLockout, updateLoginPasswordPolicies.userLockout) &&
        Objects.equals(this.enforceLoginPasswordChange, updateLoginPasswordPolicies.enforceLoginPasswordChange);
  }

  @Override
  public int hashCode() {
    return Objects.hash(characterRules, minLength, rejectDictionaryWords, rejectUserInfo, rejectKeyboardPatterns, numberOfArchivedPasswords, passwordExpiration, userLockout, enforceLoginPasswordChange);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateLoginPasswordPolicies {\n");
    
    sb.append("    characterRules: ").append(toIndentedString(characterRules)).append("\n");
    sb.append("    minLength: ").append(toIndentedString(minLength)).append("\n");
    sb.append("    rejectDictionaryWords: ").append(toIndentedString(rejectDictionaryWords)).append("\n");
    sb.append("    rejectUserInfo: ").append(toIndentedString(rejectUserInfo)).append("\n");
    sb.append("    rejectKeyboardPatterns: ").append(toIndentedString(rejectKeyboardPatterns)).append("\n");
    sb.append("    numberOfArchivedPasswords: ").append(toIndentedString(numberOfArchivedPasswords)).append("\n");
    sb.append("    passwordExpiration: ").append(toIndentedString(passwordExpiration)).append("\n");
    sb.append("    userLockout: ").append(toIndentedString(userLockout)).append("\n");
    sb.append("    enforceLoginPasswordChange: ").append(toIndentedString(enforceLoginPasswordChange)).append("\n");
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
