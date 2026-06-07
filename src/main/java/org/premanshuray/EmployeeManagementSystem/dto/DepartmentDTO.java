package org.premanshuray.EmployeeManagementSystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    private Long id;

    @NotEmpty(message = "Department name must not be empty")
    @NotBlank(message = "Department name must not be blank")
    @NotNull(message = "Department name must not be null")
    @Length(min = 3, max = 50, message = "Department name must be between 3 and 50 characters")
    private String name;

    @NotNull(message = "Department active must not be null")
    @JsonProperty("active")
    private boolean isActive;

    @PastOrPresent(message = "Timestamp must be in the past or present")
    private LocalDateTime timeStamp;


}
