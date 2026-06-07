package org.premanshuray.EmployeeManagementSystem.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.premanshuray.EmployeeManagementSystem.annotaions.EmployeeRoleValidation;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message= "Name cannot be empty")
    @NotBlank(message = "Name cannot be blank")
    @Size(min=3 , max = 50 , message = "Name should be between 3 and 50 characters")
    private String name;

    @Max(value = 80 , message = "Age should not be greater than 80")
    @Min(value = 18 , message = "Age should not be less than 18")
    private Integer age;

    @NotEmpty(message= "Email cannot be empty")
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Invalid email format"
    )
    private String email;

    @NotEmpty(message= "Role cannot be empty")
    @NotBlank(message = "Role cannot be blank")
//    @Pattern(regexp = "^(USER|ADMIN)$", message = "Role must be one of the following: USER or ADMIN")
    @EmployeeRoleValidation
    private String role;

    @Positive(message = "Salary should be a positive number")
    @Digits(integer = 6, fraction = 2, message = "Salary should be a valid number with up to 10 digits and 2 decimal places")
    private Double salary;

    @PastOrPresent(message = "Date of Joining should be in the past or present")
    private java.time.LocalDate dateOfJoining;

    private boolean isActive;
}