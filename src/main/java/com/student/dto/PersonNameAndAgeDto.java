package com.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonNameAndAgeDto {
    private String firstName;
    private Integer age;
    private Long count;
}
