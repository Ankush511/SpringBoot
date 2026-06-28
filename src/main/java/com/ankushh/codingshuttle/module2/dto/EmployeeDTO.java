package com.ankushh.codingshuttle.module2.dto;


import com.ankushh.codingshuttle.module2.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Name cannot be blank for the Employee")
    @Size(min = 3, max = 15, message = "Number of characters should be in the range: [3, 15]")
    private String name;

    @NotBlank(message = "Email of the Employee cannot be blank")
    @Email(message = "Email should be a valid email")
    private String email;

    @NotNull(message = "Age cannot be blank for the Employee")
    @Max(value = 80, message = "Age cannot be greater than 80")
    @Min(value = 18, message = "Age should be greater than 18")
    private Integer age;

    @NotBlank(message = "Role of Employee cannot be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$", message = "The role of employee can be USER or ADMIN only")
    @EmployeeRoleValidation
    private String role; // ADMIN, USER

    @PastOrPresent(message = "Date of Joining of the Employee cannot be in future")
    private LocalDate dateOfJoining;

    @NotNull(message = "Salary of employee cannot be Null")
    @Positive(message = "Salary of Employee should be in positive numbers")
    @Digits(integer = 6, fraction = 2, message = "The salary can be in the form XXXX.XX")
    private Double salary;

    @JsonProperty("isActive")
    private Boolean isActive;

}
