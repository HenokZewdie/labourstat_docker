package generated.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EmployeeInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-01T15:30:15.924-04:00")

public class EmployeeInfo   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("employee_age")
  private String employeeAge = null;

  @JsonProperty("employee_name")
  private String employeeName = null;

  @JsonProperty("employee_salary")
  private String employeeSalary = null;

  @JsonProperty("profile_image")
  private String profileImage = null;

  public EmployeeInfo id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "1", value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public EmployeeInfo employeeAge(String employeeAge) {
    this.employeeAge = employeeAge;
    return this;
  }

   /**
   * Get employeeAge
   * @return employeeAge
  **/
  @ApiModelProperty(example = "6", value = "")


  public String getEmployeeAge() {
    return employeeAge;
  }

  public void setEmployeeAge(String employeeAge) {
    this.employeeAge = employeeAge;
  }

  public EmployeeInfo employeeName(String employeeName) {
    this.employeeName = employeeName;
    return this;
  }

   /**
   * Get employeeName
   * @return employeeName
  **/
  @ApiModelProperty(example = "Mena", value = "")


  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public EmployeeInfo employeeSalary(String employeeSalary) {
    this.employeeSalary = employeeSalary;
    return this;
  }

   /**
   * Get employeeSalary
   * @return employeeSalary
  **/
  @ApiModelProperty(example = "789000", value = "")


  public String getEmployeeSalary() {
    return employeeSalary;
  }

  public void setEmployeeSalary(String employeeSalary) {
    this.employeeSalary = employeeSalary;
  }

  public EmployeeInfo profileImage(String profileImage) {
    this.profileImage = profileImage;
    return this;
  }

   /**
   * Get profileImage
   * @return profileImage
  **/
  @ApiModelProperty(example = "path", value = "")


  public String getProfileImage() {
    return profileImage;
  }

  public void setProfileImage(String profileImage) {
    this.profileImage = profileImage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmployeeInfo employeeInfo = (EmployeeInfo) o;
    return Objects.equals(this.id, employeeInfo.id) &&
        Objects.equals(this.employeeAge, employeeInfo.employeeAge) &&
        Objects.equals(this.employeeName, employeeInfo.employeeName) &&
        Objects.equals(this.employeeSalary, employeeInfo.employeeSalary) &&
        Objects.equals(this.profileImage, employeeInfo.profileImage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, employeeAge, employeeName, employeeSalary, profileImage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmployeeInfo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    employeeAge: ").append(toIndentedString(employeeAge)).append("\n");
    sb.append("    employeeName: ").append(toIndentedString(employeeName)).append("\n");
    sb.append("    employeeSalary: ").append(toIndentedString(employeeSalary)).append("\n");
    sb.append("    profileImage: ").append(toIndentedString(profileImage)).append("\n");
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

