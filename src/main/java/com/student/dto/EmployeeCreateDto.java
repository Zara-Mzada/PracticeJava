package com.student.dto;

import lombok.Data;

@Data
public class EmployeeCreateDto {
    String firstName;
    String lastName;
    Integer age;
    Long departmentId;
}
