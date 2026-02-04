package com.student.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateDTO {
    @NotBlank(message = "First name is null")
    @Pattern(regexp = "^[A-Za-zƏəÖöĞğŞşÇçİıÜü]{2,30}$",
            message = "First name format is invalid")
    private String firstName;

    @NotBlank(message = "Last name is null")
    @Pattern(regexp = "^[A-Za-zƏəÖöĞğŞşÇçİıÜü]{2,30}$",
            message = "Last name format is invalid")
    private String lastName;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Student must be at least 18")
    private Integer age;
}
